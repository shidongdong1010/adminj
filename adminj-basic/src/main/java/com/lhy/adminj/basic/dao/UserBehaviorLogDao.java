package com.lhy.adminj.basic.dao;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.UserBehaviorLogBaseDao;
import com.lhy.adminj.basic.model.UserBehaviorLog;

/**
 * 用户行为日志Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserBehaviorLogDao extends UserBehaviorLogBaseDao {

	/***
	 * 统计第一打打开APP的数量
	 * @return
	 */
	public Long countFirstOpenApp();

	/**
	 * 第一打打开APP的数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	List<Map<String, Object>> firstOpenAppMonthCount(Integer year);

	/**
	 * 统计行为日志
	 * @param year
	 * @return
	 */
	public List<Map<String, Object>> operationCount(Integer year);
}
