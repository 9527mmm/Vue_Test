package com.zxk.mapper;

import com.zxk.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: Vue_Test
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 16:50
 **/
public interface StudentMapper {

    @Select("select * from student")
    List<Student> selectAll();

    @Insert("insert into student values (#{number},#{name},#{birthday},#{address})")
    Integer addStu(Student stu);

    @Update("update student set name=#{name},birthday=#{birthday},address=#{address} where number=#{number}")
    Integer updateStu(Student stu);

    @Delete("delete from student where number=#{number}")
    Integer deleteStu(String number);
}
