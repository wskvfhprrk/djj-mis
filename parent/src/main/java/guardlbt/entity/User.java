package guardlbt.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private String userId;


    private String username;

    private String password;

    private String salt;

    private String realName;

    private String email;

    private String phone;

    private String address;

    private Integer userType;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private String token;



}