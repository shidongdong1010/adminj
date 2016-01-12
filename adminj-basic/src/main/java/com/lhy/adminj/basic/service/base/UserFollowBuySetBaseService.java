package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserFollowBuySet;

/**
 * 用户跟买设置Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserFollowBuySetBaseService {

	public void save(UserFollowBuySet userFollowBuySet);
	
	public void update(UserFollowBuySet userFollowBuySet);

	public void modify(UserFollowBuySet userFollowBuySet);

	public void delete(Long userId);

	public void batchSave(List<UserFollowBuySet> list);

    public void batchUpdate(List<UserFollowBuySet> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param userId 用户ID
	 * @return UserFollowBuySet
	 */
	public UserFollowBuySet findById(Long userId);

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @return List
	 */
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet);

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userFollowBuySet
	 * @return Long
	 */
	public Long count(UserFollowBuySet userFollowBuySet);
}
