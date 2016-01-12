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

import com.lhy.adminj.basic.dao.base.UserFriendsBaseDao;
import com.lhy.adminj.basic.model.UserFriends;

/**
 * 用户好友表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserFriendsBaseDaoImpl implements UserFriendsBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`friend_id`, _this.`user_id`, _this.`friend_user_id`, _this.`common_friend_num`, _this.`create_date`, _this.`update_date`, _this.`friend_remark`, _this.`friend_label`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`friend_id`, _this.`user_id`, _this.`friend_user_id`, _this.`common_friend_num`, _this.`create_date`, _this.`update_date`, _this.`friend_remark`, _this.`friend_label` FROM umc_user_friends _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_friends(`friend_id`, `user_id`, `friend_user_id`, `common_friend_num`, `create_date`, `update_date`, `friend_remark`, `friend_label`) VALUES (:friend_id, :user_id, :friend_user_id, :common_friend_num, :create_date, :update_date, :friend_remark, :friend_label)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_friends SET `friend_id` = :friend_id, `user_id` = :user_id, `friend_user_id` = :friend_user_id, `common_friend_num` = :common_friend_num, `create_date` = :create_date, `update_date` = :update_date, `friend_remark` = :friend_remark, `friend_label` = :friend_label WHERE `friend_id` = :friend_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_friends WHERE `friend_id` = ?";

	@Override
	public void save(UserFriends userFriends) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userFriends);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userFriends.setFriendId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserFriends userFriends) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userFriends);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserFriends userFriends) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_friends SET ");
		if(userFriends.getFriendId() != null){
			sql.append(" friend_id = ?, ");
			param.add(userFriends.getFriendId());
		}
		if(userFriends.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userFriends.getUserId());
		}
		if(userFriends.getFriendUserId() != null){
			sql.append(" friend_user_id = ?, ");
			param.add(userFriends.getFriendUserId());
		}
		if(userFriends.getCommonFriendNum() != null){
			sql.append(" common_friend_num = ?, ");
			param.add(userFriends.getCommonFriendNum());
		}
		if(userFriends.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userFriends.getCreateDate());
		}
		if(userFriends.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userFriends.getUpdateDate());
		}
		if(userFriends.getFriendRemark() != null){
			sql.append(" friend_remark = ?, ");
			param.add(userFriends.getFriendRemark());
		}
		if(userFriends.getFriendLabel() != null){
			sql.append(" friend_label = ? ");
			param.add(userFriends.getFriendLabel());
		}
		sql.append(" WHERE friend_id = ? ");
		param.add(userFriends.getFriendId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userFriendss
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserFriends> userFriendss){
		Map<String, Object>[] maps = new Map[userFriendss.size()];
		for(int i = 0; i < userFriendss.size(); i++){
			UserFriends userFriends = userFriendss.get(i);
			maps[i] = toMap(userFriends);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userFriends
	 * @return
	 */
	public Map<String, Object> toMap(UserFriends userFriends){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("friend_id", userFriends.getFriendId());
        paramMap.put("user_id", userFriends.getUserId());
        paramMap.put("friend_user_id", userFriends.getFriendUserId());
        paramMap.put("common_friend_num", userFriends.getCommonFriendNum());
        paramMap.put("create_date", userFriends.getCreateDate());
        paramMap.put("update_date", userFriends.getUpdateDate());
        paramMap.put("friend_remark", userFriends.getFriendRemark());
        paramMap.put("friend_label", userFriends.getFriendLabel());
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
	public void delete(Long friendId){
		jdbcTemplate.update(DELETE_SQL, friendId);
	}

	@Override
	public void batchSave(List<UserFriends> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserFriends> list){
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
	 * @param friendId 用户好友ID,自增序列
	 * @return UserFriends
	 */
	@Override
	public UserFriends findById(Long friendId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`friend_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserFriends.class), friendId);
	}

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @return List
	 */
	@Override
	public List<UserFriends> find(UserFriends userFriends){
		return this.find(userFriends, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserFriends> find(UserFriends userFriends, String[][] orders){
		return this.find(userFriends, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userFriends
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFriends> find(UserFriends userFriends, Long offset, Long rows){
		return this.find(userFriends, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFriends> find(UserFriends userFriends, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userFriends != null){
			if(userFriends.getFriendId() != null){
				sql.append(" AND _this.`friend_id` = ?");
				param.add(userFriends.getFriendId());
			}
			if(userFriends.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userFriends.getUserId());
			}
			if(userFriends.getFriendUserId() != null){
				sql.append(" AND _this.`friend_user_id` = ?");
				param.add(userFriends.getFriendUserId());
			}
			if(userFriends.getCommonFriendNum() != null){
				sql.append(" AND _this.`common_friend_num` = ?");
				param.add(userFriends.getCommonFriendNum());
			}
			if(userFriends.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userFriends.getCreateDate());
			}
			if(userFriends.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userFriends.getUpdateDate());
			}
			if(userFriends.getFriendRemark() != null && !"".equals(userFriends.getFriendRemark())){
				sql.append(" AND _this.`friend_remark` = ?");
				param.add(userFriends.getFriendRemark());
			}
			if(userFriends.getFriendLabel() != null && !"".equals(userFriends.getFriendLabel())){
				sql.append(" AND _this.`friend_label` = ?");
				param.add(userFriends.getFriendLabel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserFriends.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userFriends
	 * @return Long
	 */
	@Override
	public Long count(UserFriends userFriends){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_friends  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userFriends != null){
			if(userFriends.getFriendId() != null){
				sql.append(" AND _this.`friend_id` = ? ");
				param.add(userFriends.getFriendId());
			}
			if(userFriends.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userFriends.getUserId());
			}
			if(userFriends.getFriendUserId() != null){
				sql.append(" AND _this.`friend_user_id` = ? ");
				param.add(userFriends.getFriendUserId());
			}
			if(userFriends.getCommonFriendNum() != null){
				sql.append(" AND _this.`common_friend_num` = ? ");
				param.add(userFriends.getCommonFriendNum());
			}
			if(userFriends.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userFriends.getCreateDate());
			}
			if(userFriends.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userFriends.getUpdateDate());
			}
			if(userFriends.getFriendRemark() != null && !"".equals(userFriends.getFriendRemark())){
				sql.append(" AND _this.`friend_remark` = ? ");
				param.add(userFriends.getFriendRemark());
			}
			if(userFriends.getFriendLabel() != null && !"".equals(userFriends.getFriendLabel())){
				sql.append(" AND _this.`friend_label` = ? ");
				param.add(userFriends.getFriendLabel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}