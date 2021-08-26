package com.zxk.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk.domain.Student;
import com.zxk.mapper.StudentMapper;
import com.zxk.service.StudentService;
import com.zxk.utils.MapperUtils;

import java.util.List;

/**
 * @program: Vue_Test
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 16:50
 **/
public class StudentServiceImpl implements StudentService {

    @Override
    public PageInfo<Student> selectByPage(Integer pageNum, Integer pageSize) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            PageHelper.startPage(pageNum, pageSize);
            List<Student> studentList = mapper.selectAll();
            MapperUtils.commit();
            return new PageInfo<>(studentList);
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return null;
    }

    @Override
    public Integer addStu(Student stu) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            Integer i = mapper.addStu(stu);
            MapperUtils.commit();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return -1;
    }

    @Override
    public Integer updateStu(Student stu) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            Integer i = mapper.updateStu(stu);
            MapperUtils.commit();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return -1;
    }

    @Override
    public Integer deleteStu(String number) {
        try {
            StudentMapper mapper = MapperUtils.getMapper(StudentMapper.class);
            Integer i = mapper.deleteStu(number);
            MapperUtils.commit();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return -1;
    }
}
