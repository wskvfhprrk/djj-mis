package com.guardlbt.dto;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 16:54:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    @NotBlank(message = "userId不能为空")
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("部门Id")
    private Integer deptId;
    @NotBlank(message = "username不能为空")
    @ApiModelProperty("用户名")
    private String username;
    @NotBlank(message = "realName不能为空")
    @ApiModelProperty("真实姓名")
    private String realName;
    @NotBlank(message = "email不能为空")
    @ApiModelProperty("邮件地址")
    private String email;
    @NotBlank(message = "phone不能为空")
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("地址")
    private String address;
    @NotNull(message = "userType不能为空")
    @ApiModelProperty("账户类别：1_公司；2_商家；3_即开票;4回收渠道")
    private Integer userType;
    @ApiModelProperty("备注")
    private String remark;
    @NotNull(message = "status不能为空")
    @ApiModelProperty("账户状态：0_正常;1_异常:2_锁定")
    private Integer status;
    @ApiModelProperty("角色id")
    private List<Integer> roleIds;
}
