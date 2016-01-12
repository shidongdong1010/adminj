package com.lhy.adminj.basic.enumeration;

/**
 * 平台使用状态:枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum BrokersBrokerAppStateEnum {

    /** 正常 **/
    A1("1", "正常"),

    /** 取消 **/
    A2("2", "取消"),

	;

	private String code;
	private String desc;

    BrokersBrokerAppStateEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BrokersBrokerAppStateEnum getByCode(String code) {
        for (BrokersBrokerAppStateEnum enumObj : BrokersBrokerAppStateEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static BrokersBrokerAppStateEnum getByDesc(String desc) {
        for (BrokersBrokerAppStateEnum enumObj : BrokersBrokerAppStateEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}