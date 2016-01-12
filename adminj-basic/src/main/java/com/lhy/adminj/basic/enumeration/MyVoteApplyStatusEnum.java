package com.lhy.adminj.basic.enumeration;

/**
 * 申请状态枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum MyVoteApplyStatusEnum {

    /** 待审核 **/
    W("W", "待审核"),

    /** 同意 **/
    P("P", "同意"),

    /** 拒绝 **/
    D("D", "拒绝"),

	;

	private String code;
	private String desc;

    MyVoteApplyStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static MyVoteApplyStatusEnum getByCode(String code) {
        for (MyVoteApplyStatusEnum enumObj : MyVoteApplyStatusEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static MyVoteApplyStatusEnum getByDesc(String desc) {
        for (MyVoteApplyStatusEnum enumObj : MyVoteApplyStatusEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}