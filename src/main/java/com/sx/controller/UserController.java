package com.sx.controller;

import com.sx.entity.User;
import com.sx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/add")
    @ResponseBody
    public String addUser(){
        User u=new User();
       // u.setUsername("moayi");
        //u.setPassword("liu123");
        u.setEmail("1101132623@qq.com");
        try {
            userService.addUser(u);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "bad";
        }
    }
}
