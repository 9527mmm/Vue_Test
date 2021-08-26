package com.zxk.filter;

import com.zxk.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: Vue_Test
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 16:44
 **/
@WebFilter("/index.html")
public class LoginFliter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        User user= (User) req.getSession().getAttribute("user");
        if(user!=null){
            filterChain.doFilter(req, resp);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");
        /*if (username == null || "".equals(username)) {
            resp.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }
        filterChain.doFilter(req, resp);*/
    }
}
