package com.guardlbt.common.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 何建哲
 * @date 2018/12/11 15:06
 */
@Data
public final class ResultErrorCode<T> implements Serializable {
    private Integer ret;
    private String msg;
    private Boolean success;
    private T content;

    public static final ResultErrorCode TOKEN_ERROR = new ResultErrorCode(401, "token过期");
    public static final ResultErrorCode NO_OAUTH = new ResultErrorCode(401, "无权访问");
    public static final ResultErrorCode USSR_BLACK = new ResultErrorCode(402, "此号码已被拉入黑名单,请联系系统管理员");
    public static final ResultErrorCode IMEI_ERROR = new ResultErrorCode(403, "不能更换手机登陆");
    public static final ResultErrorCode USER_NONE = new ResultErrorCode(404, "用户不存在");
    public static final ResultErrorCode USER_LOCK = new ResultErrorCode(406, "账户被锁定");
    public static final ResultErrorCode USER_PASSWORD_ERROR = new ResultErrorCode(407, "用户名和密码错误");
    public static final ResultErrorCode OLD_PASSWORD_ERROR = new ResultErrorCode(408, "原密码不正确");
    public static final ResultErrorCode USER_NOT_EXIST = new ResultErrorCode(408, "用户不存在");
    public static final ResultErrorCode MERCHANT_NOT_ALLOW = new ResultErrorCode(109, "无权限生成该批次电子券");
    public static final ResultErrorCode BATCH_NOT_ALLOW = new ResultErrorCode(110, "该批次不允许再生成电子券");
    public static final ResultErrorCode BATCH_PRODUCT_FAIL = new ResultErrorCode(111, "该批次生成电子券失败");
    public static final ResultErrorCode DUPLICATE_USER = new ResultErrorCode(409, "该用户已经绑定其他商户,如果仍然需要绑定该用户，必须先删除那个商户");
    public static final ResultErrorCode SAVE_FAIL = new ResultErrorCode(410, "新增失败");
    public static final ResultErrorCode DELETE_FAIL = new ResultErrorCode(411, "删除失败");
    public static final ResultErrorCode UPDATE_FAIL = new ResultErrorCode(412, "修改失败");
    public static final ResultErrorCode SELECT_FAIL = new ResultErrorCode(413, "查询失败");
    public static final ResultErrorCode DELETE_FAIL_DEPT = new ResultErrorCode(414, "修改失败");
    public static final ResultErrorCode DELETE_FAIL_ROLE = new ResultErrorCode(415, "删除失败");
    public static final ResultErrorCode DUPLICATE_KEY = new ResultErrorCode(416, "主外键冲突");
//        public static final ResultErrorCode VALIDATECODE_PAST = new ResultErrorCode(417, "验证码过期");
    public static final ResultErrorCode VALIDATECODE_ERROR = new ResultErrorCode(418, "验证码错误");
    public static final ResultErrorCode IO_EXCEPTION = new ResultErrorCode(419, "IO异常");
    public static final ResultErrorCode FILE_NO_FIND = new ResultErrorCode(420, "文件未找到");
    public static final ResultErrorCode DELETE_ERROR = new ResultErrorCode(421, "不能删除，数据已经初使用");
    public static final ResultErrorCode BLACKLIST_ERROR = new ResultErrorCode(422, "黑名单次数据当天超限，限定12小时");
    public static final ResultErrorCode SITE_LOCK = new ResultErrorCode(423, "站点被锁定，请管理员解锁");
    public static final ResultErrorCode COUPON_BATCH_ERROR = new ResultErrorCode(424, "已经生产的电子券不能删除和修改");
    public static final ResultErrorCode USERNAME_ERROR = new ResultErrorCode(425, "用户名已经使用，请更换用户名");
    public static final ResultErrorCode USERNAME_ERROR2 = new ResultErrorCode(425, "不能修改用户名");
    public static final ResultErrorCode DELETE_OWEN_ERROR = new ResultErrorCode(426, "自己不能删除自己");
    public static final ResultErrorCode CREATE_COUPON_ERROR = new ResultErrorCode(427, "只有所属商家才能够生成电子券");

    public static final ResultErrorCode TIME_NONE = new ResultErrorCode(501, "没有时间参数time");
    public static final ResultErrorCode TIME_OUT = new ResultErrorCode(502, "访问超时");
    public static final ResultErrorCode SIGN_NONE = new ResultErrorCode(503, "sign签名不存在");
    public static final ResultErrorCode SIGN_ERROR = new ResultErrorCode(504, "sign签名不正确");




    public ResultErrorCode(int ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }
}
