package com.dadagum.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RolePermMapper {

    public void addRolePerm(@Param("role") String role, @Param("perm") String perm);

    public Set<String> getUserPerms(String username);
}
