package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
         
         
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@ApiModel("定时任务日志实体类")
@Data
public class ScheduleJobLogPageVo {

    @ApiModelProperty("任务日志id") 
    private Long logId;

    @ApiModelProperty("任务id") 
    private Long jobId;

    @ApiModelProperty("spring bean名称") 
    private String beanName;

    @ApiModelProperty("方法名") 
    private String methodName;

    @ApiModelProperty("参数") 
    private String params;

    @ApiModelProperty("任务状态    0：成功    1：失败") 
    private String status;

    @ApiModelProperty("失败信息") 
    private String error;

    @ApiModelProperty("耗时(单位：毫秒)") 
    private Integer times;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") 
    private Date createTime;
}
