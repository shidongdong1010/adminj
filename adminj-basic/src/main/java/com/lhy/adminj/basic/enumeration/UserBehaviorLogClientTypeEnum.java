package com.lhy.adminj.basic.enumeration;

/**
 * 客户端类型枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserBehaviorLogClientTypeEnum {

    /** andorid **/
    A0("0", "andorid"),

    /** ios **/
    A1("1", "ios"),

	;

	private String code;
	private String desc;

    UserBehaviorLogClientTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserBehaviorLogClientTypeEnum getByCode(String code) {
        for (UserBehaviorLogClientTypeEnum enumObj : UserBehaviorLogClientTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserBehaviorLogClientTypeEnum getByDesc(String desc) {
        for (UserBehaviorLogClientTypeEnum enumObj : UserBehaviorLogClientTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}