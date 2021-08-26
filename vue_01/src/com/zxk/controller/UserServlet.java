package com.zxk.controller;

import com.zxk.domain.User;
import com.zxk.service.UserService;
import com.zxk.service.impl.UserServiceImpl;
import com.zxk.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Vue_Test
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 17:36
 **/
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = JsonUtil.req2Bean(req, User.class);
        boolean login = userService.login(user);
        System.out.println(user);
        if (login) {
            req.getSession().setAttribute("user", user);
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
