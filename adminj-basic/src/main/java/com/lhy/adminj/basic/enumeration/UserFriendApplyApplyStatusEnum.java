package com.lhy.adminj.basic.enumeration;

/**
 * 申请状态枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserFriendApplyApplyStatusEnum {

    /** 待好友审核 **/
    W("W", "待好友审核"),

    /** 已添加 **/
    P("P", "已添加"),

    /** 删除 **/
    D("D", "删除"),

	;

	private String code;
	private String desc;

    UserFriendApplyApplyStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserFriendApplyApplyStatusEnum getByCode(String code) {
        for (UserFriendApplyApplyStatusEnum enumObj : UserFriendApplyApplyStatusEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserFriendApplyApplyStatusEnum getByDesc(String desc) {
        for (UserFriendApplyApplyStatusEnum enumObj : UserFriendApplyApplyStatusEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}