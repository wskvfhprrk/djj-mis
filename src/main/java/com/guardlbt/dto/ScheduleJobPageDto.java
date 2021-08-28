package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

        
        
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:19
*/
@ApiModel("定时任务PageDto")
@Data
public class  ScheduleJobPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



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
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10")
    private Date createTime;
}
