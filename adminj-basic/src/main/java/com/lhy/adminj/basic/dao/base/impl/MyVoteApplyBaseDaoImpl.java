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

import com.lhy.adminj.basic.dao.base.MyVoteApplyBaseDao;
import com.lhy.adminj.basic.model.MyVoteApply;

/**
 * 我的跟投申请Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyVoteApplyBaseDaoImpl implements MyVoteApplyBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`apply_id`, _this.`audit_user_id`, _this.`apply_user_id`, _this.`status`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`group_id`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`apply_id`, _this.`audit_user_id`, _this.`apply_user_id`, _this.`status`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`group_id` FROM umc_my_vote_apply _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_my_vote_apply(`apply_id`, `audit_user_id`, `apply_user_id`, `status`, `create_date`, `update_date`, `is_del`, `group_id`) VALUES (:apply_id, :audit_user_id, :apply_user_id, :status, :create_date, :update_date, :is_del, :group_id)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_my_vote_apply SET `apply_id` = :apply_id, `audit_user_id` = :audit_user_id, `apply_user_id` = :apply_user_id, `status` = :status, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del, `group_id` = :group_id WHERE `apply_id` = :apply_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_my_vote_apply WHERE `apply_id` = ?";

	@Override
	public void save(MyVoteApply myVoteApply) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myVoteApply);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		myVoteApply.setApplyId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(MyVoteApply myVoteApply) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myVoteApply);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(MyVoteApply myVoteApply) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_my_vote_apply SET ");
		if(myVoteApply.getApplyId() != null){
			sql.append(" apply_id = ?, ");
			param.add(myVoteApply.getApplyId());
		}
		if(myVoteApply.getAuditUserId() != null){
			sql.append(" audit_user_id = ?, ");
			param.add(myVoteApply.getAuditUserId());
		}
		if(myVoteApply.getApplyUserId() != null){
			sql.append(" apply_user_id = ?, ");
			param.add(myVoteApply.getApplyUserId());
		}
		if(myVoteApply.getStatus() != null){
			sql.append(" status = ?, ");
			param.add(myVoteApply.getStatus());
		}
		if(myVoteApply.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(myVoteApply.getCreateDate());
		}
		if(myVoteApply.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(myVoteApply.getUpdateDate());
		}
		if(myVoteApply.getIsDel() != null){
			sql.append(" is_del = ?, ");
			param.add(myVoteApply.getIsDel());
		}
		if(myVoteApply.getGroupId() != null){
			sql.append(" group_id = ? ");
			param.add(myVoteApply.getGroupId());
		}
		sql.append(" WHERE apply_id = ? ");
		param.add(myVoteApply.getApplyId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param myVoteApplys
	 * @return
	 */
	public Map<String, Object>[] toMap(List<MyVoteApply> myVoteApplys){
		Map<String, Object>[] maps = new Map[myVoteApplys.size()];
		for(int i = 0; i < myVoteApplys.size(); i++){
			MyVoteApply myVoteApply = myVoteApplys.get(i);
			maps[i] = toMap(myVoteApply);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param myVoteApply
	 * @return
	 */
	public Map<String, Object> toMap(MyVoteApply myVoteApply){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("apply_id", myVoteApply.getApplyId());
        paramMap.put("audit_user_id", myVoteApply.getAuditUserId());
        paramMap.put("apply_user_id", myVoteApply.getApplyUserId());
        paramMap.put("status", myVoteApply.getStatus());
        paramMap.put("create_date", myVoteApply.getCreateDate());
        paramMap.put("update_date", myVoteApply.getUpdateDate());
        paramMap.put("is_del", myVoteApply.getIsDel());
        paramMap.put("group_id", myVoteApply.getGroupId());
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
	public void delete(Long applyId){
		jdbcTemplate.update(DELETE_SQL, applyId);
	}

	@Override
	public void batchSave(List<MyVoteApply> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<MyVoteApply> list){
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
	 * @param applyId 申请ID
	 * @return MyVoteApply
	 */
	@Override
	public MyVoteApply findById(Long applyId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`apply_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(MyVoteApply.class), applyId);
	}

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @return List
	 */
	@Override
	public List<MyVoteApply> find(MyVoteApply myVoteApply){
		return this.find(myVoteApply, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<MyVoteApply> find(MyVoteApply myVoteApply, String[][] orders){
		return this.find(myVoteApply, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myVoteApply
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyVoteApply> find(MyVoteApply myVoteApply, Long offset, Long rows){
		return this.find(myVoteApply, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myVoteApply
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyVoteApply> find(MyVoteApply myVoteApply, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(myVoteApply != null){
			if(myVoteApply.getApplyId() != null){
				sql.append(" AND _this.`apply_id` = ?");
				param.add(myVoteApply.getApplyId());
			}
			if(myVoteApply.getAuditUserId() != null){
				sql.append(" AND _this.`audit_user_id` = ?");
				param.add(myVoteApply.getAuditUserId());
			}
			if(myVoteApply.getApplyUserId() != null){
				sql.append(" AND _this.`apply_user_id` = ?");
				param.add(myVoteApply.getApplyUserId());
			}
			if(myVoteApply.getStatus() != null && !"".equals(myVoteApply.getStatus())){
				sql.append(" AND _this.`status` = ?");
				param.add(myVoteApply.getStatus());
			}
			if(myVoteApply.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(myVoteApply.getCreateDate());
			}
			if(myVoteApply.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(myVoteApply.getUpdateDate());
			}
			if(myVoteApply.getIsDel() != null && !"".equals(myVoteApply.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(myVoteApply.getIsDel());
			}
			if(myVoteApply.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(myVoteApply.getGroupId());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(MyVoteApply.class));
	}


	/**
	 * 根据对象查询条数
	 * @param myVoteApply
	 * @return Long
	 */
	@Override
	public Long count(MyVoteApply myVoteApply){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_my_vote_apply  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(myVoteApply != null){
			if(myVoteApply.getApplyId() != null){
				sql.append(" AND _this.`apply_id` = ? ");
				param.add(myVoteApply.getApplyId());
			}
			if(myVoteApply.getAuditUserId() != null){
				sql.append(" AND _this.`audit_user_id` = ? ");
				param.add(myVoteApply.getAuditUserId());
			}
			if(myVoteApply.getApplyUserId() != null){
				sql.append(" AND _this.`apply_user_id` = ? ");
				param.add(myVoteApply.getApplyUserId());
			}
			if(myVoteApply.getStatus() != null && !"".equals(myVoteApply.getStatus())){
				sql.append(" AND _this.`status` = ? ");
				param.add(myVoteApply.getStatus());
			}
			if(myVoteApply.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(myVoteApply.getCreateDate());
			}
			if(myVoteApply.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(myVoteApply.getUpdateDate());
			}
			if(myVoteApply.getIsDel() != null && !"".equals(myVoteApply.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(myVoteApply.getIsDel());
			}
			if(myVoteApply.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(myVoteApply.getGroupId());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}