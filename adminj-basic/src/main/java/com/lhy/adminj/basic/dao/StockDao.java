package com.lhy.adminj.basic.dao;

import java.util.List;

import com.lhy.adminj.basic.dao.base.StockBaseDao;
import com.lhy.adminj.basic.model.Stock;

/**
 * 股票表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface StockDao extends StockBaseDao {

	/**
	 * 根据股票代码模糊查询
	 * @param stockCode 股票代码
	 * @param offset 开始索引
	 * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Stock> findLikeByStockCode(String stockCode, Long offset, Long rows);

	/**
	 * 根据股票代码模糊查询记录数
	 * @param stockCode 股票代码
	 * @return Long
	 */
	public Long countLikeByStockCode(String stockCode);

	/**
	 * 根据股票代码查询
	 *
	 * @param stockCode 股票代码
	 * @return
	 */
	public Stock findByStockCode(String stockCode);
}
