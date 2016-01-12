package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.impl.UserSailCoinRuleBaseServiceImpl;
import com.lhy.adminj.basic.service.UserSailCoinRuleService;

import org.springframework.stereotype.Service;

import com.lhy.adminj.basic.model.UserSailCoinRule;

/**
 * 航币奖励规则表(除登录)Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UserSailCoinRuleServiceImpl extends UserSailCoinRuleBaseServiceImpl implements UserSailCoinRuleService {

	@Override
	public void updateCoin(String types) {
		
		userSailCoinRuleDao.updateCoin(types);
	}

	@Override
	public List<UserSailCoinRule> findAll() {
		return userSailCoinRuleDao.findAll();
	}

	/**
	 * 查询有效的配置
	 * @param userSailCoinRule
	 * @param orders
	 * @param offset
	 * @param rows
	 * @return
	 */
	@Override
	public List<UserSailCoinRule> findEffective(UserSailCoinRule userSailCoinRule,
			String[][] orders, Long offset, Long rows){
		return userSailCoinRuleDao.findEffective(userSailCoinRule, orders, offset, rows);
	}
}
