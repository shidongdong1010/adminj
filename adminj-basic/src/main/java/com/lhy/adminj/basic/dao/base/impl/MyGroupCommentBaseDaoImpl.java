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

import com.lhy.adminj.basic.dao.base.MyGroupCommentBaseDao;
import com.lhy.adminj.basic.model.MyGroupComment;

/**
 * 我的组合评论Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupCommentBaseDaoImpl implements MyGroupCommentBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`comment_id`, _this.`parent_comment_id`, _this.`comment_user_id`, _this.`group_id`, _this.`reviewer_user_id`, _this.`forward_num`, _this.`comment_num`, _this.`comment`, _this.`create_date`, _this.`update_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`comment_id`, _this.`parent_comment_id`, _this.`comment_user_id`, _this.`group_id`, _this.`reviewer_user_id`, _this.`forward_num`, _this.`comment_num`, _this.`comment`, _this.`create_date`, _this.`update_date` FROM tmc_my_group_comment _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_my_group_comment(`comment_id`, `parent_comment_id`, `comment_user_id`, `group_id`, `reviewer_user_id`, `forward_num`, `comment_num`, `comment`, `create_date`, `update_date`) VALUES (:comment_id, :parent_comment_id, :comment_user_id, :group_id, :reviewer_user_id, :forward_num, :comment_num, :comment, :create_date, :update_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_my_group_comment SET `comment_id` = :comment_id, `parent_comment_id` = :parent_comment_id, `comment_user_id` = :comment_user_id, `group_id` = :group_id, `reviewer_user_id` = :reviewer_user_id, `forward_num` = :forward_num, `comment_num` = :comment_num, `comment` = :comment, `create_date` = :create_date, `update_date` = :update_date WHERE `comment_id` = :comment_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_my_group_comment WHERE `comment_id` = ?";

	@Override
	public void save(MyGroupComment myGroupComment) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroupComment);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		myGroupComment.setCommentId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(MyGroupComment myGroupComment) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroupComment);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(MyGroupComment myGroupComment) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_my_group_comment SET ");
		if(myGroupComment.getCommentId() != null){
			sql.append(" comment_id = ?, ");
			param.add(myGroupComment.getCommentId());
		}
		if(myGroupComment.getParentCommentId() != null){
			sql.append(" parent_comment_id = ?, ");
			param.add(myGroupComment.getParentCommentId());
		}
		if(myGroupComment.getCommentUserId() != null){
			sql.append(" comment_user_id = ?, ");
			param.add(myGroupComment.getCommentUserId());
		}
		if(myGroupComment.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(myGroupComment.getGroupId());
		}
		if(myGroupComment.getReviewerUserId() != null){
			sql.append(" reviewer_user_id = ?, ");
			param.add(myGroupComment.getReviewerUserId());
		}
		if(myGroupComment.getForwardNum() != null){
			sql.append(" forward_num = ?, ");
			param.add(myGroupComment.getForwardNum());
		}
		if(myGroupComment.getCommentNum() != null){
			sql.append(" comment_num = ?, ");
			param.add(myGroupComment.getCommentNum());
		}
		if(myGroupComment.getComment() != null){
			sql.append(" comment = ?, ");
			param.add(myGroupComment.getComment());
		}
		if(myGroupComment.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(myGroupComment.getCreateDate());
		}
		if(myGroupComment.getUpdateDate() != null){
			sql.append(" update_date = ? ");
			param.add(myGroupComment.getUpdateDate());
		}
		sql.append(" WHERE comment_id = ? ");
		param.add(myGroupComment.getCommentId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param myGroupComments
	 * @return
	 */
	public Map<String, Object>[] toMap(List<MyGroupComment> myGroupComments){
		Map<String, Object>[] maps = new Map[myGroupComments.size()];
		for(int i = 0; i < myGroupComments.size(); i++){
			MyGroupComment myGroupComment = myGroupComments.get(i);
			maps[i] = toMap(myGroupComment);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param myGroupComment
	 * @return
	 */
	public Map<String, Object> toMap(MyGroupComment myGroupComment){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("comment_id", myGroupComment.getCommentId());
        paramMap.put("parent_comment_id", myGroupComment.getParentCommentId());
        paramMap.put("comment_user_id", myGroupComment.getCommentUserId());
        paramMap.put("group_id", myGroupComment.getGroupId());
        paramMap.put("reviewer_user_id", myGroupComment.getReviewerUserId());
        paramMap.put("forward_num", myGroupComment.getForwardNum());
        paramMap.put("comment_num", myGroupComment.getCommentNum());
        paramMap.put("comment", myGroupComment.getComment());
        paramMap.put("create_date", myGroupComment.getCreateDate());
        paramMap.put("update_date", myGroupComment.getUpdateDate());
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
	public void delete(Long commentId){
		jdbcTemplate.update(DELETE_SQL, commentId);
	}

	@Override
	public void batchSave(List<MyGroupComment> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<MyGroupComment> list){
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
	 * @param commentId 组合评论ID
	 * @return MyGroupComment
	 */
	@Override
	public MyGroupComment findById(Long commentId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`comment_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(MyGroupComment.class), commentId);
	}

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @return List
	 */
	@Override
	public List<MyGroupComment> find(MyGroupComment myGroupComment){
		return this.find(myGroupComment, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<MyGroupComment> find(MyGroupComment myGroupComment, String[][] orders){
		return this.find(myGroupComment, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroupComment
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroupComment> find(MyGroupComment myGroupComment, Long offset, Long rows){
		return this.find(myGroupComment, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroupComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroupComment> find(MyGroupComment myGroupComment, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(myGroupComment != null){
			if(myGroupComment.getCommentId() != null){
				sql.append(" AND _this.`comment_id` = ?");
				param.add(myGroupComment.getCommentId());
			}
			if(myGroupComment.getParentCommentId() != null){
				sql.append(" AND _this.`parent_comment_id` = ?");
				param.add(myGroupComment.getParentCommentId());
			}
			if(myGroupComment.getCommentUserId() != null){
				sql.append(" AND _this.`comment_user_id` = ?");
				param.add(myGroupComment.getCommentUserId());
			}
			if(myGroupComment.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(myGroupComment.getGroupId());
			}
			if(myGroupComment.getReviewerUserId() != null){
				sql.append(" AND _this.`reviewer_user_id` = ?");
				param.add(myGroupComment.getReviewerUserId());
			}
			if(myGroupComment.getForwardNum() != null){
				sql.append(" AND _this.`forward_num` = ?");
				param.add(myGroupComment.getForwardNum());
			}
			if(myGroupComment.getCommentNum() != null){
				sql.append(" AND _this.`comment_num` = ?");
				param.add(myGroupComment.getCommentNum());
			}
			if(myGroupComment.getComment() != null && !"".equals(myGroupComment.getComment())){
				sql.append(" AND _this.`comment` = ?");
				param.add(myGroupComment.getComment());
			}
			if(myGroupComment.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(myGroupComment.getCreateDate());
			}
			if(myGroupComment.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(myGroupComment.getUpdateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(MyGroupComment.class));
	}


	/**
	 * 根据对象查询条数
	 * @param myGroupComment
	 * @return Long
	 */
	@Override
	public Long count(MyGroupComment myGroupComment){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_my_group_comment  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(myGroupComment != null){
			if(myGroupComment.getCommentId() != null){
				sql.append(" AND _this.`comment_id` = ? ");
				param.add(myGroupComment.getCommentId());
			}
			if(myGroupComment.getParentCommentId() != null){
				sql.append(" AND _this.`parent_comment_id` = ? ");
				param.add(myGroupComment.getParentCommentId());
			}
			if(myGroupComment.getCommentUserId() != null){
				sql.append(" AND _this.`comment_user_id` = ? ");
				param.add(myGroupComment.getCommentUserId());
			}
			if(myGroupComment.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(myGroupComment.getGroupId());
			}
			if(myGroupComment.getReviewerUserId() != null){
				sql.append(" AND _this.`reviewer_user_id` = ? ");
				param.add(myGroupComment.getReviewerUserId());
			}
			if(myGroupComment.getForwardNum() != null){
				sql.append(" AND _this.`forward_num` = ? ");
				param.add(myGroupComment.getForwardNum());
			}
			if(myGroupComment.getCommentNum() != null){
				sql.append(" AND _this.`comment_num` = ? ");
				param.add(myGroupComment.getCommentNum());
			}
			if(myGroupComment.getComment() != null && !"".equals(myGroupComment.getComment())){
				sql.append(" AND _this.`comment` = ? ");
				param.add(myGroupComment.getComment());
			}
			if(myGroupComment.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(myGroupComment.getCreateDate());
			}
			if(myGroupComment.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(myGroupComment.getUpdateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}