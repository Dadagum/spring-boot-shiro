package com.dadagum.mapper;

import com.dadagum.bean.User;

import java.util.List;

public interface UserMapper {

    /**
     * get all users info
     * @return
     */
    public List<User> getUsers();
}
