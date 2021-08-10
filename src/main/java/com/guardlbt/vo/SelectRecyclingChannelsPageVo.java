package com.guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 11:23:20
 */
@Data
public class SelectRecyclingChannelsPageVo {
    
    @ApiModelProperty("回收渠道ID")
    private Integer recyclingChannelsId;
    
    @ApiModelProperty("user_id")
    private String userId;
    
    @ApiModelProperty("真实姓名")
    private String raleName;
    
    @ApiModelProperty("电话")
    private String phone;
    
    @ApiModelProperty("电子邮件")
    private String email;
    
    @ApiModelProperty("回收渠道名称")
    private String recyclingChannelsName;
    
    @ApiModelProperty("回收渠道状态:0为正常1为锁定")
    private Integer recyclingChannelsStatus;
}
