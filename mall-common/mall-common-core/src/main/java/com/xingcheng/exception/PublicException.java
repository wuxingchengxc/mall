package com.xingcheng.exception;

import com.xingcheng.enums.ReturnCodeEnum;
import lombok.Data;

@Data
public class PublicException extends RuntimeException{

    private Integer code;
    private String message;
    /**
     * 所属模块
     */
    private String module;
    /**
     * 错误码对应的参数
     */
    private Object[] args;
    /**
     * 错误消息
     */
    private String defaultMessage;

    private ReturnCodeEnum returnCodeEnum;

    public PublicException(ReturnCodeEnum returnCodeEnum) {
        this.returnCodeEnum = returnCodeEnum;
        this.code = returnCodeEnum.getCode();
        this.message = returnCodeEnum.getMsg();
    }
    public PublicException(String module, Integer code, Object[] args, String defaultMessage) {
        this.module = module;
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

}
