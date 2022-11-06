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
 *
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

    @ApiModelProperty(value = "密码", example = "")
    @TableField("password")
    private String password;
}
