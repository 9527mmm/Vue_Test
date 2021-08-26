package com.zxk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.Student;
import com.zxk.service.StudentService;
import com.zxk.service.impl.StudentServiceImpl;
import com.zxk.utils.JsonUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @program: Vue_Test
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 18:43
 **/
@WebServlet("/stu")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        System.out.println(action);
        if ("selectByPage".equals(action)) {
            selectByPage(req, resp);
        } else if ("addStu".equals(action)) {
            addStu(req, resp);
        } else if ("updateStu".equals(action)) {
            updateStu(req, resp);
        } else if ("deleteStu".equals(action)) {
            deleteStu(req, resp);
        }
    }

    private void deleteStu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String number = req.getParameter("number");
        //调用业务层的删除方法
        Integer integer = studentService.deleteStu(number);

        if (integer > 0) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }

    private void updateStu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Student student = JsonUtil.req2Bean(req, Student.class);
        Integer integer = studentService.updateStu(student);
        if (integer > 0) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }

    private void addStu(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Student student = JsonUtil.req2Bean(req, Student.class);
        Integer integer = studentService.addStu(student);
        if (integer > 0) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }

    }

    private void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer pageNum = Integer.valueOf(req.getParameter("pageNum"));
        Integer pageSize = Integer.valueOf(req.getParameter("pageSize"));
        PageInfo<Student> pageInfo = studentService.selectByPage(pageNum, pageSize);
        String json = JsonUtil.obj2Str(pageInfo);
        resp.getWriter().write(json);
    }


    //日期转换

    private void dateConvert() {
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, Date.class);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
