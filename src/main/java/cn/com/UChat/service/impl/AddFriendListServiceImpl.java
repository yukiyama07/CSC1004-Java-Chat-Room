package cn.com.UChat.service.impl;

import cn.com.UChat.common.Constant;
import cn.com.UChat.common.ResponseEnum;
import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.entity.AddFriendList;
import cn.com.UChat.entity.FriendList;
import cn.com.UChat.entity.User;
import cn.com.UChat.repository.AddFriendListRepository;
import cn.com.UChat.repository.FriendListRepository;
import cn.com.UChat.repository.UserRepository;
import cn.com.UChat.service.AddFriendListService;
import cn.com.UChat.vo.AddFriendVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Add friend list service implementation
@Slf4j
@Service
public class AddFriendListServiceImpl implements AddFriendListService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AddFriendListRepository addFriendListRepository;

    @Autowired
    FriendListRepository friendListRepository;
    // Add friend request
    @Override
    public ServerResponse addFriendRequest(AddFriendList addFriendList) {
        // Get the sender and receiver user IDs from the input object
        long sendUserId = addFriendList.getSendUserId();
        long receiveUserId = addFriendList.getReceiveUserId();
        // Check if a friend request already exists between these two users
        if(null != addFriendListRepository.findBySendUserIdAndReceiveUserIdAndIsReceive(sendUserId, receiveUserId, 0)){
            return ServerResponse.getInstance().code(200).message("Please wait for the other user to agree");
        }
        // Set send time for the friend request
        addFriendList.setSendTime(new Date());
        try {
            // Save the friend request to the database
            addFriendListRepository.save(addFriendList);
            // Return a success response
            return ServerResponse.getInstance().code(200).message("Sent successfully");
        }catch (Exception e){
            e.printStackTrace();
            log.info(Constant.TAG_YUKI + e.getMessage());
            return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
        }
    }
    // Get friend requests for a given user
    @Override
    public ServerResponse handleAddFriend(Long addFriendId, Integer isReceive) {
        try {
            // Retrieve the friend request from the database using the given ID
            AddFriendList addFriendList = addFriendListRepository.findById(addFriendId).get();
            // If the friend request does not exist, return an error response
            if (null == addFriendList){
                return ServerResponse.getInstance().code(200).message("The friend request does not exist");
            }
            // Update the friend request's status to either accept or decline
            addFriendList.setIsReceive(isReceive);
            addFriendListRepository.save(addFriendList);
            // If the friend request was declined, return a response indicating the same
            if(isReceive==2){
                return ServerResponse.getInstance().responseEnum(ResponseEnum.ADD_SUCCESS_NO);
            }else{
                // Retrieve the sender and receiver user IDs from the friend request object
                Long sendUserId = addFriendList.getSendUserId();
                Long receiveUserId = addFriendList.getReceiveUserId();
                // Retrieve the User objects for the sender and receiver users
                User sendUser = userRepository.getOne(sendUserId);
                User receiveUser = userRepository.getOne(receiveUserId);
                // Create two new FriendList objects to represent the friendship between the two users
                List<FriendList> friendLists = new ArrayList<>();
                FriendList friendListSend = new FriendList();
                friendListSend.setUserId(sendUserId);
                friendListSend.setFriendUserId(receiveUserId);
                friendListSend.setFriendNickName(receiveUser.getUsername());
                friendLists.add(friendListSend);
                FriendList friendListReceive = new FriendList();
                friendListReceive.setUserId(receiveUserId);
                friendListReceive.setFriendUserId(sendUserId);
                friendListReceive.setFriendNickName(sendUser.getUsername());
                friendLists.add(friendListReceive);
                // Save the two FriendList objects to the database
                friendListRepository.saveAll(friendLists);
                return ServerResponse.getInstance().responseEnum(ResponseEnum.ADD_SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
            log.info(Constant.TAG_YUKI + e.getMessage());
            return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
        }
    }

    // List add friend request
    @Override
    public ServerResponse listAddFriendRequest(Long userId) {
        try{
            // Retrieve all friend requests sent to the given user ID
            List<Object[]> addFriendLists = addFriendListRepository.selectByReceiveUserIdAndIsReceiveOrderBySendTimeDesc(userId);
            List<AddFriendVo> addFriendVos = new ArrayList<>();
            addFriendLists.forEach(row -> {
                // Create a new AddFriendVo object to store the friend request information
                AddFriendVo addFriendVo = new AddFriendVo();
                // Retrieve the sender's username, message, send time, and ID from the database
                String username = (String)row[0];
                String message = (String)row[2];
                Date send_time = (Date)row[4];
                BigInteger id = (BigInteger)row[5];
                // Set the AddFriendVo object's fields
                addFriendVo.setUsername(username);
                addFriendVo.setMessage(message);
                addFriendVo.setSendTime(send_time);
                addFriendVo.setId(id.intValue());
                addFriendVos.add(addFriendVo);
            });
            return ServerResponse.getInstance().responseEnum(ResponseEnum.GET_SUCCESS).data(addFriendVos);
        }catch (Exception e){
            e.printStackTrace();
            log.info(Constant.TAG_YUKI + e.getMessage());
            return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
        }
    }
}
