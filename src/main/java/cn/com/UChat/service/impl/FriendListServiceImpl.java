package cn.com.UChat.service.impl;

import cn.com.UChat.common.Constant;
import cn.com.UChat.common.ResponseEnum;
import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.repository.FriendListRepository;
import cn.com.UChat.service.FriendListService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;

// Friend list service implementation
@Slf4j
@Service
public class FriendListServiceImpl implements FriendListService {
    @Autowired
    FriendListRepository friendListRepository;

    // Define the method to list all friend info of a user
    @Override
    public ServerResponse listAllFriendInfo(Long userId) {
        try {
            // Retrieve a list of friends using the FriendListRepository
            List<Object[]> friends = friendListRepository.selectAllFriendByUserId(userId);
            // Create a new JSONArray to store friend information
            JSONArray friendInfoJsonArr = new JSONArray();
            // Loop through each friend in the list
            friends.forEach(row -> {
                // Create a new JSONObject to store information about the friend
                JSONObject friendInfo = new JSONObject();
                // Retrieve the friend's ID from the row data
                BigInteger id = (BigInteger) row[0];
                // Retrieve the friend's online status from the row data
                Boolean isOnline = (Boolean) row[2];
                // Retrieve the friend's username from the row data
                String userName = (String) row[5];
                // Add the friend's ID, online status, and username to the JSONObject
                friendInfo.put("id",id);
                friendInfo.put("isOnline",isOnline);
                friendInfo.put("userName",userName);
                // Add the JSONObject to the JSONArray
                friendInfoJsonArr.add(friendInfo);
            });
            return ServerResponse.getInstance().responseEnum(ResponseEnum.GET_SUCCESS).data(friendInfoJsonArr);
        }catch (Exception e){
            e.printStackTrace();
            log.info(Constant.TAG_YUKI + e.getMessage());
            return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
        }
    }

    // Define the method to list all unfriended users of a user
    @Override
    public ServerResponse listAllUnFriendInfo(Long userId) {
        try {
            // Retrieve a list of unfriended users using the FriendListRepository
            List<Object[]> users = friendListRepository.selectAllUnFriendByUserId(userId);
            // Create a new JSONArray to store unfriended user information
            JSONArray unfriendInfoJsonArr = new JSONArray();
            // Loop through each unfriended user in the list
            users.forEach(row -> {
                // Create a new JSONObject to store information about the unfriended user
                JSONObject friendInfo = new JSONObject();
                // Retrieve the unfriended user's ID from the row data
                BigInteger id = (BigInteger) row[0];
                // Retrieve the unfriended user's avatar from the row data
                String avatar = (String) row[1];
                // Retrieve the unfriended user's online status from the row data
                Boolean isOnline = (Boolean) row[2];
                // Retrieve the unfriended user's username from the row data
                String username = (String) row[4];
                // Add the unfriended user's ID, avatar, online status, and username to the JSONObject
                friendInfo.put("id",id);
                friendInfo.put("avatar",avatar);
                friendInfo.put("isOnline",isOnline);
                friendInfo.put("userName",username);
                // Add the JSONObject to the JSONArray
                unfriendInfoJsonArr.add(friendInfo);
            });
            return ServerResponse.getInstance().responseEnum(ResponseEnum.GET_SUCCESS).data(unfriendInfoJsonArr);
        }catch (Exception e){
            log.info(Constant.TAG_YUKI + e.getMessage());
            return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
        }
    }
}
