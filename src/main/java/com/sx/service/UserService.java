package com.sx.service;

import com.sx.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    /**
     * 新增用户
     * @param user
     * @throws Exception
     */
    public  void addUser(User user) throws Exception;

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    public  User  findByUserName(String userName);
}
