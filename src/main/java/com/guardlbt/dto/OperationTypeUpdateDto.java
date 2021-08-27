package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
  
  
/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@ApiModel("操作类型实体类")
@Data
public class OperationTypeUpdateDto {

    @ApiModelProperty("操作类型") 
    @NotBlank(message = "操作类型不能为空值")     private String operationId;

    @ApiModelProperty("操作说明") 
    @NotBlank(message = "操作说明不能为空值")     private String name;
}