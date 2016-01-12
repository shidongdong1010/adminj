package com.lhy.adminj.basic.dao.impl;

import java.util.List;

import com.lhy.adminj.basic.dao.base.impl.URoleBaseDaoImpl;
import com.lhy.adminj.basic.dao.URoleDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.lhy.adminj.basic.model.URole;

/**
 * 角色表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class URoleDaoImpl extends URoleBaseDaoImpl implements URoleDao {

	/**
	 * 查询用记的所有角色
	 * @param userId 用户ID
	 * @return
	 */
	public List<URole> findByUserId(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("     " + selectColumn());
		sql.append("   FROM u_role _this ");
		sql.append(" WHERE (SELECT b.id FROM u_user_role b WHERE _this.id = b.role_id AND b.user_id = ?) ");
		return jdbcTemplate.query(sql.toString(), BeanPropertyRowMapper.newInstance(URole.class), userId);
	}
}
