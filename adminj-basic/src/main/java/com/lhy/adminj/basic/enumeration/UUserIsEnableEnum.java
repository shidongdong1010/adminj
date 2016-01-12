package com.lhy.adminj.basic.enumeration;

/**
 * 是否禁用枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UUserIsEnableEnum {

    /** 否 **/
    N(0L, "否"),

    /** 是 **/
    Y(1L, "是"),

	;

	private Long code;
	private String desc;

    UUserIsEnableEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UUserIsEnableEnum getByCode(Long code) {
        for (UUserIsEnableEnum enumObj : UUserIsEnableEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UUserIsEnableEnum getByDesc(String desc) {
        for (UUserIsEnableEnum enumObj : UUserIsEnableEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}