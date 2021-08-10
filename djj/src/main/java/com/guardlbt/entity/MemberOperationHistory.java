package com.guardlbt.entity;

import java.util.Date;

public class MemberOperationHistory {
    private Long id;

    private String memberId;

    private String operationId;

    private String relationInfo;

    private Date createTime;

    private String detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
    }

    public String getRelationInfo() {
        return relationInfo;
    }

    public void setRelationInfo(String relationInfo) {
        this.relationInfo = relationInfo == null ? null : relationInfo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}