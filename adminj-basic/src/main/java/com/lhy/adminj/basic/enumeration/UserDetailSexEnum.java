package com.lhy.adminj.basic.enumeration;

/**
 * 性别枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserDetailSexEnum {

    /** 男 **/
    M("M", "男"),

    /** 女 **/
    F("F", "女"),

    /** 保密 **/
    S("S", "保密"),

	;

	private String code;
	private String desc;

    UserDetailSexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserDetailSexEnum getByCode(String code) {
        for (UserDetailSexEnum enumObj : UserDetailSexEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserDetailSexEnum getByDesc(String desc) {
        for (UserDetailSexEnum enumObj : UserDetailSexEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}