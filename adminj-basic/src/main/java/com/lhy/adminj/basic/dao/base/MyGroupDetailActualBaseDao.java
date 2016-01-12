package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.MyGroupDetailActual;

/**
 * 我的组合时段详情Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyGroupDetailActualBaseDao {

	public void save(MyGroupDetailActual myGroupDetailActual);
	
	public void update(MyGroupDetailActual myGroupDetailActual);

	public void modify(MyGroupDetailActual myGroupDetailActual);

	public void delete(Long actualDetailId);

	public void batchSave(List<MyGroupDetailActual> list);

    public void batchUpdate(List<MyGroupDetailActual> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param actualDetailId 组合详情ID
	 * @return MyGroupDetailActual
	 */
	public MyGroupDetailActual findById(Long actualDetailId);

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @return List
	 */
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual);

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, String[][] orders);

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param myGroupDetailActual
	 * @return Long
	 */
	public Long count(MyGroupDetailActual myGroupDetailActual);
}
