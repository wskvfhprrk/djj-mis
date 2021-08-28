package com.guardlbt.vo;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
    
  
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-28 13:20:39
*/
@ApiModel("定位信息上报实体类")
@Data
public class ReportSiteVo {

    @ApiModelProperty(value="用户编号")
    private String userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="上报时间",example = "2001-10-10 11:11:11")
    private Date reportTime;

    @ApiModelProperty(value="经度")
    private Double longitude;

    @ApiModelProperty(value="纬度")
    private Double latitude;
}
