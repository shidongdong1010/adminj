package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserCommonFriends;

/**
 * 用户共同好友Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserCommonFriendsBaseService {

	public void save(UserCommonFriends userCommonFriends);
	
	public void update(UserCommonFriends userCommonFriends);

	public void modify(UserCommonFriends userCommonFriends);

	public void delete(Long commonFriendId);

	public void batchSave(List<UserCommonFriends> list);

    public void batchUpdate(List<UserCommonFriends> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param commonFriendId 主键
	 * @return UserCommonFriends
	 */
	public UserCommonFriends findById(Long commonFriendId);

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @return List
	 */
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends);

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userCommonFriends
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userCommonFriends
	 * @return Long
	 */
	public Long count(UserCommonFriends userCommonFriends);
}
