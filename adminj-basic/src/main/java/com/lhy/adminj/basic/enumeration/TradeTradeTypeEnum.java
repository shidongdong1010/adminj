package com.lhy.adminj.basic.enumeration;

/**
 * 交易类型枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum TradeTradeTypeEnum {

    /** 买 **/
    B("B", "买"),

    /** 卖 **/
    S("S", "卖"),

	;

	private String code;
	private String desc;

    TradeTradeTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static TradeTradeTypeEnum getByCode(String code) {
        for (TradeTradeTypeEnum enumObj : TradeTradeTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static TradeTradeTypeEnum getByDesc(String desc) {
        for (TradeTradeTypeEnum enumObj : TradeTradeTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}