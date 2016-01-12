package com.lhy.adminj.basic.enumeration;

/**
 * 组合类型
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum MyGroupTypeEnum {

    /** 自建 **/
    SELF("1", "自建"),

    /** 跟买 **/
    VOTE("2", "跟买"),

	;

	private String code;
	private String desc;

    MyGroupTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static MyGroupTypeEnum getByCode(String code) {
        for (MyGroupTypeEnum enumObj : MyGroupTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static MyGroupTypeEnum getByDesc(String desc) {
        for (MyGroupTypeEnum enumObj : MyGroupTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}