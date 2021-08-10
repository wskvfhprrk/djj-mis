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
public class SelectCouponDayRecycleRecordByCouponBatchIdByNumberVo {
    
    @ApiModelProperty("总数量")
    private Integer dayRecycleNumber;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @ApiModelProperty("回收数量(短时间字符串：yyyy-MM-dd)")
    private Date createTime;
}
