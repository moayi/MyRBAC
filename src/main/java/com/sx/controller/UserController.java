package com.sx.controller;

import com.sx.entity.User;
import com.sx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping ("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping ("/add")
    @ResponseBody
    public String addUser(User user ){
        try {
            userService.addUser(user);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "bad";
        }
    }
}
