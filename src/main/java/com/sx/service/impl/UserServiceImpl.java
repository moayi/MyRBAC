package com.sx.service.impl;

import com.sx.entity.User;
import com.sx.mapper.UserMapper;
import com.sx.service.UserService;
import com.sx.util.IdTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void addUser(User user) throws Exception {
    if("".equals(user.getId())||user.getId()==null){
        user.setId(IdTool.getID());
    }
        userMapper.insert(user);
    }
}
