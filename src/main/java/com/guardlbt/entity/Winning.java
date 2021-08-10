package com.guardlbt.entity;

import java.util.Date;

public class Winning {
    private String id;

    private String codeId;

    private String winningCode;

    private Integer isWinning;

    private Date fistTime;

    private Integer searchNumber;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId == null ? null : codeId.trim();
    }

    public String getWinningCode() {
        return winningCode;
    }

    public void setWinningCode(String winningCode) {
        this.winningCode = winningCode == null ? null : winningCode.trim();
    }

    public Integer getIsWinning() {
        return isWinning;
    }

    public void setIsWinning(Integer isWinning) {
        this.isWinning = isWinning;
    }

    public Date getFistTime() {
        return fistTime;
    }

    public void setFistTime(Date fistTime) {
        this.fistTime = fistTime;
    }

    public Integer getSearchNumber() {
        return searchNumber;
    }

    public void setSearchNumber(Integer searchNumber) {
        this.searchNumber = searchNumber;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}