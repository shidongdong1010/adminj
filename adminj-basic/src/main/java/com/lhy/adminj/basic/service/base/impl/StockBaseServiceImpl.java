package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.StockBaseService;
import com.lhy.adminj.basic.dao.StockDao;

import com.lhy.adminj.basic.model.Stock;

/**
 * 股票表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockBaseServiceImpl implements StockBaseService{
	@Autowired
	protected StockDao stockDao;

	@Override
	public void save(Stock stock) {
		stockDao.save(stock);
	}
	
	@Override
	public void update(Stock stock) {
		stockDao.update(stock);
	}

	@Override
	public void modify(Stock stock) {
		stockDao.modify(stock);
	}

	@Override
	public void delete(Long stockId){
		stockDao.delete(stockId);
	}

	@Override
	public void batchSave(List<Stock> list){
		stockDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<Stock> list){
		stockDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		stockDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param stockId 股票表主键
	 * @return Stock
	 */
	public Stock findById(Long stockId){
		return stockDao.findById(stockId);
	}

	/**
	 * 根据对象查询
	 * @param stock
	 * @return List
	 */
	public List<Stock> find(Stock stock){
		return stockDao.find(stock);
	}

	/**
	 * 根据对象查询
	 * @param stock
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<Stock> find(Stock stock, String[][] orders){
		return stockDao.find(stock, orders);
	}

	/**
	 * 根据对象查询
	 * @param stock
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Stock> find(Stock stock, Long offset, Long rows){
		return stockDao.find(stock, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param stock
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Stock> find(Stock stock, String[][] orders, Long offset, Long rows){
    	return stockDao.find(stock, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param stock
	 * @return Long
	 */
	public Long count(Stock stock){
		return stockDao.count(stock);
	}
}