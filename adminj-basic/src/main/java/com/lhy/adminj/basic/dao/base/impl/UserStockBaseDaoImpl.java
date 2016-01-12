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

import com.lhy.adminj.basic.dao.base.UserStockBaseDao;
import com.lhy.adminj.basic.model.UserStock;

/**
 * 自选股Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStockBaseDaoImpl implements UserStockBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(UserStock userStock) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO tmc_user_stock ");
		sql.append("   (  ");
		sql.append("		user_stock_id,  ");
		sql.append("		user_id,  ");
		sql.append("		name,  ");
		sql.append("		code,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		:user_stock_id,  ");
		sql.append("		null,  ");
		sql.append("		:name,  ");
		sql.append("		:code,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userStock);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userStock.setUserId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserStock userStock) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE tmc_user_stock ");
		sql.append("    SET ");
        sql.append("        user_stock_id     = :user_stock_id, ");
        sql.append("        user_id     = :user_id, ");
        sql.append("        name     = :name, ");
        sql.append("        code     = :code, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
    	sql.append("        dr     = :dr ");
		sql.append("  WHERE user_id = :user_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userStock);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param userStock
	 * @return
	 */
	public Map<String, Object> toMap(UserStock userStock){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_stock_id", userStock.getUserStockId());
        paramMap.put("user_id", userStock.getUserId());
        paramMap.put("name", userStock.getName());
        paramMap.put("code", userStock.getCode());
        paramMap.put("creat_date", userStock.getCreatDate());
        paramMap.put("creator", userStock.getCreator());
        paramMap.put("last_update_date", userStock.getLastUpdateDate());
        paramMap.put("last_updater", userStock.getLastUpdater());
        paramMap.put("dr", userStock.getDr());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("user_stock_id, ");
        sql.append("user_id, ");
        sql.append("name, ");
        sql.append("code, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
		sql.append("dr ");
		return sql.toString();
	}

	@Override
	public void delete(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM tmc_user_stock ");
		sql.append(" WHERE user_id = ? ");

		jdbcTemplate.update(sql.toString(), userId);
	}

	/**
	 * 根据主键查询
	 * @param userId 平台用户
	 * @return UserStock
	 */
	@Override
	public UserStock findById(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM tmc_user_stock ");
		sql.append(" WHERE user_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserStock.class), userId);
	}

	/**
	 * 根据对象查询
	 * @param userStock
	 * @return List
	 */
	@Override
	public List<UserStock> find(UserStock userStock){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM tmc_user_stock ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userStock != null && userStock.getUserStockId() != null){
			sql.append("  AND user_stock_id = ? ");
			param.add(userStock.getUserStockId());
        }
        if(userStock != null && userStock.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(userStock.getUserId());
        }
		if(userStock != null && userStock.getName() != null && !"".equals(userStock.getName())){
            sql.append("  AND name = ? ");
			param.add(userStock.getName());
		}
		if(userStock != null && userStock.getCode() != null && !"".equals(userStock.getCode())){
            sql.append("  AND code = ? ");
			param.add(userStock.getCode());
		}
        if(userStock != null && userStock.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(userStock.getCreatDate());
        }
        if(userStock != null && userStock.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(userStock.getCreator());
        }
        if(userStock != null && userStock.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(userStock.getLastUpdateDate());
        }
        if(userStock != null && userStock.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(userStock.getLastUpdater());
        }
        if(userStock != null && userStock.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(userStock.getDr());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserStock.class));
	}

	/**
	 * 根据对象查询
	 * @param userStock
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserStock> find(UserStock userStock, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM tmc_user_stock ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userStock != null && userStock.getUserStockId() != null){
			sql.append("  AND user_stock_id = ? ");
			param.add(userStock.getUserStockId());
        }
        if(userStock != null && userStock.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(userStock.getUserId());
        }
		if(userStock != null && userStock.getName() != null && !"".equals(userStock.getName())){
            sql.append("  AND name = ? ");
			param.add(userStock.getName());
		}
		if(userStock != null && userStock.getCode() != null && !"".equals(userStock.getCode())){
            sql.append("  AND code = ? ");
			param.add(userStock.getCode());
		}
        if(userStock != null && userStock.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(userStock.getCreatDate());
        }
        if(userStock != null && userStock.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(userStock.getCreator());
        }
        if(userStock != null && userStock.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(userStock.getLastUpdateDate());
        }
        if(userStock != null && userStock.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(userStock.getLastUpdater());
        }
        if(userStock != null && userStock.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(userStock.getDr());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserStock.class));
	}

	/**
	 * 根据对象查询条数
	 * @param userStock
	 * @return Long
	 */
	@Override
	public Long count(UserStock userStock){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM tmc_user_stock ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userStock != null && userStock.getUserStockId() != null){
			sql.append("  AND user_stock_id = ? ");
			param.add(userStock.getUserStockId());
        }
        if(userStock != null && userStock.getUserId() != null){
			sql.append("  AND user_id = ? ");
			param.add(userStock.getUserId());
        }
		if(userStock != null && userStock.getName() != null && !"".equals(userStock.getName())){
            sql.append("  AND name = ? ");
			param.add(userStock.getName());
		}
		if(userStock != null && userStock.getCode() != null && !"".equals(userStock.getCode())){
            sql.append("  AND code = ? ");
			param.add(userStock.getCode());
		}
        if(userStock != null && userStock.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(userStock.getCreatDate());
        }
        if(userStock != null && userStock.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(userStock.getCreator());
        }
        if(userStock != null && userStock.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(userStock.getLastUpdateDate());
        }
        if(userStock != null && userStock.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(userStock.getLastUpdater());
        }
        if(userStock != null && userStock.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(userStock.getDr());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}