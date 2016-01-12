package com.lhy.adminj.basic.enumeration;

/**
 * 可以查看的人枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserDynamicInfoSeeRangeEnum {

    /** 所有人 **/
    A1("1", "所有人"),

    /** 跟投者 **/
    A2("2", "跟投者"),

    /** 我的好友 **/
    A3("3", "我的好友"),

	;

	private String code;
	private String desc;

    UserDynamicInfoSeeRangeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserDynamicInfoSeeRangeEnum getByCode(String code) {
        for (UserDynamicInfoSeeRangeEnum enumObj : UserDynamicInfoSeeRangeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserDynamicInfoSeeRangeEnum getByDesc(String desc) {
        for (UserDynamicInfoSeeRangeEnum enumObj : UserDynamicInfoSeeRangeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}