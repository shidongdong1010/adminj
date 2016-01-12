package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.StockUser;

/**
 * 证券开户表302001Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface StockUserBaseDao {

	public void save(StockUser stockUser);
	
	public void update(StockUser stockUser);

	public void delete(Long stockUserId);

	/**
	 * 根据主键查询
	 * @param stockUserId 主键
	 * @return StockUser
	 */
	public StockUser findById(Long stockUserId);

	/**
	 * 根据对象查询
	 * @param stockUser
	 * @return List
	 */
	public List<StockUser> find(StockUser stockUser);

	/**
	 * 根据对象查询
	 * @param stockUser
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockUser> find(StockUser stockUser, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param stockUser
	 * @return Long
	 */
	public Long count(StockUser stockUser);
}
