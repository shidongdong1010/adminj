package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.impl.UMenuBaseServiceImpl;
import com.lhy.adminj.basic.service.UMenuService;

import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.UMenu;

/**
 * 菜单表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UMenuServiceImpl extends UMenuBaseServiceImpl implements UMenuService {

	/**
	 * 查询用户拥有的菜单
	 * @param userId
	 * @return
	 */
	public List<UMenu> find(Long userId){
		return uMenuDao.find(userId);
	}
}
