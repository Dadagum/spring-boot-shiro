package com.dadagum.realm;

import com.dadagum.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        System.out.println("in ca : username = " + username);
        // get password from database
        String password = getUserPasswd(username);
        System.out.println("password " + password);
        // get salt from database
        String salt = getUserSalt(username);
        System.out.println("salt" + salt);
        return new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), getName());
    }

    public String getUserPasswd(String username){
        return userService.getUserPasswd(username);
    }

    public String getUserSalt(String username){
        return userService.getUserSalt(username);
    }
}
