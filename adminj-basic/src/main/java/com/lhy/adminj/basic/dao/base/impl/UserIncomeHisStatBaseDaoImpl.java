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

import com.lhy.adminj.basic.dao.base.UserIncomeHisStatBaseDao;
import com.lhy.adminj.basic.model.UserIncomeHisStat;

/**
 * 用户历史收益统计Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserIncomeHisStatBaseDaoImpl implements UserIncomeHisStatBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`his_stat_id`, _this.`user_id`, _this.`group_id`, _this.`day_node`, _this.`stat_type`, _this.`income_amount`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`his_stat_id`, _this.`user_id`, _this.`group_id`, _this.`day_node`, _this.`stat_type`, _this.`income_amount`, _this.`create_date`, _this.`update_date` FROM tmc_user_income_his_stat _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_user_income_his_stat(`his_stat_id`, `user_id`, `group_id`, `day_node`, `stat_type`, `income_amount`, `create_date`, `update_date`) VALUES (:his_stat_id, :user_id, :group_id, :day_node, :stat_type, :income_amount, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_user_income_his_stat SET `his_stat_id` = :his_stat_id, `user_id` = :user_id, `group_id` = :group_id, `day_node` = :day_node, `stat_type` = :stat_type, `income_amount` = :income_amount, `create_date` = :create_date, `update_date` = :update_date WHERE `his_stat_id` = :his_stat_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_user_income_his_stat WHERE `his_stat_id` = ?";

	@Override
	public void save(UserIncomeHisStat userIncomeHisStat) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userIncomeHisStat);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userIncomeHisStat.setHisStatId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserIncomeHisStat userIncomeHisStat) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userIncomeHisStat);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserIncomeHisStat userIncomeHisStat) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_user_income_his_stat SET ");
		if(userIncomeHisStat.getHisStatId() != null){
			sql.append(" his_stat_id = ?, ");
			param.add(userIncomeHisStat.getHisStatId());
		}
		if(userIncomeHisStat.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userIncomeHisStat.getUserId());
		}
		if(userIncomeHisStat.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(userIncomeHisStat.getGroupId());
		}
		if(userIncomeHisStat.getDayNode() != null){
			sql.append(" day_node = ?, ");
			param.add(userIncomeHisStat.getDayNode());
		}
		if(userIncomeHisStat.getStatType() != null){
			sql.append(" stat_type = ?, ");
			param.add(userIncomeHisStat.getStatType());
		}
		if(userIncomeHisStat.getIncomeAmount() != null){
			sql.append(" income_amount = ?, ");
			param.add(userIncomeHisStat.getIncomeAmount());
		}
		if(userIncomeHisStat.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userIncomeHisStat.getCreateDate());
		}
		if(userIncomeHisStat.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(userIncomeHisStat.getUpdateDate());
		}
		sql.append(" WHERE his_stat_id = ? ");
		param.add(userIncomeHisStat.getHisStatId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userIncomeHisStats
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserIncomeHisStat> userIncomeHisStats){
		Map<String, Object>[] maps = new Map[userIncomeHisStats.size()];
		for(int i = 0; i < userIncomeHisStats.size(); i++){
			UserIncomeHisStat userIncomeHisStat = userIncomeHisStats.get(i);
			maps[i] = toMap(userIncomeHisStat);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userIncomeHisStat
	 * @return
	 */
	public Map<String, Object> toMap(UserIncomeHisStat userIncomeHisStat){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("his_stat_id", userIncomeHisStat.getHisStatId());
        paramMap.put("user_id", userIncomeHisStat.getUserId());
        paramMap.put("group_id", userIncomeHisStat.getGroupId());
        paramMap.put("day_node", userIncomeHisStat.getDayNode());
        paramMap.put("stat_type", userIncomeHisStat.getStatType());
        paramMap.put("income_amount", userIncomeHisStat.getIncomeAmount());
        paramMap.put("create_date", userIncomeHisStat.getCreateDate());
        paramMap.put("update_date", userIncomeHisStat.getUpdateDate());
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
	public void delete(Long hisStatId){
		jdbcTemplate.update(DELETE_SQL, hisStatId);
	}

	@Override
	public void batchSave(List<UserIncomeHisStat> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserIncomeHisStat> list){
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
	 * @param hisStatId 历史统计ID
	 * @return UserIncomeHisStat
	 */
	@Override
	public UserIncomeHisStat findById(Long hisStatId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`his_stat_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserIncomeHisStat.class), hisStatId);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @return List
	 */
	@Override
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat){
		return this.find(userIncomeHisStat, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, String[][] orders){
		return this.find(userIncomeHisStat, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, Long offset, Long rows){
		return this.find(userIncomeHisStat, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeHisStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserIncomeHisStat> find(UserIncomeHisStat userIncomeHisStat, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userIncomeHisStat != null){
			if(userIncomeHisStat.getHisStatId() != null){
				sql.append(" AND _this.`his_stat_id` = ?");
				param.add(userIncomeHisStat.getHisStatId());
			}
			if(userIncomeHisStat.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userIncomeHisStat.getUserId());
			}
			if(userIncomeHisStat.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(userIncomeHisStat.getGroupId());
			}
			if(userIncomeHisStat.getDayNode() != null){
				sql.append(" AND _this.`day_node` = ?");
				param.add(userIncomeHisStat.getDayNode());
			}
			if(userIncomeHisStat.getStatType() != null && !"".equals(userIncomeHisStat.getStatType())){
				sql.append(" AND _this.`stat_type` = ?");
				param.add(userIncomeHisStat.getStatType());
			}
			if(userIncomeHisStat.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userIncomeHisStat.getCreateDate());
			}
			if(userIncomeHisStat.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userIncomeHisStat.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserIncomeHisStat.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userIncomeHisStat
	 * @return Long
	 */
	@Override
	public Long count(UserIncomeHisStat userIncomeHisStat){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_user_income_his_stat  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userIncomeHisStat != null){
			if(userIncomeHisStat.getHisStatId() != null){
				sql.append(" AND _this.`his_stat_id` = ? ");
				param.add(userIncomeHisStat.getHisStatId());
			}
			if(userIncomeHisStat.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userIncomeHisStat.getUserId());
			}
			if(userIncomeHisStat.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(userIncomeHisStat.getGroupId());
			}
			if(userIncomeHisStat.getDayNode() != null){
				sql.append(" AND _this.`day_node` = ? ");
				param.add(userIncomeHisStat.getDayNode());
			}
			if(userIncomeHisStat.getStatType() != null && !"".equals(userIncomeHisStat.getStatType())){
				sql.append(" AND _this.`stat_type` = ? ");
				param.add(userIncomeHisStat.getStatType());
			}
			if(userIncomeHisStat.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userIncomeHisStat.getCreateDate());
			}
			if(userIncomeHisStat.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userIncomeHisStat.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}