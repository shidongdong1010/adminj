package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserIncomeActualStat;

/**
 * 用户收益实时统计Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserIncomeActualStatBaseService {

	public void save(UserIncomeActualStat userIncomeActualStat);
	
	public void update(UserIncomeActualStat userIncomeActualStat);

	public void modify(UserIncomeActualStat userIncomeActualStat);

	public void delete(Long actualStatId);

	public void batchSave(List<UserIncomeActualStat> list);

    public void batchUpdate(List<UserIncomeActualStat> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param actualStatId 实时统计ID
	 * @return UserIncomeActualStat
	 */
	public UserIncomeActualStat findById(Long actualStatId);

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @return List
	 */
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat);

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userIncomeActualStat
	 * @return Long
	 */
	public Long count(UserIncomeActualStat userIncomeActualStat);
}
