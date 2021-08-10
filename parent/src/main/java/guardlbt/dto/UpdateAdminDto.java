package guardlbt.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateAdminDto {
    private String phone;

    private String password;

    private String imei;

    private Integer islock;

    private Date createtime;

    private Date updatetime;
}
