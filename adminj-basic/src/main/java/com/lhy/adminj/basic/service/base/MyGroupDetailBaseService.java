package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.MyGroupDetail;

/**
 * 我的组合表详情Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface MyGroupDetailBaseService {

	public void save(MyGroupDetail myGroupDetail);
	
	public void update(MyGroupDetail myGroupDetail);

	public void modify(MyGroupDetail myGroupDetail);

	public void delete(Long groupDetailId);

	public void batchSave(List<MyGroupDetail> list);

    public void batchUpdate(List<MyGroupDetail> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param groupDetailId 组合详情ID
	 * @return MyGroupDetail
	 */
	public MyGroupDetail findById(Long groupDetailId);

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @return List
	 */
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail);

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, String[][] orders);

	/**
	 * 根据对象查询
	 * @param myGroupDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param myGroupDetail
	 * @return Long
	 */
	public Long count(MyGroupDetail myGroupDetail);
}
