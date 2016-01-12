package com.lhy.adminj.basic.resultcode;

import com.lhy.common.lang.result.ResultCode;

/**
 * ${table.comment}枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UUserResultCode implements ResultCode {

   /** 成功 */
    SUCCESS(200, "SUCCESS"),

    /** 系统错误 */
    SYSTEM_ERROR(500, "SYSTEM_ERROR"),

    /** 签名异常 */
    SIGN_ERROR(500, "SIGN_ERROR"),

    /** 未登陆 */
    TOKEN_IS_BLANK(50001,"TOKEN_IS_BLANK"),

    /** 登陆的用户名不存在 **/
    LOGIN_USER_NAME_NOT_EXISTS(5001, "LOGIN_USER_NAME_NOT_EXISTS"),

    /** 登陆的用户名已存在 **/
    LOGIN_USER_NAME_ESISTS(5001, "LOGIN_USER_NAME_ESISTS"),

    /** 帐户锁定 **/
    LOGIN_ACCOUNT_LOCKED(5001, "LOGIN_ACCOUNT_LOCKED"),

    /** 密码错误 **/
    LOGIN_PASSWORD_ERROR(5001, "LOGIN_PASSWORD_ERROR"),

    /** 密码错误 **/
    LOGIN_PASSWORD_ERROR2(5001, "LOGIN_PASSWORD_ERROR2"),

    /** 帐户已禁用 **/
    LOGIN_ACCOUNT_DISABLED(5001, "LOGIN_ACCOUNT_DISABLED"),

    /** 密码已过期 **/
    LOGIN_CREDENTIAL_EXPIRED(5001, "LOGIN_CREDENTIAL_EXPIRED"),
    ;

    private String errorCode;

    private int    statusCode;

    UUserResultCode(int statusCode, String errorCode) {
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
