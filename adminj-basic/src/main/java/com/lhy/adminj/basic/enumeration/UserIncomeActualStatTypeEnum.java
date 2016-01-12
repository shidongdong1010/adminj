package com.lhy.adminj.basic.enumeration;

/**
 * 类型枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserIncomeActualStatTypeEnum {

    /** 个人 **/
    P("P", "个人"),

    /** 组合 **/
    G("G", "组合"),

	;

	private String code;
	private String desc;

    UserIncomeActualStatTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserIncomeActualStatTypeEnum getByCode(String code) {
        for (UserIncomeActualStatTypeEnum enumObj : UserIncomeActualStatTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserIncomeActualStatTypeEnum getByDesc(String desc) {
        for (UserIncomeActualStatTypeEnum enumObj : UserIncomeActualStatTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}