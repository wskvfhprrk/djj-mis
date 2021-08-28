package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
       
      
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
@ApiModel("代金券明细实体类")
@Data
public class CouponStockVo {

    @ApiModelProperty(value="编号（每张代金券唯一编号）")
    private String couponNo;

    @ApiModelProperty(value="编号")
    private String couponId;

    @ApiModelProperty(value="店铺（最后在哪个店铺发出）")
    private String shopId;

    @ApiModelProperty(value="状态（0-库存 1-已领取 2-已使用 3-过期 4-作废）")
    private Integer status;

    @ApiModelProperty(value="会员ID（会员领取后绑定）")
    private String memberId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间",example = "2001-10-10 11:11:11")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="修改时间",example = "2001-10-10 11:11:11")
    private Date updateTime;
}
