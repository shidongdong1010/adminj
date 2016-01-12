package com.lhy.adminj.basic.enumeration;

/**
 * 动态类型枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserDynamicInfoTypeEnum {

    /** 晒图 **/
    S("S", "晒图"),

    /** 说说 **/
    T("T", "说说"),

    /** 提问 **/
    Q("Q", "提问"),

    /** 转发 **/
    F("F", "转发"),

	;

	private String code;
	private String desc;

    UserDynamicInfoTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserDynamicInfoTypeEnum getByCode(String code) {
        for (UserDynamicInfoTypeEnum enumObj : UserDynamicInfoTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserDynamicInfoTypeEnum getByDesc(String desc) {
        for (UserDynamicInfoTypeEnum enumObj : UserDynamicInfoTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}