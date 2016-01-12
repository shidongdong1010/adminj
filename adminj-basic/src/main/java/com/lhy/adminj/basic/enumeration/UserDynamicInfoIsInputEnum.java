package com.lhy.adminj.basic.enumeration;

/**
 * 晒图是否录入枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserDynamicInfoIsInputEnum {

    /** 是 **/
    Y("y", "是"),

    /** 否 **/
    N("N", "否"),

	;

	private String code;
	private String desc;

    UserDynamicInfoIsInputEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserDynamicInfoIsInputEnum getByCode(String code) {
        for (UserDynamicInfoIsInputEnum enumObj : UserDynamicInfoIsInputEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserDynamicInfoIsInputEnum getByDesc(String desc) {
        for (UserDynamicInfoIsInputEnum enumObj : UserDynamicInfoIsInputEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}