package com.lhy.adminj.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.lhy.adminj.basic.dao.base.impl.StockBaseDaoImpl;
import com.lhy.adminj.basic.dao.StockDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.lhy.adminj.basic.model.Stock;

/**
 * 股票表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class StockDaoImpl extends StockBaseDaoImpl implements StockDao {

	/**
	 * 根据股票代码模糊查询
	 * @param stockCode 股票代码
	 * @param offset 开始索引
	 * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<Stock> findLikeByStockCode(String stockCode, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock _this");
		sql.append(" WHERE _this.stock_code like ? or _this.stock_name like ?");
		List<Object> param = new ArrayList<Object>();
		param.add("%"+stockCode+"%");
		param.add("%"+stockCode+"%");
		if(offset != null  && rows != null){
			sql.append("  limit ?,? ");
			param.add(offset);
			param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Stock.class));
	}

	/**
	 * 根据股票代码模糊查询记录数
	 * @param stockCode 股票代码
	 * @return Long
	 */
	public Long countLikeByStockCode(String stockCode){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("     count(*) ");
		sql.append("   FROM smc_stock ");
		sql.append(" WHERE stock_code like ? ");
		List<Object> param = new ArrayList<Object>();
		param.add("%"+stockCode+"%");
		return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}

	/**
	 * 根据股票代码查询
	 *
	 * @param stockCode 股票代码
	 * @return
	 */
	public Stock findByStockCode(String stockCode){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock _this ");
		sql.append(" WHERE _this.stock_code = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Stock.class), stockCode);
	}
}
