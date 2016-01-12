package com.lhy.adminj.basic.service.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserSailCoinUseFlow;

/**
 * 用户航币使用流水表Service基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserSailCoinUseFlowBaseService {

	public void save(UserSailCoinUseFlow userSailCoinUseFlow);
	
	public void update(UserSailCoinUseFlow userSailCoinUseFlow);

	public void modify(UserSailCoinUseFlow userSailCoinUseFlow);

	public void delete(Long useFlowId);

	public void batchSave(List<UserSailCoinUseFlow> list);

    public void batchUpdate(List<UserSailCoinUseFlow> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param useFlowId 航币使用流水ID,自增
	 * @return UserSailCoinUseFlow
	 */
	public UserSailCoinUseFlow findById(Long useFlowId);

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @return List
	 */
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow);

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userSailCoinUseFlow
	 * @return Long
	 */
	public Long count(UserSailCoinUseFlow userSailCoinUseFlow);
}
