package com.dadagum.controller;

import com.dadagum.api.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
   public JsonResult<?> index(){
       return new JsonResult<>(null, "ok", 0);
   }

   @RequestMapping(value = "/authentication", method = RequestMethod.POST)
   public JsonResult<?> login(@RequestParam String username, @RequestParam String password){
       System.out.println(username);
       System.out.println(password);
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
        } catch (AuthenticationException e){
            return new JsonResult<>(null, "fail to login", 1);
        }
       return new JsonResult<>(null, "success", 0);
   }

}
