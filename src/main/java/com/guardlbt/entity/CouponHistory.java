package com.guardlbt.entity;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-11 15:09:11
*/
@ApiModel("代金券历史实体类")
@Data
public class CouponHistory {
 
    @ApiModelProperty("编号（每张代金券唯一编号）") 
    private Long id;
 
    @ApiModelProperty("编号（每张代金券唯一编号）") 
    private String couponNo;
 
    @ApiModelProperty("发出方（id+名称）") 
    private String fromName;
 
    @ApiModelProperty("接收方（id+名称）") 
    private String toName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    @ApiModelProperty("创建时间") 
    private Date createTime;
 
    @ApiModelProperty("备注") 
    private String remark;
}
