package com.lhy.adminj.basic.service;

import java.util.List;

import com.lhy.adminj.basic.service.base.impl.UserFeedBackInfoBaseServiceImpl;
import com.lhy.adminj.basic.service.UserFeedBackInfoService;

import org.springframework.stereotype.Service;

import com.lhy.adminj.basic.model.UserFeedBackInfo;

/**
 * 意见反馈信息表Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UserFeedBackInfoServiceImpl extends UserFeedBackInfoBaseServiceImpl implements UserFeedBackInfoService {

	@Override
	public List<UserFeedBackInfo> findList(UserFeedBackInfo userFeedBackInfo,
			Long offset, Long rows) {
		
		return userFeedBackInfoDao.findList(userFeedBackInfo, offset, rows);
	}

	/** 此处写一些算定义的方法，不要修改Base的方法 **/
}
