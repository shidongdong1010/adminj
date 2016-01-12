package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.CoinConvertGood;

/**
 * 兑换商品表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface CoinConvertGoodBaseService {

	public void save(CoinConvertGood coinConvertGood);
	
	public void update(CoinConvertGood coinConvertGood);

	public void modify(CoinConvertGood coinConvertGood);

	public void delete(Long id);

	public void batchSave(List<CoinConvertGood> list);

    public void batchUpdate(List<CoinConvertGood> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 主键ID
	 * @return CoinConvertGood
	 */
	public CoinConvertGood findById(Long id);

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @return List
	 */
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood);

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, String[][] orders);

	/**
	 * 根据对象查询
	 * @param coinConvertGood
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param coinConvertGood
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertGood> find(CoinConvertGood coinConvertGood, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param coinConvertGood
	 * @return Long
	 */
	public Long count(CoinConvertGood coinConvertGood);
}
