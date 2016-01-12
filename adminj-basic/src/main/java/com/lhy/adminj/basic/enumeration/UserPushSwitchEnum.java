package com.lhy.adminj.basic.enumeration;

/**
 * 推送设置枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserPushSwitchEnum {

    /** 关 **/
    A0("0", "关"),

    /** 开 **/
    A1("1", "开"),

	;

	private String code;
	private String desc;

    UserPushSwitchEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserPushSwitchEnum getByCode(String code) {
        for (UserPushSwitchEnum enumObj : UserPushSwitchEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserPushSwitchEnum getByDesc(String desc) {
        for (UserPushSwitchEnum enumObj : UserPushSwitchEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}