package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
  
  
/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:55
*/
@ApiModel("首页促销代金券实体类")
@Data
public class IndexCouponVo {

    @ApiModelProperty(value ="排序")
    private Integer sorting;

    @ApiModelProperty(value ="代金券编号")
    private String couponId;
}
