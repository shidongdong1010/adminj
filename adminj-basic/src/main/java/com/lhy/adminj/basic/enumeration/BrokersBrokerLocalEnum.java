package com.lhy.adminj.basic.enumeration;

/**
 * 券商所属地：枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum BrokersBrokerLocalEnum {

    /** 上海（SH） **/
    A1("1", "上海（SH）"),

    /** 深圳（SZ） **/
    A2("2", "深圳（SZ）"),

    /** 其他 **/
    A3("3", "其他"),

	;

	private String code;
	private String desc;

    BrokersBrokerLocalEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BrokersBrokerLocalEnum getByCode(String code) {
        for (BrokersBrokerLocalEnum enumObj : BrokersBrokerLocalEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static BrokersBrokerLocalEnum getByDesc(String desc) {
        for (BrokersBrokerLocalEnum enumObj : BrokersBrokerLocalEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}