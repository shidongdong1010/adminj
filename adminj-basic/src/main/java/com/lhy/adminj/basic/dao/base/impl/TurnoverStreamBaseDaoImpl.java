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

import com.lhy.adminj.basic.dao.base.TurnoverStreamBaseDao;
import com.lhy.adminj.basic.model.TurnoverStream;

/**
 * Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class TurnoverStreamBaseDaoImpl implements TurnoverStreamBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void save(TurnoverStream turnoverStream) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO smc_turnover_stream ");
		sql.append("   (  ");
		sql.append("		id,  ");
		sql.append("		date,  ");
		sql.append("		stock_id,  ");
		sql.append("		content,  ");
		sql.append("		fid_kkh  ");
		sql.append("   )  ");
		sql.append(" VALUES ");
		sql.append("   (  ");
		sql.append("		null,  ");
		sql.append("		:date,  ");
		sql.append("		:stock_id,  ");
		sql.append("		:content,  ");
		sql.append("		:fid_kkh  ");
		sql.append("   )  ");

		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(turnoverStream);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		turnoverStream.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(TurnoverStream turnoverStream) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE smc_turnover_stream ");
		sql.append("    SET ");
        sql.append("        id     = :id, ");
        sql.append("        date     = :date, ");
        sql.append("        stock_id     = :stock_id, ");
        sql.append("        content     = :content, ");
    	sql.append("        fid_kkh     = :fid_kkh ");
		sql.append("  WHERE id = :id ");
		
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(turnoverStream);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}
	
	/**
	 * 将对象转换成Map
	 * @param turnoverStream
	 * @return
	 */
	public Map<String, Object> toMap(TurnoverStream turnoverStream){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", turnoverStream.getId());
        paramMap.put("date", turnoverStream.getDate());
        paramMap.put("stock_id", turnoverStream.getStockId());
        paramMap.put("content", turnoverStream.getContent());
        paramMap.put("fid_kkh", turnoverStream.getFidKkh());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		StringBuilder sql = new StringBuilder();
        sql.append("id, ");
        sql.append("date, ");
        sql.append("stock_id, ");
        sql.append("content, ");
		sql.append("fid_kkh ");
		return sql.toString();
	}

	@Override
	public void delete(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE ");
		sql.append("   FROM smc_turnover_stream ");
		sql.append(" WHERE id = ? ");

		jdbcTemplate.update(sql.toString(), id);
	}

	/**
	 * 根据主键查询
	 * @param id 
	 * @return TurnoverStream
	 */
	@Override
	public TurnoverStream findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_turnover_stream ");
		sql.append(" WHERE id = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(TurnoverStream.class), id);
	}

	/**
	 * 根据对象查询
	 * @param turnoverStream
	 * @return List
	 */
	@Override
	public List<TurnoverStream> find(TurnoverStream turnoverStream){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_turnover_stream ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(turnoverStream != null && turnoverStream.getId() != null){
			sql.append("  AND id = ? ");
			param.add(turnoverStream.getId());
        }
        if(turnoverStream != null && turnoverStream.getDate() != null){
			sql.append("  AND date = ? ");
			param.add(turnoverStream.getDate());
        }
        if(turnoverStream != null && turnoverStream.getStockId() != null){
			sql.append("  AND stock_id = ? ");
			param.add(turnoverStream.getStockId());
        }
		if(turnoverStream != null && turnoverStream.getContent() != null && !"".equals(turnoverStream.getContent())){
            sql.append("  AND content = ? ");
			param.add(turnoverStream.getContent());
		}
        if(turnoverStream != null && turnoverStream.getFidKkh() != null){
			sql.append("  AND fid_kkh = ? ");
			param.add(turnoverStream.getFidKkh());
        }
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(TurnoverStream.class));
	}

	/**
	 * 根据对象查询
	 * @param turnoverStream
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<TurnoverStream> find(TurnoverStream turnoverStream, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM smc_turnover_stream ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(turnoverStream != null && turnoverStream.getId() != null){
			sql.append("  AND id = ? ");
			param.add(turnoverStream.getId());
        }
        if(turnoverStream != null && turnoverStream.getDate() != null){
			sql.append("  AND date = ? ");
			param.add(turnoverStream.getDate());
        }
        if(turnoverStream != null && turnoverStream.getStockId() != null){
			sql.append("  AND stock_id = ? ");
			param.add(turnoverStream.getStockId());
        }
		if(turnoverStream != null && turnoverStream.getContent() != null && !"".equals(turnoverStream.getContent())){
            sql.append("  AND content = ? ");
			param.add(turnoverStream.getContent());
		}
        if(turnoverStream != null && turnoverStream.getFidKkh() != null){
			sql.append("  AND fid_kkh = ? ");
			param.add(turnoverStream.getFidKkh());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(TurnoverStream.class));
	}

	/**
	 * 根据对象查询条数
	 * @param turnoverStream
	 * @return Long
	 */
	@Override
	public Long count(TurnoverStream turnoverStream){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("       count(*) ");
		sql.append("  FROM smc_turnover_stream ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(turnoverStream != null && turnoverStream.getId() != null){
			sql.append("  AND id = ? ");
			param.add(turnoverStream.getId());
        }
        if(turnoverStream != null && turnoverStream.getDate() != null){
			sql.append("  AND date = ? ");
			param.add(turnoverStream.getDate());
        }
        if(turnoverStream != null && turnoverStream.getStockId() != null){
			sql.append("  AND stock_id = ? ");
			param.add(turnoverStream.getStockId());
        }
		if(turnoverStream != null && turnoverStream.getContent() != null && !"".equals(turnoverStream.getContent())){
            sql.append("  AND content = ? ");
			param.add(turnoverStream.getContent());
		}
        if(turnoverStream != null && turnoverStream.getFidKkh() != null){
			sql.append("  AND fid_kkh = ? ");
			param.add(turnoverStream.getFidKkh());
        }
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}