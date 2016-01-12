package com.lhy.adminj.basic.enumeration;

/**
 * 打赏分类枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserSailCoinUseFlowAwardClassEnum {

    /** 查看说说 **/
    A1("1", "查看说说"),

    /** 查看晒单 **/
    A2("2", "查看晒单"),

    /** 跟买 **/
    A3("3", "跟买"),

	;

	private String code;
	private String desc;

    UserSailCoinUseFlowAwardClassEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserSailCoinUseFlowAwardClassEnum getByCode(String code) {
        for (UserSailCoinUseFlowAwardClassEnum enumObj : UserSailCoinUseFlowAwardClassEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserSailCoinUseFlowAwardClassEnum getByDesc(String desc) {
        for (UserSailCoinUseFlowAwardClassEnum enumObj : UserSailCoinUseFlowAwardClassEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}