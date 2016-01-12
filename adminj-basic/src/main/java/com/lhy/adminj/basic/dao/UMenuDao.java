package com.lhy.adminj.basic.dao;

import java.util.List;

import com.lhy.adminj.basic.dao.base.UMenuBaseDao;
import com.lhy.adminj.basic.model.UMenu;

/**
 * 菜单表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UMenuDao extends UMenuBaseDao {

	/**
	 * 查询用户拥有的菜单
	 * @param userId
	 * @return
	 */
	public List<UMenu> find(Long userId);
}
