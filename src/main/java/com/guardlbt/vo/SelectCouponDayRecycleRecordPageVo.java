package com.guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.fasterxml.jackson.annotation.*;

import java.util.Date;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:52:00
 */
@Data
public class SelectCouponDayRecycleRecordPageVo {

    @ApiModelProperty("批次编号")
    private Integer couponBatchId;

    @ApiModelProperty("名称")
    private String couponName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("开始时间(长时间字符串：yyyy-MM-dd HH:mm:ss)")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("截止时间(长时间字符串：yyyy-MM-dd HH:mm:ss)")
    private Date endTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("统计时间(长时间字符串：yyyy-MM-dd HH:mm:ss)")
    private Date createTime;

    @ApiModelProperty("总数量")
    private Integer number;

    @ApiModelProperty("回收数量")
    private Integer allRecycleNumber;

    @ApiModelProperty("未回收数量")
    private Integer noRecycleNumber;
    @ApiModelProperty("当天回收数量")
    private Integer dayRecycleNumber;
    @ApiModelProperty("当天进度（百分比）")
    private Integer dayRecyclePercent;

    @ApiModelProperty("进度（百分比）")
    private Integer allPercent;


}
