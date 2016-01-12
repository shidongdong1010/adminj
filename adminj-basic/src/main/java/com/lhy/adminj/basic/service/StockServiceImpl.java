package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.impl.StockBaseServiceImpl;

import com.lhy.adminj.basic.model.Stock;
import org.springframework.stereotype.Service;

/**
 * 股票表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class StockServiceImpl extends StockBaseServiceImpl implements StockService {

	/**
	 * 根据股票代码模糊查询
	 * @param stockCode 股票代码
	 * @param offset 开始索引
	 * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Stock> findLikeByStockCode(String stockCode, Long offset, Long rows){
		return stockDao.findLikeByStockCode(stockCode, offset, rows);
	}

	/**
	 * 根据股票代码模糊查询记录数
	 * @param stockCode 股票代码
	 * @return Long
	 */
	public Long countLikeByStockCode(String stockCode){
		return stockDao.countLikeByStockCode(stockCode);
	}

	/**
	 * 根据股票代码查询
	 *
	 * @param stockCode 股票代码
	 * @return
	 */
	public Stock findByStockCode(String stockCode){
		return stockDao.findByStockCode(stockCode);
	}
}