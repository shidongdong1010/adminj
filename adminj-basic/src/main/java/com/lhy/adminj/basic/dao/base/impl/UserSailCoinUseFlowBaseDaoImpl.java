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

import com.lhy.adminj.basic.dao.base.UserSailCoinUseFlowBaseDao;
import com.lhy.adminj.basic.model.UserSailCoinUseFlow;

/**
 * 用户航币使用流水表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinUseFlowBaseDaoImpl implements UserSailCoinUseFlowBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`use_flow_id`, _this.`user_id`, _this.`award_class`, _this.`award_user_id`, _this.`award_num`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`use_serv_id`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`use_flow_id`, _this.`user_id`, _this.`award_class`, _this.`award_user_id`, _this.`award_num`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`use_serv_id` FROM umc_user_sail_coin_use_flow _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_sail_coin_use_flow(`use_flow_id`, `user_id`, `award_class`, `award_user_id`, `award_num`, `create_date`, `update_date`, `is_del`, `use_serv_id`) VALUES (:use_flow_id, :user_id, :award_class, :award_user_id, :award_num, :create_date, :update_date, :is_del, :use_serv_id)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_sail_coin_use_flow SET `use_flow_id` = :use_flow_id, `user_id` = :user_id, `award_class` = :award_class, `award_user_id` = :award_user_id, `award_num` = :award_num, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del, `use_serv_id` = :use_serv_id WHERE `use_flow_id` = :use_flow_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_sail_coin_use_flow WHERE `use_flow_id` = ?";

	@Override
	public void save(UserSailCoinUseFlow userSailCoinUseFlow) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userSailCoinUseFlow);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userSailCoinUseFlow.setUseFlowId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserSailCoinUseFlow userSailCoinUseFlow) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userSailCoinUseFlow);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserSailCoinUseFlow userSailCoinUseFlow) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_sail_coin_use_flow SET ");
		if(userSailCoinUseFlow.getUseFlowId() != null){
			sql.append(" use_flow_id = ?, ");
			param.add(userSailCoinUseFlow.getUseFlowId());
		}
		if(userSailCoinUseFlow.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userSailCoinUseFlow.getUserId());
		}
		if(userSailCoinUseFlow.getAwardClass() != null){
			sql.append(" award_class = ?, ");
			param.add(userSailCoinUseFlow.getAwardClass());
		}
		if(userSailCoinUseFlow.getAwardUserId() != null){
			sql.append(" award_user_id = ?, ");
			param.add(userSailCoinUseFlow.getAwardUserId());
		}
		if(userSailCoinUseFlow.getAwardNum() != null){
			sql.append(" award_num = ?, ");
			param.add(userSailCoinUseFlow.getAwardNum());
		}
		if(userSailCoinUseFlow.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userSailCoinUseFlow.getCreateDate());
		}
		if(userSailCoinUseFlow.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userSailCoinUseFlow.getUpdateDate());
		}
		if(userSailCoinUseFlow.getIsDel() != null){
			sql.append(" is_del = ?, ");
			param.add(userSailCoinUseFlow.getIsDel());
		}
		if(userSailCoinUseFlow.getUseServId() != null){
			sql.append(" use_serv_id = ? ");
			param.add(userSailCoinUseFlow.getUseServId());
		}
		sql.append(" WHERE use_flow_id = ? ");
		param.add(userSailCoinUseFlow.getUseFlowId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userSailCoinUseFlows
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserSailCoinUseFlow> userSailCoinUseFlows){
		Map<String, Object>[] maps = new Map[userSailCoinUseFlows.size()];
		for(int i = 0; i < userSailCoinUseFlows.size(); i++){
			UserSailCoinUseFlow userSailCoinUseFlow = userSailCoinUseFlows.get(i);
			maps[i] = toMap(userSailCoinUseFlow);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userSailCoinUseFlow
	 * @return
	 */
	public Map<String, Object> toMap(UserSailCoinUseFlow userSailCoinUseFlow){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("use_flow_id", userSailCoinUseFlow.getUseFlowId());
        paramMap.put("user_id", userSailCoinUseFlow.getUserId());
        paramMap.put("award_class", userSailCoinUseFlow.getAwardClass());
        paramMap.put("award_user_id", userSailCoinUseFlow.getAwardUserId());
        paramMap.put("award_num", userSailCoinUseFlow.getAwardNum());
        paramMap.put("create_date", userSailCoinUseFlow.getCreateDate());
        paramMap.put("update_date", userSailCoinUseFlow.getUpdateDate());
        paramMap.put("is_del", userSailCoinUseFlow.getIsDel());
        paramMap.put("use_serv_id", userSailCoinUseFlow.getUseServId());
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
	public void delete(Long useFlowId){
		jdbcTemplate.update(DELETE_SQL, useFlowId);
	}

	@Override
	public void batchSave(List<UserSailCoinUseFlow> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserSailCoinUseFlow> list){
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
	 * @param useFlowId 航币使用流水ID,自增
	 * @return UserSailCoinUseFlow
	 */
	@Override
	public UserSailCoinUseFlow findById(Long useFlowId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`use_flow_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserSailCoinUseFlow.class), useFlowId);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @return List
	 */
	@Override
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow){
		return this.find(userSailCoinUseFlow, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, String[][] orders){
		return this.find(userSailCoinUseFlow, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, Long offset, Long rows){
		return this.find(userSailCoinUseFlow, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinUseFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserSailCoinUseFlow> find(UserSailCoinUseFlow userSailCoinUseFlow, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userSailCoinUseFlow != null){
			if(userSailCoinUseFlow.getUseFlowId() != null){
				sql.append(" AND _this.`use_flow_id` = ?");
				param.add(userSailCoinUseFlow.getUseFlowId());
			}
			if(userSailCoinUseFlow.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userSailCoinUseFlow.getUserId());
			}
			if(userSailCoinUseFlow.getAwardClass() != null && !"".equals(userSailCoinUseFlow.getAwardClass())){
				sql.append(" AND _this.`award_class` = ?");
				param.add(userSailCoinUseFlow.getAwardClass());
			}
			if(userSailCoinUseFlow.getAwardUserId() != null){
				sql.append(" AND _this.`award_user_id` = ?");
				param.add(userSailCoinUseFlow.getAwardUserId());
			}
			if(userSailCoinUseFlow.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userSailCoinUseFlow.getCreateDate());
			}
			if(userSailCoinUseFlow.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userSailCoinUseFlow.getUpdateDate());
			}
			if(userSailCoinUseFlow.getIsDel() != null && !"".equals(userSailCoinUseFlow.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userSailCoinUseFlow.getIsDel());
			}
			if(userSailCoinUseFlow.getUseServId() != null){
				sql.append(" AND _this.`use_serv_id` = ?");
				param.add(userSailCoinUseFlow.getUseServId());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserSailCoinUseFlow.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userSailCoinUseFlow
	 * @return Long
	 */
	@Override
	public Long count(UserSailCoinUseFlow userSailCoinUseFlow){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_sail_coin_use_flow  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userSailCoinUseFlow != null){
			if(userSailCoinUseFlow.getUseFlowId() != null){
				sql.append(" AND _this.`use_flow_id` = ? ");
				param.add(userSailCoinUseFlow.getUseFlowId());
			}
			if(userSailCoinUseFlow.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userSailCoinUseFlow.getUserId());
			}
			if(userSailCoinUseFlow.getAwardClass() != null && !"".equals(userSailCoinUseFlow.getAwardClass())){
				sql.append(" AND _this.`award_class` = ? ");
				param.add(userSailCoinUseFlow.getAwardClass());
			}
			if(userSailCoinUseFlow.getAwardUserId() != null){
				sql.append(" AND _this.`award_user_id` = ? ");
				param.add(userSailCoinUseFlow.getAwardUserId());
			}
			if(userSailCoinUseFlow.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userSailCoinUseFlow.getCreateDate());
			}
			if(userSailCoinUseFlow.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userSailCoinUseFlow.getUpdateDate());
			}
			if(userSailCoinUseFlow.getIsDel() != null && !"".equals(userSailCoinUseFlow.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userSailCoinUseFlow.getIsDel());
			}
			if(userSailCoinUseFlow.getUseServId() != null){
				sql.append(" AND _this.`use_serv_id` = ? ");
				param.add(userSailCoinUseFlow.getUseServId());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}