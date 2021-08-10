package guardlbt.vo;

import lombok.Data;

@Data
public class LoginVo {
    private String userId;
    private Integer deptId;
    private String username;
    private String realName;
    private String email;
    private String phone;
    private String address;
    private Integer userType;
    private Integer status;
    private String remark;
    private String token;
}
