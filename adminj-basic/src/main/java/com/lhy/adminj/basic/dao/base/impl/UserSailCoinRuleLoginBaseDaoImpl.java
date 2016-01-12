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

import com.lhy.adminj.basic.dao.base.UserSailCoinRuleLoginBaseDao;
import com.lhy.adminj.basic.model.UserSailCoinRuleLogin;

/**
 * 登录航币奖励规则表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinRuleLoginBaseDaoImpl implements UserSailCoinRuleLoginBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`rule_id`, _this.`rule_type`, _this.`rule_name`, _this.`min_day`, _this.`max_day`, _this.`effe_time`, _this.`fail_time`, _this.`coin_num`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`rule_id`, _this.`rule_type`, _this.`rule_name`, _this.`min_day`, _this.`max_day`, _this.`effe_time`, _this.`fail_time`, _this.`coin_num` FROM umc_user_sail_coin_rule_login _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_sail_coin_rule_login(`rule_id`, `rule_type`, `rule_name`, `min_day`, `max_day`, `effe_time`, `fail_time`, `coin_num`) VALUES (:rule_id, :rule_type, :rule_name, :min_day, :max_day, :effe_time, :fail_time, :coin_num)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_sail_coin_rule_login SET `rule_id` = :rule_id, `rule_type` = :rule_type, `rule_name` = :rule_name, `min_day` = :min_day, `max_day` = :max_day, `effe_time` = :effe_time, `fail_time` = :fail_time, `coin_num` = :coin_num WHERE `rule_id` = :rule_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_sail_coin_rule_login WHERE `rule_id` = ?";

	@Override
	public void save(UserSailCoinRuleLogin userSailCoinRuleLogin) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userSailCoinRuleLogin);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userSailCoinRuleLogin.setRuleId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserSailCoinRuleLogin userSailCoinRuleLogin) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userSailCoinRuleLogin);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserSailCoinRuleLogin userSailCoinRuleLogin) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_sail_coin_rule_login SET ");
		if(userSailCoinRuleLogin.getRuleId() != null){
			sql.append(" rule_id = ?, ");
			param.add(userSailCoinRuleLogin.getRuleId());
		}
		if(userSailCoinRuleLogin.getRuleType() != null){
			sql.append(" rule_type = ?, ");
			param.add(userSailCoinRuleLogin.getRuleType());
		}
		if(userSailCoinRuleLogin.getRuleName() != null){
			sql.append(" rule_name = ?, ");
			param.add(userSailCoinRuleLogin.getRuleName());
		}
		if(userSailCoinRuleLogin.getMinDay() != null){
			sql.append(" min_day = ?, ");
			param.add(userSailCoinRuleLogin.getMinDay());
		}
		if(userSailCoinRuleLogin.getMaxDay() != null){
			sql.append(" max_day = ?, ");
			param.add(userSailCoinRuleLogin.getMaxDay());
		}
		if(userSailCoinRuleLogin.getEffeTime() != null){
			sql.append(" effe_time = ?, ");
			param.add(userSailCoinRuleLogin.getEffeTime());
		}
		if(userSailCoinRuleLogin.getFailTime() != null){
			sql.append(" fail_time = ?, ");
			param.add(userSailCoinRuleLogin.getFailTime());
		}
		if(userSailCoinRuleLogin.getCoinNum() != null){
			sql.append(" coin_num = ? ");
			param.add(userSailCoinRuleLogin.getCoinNum());
		}
		sql.append(" WHERE rule_id = ? ");
		param.add(userSailCoinRuleLogin.getRuleId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userSailCoinRuleLogins
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserSailCoinRuleLogin> userSailCoinRuleLogins){
		Map<String, Object>[] maps = new Map[userSailCoinRuleLogins.size()];
		for(int i = 0; i < userSailCoinRuleLogins.size(); i++){
			UserSailCoinRuleLogin userSailCoinRuleLogin = userSailCoinRuleLogins.get(i);
			maps[i] = toMap(userSailCoinRuleLogin);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userSailCoinRuleLogin
	 * @return
	 */
	public Map<String, Object> toMap(UserSailCoinRuleLogin userSailCoinRuleLogin){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("rule_id", userSailCoinRuleLogin.getRuleId());
        paramMap.put("rule_type", userSailCoinRuleLogin.getRuleType());
        paramMap.put("rule_name", userSailCoinRuleLogin.getRuleName());
        paramMap.put("min_day", userSailCoinRuleLogin.getMinDay());
        paramMap.put("max_day", userSailCoinRuleLogin.getMaxDay());
        paramMap.put("effe_time", userSailCoinRuleLogin.getEffeTime());
        paramMap.put("fail_time", userSailCoinRuleLogin.getFailTime());
        paramMap.put("coin_num", userSailCoinRuleLogin.getCoinNum());
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
	public void batchSave(List<UserSailCoinRuleLogin> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserSailCoinRuleLogin> list){
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
	 * @return UserSailCoinRuleLogin
	 */
	@Override
	public UserSailCoinRuleLogin findById(Long ruleId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`rule_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserSailCoinRuleLogin.class), ruleId);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @return List
	 */
	@Override
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin){
		return this.find(userSailCoinRuleLogin, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, String[][] orders){
		return this.find(userSailCoinRuleLogin, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, Long offset, Long rows){
		return this.find(userSailCoinRuleLogin, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinRuleLogin
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserSailCoinRuleLogin> find(UserSailCoinRuleLogin userSailCoinRuleLogin, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userSailCoinRuleLogin != null){
			if(userSailCoinRuleLogin.getRuleId() != null){
				sql.append(" AND _this.`rule_id` = ?");
				param.add(userSailCoinRuleLogin.getRuleId());
			}
			if(userSailCoinRuleLogin.getRuleType() != null && !"".equals(userSailCoinRuleLogin.getRuleType())){
				sql.append(" AND _this.`rule_type` = ?");
				param.add(userSailCoinRuleLogin.getRuleType());
			}
			if(userSailCoinRuleLogin.getRuleName() != null && !"".equals(userSailCoinRuleLogin.getRuleName())){
				sql.append(" AND _this.`rule_name` = ?");
				param.add(userSailCoinRuleLogin.getRuleName());
			}
			if(userSailCoinRuleLogin.getMinDay() != null){
				sql.append(" AND _this.`min_day` = ?");
				param.add(userSailCoinRuleLogin.getMinDay());
			}
			if(userSailCoinRuleLogin.getMaxDay() != null){
				sql.append(" AND _this.`max_day` = ?");
				param.add(userSailCoinRuleLogin.getMaxDay());
			}
			if(userSailCoinRuleLogin.getEffeTime() != null){
				sql.append(" AND _this.`effe_time` = ?");
				param.add(userSailCoinRuleLogin.getEffeTime());
			}
			if(userSailCoinRuleLogin.getFailTime() != null){
				sql.append(" AND _this.`fail_time` = ?");
				param.add(userSailCoinRuleLogin.getFailTime());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserSailCoinRuleLogin.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userSailCoinRuleLogin
	 * @return Long
	 */
	@Override
	public Long count(UserSailCoinRuleLogin userSailCoinRuleLogin){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_sail_coin_rule_login  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userSailCoinRuleLogin != null){
			if(userSailCoinRuleLogin.getRuleId() != null){
				sql.append(" AND _this.`rule_id` = ? ");
				param.add(userSailCoinRuleLogin.getRuleId());
			}
			if(userSailCoinRuleLogin.getRuleType() != null && !"".equals(userSailCoinRuleLogin.getRuleType())){
				sql.append(" AND _this.`rule_type` = ? ");
				param.add(userSailCoinRuleLogin.getRuleType());
			}
			if(userSailCoinRuleLogin.getRuleName() != null && !"".equals(userSailCoinRuleLogin.getRuleName())){
				sql.append(" AND _this.`rule_name` = ? ");
				param.add(userSailCoinRuleLogin.getRuleName());
			}
			if(userSailCoinRuleLogin.getMinDay() != null){
				sql.append(" AND _this.`min_day` = ? ");
				param.add(userSailCoinRuleLogin.getMinDay());
			}
			if(userSailCoinRuleLogin.getMaxDay() != null){
				sql.append(" AND _this.`max_day` = ? ");
				param.add(userSailCoinRuleLogin.getMaxDay());
			}
			if(userSailCoinRuleLogin.getEffeTime() != null){
				sql.append(" AND _this.`effe_time` = ? ");
				param.add(userSailCoinRuleLogin.getEffeTime());
			}
			if(userSailCoinRuleLogin.getFailTime() != null){
				sql.append(" AND _this.`fail_time` = ? ");
				param.add(userSailCoinRuleLogin.getFailTime());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}