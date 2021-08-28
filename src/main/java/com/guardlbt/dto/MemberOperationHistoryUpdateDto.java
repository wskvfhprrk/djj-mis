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
* 时间:2021-08-28 13:20:39
*/
@ApiModel("会员操作记录历史实体类")
@Data
public class MemberOperationHistoryUpdateDto {

    @ApiModelProperty("") @NotNull(message = "不能为空值")
    private Long id;

    @ApiModelProperty("编号") 
    @NotBlank(message = "编号不能为空值")    private String memberId;

    @ApiModelProperty("操作类型") 
    @NotBlank(message = "操作类型不能为空值")    private String operationId;

    @ApiModelProperty("操作说明") 
    @NotBlank(message = "操作说明不能为空值")    private String relationInfo;

    @ApiModelProperty("详细信息") 
    @NotBlank(message = "详细信息不能为空值")    private String detail;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("") @NotNull(message = "不能为空值")
    private Date createTime;
}
