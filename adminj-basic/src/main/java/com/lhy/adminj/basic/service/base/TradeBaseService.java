package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.Trade;

/**
 * 交易记录表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface TradeBaseService {

	public void save(Trade trade);
	
	public void update(Trade trade);

	public void modify(Trade trade);

	public void delete(Long tradeId);

	public void batchSave(List<Trade> list);

    public void batchUpdate(List<Trade> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param tradeId 交易记录表主键
	 * @return Trade
	 */
	public Trade findById(Long tradeId);

	/**
	 * 根据对象查询
	 * @param trade
	 * @return List
	 */
	public List<Trade> find(Trade trade);

	/**
	 * 根据对象查询
	 * @param trade
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Trade> find(Trade trade, String[][] orders);

	/**
	 * 根据对象查询
	 * @param trade
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Trade> find(Trade trade, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param trade
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Trade> find(Trade trade, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param trade
	 * @return Long
	 */
	public Long count(Trade trade);
}
