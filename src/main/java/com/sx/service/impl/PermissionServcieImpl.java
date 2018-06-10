package com.sx.service.impl;

import com.sx.entity.Permission;
import com.sx.entity.User;
import com.sx.mapper.PermissionMapper;
import com.sx.service.PermissionServcie;
import com.sx.util.MenuTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * moayi
 *
 * @create 2018-06-07 9:03
 **/
@Service
public class PermissionServcieImpl implements PermissionServcie {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List <Permission> queryPermissionsByUser(User user) {
        List<Permission> permissions = permissionMapper.queryPermissionsByUser(user);
        List<Permission> menuList = new ArrayList<Permission>();
        for (Permission parent:permissions) {
            if("0".equals(parent.getPid())){//先查找所有的
                menuList.add(parent);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (Permission menu : menuList) {
            menu.setChildren(MenuTools.getChild(menu.getId(), permissions));
        }
        return menuList;
    }
}