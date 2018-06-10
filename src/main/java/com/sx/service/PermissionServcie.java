package com.sx.service;

import com.sx.entity.Permission;
import com.sx.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface PermissionServcie {
    /**
     *
     * @param user
     * @return
     */
    List <Permission> queryPermissionsByUser(User user);
}
