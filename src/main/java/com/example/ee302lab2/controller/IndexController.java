package com.example.ee302lab2.controller;


import com.example.ee302lab2.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



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
//            modelAndView.addObject("key", 12345);
            //System.out.println("test");
            return modelAndView;
        }

    }
}
