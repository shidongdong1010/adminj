package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.TradeActual;

/**
 * 时段交易记录表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface TradeActualBaseService {

	public void save(TradeActual tradeActual);
	
	public void update(TradeActual tradeActual);

	public void modify(TradeActual tradeActual);

	public void delete(Long actualTradeId);

	public void batchSave(List<TradeActual> list);

    public void batchUpdate(List<TradeActual> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param actualTradeId 交易记录表主键
	 * @return TradeActual
	 */
	public TradeActual findById(Long actualTradeId);

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @return List
	 */
	public List<TradeActual> find(TradeActual tradeActual);

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<TradeActual> find(TradeActual tradeActual, String[][] orders);

	/**
	 * 根据对象查询
	 * @param tradeActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<TradeActual> find(TradeActual tradeActual, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<TradeActual> find(TradeActual tradeActual, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param tradeActual
	 * @return Long
	 */
	public Long count(TradeActual tradeActual);
}
