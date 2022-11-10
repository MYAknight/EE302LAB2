package com.example.ee302lab2.controller;


import com.example.ee302lab2.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    TUserMapper tUserMapper;

    @Controller
    public class HelloController {

        @RequestMapping("/Hi")
        public ModelAndView sayHello() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("register01.html");
            return modelAndView;
        }
    }
}
