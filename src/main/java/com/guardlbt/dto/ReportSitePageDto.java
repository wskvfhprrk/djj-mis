package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

    
  
import java.util.Date;
/**
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
@ApiModel("定位信息上报PageDto")
@Data
public class  ReportSitePageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;

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
