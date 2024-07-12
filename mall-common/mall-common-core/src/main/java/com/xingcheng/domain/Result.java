package com.xingcheng.domain;

import com.xingcheng.enums.ReturnCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private String message;
    private Integer code;
    private T data;
    private Long timestamp;

    public Result() {
        timestamp = System.currentTimeMillis();
    }

    public Result(String message, Integer code) {
        timestamp = System.currentTimeMillis();
        this.message = message;
        this.code = code;
    }

    public Result(String message, Integer code, T data) {
        timestamp = System.currentTimeMillis();
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static <T>Result<T> success (String message, Integer code, T data) {
        return new Result<>(message, code, data);
    }

    public static <T>Result<T> success (T data) {
        return success(ReturnCodeEnum.RC200.getMsg(), ReturnCodeEnum.RC200.getCode(),data);
    }

    public static <T>Result<T> success () {
        return success(ReturnCodeEnum.RC200.getMsg(), ReturnCodeEnum.RC200.getCode(), null);
    }

    public static <T>Result<T> error () {
        return error(ReturnCodeEnum.RC500.getMsg(), ReturnCodeEnum.RC500.getCode());
    }

    public static <T>Result<T> error (String message, Integer code) {
        return new Result<>(message, code);
    }

    public static <T>Result<T> error (ReturnCodeEnum returnCodeEnum) {
        return error(returnCodeEnum.getMsg(), returnCodeEnum.getCode());
    }



}
