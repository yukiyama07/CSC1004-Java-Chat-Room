package cn.com.UChat.service;

import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.entity.User;

// User service
public interface UserService {
    // User registration
    ServerResponse userRegister(User user);

    // User login
    ServerResponse userLogin(User user);
}
