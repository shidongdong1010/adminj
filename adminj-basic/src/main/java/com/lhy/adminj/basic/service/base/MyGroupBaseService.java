package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.MyGroup;

/**
 * 我的组合表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyGroupBaseService {

	public void save(MyGroup myGroup);
	
	public void update(MyGroup myGroup);

	public void modify(MyGroup myGroup);

	public void delete(Long groupId);

	public void batchSave(List<MyGroup> list);

    public void batchUpdate(List<MyGroup> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param groupId 组合ID
	 * @return MyGroup
	 */
	public MyGroup findById(Long groupId);

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @return List
	 */
	public List<MyGroup> find(MyGroup myGroup);

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroup> find(MyGroup myGroup, String[][] orders);

	/**
	 * 根据对象查询
	 * @param myGroup
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroup> find(MyGroup myGroup, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroup> find(MyGroup myGroup, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param myGroup
	 * @return Long
	 */
	public Long count(MyGroup myGroup);
}
