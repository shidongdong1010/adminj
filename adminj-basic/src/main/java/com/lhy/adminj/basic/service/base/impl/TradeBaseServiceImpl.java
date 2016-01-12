package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.TradeBaseService;
import com.lhy.adminj.basic.dao.TradeDao;

import com.lhy.adminj.basic.model.Trade;

/**
 * 交易记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TradeBaseServiceImpl implements TradeBaseService{
	@Autowired
	protected TradeDao tradeDao;

	@Override
	public void save(Trade trade) {
		tradeDao.save(trade);
	}
	
	@Override
	public void update(Trade trade) {
		tradeDao.update(trade);
	}

	@Override
	public void modify(Trade trade) {
		tradeDao.modify(trade);
	}

	@Override
	public void delete(Long tradeId){
		tradeDao.delete(tradeId);
	}

	@Override
	public void batchSave(List<Trade> list){
		tradeDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<Trade> list){
		tradeDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		tradeDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param tradeId 交易记录表主键
	 * @return Trade
	 */
	public Trade findById(Long tradeId){
		return tradeDao.findById(tradeId);
	}

	/**
	 * 根据对象查询
	 * @param trade
	 * @return List
	 */
	public List<Trade> find(Trade trade){
		return tradeDao.find(trade);
	}

	/**
	 * 根据对象查询
	 * @param trade
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Trade> find(Trade trade, String[][] orders){
		return tradeDao.find(trade, orders);
	}

	/**
	 * 根据对象查询
	 * @param trade
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Trade> find(Trade trade, Long offset, Long rows){
		return tradeDao.find(trade, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param trade
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Trade> find(Trade trade, String[][] orders, Long offset, Long rows){
    	return tradeDao.find(trade, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param trade
	 * @return Long
	 */
	public Long count(Trade trade){
		return tradeDao.count(trade);
	}
}