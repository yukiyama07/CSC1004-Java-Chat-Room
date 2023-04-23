package cn.com.UChat.controller;

import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.entity.User;
import cn.com.UChat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// User controller
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService userService;

    // User registration
    @RequestMapping(value = "register", method = RequestMethod.POST)
    ServerResponse userRegister(@RequestBody User user){
        return userService.userRegister(user);
    }

    // User login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    ServerResponse userLogin(@RequestBody User user){
        return userService.userLogin(user);
    }
}
