package com.dadagum.controller;

import com.dadagum.api.JsonResult;
import com.dadagum.bean.User;
import com.dadagum.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
   public JsonResult<?> index(){
       return new JsonResult<>(null, "ok", 0);
   }

   @RequestMapping(value = "/registration", method = RequestMethod.POST)
   public JsonResult<?> register(User user, @RequestParam("rPasswd") String rPasswd){
        if (user.getUsername() == null) return new JsonResult<>(null, "username can not be empty", 1);
        if (user.getPassword() == null) return new JsonResult<>(null, "password can not be empty", 1);
        if (!user.getPassword().equals(rPasswd)) return new JsonResult<>(null, "password does not match twice", 1);
        return null;
   }

   @RequestMapping(value = "/authentication", method = RequestMethod.POST)
   public JsonResult<?> login(@RequestParam String username, @RequestParam String password){
       System.out.println(username);
       System.out.println(password);
       Subject subject = SecurityUtils.getSubject();
       UsernamePasswordToken token = new UsernamePasswordToken(username, password);
       try {
           subject.login(token);
           System.out.println("login successfully");
       }catch (Exception e){
           e.printStackTrace();
           return new JsonResult<>(null, e.getMessage(), 1);
       }
       return new JsonResult<>(null, "success", 0);
   }

    @RequestMapping(value = "/iniAuth", method = RequestMethod.POST)
   public JsonResult<?> iniAuth(@RequestParam String username, @RequestParam String password){
       System.out.println(username);
       System.out.println(password);

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            // check if has role1
            if (subject.hasRole("role1")) System.out.println("get role1 !");
            else System.out.println("do not get role1");

            // check if has user:update
            if (subject.isPermitted("user:update")) System.out.println("get user:update perm");
            else System.out.println("do not get user:update");
        } catch (AuthenticationException e){
            e.printStackTrace();
            return new JsonResult<>(null, "fail to login", 1);
        }
       return new JsonResult<>(null, "success", 0);
   }

   @RequestMapping(value = "/test", method = RequestMethod.POST)
   public JsonResult<?> getPasswd(@RequestParam String username){
        String passwd = userService.getUserPasswd(username);
        return new JsonResult<>(passwd, "ok", 0);
   }

}
