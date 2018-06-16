package com.sx.mapper;

import com.sx.entity.User;
import org.apache.ibatis.annotations.Param;
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
     * @param userName
     * @return
     */
    public  User findByUserName(@Param("userName") String userName);
}
