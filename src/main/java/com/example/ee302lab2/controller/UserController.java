package com.example.ee302lab2.controller;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.ee302lab2.entity.TUser;
import com.example.ee302lab2.mapper.TUserMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@CrossOrigin//处理跨域问题
@RequestMapping("/user")
public class UserController {
    @Autowired
    TUserMapper tUserMapper;

    @PostMapping("/login")
    public String selectUser(@RequestParam("Unumber") String Unumber,
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
    }

    @ApiOperation(value = "用户注册，学工号在数据库是唯一元素，成功message返回“用户注册成功”，否则返回“该学工号已注册“")
    @PostMapping("/registerUserWithPhone")
    @ApiResponses({
            @ApiResponse(code = 200, message = "用户注册成功", response = TUser.class),
            @ApiResponse(code = 999, message = "该学工号已注册", response = TUser.class)
    })
    public String registerUser(@ApiParam("姓名") @RequestParam("Uname") String Uname,
                               @ApiParam("密码") @RequestParam("Upassword") String Upassword,
                               @ApiParam("电话") @RequestParam("Uphone") String Uphone) throws IOException {
        System.out.println(Uname+Upassword+Uphone);
        if (null == tUserMapper.getUserInf(Uphone)) {
            TUser tUser = new TUser();
            tUser.setUname(Uname);
            tUser.setUphone(Uphone);
            tUser.setUstate(0);
            tUser.setUpassword(Upassword);
            tUserMapper.insert(tUser);
            return "redirect:/bobing-master/bobing/index.html";
        } else {
            return "redirect:/register01.html";
        }

    }

}