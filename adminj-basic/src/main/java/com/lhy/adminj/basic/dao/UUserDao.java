package com.lhy.adminj.basic.dao;

import java.util.List;

import com.lhy.adminj.basic.dao.base.UUserBaseDao;
import com.lhy.adminj.basic.model.UUser;

/**
 * 用户表Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UUserDao extends UUserBaseDao {

	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	public UUser findByUserName(String userName);
}
