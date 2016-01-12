package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.CoinConvertRule;

/**
 * 航币兑换规则Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface CoinConvertRuleBaseService {

	public void save(CoinConvertRule coinConvertRule);
	
	public void update(CoinConvertRule coinConvertRule);

	public void modify(CoinConvertRule coinConvertRule);

	public void delete(Long id);

	public void batchSave(List<CoinConvertRule> list);

    public void batchUpdate(List<CoinConvertRule> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 
	 * @return CoinConvertRule
	 */
	public CoinConvertRule findById(Long id);

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @return List
	 */
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule);

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, String[][] orders);

	/**
	 * 根据对象查询
	 * @param coinConvertRule
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param coinConvertRule
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertRule> find(CoinConvertRule coinConvertRule, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param coinConvertRule
	 * @return Long
	 */
	public Long count(CoinConvertRule coinConvertRule);
}
