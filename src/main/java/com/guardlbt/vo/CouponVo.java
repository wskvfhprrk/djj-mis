package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
     
import java.math.BigDecimal;
       
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:26
*/
@ApiModel("代金券实体类")
@Data
public class CouponVo {

    @ApiModelProperty("编号") 
    private String couponId;

    @ApiModelProperty("空间名称") 
    private String name;

    @ApiModelProperty("所属店铺") 
    private String shopId;

    @ApiModelProperty("图片") 
    private String images;

    @ApiModelProperty("面值，单价（元）") 
    private BigDecimal price;

    @ApiModelProperty("使用门槛（消费满多少元可以使用）") 
    private BigDecimal useThreshold;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("标签") 
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("结束日期") 
    private Date stopDate;

    @ApiModelProperty("优惠说明") 
    private String description;

    @ApiModelProperty("使用须知") 
    private String instruction;

    @ApiModelProperty("类型（0-公开 1-内部）") 
    private String type;

    @ApiModelProperty("状态（0-新建 1-已上架 2-已下架）") 
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") 
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间") 
    private Date updateTime;
}
