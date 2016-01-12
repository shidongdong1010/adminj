package com.lhy.adminj.basic.enumeration;

/**
 * 是否是评价回复黑名单枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserBacklistReplyBlacklistEnum {

    /** 是 **/
    Y("Y", "是"),

    /** 否 **/
    N("N", "否"),

	;

	private String code;
	private String desc;

    UserBacklistReplyBlacklistEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserBacklistReplyBlacklistEnum getByCode(String code) {
        for (UserBacklistReplyBlacklistEnum enumObj : UserBacklistReplyBlacklistEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserBacklistReplyBlacklistEnum getByDesc(String desc) {
        for (UserBacklistReplyBlacklistEnum enumObj : UserBacklistReplyBlacklistEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}