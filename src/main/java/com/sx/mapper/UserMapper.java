package com.sx.mapper;

import com.sx.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     */
    public  void insert(User user);

    /**
     *
     * 通过用户名查询用户
     * @param username
     * @return
     */
    public  User findByUserName(String username);
}
