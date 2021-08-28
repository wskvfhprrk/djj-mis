package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
  
  
/**
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
@ApiModel("首页促销店铺实体类")
@Data
public class IndexShopUpdateDto {

    @ApiModelProperty("排序") @NotNull(message = "排序不能为空值")
    private Integer sorting;

    @ApiModelProperty("店铺编号") 
    @NotBlank(message = "店铺编号不能为空值")    private String shopId;
}
