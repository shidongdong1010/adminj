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

import com.lhy.adminj.basic.dao.base.MyGroupDetailActualBaseDao;
import com.lhy.adminj.basic.model.MyGroupDetailActual;

/**
 * 我的组合时段详情Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupDetailActualBaseDaoImpl implements MyGroupDetailActualBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`actual_detail_id`, _this.`actual_type`, _this.`actual_date`, _this.`group_id`, _this.`stork_id`, _this.`stork_code`, _this.`stork_name`, _this.`total_trade_income`, _this.`today_trade_income`, _this.`total_cost`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`actual_detail_id`, _this.`actual_type`, _this.`actual_date`, _this.`group_id`, _this.`stork_id`, _this.`stork_code`, _this.`stork_name`, _this.`total_trade_income`, _this.`today_trade_income`, _this.`total_cost`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM tmc_my_group_detail_actual _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_my_group_detail_actual(`actual_detail_id`, `actual_type`, `actual_date`, `group_id`, `stork_id`, `stork_code`, `stork_name`, `total_trade_income`, `today_trade_income`, `total_cost`, `create_date`, `update_date`, `is_del`) VALUES (:actual_detail_id, :actual_type, :actual_date, :group_id, :stork_id, :stork_code, :stork_name, :total_trade_income, :today_trade_income, :total_cost, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_my_group_detail_actual SET `actual_detail_id` = :actual_detail_id, `actual_type` = :actual_type, `actual_date` = :actual_date, `group_id` = :group_id, `stork_id` = :stork_id, `stork_code` = :stork_code, `stork_name` = :stork_name, `total_trade_income` = :total_trade_income, `today_trade_income` = :today_trade_income, `total_cost` = :total_cost, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `actual_detail_id` = :actual_detail_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_my_group_detail_actual WHERE `actual_detail_id` = ?";

	@Override
	public void save(MyGroupDetailActual myGroupDetailActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroupDetailActual);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		myGroupDetailActual.setActualDetailId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(MyGroupDetailActual myGroupDetailActual) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroupDetailActual);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(MyGroupDetailActual myGroupDetailActual) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_my_group_detail_actual SET ");
		if(myGroupDetailActual.getActualDetailId() != null){
			sql.append(" actual_detail_id = ?, ");
			param.add(myGroupDetailActual.getActualDetailId());
		}
		if(myGroupDetailActual.getActualType() != null){
			sql.append(" actual_type = ?, ");
			param.add(myGroupDetailActual.getActualType());
		}
		if(myGroupDetailActual.getActualDate() != null){
			sql.append(" actual_date = ?, ");
			param.add(myGroupDetailActual.getActualDate());
		}
		if(myGroupDetailActual.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(myGroupDetailActual.getGroupId());
		}
		if(myGroupDetailActual.getStorkId() != null){
			sql.append(" stork_id = ?, ");
			param.add(myGroupDetailActual.getStorkId());
		}
		if(myGroupDetailActual.getStorkCode() != null){
			sql.append(" stork_code = ?, ");
			param.add(myGroupDetailActual.getStorkCode());
		}
		if(myGroupDetailActual.getStorkName() != null){
			sql.append(" stork_name = ?, ");
			param.add(myGroupDetailActual.getStorkName());
		}
		if(myGroupDetailActual.getTotalTradeIncome() != null){
			sql.append(" total_trade_income = ?, ");
			param.add(myGroupDetailActual.getTotalTradeIncome());
		}
		if(myGroupDetailActual.getTodayTradeIncome() != null){
			sql.append(" today_trade_income = ?, ");
			param.add(myGroupDetailActual.getTodayTradeIncome());
		}
		if(myGroupDetailActual.getTotalCost() != null){
			sql.append(" total_cost = ?, ");
			param.add(myGroupDetailActual.getTotalCost());
		}
		if(myGroupDetailActual.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(myGroupDetailActual.getCreateDate());
		}
		if(myGroupDetailActual.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(myGroupDetailActual.getUpdateDate());
		}
		if(myGroupDetailActual.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(myGroupDetailActual.getIsDel());
		}
		sql.append(" WHERE actual_detail_id = ? ");
		param.add(myGroupDetailActual.getActualDetailId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param myGroupDetailActuals
	 * @return
	 */
	public Map<String, Object>[] toMap(List<MyGroupDetailActual> myGroupDetailActuals){
		Map<String, Object>[] maps = new Map[myGroupDetailActuals.size()];
		for(int i = 0; i < myGroupDetailActuals.size(); i++){
			MyGroupDetailActual myGroupDetailActual = myGroupDetailActuals.get(i);
			maps[i] = toMap(myGroupDetailActual);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param myGroupDetailActual
	 * @return
	 */
	public Map<String, Object> toMap(MyGroupDetailActual myGroupDetailActual){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("actual_detail_id", myGroupDetailActual.getActualDetailId());
        paramMap.put("actual_type", myGroupDetailActual.getActualType());
        paramMap.put("actual_date", myGroupDetailActual.getActualDate());
        paramMap.put("group_id", myGroupDetailActual.getGroupId());
        paramMap.put("stork_id", myGroupDetailActual.getStorkId());
        paramMap.put("stork_code", myGroupDetailActual.getStorkCode());
        paramMap.put("stork_name", myGroupDetailActual.getStorkName());
        paramMap.put("total_trade_income", myGroupDetailActual.getTotalTradeIncome());
        paramMap.put("today_trade_income", myGroupDetailActual.getTodayTradeIncome());
        paramMap.put("total_cost", myGroupDetailActual.getTotalCost());
        paramMap.put("create_date", myGroupDetailActual.getCreateDate());
        paramMap.put("update_date", myGroupDetailActual.getUpdateDate());
        paramMap.put("is_del", myGroupDetailActual.getIsDel());
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
	public void delete(Long actualDetailId){
		jdbcTemplate.update(DELETE_SQL, actualDetailId);
	}

	@Override
	public void batchSave(List<MyGroupDetailActual> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<MyGroupDetailActual> list){
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
	 * @param actualDetailId 组合详情ID
	 * @return MyGroupDetailActual
	 */
	@Override
	public MyGroupDetailActual findById(Long actualDetailId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`actual_detail_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(MyGroupDetailActual.class), actualDetailId);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @return List
	 */
	@Override
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual){
		return this.find(myGroupDetailActual, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, String[][] orders){
		return this.find(myGroupDetailActual, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, Long offset, Long rows){
		return this.find(myGroupDetailActual, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroupDetailActual
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroupDetailActual> find(MyGroupDetailActual myGroupDetailActual, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(myGroupDetailActual != null){
			if(myGroupDetailActual.getActualDetailId() != null){
				sql.append(" AND _this.`actual_detail_id` = ?");
				param.add(myGroupDetailActual.getActualDetailId());
			}
			if(myGroupDetailActual.getActualType() != null && !"".equals(myGroupDetailActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ?");
				param.add(myGroupDetailActual.getActualType());
			}
			if(myGroupDetailActual.getActualDate() != null){
				sql.append(" AND _this.`actual_date` = ?");
				param.add(myGroupDetailActual.getActualDate());
			}
			if(myGroupDetailActual.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(myGroupDetailActual.getGroupId());
			}
			if(myGroupDetailActual.getStorkId() != null){
				sql.append(" AND _this.`stork_id` = ?");
				param.add(myGroupDetailActual.getStorkId());
			}
			if(myGroupDetailActual.getStorkCode() != null && !"".equals(myGroupDetailActual.getStorkCode())){
				sql.append(" AND _this.`stork_code` = ?");
				param.add(myGroupDetailActual.getStorkCode());
			}
			if(myGroupDetailActual.getStorkName() != null && !"".equals(myGroupDetailActual.getStorkName())){
				sql.append(" AND _this.`stork_name` = ?");
				param.add(myGroupDetailActual.getStorkName());
			}
			if(myGroupDetailActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(myGroupDetailActual.getCreateDate());
			}
			if(myGroupDetailActual.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(myGroupDetailActual.getUpdateDate());
			}
			if(myGroupDetailActual.getIsDel() != null && !"".equals(myGroupDetailActual.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(myGroupDetailActual.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(MyGroupDetailActual.class));
	}


	/**
	 * 根据对象查询条数
	 * @param myGroupDetailActual
	 * @return Long
	 */
	@Override
	public Long count(MyGroupDetailActual myGroupDetailActual){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_my_group_detail_actual  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(myGroupDetailActual != null){
			if(myGroupDetailActual.getActualDetailId() != null){
				sql.append(" AND _this.`actual_detail_id` = ? ");
				param.add(myGroupDetailActual.getActualDetailId());
			}
			if(myGroupDetailActual.getActualType() != null && !"".equals(myGroupDetailActual.getActualType())){
				sql.append(" AND _this.`actual_type` = ? ");
				param.add(myGroupDetailActual.getActualType());
			}
			if(myGroupDetailActual.getActualDate() != null){
				sql.append(" AND _this.`actual_date` = ? ");
				param.add(myGroupDetailActual.getActualDate());
			}
			if(myGroupDetailActual.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(myGroupDetailActual.getGroupId());
			}
			if(myGroupDetailActual.getStorkId() != null){
				sql.append(" AND _this.`stork_id` = ? ");
				param.add(myGroupDetailActual.getStorkId());
			}
			if(myGroupDetailActual.getStorkCode() != null && !"".equals(myGroupDetailActual.getStorkCode())){
				sql.append(" AND _this.`stork_code` = ? ");
				param.add(myGroupDetailActual.getStorkCode());
			}
			if(myGroupDetailActual.getStorkName() != null && !"".equals(myGroupDetailActual.getStorkName())){
				sql.append(" AND _this.`stork_name` = ? ");
				param.add(myGroupDetailActual.getStorkName());
			}
			if(myGroupDetailActual.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(myGroupDetailActual.getCreateDate());
			}
			if(myGroupDetailActual.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(myGroupDetailActual.getUpdateDate());
			}
			if(myGroupDetailActual.getIsDel() != null && !"".equals(myGroupDetailActual.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(myGroupDetailActual.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}