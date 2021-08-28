package com.guardlbt.entity;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
  
  
  
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:16
*/
@ApiModel("首页促销店铺实体类")
@Data
public class IndexShop {

    @ApiModelProperty(value ="排序")
    private Integer sorting;

    @ApiModelProperty(value ="店铺编号")
    private String shopId;
}
