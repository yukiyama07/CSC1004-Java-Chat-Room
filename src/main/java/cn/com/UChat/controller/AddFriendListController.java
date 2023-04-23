package cn.com.UChat.controller;

import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.entity.AddFriendList;
import cn.com.UChat.service.AddFriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Add friend list controller
@RestController
@RequestMapping("friend")
public class AddFriendListController {
    @Autowired
    AddFriendListService addFriendListService;

    // Add friend
    @RequestMapping(value = "add", method = RequestMethod.POST)
    ServerResponse addFriend(@RequestBody AddFriendList addFriendList){
        return addFriendListService.addFriendRequest(addFriendList);
    }

    // Get add friend list
    @RequestMapping(value = "add/list/{userId}", method = RequestMethod.GET)
    ServerResponse listFriend(@PathVariable Long userId){
        return addFriendListService.listAddFriendRequest(userId);
    }

    // Handle add friend request
    @RequestMapping(value = "add/list/handle", method = RequestMethod.POST)
    ServerResponse handleFriend(@RequestParam Long addFriendId, @RequestParam Integer isReceive){
        return addFriendListService.handleAddFriend(addFriendId, isReceive);
    }
}
