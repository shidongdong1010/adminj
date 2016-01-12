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

import com.lhy.adminj.basic.dao.base.MyGroupActualBaseDao;
import com.lhy.adminj.basic.model.MyGroupActual;

/**
 * 我的组合时段Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupActualBaseDaoImpl implements MyGroupActualBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`actual_group_id`, _this.`actual_type`, _this.`actual_date`, _this.`user_id`, _this.`group_name`, _this.`group_desc`, _this.`total_trade_income`, _this.`today_trade_income`, _this.`total_cost`, _this.`follow_buy_num`, _this.`trade_count`, _this.`profit_count`, _this.`loss_count`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`actual_group_id`, _this.`actual_type`, _this.`actual_date`, _this.`user_id`, _this.`group_name`, _this.`group_desc`, _this.`total_trade_income`, _this.`today_trade_income`, _this.`total_cost`, _this.`follow_buy_num`, _this.`trade_count`, _this.`profit_count`, _this.`loss_count`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM tmc_my_group_actual _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_my_group_actual(`actual_group_id`, `actual_type`, `actual_date`, `user_id`, `group_name`, `group_desc`, `total_trade_income`, `today_trade_income`, `total_cost`, `follow_buy_num`, `trade_count`, `profit_count`, `loss_count`, `create_date`, `update_date`, `is_del`) VALUES (:actual_group_id, :actual_type, :actual_date, :user_id, :group_name, :group_desc, :total_trade_income, :today_trade_income, :total_cost, :follow_buy_num, :trade_count, :profit_count, :loss_count, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_my_group_actual SET `actual_group_id` = :actual_group_id, `actual_type` = :actual_type, `actual_date` = :actual_date, `user_id` = :user_id, `group_name` = :group_name, `group_desc` = :group_desc, `total_trade_income` = :total_trade_income, `today_trade_income` = :today_trade_income, `total_cost` = :total_cost, `follow_buy_num` = :follow_buy_num, `trade_count` = :trade_count, `profit_count` = :profit_count, `loss_count` = :loss_count, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `actual_group_id` = :actual_group_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_my_group_actual WHERE `actual_group_id` = ?";

	@Override
	public void save(MyGroupActual myGroupActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroupActual);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		myGroupActual.setActualGroupId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(MyGroupActual myGroupActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroupActual);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(MyGroupActual myGroupActual) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_my_group_actual SET ");
		if(myGroupActual.getActualGroupId() != null){
			sql.append(" actual_group_id = ?, ");
			param.add(myGroupActual.getActualGroupId());
		}
		if(myGroupActual.getActualType() != null){
			sql.append(" actual_type = ?, ");
			param.add(myGroupActual.getActualType());
		}
		if(myGroupActual.getActualDate() != null){
			sql.append(" actual_date = ?, ");
			param.add(myGroupActual.getActualDate());
		}
		if(myGroupActual.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(myGroupActual.getUserId());
		}
		if(myGroupActual.getGroupName() != null){
			sql.append(" group_name = ?, ");
			param.add(myGroupActual.getGroupName());
		}
		if(myGroupActual.getGroupDesc() != null){
			sql.append(" group_desc = ?, ");
			param.add(myGroupActual.getGroupDesc());
		}
		if(myGroupActual.getTotalTradeIncome() != null){
			sql.append(" total_trade_income = ?, ");
			param.add(myGroupActual.getTotalTradeIncome());
		}
		if(myGroupActual.getTodayTradeIncome() != null){
			sql.append(" today_trade_income = ?, ");
			param.add(myGroupActual.getTodayTradeIncome());
		}
		if(myGroupActual.getTotalCost() != null){
			sql.append(" total_cost = ?, ");
			param.add(myGroupActual.getTotalCost());
		}
		if(myGroupActual.getFollowBuyNum() != null){
			sql.append(" follow_buy_num = ?, ");
			param.add(myGroupActual.getFollowBuyNum());
		}
		if(myGroupActual.getTradeCount() != null){
			sql.append(" trade_count = ?, ");
			param.add(myGroupActual.getTradeCount());
		}
		if(myGroupActual.getProfitCount() != null){
			sql.append(" profit_count = ?, ");
			param.add(myGroupActual.getProfitCount());
		}
		if(myGroupActual.getLossCount() != null){
			sql.append(" loss_count = ?, ");
			param.add(myGroupActual.getLossCount());
		}
		if(myGroupActual.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(myGroupActual.getCreateDate());
		}
		if(myGroupActual.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(myGroupActual.getUpdateDate());
		}
		if(myGroupActual.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(myGroupActual.getIsDel());
		}
		sql.append(" WHERE actual_group_id = ? ");
		param.add(myGroupActual.getActualGroupId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param myGroupActuals
	 * @return
	 */
	public Map<String, Object>[] toMap(List<MyGroupActual> myGroupActuals){
		Map<String, Object>[] maps = new Map[myGroupActuals.size()];
		for(int i = 0; i < myGroupActuals.size(); i++){
			MyGroupActual myGroupActual = myGroupActuals.get(i);
			maps[i] = toMap(myGroupActual);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param myGroupActual
	 * @return
	 */
	public Map<String, Object> toMap(MyGroupActual myGroupActual){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("actual_group_id", myGroupActual.getActualGroupId());
        paramMap.put("actual_type", myGroupActual.getActualType());
        paramMap.put("actual_date", myGroupActual.getActualDate());
        paramMap.put("user_id", myGroupActual.getUserId());
        paramMap.put("group_name", myGroupActual.getGroupName());
        paramMap.put("group_desc", myGroupActual.getGroupDesc());
        paramMap.put("total_trade_income", myGroupActual.getTotalTradeIncome());
        paramMap.put("today_trade_income", myGroupActual.getTodayTradeIncome());
        paramMap.put("total_cost", myGroupActual.getTotalCost());
        paramMap.put("follow_buy_num", myGroupActual.getFollowBuyNum());
        paramMap.put("trade_count", myGroupActual.getTradeCount());
        paramMap.put("profit_count", myGroupActual.getProfitCount());
        paramMap.put("loss_count", myGroupActual.getLossCount());
        paramMap.put("create_date", myGroupActual.getCreateDate());
        paramMap.put("update_date", myGroupActual.getUpdateDate());
        paramMap.put("is_del", myGroupActual.getIsDel());
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
	public void delete(Long actualGroupId){
		jdbcTemplate.update(DELETE_SQL, actualGroupId);
	}

	@Override
	public void batchSave(List<MyGroupActual> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<MyGroupActual> list){
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
	 * @param actualGroupId 组合ID
	 * @return MyGroupActual
	 */
	@Override
	public MyGroupActual findById(Long actualGroupId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`actual_group_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(MyGroupActual.class), actualGroupId);
	}

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @return List
	 */
	@Override
	public List<MyGroupActual> find(MyGroupActual myGroupActual){
		return this.find(myGroupActual, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<MyGroupActual> find(MyGroupActual myGroupActual, String[][] orders){
		return this.find(myGroupActual, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroupActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroupActual> find(MyGroupActual myGroupActual, Long offset, Long rows){
		return this.find(myGroupActual, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroupActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroupActual> find(MyGroupActual myGroupActual, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(myGroupActual != null){
			if(myGroupActual.getActualGroupId() != null){
				sql.append(" AND _this.`actual_group_id` = ?");
				param.add(myGroupActual.getActualGroupId());
			}
			if(myGroupActual.getActualType() != null && !"".equals(myGroupActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ?");
				param.add(myGroupActual.getActualType());
			}
			if(myGroupActual.getActualDate() != null){
				sql.append(" AND _this.`actual_date` = ?");
				param.add(myGroupActual.getActualDate());
			}
			if(myGroupActual.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(myGroupActual.getUserId());
			}
			if(myGroupActual.getGroupName() != null && !"".equals(myGroupActual.getGroupName())){
				sql.append(" AND _this.`group_name` = ?");
				param.add(myGroupActual.getGroupName());
			}
			if(myGroupActual.getGroupDesc() != null && !"".equals(myGroupActual.getGroupDesc())){
				sql.append(" AND _this.`group_desc` = ?");
				param.add(myGroupActual.getGroupDesc());
			}
			if(myGroupActual.getFollowBuyNum() != null){
				sql.append(" AND _this.`follow_buy_num` = ?");
				param.add(myGroupActual.getFollowBuyNum());
			}
			if(myGroupActual.getTradeCount() != null){
				sql.append(" AND _this.`trade_count` = ?");
				param.add(myGroupActual.getTradeCount());
			}
			if(myGroupActual.getProfitCount() != null){
				sql.append(" AND _this.`profit_count` = ?");
				param.add(myGroupActual.getProfitCount());
			}
			if(myGroupActual.getLossCount() != null){
				sql.append(" AND _this.`loss_count` = ?");
				param.add(myGroupActual.getLossCount());
			}
			if(myGroupActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(myGroupActual.getCreateDate());
			}
			if(myGroupActual.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(myGroupActual.getUpdateDate());
			}
			if(myGroupActual.getIsDel() != null && !"".equals(myGroupActual.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(myGroupActual.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(MyGroupActual.class));
	}


	/**
	 * 根据对象查询条数
	 * @param myGroupActual
	 * @return Long
	 */
	@Override
	public Long count(MyGroupActual myGroupActual){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_my_group_actual  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(myGroupActual != null){
			if(myGroupActual.getActualGroupId() != null){
				sql.append(" AND _this.`actual_group_id` = ? ");
				param.add(myGroupActual.getActualGroupId());
			}
			if(myGroupActual.getActualType() != null && !"".equals(myGroupActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ? ");
				param.add(myGroupActual.getActualType());
			}
			if(myGroupActual.getActualDate() != null){
				sql.append(" AND _this.`actual_date` = ? ");
				param.add(myGroupActual.getActualDate());
			}
			if(myGroupActual.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(myGroupActual.getUserId());
			}
			if(myGroupActual.getGroupName() != null && !"".equals(myGroupActual.getGroupName())){
				sql.append(" AND _this.`group_name` = ? ");
				param.add(myGroupActual.getGroupName());
			}
			if(myGroupActual.getGroupDesc() != null && !"".equals(myGroupActual.getGroupDesc())){
				sql.append(" AND _this.`group_desc` = ? ");
				param.add(myGroupActual.getGroupDesc());
			}
			if(myGroupActual.getFollowBuyNum() != null){
				sql.append(" AND _this.`follow_buy_num` = ? ");
				param.add(myGroupActual.getFollowBuyNum());
			}
			if(myGroupActual.getTradeCount() != null){
				sql.append(" AND _this.`trade_count` = ? ");
				param.add(myGroupActual.getTradeCount());
			}
			if(myGroupActual.getProfitCount() != null){
				sql.append(" AND _this.`profit_count` = ? ");
				param.add(myGroupActual.getProfitCount());
			}
			if(myGroupActual.getLossCount() != null){
				sql.append(" AND _this.`loss_count` = ? ");
				param.add(myGroupActual.getLossCount());
			}
			if(myGroupActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(myGroupActual.getCreateDate());
			}
			if(myGroupActual.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(myGroupActual.getUpdateDate());
			}
			if(myGroupActual.getIsDel() != null && !"".equals(myGroupActual.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(myGroupActual.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}