package com.sx.service;

import com.sx.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public  void addUser(User user) throws Exception;
}
