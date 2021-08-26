package com.zxk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxk.domain.Student;
import com.zxk.mapper.StudentMapper;
import com.zxk.service.StudentService;
import com.zxk.service.UserService;
import com.zxk.service.impl.StudentServiceImpl;
import com.zxk.service.impl.UserServiceImpl;
import com.zxk.utils.MapperUtils;
import org.junit.Test;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: Vue_Test
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 15:14
 **/
@WebServlet("/axios")
public class AxiosTest extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private StudentService studentService = new StudentServiceImpl();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //String name = req.getParameter("name");
        //System.out.println(name);
        String json = req.getReader().readLine();
        Map<String, String> s = mapper.readValue(json, Map.class);
        System.out.println(s);
        System.out.println(s.get("name"));
        resp.getWriter().write("发送成功");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Test
    public void selectTest() {
        StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.selectAll();
        System.out.println(studentList);
        MapperUtils.close();
    }

    @Test
    public void insertTest() {
        Integer test = studentService.addStu(new Student("test", "222", new Date(), "1111"));
        System.out.println(test);
    }
}
