package com.lhy.adminj.basic.enumeration;

/**
 * 状态枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum CoinConvertOrderStatusEnum {

    /** 未确认 **/
    N(0L, "未确认"),

    /** 已确认 **/
    Y(1L, "已确认"),

	;

	private Long code;
	private String desc;

    CoinConvertOrderStatusEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CoinConvertOrderStatusEnum getByCode(Long code) {
        for (CoinConvertOrderStatusEnum enumObj : CoinConvertOrderStatusEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static CoinConvertOrderStatusEnum getByDesc(String desc) {
        for (CoinConvertOrderStatusEnum enumObj : CoinConvertOrderStatusEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}