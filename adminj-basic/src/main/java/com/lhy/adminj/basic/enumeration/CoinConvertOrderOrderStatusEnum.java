package com.lhy.adminj.basic.enumeration;

/**
 * 订单状态枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum CoinConvertOrderOrderStatusEnum {

    /** 成功 **/
    A0("0", "成功"),

    /** 失败 **/
    A1("1", "失败"),

	;

	private String code;
	private String desc;

    CoinConvertOrderOrderStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CoinConvertOrderOrderStatusEnum getByCode(String code) {
        for (CoinConvertOrderOrderStatusEnum enumObj : CoinConvertOrderOrderStatusEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static CoinConvertOrderOrderStatusEnum getByDesc(String desc) {
        for (CoinConvertOrderOrderStatusEnum enumObj : CoinConvertOrderOrderStatusEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}