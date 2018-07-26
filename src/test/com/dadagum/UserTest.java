package com.dadagum;

import com.dadagum.bean.User;
import com.dadagum.mapper.RolePermMapper;
import com.dadagum.mapper.UserMapper;
import com.dadagum.mapper.UserRolesMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RolePermMapper rolePermMapper;

    @Autowired
   private UserRolesMapper userRolesMapper;


    @Test
    public void addUser(){
        String username = "admin3";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String password = new SimpleHash("md5", "admin3", salt,1).toString();
        User user = new User(username, password, salt);
        System.out.println(user);
        userMapper.addUser(user);
    }

    @Test
    public void getUsers(){
        List<User> list = userMapper.getUsers();
        System.out.println(list.size());
    }

    @Test
    public void getUser(){
        System.out.println(userMapper.getUser("zhang") == null);
    }

    @Test
    public void getUserRoles(){
        System.out.println(userRolesMapper.getUserRoles("test"));
    }

    @Test
    public void getUserPerms(){
        System.out.println(rolePermMapper.getUserPerms("test"));
    }

    @Test
    public void getUserpasswd(){
        System.out.println(userMapper.getUserPasswd("admin"));
    }

    @Test
    public void getUserSalt(){
        System.out.println(userMapper.getUserSalt("test"));
    }
}
