package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserSailCoinRuleBaseService;
import com.lhy.adminj.basic.dao.UserSailCoinRuleDao;

import com.lhy.adminj.basic.model.UserSailCoinRule;

/**
 * 航币奖励规则表(除登录)Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinRuleBaseServiceImpl implements UserSailCoinRuleBaseService{
	@Autowired
	protected UserSailCoinRuleDao userSailCoinRuleDao;

	@Override
	public void save(UserSailCoinRule userSailCoinRule) {
		userSailCoinRuleDao.save(userSailCoinRule);
	}
	
	@Override
	public void update(UserSailCoinRule userSailCoinRule) {
		userSailCoinRuleDao.update(userSailCoinRule);
	}

	@Override
	public void modify(UserSailCoinRule userSailCoinRule) {
		userSailCoinRuleDao.modify(userSailCoinRule);
	}

	@Override
	public void delete(Long ruleId){
		userSailCoinRuleDao.delete(ruleId);
	}

	@Override
	public void batchSave(List<UserSailCoinRule> list){
		userSailCoinRuleDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserSailCoinRule> list){
		userSailCoinRuleDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userSailCoinRuleDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param ruleId 规则ID
	 * @return UserSailCoinRule
	 */
	public UserSailCoinRule findById(Long ruleId){
		return userSailCoinRuleDao.findById(ruleId);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @return List
	 */
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule){
		return userSailCoinRuleDao.find(userSailCoinRule);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, String[][] orders){
		return userSailCoinRuleDao.find(userSailCoinRule, orders);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, Long offset, Long rows){
		return userSailCoinRuleDao.find(userSailCoinRule, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, String[][] orders, Long offset, Long rows){
    	return userSailCoinRuleDao.find(userSailCoinRule, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userSailCoinRule
	 * @return Long
	 */
	public Long count(UserSailCoinRule userSailCoinRule){
		return userSailCoinRuleDao.count(userSailCoinRule);
	}
}