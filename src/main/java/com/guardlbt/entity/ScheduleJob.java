package com.guardlbt.entity;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
        
        
import java.util.Date;
        
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:18
*/
@ApiModel("定时任务实体类")
@Data
public class ScheduleJob {

    @ApiModelProperty(value ="任务id")
    private Long jobId;

    @ApiModelProperty(value ="spring bean名称")
    private String beanName;

    @ApiModelProperty(value ="方法名")
    private String methodName;

    @ApiModelProperty(value ="参数")
    private String params;

    @ApiModelProperty(value ="cron表达式")
    private String cronExpression;

    @ApiModelProperty(value ="任务状态  0：正常  1：暂停")
    private Integer status;

    @ApiModelProperty(value ="备注")
    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间")
    private Date createTime;
}
