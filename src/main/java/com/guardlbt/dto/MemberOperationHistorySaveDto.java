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
@ApiModel("会员操作记录历史实体类")
@Data
public class MemberOperationHistorySaveDto {

    @ApiModelProperty(value ="编号",example = "")
    @NotBlank(message = "编号不能为空值")
    private String memberId;

    @ApiModelProperty(value ="操作类型",example = "")
    @NotBlank(message = "操作类型不能为空值")
    private String operationId;

    @ApiModelProperty(value ="操作说明",example = "")
    @NotBlank(message = "操作说明不能为空值")
    private String relationInfo;

    @ApiModelProperty(value ="详细信息",example = "")
    @NotBlank(message = "详细信息不能为空值")
    private String detail;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="",example = "2000-12-12 10:10:10")
    @NotNull(message = "不能为空值")
    private Date createTime;
}
