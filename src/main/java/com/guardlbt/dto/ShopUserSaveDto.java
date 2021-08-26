package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

import lombok.Data;


import java.util.Date;

/**
 * Created by 代码自动生成.
 * 时间:2021-08-25 18:06:23
 */
@ApiModel("商店管理员实体类")
@Data
public class ShopUserSaveDto {


    @ApiModelProperty("昵称")
    @NotBlank(message = "昵称不能为空值")
    private String name;

    @ApiModelProperty("性别（0:男，1:女）")
    @NotBlank(message = "性别（0:男，1:女）不能为空值")
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("生日")
    @NotNull(message = "生日不能为空值")
    private Date birthday;

    @ApiModelProperty("联系方式")
    @NotBlank(message = "联系方式不能为空值")
    private String phone;

    @ApiModelProperty("角色（0-老板 1-店长 2-员工）")
    @NotBlank(message = "角色（0-老板 1-店长 2-员工）不能为空值")
    private String role;

    @ApiModelProperty("店铺编号")
    @NotBlank(message = "店铺编号不能为空值")
    private String shopId;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty("创建时间")
//    @NotNull(message = "创建时间不能为空值")
//    private Date createTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty("更新时间")
//    @NotNull(message = "更新时间不能为空值")
//    private Date updateTime;

//    @ApiModelProperty("状态（0-正常 1-暂停 2-注销）")
//    @NotBlank(message = "状态（0-正常 1-暂停 2-注销）不能为空值")
//    private String status;

    @ApiModelProperty("用户在微信端的唯一标识")
    @NotBlank(message = "用户在微信端的唯一标识不能为空值")
    private String openId;
}
