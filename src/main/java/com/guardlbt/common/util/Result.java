package com.guardlbt.common.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 何建哲
 * @date 2018/12/12 7:43
 */
@Data
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "是否成功返回结果，true表示成功，false表示不成功",example = "true")
    private Boolean success;
    @ApiModelProperty(value = "返回代码code",example = "10000")
    private Integer ret;
    @ApiModelProperty(value = "服务器返回提示信息",example = "ok")
    private String msg;
    @ApiModelProperty(value = "返回业务数据，当ret==10000时才会有，如果为对象返回{}，数组返回[]")
    private T content;

    public Result() {
    }

    public Result(Boolean success, int ret, String msg) {
        this.success = success;
        this.ret = ret;
        this.msg = msg;
    }

    public Result(Boolean success, int ret, String msg, T content) {
        this.success = success;
        this.ret = ret;
        this.msg = msg;
        this.content = content;
    }

    public static Result error(ResultErrorCode resultErrorCode) {
        return new Result(false, resultErrorCode.getRet(), resultErrorCode.getMsg(), null);
    }

    public static Result error(ResultErrorCode resultErrorCode, String str) {
        return new Result(false, resultErrorCode.getRet(), String.format(resultErrorCode.getMsg(), str), null);
    }

    public static Result error(int ret, String msg) {
        return new Result(false, ret, msg, null);
    }

    public static Result error(int code) {
        return new Result(false, code, "error", null);
    }

    public static Result ok() {
        return new Result(true, 10000, "ok", "{}");
    }

    public static <T> Result ok(T content) {
//        if (null == content) {
//            return new Result(true, 10000, "ok", content);
//        }
        //处理返回结果为集合是空值，统一处理为null
//        Class<?> aClass = content.getClass();
//        if (aClass == ArrayList.class) {
//            List list = (List) content;
//            if (list.size() == 0) {
//                content = [];
//            }
//        }
        return new Result(true, 10000, "ok", content);
    }


}
