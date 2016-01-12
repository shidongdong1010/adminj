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

import com.lhy.adminj.basic.dao.base.UserMeetRecordBaseDao;
import com.lhy.adminj.basic.model.UserMeetRecord;

/**
 * 用户打招呼表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserMeetRecordBaseDaoImpl implements UserMeetRecordBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`meet_id`, _this.`user_id`, _this.`friend_id`, _this.`familiar_sum`, _this.`say`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`meet_id`, _this.`user_id`, _this.`friend_id`, _this.`familiar_sum`, _this.`say`, _this.`create_date`, _this.`update_date` FROM umc_user_meet_record _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_meet_record(`meet_id`, `user_id`, `friend_id`, `familiar_sum`, `say`, `create_date`, `update_date`) VALUES (:meet_id, :user_id, :friend_id, :familiar_sum, :say, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_meet_record SET `meet_id` = :meet_id, `user_id` = :user_id, `friend_id` = :friend_id, `familiar_sum` = :familiar_sum, `say` = :say, `create_date` = :create_date, `update_date` = :update_date WHERE `meet_id` = :meet_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_meet_record WHERE `meet_id` = ?";

	@Override
	public void save(UserMeetRecord userMeetRecord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userMeetRecord);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userMeetRecord.setMeetId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserMeetRecord userMeetRecord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userMeetRecord);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserMeetRecord userMeetRecord) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_meet_record SET ");
		if(userMeetRecord.getMeetId() != null){
			sql.append(" meet_id = ?, ");
			param.add(userMeetRecord.getMeetId());
		}
		if(userMeetRecord.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userMeetRecord.getUserId());
		}
		if(userMeetRecord.getFriendId() != null){
			sql.append(" friend_id = ?, ");
			param.add(userMeetRecord.getFriendId());
		}
		if(userMeetRecord.getFamiliarSum() != null){
			sql.append(" familiar_sum = ?, ");
			param.add(userMeetRecord.getFamiliarSum());
		}
		if(userMeetRecord.getSay() != null){
			sql.append(" say = ?, ");
			param.add(userMeetRecord.getSay());
		}
		if(userMeetRecord.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userMeetRecord.getCreateDate());
		}
		if(userMeetRecord.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(userMeetRecord.getUpdateDate());
		}
		sql.append(" WHERE meet_id = ? ");
		param.add(userMeetRecord.getMeetId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userMeetRecords
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserMeetRecord> userMeetRecords){
		Map<String, Object>[] maps = new Map[userMeetRecords.size()];
		for(int i = 0; i < userMeetRecords.size(); i++){
			UserMeetRecord userMeetRecord = userMeetRecords.get(i);
			maps[i] = toMap(userMeetRecord);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userMeetRecord
	 * @return
	 */
	public Map<String, Object> toMap(UserMeetRecord userMeetRecord){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("meet_id", userMeetRecord.getMeetId());
        paramMap.put("user_id", userMeetRecord.getUserId());
        paramMap.put("friend_id", userMeetRecord.getFriendId());
        paramMap.put("familiar_sum", userMeetRecord.getFamiliarSum());
        paramMap.put("say", userMeetRecord.getSay());
        paramMap.put("create_date", userMeetRecord.getCreateDate());
        paramMap.put("update_date", userMeetRecord.getUpdateDate());
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
	public void delete(Long meetId){
		jdbcTemplate.update(DELETE_SQL, meetId);
	}

	@Override
	public void batchSave(List<UserMeetRecord> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserMeetRecord> list){
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
	 * @param meetId ID
	 * @return UserMeetRecord
	 */
	@Override
	public UserMeetRecord findById(Long meetId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`meet_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserMeetRecord.class), meetId);
	}

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @return List
	 */
	@Override
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord){
		return this.find(userMeetRecord, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, String[][] orders){
		return this.find(userMeetRecord, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userMeetRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, Long offset, Long rows){
		return this.find(userMeetRecord, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userMeetRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserMeetRecord> find(UserMeetRecord userMeetRecord, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userMeetRecord != null){
			if(userMeetRecord.getMeetId() != null){
				sql.append(" AND _this.`meet_id` = ?");
				param.add(userMeetRecord.getMeetId());
			}
			if(userMeetRecord.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userMeetRecord.getUserId());
			}
			if(userMeetRecord.getFriendId() != null){
				sql.append(" AND _this.`friend_id` = ?");
				param.add(userMeetRecord.getFriendId());
			}
			if(userMeetRecord.getSay() != null && !"".equals(userMeetRecord.getSay())){
				sql.append(" AND _this.`say` = ?");
				param.add(userMeetRecord.getSay());
			}
			if(userMeetRecord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userMeetRecord.getCreateDate());
			}
			if(userMeetRecord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userMeetRecord.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserMeetRecord.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userMeetRecord
	 * @return Long
	 */
	@Override
	public Long count(UserMeetRecord userMeetRecord){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_meet_record  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userMeetRecord != null){
			if(userMeetRecord.getMeetId() != null){
				sql.append(" AND _this.`meet_id` = ? ");
				param.add(userMeetRecord.getMeetId());
			}
			if(userMeetRecord.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userMeetRecord.getUserId());
			}
			if(userMeetRecord.getFriendId() != null){
				sql.append(" AND _this.`friend_id` = ? ");
				param.add(userMeetRecord.getFriendId());
			}
			if(userMeetRecord.getSay() != null && !"".equals(userMeetRecord.getSay())){
				sql.append(" AND _this.`say` = ? ");
				param.add(userMeetRecord.getSay());
			}
			if(userMeetRecord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userMeetRecord.getCreateDate());
			}
			if(userMeetRecord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userMeetRecord.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}