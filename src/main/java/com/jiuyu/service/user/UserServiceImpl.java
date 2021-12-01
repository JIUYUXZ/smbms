package com.jiuyu.service.user;

import com.jiuyu.dao.BaseDao;
import com.jiuyu.dao.user.UserDao;
import com.jiuyu.dao.user.UserDaoImpl;
import com.jiuyu.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 *
 */

public class UserServiceImpl implements UserService {

    //业务层都会调用dao层，所以我们要引入dao层
    private UserDao userDao;
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        User user = null;

        connection = BaseDao.getConnection();
        //通过业务层调用具体的数据库操作
        userDao.getLoginUsr(connection,userCode);

        BaseDao.closeResource(connection,null,null);
        return user;
    }

}
