package com.dadagum.service;

import com.dadagum.bean.User;

import java.util.Set;

public interface UserService {

    public void addUser(User user);

    public String getUserPasswd(String username);

    public String getUserSalt(String username);

    public Set<String> getUserRoles(String username);

    public Set<String> getUserPerms(String username);

}
