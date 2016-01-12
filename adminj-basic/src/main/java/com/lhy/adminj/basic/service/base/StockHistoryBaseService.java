package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.StockHistory;

/**
 * 股票历史表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface StockHistoryBaseService {

	public void save(StockHistory stockHistory);
	
	public void update(StockHistory stockHistory);

	public void delete(Long stockHistoryId);

	/**
	 * 根据主键查询
	 * @param stockHistoryId 股票历史表主键
	 * @return StockHistory
	 */
	public StockHistory findById(Long stockHistoryId);

	/**
	 * 根据对象查询
	 * @param stockHistory
	 * @return List
	 */
	public List<StockHistory> find(StockHistory stockHistory);

	/**
	 * 根据对象查询
	 * @param stockHistory
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockHistory> find(StockHistory stockHistory, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param stockHistory
	 * @return Long
	 */
	public Long count(StockHistory stockHistory);
}
