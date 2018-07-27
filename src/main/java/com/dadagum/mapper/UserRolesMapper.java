package com.dadagum.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface UserRolesMapper {

    public void assignRole(@Param("username") String username, @Param("role") String role);

    public Set<String> getUserRoles(String username);
}
