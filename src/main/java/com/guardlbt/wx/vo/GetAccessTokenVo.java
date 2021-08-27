package com.guardlbt.wx.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetAccessTokenVo implements Serializable {
    /**
     * 获取到的凭证
     */
    private String access_token;
    /**
     * 凭证有效时间，单位：秒。目前是7200秒之内的值。
     */
    private Long expires_in;
    /**
     * 错误码
     */
    private Integer errcode;
    /**
     * 错误信息
     */
    private String errmsg;
}
