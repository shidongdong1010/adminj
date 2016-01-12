package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.StockActual;

/**
 * 股票时段表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface StockActualBaseService {

	public void save(StockActual stockActual);
	
	public void update(StockActual stockActual);

	public void modify(StockActual stockActual);

	public void delete(Long actualStockId);

	public void batchSave(List<StockActual> list);

    public void batchUpdate(List<StockActual> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param actualStockId 股票表主键
	 * @return StockActual
	 */
	public StockActual findById(Long actualStockId);

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @return List
	 */
	public List<StockActual> find(StockActual stockActual);

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<StockActual> find(StockActual stockActual, String[][] orders);

	/**
	 * 根据对象查询
	 * @param stockActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockActual> find(StockActual stockActual, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockActual> find(StockActual stockActual, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param stockActual
	 * @return Long
	 */
	public Long count(StockActual stockActual);
}
