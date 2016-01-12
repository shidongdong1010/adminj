package com.lhy.adminj.basic.enumeration;

/**
 * 是否启用枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum CoinConvertGoodIsEnableEnum {

    /** 启用 **/
    Y(0L, "启用"),

    /** 下架 **/
    N(1L, "下架"),

	;

	private Long code;
	private String desc;

    CoinConvertGoodIsEnableEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CoinConvertGoodIsEnableEnum getByCode(Long code) {
        for (CoinConvertGoodIsEnableEnum enumObj : CoinConvertGoodIsEnableEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static CoinConvertGoodIsEnableEnum getByDesc(String desc) {
        for (CoinConvertGoodIsEnableEnum enumObj : CoinConvertGoodIsEnableEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}