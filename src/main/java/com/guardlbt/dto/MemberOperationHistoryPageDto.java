package com.guardlbt.dto;

import org.springframework.format.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.*;

      
      
import java.util.Date;

/**
* Created by 代码自动生成.
* 时间:2021-08-28 11:42:17
*/
@ApiModel("会员操作记录历史PageDto")
@Data
public class  MemberOperationHistoryPageDto {

    @NotNull(message = "pageNumber不能为空")
    @ApiModelProperty(value = "查询页码（默认值为1）",example = "1")
    private Integer pageNumber;

    @NotNull(message = "pageSize不能为空")
    @ApiModelProperty(value = "每页多少条（默认值为30）",example = "1")
    private Integer pageSize;



    @ApiModelProperty(value ="编号")
    private String memberId;

    @ApiModelProperty(value ="操作类型")
    private String operationId;

    @ApiModelProperty(value ="操作说明")
    private String relationInfo;

    @ApiModelProperty(value ="详细信息")
    private String detail;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value ="",example = "2000-12-12 10:10:10")
    private Date createTime;
}
