package com.dadagum;

import com.dadagum.mapper.RolePermMapper;
import com.dadagum.mapper.UserRolesMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class RolePermTest {

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Autowired
    private RolePermMapper rolePermMapper;

    public void assignRole(){
        String username = "admin";
        String role = "role1";
        userRolesMapper.assignRole(username, role);
    }

    public void addRolePerm(){
        String role = "role2";
        String perm = "user:delete";
        rolePermMapper.addRolePerm(role, perm);
    }
}
