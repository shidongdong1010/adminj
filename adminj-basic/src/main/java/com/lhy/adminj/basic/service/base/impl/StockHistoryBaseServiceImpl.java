package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.StockHistoryBaseService;
import com.lhy.adminj.basic.dao.StockHistoryDao;

import com.lhy.adminj.basic.model.StockHistory;

/**
 * 股票历史表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockHistoryBaseServiceImpl implements StockHistoryBaseService{
	@Autowired
	protected StockHistoryDao stockHistoryDao;

	@Override
	public void save(StockHistory stockHistory) {
		stockHistoryDao.save(stockHistory);
	}
	
	@Override
	public void update(StockHistory stockHistory) {
		stockHistoryDao.update(stockHistory);
	}

	@Override
	public void delete(Long stockHistoryId){
		stockHistoryDao.delete(stockHistoryId);
	}

	/**
	 * 根据主键查询
	 * @param stockHistoryId 股票历史表主键
	 * @return StockHistory
	 */
	public StockHistory findById(Long stockHistoryId){
		return stockHistoryDao.findById(stockHistoryId);
	}

	/**
	 * 根据对象查询
	 * @param stockHistory
	 * @return List
	 */
	public List<StockHistory> find(StockHistory stockHistory){
		return stockHistoryDao.find(stockHistory);
	}

	/**
	 * 根据对象查询
	 * @param stockHistory
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockHistory> find(StockHistory stockHistory, Long offset, Long rows){
		return stockHistoryDao.find(stockHistory, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param stockHistory
	 * @return Long
	 */
	public Long count(StockHistory stockHistory){
		return stockHistoryDao.count(stockHistory);
	}
}