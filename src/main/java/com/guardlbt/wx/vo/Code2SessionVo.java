package com.guardlbt.wx.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 登陆验证获取code2Session返回值
 */
@Data
public class Code2SessionVo implements Serializable {
    /**
     * 用户唯一标识
     */
    private String openid;
    /**
     * 会话密钥
     */
    private String session_key;
    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID 机制说明。
     */
    private String unionid;
    /**
     * 错误码
     */
    private Integer errcode;
    /**
     * 错误信息
     */
    private String errmsg;
}
