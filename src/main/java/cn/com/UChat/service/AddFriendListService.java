package cn.com.UChat.service;

import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.entity.AddFriendList;

// Add friend list service
public interface AddFriendListService {
    // Add friend request
    ServerResponse addFriendRequest(AddFriendList addFriendList);
    // Handle add friend request
    ServerResponse handleAddFriend(Long addFriendId, Integer isReceive);
    // List add friend request
    ServerResponse listAddFriendRequest(Long userId);
}
