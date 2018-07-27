package com.dadagum.service.impl;

import com.dadagum.bean.User;
import com.dadagum.mapper.RolePermMapper;
import com.dadagum.mapper.UserMapper;
import com.dadagum.mapper.UserRolesMapper;
import com.dadagum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Autowired
    private RolePermMapper rolePermMapper;

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

    @Override
    public Set<String> getUserRoles(String username) {
        return userRolesMapper.getUserRoles(username);
    }

    @Override
    public Set<String> getUserPerms(String username) {
        return rolePermMapper.getUserPerms(username);
    }


}
