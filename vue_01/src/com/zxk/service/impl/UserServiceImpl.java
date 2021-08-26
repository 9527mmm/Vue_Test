package com.zxk.service.impl;

import com.zxk.domain.User;
import com.zxk.mapper.UserMapper;
import com.zxk.service.UserService;
import com.zxk.utils.MapperUtils;

/**
 * @program: Vue_Test
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-22 16:49
 **/
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(User user) {
        try {
            UserMapper mapper = MapperUtils.getMapper(UserMapper.class);
            System.out.println(user.getUsername()+"==="+user.getPassword());
            User login = mapper.login(user.getUsername(), user.getPassword());
            MapperUtils.commit();
            if(login!=null){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtils.rollback();
        } finally {
            MapperUtils.close();
        }
        return false;
    }
}
