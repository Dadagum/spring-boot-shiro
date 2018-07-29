package com.dadagum.shiro.matcher;

import com.dadagum.util.RedisUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher{

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        String username = (String) token.getPrincipal();
        // get cache
        AtomicInteger cnt = (AtomicInteger) redisUtil.getValue(username);
        System.out.println("in matcher : ");
        if (cnt == null) {
            cnt = new AtomicInteger(0);
            redisUtil.setValue(username, cnt, 10);
        }
        if (cnt.incrementAndGet() > 2) throw new ExcessiveAttemptsException("stop trying!");

        boolean matches = super.doCredentialsMatch(token, info);
        // login successfully
        if (matches) redisUtil.setValue(username, null);
        else redisUtil.setValue(username, cnt);
        return matches;
    }
}
