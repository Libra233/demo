package com.example.springboottest1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: SpirngbootTest1
 * @description: 这是个控制类
 * @author: ZhangCH
 * @create: 2020/02/06
 */
@Controller
@RequestMapping(value = {"/hello"})
public class helloController {

    @RequestMapping(value = {"/springboot"})
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = {"/loginHtml"})
    public String userLogin() {
        return "userLogin";
    }



}
