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

import com.lhy.adminj.basic.dao.base.UserSailCoinRuleBaseDao;
import com.lhy.adminj.basic.model.UserSailCoinRule;

/**
 * 航币奖励规则表(除登录)Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinRuleBaseDaoImpl implements UserSailCoinRuleBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`rule_id`, _this.`rule_type`, _this.`rule_name`, _this.`effe_time`, _this.`fail_time`, _this.`coin_num`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`rule_id`, _this.`rule_type`, _this.`rule_name`, _this.`effe_time`, _this.`fail_time`, _this.`coin_num` FROM umc_user_sail_coin_rule _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_sail_coin_rule(`rule_id`, `rule_type`, `rule_name`, `effe_time`, `fail_time`, `coin_num`) VALUES (:rule_id, :rule_type, :rule_name, :effe_time, :fail_time, :coin_num)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_sail_coin_rule SET `rule_id` = :rule_id, `rule_type` = :rule_type, `rule_name` = :rule_name, `effe_time` = :effe_time, `fail_time` = :fail_time, `coin_num` = :coin_num WHERE `rule_id` = :rule_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_sail_coin_rule WHERE `rule_id` = ?";

	@Override
	public void save(UserSailCoinRule userSailCoinRule) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userSailCoinRule);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userSailCoinRule.setRuleId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserSailCoinRule userSailCoinRule) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userSailCoinRule);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserSailCoinRule userSailCoinRule) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_sail_coin_rule SET ");
		if(userSailCoinRule.getRuleId() != null){
			sql.append(" rule_id = ?, ");
			param.add(userSailCoinRule.getRuleId());
		}
		if(userSailCoinRule.getRuleType() != null){
			sql.append(" rule_type = ?, ");
			param.add(userSailCoinRule.getRuleType());
		}
		if(userSailCoinRule.getRuleName() != null){
			sql.append(" rule_name = ?, ");
			param.add(userSailCoinRule.getRuleName());
		}
		if(userSailCoinRule.getEffeTime() != null){
			sql.append(" effe_time = ?, ");
			param.add(userSailCoinRule.getEffeTime());
		}
		if(userSailCoinRule.getFailTime() != null){
			sql.append(" fail_time = ?, ");
			param.add(userSailCoinRule.getFailTime());
		}
		if(userSailCoinRule.getCoinNum() != null){
			sql.append(" coin_num = ? ");
			param.add(userSailCoinRule.getCoinNum());
		}
		sql.append(" WHERE rule_id = ? ");
		param.add(userSailCoinRule.getRuleId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userSailCoinRules
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserSailCoinRule> userSailCoinRules){
		Map<String, Object>[] maps = new Map[userSailCoinRules.size()];
		for(int i = 0; i < userSailCoinRules.size(); i++){
			UserSailCoinRule userSailCoinRule = userSailCoinRules.get(i);
			maps[i] = toMap(userSailCoinRule);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userSailCoinRule
	 * @return
	 */
	public Map<String, Object> toMap(UserSailCoinRule userSailCoinRule){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("rule_id", userSailCoinRule.getRuleId());
        paramMap.put("rule_type", userSailCoinRule.getRuleType());
        paramMap.put("rule_name", userSailCoinRule.getRuleName());
        paramMap.put("effe_time", userSailCoinRule.getEffeTime());
        paramMap.put("fail_time", userSailCoinRule.getFailTime());
        paramMap.put("coin_num", userSailCoinRule.getCoinNum());
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
	public void delete(Long ruleId){
		jdbcTemplate.update(DELETE_SQL, ruleId);
	}

	@Override
	public void batchSave(List<UserSailCoinRule> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserSailCoinRule> list){
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
	 * @param ruleId 规则ID
	 * @return UserSailCoinRule
	 */
	@Override
	public UserSailCoinRule findById(Long ruleId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`rule_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserSailCoinRule.class), ruleId);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @return List
	 */
	@Override
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule){
		return this.find(userSailCoinRule, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, String[][] orders){
		return this.find(userSailCoinRule, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, Long offset, Long rows){
		return this.find(userSailCoinRule, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserSailCoinRule> find(UserSailCoinRule userSailCoinRule, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userSailCoinRule != null){
			if(userSailCoinRule.getRuleId() != null){
				sql.append(" AND _this.`rule_id` = ?");
				param.add(userSailCoinRule.getRuleId());
			}
			if(userSailCoinRule.getRuleType() != null && !"".equals(userSailCoinRule.getRuleType())){
				sql.append(" AND _this.`rule_type` = ?");
				param.add(userSailCoinRule.getRuleType());
			}
			if(userSailCoinRule.getRuleName() != null && !"".equals(userSailCoinRule.getRuleName())){
				sql.append(" AND _this.`rule_name` = ?");
				param.add(userSailCoinRule.getRuleName());
			}
			if(userSailCoinRule.getEffeTime() != null){
				sql.append(" AND _this.`effe_time` = ?");
				param.add(userSailCoinRule.getEffeTime());
			}
			if(userSailCoinRule.getFailTime() != null){
				sql.append(" AND _this.`fail_time` = ?");
				param.add(userSailCoinRule.getFailTime());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserSailCoinRule.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userSailCoinRule
	 * @return Long
	 */
	@Override
	public Long count(UserSailCoinRule userSailCoinRule){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_sail_coin_rule  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userSailCoinRule != null){
			if(userSailCoinRule.getRuleId() != null){
				sql.append(" AND _this.`rule_id` = ? ");
				param.add(userSailCoinRule.getRuleId());
			}
			if(userSailCoinRule.getRuleType() != null && !"".equals(userSailCoinRule.getRuleType())){
				sql.append(" AND _this.`rule_type` = ? ");
				param.add(userSailCoinRule.getRuleType());
			}
			if(userSailCoinRule.getRuleName() != null && !"".equals(userSailCoinRule.getRuleName())){
				sql.append(" AND _this.`rule_name` = ? ");
				param.add(userSailCoinRule.getRuleName());
			}
			if(userSailCoinRule.getEffeTime() != null){
				sql.append(" AND _this.`effe_time` = ? ");
				param.add(userSailCoinRule.getEffeTime());
			}
			if(userSailCoinRule.getFailTime() != null){
				sql.append(" AND _this.`fail_time` = ? ");
				param.add(userSailCoinRule.getFailTime());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}