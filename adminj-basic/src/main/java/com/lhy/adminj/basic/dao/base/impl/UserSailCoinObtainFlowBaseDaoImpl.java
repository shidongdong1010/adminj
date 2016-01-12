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

import com.lhy.adminj.basic.dao.base.UserSailCoinObtainFlowBaseDao;
import com.lhy.adminj.basic.model.UserSailCoinObtainFlow;

/**
 * 用户航币获取流水表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserSailCoinObtainFlowBaseDaoImpl implements UserSailCoinObtainFlowBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`obtain_flow_id`, _this.`obtain_way`, _this.`recommend_user_id`, _this.`award_num`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`user_id`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`obtain_flow_id`, _this.`obtain_way`, _this.`recommend_user_id`, _this.`award_num`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`user_id` FROM umc_user_sail_coin_obtain_flow _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_sail_coin_obtain_flow(`obtain_flow_id`, `obtain_way`, `recommend_user_id`, `award_num`, `create_date`, `update_date`, `is_del`, `user_id`) VALUES (:obtain_flow_id, :obtain_way, :recommend_user_id, :award_num, :create_date, :update_date, :is_del, :user_id)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_sail_coin_obtain_flow SET `obtain_flow_id` = :obtain_flow_id, `obtain_way` = :obtain_way, `recommend_user_id` = :recommend_user_id, `award_num` = :award_num, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del, `user_id` = :user_id WHERE `obtain_flow_id` = :obtain_flow_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_sail_coin_obtain_flow WHERE `obtain_flow_id` = ?";

	@Override
	public void save(UserSailCoinObtainFlow userSailCoinObtainFlow) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userSailCoinObtainFlow);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userSailCoinObtainFlow.setObtainFlowId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserSailCoinObtainFlow userSailCoinObtainFlow) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userSailCoinObtainFlow);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserSailCoinObtainFlow userSailCoinObtainFlow) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_sail_coin_obtain_flow SET ");
		if(userSailCoinObtainFlow.getObtainFlowId() != null){
			sql.append(" obtain_flow_id = ?, ");
			param.add(userSailCoinObtainFlow.getObtainFlowId());
		}
		if(userSailCoinObtainFlow.getObtainWay() != null){
			sql.append(" obtain_way = ?, ");
			param.add(userSailCoinObtainFlow.getObtainWay());
		}
		if(userSailCoinObtainFlow.getRecommendUserId() != null){
			sql.append(" recommend_user_id = ?, ");
			param.add(userSailCoinObtainFlow.getRecommendUserId());
		}
		if(userSailCoinObtainFlow.getAwardNum() != null){
			sql.append(" award_num = ?, ");
			param.add(userSailCoinObtainFlow.getAwardNum());
		}
		if(userSailCoinObtainFlow.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userSailCoinObtainFlow.getCreateDate());
		}
		if(userSailCoinObtainFlow.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userSailCoinObtainFlow.getUpdateDate());
		}
		if(userSailCoinObtainFlow.getIsDel() != null){
			sql.append(" is_del = ?, ");
			param.add(userSailCoinObtainFlow.getIsDel());
		}
		if(userSailCoinObtainFlow.getUserId() != null){
			sql.append(" user_id = ? ");
			param.add(userSailCoinObtainFlow.getUserId());
		}
		sql.append(" WHERE obtain_flow_id = ? ");
		param.add(userSailCoinObtainFlow.getObtainFlowId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userSailCoinObtainFlows
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserSailCoinObtainFlow> userSailCoinObtainFlows){
		Map<String, Object>[] maps = new Map[userSailCoinObtainFlows.size()];
		for(int i = 0; i < userSailCoinObtainFlows.size(); i++){
			UserSailCoinObtainFlow userSailCoinObtainFlow = userSailCoinObtainFlows.get(i);
			maps[i] = toMap(userSailCoinObtainFlow);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userSailCoinObtainFlow
	 * @return
	 */
	public Map<String, Object> toMap(UserSailCoinObtainFlow userSailCoinObtainFlow){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("obtain_flow_id", userSailCoinObtainFlow.getObtainFlowId());
        paramMap.put("obtain_way", userSailCoinObtainFlow.getObtainWay());
        paramMap.put("recommend_user_id", userSailCoinObtainFlow.getRecommendUserId());
        paramMap.put("award_num", userSailCoinObtainFlow.getAwardNum());
        paramMap.put("create_date", userSailCoinObtainFlow.getCreateDate());
        paramMap.put("update_date", userSailCoinObtainFlow.getUpdateDate());
        paramMap.put("is_del", userSailCoinObtainFlow.getIsDel());
        paramMap.put("user_id", userSailCoinObtainFlow.getUserId());
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
	public void delete(Long obtainFlowId){
		jdbcTemplate.update(DELETE_SQL, obtainFlowId);
	}

	@Override
	public void batchSave(List<UserSailCoinObtainFlow> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserSailCoinObtainFlow> list){
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
	 * @param obtainFlowId 航币获取流水ID,自增
	 * @return UserSailCoinObtainFlow
	 */
	@Override
	public UserSailCoinObtainFlow findById(Long obtainFlowId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`obtain_flow_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserSailCoinObtainFlow.class), obtainFlowId);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @return List
	 */
	@Override
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow){
		return this.find(userSailCoinObtainFlow, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, String[][] orders){
		return this.find(userSailCoinObtainFlow, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, Long offset, Long rows){
		return this.find(userSailCoinObtainFlow, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userSailCoinObtainFlow
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserSailCoinObtainFlow> find(UserSailCoinObtainFlow userSailCoinObtainFlow, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userSailCoinObtainFlow != null){
			if(userSailCoinObtainFlow.getObtainFlowId() != null){
				sql.append(" AND _this.`obtain_flow_id` = ?");
				param.add(userSailCoinObtainFlow.getObtainFlowId());
			}
			if(userSailCoinObtainFlow.getObtainWay() != null && !"".equals(userSailCoinObtainFlow.getObtainWay())){
				sql.append(" AND _this.`obtain_way` = ?");
				param.add(userSailCoinObtainFlow.getObtainWay());
			}
			if(userSailCoinObtainFlow.getRecommendUserId() != null){
				sql.append(" AND _this.`recommend_user_id` = ?");
				param.add(userSailCoinObtainFlow.getRecommendUserId());
			}
			if(userSailCoinObtainFlow.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userSailCoinObtainFlow.getCreateDate());
			}
			if(userSailCoinObtainFlow.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userSailCoinObtainFlow.getUpdateDate());
			}
			if(userSailCoinObtainFlow.getIsDel() != null && !"".equals(userSailCoinObtainFlow.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userSailCoinObtainFlow.getIsDel());
			}
			if(userSailCoinObtainFlow.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userSailCoinObtainFlow.getUserId());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserSailCoinObtainFlow.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userSailCoinObtainFlow
	 * @return Long
	 */
	@Override
	public Long count(UserSailCoinObtainFlow userSailCoinObtainFlow){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_sail_coin_obtain_flow  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userSailCoinObtainFlow != null){
			if(userSailCoinObtainFlow.getObtainFlowId() != null){
				sql.append(" AND _this.`obtain_flow_id` = ? ");
				param.add(userSailCoinObtainFlow.getObtainFlowId());
			}
			if(userSailCoinObtainFlow.getObtainWay() != null && !"".equals(userSailCoinObtainFlow.getObtainWay())){
				sql.append(" AND _this.`obtain_way` = ? ");
				param.add(userSailCoinObtainFlow.getObtainWay());
			}
			if(userSailCoinObtainFlow.getRecommendUserId() != null){
				sql.append(" AND _this.`recommend_user_id` = ? ");
				param.add(userSailCoinObtainFlow.getRecommendUserId());
			}
			if(userSailCoinObtainFlow.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userSailCoinObtainFlow.getCreateDate());
			}
			if(userSailCoinObtainFlow.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userSailCoinObtainFlow.getUpdateDate());
			}
			if(userSailCoinObtainFlow.getIsDel() != null && !"".equals(userSailCoinObtainFlow.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userSailCoinObtainFlow.getIsDel());
			}
			if(userSailCoinObtainFlow.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userSailCoinObtainFlow.getUserId());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}