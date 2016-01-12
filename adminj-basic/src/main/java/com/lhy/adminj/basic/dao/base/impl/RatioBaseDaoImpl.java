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

import com.lhy.adminj.basic.dao.base.RatioBaseDao;
import com.lhy.adminj.basic.model.Ratio;

/**
 * 浮动表(涨幅、跌幅、换手率、振幅榜)Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class RatioBaseDaoImpl implements RatioBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(Ratio ratio) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_ratio ");
		sql.append("   (  ");
		sql.append("		ratio_id,  ");
		sql.append("		stock_code,  ");
		sql.append("		stock_name,  ");
		sql.append("		stock_price,  ");
		sql.append("		stock_zf,  ");
		sql.append("		stock_up,  ");
		sql.append("		stock_down,  ");
		sql.append("		stock_hsl,  ");
		sql.append("		stock_zfb,  ");
		sql.append("		creat_date,  ");
		sql.append("		creator,  ");
		sql.append("		last_update_date,  ");
		sql.append("		last_updater,  ");
		sql.append("		dr  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:stock_code,  ");
		sql.append("		:stock_name,  ");
		sql.append("		:stock_price,  ");
		sql.append("		:stock_zf,  ");
		sql.append("		:stock_up,  ");
		sql.append("		:stock_down,  ");
		sql.append("		:stock_hsl,  ");
		sql.append("		:stock_zfb,  ");
		sql.append("		:creat_date,  ");
		sql.append("		:creator,  ");
		sql.append("		:last_update_date,  ");
		sql.append("		:last_updater,  ");
		sql.append("		:dr  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(ratio);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		ratio.setRatioId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(Ratio ratio) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_ratio ");
		sql.append("    SET ");
        sql.append("        ratio_id     = :ratio_id, ");
        sql.append("        stock_code     = :stock_code, ");
        sql.append("        stock_name     = :stock_name, ");
        sql.append("        stock_price     = :stock_price, ");
        sql.append("        stock_zf     = :stock_zf, ");
        sql.append("        stock_up     = :stock_up, ");
        sql.append("        stock_down     = :stock_down, ");
        sql.append("        stock_hsl     = :stock_hsl, ");
        sql.append("        stock_zfb     = :stock_zfb, ");
        sql.append("        creat_date     = :creat_date, ");
        sql.append("        creator     = :creator, ");
        sql.append("        last_update_date     = :last_update_date, ");
        sql.append("        last_updater     = :last_updater, ");
    	sql.append("        dr     = :dr ");
		sql.append("  WHERE ratio_id = :ratio_id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(ratio);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param ratio
	 * @return
	 */
	public Map<String, Object> toMap(Ratio ratio){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ratio_id", ratio.getRatioId());
        paramMap.put("stock_code", ratio.getStockCode());
        paramMap.put("stock_name", ratio.getStockName());
        paramMap.put("stock_price", ratio.getStockPrice());
        paramMap.put("stock_zf", ratio.getStockZf());
        paramMap.put("stock_up", ratio.getStockUp());
        paramMap.put("stock_down", ratio.getStockDown());
        paramMap.put("stock_hsl", ratio.getStockHsl());
        paramMap.put("stock_zfb", ratio.getStockZfb());
        paramMap.put("creat_date", ratio.getCreatDate());
        paramMap.put("creator", ratio.getCreator());
        paramMap.put("last_update_date", ratio.getLastUpdateDate());
        paramMap.put("last_updater", ratio.getLastUpdater());
        paramMap.put("dr", ratio.getDr());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("ratio_id, ");
        sql.append("stock_code, ");
        sql.append("stock_name, ");
        sql.append("stock_price, ");
        sql.append("stock_zf, ");
        sql.append("stock_up, ");
        sql.append("stock_down, ");
        sql.append("stock_hsl, ");
        sql.append("stock_zfb, ");
        sql.append("creat_date, ");
        sql.append("creator, ");
        sql.append("last_update_date, ");
        sql.append("last_updater, ");
		sql.append("dr ");
		return sql.toString();
	}

	@Override
	public void delete(Long ratioId){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_ratio ");
		sql.append(" WHERE ratio_id = ? ");

		jdbcTemplate.update(sql.toString(), ratioId);
	}

	/**
	 * 根据主键查询
	 * @param ratioId 浮动表主键
	 * @return Ratio
	 */
	@Override
	public Ratio findById(Long ratioId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_ratio ");
		sql.append(" WHERE ratio_id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(Ratio.class), ratioId);
	}

	/**
	 * 根据对象查询
	 * @param ratio
	 * @return List
	 */
	@Override
	public List<Ratio> find(Ratio ratio){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_ratio ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(ratio != null && ratio.getRatioId() != null){
			sql.append("  AND ratio_id = ? ");
			param.add(ratio.getRatioId());
        }
		if(ratio != null && ratio.getStockCode() != null && !"".equals(ratio.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(ratio.getStockCode());
		}
		if(ratio != null && ratio.getStockName() != null && !"".equals(ratio.getStockName())){
            sql.append("  AND stock_name = ? ");
			param.add(ratio.getStockName());
		}
        if(ratio != null && ratio.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(ratio.getCreatDate());
        }
        if(ratio != null && ratio.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(ratio.getCreator());
        }
        if(ratio != null && ratio.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(ratio.getLastUpdateDate());
        }
        if(ratio != null && ratio.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(ratio.getLastUpdater());
        }
        if(ratio != null && ratio.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(ratio.getDr());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Ratio.class));
	}

	/**
	 * 根据对象查询
	 * @param ratio
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<Ratio> find(Ratio ratio, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_ratio ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(ratio != null && ratio.getRatioId() != null){
			sql.append("  AND ratio_id = ? ");
			param.add(ratio.getRatioId());
        }
		if(ratio != null && ratio.getStockCode() != null && !"".equals(ratio.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(ratio.getStockCode());
		}
		if(ratio != null && ratio.getStockName() != null && !"".equals(ratio.getStockName())){
            sql.append("  AND stock_name = ? ");
			param.add(ratio.getStockName());
		}
        if(ratio != null && ratio.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(ratio.getCreatDate());
        }
        if(ratio != null && ratio.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(ratio.getCreator());
        }
        if(ratio != null && ratio.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(ratio.getLastUpdateDate());
        }
        if(ratio != null && ratio.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(ratio.getLastUpdater());
        }
        if(ratio != null && ratio.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(ratio.getDr());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(Ratio.class));
	}

	/**
	 * 根据对象查询条数
	 * @param ratio
	 * @return Long
	 */
	@Override
	public Long count(Ratio ratio){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_ratio ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(ratio != null && ratio.getRatioId() != null){
			sql.append("  AND ratio_id = ? ");
			param.add(ratio.getRatioId());
        }
		if(ratio != null && ratio.getStockCode() != null && !"".equals(ratio.getStockCode())){
            sql.append("  AND stock_code = ? ");
			param.add(ratio.getStockCode());
		}
		if(ratio != null && ratio.getStockName() != null && !"".equals(ratio.getStockName())){
            sql.append("  AND stock_name = ? ");
			param.add(ratio.getStockName());
		}
        if(ratio != null && ratio.getCreatDate() != null){
			sql.append("  AND creat_date = ? ");
			param.add(ratio.getCreatDate());
        }
        if(ratio != null && ratio.getCreator() != null){
			sql.append("  AND creator = ? ");
			param.add(ratio.getCreator());
        }
        if(ratio != null && ratio.getLastUpdateDate() != null){
			sql.append("  AND last_update_date = ? ");
			param.add(ratio.getLastUpdateDate());
        }
        if(ratio != null && ratio.getLastUpdater() != null){
			sql.append("  AND last_updater = ? ");
			param.add(ratio.getLastUpdater());
        }
        if(ratio != null && ratio.getDr() != null){
			sql.append("  AND dr = ? ");
			param.add(ratio.getDr());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}