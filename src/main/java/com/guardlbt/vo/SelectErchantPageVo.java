package com.guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 16:58:07
 */
@Data
public class SelectErchantPageVo {
    
    @ApiModelProperty("商家id")
    private String merchantId;
    
    @ApiModelProperty("用户名")
    private String username;
    
    @ApiModelProperty("密码")
    private String password;
    
    @ApiModelProperty("商家名称")
    private String merchantName;
    
    @ApiModelProperty("真实姓名")
    private String realName;
    
    @ApiModelProperty("邮件地址")
    private String email;
    
    @ApiModelProperty("手机号")
    private String phone;
    
    @ApiModelProperty("地址")
    private String address;
    
    @ApiModelProperty("账户类别：1_公司；2_商家；3_即开票")
    private Integer userType;
    
    @ApiModelProperty("用户id")
    private String userId;
    
    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("是否推送回收情况:1推送0不推送")
    private Integer sendStatus;

    @ApiModelProperty("推送地址：如果sendStatus==1时不能为空值")
    private String sendUrl;

}
