package com.guardlbt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UseCouponDto {
    @ApiModelProperty("用户openid")
    @NotBlank(message = "用户openid不能为空值")
    private String openId;
    @ApiModelProperty("电子券编号")
    @NotBlank(message = "电子券编号不能为空值")
    private String couponId;
}
