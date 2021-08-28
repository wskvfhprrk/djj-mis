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
@ApiModel("代金券历史实体类")
@Data
public class CouponHistoryPageVo {

    @ApiModelProperty(value="编号（每张代金券唯一编号）")
    private Long id;

    @ApiModelProperty(value="编号（每张代金券唯一编号）")
    private String couponNo;

    @ApiModelProperty(value="发出方（id+名称）")
    private String fromName;

    @ApiModelProperty(value="接收方（id+名称）")
    private String toName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间",example = "2001-10-10 11:11:11")
    private Date createTime;

    @ApiModelProperty(value="备注")
    private String remark;
}
