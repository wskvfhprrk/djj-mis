package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

    
  
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:18
*/
@ApiModel("定位信息上报PageDto")
@Data
public class  ReportSitePageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;


    @ApiModelProperty(value ="用户编号")
    private String userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="上报时间",example = "2000-12-12 10:10:10")
    private Date reportTime;

    @ApiModelProperty(value ="经度")
    private Double longitude;

    @ApiModelProperty(value ="纬度")
    private Double latitude;
}
