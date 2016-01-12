package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.StockHis;

/**
 * 股票历史表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface StockHisBaseDao {

	public void save(StockHis stockHis);
	
	public void update(StockHis stockHis);

	public void modify(StockHis stockHis);

	public void delete(Long hisStockId);

	public void batchSave(List<StockHis> list);

    public void batchUpdate(List<StockHis> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param hisStockId 股票表主键
	 * @return StockHis
	 */
	public StockHis findById(Long hisStockId);

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @return List
	 */
	public List<StockHis> find(StockHis stockHis);

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<StockHis> find(StockHis stockHis, String[][] orders);

	/**
	 * 根据对象查询
	 * @param stockHis
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockHis> find(StockHis stockHis, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockHis> find(StockHis stockHis, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param stockHis
	 * @return Long
	 */
	public Long count(StockHis stockHis);
}
