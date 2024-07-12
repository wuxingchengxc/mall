package com.xingcheng.exception;

import com.xingcheng.domain.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

// 给所有的控制类增加统一的处理器
@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error();
    }

    //自定义异常处理
    @ExceptionHandler(PublicException.class)
    @ResponseBody
    public Result error(PublicException e) {
        return Result.error(e.getReturnCodeEnum().getMsg(), e.getReturnCodeEnum().getCode());
    }

}