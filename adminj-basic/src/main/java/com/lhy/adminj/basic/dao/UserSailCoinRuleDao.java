package com.lhy.adminj.basic.dao;

import java.util.List;

import com.lhy.adminj.basic.dao.base.UserSailCoinRuleBaseDao;
import com.lhy.adminj.basic.model.UserSailCoinRule;

/**
 * 航币奖励规则表(除登录)Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserSailCoinRuleDao extends UserSailCoinRuleBaseDao {

	/** 此处写一些算定义的方法，不要修改Base的方法 **/
	
	public void updateCoin(String types);
	
	public List<UserSailCoinRule> findAll();

	/**
	 * 查询有效的配置
	 * @param userSailCoinRule
	 * @param orders
	 * @param offset
	 * @param rows
	 * @return
	 */
	List<UserSailCoinRule> findEffective(UserSailCoinRule userSailCoinRule,
			String[][] orders, Long offset, Long rows);
}
