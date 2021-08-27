package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
  
  
/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@ApiModel("首页促销代金券实体类")
@Data
public class IndexCouponUpdateDto {

    @ApiModelProperty("排序") @NotNull(message = "排序不能为空值")
     private Integer sorting;

    @ApiModelProperty("代金券编号") 
    @NotBlank(message = "代金券编号不能为空值")     private String couponId;
}