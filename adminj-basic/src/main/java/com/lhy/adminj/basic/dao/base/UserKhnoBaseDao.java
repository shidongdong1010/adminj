package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserKhno;

/**
 * 用户卷商表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserKhnoBaseDao {

	public void save(UserKhno userKhno);
	
	public void update(UserKhno userKhno);

	public void modify(UserKhno userKhno);

	public void delete(Long id);

	public void batchSave(List<UserKhno> list);

    public void batchUpdate(List<UserKhno> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id ID
	 * @return UserKhno
	 */
	public UserKhno findById(Long id);

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @return List
	 */
	public List<UserKhno> find(UserKhno userKhno);

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserKhno> find(UserKhno userKhno, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userKhno
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserKhno> find(UserKhno userKhno, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserKhno> find(UserKhno userKhno, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userKhno
	 * @return Long
	 */
	public Long count(UserKhno userKhno);
}
