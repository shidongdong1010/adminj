package com.lhy.adminj.basic.service;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.enumeration.UserBehaviorLogCodeEnum;
import com.lhy.adminj.basic.service.base.UserBehaviorLogBaseService;
import com.lhy.adminj.basic.model.UserBehaviorLog;

/**
 * 用户行为日志Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserBehaviorLogService extends UserBehaviorLogBaseService {

	/**
	 * 统计用户行为日志
	 * @param behaviorLogCodeEnum
	 * @return
	 */
	public Long count(UserBehaviorLogCodeEnum behaviorLogCodeEnum);

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
