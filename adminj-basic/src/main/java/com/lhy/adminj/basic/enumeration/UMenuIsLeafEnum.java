package com.lhy.adminj.basic.enumeration;

/**
 * 是否叶子节点枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UMenuIsLeafEnum {

    /** 否 **/
    N(0L, "否"),

    /** 是 **/
    Y(1L, "是"),

	;

	private Long code;
	private String desc;

    UMenuIsLeafEnum(Long code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UMenuIsLeafEnum getByCode(Long code) {
        for (UMenuIsLeafEnum enumObj : UMenuIsLeafEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UMenuIsLeafEnum getByDesc(String desc) {
        for (UMenuIsLeafEnum enumObj : UMenuIsLeafEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}