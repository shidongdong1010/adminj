package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.impl.UUserRoleBaseServiceImpl;
import com.lhy.adminj.basic.service.UUserRoleService;

import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.UUserRole;

/**
 * 用户角色关系表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UUserRoleServiceImpl extends UUserRoleBaseServiceImpl implements UUserRoleService {

	/**
	 * 用户用户ID查询角色
	 * @param userId
	 * @return
	 */
	@Override
	public List<UUserRole> findByUserId(Long userId){
		UUserRole uUserRole = new UUserRole();
		uUserRole.setUserId(userId);
		return  find(uUserRole);
	}
}
