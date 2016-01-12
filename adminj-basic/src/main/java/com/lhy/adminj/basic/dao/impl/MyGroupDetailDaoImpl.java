package com.lhy.adminj.basic.dao.impl;

import java.util.List;
import java.util.Map;

import com.lhy.adminj.basic.dao.base.impl.MyGroupDetailBaseDaoImpl;
import com.lhy.adminj.basic.dao.MyGroupDetailDao;

import org.springframework.stereotype.Repository;
import com.lhy.adminj.basic.model.MyGroupDetail;

/**
 * 我的组合表详情Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class MyGroupDetailDaoImpl extends MyGroupDetailBaseDaoImpl implements MyGroupDetailDao {

	/**
	 * 查询组合明细及股票的当前价
	 * @param groupId
	 * @return
	 */
	public List<Map<String,Object>> findAndCurrPrice(Long groupId){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("_this.`group_detail_id` groupDetailId, _this.`group_id` groupId, _this.`stock_id` stockId, _this.`stock_code` stockCode, _this.`stock_name` stockName, _this.`total_trade_income` totalTradeIncome, _this.`today_trade_income` todayTradeIncome, _this.`total_cost` totalCost, _this.`create_date` createDate, _this.`update_date` updateDate, _this.`is_del` isDel, a.`zxz` ");
		sql.append("FROM tmc_my_group_detail _this ");
		sql.append(" INNER JOIN smc_stock a ON _this.`stock_id` = a.`stock_id` ");
		sql.append("WHERE _this.group_id = ?");
		return jdbcTemplate.queryForList(sql.toString(), groupId);
	}

}
