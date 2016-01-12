package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.URoleBaseService;
import com.lhy.adminj.basic.model.URole;

/**
 * 角色表Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface URoleService extends URoleBaseService {

	/**
	 * 查询用记的所有角色
	 * @param userId 用户ID
	 * @return
	 */
	public List<URole> findByUserId(Long userId);
}
