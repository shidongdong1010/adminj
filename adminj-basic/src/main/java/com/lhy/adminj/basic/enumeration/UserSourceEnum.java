package com.lhy.adminj.basic.enumeration;

/**
 * 注册来源枚举(用户表)
 *
 * @author Wufan
 * @version $v: 1.0.0, $Id:UserEnum.java, $time:2015-09-16 Exp $
 *
 */
public enum UserSourceEnum {

	SAIL("0", "领航员"), 
	QQ("1", "QQ"), 
	WECHAT("2", "微信"),
	WEIBO("3", "新浪微博");
	
	private String code;

	private String desc;

	private UserSourceEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static UserSourceEnum getByCode(String code) {
		for (UserSourceEnum enumObj : UserSourceEnum.values()) {
			if (enumObj.getCode().equals(code)) {
				return enumObj;
			}
		}
		return null;
	}

	public static UserSourceEnum getByDesc(String desc) {
		for (UserSourceEnum enumObj : UserSourceEnum.values()) {
			if (enumObj.getDesc().equals(desc)) {
				return enumObj;
			}
		}
		return null;
	}

}