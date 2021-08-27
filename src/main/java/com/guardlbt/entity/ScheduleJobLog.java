package com.guardlbt.entity;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
         
         
import java.util.Date;
         
/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
@ApiModel("定时任务日志实体类")
@Data
public class ScheduleJobLog {

    @ApiModelProperty(value ="任务日志id")
    private Long logId;

    @ApiModelProperty(value ="任务id")
    private Long jobId;

    @ApiModelProperty(value ="spring bean名称")
    private String beanName;

    @ApiModelProperty(value ="方法名")
    private String methodName;

    @ApiModelProperty(value ="参数")
    private String params;

    @ApiModelProperty(value ="任务状态    0：成功    1：失败")
    private String status;

    @ApiModelProperty(value ="失败信息")
    private String error;

    @ApiModelProperty(value ="耗时(单位：毫秒)")
    private Integer times;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间")
    private Date createTime;
}
