package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserMobileBook;

/**
 * 用户手机通讯表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserMobileBookBaseService {

	public void save(UserMobileBook userMobileBook);
	
	public void update(UserMobileBook userMobileBook);

	public void modify(UserMobileBook userMobileBook);

	public void delete(Long bookId);

	public void batchSave(List<UserMobileBook> list);

    public void batchUpdate(List<UserMobileBook> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param bookId 通讯录ID
	 * @return UserMobileBook
	 */
	public UserMobileBook findById(Long bookId);

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @return List
	 */
	public List<UserMobileBook> find(UserMobileBook userMobileBook);

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserMobileBook> find(UserMobileBook userMobileBook, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userMobileBook
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMobileBook> find(UserMobileBook userMobileBook, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserMobileBook> find(UserMobileBook userMobileBook, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userMobileBook
	 * @return Long
	 */
	public Long count(UserMobileBook userMobileBook);
}
