package com.dadagum;

import com.dadagum.util.RedisUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedisTest {

    @Test
    public void testConnection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        RedisUtil redisUtil = (RedisUtil) context.getBean("redisUtil");
        redisUtil.setValue("hello", "world");
        System.out.println(redisUtil.getValue("hello"));
    }
}
