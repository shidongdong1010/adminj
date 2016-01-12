package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserStockPositionActual;

/**
 * 股票时段持仓表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserStockPositionActualBaseDao {

	public void save(UserStockPositionActual userStockPositionActual);
	
	public void update(UserStockPositionActual userStockPositionActual);

	public void modify(UserStockPositionActual userStockPositionActual);

	public void delete(Long actualPositionId);

	public void batchSave(List<UserStockPositionActual> list);

    public void batchUpdate(List<UserStockPositionActual> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param actualPositionId 股票持仓ID
	 * @return UserStockPositionActual
	 */
	public UserStockPositionActual findById(Long actualPositionId);

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @return List
	 */
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual);

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userStockPositionActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStockPositionActual> find(UserStockPositionActual userStockPositionActual, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userStockPositionActual
	 * @return Long
	 */
	public Long count(UserStockPositionActual userStockPositionActual);
}
