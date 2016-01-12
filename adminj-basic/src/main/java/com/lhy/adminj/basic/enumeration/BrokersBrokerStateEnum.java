package com.lhy.adminj.basic.enumeration;

/**
 * 券商接入状态：枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum BrokersBrokerStateEnum {

    /** 正常 **/
    A1("1", "正常"),

    /** 终止 **/
    A2("2", "终止"),

    /** 以外 **/
    A3("3", "以外"),

	;

	private String code;
	private String desc;

    BrokersBrokerStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BrokersBrokerStateEnum getByCode(String code) {
        for (BrokersBrokerStateEnum enumObj : BrokersBrokerStateEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static BrokersBrokerStateEnum getByDesc(String desc) {
        for (BrokersBrokerStateEnum enumObj : BrokersBrokerStateEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}