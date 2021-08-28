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
@ApiModel("定位信息上报实体类")
@Data
public class ReportSiteUpdateDto {

    @ApiModelProperty("用户编号") 
    @NotBlank(message = "用户编号不能为空值")    private String userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("上报时间") @NotNull(message = "上报时间不能为空值")
    private Date reportTime;

    @ApiModelProperty("经度") @NotNull(message = "经度不能为空值")
    private Double longitude;

    @ApiModelProperty("纬度") @NotNull(message = "纬度不能为空值")
    private Double latitude;
}
