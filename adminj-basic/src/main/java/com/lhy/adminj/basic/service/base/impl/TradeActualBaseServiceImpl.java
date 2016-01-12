package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.TradeActualBaseService;
import com.lhy.adminj.basic.dao.TradeActualDao;

import com.lhy.adminj.basic.model.TradeActual;

/**
 * 时段交易记录表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TradeActualBaseServiceImpl implements TradeActualBaseService{
	@Autowired
	protected TradeActualDao tradeActualDao;

	@Override
	public void save(TradeActual tradeActual) {
		tradeActualDao.save(tradeActual);
	}
	
	@Override
	public void update(TradeActual tradeActual) {
		tradeActualDao.update(tradeActual);
	}

	@Override
	public void modify(TradeActual tradeActual) {
		tradeActualDao.modify(tradeActual);
	}

	@Override
	public void delete(Long actualTradeId){
		tradeActualDao.delete(actualTradeId);
	}

	@Override
	public void batchSave(List<TradeActual> list){
		tradeActualDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<TradeActual> list){
		tradeActualDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		tradeActualDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param actualTradeId 交易记录表主键
	 * @return TradeActual
	 */
	public TradeActual findById(Long actualTradeId){
		return tradeActualDao.findById(actualTradeId);
	}

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @return List
	 */
	public List<TradeActual> find(TradeActual tradeActual){
		return tradeActualDao.find(tradeActual);
	}

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<TradeActual> find(TradeActual tradeActual, String[][] orders){
		return tradeActualDao.find(tradeActual, orders);
	}

	/**
	 * 根据对象查询
	 * @param tradeActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<TradeActual> find(TradeActual tradeActual, Long offset, Long rows){
		return tradeActualDao.find(tradeActual, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param tradeActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<TradeActual> find(TradeActual tradeActual, String[][] orders, Long offset, Long rows){
    	return tradeActualDao.find(tradeActual, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param tradeActual
	 * @return Long
	 */
	public Long count(TradeActual tradeActual){
		return tradeActualDao.count(tradeActual);
	}
}