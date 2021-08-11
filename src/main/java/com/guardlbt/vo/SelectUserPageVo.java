package com.guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 16:54:21
 */
@Data
public class SelectUserPageVo {
    
    @ApiModelProperty("用户id")
    private String userId;
    
    @ApiModelProperty("部门Id")
    private Integer deptId;
    
    @ApiModelProperty("用户名")
    private String username;
    
    @ApiModelProperty("真实姓名")
    private String realName;
    
    @ApiModelProperty("邮件地址")
    private String email;
    
    @ApiModelProperty("手机号")
    private String phone;
    
    @ApiModelProperty("地址")
    private String address;
    
    @ApiModelProperty("账户类别：1_公司；2_商家；3_即开票;4回收渠道")
    private Integer userType;
    
    @ApiModelProperty("备注")
    private String remark;

    private Integer status;
}
