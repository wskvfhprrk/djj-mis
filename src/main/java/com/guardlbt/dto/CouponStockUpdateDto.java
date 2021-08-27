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
* 时间:2021-08-27 13:42:55
*/
@ApiModel("代金券明细实体类")
@Data
public class CouponStockUpdateDto {

    @ApiModelProperty(value ="编号（每张代金券唯一编号）") 
    @NotBlank(message = "编号（每张代金券唯一编号）不能为空值")     private String couponNo;

    @ApiModelProperty(value ="编号") 
    @NotBlank(message = "编号不能为空值")     private String couponId;

    @ApiModelProperty(value ="店铺（最后在哪个店铺发出）") 
    @NotBlank(message = "店铺（最后在哪个店铺发出）不能为空值")     private String shopId;

    @ApiModelProperty(value ="状态（0-库存 1-已领取 2-已使用 3-过期 4-作废）") 
    @NotBlank(message = "状态（0-库存 1-已领取 2-已使用 3-过期 4-作废）不能为空值")     private String status;

    @ApiModelProperty(value ="会员ID（会员领取后绑定）") 
    @NotBlank(message = "会员ID（会员领取后绑定）不能为空值")     private String memberId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10") @NotNull(message = "创建时间不能为空值")
     private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="修改时间",example = "2000-12-12 10:10:10") @NotNull(message = "修改时间不能为空值")
     private Date updateTime;
}
