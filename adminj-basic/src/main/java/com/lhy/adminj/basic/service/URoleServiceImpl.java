package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.impl.URoleBaseServiceImpl;
import com.lhy.adminj.basic.service.URoleService;

import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.URole;

/**
 * 角色表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class URoleServiceImpl extends URoleBaseServiceImpl implements URoleService {

	/**
	 * 查询用记的所有角色
	 * @param userId 用户ID
	 * @return
	 */
	public List<URole> findByUserId(Long userId){
		return uRoleDao.findByUserId(userId);
	}
}
