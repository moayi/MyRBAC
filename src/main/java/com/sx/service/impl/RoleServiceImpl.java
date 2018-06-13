package com.sx.service.impl;

import com.sx.mapper.RoleMapper;
import com.sx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * moayi
 *
 * @create 2018-06-11 14:25
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<String> findRoleByUserId(String userId) {
        List<String> roles = roleMapper.findRoleByUserId(userId);
        return roles;
    }
}