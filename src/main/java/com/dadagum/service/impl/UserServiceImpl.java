package com.dadagum.service.impl;

import com.dadagum.bean.User;
import com.dadagum.mapper.UserMapper;
import com.dadagum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        // generate salt

    }

    @Override
    public String getUserPasswd(String username) {
        return userMapper.getUserPasswd(username);
    }

    @Override
    public String getUserSalt(String username) {
        return userMapper.getUserSalt(username);
    }


}
