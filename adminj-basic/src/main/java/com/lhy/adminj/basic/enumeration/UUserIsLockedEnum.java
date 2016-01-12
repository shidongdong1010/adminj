package com.lhy.adminj.basic.enumeration;

/**
 * 是否锁定枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UUserIsLockedEnum {

    /** 正常 **/
    NORMAL(0L, "正常"),

    /** 锁定 **/
    LOCKED(1L, "锁定"),

	;

	private Long code;
	private String desc;

    UUserIsLockedEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UUserIsLockedEnum getByCode(Long code) {
        for (UUserIsLockedEnum enumObj : UUserIsLockedEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UUserIsLockedEnum getByDesc(String desc) {
        for (UUserIsLockedEnum enumObj : UUserIsLockedEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}