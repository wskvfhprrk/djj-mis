package com.guardlbt.dto;

import javax.validation.constraints.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 16:54:21
 */
@Data
public class SelectUserPageDto {
@NotNull(message = "pageNumber不能为空") @ApiModelProperty("查询页码（默认值为1）")
    private Integer pageNumber;
@NotNull(message = "pageSize不能为空") @ApiModelProperty("每页多少条（默认值为30）")
    private Integer pageSize;
@ApiModelProperty("用户名（模糊）")
    private String username;
@ApiModelProperty("真实姓名（模糊）")
    private String realName;
@ApiModelProperty("邮件地址")
    private String email;
@ApiModelProperty("手机号（模糊）")
    private String phone;
@ApiModelProperty("账户类别：1_公司；2_商家；3_即开票;4回收渠道")
    private Integer userType;
}
