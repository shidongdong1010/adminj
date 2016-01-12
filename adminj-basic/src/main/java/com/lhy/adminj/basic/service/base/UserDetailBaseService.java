package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserDetail;

/**
 * 用户简介表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserDetailBaseService {

	public void save(UserDetail userDetail);
	
	public void update(UserDetail userDetail);

	public void modify(UserDetail userDetail);

	public void delete(Long userId);

	public void batchSave(List<UserDetail> list);

    public void batchUpdate(List<UserDetail> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param userId 用户ID,自增序列
	 * @return UserDetail
	 */
	public UserDetail findById(Long userId);

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @return List
	 */
	public List<UserDetail> find(UserDetail userDetail);

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserDetail> find(UserDetail userDetail, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDetail> find(UserDetail userDetail, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserDetail> find(UserDetail userDetail, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userDetail
	 * @return Long
	 */
	public Long count(UserDetail userDetail);
}
