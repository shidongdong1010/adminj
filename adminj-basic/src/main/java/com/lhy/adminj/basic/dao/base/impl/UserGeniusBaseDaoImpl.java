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

import com.lhy.adminj.basic.dao.base.UserGeniusBaseDao;
import com.lhy.adminj.basic.model.UserGenius;

/**
 * 牛人排名记录表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserGeniusBaseDaoImpl implements UserGeniusBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`genius_id`, _this.`user_id`, _this.`earnings_rate_rank`, _this.`active_rank`, _this.`follow_rank`, _this.`create_date`, _this.`update_date`, _this.`rank_weight`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`genius_id`, _this.`user_id`, _this.`earnings_rate_rank`, _this.`active_rank`, _this.`follow_rank`, _this.`create_date`, _this.`update_date`, _this.`rank_weight` FROM umc_user_genius _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_genius(`genius_id`, `user_id`, `earnings_rate_rank`, `active_rank`, `follow_rank`, `create_date`, `update_date`, `rank_weight`) VALUES (:genius_id, :user_id, :earnings_rate_rank, :active_rank, :follow_rank, :create_date, :update_date, :rank_weight)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_genius SET `genius_id` = :genius_id, `user_id` = :user_id, `earnings_rate_rank` = :earnings_rate_rank, `active_rank` = :active_rank, `follow_rank` = :follow_rank, `create_date` = :create_date, `update_date` = :update_date, `rank_weight` = :rank_weight WHERE `genius_id` = :genius_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_genius WHERE `genius_id` = ?";

	@Override
	public void save(UserGenius userGenius) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userGenius);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userGenius.setGeniusId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserGenius userGenius) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userGenius);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserGenius userGenius) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_genius SET ");
		if(userGenius.getGeniusId() != null){
			sql.append(" genius_id = ?, ");
			param.add(userGenius.getGeniusId());
		}
		if(userGenius.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userGenius.getUserId());
		}
		if(userGenius.getEarningsRateRank() != null){
			sql.append(" earnings_rate_rank = ?, ");
			param.add(userGenius.getEarningsRateRank());
		}
		if(userGenius.getActiveRank() != null){
			sql.append(" active_rank = ?, ");
			param.add(userGenius.getActiveRank());
		}
		if(userGenius.getFollowRank() != null){
			sql.append(" follow_rank = ?, ");
			param.add(userGenius.getFollowRank());
		}
		if(userGenius.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userGenius.getCreateDate());
		}
		if(userGenius.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userGenius.getUpdateDate());
		}
		if(userGenius.getRankWeight() != null){
			sql.append(" rank_weight = ? ");
			param.add(userGenius.getRankWeight());
		}
		sql.append(" WHERE genius_id = ? ");
		param.add(userGenius.getGeniusId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userGeniuss
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserGenius> userGeniuss){
		Map<String, Object>[] maps = new Map[userGeniuss.size()];
		for(int i = 0; i < userGeniuss.size(); i++){
			UserGenius userGenius = userGeniuss.get(i);
			maps[i] = toMap(userGenius);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userGenius
	 * @return
	 */
	public Map<String, Object> toMap(UserGenius userGenius){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("genius_id", userGenius.getGeniusId());
        paramMap.put("user_id", userGenius.getUserId());
        paramMap.put("earnings_rate_rank", userGenius.getEarningsRateRank());
        paramMap.put("active_rank", userGenius.getActiveRank());
        paramMap.put("follow_rank", userGenius.getFollowRank());
        paramMap.put("create_date", userGenius.getCreateDate());
        paramMap.put("update_date", userGenius.getUpdateDate());
        paramMap.put("rank_weight", userGenius.getRankWeight());
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
	public void delete(Long geniusId){
		jdbcTemplate.update(DELETE_SQL, geniusId);
	}

	@Override
	public void batchSave(List<UserGenius> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserGenius> list){
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
	 * @param geniusId 牛人表主键ID
	 * @return UserGenius
	 */
	@Override
	public UserGenius findById(Long geniusId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`genius_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserGenius.class), geniusId);
	}

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @return List
	 */
	@Override
	public List<UserGenius> find(UserGenius userGenius){
		return this.find(userGenius, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserGenius> find(UserGenius userGenius, String[][] orders){
		return this.find(userGenius, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userGenius
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserGenius> find(UserGenius userGenius, Long offset, Long rows){
		return this.find(userGenius, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userGenius
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserGenius> find(UserGenius userGenius, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userGenius != null){
			if(userGenius.getGeniusId() != null){
				sql.append(" AND _this.`genius_id` = ?");
				param.add(userGenius.getGeniusId());
			}
			if(userGenius.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userGenius.getUserId());
			}
			if(userGenius.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userGenius.getCreateDate());
			}
			if(userGenius.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userGenius.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserGenius.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userGenius
	 * @return Long
	 */
	@Override
	public Long count(UserGenius userGenius){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_genius  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userGenius != null){
			if(userGenius.getGeniusId() != null){
				sql.append(" AND _this.`genius_id` = ? ");
				param.add(userGenius.getGeniusId());
			}
			if(userGenius.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userGenius.getUserId());
			}
			if(userGenius.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userGenius.getCreateDate());
			}
			if(userGenius.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userGenius.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}