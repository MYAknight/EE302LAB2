package com.example.ee302lab2.controller;

import com.example.ee302lab2.entity.TUser;
import com.example.ee302lab2.mapper.TUserMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    TUserMapper tUserMapper;

    @PostMapping("/login")
    public String selectUser(@RequestParam("Unumber") String Unumber,
                             @RequestParam("Upassword") String password

    ) {

        TUser userInf = tUserMapper.getUserInf(Unumber);
        if (null == userInf) {
            return "back";
        } else {
            if (password.equals(userInf.getUpassword())) {
                return "go";
            } else {
                return "back";
            }
        }
    }
 /*   @RequestMapping("/login")
    public String selectUser(Map<String, Object> map, @RequestParam("Unumber") String Unumber,
                             @RequestParam("password") String password

    ) {
        TUser userInf = tUserMapper.getUserInf(Unumber);
        if (null == userInf) {
            return "redirect:/register01.html";
        } else {
            if (password.equals(userInf.getUpassword())) {
                return "redirect:/bobing-master/bobing/index.html";
            } else {
                return "redirect:/register01.html";
            }
        }
    }*/
   /* @RequestMapping("/login")
    public ModelAndView selectUser(@RequestParam("Unumber") String Unumber,
                                   @RequestParam("password") String password
    ) {
        TUser userInf = tUserMapper.getUserInf(Unumber);
        ModelAndView modelAndView = new ModelAndView();
        if (null == userInf) {
            modelAndView.setViewName("register01.html");
        } else {
            if (password.equals(userInf.getUpassword())) {
                modelAndView.setViewName("bobing-master/bobing/index.html");
                modelAndView.addObject("key", 32123);
                System.out.println("code");
            } else {
                modelAndView.setViewName("register01.html");
            }
        }
        return modelAndView;
    }*/

    @ApiOperation(value = "用户注册，学工号在数据库是唯一元素，成功message返回“用户注册成功”，否则返回“该学工号已注册“")
    @PostMapping("/registerUserWithPhone")
    public String registerUser(@ApiParam("姓名") @RequestParam("Uname") String Uname,
                               @ApiParam("密码") @RequestParam("Upassword") String Upassword,
                               @ApiParam("电话") @RequestParam("Uphone") String Uphone) {
        if (null == tUserMapper.getUserInf(Uphone)) {
            TUser tUser = new TUser();
            tUser.setUname(Uname);
            tUser.setUphone(Uphone);
            tUser.setUstate(0);
            tUser.setUpassword(Upassword);
            tUserMapper.insert(tUser);
            return "resuss";
        } else {
            return "refail";
        }
    }
}