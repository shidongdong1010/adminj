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

import com.lhy.adminj.basic.dao.base.UserDynamicSetBaseDao;
import com.lhy.adminj.basic.model.UserDynamicSet;

/**
 * 用户动态设置表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicSetBaseDaoImpl implements UserDynamicSetBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`user_id`, _this.`see_range`, _this.`comment_range`, _this.`need_reward`, _this.`reward_sail_coin`, _this.`show_location`, _this.`local`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`user_id`, _this.`see_range`, _this.`comment_range`, _this.`need_reward`, _this.`reward_sail_coin`, _this.`show_location`, _this.`local`, _this.`create_date`, _this.`update_date` FROM umc_user_dynamic_set _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_dynamic_set(`user_id`, `see_range`, `comment_range`, `need_reward`, `reward_sail_coin`, `show_location`, `local`, `create_date`, `update_date`) VALUES (:user_id, :see_range, :comment_range, :need_reward, :reward_sail_coin, :show_location, :local, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_dynamic_set SET `user_id` = :user_id, `see_range` = :see_range, `comment_range` = :comment_range, `need_reward` = :need_reward, `reward_sail_coin` = :reward_sail_coin, `show_location` = :show_location, `local` = :local, `create_date` = :create_date, `update_date` = :update_date WHERE `user_id` = :user_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_dynamic_set WHERE `user_id` = ?";

	@Override
	public void save(UserDynamicSet userDynamicSet) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicSet);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userDynamicSet.setUserId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserDynamicSet userDynamicSet) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicSet);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserDynamicSet userDynamicSet) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_dynamic_set SET ");
		if(userDynamicSet.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userDynamicSet.getUserId());
		}
		if(userDynamicSet.getSeeRange() != null){
			sql.append(" see_range = ?, ");
			param.add(userDynamicSet.getSeeRange());
		}
		if(userDynamicSet.getCommentRange() != null){
			sql.append(" comment_range = ?, ");
			param.add(userDynamicSet.getCommentRange());
		}
		if(userDynamicSet.getNeedReward() != null){
			sql.append(" need_reward = ?, ");
			param.add(userDynamicSet.getNeedReward());
		}
		if(userDynamicSet.getRewardSailCoin() != null){
			sql.append(" reward_sail_coin = ?, ");
			param.add(userDynamicSet.getRewardSailCoin());
		}
		if(userDynamicSet.getShowLocation() != null){
			sql.append(" show_location = ?, ");
			param.add(userDynamicSet.getShowLocation());
		}
		if(userDynamicSet.getLocal() != null){
			sql.append(" local = ?, ");
			param.add(userDynamicSet.getLocal());
		}
		if(userDynamicSet.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userDynamicSet.getCreateDate());
		}
		if(userDynamicSet.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(userDynamicSet.getUpdateDate());
		}
		sql.append(" WHERE user_id = ? ");
		param.add(userDynamicSet.getUserId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicSets
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserDynamicSet> userDynamicSets){
		Map<String, Object>[] maps = new Map[userDynamicSets.size()];
		for(int i = 0; i < userDynamicSets.size(); i++){
			UserDynamicSet userDynamicSet = userDynamicSets.get(i);
			maps[i] = toMap(userDynamicSet);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicSet
	 * @return
	 */
	public Map<String, Object> toMap(UserDynamicSet userDynamicSet){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userDynamicSet.getUserId());
        paramMap.put("see_range", userDynamicSet.getSeeRange());
        paramMap.put("comment_range", userDynamicSet.getCommentRange());
        paramMap.put("need_reward", userDynamicSet.getNeedReward());
        paramMap.put("reward_sail_coin", userDynamicSet.getRewardSailCoin());
        paramMap.put("show_location", userDynamicSet.getShowLocation());
        paramMap.put("local", userDynamicSet.getLocal());
        paramMap.put("create_date", userDynamicSet.getCreateDate());
        paramMap.put("update_date", userDynamicSet.getUpdateDate());
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
	public void delete(Long userId){
		jdbcTemplate.update(DELETE_SQL, userId);
	}

	@Override
	public void batchSave(List<UserDynamicSet> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserDynamicSet> list){
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
	 * @param userId 用户ID
	 * @return UserDynamicSet
	 */
	@Override
	public UserDynamicSet findById(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`user_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserDynamicSet.class), userId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @return List
	 */
	@Override
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet){
		return this.find(userDynamicSet, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, String[][] orders){
		return this.find(userDynamicSet, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicSet
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, Long offset, Long rows){
		return this.find(userDynamicSet, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicSet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicSet> find(UserDynamicSet userDynamicSet, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userDynamicSet != null){
			if(userDynamicSet.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userDynamicSet.getUserId());
			}
			if(userDynamicSet.getSeeRange() != null && !"".equals(userDynamicSet.getSeeRange())){
				sql.append(" AND _this.`see_range` = ?");
				param.add(userDynamicSet.getSeeRange());
			}
			if(userDynamicSet.getCommentRange() != null && !"".equals(userDynamicSet.getCommentRange())){
				sql.append(" AND _this.`comment_range` = ?");
				param.add(userDynamicSet.getCommentRange());
			}
			if(userDynamicSet.getNeedReward() != null && !"".equals(userDynamicSet.getNeedReward())){
				sql.append(" AND _this.`need_reward` = ?");
				param.add(userDynamicSet.getNeedReward());
			}
			if(userDynamicSet.getShowLocation() != null && !"".equals(userDynamicSet.getShowLocation())){
				sql.append(" AND _this.`show_location` = ?");
				param.add(userDynamicSet.getShowLocation());
			}
			if(userDynamicSet.getLocal() != null && !"".equals(userDynamicSet.getLocal())){
				sql.append(" AND _this.`local` = ?");
				param.add(userDynamicSet.getLocal());
			}
			if(userDynamicSet.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userDynamicSet.getCreateDate());
			}
			if(userDynamicSet.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userDynamicSet.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserDynamicSet.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userDynamicSet
	 * @return Long
	 */
	@Override
	public Long count(UserDynamicSet userDynamicSet){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_dynamic_set  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userDynamicSet != null){
			if(userDynamicSet.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userDynamicSet.getUserId());
			}
			if(userDynamicSet.getSeeRange() != null && !"".equals(userDynamicSet.getSeeRange())){
				sql.append(" AND _this.`see_range` = ? ");
				param.add(userDynamicSet.getSeeRange());
			}
			if(userDynamicSet.getCommentRange() != null && !"".equals(userDynamicSet.getCommentRange())){
				sql.append(" AND _this.`comment_range` = ? ");
				param.add(userDynamicSet.getCommentRange());
			}
			if(userDynamicSet.getNeedReward() != null && !"".equals(userDynamicSet.getNeedReward())){
				sql.append(" AND _this.`need_reward` = ? ");
				param.add(userDynamicSet.getNeedReward());
			}
			if(userDynamicSet.getShowLocation() != null && !"".equals(userDynamicSet.getShowLocation())){
				sql.append(" AND _this.`show_location` = ? ");
				param.add(userDynamicSet.getShowLocation());
			}
			if(userDynamicSet.getLocal() != null && !"".equals(userDynamicSet.getLocal())){
				sql.append(" AND _this.`local` = ? ");
				param.add(userDynamicSet.getLocal());
			}
			if(userDynamicSet.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userDynamicSet.getCreateDate());
			}
			if(userDynamicSet.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userDynamicSet.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}