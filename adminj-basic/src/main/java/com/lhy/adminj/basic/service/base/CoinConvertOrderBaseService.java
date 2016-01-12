package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.CoinConvertOrder;

/**
 * 兑换订单表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface CoinConvertOrderBaseService {

	public void save(CoinConvertOrder coinConvertOrder);
	
	public void update(CoinConvertOrder coinConvertOrder);

	public void modify(CoinConvertOrder coinConvertOrder);

	public void delete(Long id);

	public void batchSave(List<CoinConvertOrder> list);

    public void batchUpdate(List<CoinConvertOrder> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param id 
	 * @return CoinConvertOrder
	 */
	public CoinConvertOrder findById(Long id);

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @return List
	 */
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder);

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, String[][] orders);

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param coinConvertOrder
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<CoinConvertOrder> find(CoinConvertOrder coinConvertOrder, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param coinConvertOrder
	 * @return Long
	 */
	public Long count(CoinConvertOrder coinConvertOrder);
}
