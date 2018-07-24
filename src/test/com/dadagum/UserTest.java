package com.dadagum;

import com.dadagum.bean.User;
import com.dadagum.mapper.UserMapper;
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
    private UserMapper mapper;

    @Test
    public void getUsers(){
        List<User> list = mapper.getUsers();
        System.out.println(list.size());
    }

    @Test
    public void getUser(){
        System.out.println(mapper.getUser("zhang") == null);
    }

}
