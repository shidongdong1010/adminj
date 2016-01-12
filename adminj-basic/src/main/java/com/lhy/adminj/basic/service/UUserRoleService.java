package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.UUserRoleBaseService;
import com.lhy.adminj.basic.model.UUserRole;

/**
 * 用户角色关系表Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UUserRoleService extends UUserRoleBaseService {

	/**
	 * 用户用户ID查询角色
	 * @param userId
	 * @return
	 */
	public List<UUserRole> findByUserId(Long userId);
}
