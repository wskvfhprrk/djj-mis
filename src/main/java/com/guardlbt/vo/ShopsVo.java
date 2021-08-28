package com.guardlbt.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ShopsVo {
    @ApiModelProperty(value ="店铺编号")
    private String shopId;

    @ApiModelProperty(value ="店铺名称")
    private String name;
}
