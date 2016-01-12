package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserSailCoinRuleLogin;

/**
 * 登录航币奖励规则表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserSailCoinRuleLoginBaseService {

	public void save(UserSailCoinRuleLogin userSailCoinRuleLogin);
	
	public void update(UserSailCoinRuleLogin userSailCoinRuleLogin);

	public void modify(UserSailCoinRuleLogin userSailCoinRuleLogin);

	public void delete(Long ruleId);

	public void batchSave(List<UserSailCoinRuleLogin> list);

    public void batchUpdate(List<UserSailCoinRuleLogin> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param ruleId 规则ID
	 * @return UserSailCoinRuleLogin
	 */
	public UserSailCoinRuleLogin findById(Long ruleId);

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @return List
	 */
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin);

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userSailCoinRuleLogin
	 * @return Long
	 */
	public Long count(UserSailCoinRuleLogin userSailCoinRuleLogin);
}
