package com.lhy.adminj.basic.enumeration;

/**
 * 账号状态枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserStatusEnum {

    /** 正常 **/
    A0("0", "正常"),

    /** 锁定 **/
    A1("1", "锁定"),

    /** 已删除 **/
    A2("2", "已删除"),

	;

	private String code;
	private String desc;

    UserStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserStatusEnum getByCode(String code) {
        for (UserStatusEnum enumObj : UserStatusEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserStatusEnum getByDesc(String desc) {
        for (UserStatusEnum enumObj : UserStatusEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}