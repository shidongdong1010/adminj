package com.lhy.adminj.basic.dao;

import java.util.List;

import com.lhy.adminj.basic.dao.base.UserSailCoinRuleLoginBaseDao;
import com.lhy.adminj.basic.model.UserSailCoinRuleLogin;

/**
 * 登录航币奖励规则表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserSailCoinRuleLoginDao extends UserSailCoinRuleLoginBaseDao {

	/** 此处写一些算定义的方法，不要修改Base的方法 **/
	
	void updateCoin();
	
	public List<UserSailCoinRuleLogin> findAll();
}
