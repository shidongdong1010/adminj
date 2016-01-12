package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.SysSensitiveWord;

/**
 * 敏感词库Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface SysSensitiveWordBaseService {

	public void save(SysSensitiveWord sysSensitiveWord);
	
	public void update(SysSensitiveWord sysSensitiveWord);

	public void modify(SysSensitiveWord sysSensitiveWord);

	public void delete(Long wordId);

	public void batchSave(List<SysSensitiveWord> list);

    public void batchUpdate(List<SysSensitiveWord> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param wordId 敏感词ID
	 * @return SysSensitiveWord
	 */
	public SysSensitiveWord findById(Long wordId);

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @return List
	 */
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord);

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, String[][] orders);

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param sysSensitiveWord
	 * @return Long
	 */
	public Long count(SysSensitiveWord sysSensitiveWord);
}
