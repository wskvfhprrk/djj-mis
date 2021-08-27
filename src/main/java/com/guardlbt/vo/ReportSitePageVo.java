package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
    
  
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-26 16:20:27
*/
@ApiModel("定位信息上报实体类")
@Data
public class ReportSitePageVo {

    @ApiModelProperty("用户编号") 
    private String userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("上报时间") 
    private Date reportTime;

    @ApiModelProperty("经度") 
    private Double longitude;

    @ApiModelProperty("纬度") 
    private Double latitude;
}
