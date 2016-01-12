package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.UserSailCoinRuleLoginBaseService;
import com.lhy.adminj.basic.dao.UserSailCoinRuleLoginDao;

import com.lhy.adminj.basic.model.UserSailCoinRuleLogin;

/**
 * 登录航币奖励规则表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinRuleLoginBaseServiceImpl implements UserSailCoinRuleLoginBaseService{
	@Autowired
	protected UserSailCoinRuleLoginDao userSailCoinRuleLoginDao;

	@Override
	public void save(UserSailCoinRuleLogin userSailCoinRuleLogin) {
		userSailCoinRuleLoginDao.save(userSailCoinRuleLogin);
	}
	
	@Override
	public void update(UserSailCoinRuleLogin userSailCoinRuleLogin) {
		userSailCoinRuleLoginDao.update(userSailCoinRuleLogin);
	}

	@Override
	public void modify(UserSailCoinRuleLogin userSailCoinRuleLogin) {
		userSailCoinRuleLoginDao.modify(userSailCoinRuleLogin);
	}

	@Override
	public void delete(Long ruleId){
		userSailCoinRuleLoginDao.delete(ruleId);
	}

	@Override
	public void batchSave(List<UserSailCoinRuleLogin> list){
		userSailCoinRuleLoginDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<UserSailCoinRuleLogin> list){
		userSailCoinRuleLoginDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		userSailCoinRuleLoginDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param ruleId 规则ID
	 * @return UserSailCoinRuleLogin
	 */
	public UserSailCoinRuleLogin findById(Long ruleId){
		return userSailCoinRuleLoginDao.findById(ruleId);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @return List
	 */
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin){
		return userSailCoinRuleLoginDao.find(userSailCoinRuleLogin);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, String[][] orders){
		return userSailCoinRuleLoginDao.find(userSailCoinRuleLogin, orders);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, Long offset, Long rows){
		return userSailCoinRuleLoginDao.find(userSailCoinRuleLogin, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, String[][] orders, Long offset, Long rows){
    	return userSailCoinRuleLoginDao.find(userSailCoinRuleLogin, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param userSailCoinRuleLogin
	 * @return Long
	 */
	public Long count(UserSailCoinRuleLogin userSailCoinRuleLogin){
		return userSailCoinRuleLoginDao.count(userSailCoinRuleLogin);
	}
}