package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserIncomeHisStat;

/**
 * 用户历史收益统计Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserIncomeHisStatBaseService {

	public void save(UserIncomeHisStat userIncomeHisStat);
	
	public void update(UserIncomeHisStat userIncomeHisStat);

	public void modify(UserIncomeHisStat userIncomeHisStat);

	public void delete(Long hisStatId);

	public void batchSave(List<UserIncomeHisStat> list);

    public void batchUpdate(List<UserIncomeHisStat> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param hisStatId 历史统计ID
	 * @return UserIncomeHisStat
	 */
	public UserIncomeHisStat findById(Long hisStatId);

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @return List
	 */
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat);

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userIncomeHisStat
	 * @return Long
	 */
	public Long count(UserIncomeHisStat userIncomeHisStat);
}
