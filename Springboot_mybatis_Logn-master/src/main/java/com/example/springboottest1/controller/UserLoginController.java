package com.example.springboottest1.controller;

import com.example.springboottest1.entity.User;
import com.example.springboottest1.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: SpirngbootTest1
 * @description: 用户登录验证
 * @author: ZhangCH
 * @create: 2020/02/06
 */
@RequestMapping(value = {"/user"})
@Controller
public class UserLoginController {

    @Autowired
    private  UserLoginService userLoginService;

    /**
     * @Description: 跳转到注册页面
     * @Param:
     * @return:
     * @author: ZhangCH
     * @create: 2020/02/06
     */
    @RequestMapping(value = {"/registerpage"})
    public String regist() {

        return "register";

    }


    @RequestMapping(value = {"/login"})
    public String login(String username, String password, HttpServletRequest request) {

            User bean  = new User(username,password);

            User user = (User) userLoginService.userLogin(bean);

            if(null!=user) {

                request.getSession().setAttribute("session_user",user);

                return "hello";
            }
        return "error";

    }


    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("password2") String password2,
                        @RequestParam("age") int age) {

        if(!password.equals(password2)){

            return "两次密码不相同，注册失败！！";
        }else {
            int a = userLoginService.add(username,password,age);
            if(a == 0){
                return "注册失败！";
            }else {
                return "注册成功！";
            }
        }

    }


    @ResponseBody
    @RequestMapping(value = {"/test"})
    public String test() {

        List<User> list = userLoginService.selectList();

      return "测试数据"+list.get(0).getUsername();

    }



}
