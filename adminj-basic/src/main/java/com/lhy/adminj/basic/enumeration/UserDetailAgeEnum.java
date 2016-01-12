package com.lhy.adminj.basic.enumeration;

/**
 * @author 
 * @version $v: 1.0.0, $Id:UserDetailAgeEnum.java, $time:2015/9/17 18:57 Exp $
 */
public enum UserDetailAgeEnum {

    A("1", "18以下"),
    B("2", "18-25"),
    C("3", "25-35"),
    D("4", "35-45"),
    E("5", "45-65"),
    F("6", "65以上");

    private String code;

    private String desc;

    private UserDetailAgeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserDetailAgeEnum getByCode(String code) {
        for (UserDetailAgeEnum enumObj : UserDetailAgeEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserDetailAgeEnum getByDesc(String desc) {
        for (UserDetailAgeEnum enumObj : UserDetailAgeEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }

}