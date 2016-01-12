package com.lhy.adminj.basic.enumeration;

/**
 * 获取方式枚举
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public enum UserSailCoinObtainFlowObtainWayEnum {

    /** 注册 **/
    A1("1", "注册"),

    /** 推荐好友下载 **/
    A2("2", "推荐好友下载"),

    /** 完善信息 **/
    A3("3", "完善信息"),

    /** 连续登录 **/
    A4("4", "连续登录"),

    /** 操作 **/
    A5("5", "操作"),

    /** 发表说说 **/
    A6("6", "发表说说"),

    /** 晒单 **/
    A7("7", "晒单"),

    /** 上传头像 **/
    A8("8", "上传头像"),

    /** 实名认证 **/
    A9("9", "实名认证"),

    /** 绑定银行卡 **/
    A10("10", "绑定银行卡"),

	;

	private String code;
	private String desc;

    UserSailCoinObtainFlowObtainWayEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static UserSailCoinObtainFlowObtainWayEnum getByCode(String code) {
        for (UserSailCoinObtainFlowObtainWayEnum enumObj : UserSailCoinObtainFlowObtainWayEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public static UserSailCoinObtainFlowObtainWayEnum getByDesc(String desc) {
        for (UserSailCoinObtainFlowObtainWayEnum enumObj : UserSailCoinObtainFlowObtainWayEnum.values()) {
            if (enumObj.getDesc().equals(desc)) {
                return enumObj;
            }
        }
        return null;
    }
}