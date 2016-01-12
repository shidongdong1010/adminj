package com.lhy.adminj.basic.dao.impl;

import java.util.List;

import com.lhy.adminj.basic.dao.base.impl.UResourceBaseDaoImpl;
import com.lhy.adminj.basic.dao.UResourceDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.lhy.adminj.basic.model.UResource;

/**
 * Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UResourceDaoImpl extends UResourceBaseDaoImpl implements UResourceDao {

	/**
	 * 根据角色查询所有资源
	 * @param roleId 角色ID
	 * @return
	 */
	public List<UResource> findByRoleId(Long roleId){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("     " + selectColumn());
		sql.append("   FROM u_resource _this ");
		sql.append(" WHERE (select b.id FROM u_role_resource b WHERE _this.id = b.resource_id AND b.role_id = ?) ");
		return jdbcTemplate.query(sql.toString(), BeanPropertyRowMapper.newInstance(UResource.class), roleId);
	}
}
