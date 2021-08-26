package com.zxk.domain;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: Vue_Test
 * @description: 学生实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 16:35
 **/
public class Student implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 学号
     */
    private String number;
    /**
     * 姓名
     */
    private String name;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 地址
     */
    private String address;

    public Student() {
    }

    public Student(String number, String name, Date birthday, String address) {
        this.number = number;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getBirthday() {
        return birthday;
    }

    /**
     * 逻辑视图，使date转string
     *
     * @return
     */
   /* public String getBirStr() {
        return DateUtils.date2Str(getBirthday());
    }*/
    public void setBirthday(Date birthday) {
        System.out.println(birthday);
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(getNumber(), student.getNumber()) &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getBirthday(), student.getBirthday()) &&
                Objects.equals(getAddress(), student.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getName(), getBirthday(), getAddress());
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

}
