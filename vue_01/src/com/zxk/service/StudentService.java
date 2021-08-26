package com.zxk.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.Student;

/**
 * @program: Vue_Test
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 16:49
 **/
public interface StudentService {
    PageInfo<Student> selectByPage(Integer pageNum, Integer pageSize);

    Integer addStu(Student stu);

    Integer updateStu(Student stu);

    Integer deleteStu(String number);
}
