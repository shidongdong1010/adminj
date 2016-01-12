package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.MyGroupActual;

/**
 * 我的组合时段Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyGroupActualBaseService {

	public void save(MyGroupActual myGroupActual);
	
	public void update(MyGroupActual myGroupActual);

	public void modify(MyGroupActual myGroupActual);

	public void delete(Long actualGroupId);

	public void batchSave(List<MyGroupActual> list);

    public void batchUpdate(List<MyGroupActual> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param actualGroupId 组合ID
	 * @return MyGroupActual
	 */
	public MyGroupActual findById(Long actualGroupId);

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @return List
	 */
	public List<MyGroupActual> find(MyGroupActual myGroupActual);

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroupActual> find(MyGroupActual myGroupActual, String[][] orders);

	/**
	 * 根据对象查询
	 * @param myGroupActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupActual> find(MyGroupActual myGroupActual, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupActual> find(MyGroupActual myGroupActual, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param myGroupActual
	 * @return Long
	 */
	public Long count(MyGroupActual myGroupActual);
}
