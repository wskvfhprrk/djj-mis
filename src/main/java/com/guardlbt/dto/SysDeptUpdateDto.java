package com.guardlbt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import lombok.Data;
     
     
/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:14
*/
@ApiModel("商店部门管理实体类")
@Data
public class SysDeptUpdateDto {

    @ApiModelProperty(value ="") @NotNull(message = "不能为空值")
     private Integer deptId;

    @ApiModelProperty(value ="上级部门ID，一级部门为0") @NotNull(message = "上级部门ID，一级部门为0不能为空值")
     private Long parentId;

    @ApiModelProperty(value ="部门名称") 
    @NotBlank(message = "部门名称不能为空值")     private String name;

    @ApiModelProperty(value ="排序") @NotNull(message = "排序不能为空值")
     private Integer orderNum;

    @ApiModelProperty(value ="是否删除  -1：已删除  0：正常") @NotNull(message = "是否删除  -1：已删除  0：正常不能为空值")
     private Integer delFlag;
}
