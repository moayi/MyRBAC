package com.sx.util;

import com.sx.entity.Permission;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * moayi
 *
 * @create 2018-06-07 11:11
 **/
public class MenuTools {
    public static List<Permission> getChild(String id, List<Permission> rootMenu) {
        // 子菜单
        List<Permission> childList = new ArrayList<>();
        for (Permission menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(menu.getPid())) {
                if (menu.getPid().equals(id)) {
                    childList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (Permission menu : childList) {// 没有url子菜单还有子菜单
            if (StringUtils.isBlank(menu.getUrl())) {
                // 递归
                menu.setChildren(getChild(menu.getId(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}