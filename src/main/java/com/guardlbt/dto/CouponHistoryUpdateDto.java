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
* 时间:2021-08-28 11:42:14
*/
@ApiModel("代金券历史实体类")
@Data
public class CouponHistoryUpdateDto {

    @ApiModelProperty(value ="编号（每张代金券唯一编号）") @NotNull(message = "编号（每张代金券唯一编号）不能为空值")
     private Long id;

    @ApiModelProperty(value ="编号（每张代金券唯一编号）") 
    @NotBlank(message = "编号（每张代金券唯一编号）不能为空值")     private String couponNo;

    @ApiModelProperty(value ="发出方（id+名称）") 
    @NotBlank(message = "发出方（id+名称）不能为空值")     private String fromName;

    @ApiModelProperty(value ="接收方（id+名称）") 
    @NotBlank(message = "接收方（id+名称）不能为空值")     private String toName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="创建时间",example = "2000-12-12 10:10:10") @NotNull(message = "创建时间不能为空值")
     private Date createTime;

    @ApiModelProperty(value ="备注") 
    @NotBlank(message = "备注不能为空值")     private String remark;
}
