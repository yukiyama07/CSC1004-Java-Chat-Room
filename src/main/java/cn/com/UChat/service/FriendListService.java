package cn.com.UChat.service;

import cn.com.UChat.common.ServerResponse;

// Friend list service
public interface FriendListService {
    // list all friend info
    ServerResponse listAllFriendInfo(Long userId);
    // list all un-friend info
    ServerResponse listAllUnFriendInfo(Long userId);

}
