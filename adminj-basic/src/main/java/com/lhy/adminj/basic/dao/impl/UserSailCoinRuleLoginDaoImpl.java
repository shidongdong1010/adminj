package com.lhy.adminj.basic.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.impl.UserSailCoinRuleLoginBaseDaoImpl;
import com.lhy.adminj.basic.dao.UserSailCoinRuleLoginDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lhy.adminj.basic.model.UserSailCoinRuleLogin;

/**
 * 登录航币奖励规则表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UserSailCoinRuleLoginDaoImpl extends UserSailCoinRuleLoginBaseDaoImpl implements UserSailCoinRuleLoginDao {

	@Override
	public void updateCoin() {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE umc_user_sail_coin_rule_login ");
		sql.append("    SET ");
        sql.append("        fail_time     = NOW() ");
		// 构造SQL的参数
		Map<String, Object> paramMap = new HashMap<String, Object>();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(sql.toString(), paramMap);
	}

	@Override
	public List<UserSailCoinRuleLogin> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn());
		sql.append("   FROM umc_user_sail_coin_rule_login _this ");
		sql.append(" WHERE 1 = 1  AND _this.fail_time is null ");
		List<Object> param = new ArrayList<Object>();
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserSailCoinRuleLogin.class));
	}

	/** 此处写一些算定义的方法，不要修改Base的方法 **/
}
