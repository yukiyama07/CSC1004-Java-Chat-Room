package cn.com.UChat.server;

import cn.com.UChat.entity.MessageList;
import cn.com.UChat.service.MessageListService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

// WebSocket Server
@Slf4j
@Component
@ServerEndpoint("/imserver/{userId}")
public class WebSocketServer {

    @Autowired
    private MessageListService messageListService;
    // Declare a static WebSocketServer object and initialize it to null
    public static WebSocketServer webSocketServer;
    // Define the init() method
    @PostConstruct
    public void init(){
        // Set the webSocketServer object to this object
        webSocketServer = this;
        // Set the messageListService object of the webSocketServer object to the messageListService object of this object
        webSocketServer.messageListService = this.messageListService;
    }

    // Define the onlineCount and webSocketMap variables
    private static int onlineCount = 0;
    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    // Define the session, userId variables
    private Session session;
    // userId received
    private String userId="";

    // The method called when the connection is successfully established
    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String userId) {
        // Set the session and userId variables to the session and userId received
        this.session = session;
        this.userId=userId;
        // If the webSocketMap already contains the userId, remove it and add the current object to it
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            // add to the set
            webSocketMap.put(userId,this);
        }else{
            // Otherwise, add the current object to the webSocketMap and increase the online count by 1
            webSocketMap.put(userId,this);
            addOnlineCount();
        }

        log.info("User connected,  Id: "+userId+", the number of people currently online is:" + getOnlineCount());

        try {
            sendMessage("Connection successful");
        } catch (IOException e) {
            log.error("User Id :"+userId+", Network exception!");
        }
    }

    // The method called when the connection is closed
    @OnClose
    public void onClose() {
        // If the webSocketMap contains the userId, remove it and decrease the online count by 1
        if(webSocketMap.containsKey(userId)){
            // remove from the set
            webSocketMap.remove(userId);
            // decrease the online count by 1
            subOnlineCount();
        }
        log.info("User exit Id:"+userId+", the number of people currently online is:" + getOnlineCount());
    }

    // The method called when a message is received from a client
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("User Id :"+userId+", message:"+message);
        // If the message is not empty, call the sendMessageTo() method to send the message to the specified user or call the sendMessageAll() method to send the message to all users
        if(!StringUtils.isEmpty(message)){
            try {
                // Parse the message
                JSONObject jsonObject = JSON.parseObject(message);
                // Append the sender
                jsonObject.put("fromUserId",this.userId);
                // Decide whether to send to all users or a single user
                String toUserId = jsonObject.getString("toUserId");
                if(!StringUtils.isEmpty(toUserId)&&toUserId.equals("0")){
                    sendMessageAll(jsonObject.toJSONString());
                }else{
                    sendMessageTo(jsonObject.toJSONString(),toUserId);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // The method called when an error occurs
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("User error id:"+this.userId+", reason is :"+error.getMessage());
        error.printStackTrace();
    }

    // Implement active sever push
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    // Send a message to a specified user
    public void sendMessageTo(String message,@PathParam("userId") String userId) throws IOException {
        // Parse the message
        // Parse the message string into a JSON object
        JSONObject jsonObject = JSON.parseObject(message);
        // get the toUserId from the JSON object
        String toUserId = jsonObject.getString("toUserId");
        // create a new MessageList instance
        MessageList messageList = new MessageList();
        // set the sendUserId of the MessageList to the current userId
        messageList.setSendUserId(Long.parseLong(this.userId));
        // set the receiveUserId of the MessageList to the toUserId from the JSON object
        messageList.setReceiveUserId(Long.parseLong(toUserId));
        // set the content of the MessageList to the message from the JSON object
        messageList.setContent(jsonObject.getString("message"));
        // set the sendTime of the MessageList to the current time
        messageList.setSendTime(new Date());
        // save the MessageList to the database
        webSocketServer.messageListService.saveMessage(messageList);
        // If the webSocketMap contains the toUserId, send the message to the toUserId
        if(!StringUtils.isEmpty(toUserId)&&webSocketMap.containsKey(toUserId)){
            webSocketMap.get(toUserId).sendMessage(message);
        }else{
            log.error("Requested userId:"+toUserId+"not on the server");
        }
    }

    // Send a message to all users
    public void sendMessageAll(String message) throws IOException {
        // Parse the message string into a JSON object
        JSONObject jsonObject = JSON.parseObject(message);
        // Loop through the webSocketMap
        for (WebSocketServer item : webSocketMap.values()) {
            // Get the userId of the current item
            String toUserId = item.userId;
            // If the userId of the current item is the same as the userId of the sender, skip the current item
            if (toUserId.equals(jsonObject.getString("fromUserId"))) {
                continue;
            }
            // create a new MessageList instance
            MessageList messageList = new MessageList();
            // set the sendUserId of the MessageList to the current userId
            messageList.setSendUserId(Long.parseLong(this.userId));
            // set the receiveUserId of the MessageList to the toUserId from the JSON object
            messageList.setReceiveUserId(Long.parseLong(toUserId));
            // set the content of the MessageList to the message from the JSON object
            messageList.setContent(jsonObject.getString("message"));
            // set the sendTime of the MessageList to the current time
            messageList.setSendTime(new Date());
            // save the MessageList to the database
            webSocketServer.messageListService.saveMessage(messageList);
            // If the webSocketMap contains the toUserId, send the message to the toUserId
            if(!StringUtils.isEmpty(toUserId)&&webSocketMap.containsKey(toUserId)){
                webSocketMap.get(toUserId).sendMessage( message);
            }else{
                log.error("Requested userId:"+toUserId+"not on the server");
            }
        }
    }

    // The method gets the number of online users
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    // The method increases the number of online users
    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    // The method decreases the number of online users
    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
