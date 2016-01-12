package com.lhy.adminj.basic.dao;

import java.util.List;

import com.lhy.adminj.basic.dao.base.UResourceBaseDao;
import com.lhy.adminj.basic.model.UResource;

/**
 * Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UResourceDao extends UResourceBaseDao {
	/**
	 * 根据角色查询所有资源
	 * @param roleId 角色ID
	 * @return
	 */
	public List<UResource> findByRoleId(Long roleId);
}
