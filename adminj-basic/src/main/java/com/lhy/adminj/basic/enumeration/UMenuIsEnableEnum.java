package com.lhy.adminj.basic.enumeration;

/**
 * 是否禁用枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UMenuIsEnableEnum {

    /** 否 **/
    A0("0", "否"),

    /** 是 **/
    A1("1", "是"),

	;

	private String code;
	private String desc;

    UMenuIsEnableEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UMenuIsEnableEnum getByCode(String code) {
        for (UMenuIsEnableEnum enumObj : UMenuIsEnableEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UMenuIsEnableEnum getByDesc(String desc) {
        for (UMenuIsEnableEnum enumObj : UMenuIsEnableEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}