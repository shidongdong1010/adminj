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

import com.lhy.adminj.basic.dao.base.BrokersBaseDao;
import com.lhy.adminj.basic.model.Brokers;

/**
 * 券商管理表，后期接入的券商都通过此表进行管理Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class BrokersBaseDaoImpl implements BrokersBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(Brokers brokers) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_brokers ");
		sql.append("   (  ");
		sql.append("		broker_id,  ");
		sql.append("		broker_name,  ");
		sql.append("		broker_code,  ");
		sql.append("		broker_class,  ");
		sql.append("		broker_state,  ");
		sql.append("		broker_local,  ");
		sql.append("		broker_address,  ");
		sql.append("		broker_money,  ");
		sql.append("		broker_app_state,  ");
		sql.append("		broker_fee,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr,  ");
		sql.append("		coop_end_date,  ");
		sql.append("		coop_start_data  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:broker_name,  ");
		sql.append("		:broker_code,  ");
		sql.append("		:broker_class,  ");
		sql.append("		:broker_state,  ");
		sql.append("		:broker_local,  ");
		sql.append("		:broker_address,  ");
		sql.append("		:broker_money,  ");
		sql.append("		:broker_app_state,  ");
		sql.append("		:broker_fee,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr,  ");
		sql.append("		:coop_end_date,  ");
		sql.append("		:coop_start_data  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(brokers);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		brokers.setBrokerId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(Brokers brokers) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_brokers ");
		sql.append("    SET ");
        sql.append("        broker_id     = :broker_id, ");
        sql.append("        broker_name     = :broker_name, ");
        sql.append("        broker_code     = :broker_code, ");
        sql.append("        broker_class     = :broker_class, ");
        sql.append("        broker_state     = :broker_state, ");
        sql.append("        broker_local     = :broker_local, ");
        sql.append("        broker_address     = :broker_address, ");
        sql.append("        broker_money     = :broker_money, ");
        sql.append("        broker_app_state     = :broker_app_state, ");
        sql.append("        broker_fee     = :broker_fee, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
        sql.append("        dr     = :dr, ");
        sql.append("        coop_end_date     = :coop_end_date, ");
    	sql.append("        coop_start_data     = :coop_start_data ");
		sql.append("  WHERE broker_id = :broker_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(brokers);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param brokers
	 * @return
	 */
	public Map<String, Object> toMap(Brokers brokers){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("broker_id", brokers.getBrokerId());
        paramMap.put("broker_name", brokers.getBrokerName());
        paramMap.put("broker_code", brokers.getBrokerCode());
        paramMap.put("broker_class", brokers.getBrokerClass());
        paramMap.put("broker_state", brokers.getBrokerState());
        paramMap.put("broker_local", brokers.getBrokerLocal());
        paramMap.put("broker_address", brokers.getBrokerAddress());
        paramMap.put("broker_money", brokers.getBrokerMoney());
        paramMap.put("broker_app_state", brokers.getBrokerAppState());
        paramMap.put("broker_fee", brokers.getBrokerFee());
        paramMap.put("creat_date", brokers.getCreatDate());
        paramMap.put("creator", brokers.getCreator());
        paramMap.put("last_update_date", brokers.getLastUpdateDate());
        paramMap.put("last_updater", brokers.getLastUpdater());
        paramMap.put("dr", brokers.getDr());
        paramMap.put("coop_end_date", brokers.getCoopEndDate());
        paramMap.put("coop_start_data", brokers.getCoopStartData());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("broker_id, ");
        sql.append("broker_name, ");
        sql.append("broker_code, ");
        sql.append("broker_class, ");
        sql.append("broker_state, ");
        sql.append("broker_local, ");
        sql.append("broker_address, ");
        sql.append("broker_money, ");
        sql.append("broker_app_state, ");
        sql.append("broker_fee, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
        sql.append("dr, ");
        sql.append("coop_end_date, ");
		sql.append("coop_start_data ");
		return sql.toString();
	}

	@Override
	public void delete(Long brokerId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_brokers ");
		sql.append(" WHERE broker_id = ? ");

		jdbcTemplate.update(sql.toString(), brokerId);
	}

	/**
	 * 根据主键查询
	 * @param brokerId 
	 * @return Brokers
	 */
	@Override
	public Brokers findById(Long brokerId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_brokers ");
		sql.append(" WHERE broker_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Brokers.class), brokerId);
	}

	/**
	 * 根据对象查询
	 * @param brokers
	 * @return List
	 */
	@Override
	public List<Brokers> find(Brokers brokers){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_brokers ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(brokers != null && brokers.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(brokers.getBrokerId());
        }
		if(brokers != null && brokers.getBrokerName() != null && !"".equals(brokers.getBrokerName())){
            sql.append("  AND broker_name = ? ");
			param.add(brokers.getBrokerName());
		}
		if(brokers != null && brokers.getBrokerCode() != null && !"".equals(brokers.getBrokerCode())){
            sql.append("  AND broker_code = ? ");
			param.add(brokers.getBrokerCode());
		}
		if(brokers != null && brokers.getBrokerClass() != null && !"".equals(brokers.getBrokerClass())){
            sql.append("  AND broker_class = ? ");
			param.add(brokers.getBrokerClass());
		}
		if(brokers != null && brokers.getBrokerState() != null && !"".equals(brokers.getBrokerState())){
            sql.append("  AND broker_state = ? ");
			param.add(brokers.getBrokerState());
		}
		if(brokers != null && brokers.getBrokerLocal() != null && !"".equals(brokers.getBrokerLocal())){
            sql.append("  AND broker_local = ? ");
			param.add(brokers.getBrokerLocal());
		}
		if(brokers != null && brokers.getBrokerAddress() != null && !"".equals(brokers.getBrokerAddress())){
            sql.append("  AND broker_address = ? ");
			param.add(brokers.getBrokerAddress());
		}
		if(brokers != null && brokers.getBrokerAppState() != null && !"".equals(brokers.getBrokerAppState())){
            sql.append("  AND broker_app_state = ? ");
			param.add(brokers.getBrokerAppState());
		}
        if(brokers != null && brokers.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(brokers.getCreatDate());
        }
        if(brokers != null && brokers.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(brokers.getCreator());
        }
        if(brokers != null && brokers.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(brokers.getLastUpdateDate());
        }
        if(brokers != null && brokers.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(brokers.getLastUpdater());
        }
        if(brokers != null && brokers.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(brokers.getDr());
        }
        if(brokers != null && brokers.getCoopEndDate() != null){
			sql.append("  AND coop_end_date = ? ");
			param.add(brokers.getCoopEndDate());
        }
        if(brokers != null && brokers.getCoopStartData() != null){
			sql.append("  AND coop_start_data = ? ");
			param.add(brokers.getCoopStartData());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Brokers.class));
	}

	/**
	 * 根据对象查询
	 * @param brokers
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Brokers> find(Brokers brokers, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_brokers ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(brokers != null && brokers.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(brokers.getBrokerId());
        }
		if(brokers != null && brokers.getBrokerName() != null && !"".equals(brokers.getBrokerName())){
            sql.append("  AND broker_name = ? ");
			param.add(brokers.getBrokerName());
		}
		if(brokers != null && brokers.getBrokerCode() != null && !"".equals(brokers.getBrokerCode())){
            sql.append("  AND broker_code = ? ");
			param.add(brokers.getBrokerCode());
		}
		if(brokers != null && brokers.getBrokerClass() != null && !"".equals(brokers.getBrokerClass())){
            sql.append("  AND broker_class = ? ");
			param.add(brokers.getBrokerClass());
		}
		if(brokers != null && brokers.getBrokerState() != null && !"".equals(brokers.getBrokerState())){
            sql.append("  AND broker_state = ? ");
			param.add(brokers.getBrokerState());
		}
		if(brokers != null && brokers.getBrokerLocal() != null && !"".equals(brokers.getBrokerLocal())){
            sql.append("  AND broker_local = ? ");
			param.add(brokers.getBrokerLocal());
		}
		if(brokers != null && brokers.getBrokerAddress() != null && !"".equals(brokers.getBrokerAddress())){
            sql.append("  AND broker_address = ? ");
			param.add(brokers.getBrokerAddress());
		}
		if(brokers != null && brokers.getBrokerAppState() != null && !"".equals(brokers.getBrokerAppState())){
            sql.append("  AND broker_app_state = ? ");
			param.add(brokers.getBrokerAppState());
		}
        if(brokers != null && brokers.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(brokers.getCreatDate());
        }
        if(brokers != null && brokers.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(brokers.getCreator());
        }
        if(brokers != null && brokers.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(brokers.getLastUpdateDate());
        }
        if(brokers != null && brokers.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(brokers.getLastUpdater());
        }
        if(brokers != null && brokers.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(brokers.getDr());
        }
        if(brokers != null && brokers.getCoopEndDate() != null){
			sql.append("  AND coop_end_date = ? ");
			param.add(brokers.getCoopEndDate());
        }
        if(brokers != null && brokers.getCoopStartData() != null){
			sql.append("  AND coop_start_data = ? ");
			param.add(brokers.getCoopStartData());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Brokers.class));
	}

	/**
	 * 根据对象查询条数
	 * @param brokers
	 * @return Long
	 */
	@Override
	public Long count(Brokers brokers){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_brokers ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(brokers != null && brokers.getBrokerId() != null){
			sql.append("  AND broker_id = ? ");
			param.add(brokers.getBrokerId());
        }
		if(brokers != null && brokers.getBrokerName() != null && !"".equals(brokers.getBrokerName())){
            sql.append("  AND broker_name = ? ");
			param.add(brokers.getBrokerName());
		}
		if(brokers != null && brokers.getBrokerCode() != null && !"".equals(brokers.getBrokerCode())){
            sql.append("  AND broker_code = ? ");
			param.add(brokers.getBrokerCode());
		}
		if(brokers != null && brokers.getBrokerClass() != null && !"".equals(brokers.getBrokerClass())){
            sql.append("  AND broker_class = ? ");
			param.add(brokers.getBrokerClass());
		}
		if(brokers != null && brokers.getBrokerState() != null && !"".equals(brokers.getBrokerState())){
            sql.append("  AND broker_state = ? ");
			param.add(brokers.getBrokerState());
		}
		if(brokers != null && brokers.getBrokerLocal() != null && !"".equals(brokers.getBrokerLocal())){
            sql.append("  AND broker_local = ? ");
			param.add(brokers.getBrokerLocal());
		}
		if(brokers != null && brokers.getBrokerAddress() != null && !"".equals(brokers.getBrokerAddress())){
            sql.append("  AND broker_address = ? ");
			param.add(brokers.getBrokerAddress());
		}
		if(brokers != null && brokers.getBrokerAppState() != null && !"".equals(brokers.getBrokerAppState())){
            sql.append("  AND broker_app_state = ? ");
			param.add(brokers.getBrokerAppState());
		}
        if(brokers != null && brokers.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(brokers.getCreatDate());
        }
        if(brokers != null && brokers.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(brokers.getCreator());
        }
        if(brokers != null && brokers.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(brokers.getLastUpdateDate());
        }
        if(brokers != null && brokers.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(brokers.getLastUpdater());
        }
        if(brokers != null && brokers.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(brokers.getDr());
        }
        if(brokers != null && brokers.getCoopEndDate() != null){
			sql.append("  AND coop_end_date = ? ");
			param.add(brokers.getCoopEndDate());
        }
        if(brokers != null && brokers.getCoopStartData() != null){
			sql.append("  AND coop_start_data = ? ");
			param.add(brokers.getCoopStartData());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}