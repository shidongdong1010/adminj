package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserStockPosition;

/**
 * 股票持仓表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserStockPositionBaseDao {

	public void save(UserStockPosition userStockPosition);
	
	public void update(UserStockPosition userStockPosition);

	public void modify(UserStockPosition userStockPosition);

	public void delete(Long positionId);

	public void batchSave(List<UserStockPosition> list);

    public void batchUpdate(List<UserStockPosition> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param positionId 股票持仓ID
	 * @return UserStockPosition
	 */
	public UserStockPosition findById(Long positionId);

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @return List
	 */
	public List<UserStockPosition> find(UserStockPosition userStockPosition);

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserStockPosition> find(UserStockPosition userStockPosition, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userStockPosition
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStockPosition> find(UserStockPosition userStockPosition, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userStockPosition
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStockPosition> find(UserStockPosition userStockPosition, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userStockPosition
	 * @return Long
	 */
	public Long count(UserStockPosition userStockPosition);
}
