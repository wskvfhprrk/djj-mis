package com.guardlbt.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShareCouponDto {
    @ApiModelProperty("fomeOpenid")
    @NotBlank(message = "fomeOpenid不能为空值")
    private String fomeOpenid;
    @ApiModelProperty("toOpneid")
    @NotBlank(message = "toOpneid不能为空值")
    private String toOpneid;
    @ApiModelProperty("couponId")
    @NotBlank(message = "couponId不能为空值")
    private String couponId;

}
