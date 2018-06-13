package com.sx.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    /**
     * 根据用户名查询哪些角色
     * @param userId
     * @return
     */
    public List<String> findRoleByUserId(String userId);

}
