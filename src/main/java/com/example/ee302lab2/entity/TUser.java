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
import java.util.Date;

/**
 * <p>
 *
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_user")
@ApiModel(value = "TUser对象", description = "")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID", example = "1")
    @TableId(value = "PK_UID", type = IdType.AUTO)
    private Integer pkUid;

    @ApiModelProperty(value = "昵称", example = "1")
    @TableField("Uname")
    private String uname;

    @ApiModelProperty(value = "密码", example = "1")
    @TableField("Upassword")
    private String upassword;

    @ApiModelProperty(value = "电话", example = "1")
    @TableField("Uphone")
    private String uphone;

    @ApiModelProperty(value = "数据", example = "1")
    @TableField("Udata")
    private String Udata;

    @ApiModelProperty(value = "状态", example = "0是默认用户状态，1是已经被拉黑的用户状态，9是管理员状态")
    @TableField("Ustate")
    private Integer ustate;
}
