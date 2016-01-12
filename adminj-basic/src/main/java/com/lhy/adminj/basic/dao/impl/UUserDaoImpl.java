package com.lhy.adminj.basic.dao.impl;

import java.util.List;

import com.lhy.adminj.basic.dao.base.impl.UUserBaseDaoImpl;
import com.lhy.adminj.basic.dao.UUserDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.lhy.adminj.basic.model.UUser;

/**
 * 用户表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UUserDaoImpl extends UUserBaseDaoImpl implements UUserDao {

	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public UUser findByUserName(String userName){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("     " + selectColumn());
		sql.append("   FROM u_user _this ");
		sql.append(" WHERE _this.user_name = ? ");
		List<UUser>  list = jdbcTemplate.query(sql.toString(), BeanPropertyRowMapper.newInstance(UUser.class), userName);
		if(list == null || list.isEmpty()){
			return null;
		}
		return list.get(0);
	}
}
