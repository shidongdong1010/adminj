package com.lhy.adminj.basic.enumeration;

/**
 * 币种枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserStockPositionCurrencyEnum {

    /** 人民币 **/
    CNY("CNY", "人民币"),

    /** 美元 **/
    USD("USD", "美元"),

    /** 欧元 **/
    EUR("EUR", "欧元"),

    /** 港币 **/
    HKD("HKD", "港币"),

    /** 英镑 **/
    GBP("GBP", "英镑"),

    /** 日元 **/
    JPY("JPY", "日元"),

    /** 韩元 **/
    KRW("KRW", "韩元"),

    /** 加元 **/
    CAD("CAD", "加元"),

    /** 澳元 **/
    AUD("AUD", "澳元"),

    /** 瑞郎 **/
    CHF("CHF", "瑞郎"),

    /** 新加坡元 **/
    SGD("SGD", "新加坡元"),

    /** 马来西亚币 **/
    MYR("MYR", "马来西亚币"),

    /** 印尼 **/
    IDR("IDR", "印尼"),

    /** 新西兰 **/
    NZD("NZD", "新西兰"),

    /** 越南 **/
    VND("VND", "越南"),

    /** 泰铢 **/
    THB("THB", "泰铢"),

    /** 菲律宾 **/
    PHP("PHP", "菲律宾"),

	;

	private String code;
	private String desc;

    UserStockPositionCurrencyEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserStockPositionCurrencyEnum getByCode(String code) {
        for (UserStockPositionCurrencyEnum enumObj : UserStockPositionCurrencyEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserStockPositionCurrencyEnum getByDesc(String desc) {
        for (UserStockPositionCurrencyEnum enumObj : UserStockPositionCurrencyEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}