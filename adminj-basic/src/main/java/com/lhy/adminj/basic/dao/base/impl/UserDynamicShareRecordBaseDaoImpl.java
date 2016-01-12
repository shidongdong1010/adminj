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

import com.lhy.adminj.basic.dao.base.UserDynamicShareRecordBaseDao;
import com.lhy.adminj.basic.model.UserDynamicShareRecord;

/**
 * 用户动态分享记录表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicShareRecordBaseDaoImpl implements UserDynamicShareRecordBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`share_id`, _this.`dynamic_id`, _this.`user_id`, _this.`share_user_id`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`share_id`, _this.`dynamic_id`, _this.`user_id`, _this.`share_user_id`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM udc_user_dynamic_share_record _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO udc_user_dynamic_share_record(`share_id`, `dynamic_id`, `user_id`, `share_user_id`, `create_date`, `update_date`, `is_del`) VALUES (:share_id, :dynamic_id, :user_id, :share_user_id, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE udc_user_dynamic_share_record SET `share_id` = :share_id, `dynamic_id` = :dynamic_id, `user_id` = :user_id, `share_user_id` = :share_user_id, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `share_id` = :share_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM udc_user_dynamic_share_record WHERE `share_id` = ?";

	@Override
	public void save(UserDynamicShareRecord userDynamicShareRecord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicShareRecord);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userDynamicShareRecord.setShareId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserDynamicShareRecord userDynamicShareRecord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicShareRecord);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserDynamicShareRecord userDynamicShareRecord) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE udc_user_dynamic_share_record SET ");
		if(userDynamicShareRecord.getShareId() != null){
			sql.append(" share_id = ?, ");
			param.add(userDynamicShareRecord.getShareId());
		}
		if(userDynamicShareRecord.getDynamicId() != null){
			sql.append(" dynamic_id = ?, ");
			param.add(userDynamicShareRecord.getDynamicId());
		}
		if(userDynamicShareRecord.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userDynamicShareRecord.getUserId());
		}
		if(userDynamicShareRecord.getShareUserId() != null){
			sql.append(" share_user_id = ?, ");
			param.add(userDynamicShareRecord.getShareUserId());
		}
		if(userDynamicShareRecord.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userDynamicShareRecord.getCreateDate());
		}
		if(userDynamicShareRecord.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userDynamicShareRecord.getUpdateDate());
		}
		if(userDynamicShareRecord.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(userDynamicShareRecord.getIsDel());
		}
		sql.append(" WHERE share_id = ? ");
		param.add(userDynamicShareRecord.getShareId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicShareRecords
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserDynamicShareRecord> userDynamicShareRecords){
		Map<String, Object>[] maps = new Map[userDynamicShareRecords.size()];
		for(int i = 0; i < userDynamicShareRecords.size(); i++){
			UserDynamicShareRecord userDynamicShareRecord = userDynamicShareRecords.get(i);
			maps[i] = toMap(userDynamicShareRecord);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicShareRecord
	 * @return
	 */
	public Map<String, Object> toMap(UserDynamicShareRecord userDynamicShareRecord){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("share_id", userDynamicShareRecord.getShareId());
        paramMap.put("dynamic_id", userDynamicShareRecord.getDynamicId());
        paramMap.put("user_id", userDynamicShareRecord.getUserId());
        paramMap.put("share_user_id", userDynamicShareRecord.getShareUserId());
        paramMap.put("create_date", userDynamicShareRecord.getCreateDate());
        paramMap.put("update_date", userDynamicShareRecord.getUpdateDate());
        paramMap.put("is_del", userDynamicShareRecord.getIsDel());
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
	public void delete(Long shareId){
		jdbcTemplate.update(DELETE_SQL, shareId);
	}

	@Override
	public void batchSave(List<UserDynamicShareRecord> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserDynamicShareRecord> list){
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
	 * @param shareId 分享ID
	 * @return UserDynamicShareRecord
	 */
	@Override
	public UserDynamicShareRecord findById(Long shareId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`share_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserDynamicShareRecord.class), shareId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @return List
	 */
	@Override
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord){
		return this.find(userDynamicShareRecord, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, String[][] orders){
		return this.find(userDynamicShareRecord, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, Long offset, Long rows){
		return this.find(userDynamicShareRecord, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicShareRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicShareRecord> find(UserDynamicShareRecord userDynamicShareRecord, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userDynamicShareRecord != null){
			if(userDynamicShareRecord.getShareId() != null){
				sql.append(" AND _this.`share_id` = ?");
				param.add(userDynamicShareRecord.getShareId());
			}
			if(userDynamicShareRecord.getDynamicId() != null){
				sql.append(" AND _this.`dynamic_id` = ?");
				param.add(userDynamicShareRecord.getDynamicId());
			}
			if(userDynamicShareRecord.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userDynamicShareRecord.getUserId());
			}
			if(userDynamicShareRecord.getShareUserId() != null){
				sql.append(" AND _this.`share_user_id` = ?");
				param.add(userDynamicShareRecord.getShareUserId());
			}
			if(userDynamicShareRecord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userDynamicShareRecord.getCreateDate());
			}
			if(userDynamicShareRecord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userDynamicShareRecord.getUpdateDate());
			}
			if(userDynamicShareRecord.getIsDel() != null && !"".equals(userDynamicShareRecord.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userDynamicShareRecord.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserDynamicShareRecord.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userDynamicShareRecord
	 * @return Long
	 */
	@Override
	public Long count(UserDynamicShareRecord userDynamicShareRecord){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM udc_user_dynamic_share_record  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userDynamicShareRecord != null){
			if(userDynamicShareRecord.getShareId() != null){
				sql.append(" AND _this.`share_id` = ? ");
				param.add(userDynamicShareRecord.getShareId());
			}
			if(userDynamicShareRecord.getDynamicId() != null){
				sql.append(" AND _this.`dynamic_id` = ? ");
				param.add(userDynamicShareRecord.getDynamicId());
			}
			if(userDynamicShareRecord.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userDynamicShareRecord.getUserId());
			}
			if(userDynamicShareRecord.getShareUserId() != null){
				sql.append(" AND _this.`share_user_id` = ? ");
				param.add(userDynamicShareRecord.getShareUserId());
			}
			if(userDynamicShareRecord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userDynamicShareRecord.getCreateDate());
			}
			if(userDynamicShareRecord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userDynamicShareRecord.getUpdateDate());
			}
			if(userDynamicShareRecord.getIsDel() != null && !"".equals(userDynamicShareRecord.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userDynamicShareRecord.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}