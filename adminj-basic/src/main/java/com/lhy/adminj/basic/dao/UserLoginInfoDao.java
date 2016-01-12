package com.lhy.adminj.basic.dao;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.UserLoginInfoBaseDao;
import com.lhy.adminj.basic.model.UserLoginInfo;

/**
 * 用户登陆日志Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserLoginInfoDao extends UserLoginInfoBaseDao {

	/**
	 * 登陆数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	List<Map<String, Object>> loginMonthCount(Integer year);
}
