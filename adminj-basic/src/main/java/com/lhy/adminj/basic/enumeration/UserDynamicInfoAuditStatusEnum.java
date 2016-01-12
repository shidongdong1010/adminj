package com.lhy.adminj.basic.enumeration;

/**
 * 状态枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserDynamicInfoAuditStatusEnum {

    /** 待审核 **/
    W("W", "待审核"),

    /** 审核通过 **/
    P("P", "审核通过"),

    /** 审核拒绝 **/
    D("D", "审核拒绝"),

	;

	private String code;
	private String desc;

    UserDynamicInfoAuditStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserDynamicInfoAuditStatusEnum getByCode(String code) {
        for (UserDynamicInfoAuditStatusEnum enumObj : UserDynamicInfoAuditStatusEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserDynamicInfoAuditStatusEnum getByDesc(String desc) {
        for (UserDynamicInfoAuditStatusEnum enumObj : UserDynamicInfoAuditStatusEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}