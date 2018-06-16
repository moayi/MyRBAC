package com.sx.service.impl;

import com.sx.entity.User;
import com.sx.mapper.UserMapper;
import com.sx.service.UserService;
import com.sx.shiro.Encryption.PasswordHelper;
import com.sx.util.IdTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordHelper passwordHelper;
    @Override
    public void addUser(User user) throws Exception {
    if("".equals(user.getId())||user.getId()==null){
        user.setId(IdTool.getID());
    }
        passwordHelper.encryptPassword(user);
        userMapper.insert(user);
    }

    @Override
    public User findByUserName(String userName) {
        User user = userMapper.findByUserName(userName);
        return user;
    }
}
