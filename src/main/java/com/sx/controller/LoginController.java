package com.sx.controller;

import com.sx.entity.Permission;
import com.sx.entity.User;
import com.sx.service.PermissionServcie;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    /**
     * 登陆认证处理
     * @return
     */
    @RequestMapping("/login/doLogin")
    public  void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String errorClassName = (String)req.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equals(errorClassName)) {
            req.setAttribute("error", "用户名/密码错误");
        } else if(IncorrectCredentialsException.class.getName().equals(errorClassName)) {
            req.setAttribute("error", "用户名/密码错误");
        } else if(ExcessiveAttemptsException.class.getName().equals(errorClassName)){
            req.setAttribute("error", errorClassName.toString());
        }else if(errorClassName != null) {
            req.setAttribute("error", "未知错误：" + errorClassName);
        }
        req.getRequestDispatcher("/jsp/login/login.jsp").forward(req, resp);
    }
    /**
     * 登陆成功处理
     * @param session
     * @return
     */
    @RequestMapping("/index")
    public  String homePage(HttpSession session){
        User user=new User();
        user.setId("1");
        List<Permission> permissions = permissionServcie.queryPermissionsByUser(user);
        session.setAttribute("menu",permissions);
        return "redirect:/jsp/main.jsp";
    }
}