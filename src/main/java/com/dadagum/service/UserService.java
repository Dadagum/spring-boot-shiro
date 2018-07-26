package com.dadagum.service;

import com.dadagum.bean.User;

public interface UserService {

    public void addUser(User user);

    public String getUserPasswd(String username);

    public String getUserSalt(String username);

}
