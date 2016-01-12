package com.lhy.adminj.basic.dao.impl;

import org.springframework.stereotype.Repository;

import com.lhy.adminj.basic.dao.UserCommonFriendsDao;
import com.lhy.adminj.basic.dao.base.impl.UserCommonFriendsBaseDaoImpl;

/**
 * 用户共同好友Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UserCommonFriendsDaoImpl extends UserCommonFriendsBaseDaoImpl implements UserCommonFriendsDao {

	@Override
	public void executeFindCommonFriend() {
		// TODO Auto-generated method stub
		
		//清空数据
		jdbcTemplate.update("TRUNCATE TABLE umc_user_common_friends");
		
		//加载共同好友
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO umc_user_common_friends (");
		sql.append("    common_friend_id,");
		sql.append("    usera_id,");
		sql.append("	userb_id,");
		sql.append("	common_friend_userid,");
		sql.append("	common_friend_username,");
		sql.append("	common_friend_nickname");
		sql.append(") SELECT");
		sql.append("	null,");
		sql.append("	t3.user_id,");
		sql.append("	t1.friend_user_id,");
		sql.append("	t2.friend_user_id AS common_friend_id,");
		sql.append("	u.user_name,");
		sql.append("	ud.nick_name");
		sql.append(" FROM");
		sql.append("	umc_user_friends t1");
		sql.append(" INNER JOIN umc_user_friends t2 ON t1.friend_user_id = t2.user_id");
		sql.append(" INNER JOIN umc_user_friends t3 ON t3.user_id = t1.user_id");
		sql.append(" AND t3.friend_user_id = t2.friend_user_id");
		sql.append(" INNER JOIN umc_user u ON u.user_id = t2.friend_user_id");
		sql.append(" INNER JOIN umc_user_detail ud ON ud.user_id = t2.friend_user_id");
		sql.append(" WHERE");
		sql.append("	t1.user_id != t2.friend_user_id");
		sql.append(" ORDER BY");
		sql.append("	t1.user_id,");
		sql.append("	t1.friend_user_id,");
		sql.append("	t2.friend_user_id");
		jdbcTemplate.update(sql.toString());
	}

}
