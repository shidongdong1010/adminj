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

import com.lhy.adminj.basic.dao.base.UserDynamicCommentPraiseBaseDao;
import com.lhy.adminj.basic.model.UserDynamicCommentPraise;

/**
 * 用户动态点赞记录表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicCommentPraiseBaseDaoImpl implements UserDynamicCommentPraiseBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`praise_id`, _this.`comment_id`, _this.`user_id`, _this.`praise_user_id`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`praise_id`, _this.`comment_id`, _this.`user_id`, _this.`praise_user_id`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM udc_user_dynamic_comment_praise _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO udc_user_dynamic_comment_praise(`praise_id`, `comment_id`, `user_id`, `praise_user_id`, `create_date`, `update_date`, `is_del`) VALUES (:praise_id, :comment_id, :user_id, :praise_user_id, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE udc_user_dynamic_comment_praise SET `praise_id` = :praise_id, `comment_id` = :comment_id, `user_id` = :user_id, `praise_user_id` = :praise_user_id, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `praise_id` = :praise_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM udc_user_dynamic_comment_praise WHERE `praise_id` = ?";

	@Override
	public void save(UserDynamicCommentPraise userDynamicCommentPraise) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicCommentPraise);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userDynamicCommentPraise.setPraiseId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserDynamicCommentPraise userDynamicCommentPraise) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicCommentPraise);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserDynamicCommentPraise userDynamicCommentPraise) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE udc_user_dynamic_comment_praise SET ");
		if(userDynamicCommentPraise.getPraiseId() != null){
			sql.append(" praise_id = ?, ");
			param.add(userDynamicCommentPraise.getPraiseId());
		}
		if(userDynamicCommentPraise.getCommentId() != null){
			sql.append(" comment_id = ?, ");
			param.add(userDynamicCommentPraise.getCommentId());
		}
		if(userDynamicCommentPraise.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userDynamicCommentPraise.getUserId());
		}
		if(userDynamicCommentPraise.getPraiseUserId() != null){
			sql.append(" praise_user_id = ?, ");
			param.add(userDynamicCommentPraise.getPraiseUserId());
		}
		if(userDynamicCommentPraise.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userDynamicCommentPraise.getCreateDate());
		}
		if(userDynamicCommentPraise.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userDynamicCommentPraise.getUpdateDate());
		}
		if(userDynamicCommentPraise.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(userDynamicCommentPraise.getIsDel());
		}
		sql.append(" WHERE praise_id = ? ");
		param.add(userDynamicCommentPraise.getPraiseId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicCommentPraises
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserDynamicCommentPraise> userDynamicCommentPraises){
		Map<String, Object>[] maps = new Map[userDynamicCommentPraises.size()];
		for(int i = 0; i < userDynamicCommentPraises.size(); i++){
			UserDynamicCommentPraise userDynamicCommentPraise = userDynamicCommentPraises.get(i);
			maps[i] = toMap(userDynamicCommentPraise);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicCommentPraise
	 * @return
	 */
	public Map<String, Object> toMap(UserDynamicCommentPraise userDynamicCommentPraise){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("praise_id", userDynamicCommentPraise.getPraiseId());
        paramMap.put("comment_id", userDynamicCommentPraise.getCommentId());
        paramMap.put("user_id", userDynamicCommentPraise.getUserId());
        paramMap.put("praise_user_id", userDynamicCommentPraise.getPraiseUserId());
        paramMap.put("create_date", userDynamicCommentPraise.getCreateDate());
        paramMap.put("update_date", userDynamicCommentPraise.getUpdateDate());
        paramMap.put("is_del", userDynamicCommentPraise.getIsDel());
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
	public void delete(Long praiseId){
		jdbcTemplate.update(DELETE_SQL, praiseId);
	}

	@Override
	public void batchSave(List<UserDynamicCommentPraise> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserDynamicCommentPraise> list){
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
	 * @param praiseId 点赞ID
	 * @return UserDynamicCommentPraise
	 */
	@Override
	public UserDynamicCommentPraise findById(Long praiseId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`praise_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserDynamicCommentPraise.class), praiseId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @return List
	 */
	@Override
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise){
		return this.find(userDynamicCommentPraise, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, String[][] orders){
		return this.find(userDynamicCommentPraise, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, Long offset, Long rows){
		return this.find(userDynamicCommentPraise, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicCommentPraise
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicCommentPraise> find(UserDynamicCommentPraise userDynamicCommentPraise, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userDynamicCommentPraise != null){
			if(userDynamicCommentPraise.getPraiseId() != null){
				sql.append(" AND _this.`praise_id` = ?");
				param.add(userDynamicCommentPraise.getPraiseId());
			}
			if(userDynamicCommentPraise.getCommentId() != null){
				sql.append(" AND _this.`comment_id` = ?");
				param.add(userDynamicCommentPraise.getCommentId());
			}
			if(userDynamicCommentPraise.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userDynamicCommentPraise.getUserId());
			}
			if(userDynamicCommentPraise.getPraiseUserId() != null){
				sql.append(" AND _this.`praise_user_id` = ?");
				param.add(userDynamicCommentPraise.getPraiseUserId());
			}
			if(userDynamicCommentPraise.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userDynamicCommentPraise.getCreateDate());
			}
			if(userDynamicCommentPraise.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userDynamicCommentPraise.getUpdateDate());
			}
			if(userDynamicCommentPraise.getIsDel() != null && !"".equals(userDynamicCommentPraise.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userDynamicCommentPraise.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserDynamicCommentPraise.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userDynamicCommentPraise
	 * @return Long
	 */
	@Override
	public Long count(UserDynamicCommentPraise userDynamicCommentPraise){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM udc_user_dynamic_comment_praise  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userDynamicCommentPraise != null){
			if(userDynamicCommentPraise.getPraiseId() != null){
				sql.append(" AND _this.`praise_id` = ? ");
				param.add(userDynamicCommentPraise.getPraiseId());
			}
			if(userDynamicCommentPraise.getCommentId() != null){
				sql.append(" AND _this.`comment_id` = ? ");
				param.add(userDynamicCommentPraise.getCommentId());
			}
			if(userDynamicCommentPraise.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userDynamicCommentPraise.getUserId());
			}
			if(userDynamicCommentPraise.getPraiseUserId() != null){
				sql.append(" AND _this.`praise_user_id` = ? ");
				param.add(userDynamicCommentPraise.getPraiseUserId());
			}
			if(userDynamicCommentPraise.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userDynamicCommentPraise.getCreateDate());
			}
			if(userDynamicCommentPraise.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userDynamicCommentPraise.getUpdateDate());
			}
			if(userDynamicCommentPraise.getIsDel() != null && !"".equals(userDynamicCommentPraise.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userDynamicCommentPraise.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}