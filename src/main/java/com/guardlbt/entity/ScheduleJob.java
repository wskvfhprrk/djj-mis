package com.guardlbt.entity;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
        
        
import java.util.Date;
        
/**
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
@ApiModel("定时任务实体类")
@Data
public class ScheduleJob {

    @ApiModelProperty("任务id") 
    private Long jobId;

    @ApiModelProperty("spring bean名称") 
    private String beanName;

    @ApiModelProperty("方法名") 
    private String methodName;

    @ApiModelProperty("参数") 
    private String params;

    @ApiModelProperty("cron表达式") 
    private String cronExpression;

    @ApiModelProperty("任务状态  0：正常  1：暂停") 
    private Integer status;

    @ApiModelProperty("备注") 
    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") 
    private Date createTime;
}
