package com.lhy.adminj.basic.enumeration;

/**
 * 是否启用枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum CoinConvertRuleIsEnableEnum {

    /** 启用 **/
    Y(0L, "启用"),

    /** 禁用 **/
    N(1L, "禁用"),

	;

	private Long code;
	private String desc;

    CoinConvertRuleIsEnableEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CoinConvertRuleIsEnableEnum getByCode(Long code) {
        for (CoinConvertRuleIsEnableEnum enumObj : CoinConvertRuleIsEnableEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static CoinConvertRuleIsEnableEnum getByDesc(String desc) {
        for (CoinConvertRuleIsEnableEnum enumObj : CoinConvertRuleIsEnableEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}