package com.guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-25 16:52:00
 */
@Data
public class SelectCouponDayRecycleRecordPageDto {
    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码")
    private Integer pageNumber;
    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条")
    private Integer pageSize;
    @ApiModelProperty("电子券批次id:省码+3位序号（5位数字）")
    private Integer couponBatchId;
}
