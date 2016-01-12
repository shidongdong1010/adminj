package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserBacklist;

/**
 * 用户黑名单表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserBacklistBaseService {

	public void save(UserBacklist userBacklist);
	
	public void update(UserBacklist userBacklist);

	public void modify(UserBacklist userBacklist);

	public void delete(Long userId);

	public void batchSave(List<UserBacklist> list);

    public void batchUpdate(List<UserBacklist> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param userId 用户ID,自增序列
	 * @return UserBacklist
	 */
	public UserBacklist findById(Long userId);

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @return List
	 */
	public List<UserBacklist> find(UserBacklist userBacklist);

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserBacklist> find(UserBacklist userBacklist, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userBacklist
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserBacklist> find(UserBacklist userBacklist, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userBacklist
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserBacklist> find(UserBacklist userBacklist, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userBacklist
	 * @return Long
	 */
	public Long count(UserBacklist userBacklist);
}
