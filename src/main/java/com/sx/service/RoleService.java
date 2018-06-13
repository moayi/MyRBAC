package com.sx.service;

import java.util.List;

public interface RoleService {
    /**
     * 根据用户名查询哪些角色
     * @param userId
     * @return
     */
    public List<String> findRoleByUserId(String userId);
}
