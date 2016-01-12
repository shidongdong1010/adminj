package com.lhy.adminj.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.impl.UserBehaviorLogBaseDaoImpl;
import com.lhy.adminj.basic.dao.UserBehaviorLogDao;

import com.lhy.adminj.basic.enumeration.UserBehaviorLogCodeEnum;
import org.springframework.stereotype.Repository;
import com.lhy.adminj.basic.model.UserBehaviorLog;

/**
 * 用户行为日志Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UserBehaviorLogDaoImpl extends UserBehaviorLogBaseDaoImpl implements UserBehaviorLogDao {

	/***
	 * 统计第一打打开APP的数量
	 * @return
	 */
	public Long countFirstOpenApp(){
		String sql = "select count(distinct client_id) from umc_user_behavior_log where code = ?";

		return jdbcTemplate.queryForObject(sql, Long.class, UserBehaviorLogCodeEnum.H.getCode());
	}

	/**
	 * 第一打打开APP的数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	public List<Map<String, Object>> firstOpenAppMonthCount(Integer year){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("    c.year, c.month, c.num ");
		sql.append("FROM ");
		sql.append("    (SELECT ");
		sql.append("        YEAR(a.time) year,");
		sql.append("            MONTH(a.time) month,");
		sql.append("            COUNT(DISTINCT a.client_id) num");
		sql.append("    FROM");
		sql.append("        umc_user_behavior_log a");
		sql.append("    INNER JOIN ( ");
		sql.append("    	SELECT ");
		sql.append("       	client_id, MIN(id) id");
		sql.append("    	FROM");
		sql.append("        umc_user_behavior_log");
		List<Object> param = new ArrayList<>();
		if(year != null) {
			sql.append("   WHERE YEAR(a.time) = ? ");
			param.add(year);
		}
		sql.append("    	GROUP BY client_id ");
		sql.append("    ) b ON a.id = b.id");
		sql.append("    GROUP BY YEAR(a.time) , MONTH(a.time)) c ");
		sql.append("ORDER BY c.year ASC , c.month ASC , c.num");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

	/**
	 * 统计行为日志
	 * @param year
	 * @return
	 */
	public List<Map<String, Object>> operationCount(Integer year){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ");
		sql.append("    YEAR(a.create_time) year, ");
		sql.append("    MONTH(a.create_time) month, ");
		sql.append("    a.code, ");
		sql.append("    COUNT(*) num ");
		sql.append(" FROM ");
		sql.append("    umc_user_behavior_log a ");
		List<Object> param = new ArrayList<>();
		if(year != null){
			sql.append(" WHERE  YEAR(a.create_time) = ?");
			param.add(year);
		}
		sql.append(" GROUP BY a.code , YEAR(a.create_time) , MONTH(a.create_time) ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}

}
