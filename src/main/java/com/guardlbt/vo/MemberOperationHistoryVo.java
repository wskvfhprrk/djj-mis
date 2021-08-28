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
@ApiModel("会员操作记录历史实体类")
@Data
public class MemberOperationHistoryVo {

    @ApiModelProperty(value="")
    private Long id;

    @ApiModelProperty(value="编号")
    private String memberId;

    @ApiModelProperty(value="操作类型")
    private String operationId;

    @ApiModelProperty(value="操作说明")
    private String relationInfo;

    @ApiModelProperty(value="详细信息")
    private String detail;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="",example = "2001-10-10 11:11:11")
    private Date createTime;
}
