package com.lhy.adminj.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.impl.UserLoginInfoBaseDaoImpl;
import com.lhy.adminj.basic.dao.UserLoginInfoDao;

import org.springframework.stereotype.Repository;
import com.lhy.adminj.basic.model.UserLoginInfo;

/**
 * 用户登陆日志Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UserLoginInfoDaoImpl extends UserLoginInfoBaseDaoImpl implements UserLoginInfoDao {

	/**
	 * 登陆数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	public List<Map<String, Object>> loginMonthCount(Integer year){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" 	b.year, b.month, b.num ");
		sql.append(" FROM ");
		sql.append(" 	(SELECT ");
		sql.append(" 		YEAR(a.create_date) year, ");
		sql.append(" 		MONTH(a.create_date) month, ");
		sql.append(" 		COUNT(*) num ");
		sql.append(" 	 FROM  umc_user_login_info a ");

		List<Object> param = new ArrayList<>();
		if(year != null){
			sql.append(" WHERE YEAR(a.create_date) = ? ");
			param.add(year);
		}
		sql.append(" 	 GROUP BY YEAR(a.create_date) , MONTH(a.create_date)");
		sql.append("	) b ");
		sql.append(" ORDER BY b.year asc, b.month asc, b.num ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}
}
