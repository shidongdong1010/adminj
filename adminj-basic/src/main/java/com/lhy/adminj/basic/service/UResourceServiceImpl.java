package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.impl.UResourceBaseServiceImpl;
import com.lhy.adminj.basic.service.UResourceService;

import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.UResource;

/**
 * Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UResourceServiceImpl extends UResourceBaseServiceImpl implements UResourceService {

	/**
	 * 根据角色查询所有资源
	 * @param roleId 角色ID
	 * @return
	 */
	public List<UResource> findByRoleId(Long roleId){
		return uResourceDao.findByRoleId(roleId);
	}
}
