package com.lhy.adminj.basic.dao;

import com.lhy.adminj.basic.dao.base.UserCommonFriendsBaseDao;

/**
 * 用户共同好友Dao接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserCommonFriendsDao extends UserCommonFriendsBaseDao {

	/**
	 * 执行查找共同好友
	 */
	public void executeFindCommonFriend();

}
