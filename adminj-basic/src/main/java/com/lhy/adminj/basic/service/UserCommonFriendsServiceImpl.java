package com.lhy.adminj.basic.service;

import org.springframework.stereotype.Service;

import com.lhy.adminj.basic.service.base.impl.UserCommonFriendsBaseServiceImpl;

/**
 * 用户共同好友Service接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Service
public class UserCommonFriendsServiceImpl extends UserCommonFriendsBaseServiceImpl implements UserCommonFriendsService {

	@Override
	public void executeFindCommonFriend() {
		// TODO Auto-generated method stub
		userCommonFriendsDao.executeFindCommonFriend();
	}

}
