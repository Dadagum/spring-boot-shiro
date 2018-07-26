package com.dadagum.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermMapper {

    public void addRolePerm(@Param("role") String role, @Param("perm") String perm);

    public List<String> getUserPerms(String username);
}
