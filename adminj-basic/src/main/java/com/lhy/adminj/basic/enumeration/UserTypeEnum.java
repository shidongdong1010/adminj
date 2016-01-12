package com.lhy.adminj.basic.enumeration;

/**
 * 会员类型枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserTypeEnum {

    /** 内部 **/
    LHY("0", "内部"),

    /** 牛人 **/
    CATTLE("1", "牛人"),

    /** 一般投资者 **/
    INVESTOR("2", "一般投资者"),

	;

	private String code;
	private String desc;

    UserTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserTypeEnum getByCode(String code) {
        for (UserTypeEnum enumObj : UserTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserTypeEnum getByDesc(String desc) {
        for (UserTypeEnum enumObj : UserTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}