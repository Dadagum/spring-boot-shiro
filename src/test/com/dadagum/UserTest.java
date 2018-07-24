package com.dadagum;

import com.dadagum.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void getUsers(){
        System.out.println(mapper.getUsers());
    }
}
