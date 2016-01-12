package com.lhy.adminj.basic.enumeration;

/**
 * 是否枚举
 *
 * @author wufan
 * @version 1.0
 */
public enum YesOrNoEnum {
	
	Y("Y", "是"),

	N("N", "否");

	private String code;

	private String desc;

	private YesOrNoEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

    public static YesOrNoEnum getByCode(String code) {
        for (YesOrNoEnum enumObj : YesOrNoEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
