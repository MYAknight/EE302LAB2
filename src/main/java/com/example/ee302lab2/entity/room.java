package com.example.ee302lab2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *这里设计上出现失误，Number表示的为房间号码，uid实际上是用户的注册手机号
 * @author Huaqi
 * @EE302FZ LAB2
 * </p>
 * @since 2022-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_room")
@ApiModel(value = "房间对象", description = "")
public class room implements Serializable {
    @ApiModelProperty(value = "房间ID", example = "1")
    @TableId(value = "PK_RID")
    private int id;

    @ApiModelProperty(value = "状态", example = "0是未开启状态，1是已经开启状态")
    @TableField("state")
    private Integer ustate;

    @ApiModelProperty(value = "房间号码", example = "")
    @TableField("Number")
    private Integer Number;

    @ApiModelProperty(value = "用户id", example = "")
    @TableField("uid")
    private String uid;

    @ApiModelProperty(value = "用户名", example = "")
    @TableField("Uname")
    private String Uname;

    @ApiModelProperty(value = "状元", example = "")
    @TableField("d1")
    private Integer d1;

    @ApiModelProperty(value = "对堂", example = "")
    @TableField("d2")
    private Integer d2;

    @ApiModelProperty(value = "三红", example = "")
    @TableField("d3")
    private Integer d3;

    @ApiModelProperty(value = "四进", example = "")
    @TableField("d4")
    private Integer d4;

    @ApiModelProperty(value = "二举", example = "")
    @TableField("d5")
    private Integer d5;

    @ApiModelProperty(value = "一秀", example = "")
    @TableField("d6")
    private Integer d6;

}
