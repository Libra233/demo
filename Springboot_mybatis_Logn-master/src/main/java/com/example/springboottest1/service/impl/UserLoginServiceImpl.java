package com.example.springboottest1.service.impl;

import com.example.springboottest1.entity.User;
import com.example.springboottest1.mapper.UserMapper;
import com.example.springboottest1.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SpirngbootTest1
 * @description: 登录验证的实现类
 * @author: ZhangCH
 * @create: 2020/02/06
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserMapper usermapper;

    @Override
    public User userLogin(User bean) {
        User user = usermapper.userlogin(bean);
        return user;
    }

    @Override
    public int add(String username,String password,int age) {
        User user = new User(username,password, age);
        return usermapper.insert(user);
    }

    @Override
    public List<User> selectList() {
        List<User> list = new ArrayList<>();
        list.add(usermapper.selectByPrimaryKey(1));
        return list;
    }


//    @Override
//    public String TS(){
//
//    }


}
