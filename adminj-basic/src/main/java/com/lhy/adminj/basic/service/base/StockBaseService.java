package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.Stock;

/**
 * 股票表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface StockBaseService {

	public void save(Stock stock);
	
	public void update(Stock stock);

	public void modify(Stock stock);

	public void delete(Long stockId);

	public void batchSave(List<Stock> list);

    public void batchUpdate(List<Stock> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param stockId 股票表主键
	 * @return Stock
	 */
	public Stock findById(Long stockId);

	/**
	 * 根据对象查询
	 * @param stock
	 * @return List
	 */
	public List<Stock> find(Stock stock);

	/**
	 * 根据对象查询
	 * @param stock
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Stock> find(Stock stock, String[][] orders);

	/**
	 * 根据对象查询
	 * @param stock
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Stock> find(Stock stock, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param stock
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Stock> find(Stock stock, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param stock
	 * @return Long
	 */
	public Long count(Stock stock);
}
