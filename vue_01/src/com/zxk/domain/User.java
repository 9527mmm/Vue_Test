package com.zxk.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: Vue_Test
 * @description: 用户实体类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 16:38
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }
}
