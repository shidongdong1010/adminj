package com.lhy.adminj.basic.enumeration;

/**
 * 是否显示枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum ProvinceValidFlagEnum {

    /** 显示 **/
    Y("Y", "显示"),

    /** 不显示 **/
    N("N", "不显示"),

	;

	private String code;
	private String desc;

    ProvinceValidFlagEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ProvinceValidFlagEnum getByCode(String code) {
        for (ProvinceValidFlagEnum enumObj : ProvinceValidFlagEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static ProvinceValidFlagEnum getByDesc(String desc) {
        for (ProvinceValidFlagEnum enumObj : ProvinceValidFlagEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}