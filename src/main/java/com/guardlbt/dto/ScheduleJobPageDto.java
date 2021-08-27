package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

        
        
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@ApiModel("定时任务PageDto")
@Data
public class  ScheduleJobPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;


    @ApiModelProperty("spring bean名称") 
    private String beanName;

    @ApiModelProperty("方法名") 
    private String methodName;

    @ApiModelProperty("参数") 
    private String params;

    @ApiModelProperty("cron表达式") 
    private String cronExpression;

    @ApiModelProperty("任务状态  0：正常  1：暂停") 
    private String status;

    @ApiModelProperty("备注") 
    private String remark;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间") 
    private Date createTime;
}
