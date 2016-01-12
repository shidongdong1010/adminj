package com.lhy.adminj.basic.enumeration;

/**
 * 可以评论的人枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserDynamicInfoCommentRangeEnum {

    /** 所有人 **/
    A1("1", "所有人"),

    /** 跟投者 **/
    A2("2", "跟投者"),

    /** 我的好友 **/
    A3("3", "我的好友"),

	;

	private String code;
	private String desc;

    UserDynamicInfoCommentRangeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserDynamicInfoCommentRangeEnum getByCode(String code) {
        for (UserDynamicInfoCommentRangeEnum enumObj : UserDynamicInfoCommentRangeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserDynamicInfoCommentRangeEnum getByDesc(String desc) {
        for (UserDynamicInfoCommentRangeEnum enumObj : UserDynamicInfoCommentRangeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}