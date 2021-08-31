package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

     
import java.math.BigDecimal;
       
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
@ApiModel("代金券PageDto")
@Data
public class  CouponPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



    @ApiModelProperty(value ="商圈名称")
    private String name;

    @ApiModelProperty(value ="所属店铺")
    private String shopId;

    @ApiModelProperty(value ="图片")
    private String images;

    @ApiModelProperty(value ="面值，单价（元）")
    private BigDecimal price;

    @ApiModelProperty(value ="使用门槛（消费满多少元可以使用）")
    private BigDecimal useThreshold;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="标签",example = "2000-12-12 10:10:10")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="结束日期",example = "2000-12-12 10:10:10")
    private Date stopDate;

    @ApiModelProperty(value ="优惠说明")
    private String description;

    @ApiModelProperty(value ="使用须知")
    private String instruction;

    @ApiModelProperty(value ="类型（0-公开 1-内部）")
    private Integer type;

    @ApiModelProperty(value ="状态（0-新建 1-已上架 2-已下架）")
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="修改时间",example = "2000-12-12 10:10:10")
    private Date updateTime;
}
