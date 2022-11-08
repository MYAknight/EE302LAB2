package com.example.ee302lab2.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.ee302lab2.entity.Result;
import com.example.ee302lab2.entity.TUser;
import com.example.ee302lab2.entity.room;
import com.example.ee302lab2.mapper.TRoomMapper;
import com.example.ee302lab2.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class connectController {
    @Autowired
    TUserMapper tUserMapper;

    @Autowired
    TRoomMapper tRoomMapper;

    @PostMapping("/join")
    public String selectUser(
            @RequestParam("Rnumber") String Rnumber,
            @RequestParam("uid") String uid
    ) {
        System.out.println(uid + "  " + Rnumber);
        int Number = Integer.parseInt(Rnumber);
        room oneRoomInf = tRoomMapper.getOneRoomInfByUid(uid);
        TUser userInf = tUserMapper.getUserInf(uid);
        String Uname = userInf.getUname();
        System.out.println(Uname);
        if (null == oneRoomInf) {
            tRoomMapper.addUser2Room(1, Number, uid, Uname, 0, 0, 0, 0, 0, 0);
            return "okk";
        } else {
            tRoomMapper.changeOneUserRoom(Number, uid);
            return "okk";
        }
    }

    @PostMapping("/roomInf")
    public Result roomInf(
            @RequestParam("Rnumber") String Rnumber
    ) {
        int Rnum = Integer.parseInt(Rnumber);
        List<room> oneRoomInfByRnumber = tRoomMapper.getOneRoomInfByRnumber(Rnum);
        Result r1 = new Result();
        r1.data("Rinf", oneRoomInfByRnumber);
        return r1;
    }

    @PostMapping("/changeZhanJi")
    public void changeZhanJi(
            @RequestParam("uid") String uid,
            @RequestParam("d1") int d1,
            @RequestParam("d2") int d2,
            @RequestParam("d3") int d3,
            @RequestParam("d4") int d4,
            @RequestParam("d5") int d5,
            @RequestParam("d6") int d6
    ) {
        System.out.println(d1 + " " + d2 + " " + d3 + " " + d4 + " " + d5 + " " + d6 + " ");
        tRoomMapper.changeOneUserData(d1, d2, d3, d4, d5, d6, uid);
    }
}

