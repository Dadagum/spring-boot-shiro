package com.dadagum.mapper;

import com.dadagum.bean.User;

import java.util.List;

public interface UserMapper {

    /**
     * get all users info
     * @return
     */
    public List<User> getUsers();

    /**
     * get userinfo by username
     * @param username
     * @return
     */
    public User getUser(String username);

    /** @TODO
     * add a user
     * @param user
     */
    public void addUser(User user);
}
