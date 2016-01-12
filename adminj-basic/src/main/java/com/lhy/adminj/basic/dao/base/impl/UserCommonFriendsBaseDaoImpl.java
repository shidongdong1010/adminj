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

import com.lhy.adminj.basic.dao.base.UserCommonFriendsBaseDao;
import com.lhy.adminj.basic.model.UserCommonFriends;

/**
 * 用户共同好友Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserCommonFriendsBaseDaoImpl implements UserCommonFriendsBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`common_friend_id`, _this.`usera_id`, _this.`userb_id`, _this.`common_friend_userid`, _this.`common_friend_username`, _this.`common_friend_nickname`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`common_friend_id`, _this.`usera_id`, _this.`userb_id`, _this.`common_friend_userid`, _this.`common_friend_username`, _this.`common_friend_nickname` FROM umc_user_common_friends _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_common_friends(`common_friend_id`, `usera_id`, `userb_id`, `common_friend_userid`, `common_friend_username`, `common_friend_nickname`) VALUES (:common_friend_id, :usera_id, :userb_id, :common_friend_userid, :common_friend_username, :common_friend_nickname)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_common_friends SET `common_friend_id` = :common_friend_id, `usera_id` = :usera_id, `userb_id` = :userb_id, `common_friend_userid` = :common_friend_userid, `common_friend_username` = :common_friend_username, `common_friend_nickname` = :common_friend_nickname WHERE `common_friend_id` = :common_friend_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_common_friends WHERE `common_friend_id` = ?";

	@Override
	public void save(UserCommonFriends userCommonFriends) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userCommonFriends);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userCommonFriends.setCommonFriendId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserCommonFriends userCommonFriends) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userCommonFriends);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserCommonFriends userCommonFriends) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_common_friends SET ");
		if(userCommonFriends.getCommonFriendId() != null){
			sql.append(" common_friend_id = ?, ");
			param.add(userCommonFriends.getCommonFriendId());
		}
		if(userCommonFriends.getUseraId() != null){
			sql.append(" usera_id = ?, ");
			param.add(userCommonFriends.getUseraId());
		}
		if(userCommonFriends.getUserbId() != null){
			sql.append(" userb_id = ?, ");
			param.add(userCommonFriends.getUserbId());
		}
		if(userCommonFriends.getCommonFriendUserid() != null){
			sql.append(" common_friend_userid = ?, ");
			param.add(userCommonFriends.getCommonFriendUserid());
		}
		if(userCommonFriends.getCommonFriendUsername() != null){
			sql.append(" common_friend_username = ?, ");
			param.add(userCommonFriends.getCommonFriendUsername());
		}
		if(userCommonFriends.getCommonFriendNickname() != null){
			sql.append(" common_friend_nickname = ? ");
			param.add(userCommonFriends.getCommonFriendNickname());
		}
		sql.append(" WHERE common_friend_id = ? ");
		param.add(userCommonFriends.getCommonFriendId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userCommonFriendss
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserCommonFriends> userCommonFriendss){
		Map<String, Object>[] maps = new Map[userCommonFriendss.size()];
		for(int i = 0; i < userCommonFriendss.size(); i++){
			UserCommonFriends userCommonFriends = userCommonFriendss.get(i);
			maps[i] = toMap(userCommonFriends);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userCommonFriends
	 * @return
	 */
	public Map<String, Object> toMap(UserCommonFriends userCommonFriends){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("common_friend_id", userCommonFriends.getCommonFriendId());
        paramMap.put("usera_id", userCommonFriends.getUseraId());
        paramMap.put("userb_id", userCommonFriends.getUserbId());
        paramMap.put("common_friend_userid", userCommonFriends.getCommonFriendUserid());
        paramMap.put("common_friend_username", userCommonFriends.getCommonFriendUsername());
        paramMap.put("common_friend_nickname", userCommonFriends.getCommonFriendNickname());
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
	public void delete(Long commonFriendId){
		jdbcTemplate.update(DELETE_SQL, commonFriendId);
	}

	@Override
	public void batchSave(List<UserCommonFriends> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserCommonFriends> list){
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
	 * @param commonFriendId 主键
	 * @return UserCommonFriends
	 */
	@Override
	public UserCommonFriends findById(Long commonFriendId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`common_friend_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserCommonFriends.class), commonFriendId);
	}

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @return List
	 */
	@Override
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends){
		return this.find(userCommonFriends, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, String[][] orders){
		return this.find(userCommonFriends, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userCommonFriends
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, Long offset, Long rows){
		return this.find(userCommonFriends, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userCommonFriends
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserCommonFriends> find(UserCommonFriends userCommonFriends, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userCommonFriends != null){
			if(userCommonFriends.getCommonFriendId() != null){
				sql.append(" AND _this.`common_friend_id` = ?");
				param.add(userCommonFriends.getCommonFriendId());
			}
			if(userCommonFriends.getUseraId() != null){
				sql.append(" AND _this.`usera_id` = ?");
				param.add(userCommonFriends.getUseraId());
			}
			if(userCommonFriends.getUserbId() != null){
				sql.append(" AND _this.`userb_id` = ?");
				param.add(userCommonFriends.getUserbId());
			}
			if(userCommonFriends.getCommonFriendUserid() != null){
				sql.append(" AND _this.`common_friend_userid` = ?");
				param.add(userCommonFriends.getCommonFriendUserid());
			}
			if(userCommonFriends.getCommonFriendUsername() != null && !"".equals(userCommonFriends.getCommonFriendUsername())){
				sql.append(" AND _this.`common_friend_username` = ?");
				param.add(userCommonFriends.getCommonFriendUsername());
			}
			if(userCommonFriends.getCommonFriendNickname() != null && !"".equals(userCommonFriends.getCommonFriendNickname())){
				sql.append(" AND _this.`common_friend_nickname` = ?");
				param.add(userCommonFriends.getCommonFriendNickname());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserCommonFriends.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userCommonFriends
	 * @return Long
	 */
	@Override
	public Long count(UserCommonFriends userCommonFriends){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_common_friends  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userCommonFriends != null){
			if(userCommonFriends.getCommonFriendId() != null){
				sql.append(" AND _this.`common_friend_id` = ? ");
				param.add(userCommonFriends.getCommonFriendId());
			}
			if(userCommonFriends.getUseraId() != null){
				sql.append(" AND _this.`usera_id` = ? ");
				param.add(userCommonFriends.getUseraId());
			}
			if(userCommonFriends.getUserbId() != null){
				sql.append(" AND _this.`userb_id` = ? ");
				param.add(userCommonFriends.getUserbId());
			}
			if(userCommonFriends.getCommonFriendUserid() != null){
				sql.append(" AND _this.`common_friend_userid` = ? ");
				param.add(userCommonFriends.getCommonFriendUserid());
			}
			if(userCommonFriends.getCommonFriendUsername() != null && !"".equals(userCommonFriends.getCommonFriendUsername())){
				sql.append(" AND _this.`common_friend_username` = ? ");
				param.add(userCommonFriends.getCommonFriendUsername());
			}
			if(userCommonFriends.getCommonFriendNickname() != null && !"".equals(userCommonFriends.getCommonFriendNickname())){
				sql.append(" AND _this.`common_friend_nickname` = ? ");
				param.add(userCommonFriends.getCommonFriendNickname());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}