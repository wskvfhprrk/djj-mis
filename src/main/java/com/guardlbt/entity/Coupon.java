package com.guardlbt.entity;

import java.util.Date;

public class Coupon {
    private Long couponId;

    private Integer couponStatus;

    private Date createTime;

    private Date updateTime;

    private String recyUser;

    private String couponEncrypt;

    private String couponManualcode;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Integer getCouponStatus() {
        return couponStatus;
    }

    public void setCouponStatus(Integer couponStatus) {
        this.couponStatus = couponStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRecyUser() {
        return recyUser;
    }

    public void setRecyUser(String recyUser) {
        this.recyUser = recyUser == null ? null : recyUser.trim();
    }

    public String getCouponEncrypt() {
        return couponEncrypt;
    }

    public void setCouponEncrypt(String couponEncrypt) {
        this.couponEncrypt = couponEncrypt == null ? null : couponEncrypt.trim();
    }

    public String getCouponManualcode() {
        return couponManualcode;
    }

    public void setCouponManualcode(String couponManualcode) {
        this.couponManualcode = couponManualcode == null ? null : couponManualcode.trim();
    }
}