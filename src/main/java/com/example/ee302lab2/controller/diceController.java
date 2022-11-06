package com.example.ee302lab2.controller;

import com.example.ee302lab2.entity.room;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dice", method = {RequestMethod.GET, RequestMethod.POST})
@Api(value = "diceController", tags = "扔色子")
public class diceController {

    @ApiOperation("创建房间")
    @PostMapping("/createRoom")
    public int createRoom(
    ) {
        room r1 = new room();
        int id = r1.getId();
        return id;
    }

    @ApiOperation("验证结果")
    @PostMapping("/checkResult")
    public String checkResult(@ApiParam("名称") @RequestParam("Uname") String temp
    ) {
        System.out.println(temp);
        if (temp.length() != 6) {
            return "传入参数有误";
        }
        int i1 = Integer.parseInt(temp);
        int[] dice_array = new int[6];
        for (int i = 0; i < 6; i++) {
            dice_array[i] = i1%10;
            i1/=10;
        }

        String result;
        int one_flag = 0;
        int two_flag = 0;
        int three_flag = 0;
        int four_flag = 0;
        int five_flag = 0;
        int six_flag = 0;
        for (int i = 0; i < 6; i++) {
            if (dice_array[i] == 1) {
                one_flag++;
            }
            if (dice_array[i] == 2) {
                two_flag++;
            }
            if (dice_array[i] == 3) {
                three_flag++;
            }
            if (dice_array[i] == 4) {
                four_flag++;
            }
            if (dice_array[i] == 5) {
                five_flag++;
            }
            if (dice_array[i] == 6) {
                six_flag++;
            }
        }
        //状元
        if ((two_flag == 2 && four_flag == 4) || (four_flag == 6) || (one_flag == 6) || (four_flag == 5) || (two_flag == 5) || (four_flag == 4)) {
            result = "状元";
        }
        //对堂
        else if (one_flag == 1 && two_flag == 1 && three_flag == 1 && four_flag == 1 && five_flag == 1 && six_flag == 1) {
            result = "对堂";
        }
        //四进
        else if (two_flag == 4) {
            result = "四进";
        }
        //三红
        else if (four_flag == 3) {
            result = "三红";
        }
        //二举
        else if (four_flag == 2) {
            result = "二举";
        }
        //一秀
        else if (four_flag == 1) {
            result = "一秀";
        } else {
            result = "不中";
        }
        return result;
    }
}
