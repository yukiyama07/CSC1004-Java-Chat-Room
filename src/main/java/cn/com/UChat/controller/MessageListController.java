package cn.com.UChat.controller;

import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.service.MessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Message list controller
@RestController
@RequestMapping(value = "message")
public class MessageListController {
    @Autowired
    MessageListService messageListService;

    // Get history message
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    ServerResponse getEightMessage(@RequestParam("sid") Long sid, @RequestParam("rid") Long rid){
        return messageListService.getEightMessage(sid, rid);
    }
}
