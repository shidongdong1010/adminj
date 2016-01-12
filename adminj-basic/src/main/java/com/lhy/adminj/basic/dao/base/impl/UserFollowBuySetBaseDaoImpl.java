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

import com.lhy.adminj.basic.dao.base.UserFollowBuySetBaseDao;
import com.lhy.adminj.basic.model.UserFollowBuySet;

/**
 * 用户跟买设置Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFollowBuySetBaseDaoImpl implements UserFollowBuySetBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`user_id`, _this.`follow_buy_num`, _this.`see_range`, _this.`need_reward`, _this.`reward_sail_coin`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`user_id`, _this.`follow_buy_num`, _this.`see_range`, _this.`need_reward`, _this.`reward_sail_coin`, _this.`create_date`, _this.`update_date` FROM umc_user_follow_buy_set _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_follow_buy_set(`user_id`, `follow_buy_num`, `see_range`, `need_reward`, `reward_sail_coin`, `create_date`, `update_date`) VALUES (:user_id, :follow_buy_num, :see_range, :need_reward, :reward_sail_coin, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_follow_buy_set SET `user_id` = :user_id, `follow_buy_num` = :follow_buy_num, `see_range` = :see_range, `need_reward` = :need_reward, `reward_sail_coin` = :reward_sail_coin, `create_date` = :create_date, `update_date` = :update_date WHERE `user_id` = :user_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_follow_buy_set WHERE `user_id` = ?";

	@Override
	public void save(UserFollowBuySet userFollowBuySet) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userFollowBuySet);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userFollowBuySet.setUserId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserFollowBuySet userFollowBuySet) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userFollowBuySet);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserFollowBuySet userFollowBuySet) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_follow_buy_set SET ");
		if(userFollowBuySet.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userFollowBuySet.getUserId());
		}
		if(userFollowBuySet.getFollowBuyNum() != null){
			sql.append(" follow_buy_num = ?, ");
			param.add(userFollowBuySet.getFollowBuyNum());
		}
		if(userFollowBuySet.getSeeRange() != null){
			sql.append(" see_range = ?, ");
			param.add(userFollowBuySet.getSeeRange());
		}
		if(userFollowBuySet.getNeedReward() != null){
			sql.append(" need_reward = ?, ");
			param.add(userFollowBuySet.getNeedReward());
		}
		if(userFollowBuySet.getRewardSailCoin() != null){
			sql.append(" reward_sail_coin = ?, ");
			param.add(userFollowBuySet.getRewardSailCoin());
		}
		if(userFollowBuySet.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userFollowBuySet.getCreateDate());
		}
		if(userFollowBuySet.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(userFollowBuySet.getUpdateDate());
		}
		sql.append(" WHERE user_id = ? ");
		param.add(userFollowBuySet.getUserId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userFollowBuySets
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserFollowBuySet> userFollowBuySets){
		Map<String, Object>[] maps = new Map[userFollowBuySets.size()];
		for(int i = 0; i < userFollowBuySets.size(); i++){
			UserFollowBuySet userFollowBuySet = userFollowBuySets.get(i);
			maps[i] = toMap(userFollowBuySet);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userFollowBuySet
	 * @return
	 */
	public Map<String, Object> toMap(UserFollowBuySet userFollowBuySet){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userFollowBuySet.getUserId());
        paramMap.put("follow_buy_num", userFollowBuySet.getFollowBuyNum());
        paramMap.put("see_range", userFollowBuySet.getSeeRange());
        paramMap.put("need_reward", userFollowBuySet.getNeedReward());
        paramMap.put("reward_sail_coin", userFollowBuySet.getRewardSailCoin());
        paramMap.put("create_date", userFollowBuySet.getCreateDate());
        paramMap.put("update_date", userFollowBuySet.getUpdateDate());
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
	public void batchSave(List<UserFollowBuySet> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserFollowBuySet> list){
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
	 * @return UserFollowBuySet
	 */
	@Override
	public UserFollowBuySet findById(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`user_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserFollowBuySet.class), userId);
	}

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @return List
	 */
	@Override
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet){
		return this.find(userFollowBuySet, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, String[][] orders){
		return this.find(userFollowBuySet, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, Long offset, Long rows){
		return this.find(userFollowBuySet, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userFollowBuySet
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFollowBuySet> find(UserFollowBuySet userFollowBuySet, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userFollowBuySet != null){
			if(userFollowBuySet.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userFollowBuySet.getUserId());
			}
			if(userFollowBuySet.getFollowBuyNum() != null){
				sql.append(" AND _this.`follow_buy_num` = ?");
				param.add(userFollowBuySet.getFollowBuyNum());
			}
			if(userFollowBuySet.getSeeRange() != null && !"".equals(userFollowBuySet.getSeeRange())){
				sql.append(" AND _this.`see_range` = ?");
				param.add(userFollowBuySet.getSeeRange());
			}
			if(userFollowBuySet.getNeedReward() != null && !"".equals(userFollowBuySet.getNeedReward())){
				sql.append(" AND _this.`need_reward` = ?");
				param.add(userFollowBuySet.getNeedReward());
			}
			if(userFollowBuySet.getRewardSailCoin() != null){
				sql.append(" AND _this.`reward_sail_coin` = ?");
				param.add(userFollowBuySet.getRewardSailCoin());
			}
			if(userFollowBuySet.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userFollowBuySet.getCreateDate());
			}
			if(userFollowBuySet.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userFollowBuySet.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserFollowBuySet.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userFollowBuySet
	 * @return Long
	 */
	@Override
	public Long count(UserFollowBuySet userFollowBuySet){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_follow_buy_set  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userFollowBuySet != null){
			if(userFollowBuySet.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userFollowBuySet.getUserId());
			}
			if(userFollowBuySet.getFollowBuyNum() != null){
				sql.append(" AND _this.`follow_buy_num` = ? ");
				param.add(userFollowBuySet.getFollowBuyNum());
			}
			if(userFollowBuySet.getSeeRange() != null && !"".equals(userFollowBuySet.getSeeRange())){
				sql.append(" AND _this.`see_range` = ? ");
				param.add(userFollowBuySet.getSeeRange());
			}
			if(userFollowBuySet.getNeedReward() != null && !"".equals(userFollowBuySet.getNeedReward())){
				sql.append(" AND _this.`need_reward` = ? ");
				param.add(userFollowBuySet.getNeedReward());
			}
			if(userFollowBuySet.getRewardSailCoin() != null){
				sql.append(" AND _this.`reward_sail_coin` = ? ");
				param.add(userFollowBuySet.getRewardSailCoin());
			}
			if(userFollowBuySet.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userFollowBuySet.getCreateDate());
			}
			if(userFollowBuySet.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userFollowBuySet.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}