package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserLoginInfo;

/**
 * 用户登陆日志Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserLoginInfoBaseDao {

	public void save(UserLoginInfo userLoginInfo);
	
	public void update(UserLoginInfo userLoginInfo);

	public void modify(UserLoginInfo userLoginInfo);

	public void delete(Long loginId);

	public void batchSave(List<UserLoginInfo> list);

    public void batchUpdate(List<UserLoginInfo> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param loginId 登陆表主键
	 * @return UserLoginInfo
	 */
	public UserLoginInfo findById(Long loginId);

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @return List
	 */
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo);

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userLoginInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userLoginInfo
	 * @return Long
	 */
	public Long count(UserLoginInfo userLoginInfo);
}
