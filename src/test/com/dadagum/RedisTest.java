package com.dadagum;

import com.dadagum.bean.User;
import com.dadagum.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-redis.xml")
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testConnection(){
        redisUtil.setValue("hello", "world");
        System.out.println(redisUtil.getValue("hello"));
    }

    @Test
    public void testIntegerNull(){
        AtomicInteger i = (AtomicInteger) redisUtil.getValue("tst");
        if (i == null) System.out.println("null");
    }

    @Test
    public void testSeri(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setSalt("teset");
        redisUtil.setValue("test", user);
        System.out.println(redisUtil.getValue("test"));
    }

    @Test
    public void testGetCache(){

    }
}
