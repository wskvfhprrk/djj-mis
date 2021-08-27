package com.guardlbt.entity;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
  
  
  
/**
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
@ApiModel("操作类型实体类")
@Data
public class OperationType {

    @ApiModelProperty(value ="操作类型")
    private String operationId;

    @ApiModelProperty(value ="操作说明")
    private String name;
}
