package com.sx.mapper;

import com.sx.entity.Permission;
import com.sx.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {
    /**
     * 根据用户查询权限
     * @return
     */
    List<Permission> queryPermissionsByUser(User user);
}
