package com.dadagum.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRolesMapper {

    public void assignRole(@Param("username") String username, @Param("role") String role);

    public List<String> getUserRoles(String username);
}
