package com.lhy.adminj.basic.dao.base;

import java.util.List;

import com.lhy.adminj.basic.model.UserSailCoinObtainFlow;

/**
 * 用户航币获取流水表Dao基础操作接口
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public interface UserSailCoinObtainFlowBaseDao {

	public void save(UserSailCoinObtainFlow userSailCoinObtainFlow);
	
	public void update(UserSailCoinObtainFlow userSailCoinObtainFlow);

	public void modify(UserSailCoinObtainFlow userSailCoinObtainFlow);

	public void delete(Long obtainFlowId);

	public void batchSave(List<UserSailCoinObtainFlow> list);

    public void batchUpdate(List<UserSailCoinObtainFlow> list);

    public void batchDelete(List<Long> ids);

	/**
	 * 根据主键查询
	 * @param obtainFlowId 航币获取流水ID,自增
	 * @return UserSailCoinObtainFlow
	 */
	public UserSailCoinObtainFlow findById(Long obtainFlowId);

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @return List
	 */
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow);

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, String[][] orders);

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, Long offset, Long rows);

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, String[][] orders, Long offset, Long rows);

	/**
	 * 根据对象查询条数
	 * @param userSailCoinObtainFlow
	 * @return Long
	 */
	public Long count(UserSailCoinObtainFlow userSailCoinObtainFlow);
}
