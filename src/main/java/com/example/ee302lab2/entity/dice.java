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

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_dice")
@ApiModel(value = "骰子", description = "")
public class dice implements Serializable {
    public int[] die=new int[7];
    @ApiModelProperty(value = "ID", example = "1")
    @TableId(value = "PK_UID" )
    private Integer pkUid;

    @ApiModelProperty(value = "数", example = "0是默认用户状态，1是已经被拉黑的用户状态，9是管理员状态")
    @TableField("Ustate")
    private Integer ustate;

    @ApiModelProperty(value = "总得分", example = "")
    @TableField("set_Time")
    private Integer setTime;

}