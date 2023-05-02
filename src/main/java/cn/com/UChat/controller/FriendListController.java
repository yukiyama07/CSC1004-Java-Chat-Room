package cn.com.UChat.controller;

import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.service.FriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Friend list controller
@RestController
@RequestMapping(value = "friend")
public class FriendListController {
    @Autowired
    FriendListService friendListService;

    // Get friend list
    @RequestMapping(value = "/list/{userId}", method = RequestMethod.GET)
    ServerResponse listAllFriend(@PathVariable Long userId){
        return friendListService.listAllFriendInfo(userId);
    }

    // Get un-friend list
    @RequestMapping(value = "/list/un/{userId}", method = RequestMethod.GET)
    ServerResponse listAllUnFriend(@PathVariable Long userId){
        return friendListService.listAllUnFriendInfo(userId);
    }

}
