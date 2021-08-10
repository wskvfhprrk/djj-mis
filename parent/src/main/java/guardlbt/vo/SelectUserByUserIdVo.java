package guardlbt.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * Created by 代码自动生成.
 * 时间:2019-03-27 16:54:21
 */
@Data
public class SelectUserByUserIdVo {

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

    @ApiModelProperty("账户类别：1_公司；2_商家；3_即开票")
    private Integer userType;

    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("roleIds")
    private List<Integer> roleIds;

    private Integer status;
}
