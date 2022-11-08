package com.example.ee302lab2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ee302lab2.entity.room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TRoomMapper extends BaseMapper<room> {
    void addUser2Room(int state, int Number, String uid, String Uname, int d1, int d2, int d3, int d4, int d5, int d6);

    void changeOneUserRoom(int Number, String uid);

    void changeOneUserData(int d1, int d2, int d3, int d4, int d5, int d6, String uid);

    room getOneRoomInfByUid(String uid);

    List<room> getOneRoomInfByRnumber(int Number);
}
