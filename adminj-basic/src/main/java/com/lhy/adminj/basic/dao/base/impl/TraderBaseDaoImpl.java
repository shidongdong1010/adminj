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

import com.lhy.adminj.basic.dao.base.TraderBaseDao;
import com.lhy.adminj.basic.model.Trader;

/**
 * 券商信息表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TraderBaseDaoImpl implements TraderBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(Trader trader) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_trader ");
		sql.append("   (  ");
		sql.append("		trader_id,  ");
		sql.append("		name,  ");
		sql.append("		cn_short_name,  ");
		sql.append("		en_short_name,  ");
		sql.append("		cooperation,  ");
		sql.append("		update_date,  ");
		sql.append("		coop_end_date,  ");
		sql.append("		create_date,  ");
		sql.append("		coop_start_data  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:name,  ");
		sql.append("		:cn_short_name,  ");
		sql.append("		:en_short_name,  ");
		sql.append("		:cooperation,  ");
		sql.append("		:update_date,  ");
		sql.append("		:coop_end_date,  ");
		sql.append("		:create_date,  ");
		sql.append("		:coop_start_data  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(trader);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		trader.setTraderId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(Trader trader) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_trader ");
		sql.append("    SET ");
        sql.append("        trader_id     = :trader_id, ");
        sql.append("        name     = :name, ");
        sql.append("        cn_short_name     = :cn_short_name, ");
        sql.append("        en_short_name     = :en_short_name, ");
        sql.append("        cooperation     = :cooperation, ");
        sql.append("        update_date     = :update_date, ");
        sql.append("        coop_end_date     = :coop_end_date, ");
        sql.append("        create_date     = :create_date, ");
    	sql.append("        coop_start_data     = :coop_start_data ");
		sql.append("  WHERE trader_id = :trader_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(trader);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param trader
	 * @return
	 */
	public Map<String, Object> toMap(Trader trader){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("trader_id", trader.getTraderId());
        paramMap.put("name", trader.getName());
        paramMap.put("cn_short_name", trader.getCnShortName());
        paramMap.put("en_short_name", trader.getEnShortName());
        paramMap.put("cooperation", trader.getCooperation());
        paramMap.put("update_date", trader.getUpdateDate());
        paramMap.put("coop_end_date", trader.getCoopEndDate());
        paramMap.put("create_date", trader.getCreateDate());
        paramMap.put("coop_start_data", trader.getCoopStartData());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("trader_id, ");
        sql.append("name, ");
        sql.append("cn_short_name, ");
        sql.append("en_short_name, ");
        sql.append("cooperation, ");
        sql.append("update_date, ");
        sql.append("coop_end_date, ");
        sql.append("create_date, ");
		sql.append("coop_start_data ");
		return sql.toString();
	}

	@Override
	public void delete(Long traderId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_trader ");
		sql.append(" WHERE trader_id = ? ");

		jdbcTemplate.update(sql.toString(), traderId);
	}

	/**
	 * 根据主键查询
	 * @param traderId 券商ID
	 * @return Trader
	 */
	@Override
	public Trader findById(Long traderId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_trader ");
		sql.append(" WHERE trader_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Trader.class), traderId);
	}

	/**
	 * 根据对象查询
	 * @param trader
	 * @return List
	 */
	@Override
	public List<Trader> find(Trader trader){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_trader ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(trader != null && trader.getTraderId() != null){
			sql.append("  AND trader_id = ? ");
			param.add(trader.getTraderId());
        }
		if(trader != null && trader.getName() != null && !"".equals(trader.getName())){
            sql.append("  AND name = ? ");
			param.add(trader.getName());
		}
		if(trader != null && trader.getCnShortName() != null && !"".equals(trader.getCnShortName())){
            sql.append("  AND cn_short_name = ? ");
			param.add(trader.getCnShortName());
		}
		if(trader != null && trader.getEnShortName() != null && !"".equals(trader.getEnShortName())){
            sql.append("  AND en_short_name = ? ");
			param.add(trader.getEnShortName());
		}
		if(trader != null && trader.getCooperation() != null && !"".equals(trader.getCooperation())){
            sql.append("  AND cooperation = ? ");
			param.add(trader.getCooperation());
		}
        if(trader != null && trader.getUpdateDate() != null){
			sql.append("  AND update_date = ? ");
			param.add(trader.getUpdateDate());
        }
        if(trader != null && trader.getCoopEndDate() != null){
			sql.append("  AND coop_end_date = ? ");
			param.add(trader.getCoopEndDate());
        }
        if(trader != null && trader.getCreateDate() != null){
			sql.append("  AND create_date = ? ");
			param.add(trader.getCreateDate());
        }
        if(trader != null && trader.getCoopStartData() != null){
			sql.append("  AND coop_start_data = ? ");
			param.add(trader.getCoopStartData());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Trader.class));
	}

	/**
	 * 根据对象查询
	 * @param trader
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Trader> find(Trader trader, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_trader ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(trader != null && trader.getTraderId() != null){
			sql.append("  AND trader_id = ? ");
			param.add(trader.getTraderId());
        }
		if(trader != null && trader.getName() != null && !"".equals(trader.getName())){
            sql.append("  AND name = ? ");
			param.add(trader.getName());
		}
		if(trader != null && trader.getCnShortName() != null && !"".equals(trader.getCnShortName())){
            sql.append("  AND cn_short_name = ? ");
			param.add(trader.getCnShortName());
		}
		if(trader != null && trader.getEnShortName() != null && !"".equals(trader.getEnShortName())){
            sql.append("  AND en_short_name = ? ");
			param.add(trader.getEnShortName());
		}
		if(trader != null && trader.getCooperation() != null && !"".equals(trader.getCooperation())){
            sql.append("  AND cooperation = ? ");
			param.add(trader.getCooperation());
		}
        if(trader != null && trader.getUpdateDate() != null){
			sql.append("  AND update_date = ? ");
			param.add(trader.getUpdateDate());
        }
        if(trader != null && trader.getCoopEndDate() != null){
			sql.append("  AND coop_end_date = ? ");
			param.add(trader.getCoopEndDate());
        }
        if(trader != null && trader.getCreateDate() != null){
			sql.append("  AND create_date = ? ");
			param.add(trader.getCreateDate());
        }
        if(trader != null && trader.getCoopStartData() != null){
			sql.append("  AND coop_start_data = ? ");
			param.add(trader.getCoopStartData());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Trader.class));
	}

	/**
	 * 根据对象查询条数
	 * @param trader
	 * @return Long
	 */
	@Override
	public Long count(Trader trader){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_trader ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(trader != null && trader.getTraderId() != null){
			sql.append("  AND trader_id = ? ");
			param.add(trader.getTraderId());
        }
		if(trader != null && trader.getName() != null && !"".equals(trader.getName())){
            sql.append("  AND name = ? ");
			param.add(trader.getName());
		}
		if(trader != null && trader.getCnShortName() != null && !"".equals(trader.getCnShortName())){
            sql.append("  AND cn_short_name = ? ");
			param.add(trader.getCnShortName());
		}
		if(trader != null && trader.getEnShortName() != null && !"".equals(trader.getEnShortName())){
            sql.append("  AND en_short_name = ? ");
			param.add(trader.getEnShortName());
		}
		if(trader != null && trader.getCooperation() != null && !"".equals(trader.getCooperation())){
            sql.append("  AND cooperation = ? ");
			param.add(trader.getCooperation());
		}
        if(trader != null && trader.getUpdateDate() != null){
			sql.append("  AND update_date = ? ");
			param.add(trader.getUpdateDate());
        }
        if(trader != null && trader.getCoopEndDate() != null){
			sql.append("  AND coop_end_date = ? ");
			param.add(trader.getCoopEndDate());
        }
        if(trader != null && trader.getCreateDate() != null){
			sql.append("  AND create_date = ? ");
			param.add(trader.getCreateDate());
        }
        if(trader != null && trader.getCoopStartData() != null){
			sql.append("  AND coop_start_data = ? ");
			param.add(trader.getCoopStartData());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}