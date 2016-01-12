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

import com.lhy.adminj.basic.dao.base.MyVoteDetailBaseDao;
import com.lhy.adminj.basic.model.MyVoteDetail;

/**
 * 我的跟投详情Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyVoteDetailBaseDaoImpl implements MyVoteDetailBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`vote_detail_id`, _this.`group_user_id`, _this.`vote_user_id`, _this.`group_id`, _this.`status`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`vote_detail_id`, _this.`group_user_id`, _this.`vote_user_id`, _this.`group_id`, _this.`status`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM tmc_my_vote_detail _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_my_vote_detail(`vote_detail_id`, `group_user_id`, `vote_user_id`, `group_id`, `status`, `create_date`, `update_date`, `is_del`) VALUES (:vote_detail_id, :group_user_id, :vote_user_id, :group_id, :status, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_my_vote_detail SET `vote_detail_id` = :vote_detail_id, `group_user_id` = :group_user_id, `vote_user_id` = :vote_user_id, `group_id` = :group_id, `status` = :status, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `vote_detail_id` = :vote_detail_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_my_vote_detail WHERE `vote_detail_id` = ?";

	@Override
	public void save(MyVoteDetail myVoteDetail) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myVoteDetail);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		myVoteDetail.setVoteDetailId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(MyVoteDetail myVoteDetail) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myVoteDetail);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(MyVoteDetail myVoteDetail) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_my_vote_detail SET ");
		if(myVoteDetail.getVoteDetailId() != null){
			sql.append(" vote_detail_id = ?, ");
			param.add(myVoteDetail.getVoteDetailId());
		}
		if(myVoteDetail.getGroupUserId() != null){
			sql.append(" group_user_id = ?, ");
			param.add(myVoteDetail.getGroupUserId());
		}
		if(myVoteDetail.getVoteUserId() != null){
			sql.append(" vote_user_id = ?, ");
			param.add(myVoteDetail.getVoteUserId());
		}
		if(myVoteDetail.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(myVoteDetail.getGroupId());
		}
		if(myVoteDetail.getStatus() != null){
			sql.append(" status = ?, ");
			param.add(myVoteDetail.getStatus());
		}
		if(myVoteDetail.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(myVoteDetail.getCreateDate());
		}
		if(myVoteDetail.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(myVoteDetail.getUpdateDate());
		}
		if(myVoteDetail.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(myVoteDetail.getIsDel());
		}
		sql.append(" WHERE vote_detail_id = ? ");
		param.add(myVoteDetail.getVoteDetailId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param myVoteDetails
	 * @return
	 */
	public Map<String, Object>[] toMap(List<MyVoteDetail> myVoteDetails){
		Map<String, Object>[] maps = new Map[myVoteDetails.size()];
		for(int i = 0; i < myVoteDetails.size(); i++){
			MyVoteDetail myVoteDetail = myVoteDetails.get(i);
			maps[i] = toMap(myVoteDetail);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param myVoteDetail
	 * @return
	 */
	public Map<String, Object> toMap(MyVoteDetail myVoteDetail){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("vote_detail_id", myVoteDetail.getVoteDetailId());
        paramMap.put("group_user_id", myVoteDetail.getGroupUserId());
        paramMap.put("vote_user_id", myVoteDetail.getVoteUserId());
        paramMap.put("group_id", myVoteDetail.getGroupId());
        paramMap.put("status", myVoteDetail.getStatus());
        paramMap.put("create_date", myVoteDetail.getCreateDate());
        paramMap.put("update_date", myVoteDetail.getUpdateDate());
        paramMap.put("is_del", myVoteDetail.getIsDel());
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
	public void delete(Long voteDetailId){
		jdbcTemplate.update(DELETE_SQL, voteDetailId);
	}

	@Override
	public void batchSave(List<MyVoteDetail> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<MyVoteDetail> list){
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
	 * @param voteDetailId 跟头详情ID
	 * @return MyVoteDetail
	 */
	@Override
	public MyVoteDetail findById(Long voteDetailId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`vote_detail_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(MyVoteDetail.class), voteDetailId);
	}

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @return List
	 */
	@Override
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail){
		return this.find(myVoteDetail, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, String[][] orders){
		return this.find(myVoteDetail, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myVoteDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, Long offset, Long rows){
		return this.find(myVoteDetail, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myVoteDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyVoteDetail> find(MyVoteDetail myVoteDetail, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(myVoteDetail != null){
			if(myVoteDetail.getVoteDetailId() != null){
				sql.append(" AND _this.`vote_detail_id` = ?");
				param.add(myVoteDetail.getVoteDetailId());
			}
			if(myVoteDetail.getGroupUserId() != null){
				sql.append(" AND _this.`group_user_id` = ?");
				param.add(myVoteDetail.getGroupUserId());
			}
			if(myVoteDetail.getVoteUserId() != null){
				sql.append(" AND _this.`vote_user_id` = ?");
				param.add(myVoteDetail.getVoteUserId());
			}
			if(myVoteDetail.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(myVoteDetail.getGroupId());
			}
			if(myVoteDetail.getStatus() != null && !"".equals(myVoteDetail.getStatus())){
				sql.append(" AND _this.`status` = ?");
				param.add(myVoteDetail.getStatus());
			}
			if(myVoteDetail.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(myVoteDetail.getCreateDate());
			}
			if(myVoteDetail.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(myVoteDetail.getUpdateDate());
			}
			if(myVoteDetail.getIsDel() != null && !"".equals(myVoteDetail.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(myVoteDetail.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(MyVoteDetail.class));
	}


	/**
	 * 根据对象查询条数
	 * @param myVoteDetail
	 * @return Long
	 */
	@Override
	public Long count(MyVoteDetail myVoteDetail){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_my_vote_detail  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(myVoteDetail != null){
			if(myVoteDetail.getVoteDetailId() != null){
				sql.append(" AND _this.`vote_detail_id` = ? ");
				param.add(myVoteDetail.getVoteDetailId());
			}
			if(myVoteDetail.getGroupUserId() != null){
				sql.append(" AND _this.`group_user_id` = ? ");
				param.add(myVoteDetail.getGroupUserId());
			}
			if(myVoteDetail.getVoteUserId() != null){
				sql.append(" AND _this.`vote_user_id` = ? ");
				param.add(myVoteDetail.getVoteUserId());
			}
			if(myVoteDetail.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(myVoteDetail.getGroupId());
			}
			if(myVoteDetail.getStatus() != null && !"".equals(myVoteDetail.getStatus())){
				sql.append(" AND _this.`status` = ? ");
				param.add(myVoteDetail.getStatus());
			}
			if(myVoteDetail.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(myVoteDetail.getCreateDate());
			}
			if(myVoteDetail.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(myVoteDetail.getUpdateDate());
			}
			if(myVoteDetail.getIsDel() != null && !"".equals(myVoteDetail.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(myVoteDetail.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}