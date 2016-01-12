package com.lhy.adminj.basic.dao.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.lhy.adminj.basic.dao.base.StockHistoryBaseDao;
import com.lhy.adminj.basic.model.StockHistory;

/**
 * 股票历史表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockHistoryBaseDaoImpl implements StockHistoryBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(StockHistory stockHistory) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_stock_history ");
		sql.append("   (  ");
		sql.append("		stock_history_id,  ");
		sql.append("		stock_date,  ");
		sql.append("		stock_code,  ");
		sql.append("		start_pri,  ");
		sql.append("		end_pri,  ");
		sql.append("		today_max,  ");
		sql.append("		today_min,  ");
		sql.append("		tra_number,  ");
		sql.append("		tra_amount,  ");
		sql.append("		submit_pric,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:stock_date,  ");
		sql.append("		:stock_code,  ");
		sql.append("		:start_pri,  ");
		sql.append("		:end_pri,  ");
		sql.append("		:today_max,  ");
		sql.append("		:today_min,  ");
		sql.append("		:tra_number,  ");
		sql.append("		:tra_amount,  ");
		sql.append("		:submit_pric,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockHistory);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		stockHistory.setStockHistoryId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(StockHistory stockHistory) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_stock_history ");
		sql.append("    SET ");
        sql.append("        stock_history_id     = :stock_history_id, ");
        sql.append("        stock_date     = :stock_date, ");
        sql.append("        stock_code     = :stock_code, ");
        sql.append("        start_pri     = :start_pri, ");
        sql.append("        end_pri     = :end_pri, ");
        sql.append("        today_max     = :today_max, ");
        sql.append("        today_min     = :today_min, ");
        sql.append("        tra_number     = :tra_number, ");
        sql.append("        tra_amount     = :tra_amount, ");
        sql.append("        submit_pric     = :submit_pric, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
    	sql.append("        dr     = :dr ");
		sql.append("  WHERE stock_history_id = :stock_history_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockHistory);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param stockHistory
	 * @return
	 */
	public Map<String, Object> toMap(StockHistory stockHistory){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("stock_history_id", stockHistory.getStockHistoryId());
        paramMap.put("stock_date", stockHistory.getStockDate());
        paramMap.put("stock_code", stockHistory.getStockCode());
        paramMap.put("start_pri", stockHistory.getStartPri());
        paramMap.put("end_pri", stockHistory.getEndPri());
        paramMap.put("today_max", stockHistory.getTodayMax());
        paramMap.put("today_min", stockHistory.getTodayMin());
        paramMap.put("tra_number", stockHistory.getTraNumber());
        paramMap.put("tra_amount", stockHistory.getTraAmount());
        paramMap.put("submit_pric", stockHistory.getSubmitPric());
        paramMap.put("creat_date", stockHistory.getCreatDate());
        paramMap.put("creator", stockHistory.getCreator());
        paramMap.put("last_update_date", stockHistory.getLastUpdateDate());
        paramMap.put("last_updater", stockHistory.getLastUpdater());
        paramMap.put("dr", stockHistory.getDr());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("stock_history_id, ");
        sql.append("stock_date, ");
        sql.append("stock_code, ");
        sql.append("start_pri, ");
        sql.append("end_pri, ");
        sql.append("today_max, ");
        sql.append("today_min, ");
        sql.append("tra_number, ");
        sql.append("tra_amount, ");
        sql.append("submit_pric, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
		sql.append("dr ");
		return sql.toString();
	}

	@Override
	public void delete(Long stockHistoryId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_stock_history ");
		sql.append(" WHERE stock_history_id = ? ");

		jdbcTemplate.update(sql.toString(), stockHistoryId);
	}

	/**
	 * 根据主键查询
	 * @param stockHistoryId 股票历史表主键
	 * @return StockHistory
	 */
	@Override
	public StockHistory findById(Long stockHistoryId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_history ");
		sql.append(" WHERE stock_history_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(StockHistory.class), stockHistoryId);
	}

	/**
	 * 根据对象查询
	 * @param stockHistory
	 * @return List
	 */
	@Override
	public List<StockHistory> find(StockHistory stockHistory){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_history ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockHistory != null && stockHistory.getStockHistoryId() != null){
			sql.append("  AND stock_history_id = ? ");
			param.add(stockHistory.getStockHistoryId());
        }
        if(stockHistory != null && stockHistory.getStockDate() != null){
			sql.append("  AND stock_date = ? ");
			param.add(stockHistory.getStockDate());
        }
		if(stockHistory != null && stockHistory.getStockCode() != null && !"".equals(stockHistory.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(stockHistory.getStockCode());
		}
        if(stockHistory != null && stockHistory.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockHistory.getCreatDate());
        }
        if(stockHistory != null && stockHistory.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockHistory.getCreator());
        }
        if(stockHistory != null && stockHistory.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockHistory.getLastUpdateDate());
        }
        if(stockHistory != null && stockHistory.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockHistory.getLastUpdater());
        }
        if(stockHistory != null && stockHistory.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockHistory.getDr());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(StockHistory.class));
	}

	/**
	 * 根据对象查询
	 * @param stockHistory
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<StockHistory> find(StockHistory stockHistory, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_history ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockHistory != null && stockHistory.getStockHistoryId() != null){
			sql.append("  AND stock_history_id = ? ");
			param.add(stockHistory.getStockHistoryId());
        }
        if(stockHistory != null && stockHistory.getStockDate() != null){
			sql.append("  AND stock_date = ? ");
			param.add(stockHistory.getStockDate());
        }
		if(stockHistory != null && stockHistory.getStockCode() != null && !"".equals(stockHistory.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(stockHistory.getStockCode());
		}
        if(stockHistory != null && stockHistory.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockHistory.getCreatDate());
        }
        if(stockHistory != null && stockHistory.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockHistory.getCreator());
        }
        if(stockHistory != null && stockHistory.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockHistory.getLastUpdateDate());
        }
        if(stockHistory != null && stockHistory.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockHistory.getLastUpdater());
        }
        if(stockHistory != null && stockHistory.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockHistory.getDr());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(StockHistory.class));
	}

	/**
	 * 根据对象查询条数
	 * @param stockHistory
	 * @return Long
	 */
	@Override
	public Long count(StockHistory stockHistory){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_stock_history ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockHistory != null && stockHistory.getStockHistoryId() != null){
			sql.append("  AND stock_history_id = ? ");
			param.add(stockHistory.getStockHistoryId());
        }
        if(stockHistory != null && stockHistory.getStockDate() != null){
			sql.append("  AND stock_date = ? ");
			param.add(stockHistory.getStockDate());
        }
		if(stockHistory != null && stockHistory.getStockCode() != null && !"".equals(stockHistory.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(stockHistory.getStockCode());
		}
        if(stockHistory != null && stockHistory.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockHistory.getCreatDate());
        }
        if(stockHistory != null && stockHistory.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockHistory.getCreator());
        }
        if(stockHistory != null && stockHistory.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockHistory.getLastUpdateDate());
        }
        if(stockHistory != null && stockHistory.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockHistory.getLastUpdater());
        }
        if(stockHistory != null && stockHistory.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockHistory.getDr());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}