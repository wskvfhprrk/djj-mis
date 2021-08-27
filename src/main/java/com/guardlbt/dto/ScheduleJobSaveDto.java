package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
        
        
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@ApiModel("定时任务实体类")
@Data
public class ScheduleJobSaveDto {


    @ApiModelProperty("spring bean名称") 
    @NotBlank(message = "spring bean名称不能为空值")
    private String beanName;

    @ApiModelProperty("方法名") 
    @NotBlank(message = "方法名不能为空值")
    private String methodName;

    @ApiModelProperty("参数") 
    @NotBlank(message = "参数不能为空值")
    private String params;

    @ApiModelProperty("cron表达式") 
    @NotBlank(message = "cron表达式不能为空值")
    private String cronExpression;

    @ApiModelProperty("任务状态  0：正常  1：暂停") 
    @NotBlank(message = "任务状态  0：正常  1：暂停不能为空值")
    private String status;

    @ApiModelProperty("备注") 
    @NotBlank(message = "备注不能为空值")
    private String remark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") @NotNull(message = "创建时间不能为空值")
    private Date createTime;
}
