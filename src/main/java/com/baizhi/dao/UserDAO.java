package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDAO extends BaseDAO<User> {
    //根据用户名和密码查询
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    //根据用户名查询
    User findByUsername(@Param("username") String username);
}
