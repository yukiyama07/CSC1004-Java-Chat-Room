package cn.com.UChat.service.impl;

import cn.com.UChat.common.Constant;
import cn.com.UChat.common.ResponseEnum;
import cn.com.UChat.common.ServerResponse;
import cn.com.UChat.entity.User;
import cn.com.UChat.repository.UserRepository;
import cn.com.UChat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

// User service implementation
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    // User registration
    @Override
    public ServerResponse userRegister(User user) {
        try {
            // Check if the username and password are empty
            if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
                return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
            }
            // Check if the username already exists
            User cUser = userRepository.findByUsername(user.getUsername());
            if (cUser != null) {
                // Username already exists
                return ServerResponse.getInstance().responseEnum(ResponseEnum.USERNAME_EXSIT);
            }
            // Save user information
            userRepository.save(user);
            return ServerResponse.getInstance().responseEnum(ResponseEnum.REGISTE_SUCCESS);
        }catch (Exception e) {
            log.info(Constant.TAG_YUKI + e.getMessage());
            return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
        }
    }

    // User login
    @Override
    public ServerResponse userLogin(User user) {
        try {
            // Check if the username and password are empty
            if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
                return ServerResponse.getInstance().responseEnum(ResponseEnum.INVALID_PARAM);
            }
            // Check if the username and password are correct
            User cUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if(cUser == null){
                return ServerResponse.getInstance().responseEnum(ResponseEnum.LOGIN_FAILED);
            }
            // Set the user to online
            cUser.setIsOnline(true);
            // Save user information
            userRepository.save(cUser);
            return ServerResponse.getInstance().responseEnum(ResponseEnum.LOGIN_SUCCESS).data(cUser);
        }catch (Exception e) {
            log.info(Constant.TAG_YUKI + e.getMessage());
            return ServerResponse.getInstance().responseEnum(ResponseEnum.INNER_ERROR);
        }
    }
}
