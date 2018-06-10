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
}
