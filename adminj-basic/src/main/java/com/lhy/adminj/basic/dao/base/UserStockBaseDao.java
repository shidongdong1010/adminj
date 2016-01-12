package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserStock;

/**
 * 自选股Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserStockBaseDao {

	public void save(UserStock userStock);
	
	public void update(UserStock userStock);

	public void delete(Long userId);

	/**
	 * 根据主键查询
	 * @param userId 平台用户
	 * @return UserStock
	 */
	public UserStock findById(Long userId);

	/**
	 * 根据对象查询
	 * @param userStock
	 * @return List
	 */
	public List<UserStock> find(UserStock userStock);

	/**
	 * 根据对象查询
	 * @param userStock
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserStock> find(UserStock userStock, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userStock
	 * @return Long
	 */
	public Long count(UserStock userStock);
}
