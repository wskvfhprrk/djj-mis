package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
     
     
/**
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:38
*/
@ApiModel("商店部门管理实体类")
@Data
public class SysDeptPageVo {

    @ApiModelProperty(value="")
    private Integer deptId;

    @ApiModelProperty(value="上级部门ID，一级部门为0")
    private Long parentId;

    @ApiModelProperty(value="部门名称")
    private String name;

    @ApiModelProperty(value="排序")
    private Integer orderNum;

    @ApiModelProperty(value="是否删除  -1：已删除  0：正常")
    private Integer delFlag;
}
