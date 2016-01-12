package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.UMenuBaseService;
import com.lhy.adminj.basic.model.UMenu;

/**
 * 菜单表Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UMenuService extends UMenuBaseService {

	/**
	 * 查询用户拥有的菜单
	 * @param userId
	 * @return
	 */
	public List<UMenu> find(Long userId);
}
