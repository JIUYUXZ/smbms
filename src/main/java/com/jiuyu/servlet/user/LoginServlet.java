package com.jiuyu.servlet.user;

import com.jiuyu.pojo.User;
import com.jiuyu.service.user.UserService;
import com.jiuyu.service.user.UserServiceImpl;
import com.jiuyu.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    //控制层，调用业务层代码

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("LoginServlet--start....");

        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //和数据库中的密码进行对比，调用业务层
        UserService userService = new UserServiceImpl();
        try {
            User user = userService.login(userCode, userPassword); //这里已经把登录的人给查出来了
            if (user != null) {
                //查到用户，将信息放到Session中
                req.getSession().setAttribute(Constants.USER_SESSION,user);
                //跳转到主页
                resp.sendRedirect("jsp/frame.jsp");
            }else {
                //无法登录，转发回登录界面
                req.setAttribute("error","用户名或密码不正确");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
