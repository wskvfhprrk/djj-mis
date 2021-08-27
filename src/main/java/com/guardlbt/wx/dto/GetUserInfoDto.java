package com.guardlbt.wx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("提交用户信息参数")
public class GetUserInfoDto {
    @NotBlank(message = "openid不能为空值")
    @ApiModelProperty("openid")
    private String openid;
    @NotBlank(message = "用户昵称不能为空值")
    @ApiModelProperty("用户昵称")
    private String nickName;
    @NotBlank(message = "头像不能为空值")
    @ApiModelProperty("头像")
    private String avatarUrl;
    @NotNull(message = "性别不能为空值")
    @ApiModelProperty("性别")
    private Integer gender;
}