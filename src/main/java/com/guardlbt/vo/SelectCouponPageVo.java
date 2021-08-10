package com.guardlbt.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SelectCouponPageVo {
    private String couponId;

    private Integer couponBatchId;

    private Integer couponStatus;

    private Date createTime;

    private Date updateTime;

    private String recyUser;

    private String transactionNumber;
}
