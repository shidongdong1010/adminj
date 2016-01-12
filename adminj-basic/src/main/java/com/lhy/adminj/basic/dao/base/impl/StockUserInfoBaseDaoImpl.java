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

import com.lhy.adminj.basic.dao.base.StockUserInfoBaseDao;
import com.lhy.adminj.basic.model.StockUserInfo;

/**
 * 平台客户和证券客户关联Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class StockUserInfoBaseDaoImpl implements StockUserInfoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(StockUserInfo stockUserInfo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_stock_user_info ");
		sql.append("   (  ");
		sql.append("		stock_user_info_id,  ");
		sql.append("		user_id,  ");
		sql.append("		stock_user_id,  ");
		sql.append("		status,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr,  ");
		sql.append("		broker_id,  ");
		sql.append("		stork_khh  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:user_id,  ");
		sql.append("		:stock_user_id,  ");
		sql.append("		:status,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr,  ");
		sql.append("		:broker_id,  ");
		sql.append("		:stork_khh  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockUserInfo);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		stockUserInfo.setStockUserInfoId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(StockUserInfo stockUserInfo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_stock_user_info ");
		sql.append("    SET ");
        sql.append("        stock_user_info_id     = :stock_user_info_id, ");
        sql.append("        user_id     = :user_id, ");
        sql.append("        stock_user_id     = :stock_user_id, ");
        sql.append("        status     = :status, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
        sql.append("        dr     = :dr, ");
        sql.append("        broker_id     = :broker_id, ");
    	sql.append("        stork_khh     = :stork_khh ");
		sql.append("  WHERE stock_user_info_id = :stock_user_info_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(stockUserInfo);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param stockUserInfo
	 * @return
	 */
	public Map<String, Object> toMap(StockUserInfo stockUserInfo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("stock_user_info_id", stockUserInfo.getStockUserInfoId());
        paramMap.put("user_id", stockUserInfo.getUserId());
        paramMap.put("stock_user_id", stockUserInfo.getStockUserId());
        paramMap.put("status", stockUserInfo.getStatus());
        paramMap.put("creat_date", stockUserInfo.getCreatDate());
        paramMap.put("creator", stockUserInfo.getCreator());
        paramMap.put("last_update_date", stockUserInfo.getLastUpdateDate());
        paramMap.put("last_updater", stockUserInfo.getLastUpdater());
        paramMap.put("dr", stockUserInfo.getDr());
        paramMap.put("broker_id", stockUserInfo.getBrokerId());
        paramMap.put("stork_khh", stockUserInfo.getStorkKhh());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("stock_user_info_id, ");
        sql.append("user_id, ");
        sql.append("stock_user_id, ");
        sql.append("status, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
        sql.append("dr, ");
        sql.append("broker_id, ");
		sql.append("stork_khh ");
		return sql.toString();
	}

	@Override
	public void delete(Long stockUserInfoId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_stock_user_info ");
		sql.append(" WHERE stock_user_info_id = ? ");

		jdbcTemplate.update(sql.toString(), stockUserInfoId);
	}

	/**
	 * 根据主键查询
	 * @param stockUserInfoId 主键
	 * @return StockUserInfo
	 */
	@Override
	public StockUserInfo findById(Long stockUserInfoId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_user_info ");
		sql.append(" WHERE stock_user_info_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(StockUserInfo.class), stockUserInfoId);
	}

	/**
	 * 根据对象查询
	 * @param stockUserInfo
	 * @return List
	 */
	@Override
	public List<StockUserInfo> find(StockUserInfo stockUserInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_user_info ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockUserInfo != null && stockUserInfo.getStockUserInfoId() != null){
			sql.append("  AND stock_user_info_id = ? ");
			param.add(stockUserInfo.getStockUserInfoId());
        }
        if(stockUserInfo != null && stockUserInfo.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(stockUserInfo.getUserId());
        }
        if(stockUserInfo != null && stockUserInfo.getStockUserId() != null){
			sql.append("  AND stock_user_id = ? ");
			param.add(stockUserInfo.getStockUserId());
        }
		if(stockUserInfo != null && stockUserInfo.getStatus() != null && !"".equals(stockUserInfo.getStatus())){
            sql.append("  AND status = ? ");
			param.add(stockUserInfo.getStatus());
		}
        if(stockUserInfo != null && stockUserInfo.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockUserInfo.getCreatDate());
        }
        if(stockUserInfo != null && stockUserInfo.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockUserInfo.getCreator());
        }
        if(stockUserInfo != null && stockUserInfo.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockUserInfo.getLastUpdateDate());
        }
        if(stockUserInfo != null && stockUserInfo.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockUserInfo.getLastUpdater());
        }
        if(stockUserInfo != null && stockUserInfo.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockUserInfo.getDr());
        }
        if(stockUserInfo != null && stockUserInfo.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(stockUserInfo.getBrokerId());
        }
		if(stockUserInfo != null && stockUserInfo.getStorkKhh() != null && !"".equals(stockUserInfo.getStorkKhh())){
            sql.append("  AND stork_khh = ? ");
			param.add(stockUserInfo.getStorkKhh());
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(StockUserInfo.class));
	}

	/**
	 * 根据对象查询
	 * @param stockUserInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<StockUserInfo> find(StockUserInfo stockUserInfo, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_stock_user_info ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockUserInfo != null && stockUserInfo.getStockUserInfoId() != null){
			sql.append("  AND stock_user_info_id = ? ");
			param.add(stockUserInfo.getStockUserInfoId());
        }
        if(stockUserInfo != null && stockUserInfo.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(stockUserInfo.getUserId());
        }
        if(stockUserInfo != null && stockUserInfo.getStockUserId() != null){
			sql.append("  AND stock_user_id = ? ");
			param.add(stockUserInfo.getStockUserId());
        }
		if(stockUserInfo != null && stockUserInfo.getStatus() != null && !"".equals(stockUserInfo.getStatus())){
            sql.append("  AND status = ? ");
			param.add(stockUserInfo.getStatus());
		}
        if(stockUserInfo != null && stockUserInfo.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockUserInfo.getCreatDate());
        }
        if(stockUserInfo != null && stockUserInfo.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockUserInfo.getCreator());
        }
        if(stockUserInfo != null && stockUserInfo.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockUserInfo.getLastUpdateDate());
        }
        if(stockUserInfo != null && stockUserInfo.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockUserInfo.getLastUpdater());
        }
        if(stockUserInfo != null && stockUserInfo.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockUserInfo.getDr());
        }
        if(stockUserInfo != null && stockUserInfo.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(stockUserInfo.getBrokerId());
        }
		if(stockUserInfo != null && stockUserInfo.getStorkKhh() != null && !"".equals(stockUserInfo.getStorkKhh())){
            sql.append("  AND stork_khh = ? ");
			param.add(stockUserInfo.getStorkKhh());
		}
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(StockUserInfo.class));
	}

	/**
	 * 根据对象查询条数
	 * @param stockUserInfo
	 * @return Long
	 */
	@Override
	public Long count(StockUserInfo stockUserInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_stock_user_info ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(stockUserInfo != null && stockUserInfo.getStockUserInfoId() != null){
			sql.append("  AND stock_user_info_id = ? ");
			param.add(stockUserInfo.getStockUserInfoId());
        }
        if(stockUserInfo != null && stockUserInfo.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(stockUserInfo.getUserId());
        }
        if(stockUserInfo != null && stockUserInfo.getStockUserId() != null){
			sql.append("  AND stock_user_id = ? ");
			param.add(stockUserInfo.getStockUserId());
        }
		if(stockUserInfo != null && stockUserInfo.getStatus() != null && !"".equals(stockUserInfo.getStatus())){
            sql.append("  AND status = ? ");
			param.add(stockUserInfo.getStatus());
		}
        if(stockUserInfo != null && stockUserInfo.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(stockUserInfo.getCreatDate());
        }
        if(stockUserInfo != null && stockUserInfo.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(stockUserInfo.getCreator());
        }
        if(stockUserInfo != null && stockUserInfo.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(stockUserInfo.getLastUpdateDate());
        }
        if(stockUserInfo != null && stockUserInfo.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(stockUserInfo.getLastUpdater());
        }
        if(stockUserInfo != null && stockUserInfo.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(stockUserInfo.getDr());
        }
        if(stockUserInfo != null && stockUserInfo.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(stockUserInfo.getBrokerId());
        }
		if(stockUserInfo != null && stockUserInfo.getStorkKhh() != null && !"".equals(stockUserInfo.getStorkKhh())){
            sql.append("  AND stork_khh = ? ");
			param.add(stockUserInfo.getStorkKhh());
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}