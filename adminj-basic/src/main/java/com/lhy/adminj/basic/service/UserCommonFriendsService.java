package com.lhy.adminj.basic.service;

import com.lhy.adminj.basic.service.base.UserCommonFriendsBaseService;

/**
 * 用户共同好友Service接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserCommonFriendsService extends UserCommonFriendsBaseService {

	/**
	 * 执行查找共同好友
	 */
	public void executeFindCommonFriend();
}
