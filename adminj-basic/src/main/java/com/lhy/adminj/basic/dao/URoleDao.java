package com.lhy.adminj.basic.dao;

import java.util.List;

import com.lhy.adminj.basic.dao.base.URoleBaseDao;
import com.lhy.adminj.basic.model.URole;

/**
 * 角色表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface URoleDao extends URoleBaseDao {

	/**
	 * 查询用记的所有角色
	 * @param userId 用户ID
	 * @return
	 */
	public List<URole> findByUserId(Long userId);
}
