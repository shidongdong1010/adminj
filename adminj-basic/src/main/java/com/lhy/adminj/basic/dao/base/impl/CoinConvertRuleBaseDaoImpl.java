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

import com.lhy.adminj.basic.dao.base.CoinConvertRuleBaseDao;
import com.lhy.adminj.basic.model.CoinConvertRule;

/**
 * 航币兑换规则Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class CoinConvertRuleBaseDaoImpl implements CoinConvertRuleBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`coin`, _this.`rmb`, _this.`begin_time`, _this.`end_time`, _this.`is_enable`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`coin`, _this.`rmb`, _this.`begin_time`, _this.`end_time`, _this.`is_enable` FROM umc_coin_convert_rule _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_coin_convert_rule(`id`, `coin`, `rmb`, `begin_time`, `end_time`, `is_enable`) VALUES (:id, :coin, :rmb, :begin_time, :end_time, :is_enable)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_coin_convert_rule SET `id` = :id, `coin` = :coin, `rmb` = :rmb, `begin_time` = :begin_time, `end_time` = :end_time, `is_enable` = :is_enable WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_coin_convert_rule WHERE `id` = ?";

	@Override
	public void save(CoinConvertRule coinConvertRule) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(coinConvertRule);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		coinConvertRule.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(CoinConvertRule coinConvertRule) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(coinConvertRule);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(CoinConvertRule coinConvertRule) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_coin_convert_rule SET ");
		if(coinConvertRule.getId() != null){
			sql.append(" id = ?, ");
			param.add(coinConvertRule.getId());
		}
		if(coinConvertRule.getCoin() != null){
			sql.append(" coin = ?, ");
			param.add(coinConvertRule.getCoin());
		}
		if(coinConvertRule.getRmb() != null){
			sql.append(" rmb = ?, ");
			param.add(coinConvertRule.getRmb());
		}
		if(coinConvertRule.getBeginTime() != null){
			sql.append(" begin_time = ?, ");
			param.add(coinConvertRule.getBeginTime());
		}
		if(coinConvertRule.getEndTime() != null){
			sql.append(" end_time = ?, ");
			param.add(coinConvertRule.getEndTime());
		}
		if(coinConvertRule.getIsEnable() != null){
			sql.append(" is_enable = ? ");
			param.add(coinConvertRule.getIsEnable());
		}
		sql.append(" WHERE id = ? ");
		param.add(coinConvertRule.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param coinConvertRules
	 * @return
	 */
	public Map<String, Object>[] toMap(List<CoinConvertRule> coinConvertRules){
		Map<String, Object>[] maps = new Map[coinConvertRules.size()];
		for(int i = 0; i < coinConvertRules.size(); i++){
			CoinConvertRule coinConvertRule = coinConvertRules.get(i);
			maps[i] = toMap(coinConvertRule);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param coinConvertRule
	 * @return
	 */
	public Map<String, Object> toMap(CoinConvertRule coinConvertRule){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", coinConvertRule.getId());
        paramMap.put("coin", coinConvertRule.getCoin());
        paramMap.put("rmb", coinConvertRule.getRmb());
        paramMap.put("begin_time", coinConvertRule.getBeginTime());
        paramMap.put("end_time", coinConvertRule.getEndTime());
        paramMap.put("is_enable", coinConvertRule.getIsEnable());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		return SELECT_COLUMN_SQL;
	}

	@Override
	public void delete(Long id){
		jdbcTemplate.update(DELETE_SQL, id);
	}

	@Override
	public void batchSave(List<CoinConvertRule> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<CoinConvertRule> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(UPDATE_SQL, params);
	}

	@Override
	public void batchDelete(List<Long> ids){
        List<Object[]> list = new ArrayList<Object[]>();
        for(Long id : ids){
            list.add(new Object[]{id});
        }
        jdbcTemplate.batchUpdate(DELETE_SQL, list);
	}


	/**
	 * 根据主键查询
	 * @param id 
	 * @return CoinConvertRule
	 */
	@Override
	public CoinConvertRule findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(CoinConvertRule.class), id);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @return List
	 */
	@Override
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule){
		return this.find(coinConvertRule, null, null);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, String[][] orders){
		return this.find(coinConvertRule, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertRule
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, Long offset, Long rows){
		return this.find(coinConvertRule, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(coinConvertRule != null){
			if(coinConvertRule.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(coinConvertRule.getId());
			}
			if(coinConvertRule.getBeginTime() != null){
				sql.append(" AND _this.`begin_time` = ?");
				param.add(coinConvertRule.getBeginTime());
			}
			if(coinConvertRule.getEndTime() != null){
				sql.append(" AND _this.`end_time` = ?");
				param.add(coinConvertRule.getEndTime());
			}
			if(coinConvertRule.getIsEnable() != null){
				sql.append(" AND _this.`is_enable` = ?");
				param.add(coinConvertRule.getIsEnable());
			}
		}

		// 排序
		if(orders != null && orders.length > 0){
   			sql.append(" ORDER BY ");
			for(int i = 0; i < orders.length; i++){
    			String[] order = orders[i];
				if(i != 0){
    				sql.append("_this.`").append(order[0]).append("`, ");
				}
				if(order.length == 1){
    				sql.append("_this.`").append(order[0]).append("` ASC ");
				}else{
    				sql.append("_this.`").append(order[0]).append("` ").append(order[1]);
				}
			}
		}

		// 分页
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(CoinConvertRule.class));
	}


	/**
	 * 根据对象查询条数
	 * @param coinConvertRule
	 * @return Long
	 */
	@Override
	public Long count(CoinConvertRule coinConvertRule){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_coin_convert_rule  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(coinConvertRule != null){
			if(coinConvertRule.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(coinConvertRule.getId());
			}
			if(coinConvertRule.getBeginTime() != null){
				sql.append(" AND _this.`begin_time` = ? ");
				param.add(coinConvertRule.getBeginTime());
			}
			if(coinConvertRule.getEndTime() != null){
				sql.append(" AND _this.`end_time` = ? ");
				param.add(coinConvertRule.getEndTime());
			}
			if(coinConvertRule.getIsEnable() != null){
				sql.append(" AND _this.`is_enable` = ? ");
				param.add(coinConvertRule.getIsEnable());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}