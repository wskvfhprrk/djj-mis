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
* 时间:2021-08-27 13:42:56
*/
@ApiModel("定时任务日志实体类")
@Data
public class ScheduleJobLogSaveDto {

    @ApiModelProperty(value ="任务id",example = "")
    @NotNull(message = "任务id不能为空值")
    private Long jobId;

    @ApiModelProperty(value ="spring bean名称",example = "")
    @NotBlank(message = "spring bean名称不能为空值")
    private String beanName;

    @ApiModelProperty(value ="方法名",example = "")
    @NotBlank(message = "方法名不能为空值")
    private String methodName;

    @ApiModelProperty(value ="参数",example = "")
    @NotBlank(message = "参数不能为空值")
    private String params;

    @ApiModelProperty(value ="任务状态    0：成功    1：失败",example = "")
    @NotBlank(message = "任务状态    0：成功    1：失败不能为空值")
    private String status;

    @ApiModelProperty(value ="失败信息",example = "")
    @NotBlank(message = "失败信息不能为空值")
    private String error;

    @ApiModelProperty(value ="耗时(单位：毫秒)",example = "")
    @NotNull(message = "耗时(单位：毫秒)不能为空值")
    private Integer times;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10")
    @NotNull(message = "创建时间不能为空值")
    private Date createTime;
}
