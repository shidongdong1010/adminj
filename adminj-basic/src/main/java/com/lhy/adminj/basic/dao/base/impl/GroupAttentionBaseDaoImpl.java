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

import com.lhy.adminj.basic.dao.base.GroupAttentionBaseDao;
import com.lhy.adminj.basic.model.GroupAttention;

/**
 * 我关注的组合Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class GroupAttentionBaseDaoImpl implements GroupAttentionBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`attention_id`, _this.`user_id`, _this.`attention_user_id`, _this.`attention_group_id`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`attention_id`, _this.`user_id`, _this.`attention_user_id`, _this.`attention_group_id`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM tmc_group_attention _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_group_attention(`attention_id`, `user_id`, `attention_user_id`, `attention_group_id`, `create_date`, `update_date`, `is_del`) VALUES (:attention_id, :user_id, :attention_user_id, :attention_group_id, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_group_attention SET `attention_id` = :attention_id, `user_id` = :user_id, `attention_user_id` = :attention_user_id, `attention_group_id` = :attention_group_id, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `attention_id` = :attention_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_group_attention WHERE `attention_id` = ?";

	@Override
	public void save(GroupAttention groupAttention) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(groupAttention);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		groupAttention.setAttentionId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(GroupAttention groupAttention) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(groupAttention);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(GroupAttention groupAttention) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_group_attention SET ");
		if(groupAttention.getAttentionId() != null){
			sql.append(" attention_id = ?, ");
			param.add(groupAttention.getAttentionId());
		}
		if(groupAttention.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(groupAttention.getUserId());
		}
		if(groupAttention.getAttentionUserId() != null){
			sql.append(" attention_user_id = ?, ");
			param.add(groupAttention.getAttentionUserId());
		}
		if(groupAttention.getAttentionGroupId() != null){
			sql.append(" attention_group_id = ?, ");
			param.add(groupAttention.getAttentionGroupId());
		}
		if(groupAttention.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(groupAttention.getCreateDate());
		}
		if(groupAttention.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(groupAttention.getUpdateDate());
		}
		if(groupAttention.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(groupAttention.getIsDel());
		}
		sql.append(" WHERE attention_id = ? ");
		param.add(groupAttention.getAttentionId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param groupAttentions
	 * @return
	 */
	public Map<String, Object>[] toMap(List<GroupAttention> groupAttentions){
		Map<String, Object>[] maps = new Map[groupAttentions.size()];
		for(int i = 0; i < groupAttentions.size(); i++){
			GroupAttention groupAttention = groupAttentions.get(i);
			maps[i] = toMap(groupAttention);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param groupAttention
	 * @return
	 */
	public Map<String, Object> toMap(GroupAttention groupAttention){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("attention_id", groupAttention.getAttentionId());
        paramMap.put("user_id", groupAttention.getUserId());
        paramMap.put("attention_user_id", groupAttention.getAttentionUserId());
        paramMap.put("attention_group_id", groupAttention.getAttentionGroupId());
        paramMap.put("create_date", groupAttention.getCreateDate());
        paramMap.put("update_date", groupAttention.getUpdateDate());
        paramMap.put("is_del", groupAttention.getIsDel());
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
	public void delete(Long attentionId){
		jdbcTemplate.update(DELETE_SQL, attentionId);
	}

	@Override
	public void batchSave(List<GroupAttention> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<GroupAttention> list){
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
	 * @param attentionId 关注ID
	 * @return GroupAttention
	 */
	@Override
	public GroupAttention findById(Long attentionId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`attention_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(GroupAttention.class), attentionId);
	}

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @return List
	 */
	@Override
	public List<GroupAttention> find(GroupAttention groupAttention){
		return this.find(groupAttention, null, null);
	}

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<GroupAttention> find(GroupAttention groupAttention, String[][] orders){
		return this.find(groupAttention, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param groupAttention
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<GroupAttention> find(GroupAttention groupAttention, Long offset, Long rows){
		return this.find(groupAttention, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param groupAttention
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<GroupAttention> find(GroupAttention groupAttention, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(groupAttention != null){
			if(groupAttention.getAttentionId() != null){
				sql.append(" AND _this.`attention_id` = ?");
				param.add(groupAttention.getAttentionId());
			}
			if(groupAttention.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(groupAttention.getUserId());
			}
			if(groupAttention.getAttentionUserId() != null){
				sql.append(" AND _this.`attention_user_id` = ?");
				param.add(groupAttention.getAttentionUserId());
			}
			if(groupAttention.getAttentionGroupId() != null){
				sql.append(" AND _this.`attention_group_id` = ?");
				param.add(groupAttention.getAttentionGroupId());
			}
			if(groupAttention.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(groupAttention.getCreateDate());
			}
			if(groupAttention.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(groupAttention.getUpdateDate());
			}
			if(groupAttention.getIsDel() != null && !"".equals(groupAttention.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(groupAttention.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(GroupAttention.class));
	}


	/**
	 * 根据对象查询条数
	 * @param groupAttention
	 * @return Long
	 */
	@Override
	public Long count(GroupAttention groupAttention){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_group_attention  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(groupAttention != null){
			if(groupAttention.getAttentionId() != null){
				sql.append(" AND _this.`attention_id` = ? ");
				param.add(groupAttention.getAttentionId());
			}
			if(groupAttention.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(groupAttention.getUserId());
			}
			if(groupAttention.getAttentionUserId() != null){
				sql.append(" AND _this.`attention_user_id` = ? ");
				param.add(groupAttention.getAttentionUserId());
			}
			if(groupAttention.getAttentionGroupId() != null){
				sql.append(" AND _this.`attention_group_id` = ? ");
				param.add(groupAttention.getAttentionGroupId());
			}
			if(groupAttention.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(groupAttention.getCreateDate());
			}
			if(groupAttention.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(groupAttention.getUpdateDate());
			}
			if(groupAttention.getIsDel() != null && !"".equals(groupAttention.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(groupAttention.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}