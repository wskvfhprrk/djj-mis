package com.guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.*;
import java.util.Date;    


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:48:40
 */
@Data
public class SelectCouponBatchByCouponBatchIdVo {
    
    @ApiModelProperty("电子券批次id:省码+3位序号（5位数字）")
    private Integer couponBatchId;
    
    @ApiModelProperty("商家id")
    private Integer merchantId;
    
    @ApiModelProperty("名称")
    private String couponName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty("开始时间(长时间字符串：yyyy-MM-dd HH:mm:ss)")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @ApiModelProperty("截止时间(长时间字符串：yyyy-MM-dd HH:mm:ss)")
    private Date endTime;
    
    @ApiModelProperty("内容描述")
    private String description;
    
    @ApiModelProperty("总金额（=面值*数量）")
    private Integer money;
    
    @ApiModelProperty("电子券面值")
    private Integer price;
    
    @ApiModelProperty("电子券数量")
    private Integer number;
    
    @ApiModelProperty("状态（1新建/2正在生产/3已生产）")
    private Integer couponbatchStatus;

    private Integer isQr;
}
