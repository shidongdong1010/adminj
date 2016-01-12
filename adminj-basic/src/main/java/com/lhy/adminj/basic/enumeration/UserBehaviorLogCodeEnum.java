package com.lhy.adminj.basic.enumeration;

/**
 * 行为代码枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserBehaviorLogCodeEnum {

    A("1", "登陆"),
    B("2", "跟买"),
    C("3", "晒单"),
    D("4", "说说"),
    E("5", "评论"),
    F("6", "转发"),
    G("7", "打赏"),
    H("8", "打开APP"),
	;

	private String code;
	private String desc;

    UserBehaviorLogCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserBehaviorLogCodeEnum getByCode(String code) {
        for (UserBehaviorLogCodeEnum enumObj : UserBehaviorLogCodeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserBehaviorLogCodeEnum getByDesc(String desc) {
        for (UserBehaviorLogCodeEnum enumObj : UserBehaviorLogCodeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}