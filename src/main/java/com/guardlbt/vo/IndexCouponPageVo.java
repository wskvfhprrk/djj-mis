package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
  
  
/**
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@ApiModel("首页促销代金券实体类")
@Data
public class IndexCouponPageVo {

    @ApiModelProperty("排序") 
    private Integer sorting;

    @ApiModelProperty("代金券编号") 
    private String couponId;
}
