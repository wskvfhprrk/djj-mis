package com.guardlbt.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SelectAdminPageVo {
    private String phone;

    private String password;

    private String imei;

    private Integer islock;

    private Date createtime;

    private Date updatetime;
}
