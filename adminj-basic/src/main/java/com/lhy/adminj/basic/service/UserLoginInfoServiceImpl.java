package com.lhy.adminj.basic.service;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.service.base.impl.UserLoginInfoBaseServiceImpl;
import com.lhy.adminj.basic.service.UserLoginInfoService;

import org.springframework.stereotype.Service;
import com.lhy.adminj.basic.model.UserLoginInfo;

/**
 * 用户登陆日志Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UserLoginInfoServiceImpl extends UserLoginInfoBaseServiceImpl implements UserLoginInfoService {

	/**
	 * 登陆数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	public List<Map<String, Object>> loginMonthCount(Integer year){
		return userLoginInfoDao.loginMonthCount(year);
	}

}
