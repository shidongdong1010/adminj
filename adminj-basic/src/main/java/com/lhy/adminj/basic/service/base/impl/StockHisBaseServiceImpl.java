package com.lhy.adminj.basic.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhy.adminj.basic.service.base.StockHisBaseService;
import com.lhy.adminj.basic.dao.StockHisDao;

import com.lhy.adminj.basic.model.StockHis;

/**
 * 股票历史表Service基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockHisBaseServiceImpl implements StockHisBaseService{
	@Autowired
	protected StockHisDao stockHisDao;

	@Override
	public void save(StockHis stockHis) {
		stockHisDao.save(stockHis);
	}
	
	@Override
	public void update(StockHis stockHis) {
		stockHisDao.update(stockHis);
	}

	@Override
	public void modify(StockHis stockHis) {
		stockHisDao.modify(stockHis);
	}

	@Override
	public void delete(Long hisStockId){
		stockHisDao.delete(hisStockId);
	}

	@Override
	public void batchSave(List<StockHis> list){
		stockHisDao.batchSave(list);
	}

	@Override
    public void batchUpdate(List<StockHis> list){
		stockHisDao.batchUpdate(list);
	}

	@Override
    public void batchDelete(List<Long> ids){
		stockHisDao.batchDelete(ids);
	}

	/**
	 * 根据主键查询
	 * @param hisStockId 股票表主键
	 * @return StockHis
	 */
	public StockHis findById(Long hisStockId){
		return stockHisDao.findById(hisStockId);
	}

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @return List
	 */
	public List<StockHis> find(StockHis stockHis){
		return stockHisDao.find(stockHis);
	}

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<StockHis> find(StockHis stockHis, String[][] orders){
		return stockHisDao.find(stockHis, orders);
	}

	/**
	 * 根据对象查询
	 * @param stockHis
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockHis> find(StockHis stockHis, Long offset, Long rows){
		return stockHisDao.find(stockHis, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param stockHis
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<StockHis> find(StockHis stockHis, String[][] orders, Long offset, Long rows){
    	return stockHisDao.find(stockHis, orders, offset, rows);
	}

	/**
	 * 根据对象查询条数
	 * @param stockHis
	 * @return Long
	 */
	public Long count(StockHis stockHis){
		return stockHisDao.count(stockHis);
	}
}