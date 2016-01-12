package com.lhy.adminj.basic.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.impl.UserSailCoinRuleBaseDaoImpl;
import com.lhy.adminj.basic.dao.UserSailCoinRuleDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lhy.adminj.basic.model.UserSailCoinRule;

/**
 * 航币奖励规则表(除登录)Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UserSailCoinRuleDaoImpl extends UserSailCoinRuleBaseDaoImpl implements UserSailCoinRuleDao {

	@Override
	public void updateCoin(String types) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE umc_user_sail_coin_rule ");
		sql.append("    SET ");
        sql.append("        fail_time     = NOW() ");	
    	sql.append("  WHERE rule_type in (");
    	sql.append(types);
    	sql.append(")");
		// 构造SQL的参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}

	@Override
	public List<UserSailCoinRule> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM umc_user_sail_coin_rule _this ");
		sql.append(" WHERE 1 = 1 and  _this.fail_time is null ");
		List<Object> param = new ArrayList<Object>();
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserSailCoinRule.class));
	}
	@Override
	public List<UserSailCoinRule> findEffective(UserSailCoinRule userSailCoinRule, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 AND _this.effe_time<= NOW() AND  _this.fail_time is null ");

		List<Object> param = new ArrayList<Object>();
    	if(userSailCoinRule != null){
			if(userSailCoinRule.getRuleId() != null){
				sql.append(" AND _this.rule_id = ?");
				param.add(userSailCoinRule.getRuleId());
			}
			if(userSailCoinRule.getRuleType() != null && !"".equals(userSailCoinRule.getRuleType())){
				sql.append(" AND _this.rule_type = ?");
				param.add(userSailCoinRule.getRuleType());
			}
			if(userSailCoinRule.getRuleName() != null && !"".equals(userSailCoinRule.getRuleName())){
				sql.append(" AND _this.rule_name = ?");
				param.add(userSailCoinRule.getRuleName());
			}
			if(userSailCoinRule.getEffeTime() != null){
				sql.append(" AND _this.effe_time = ?");
				param.add(userSailCoinRule.getEffeTime());
			}
			if(userSailCoinRule.getFailTime() != null){
				sql.append(" AND _this.fail_time = ?");
				param.add(userSailCoinRule.getFailTime());
			}
		}

		// 排序
		if(orders != null && orders.length > 0){
   			sql.append(" ORDER BY ");
			for(int i = 0; i < orders.length; i++){
    			String[] order = orders[i];
				if(i != 0){
    				sql.append(order[0]).append(", ");
				}
				if(order.length == 1){
    				sql.append(order[0]).append(" ASC");
				}else{
    				sql.append(order[0]).append(" ").append(order[1]);
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

}
