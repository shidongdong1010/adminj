package com.lhy.adminj.basic.enumeration;

/**
 * @author Administrator
 * @version $v: 1.0.0, $Id:${FILE}, $time:2015/9/17 18:46 Exp $
 */
public enum UserDetailCompanyDutiesEnum {

    CHAIRMAN("1", "董事长"),
    PRESIDENT("2", "总裁"),
    GENERAL("3", "总经理"),
    DEPARTMENT("4", "部门经理"),
    STAFF("5", "员工");

    private String code;

    private String desc;

    private UserDetailCompanyDutiesEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserDetailCompanyDutiesEnum getByCode(String code) {
        for (UserDetailCompanyDutiesEnum enumObj : UserDetailCompanyDutiesEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserDetailCompanyDutiesEnum getByDesc(String desc) {
        for (UserDetailCompanyDutiesEnum enumObj : UserDetailCompanyDutiesEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }

}
