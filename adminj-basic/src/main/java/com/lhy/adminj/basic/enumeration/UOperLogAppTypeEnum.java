package com.lhy.adminj.basic.enumeration;

/**
 * 业务类型枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UOperLogAppTypeEnum {

    /** 添加用户 **/
    A0("0", "添加用户"),

    /** 注销用户 **/
    A1("1", "注销用户"),

    /** 锁定用户 **/
    A2("2", "锁定用户"),

    /** 启用用户 **/
    A3("3", "启用用户"),

    /** 用户赋角色 **/
    A4("4", "用户赋角色"),

    /** 用户去角色 **/
    A5("5", "用户去角色"),

    /** 添加角色 **/
    A10("10", "添加角色"),

    /** 禁用角色 **/
    A11("11", "禁用角色"),

    /** 启用角色 **/
    A12("12", "启用角色"),

    /** 角色赋权限 **/
    A13("13", "角色赋权限"),

    /** 角色去权限 **/
    A14("14", "角色去权限"),

    /** 添加权限 **/
    A20("20", "添加权限"),

    /** 修改权限 **/
    A21("21", "修改权限"),

    /** 禁用权限 **/
    A22("22", "禁用权限"),

    /** 启用权限 **/
    A23("23", "启用权限"),

	;

	private String code;
	private String desc;

    UOperLogAppTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UOperLogAppTypeEnum getByCode(String code) {
        for (UOperLogAppTypeEnum enumObj : UOperLogAppTypeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UOperLogAppTypeEnum getByDesc(String desc) {
        for (UOperLogAppTypeEnum enumObj : UOperLogAppTypeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}