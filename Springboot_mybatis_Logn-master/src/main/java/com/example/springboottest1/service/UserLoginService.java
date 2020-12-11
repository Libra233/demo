package com.example.springboottest1.service;

import com.example.springboottest1.entity.User;

import java.util.List;

public interface UserLoginService {

    User userLogin(User bean);


    int add(String username,String password,int age);

    List<User> selectList();

//    //计算相差天数
//    String TS();
}
