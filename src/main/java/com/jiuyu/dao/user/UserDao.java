package com.jiuyu.dao.user;

import com.jiuyu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {

    //得到登录的用户
    public User getLoginUsr(Connection connection, String userCode) throws SQLException;


}
