package com.dadagum;

import com.dadagum.mapper.RolePermMapper;
import com.dadagum.mapper.UserRolesMapper;
import org.junit.Test;
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

    @Test
    public void assignRole(){
        String username = "root";
        String role = "root";
        userRolesMapper.assignRole(username, role);
    }

    @Test
    public void addRolePerm(){
        String role = "root";
        String perm = "all";
        rolePermMapper.addRolePerm(role, perm);
    }
}
