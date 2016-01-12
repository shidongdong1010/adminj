package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.SysSms;

/**
 * 短信信息表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface SysSmsBaseDao {

	public void save(SysSms sysSms);
	
	public void update(SysSms sysSms);

	public void modify(SysSms sysSms);

	public void delete(Long smsId);

	public void batchSave(List<SysSms> list);

    public void batchUpdate(List<SysSms> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param smsId 短信ID
	 * @return SysSms
	 */
	public SysSms findById(Long smsId);

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @return List
	 */
	public List<SysSms> find(SysSms sysSms);

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<SysSms> find(SysSms sysSms, String[][] orders);

	/**
	 * 根据对象查询
	 * @param sysSms
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysSms> find(SysSms sysSms, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysSms> find(SysSms sysSms, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param sysSms
	 * @return Long
	 */
	public Long count(SysSms sysSms);
}
