package com.guardlbt.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * Created by 代码自动生成.
 * 时间:2019-04-10 10:07:23
 */
@Data
public class SelectCouponCheckPageVo {

    @ApiModelProperty("电子券批次号")
    private Integer couponBatchId;

    @ApiModelProperty("电子券编号")
    private Long couponId;

    @ApiModelProperty("状态（1库存、2锁定、3回收、4失效），只有回收状态")
    private Integer couponStatus;

    @ApiModelProperty("更新时间——电子券系统回收时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date couponUpdateTime;

}
