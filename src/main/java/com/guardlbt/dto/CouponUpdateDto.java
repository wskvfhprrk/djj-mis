package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
     
import java.math.BigDecimal;
       
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
@ApiModel("代金券实体类")
@Data
public class CouponUpdateDto {

    @ApiModelProperty(value ="编号") 
    @NotBlank(message = "编号不能为空值")     private String couponId;

    @ApiModelProperty(value ="商圈名称") 
    @NotBlank(message = "商圈名称不能为空值")     private String name;

    @ApiModelProperty(value ="所属店铺") 
    @NotBlank(message = "所属店铺不能为空值")     private String shopId;

    @ApiModelProperty(value ="图片") 
    @NotBlank(message = "图片不能为空值")     private String images;

    @ApiModelProperty(value ="面值，单价（元）") @NotNull(message = "面值，单价（元）不能为空值")
     private BigDecimal price;

    @ApiModelProperty(value ="使用门槛（消费满多少元可以使用）") @NotNull(message = "使用门槛（消费满多少元可以使用）不能为空值")
     private BigDecimal useThreshold;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="标签",example = "2000-12-12 10:10:10") @NotNull(message = "标签不能为空值")
     private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="结束日期",example = "2000-12-12 10:10:10") @NotNull(message = "结束日期不能为空值")
     private Date stopDate;

    @ApiModelProperty(value ="优惠说明") 
    @NotBlank(message = "优惠说明不能为空值")     private String description;

    @ApiModelProperty(value ="使用须知") 
    @NotBlank(message = "使用须知不能为空值")     private String instruction;

    @ApiModelProperty(value ="类型（0-公开 1-内部）") @NotNull(message = "类型（0-公开 1-内部）不能为空值")
     private Integer type;

    @ApiModelProperty(value ="状态（0-新建 1-已上架 2-已下架）") @NotNull(message = "状态（0-新建 1-已上架 2-已下架）不能为空值")
     private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10") @NotNull(message = "创建时间不能为空值")
     private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="修改时间",example = "2000-12-12 10:10:10") @NotNull(message = "修改时间不能为空值")
     private Date updateTime;
}
