package com.xingcheng.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ReturnCodeEnum {
    /**操作失败**/
    RC999(999,"操作XXX失败"),
    /**操作成功**/
    RC200(200,"success"),
    /**服务降级**/
    RC201(201,"服务开启降级保护,请稍后再试!"),
    /**热点参数限流**/
    RC202(202,"热点参数限流,请稍后再试!"),
    /**系统规则不满足**/
    RC203(203,"系统规则不满足要求,请稍后再试!"),
    /**授权规则不通过**/
    RC204(204,"授权规则不通过,请稍后再试!"),
    RC208(208,"用户未登录!"),
    /**access_denied**/
    RC403(403,"无访问权限,请联系管理员授予权限"),
    /**access_denied**/
    RC401(401,"匿名用户访问无权限资源时的异常"),
    RC404(404,"404页面找不到的异常"),
    /**服务异常**/
    RC500(500,"系统异常，请稍后重试"),
    RC375(375,"数学运算异常，请稍后重试"),

    INVALID_TOKEN(2001,"访问令牌不合法"),
    ACCESS_DENIED(2003,"没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED(1001,"客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002,"用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式"),
    USERNAME_INEXISTENCE(1005,"用户名或密码错误"),
    BUSINESS_ERROR(1004,"业务逻辑异常"),
    VERIFICATION_CODE_INEXISTENCE(1006,"验证码失败"),
    VERIFICATION_CODE_ERROR(1007,"验证码错误"),
    REPEAT_ROLE_NAME_ERROR(1008,"角色名称发生重复")
    ;

    private Integer code;
    private String msg;
    public static ReturnCodeEnum findEnumByCode (Integer code) {
        return Arrays.stream(ReturnCodeEnum.values()).filter(a -> code.equals(a.code)).findFirst().orElse(null);
    }

}
