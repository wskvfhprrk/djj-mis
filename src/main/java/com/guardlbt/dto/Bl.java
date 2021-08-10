package com.guardlbt.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Bl implements Serializable {

    private String siteId;
    //黑名单数据库id
    private Integer blacklistId;
    //当天错误数
    private int number;
    //总次数
    private int countNumber;
    //失败超过10次的总天数
    private int countDay;
    //
    private int lock;
}
