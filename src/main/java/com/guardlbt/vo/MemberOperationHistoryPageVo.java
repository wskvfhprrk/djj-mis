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
@ApiModel("会员操作记录历史实体类")
@Data
public class MemberOperationHistoryPageVo {

    @ApiModelProperty("") 
    private Long id;

    @ApiModelProperty("编号") 
    private String memberId;

    @ApiModelProperty("操作类型") 
    private String operationId;

    @ApiModelProperty("操作说明") 
    private String relationInfo;

    @ApiModelProperty("详细信息") 
    private String detail;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("") 
    private Date createTime;
}
