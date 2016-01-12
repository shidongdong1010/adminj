package com.lhy.adminj.basic.enumeration;

/**
 * 密码是否过期枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UUserIsExpiredEnum {

    /** 正常 **/
    N(0L, "正常"),

    /** 已过期 **/
    Y(1L, "已过期"),

	;

	private Long code;
	private String desc;

    UUserIsExpiredEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UUserIsExpiredEnum getByCode(Long code) {
        for (UUserIsExpiredEnum enumObj : UUserIsExpiredEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UUserIsExpiredEnum getByDesc(String desc) {
        for (UUserIsExpiredEnum enumObj : UUserIsExpiredEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}