package com.lhy.adminj.basic.enumeration;

/**
 * 类型枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserIncomeHisStatTypeEnum {

    /** 月 **/
    M("M", "月"),

    /** 天 **/
    D("D", "天"),

	;

	private String code;
	private String desc;

    UserIncomeHisStatTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserIncomeHisStatTypeEnum getByCode(String code) {
        for (UserIncomeHisStatTypeEnum enumObj : UserIncomeHisStatTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserIncomeHisStatTypeEnum getByDesc(String desc) {
        for (UserIncomeHisStatTypeEnum enumObj : UserIncomeHisStatTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}