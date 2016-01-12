package com.lhy.adminj.basic.resultcode;

import com.lhy.common.lang.result.ResultCode;

/**
 * ${table.comment}枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UResourceResultCode implements ResultCode {

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

    UResourceResultCode(int statusCode, String errorCode) {
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
