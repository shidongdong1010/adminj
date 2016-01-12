package com.lhy.adminj.basic.enumeration;

/**
 * 是否晒图黑名单枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserBacklistShowBlacklistEnum {

    /** 是 **/
    Y("Y", "是"),

    /** 否 **/
    N("N", "否"),

	;

	private String code;
	private String desc;

    UserBacklistShowBlacklistEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserBacklistShowBlacklistEnum getByCode(String code) {
        for (UserBacklistShowBlacklistEnum enumObj : UserBacklistShowBlacklistEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserBacklistShowBlacklistEnum getByDesc(String desc) {
        for (UserBacklistShowBlacklistEnum enumObj : UserBacklistShowBlacklistEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}