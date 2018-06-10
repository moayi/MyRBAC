package com.sx.controller;

import com.sx.entity.Permission;
import com.sx.entity.User;
import com.sx.service.PermissionServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * moayi
 *
 * @create 2018-06-07 15:01
 **/
@Controller
public class LoginController {
    @Autowired
    private PermissionServcie permissionServcie;
    @RequestMapping("/index")
    public  String toIndex(HttpSession session){
        User user=new User();
        user.setId("1");
        List<Permission> permissions = permissionServcie.queryPermissionsByUser(user);
        session.setAttribute("menu",permissions);
        return "redirect:/jsp/main.jsp";
    }
}