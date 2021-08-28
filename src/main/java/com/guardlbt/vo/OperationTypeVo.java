package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
  
  
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:18
*/
@ApiModel("操作类型实体类")
@Data
public class OperationTypeVo {

    @ApiModelProperty(value ="操作类型")
    private String operationId;

    @ApiModelProperty(value ="操作说明")
    private String name;
}
