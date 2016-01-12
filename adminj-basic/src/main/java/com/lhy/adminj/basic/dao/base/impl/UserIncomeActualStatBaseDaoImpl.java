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

import com.lhy.adminj.basic.dao.base.UserIncomeActualStatBaseDao;
import com.lhy.adminj.basic.model.UserIncomeActualStat;

/**
 * 用户收益实时统计Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserIncomeActualStatBaseDaoImpl implements UserIncomeActualStatBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`actual_stat_id`, _this.`user_id`, _this.`stat_type`, _this.`group_id`, _this.`day_time`, _this.`hour_time`, _this.`income_amount`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`actual_stat_id`, _this.`user_id`, _this.`stat_type`, _this.`group_id`, _this.`day_time`, _this.`hour_time`, _this.`income_amount`, _this.`create_date`, _this.`update_date` FROM tmc_user_income_actual_stat _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_user_income_actual_stat(`actual_stat_id`, `user_id`, `stat_type`, `group_id`, `day_time`, `hour_time`, `income_amount`, `create_date`, `update_date`) VALUES (:actual_stat_id, :user_id, :stat_type, :group_id, :day_time, :hour_time, :income_amount, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_user_income_actual_stat SET `actual_stat_id` = :actual_stat_id, `user_id` = :user_id, `stat_type` = :stat_type, `group_id` = :group_id, `day_time` = :day_time, `hour_time` = :hour_time, `income_amount` = :income_amount, `create_date` = :create_date, `update_date` = :update_date WHERE `actual_stat_id` = :actual_stat_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_user_income_actual_stat WHERE `actual_stat_id` = ?";

	@Override
	public void save(UserIncomeActualStat userIncomeActualStat) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userIncomeActualStat);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userIncomeActualStat.setActualStatId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserIncomeActualStat userIncomeActualStat) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userIncomeActualStat);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserIncomeActualStat userIncomeActualStat) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_user_income_actual_stat SET ");
		if(userIncomeActualStat.getActualStatId() != null){
			sql.append(" actual_stat_id = ?, ");
			param.add(userIncomeActualStat.getActualStatId());
		}
		if(userIncomeActualStat.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userIncomeActualStat.getUserId());
		}
		if(userIncomeActualStat.getStatType() != null){
			sql.append(" stat_type = ?, ");
			param.add(userIncomeActualStat.getStatType());
		}
		if(userIncomeActualStat.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(userIncomeActualStat.getGroupId());
		}
		if(userIncomeActualStat.getDayTime() != null){
			sql.append(" day_time = ?, ");
			param.add(userIncomeActualStat.getDayTime());
		}
		if(userIncomeActualStat.getHourTime() != null){
			sql.append(" hour_time = ?, ");
			param.add(userIncomeActualStat.getHourTime());
		}
		if(userIncomeActualStat.getIncomeAmount() != null){
			sql.append(" income_amount = ?, ");
			param.add(userIncomeActualStat.getIncomeAmount());
		}
		if(userIncomeActualStat.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userIncomeActualStat.getCreateDate());
		}
		if(userIncomeActualStat.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(userIncomeActualStat.getUpdateDate());
		}
		sql.append(" WHERE actual_stat_id = ? ");
		param.add(userIncomeActualStat.getActualStatId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userIncomeActualStats
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserIncomeActualStat> userIncomeActualStats){
		Map<String, Object>[] maps = new Map[userIncomeActualStats.size()];
		for(int i = 0; i < userIncomeActualStats.size(); i++){
			UserIncomeActualStat userIncomeActualStat = userIncomeActualStats.get(i);
			maps[i] = toMap(userIncomeActualStat);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userIncomeActualStat
	 * @return
	 */
	public Map<String, Object> toMap(UserIncomeActualStat userIncomeActualStat){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("actual_stat_id", userIncomeActualStat.getActualStatId());
        paramMap.put("user_id", userIncomeActualStat.getUserId());
        paramMap.put("stat_type", userIncomeActualStat.getStatType());
        paramMap.put("group_id", userIncomeActualStat.getGroupId());
        paramMap.put("day_time", userIncomeActualStat.getDayTime());
        paramMap.put("hour_time", userIncomeActualStat.getHourTime());
        paramMap.put("income_amount", userIncomeActualStat.getIncomeAmount());
        paramMap.put("create_date", userIncomeActualStat.getCreateDate());
        paramMap.put("update_date", userIncomeActualStat.getUpdateDate());
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
	public void delete(Long actualStatId){
		jdbcTemplate.update(DELETE_SQL, actualStatId);
	}

	@Override
	public void batchSave(List<UserIncomeActualStat> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserIncomeActualStat> list){
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
	 * @param actualStatId 实时统计ID
	 * @return UserIncomeActualStat
	 */
	@Override
	public UserIncomeActualStat findById(Long actualStatId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`actual_stat_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserIncomeActualStat.class), actualStatId);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @return List
	 */
	@Override
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat){
		return this.find(userIncomeActualStat, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, String[][] orders){
		return this.find(userIncomeActualStat, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, Long offset, Long rows){
		return this.find(userIncomeActualStat, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userIncomeActualStat
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserIncomeActualStat> find(UserIncomeActualStat userIncomeActualStat, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userIncomeActualStat != null){
			if(userIncomeActualStat.getActualStatId() != null){
				sql.append(" AND _this.`actual_stat_id` = ?");
				param.add(userIncomeActualStat.getActualStatId());
			}
			if(userIncomeActualStat.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userIncomeActualStat.getUserId());
			}
			if(userIncomeActualStat.getStatType() != null && !"".equals(userIncomeActualStat.getStatType())){
				sql.append(" AND _this.`stat_type` = ?");
				param.add(userIncomeActualStat.getStatType());
			}
			if(userIncomeActualStat.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(userIncomeActualStat.getGroupId());
			}
			if(userIncomeActualStat.getDayTime() != null){
				sql.append(" AND _this.`day_time` = ?");
				param.add(userIncomeActualStat.getDayTime());
			}
			if(userIncomeActualStat.getHourTime() != null){
				sql.append(" AND _this.`hour_time` = ?");
				param.add(userIncomeActualStat.getHourTime());
			}
			if(userIncomeActualStat.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userIncomeActualStat.getCreateDate());
			}
			if(userIncomeActualStat.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userIncomeActualStat.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserIncomeActualStat.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userIncomeActualStat
	 * @return Long
	 */
	@Override
	public Long count(UserIncomeActualStat userIncomeActualStat){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_user_income_actual_stat  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userIncomeActualStat != null){
			if(userIncomeActualStat.getActualStatId() != null){
				sql.append(" AND _this.`actual_stat_id` = ? ");
				param.add(userIncomeActualStat.getActualStatId());
			}
			if(userIncomeActualStat.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userIncomeActualStat.getUserId());
			}
			if(userIncomeActualStat.getStatType() != null && !"".equals(userIncomeActualStat.getStatType())){
				sql.append(" AND _this.`stat_type` = ? ");
				param.add(userIncomeActualStat.getStatType());
			}
			if(userIncomeActualStat.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(userIncomeActualStat.getGroupId());
			}
			if(userIncomeActualStat.getDayTime() != null){
				sql.append(" AND _this.`day_time` = ? ");
				param.add(userIncomeActualStat.getDayTime());
			}
			if(userIncomeActualStat.getHourTime() != null){
				sql.append(" AND _this.`hour_time` = ? ");
				param.add(userIncomeActualStat.getHourTime());
			}
			if(userIncomeActualStat.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userIncomeActualStat.getCreateDate());
			}
			if(userIncomeActualStat.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userIncomeActualStat.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}