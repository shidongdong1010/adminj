package com.lhy.adminj.basic.resultcode;

import com.lhy.common.lang.result.ResultCode;

/**
 * 动态信息操作出现错误时的错误码枚举
 * @author SDD
 * @version $v: 1.0.0, $time:2015/10/12 14:00 Exp $
 */
public enum DynamicResultCode implements ResultCode {
    /** 成功 */
    SUCCESS(200, "SUCCESS"),

    /** 系统错误 */
    SYSTEM_ERROR(500, "SYSTEM_ERROR"),

    /** 签名异常 */
    SIGN_ERROR(500, "SIGN_ERROR"),

    /** 未登陆 */
    TOKEN_IS_BLANK(50001,"TOKEN_IS_BLANK"),

    ;

    private String errorCode;

    private int    statusCode;

    DynamicResultCode(int statusCode, String errorCode) {
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

}
