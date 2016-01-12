package com.lhy.adminj.basic.enumeration;

/**
 * 删除标记枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UUserDeleteFlagEnum {

    /** 正常 **/
    A0("0", "正常"),

    /** 删除 **/
    A1("1", "删除"),

	;

	private String code;
	private String desc;

    UUserDeleteFlagEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UUserDeleteFlagEnum getByCode(String code) {
        for (UUserDeleteFlagEnum enumObj : UUserDeleteFlagEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UUserDeleteFlagEnum getByDesc(String desc) {
        for (UUserDeleteFlagEnum enumObj : UUserDeleteFlagEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}