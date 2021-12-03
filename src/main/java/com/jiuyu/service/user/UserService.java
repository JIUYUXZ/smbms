package com.jiuyu.service.user;

import com.jiuyu.pojo.User;

import java.sql.SQLException;

public interface UserService {
    /**
     * 用户登录
     * @param userCode
     * @param userPassword
     * @return
     */
    public User login(String userCode, String userPassword) throws SQLException, ClassNotFoundException;
}
