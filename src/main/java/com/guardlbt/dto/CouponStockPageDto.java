package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

       
      
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:23
*/
@ApiModel("代金券明细PageDto")
@Data
public class  CouponStockPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;


    @ApiModelProperty("编号") 
    private String couponId;

    @ApiModelProperty("店铺（最后在哪个店铺发出）") 
    private String shopId;

    @ApiModelProperty("状态（0-库存 1-已领取 2-已使用 3-过期 4-作废）") 
    private String status;

    @ApiModelProperty("会员ID（会员领取后绑定）") 
    private String memberId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") 
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间") 
    private Date updateTime;
}
