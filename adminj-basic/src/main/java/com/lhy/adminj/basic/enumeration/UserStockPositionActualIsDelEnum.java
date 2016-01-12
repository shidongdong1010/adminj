package com.lhy.adminj.basic.enumeration;

/**
 * 逻辑删除标志枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserStockPositionActualIsDelEnum {

    /** 不删除 **/
    N("n", "不删除"),

    /** 删除 **/
    Y("y", "删除"),

	;

	private String code;
	private String desc;

    UserStockPositionActualIsDelEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserStockPositionActualIsDelEnum getByCode(String code) {
        for (UserStockPositionActualIsDelEnum enumObj : UserStockPositionActualIsDelEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserStockPositionActualIsDelEnum getByDesc(String desc) {
        for (UserStockPositionActualIsDelEnum enumObj : UserStockPositionActualIsDelEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}