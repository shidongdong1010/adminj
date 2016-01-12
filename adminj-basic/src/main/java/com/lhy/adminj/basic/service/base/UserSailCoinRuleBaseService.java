package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserSailCoinRule;

/**
 * 航币奖励规则表(除登录)Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserSailCoinRuleBaseService {

	public void save(UserSailCoinRule userSailCoinRule);
	
	public void update(UserSailCoinRule userSailCoinRule);

	public void modify(UserSailCoinRule userSailCoinRule);

	public void delete(Long ruleId);

	public void batchSave(List<UserSailCoinRule> list);

    public void batchUpdate(List<UserSailCoinRule> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param ruleId 规则ID
	 * @return UserSailCoinRule
	 */
	public UserSailCoinRule findById(Long ruleId);

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @return List
	 */
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule);

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userSailCoinRule
	 * @return Long
	 */
	public Long count(UserSailCoinRule userSailCoinRule);
}
