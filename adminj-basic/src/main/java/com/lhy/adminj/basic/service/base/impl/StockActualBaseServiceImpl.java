package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.StockActualBaseService;
import com.lhy.adminj.basic.dao.StockActualDao;

import com.lhy.adminj.basic.model.StockActual;

/**
 * 股票时段表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockActualBaseServiceImpl implements StockActualBaseService{
	@Autowired
	protected StockActualDao stockActualDao;

	@Override
	public void save(StockActual stockActual) {
		stockActualDao.save(stockActual);
	}
	
	@Override
	public void update(StockActual stockActual) {
		stockActualDao.update(stockActual);
	}

	@Override
	public void modify(StockActual stockActual) {
		stockActualDao.modify(stockActual);
	}

	@Override
	public void delete(Long actualStockId){
		stockActualDao.delete(actualStockId);
	}

	@Override
	public void batchSave(List<StockActual> list){
		stockActualDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<StockActual> list){
		stockActualDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		stockActualDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param actualStockId 股票表主键
	 * @return StockActual
	 */
	public StockActual findById(Long actualStockId){
		return stockActualDao.findById(actualStockId);
	}

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @return List
	 */
	public List<StockActual> find(StockActual stockActual){
		return stockActualDao.find(stockActual);
	}

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<StockActual> find(StockActual stockActual, String[][] orders){
		return stockActualDao.find(stockActual, orders);
	}

	/**
	 * 根据对象查询
	 * @param stockActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockActual> find(StockActual stockActual, Long offset, Long rows){
		return stockActualDao.find(stockActual, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param stockActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockActual> find(StockActual stockActual, String[][] orders, Long offset, Long rows){
    	return stockActualDao.find(stockActual, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param stockActual
	 * @return Long
	 */
	public Long count(StockActual stockActual){
		return stockActualDao.count(stockActual);
	}
}