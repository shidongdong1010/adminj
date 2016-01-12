package com.lhy.adminj.basic.service;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.enumeration.UserBehaviorLogCodeEnum;
import com.lhy.adminj.basic.service.base.impl.UserBehaviorLogBaseServiceImpl;
import com.lhy.adminj.basic.service.UserBehaviorLogService;

import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.UserBehaviorLog;

/**
 * 用户行为日志Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UserBehaviorLogServiceImpl extends UserBehaviorLogBaseServiceImpl implements UserBehaviorLogService {

	/**
	 * 统计用户行为日志
	 * @param behaviorLogCodeEnum
	 * @return
	 */
	public Long count(UserBehaviorLogCodeEnum behaviorLogCodeEnum){
		UserBehaviorLog param =new UserBehaviorLog();
		param.setCode(behaviorLogCodeEnum.getCode());
		return userBehaviorLogDao.count(param);
	}

	/***
	 * 统计第一打打开APP的数量
	 * @return
	 */
	public Long countFirstOpenApp(){
		return userBehaviorLogDao.countFirstOpenApp();
	}

	/**
	 * 第一打打开APP的数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	public List<Map<String, Object>> firstOpenAppMonthCount(Integer year){
		return userBehaviorLogDao.firstOpenAppMonthCount(year);
	}

	/**
	 * 统计行为日志
	 * @param year
	 * @return
	 */
	public List<Map<String, Object>> operationCount(Integer year){
		return userBehaviorLogDao.operationCount(year);
	}
}
