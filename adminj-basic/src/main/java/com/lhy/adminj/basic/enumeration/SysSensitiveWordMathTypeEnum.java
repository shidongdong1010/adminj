package com.lhy.adminj.basic.enumeration;

/**
 * 匹配类型枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum SysSensitiveWordMathTypeEnum {

    MIN_MATH("1", "最小匹配"),
    /** 最大匹配 **/
    MAX_MATH("2", "最大匹配"),

	;

	private String code;
	private String desc;

    SysSensitiveWordMathTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static SysSensitiveWordMathTypeEnum getByCode(String code) {
        for (SysSensitiveWordMathTypeEnum enumObj : SysSensitiveWordMathTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static SysSensitiveWordMathTypeEnum getByDesc(String desc) {
        for (SysSensitiveWordMathTypeEnum enumObj : SysSensitiveWordMathTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}