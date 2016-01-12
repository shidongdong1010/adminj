package com.lhy.adminj.basic.dao.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.lhy.adminj.basic.dao.base.MyGroupDetailBaseDao;
import com.lhy.adminj.basic.model.MyGroupDetail;

/**
 * 我的组合表详情Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupDetailBaseDaoImpl implements MyGroupDetailBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`group_detail_id`, _this.`group_id`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`total_trade_income`, _this.`today_trade_income`, _this.`total_cost`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`group_detail_id`, _this.`group_id`, _this.`stock_id`, _this.`stock_code`, _this.`stock_name`, _this.`total_trade_income`, _this.`today_trade_income`, _this.`total_cost`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM tmc_my_group_detail _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_my_group_detail(`group_detail_id`, `group_id`, `stock_id`, `stock_code`, `stock_name`, `total_trade_income`, `today_trade_income`, `total_cost`, `create_date`, `update_date`, `is_del`) VALUES (:group_detail_id, :group_id, :stock_id, :stock_code, :stock_name, :total_trade_income, :today_trade_income, :total_cost, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_my_group_detail SET `group_detail_id` = :group_detail_id, `group_id` = :group_id, `stock_id` = :stock_id, `stock_code` = :stock_code, `stock_name` = :stock_name, `total_trade_income` = :total_trade_income, `today_trade_income` = :today_trade_income, `total_cost` = :total_cost, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `group_detail_id` = :group_detail_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_my_group_detail WHERE `group_detail_id` = ?";

	@Override
	public void save(MyGroupDetail myGroupDetail) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroupDetail);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		myGroupDetail.setGroupDetailId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(MyGroupDetail myGroupDetail) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroupDetail);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(MyGroupDetail myGroupDetail) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_my_group_detail SET ");
		if(myGroupDetail.getGroupDetailId() != null){
			sql.append(" group_detail_id = ?, ");
			param.add(myGroupDetail.getGroupDetailId());
		}
		if(myGroupDetail.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(myGroupDetail.getGroupId());
		}
		if(myGroupDetail.getStockId() != null){
			sql.append(" stock_id = ?, ");
			param.add(myGroupDetail.getStockId());
		}
		if(myGroupDetail.getStockCode() != null){
			sql.append(" stock_code = ?, ");
			param.add(myGroupDetail.getStockCode());
		}
		if(myGroupDetail.getStockName() != null){
			sql.append(" stock_name = ?, ");
			param.add(myGroupDetail.getStockName());
		}
		if(myGroupDetail.getTotalTradeIncome() != null){
			sql.append(" total_trade_income = ?, ");
			param.add(myGroupDetail.getTotalTradeIncome());
		}
		if(myGroupDetail.getTodayTradeIncome() != null){
			sql.append(" today_trade_income = ?, ");
			param.add(myGroupDetail.getTodayTradeIncome());
		}
		if(myGroupDetail.getTotalCost() != null){
			sql.append(" total_cost = ?, ");
			param.add(myGroupDetail.getTotalCost());
		}
		if(myGroupDetail.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(myGroupDetail.getCreateDate());
		}
		if(myGroupDetail.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(myGroupDetail.getUpdateDate());
		}
		if(myGroupDetail.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(myGroupDetail.getIsDel());
		}
		sql.append(" WHERE group_detail_id = ? ");
		param.add(myGroupDetail.getGroupDetailId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param myGroupDetails
	 * @return
	 */
	public Map<String, Object>[] toMap(List<MyGroupDetail> myGroupDetails){
		Map<String, Object>[] maps = new Map[myGroupDetails.size()];
		for(int i = 0; i < myGroupDetails.size(); i++){
			MyGroupDetail myGroupDetail = myGroupDetails.get(i);
			maps[i] = toMap(myGroupDetail);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param myGroupDetail
	 * @return
	 */
	public Map<String, Object> toMap(MyGroupDetail myGroupDetail){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("group_detail_id", myGroupDetail.getGroupDetailId());
        paramMap.put("group_id", myGroupDetail.getGroupId());
        paramMap.put("stock_id", myGroupDetail.getStockId());
        paramMap.put("stock_code", myGroupDetail.getStockCode());
        paramMap.put("stock_name", myGroupDetail.getStockName());
        paramMap.put("total_trade_income", myGroupDetail.getTotalTradeIncome());
        paramMap.put("today_trade_income", myGroupDetail.getTodayTradeIncome());
        paramMap.put("total_cost", myGroupDetail.getTotalCost());
        paramMap.put("create_date", myGroupDetail.getCreateDate());
        paramMap.put("update_date", myGroupDetail.getUpdateDate());
        paramMap.put("is_del", myGroupDetail.getIsDel());
		return paramMap;
	}

	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn(){
		return SELECT_COLUMN_SQL;
	}

	@Override
	public void delete(Long groupDetailId){
		jdbcTemplate.update(DELETE_SQL, groupDetailId);
	}

	@Override
	public void batchSave(List<MyGroupDetail> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<MyGroupDetail> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(UPDATE_SQL, params);
	}

	@Override
	public void batchDelete(List<Long> ids){
        List<Object[]> list = new ArrayList<Object[]>();
        for(Long id : ids){
            list.add(new Object[]{id});
        }
        jdbcTemplate.batchUpdate(DELETE_SQL, list);
	}


	/**
	 * 根据主键查询
	 * @param groupDetailId 组合详情ID
	 * @return MyGroupDetail
	 */
	@Override
	public MyGroupDetail findById(Long groupDetailId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`group_detail_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(MyGroupDetail.class), groupDetailId);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @return List
	 */
	@Override
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail){
		return this.find(myGroupDetail, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, String[][] orders){
		return this.find(myGroupDetail, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, Long offset, Long rows){
		return this.find(myGroupDetail, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroupDetail> find(MyGroupDetail myGroupDetail, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(myGroupDetail != null){
			if(myGroupDetail.getGroupDetailId() != null){
				sql.append(" AND _this.`group_detail_id` = ?");
				param.add(myGroupDetail.getGroupDetailId());
			}
			if(myGroupDetail.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(myGroupDetail.getGroupId());
			}
			if(myGroupDetail.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ?");
				param.add(myGroupDetail.getStockId());
			}
			if(myGroupDetail.getStockCode() != null && !"".equals(myGroupDetail.getStockCode())){
				sql.append(" AND _this.`stock_code` = ?");
				param.add(myGroupDetail.getStockCode());
			}
			if(myGroupDetail.getStockName() != null && !"".equals(myGroupDetail.getStockName())){
				sql.append(" AND _this.`stock_name` = ?");
				param.add(myGroupDetail.getStockName());
			}
			if(myGroupDetail.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(myGroupDetail.getCreateDate());
			}
			if(myGroupDetail.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(myGroupDetail.getUpdateDate());
			}
			if(myGroupDetail.getIsDel() != null && !"".equals(myGroupDetail.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(myGroupDetail.getIsDel());
			}
		}

		// 排序
		if(orders != null && orders.length > 0){
   			sql.append(" ORDER BY ");
			for(int i = 0; i < orders.length; i++){
    			String[] order = orders[i];
				if(i != 0){
    				sql.append("_this.`").append(order[0]).append("`, ");
				}
				if(order.length == 1){
    				sql.append("_this.`").append(order[0]).append("` ASC ");
				}else{
    				sql.append("_this.`").append(order[0]).append("` ").append(order[1]);
				}
			}
		}

		// 分页
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(MyGroupDetail.class));
	}


	/**
	 * 根据对象查询条数
	 * @param myGroupDetail
	 * @return Long
	 */
	@Override
	public Long count(MyGroupDetail myGroupDetail){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_my_group_detail  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(myGroupDetail != null){
			if(myGroupDetail.getGroupDetailId() != null){
				sql.append(" AND _this.`group_detail_id` = ? ");
				param.add(myGroupDetail.getGroupDetailId());
			}
			if(myGroupDetail.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(myGroupDetail.getGroupId());
			}
			if(myGroupDetail.getStockId() != null){
				sql.append(" AND _this.`stock_id` = ? ");
				param.add(myGroupDetail.getStockId());
			}
			if(myGroupDetail.getStockCode() != null && !"".equals(myGroupDetail.getStockCode())){
				sql.append(" AND _this.`stock_code` = ? ");
				param.add(myGroupDetail.getStockCode());
			}
			if(myGroupDetail.getStockName() != null && !"".equals(myGroupDetail.getStockName())){
				sql.append(" AND _this.`stock_name` = ? ");
				param.add(myGroupDetail.getStockName());
			}
			if(myGroupDetail.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(myGroupDetail.getCreateDate());
			}
			if(myGroupDetail.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(myGroupDetail.getUpdateDate());
			}
			if(myGroupDetail.getIsDel() != null && !"".equals(myGroupDetail.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(myGroupDetail.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}