package com.guardlbt.common.exception;

import com.guardlbt.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author 何建哲
 * @date 2019/3/2 9:02
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof ResultException) {
            ResultException resultException = (ResultException) e;
            return Result.error(resultException.getRet(), resultException.getMsg());
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            List<String> list = bindException.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return Result.error(400, list.toString());
        }else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            List<String> list = methodArgumentNotValidException.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return Result.error(400, list.toString());
        } else {
            //打印出来
            log.error(e.getMessage());
            e.printStackTrace();
            return Result.error(-1, "程序异常，请联系管理员！");
        }
    }
}
