package cn.com.UChat.service;

import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.entity.MessageList;

// Message list service
public interface MessageListService {
    // Get history message
    ServerResponse getEightMessage(Long sendUserId, Long receiveUserId);

    // Save message
    void saveMessage(MessageList messageList);
}
