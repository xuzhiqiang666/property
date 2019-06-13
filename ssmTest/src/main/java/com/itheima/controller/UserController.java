package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentController studentController;

    @RequestMapping("/findOne")
    public ModelAndView findOne(User user, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        User user1 = userService.findOne(user);
        if(user1!=null){
            session.setAttribute("user", user1);
            return studentController.findAll();
        }else {
            modelAndView.addObject("msg","用户名或密码错误,请重新输入!" );
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
