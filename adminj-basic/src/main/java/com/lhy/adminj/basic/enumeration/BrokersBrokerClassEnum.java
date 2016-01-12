package com.lhy.adminj.basic.enumeration;

/**
 * 券商类型：枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum BrokersBrokerClassEnum {

    /** 证券经纪业务 **/
    A1("1", "证券经纪业务"),

    /** 证券投资咨询业务 **/
    A2("2", "证券投资咨询业务"),

    /** 与证券有关的财务顾问业务 **/
    A3("3", "与证券有关的财务顾问业务"),

    /** 证券承销与保荐业务 **/
    A4("4", "证券承销与保荐业务"),

    /** 证券自营业务 **/
    A5("5", "证券自营业务"),

    /** 证券资产管理业务 **/
    A6("6", "证券资产管理业务"),

    /** 其他证券业务 **/
    A7("7", "其他证券业务"),

	;

	private String code;
	private String desc;

    BrokersBrokerClassEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static BrokersBrokerClassEnum getByCode(String code) {
        for (BrokersBrokerClassEnum enumObj : BrokersBrokerClassEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static BrokersBrokerClassEnum getByDesc(String desc) {
        for (BrokersBrokerClassEnum enumObj : BrokersBrokerClassEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}