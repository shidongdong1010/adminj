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

import com.lhy.adminj.basic.dao.base.UserDynamicForwardRecordBaseDao;
import com.lhy.adminj.basic.model.UserDynamicForwardRecord;

/**
 * 用户动态转发记录表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicForwardRecordBaseDaoImpl implements UserDynamicForwardRecordBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`forward_id`, _this.`dynamic_id`, _this.`user_id`, _this.`forward_user_id`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`forward_id`, _this.`dynamic_id`, _this.`user_id`, _this.`forward_user_id`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM udc_user_dynamic_forward_record _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO udc_user_dynamic_forward_record(`forward_id`, `dynamic_id`, `user_id`, `forward_user_id`, `create_date`, `update_date`, `is_del`) VALUES (:forward_id, :dynamic_id, :user_id, :forward_user_id, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE udc_user_dynamic_forward_record SET `forward_id` = :forward_id, `dynamic_id` = :dynamic_id, `user_id` = :user_id, `forward_user_id` = :forward_user_id, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `forward_id` = :forward_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM udc_user_dynamic_forward_record WHERE `forward_id` = ?";

	@Override
	public void save(UserDynamicForwardRecord userDynamicForwardRecord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicForwardRecord);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userDynamicForwardRecord.setForwardId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserDynamicForwardRecord userDynamicForwardRecord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicForwardRecord);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserDynamicForwardRecord userDynamicForwardRecord) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE udc_user_dynamic_forward_record SET ");
		if(userDynamicForwardRecord.getForwardId() != null){
			sql.append(" forward_id = ?, ");
			param.add(userDynamicForwardRecord.getForwardId());
		}
		if(userDynamicForwardRecord.getDynamicId() != null){
			sql.append(" dynamic_id = ?, ");
			param.add(userDynamicForwardRecord.getDynamicId());
		}
		if(userDynamicForwardRecord.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userDynamicForwardRecord.getUserId());
		}
		if(userDynamicForwardRecord.getForwardUserId() != null){
			sql.append(" forward_user_id = ?, ");
			param.add(userDynamicForwardRecord.getForwardUserId());
		}
		if(userDynamicForwardRecord.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userDynamicForwardRecord.getCreateDate());
		}
		if(userDynamicForwardRecord.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userDynamicForwardRecord.getUpdateDate());
		}
		if(userDynamicForwardRecord.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(userDynamicForwardRecord.getIsDel());
		}
		sql.append(" WHERE forward_id = ? ");
		param.add(userDynamicForwardRecord.getForwardId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicForwardRecords
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserDynamicForwardRecord> userDynamicForwardRecords){
		Map<String, Object>[] maps = new Map[userDynamicForwardRecords.size()];
		for(int i = 0; i < userDynamicForwardRecords.size(); i++){
			UserDynamicForwardRecord userDynamicForwardRecord = userDynamicForwardRecords.get(i);
			maps[i] = toMap(userDynamicForwardRecord);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicForwardRecord
	 * @return
	 */
	public Map<String, Object> toMap(UserDynamicForwardRecord userDynamicForwardRecord){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("forward_id", userDynamicForwardRecord.getForwardId());
        paramMap.put("dynamic_id", userDynamicForwardRecord.getDynamicId());
        paramMap.put("user_id", userDynamicForwardRecord.getUserId());
        paramMap.put("forward_user_id", userDynamicForwardRecord.getForwardUserId());
        paramMap.put("create_date", userDynamicForwardRecord.getCreateDate());
        paramMap.put("update_date", userDynamicForwardRecord.getUpdateDate());
        paramMap.put("is_del", userDynamicForwardRecord.getIsDel());
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
	public void delete(Long forwardId){
		jdbcTemplate.update(DELETE_SQL, forwardId);
	}

	@Override
	public void batchSave(List<UserDynamicForwardRecord> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserDynamicForwardRecord> list){
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
	 * @param forwardId 转发ID
	 * @return UserDynamicForwardRecord
	 */
	@Override
	public UserDynamicForwardRecord findById(Long forwardId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`forward_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserDynamicForwardRecord.class), forwardId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @return List
	 */
	@Override
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord){
		return this.find(userDynamicForwardRecord, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, String[][] orders){
		return this.find(userDynamicForwardRecord, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, Long offset, Long rows){
		return this.find(userDynamicForwardRecord, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicForwardRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicForwardRecord> find(UserDynamicForwardRecord userDynamicForwardRecord, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userDynamicForwardRecord != null){
			if(userDynamicForwardRecord.getForwardId() != null){
				sql.append(" AND _this.`forward_id` = ?");
				param.add(userDynamicForwardRecord.getForwardId());
			}
			if(userDynamicForwardRecord.getDynamicId() != null){
				sql.append(" AND _this.`dynamic_id` = ?");
				param.add(userDynamicForwardRecord.getDynamicId());
			}
			if(userDynamicForwardRecord.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userDynamicForwardRecord.getUserId());
			}
			if(userDynamicForwardRecord.getForwardUserId() != null){
				sql.append(" AND _this.`forward_user_id` = ?");
				param.add(userDynamicForwardRecord.getForwardUserId());
			}
			if(userDynamicForwardRecord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userDynamicForwardRecord.getCreateDate());
			}
			if(userDynamicForwardRecord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userDynamicForwardRecord.getUpdateDate());
			}
			if(userDynamicForwardRecord.getIsDel() != null && !"".equals(userDynamicForwardRecord.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userDynamicForwardRecord.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserDynamicForwardRecord.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userDynamicForwardRecord
	 * @return Long
	 */
	@Override
	public Long count(UserDynamicForwardRecord userDynamicForwardRecord){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM udc_user_dynamic_forward_record  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userDynamicForwardRecord != null){
			if(userDynamicForwardRecord.getForwardId() != null){
				sql.append(" AND _this.`forward_id` = ? ");
				param.add(userDynamicForwardRecord.getForwardId());
			}
			if(userDynamicForwardRecord.getDynamicId() != null){
				sql.append(" AND _this.`dynamic_id` = ? ");
				param.add(userDynamicForwardRecord.getDynamicId());
			}
			if(userDynamicForwardRecord.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userDynamicForwardRecord.getUserId());
			}
			if(userDynamicForwardRecord.getForwardUserId() != null){
				sql.append(" AND _this.`forward_user_id` = ? ");
				param.add(userDynamicForwardRecord.getForwardUserId());
			}
			if(userDynamicForwardRecord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userDynamicForwardRecord.getCreateDate());
			}
			if(userDynamicForwardRecord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userDynamicForwardRecord.getUpdateDate());
			}
			if(userDynamicForwardRecord.getIsDel() != null && !"".equals(userDynamicForwardRecord.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userDynamicForwardRecord.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}