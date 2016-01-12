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

import com.lhy.adminj.basic.dao.base.UserDynamicCommentBaseDao;
import com.lhy.adminj.basic.model.UserDynamicComment;

/**
 * 用户动态评论表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicCommentBaseDaoImpl implements UserDynamicCommentBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`comment_id`, _this.`dynamic_id`, _this.`user_id`, _this.`comment_user_id`, _this.`comment`, _this.`praise_num`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`show_location`, _this.`local`, _this.`give_user_id`, _this.`image_path`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`comment_id`, _this.`dynamic_id`, _this.`user_id`, _this.`comment_user_id`, _this.`comment`, _this.`praise_num`, _this.`create_date`, _this.`update_date`, _this.`is_del`, _this.`show_location`, _this.`local`, _this.`give_user_id`, _this.`image_path` FROM udc_user_dynamic_comment _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO udc_user_dynamic_comment(`comment_id`, `dynamic_id`, `user_id`, `comment_user_id`, `comment`, `praise_num`, `create_date`, `update_date`, `is_del`, `show_location`, `local`, `give_user_id`, `image_path`) VALUES (:comment_id, :dynamic_id, :user_id, :comment_user_id, :comment, :praise_num, :create_date, :update_date, :is_del, :show_location, :local, :give_user_id, :image_path)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE udc_user_dynamic_comment SET `comment_id` = :comment_id, `dynamic_id` = :dynamic_id, `user_id` = :user_id, `comment_user_id` = :comment_user_id, `comment` = :comment, `praise_num` = :praise_num, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del, `show_location` = :show_location, `local` = :local, `give_user_id` = :give_user_id, `image_path` = :image_path WHERE `comment_id` = :comment_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM udc_user_dynamic_comment WHERE `comment_id` = ?";

	@Override
	public void save(UserDynamicComment userDynamicComment) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicComment);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userDynamicComment.setCommentId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserDynamicComment userDynamicComment) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicComment);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserDynamicComment userDynamicComment) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE udc_user_dynamic_comment SET ");
		if(userDynamicComment.getCommentId() != null){
			sql.append(" comment_id = ?, ");
			param.add(userDynamicComment.getCommentId());
		}
		if(userDynamicComment.getDynamicId() != null){
			sql.append(" dynamic_id = ?, ");
			param.add(userDynamicComment.getDynamicId());
		}
		if(userDynamicComment.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userDynamicComment.getUserId());
		}
		if(userDynamicComment.getCommentUserId() != null){
			sql.append(" comment_user_id = ?, ");
			param.add(userDynamicComment.getCommentUserId());
		}
		if(userDynamicComment.getComment() != null){
			sql.append(" comment = ?, ");
			param.add(userDynamicComment.getComment());
		}
		if(userDynamicComment.getPraiseNum() != null){
			sql.append(" praise_num = ?, ");
			param.add(userDynamicComment.getPraiseNum());
		}
		if(userDynamicComment.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userDynamicComment.getCreateDate());
		}
		if(userDynamicComment.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userDynamicComment.getUpdateDate());
		}
		if(userDynamicComment.getIsDel() != null){
			sql.append(" is_del = ?, ");
			param.add(userDynamicComment.getIsDel());
		}
		if(userDynamicComment.getShowLocation() != null){
			sql.append(" show_location = ?, ");
			param.add(userDynamicComment.getShowLocation());
		}
		if(userDynamicComment.getLocal() != null){
			sql.append(" local = ?, ");
			param.add(userDynamicComment.getLocal());
		}
		if(userDynamicComment.getGiveUserId() != null){
			sql.append(" give_user_id = ?, ");
			param.add(userDynamicComment.getGiveUserId());
		}
		if(userDynamicComment.getImagePath() != null){
			sql.append(" image_path = ? ");
			param.add(userDynamicComment.getImagePath());
		}
		sql.append(" WHERE comment_id = ? ");
		param.add(userDynamicComment.getCommentId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicComments
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserDynamicComment> userDynamicComments){
		Map<String, Object>[] maps = new Map[userDynamicComments.size()];
		for(int i = 0; i < userDynamicComments.size(); i++){
			UserDynamicComment userDynamicComment = userDynamicComments.get(i);
			maps[i] = toMap(userDynamicComment);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicComment
	 * @return
	 */
	public Map<String, Object> toMap(UserDynamicComment userDynamicComment){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("comment_id", userDynamicComment.getCommentId());
        paramMap.put("dynamic_id", userDynamicComment.getDynamicId());
        paramMap.put("user_id", userDynamicComment.getUserId());
        paramMap.put("comment_user_id", userDynamicComment.getCommentUserId());
        paramMap.put("comment", userDynamicComment.getComment());
        paramMap.put("praise_num", userDynamicComment.getPraiseNum());
        paramMap.put("create_date", userDynamicComment.getCreateDate());
        paramMap.put("update_date", userDynamicComment.getUpdateDate());
        paramMap.put("is_del", userDynamicComment.getIsDel());
        paramMap.put("show_location", userDynamicComment.getShowLocation());
        paramMap.put("local", userDynamicComment.getLocal());
        paramMap.put("give_user_id", userDynamicComment.getGiveUserId());
        paramMap.put("image_path", userDynamicComment.getImagePath());
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
	public void batchSave(List<UserDynamicComment> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserDynamicComment> list){
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
	 * @param commentId 评论ID
	 * @return UserDynamicComment
	 */
	@Override
	public UserDynamicComment findById(Long commentId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`comment_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserDynamicComment.class), commentId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @return List
	 */
	@Override
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment){
		return this.find(userDynamicComment, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, String[][] orders){
		return this.find(userDynamicComment, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicComment
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, Long offset, Long rows){
		return this.find(userDynamicComment, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicComment
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicComment> find(UserDynamicComment userDynamicComment, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userDynamicComment != null){
			if(userDynamicComment.getCommentId() != null){
				sql.append(" AND _this.`comment_id` = ?");
				param.add(userDynamicComment.getCommentId());
			}
			if(userDynamicComment.getDynamicId() != null){
				sql.append(" AND _this.`dynamic_id` = ?");
				param.add(userDynamicComment.getDynamicId());
			}
			if(userDynamicComment.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userDynamicComment.getUserId());
			}
			if(userDynamicComment.getCommentUserId() != null){
				sql.append(" AND _this.`comment_user_id` = ?");
				param.add(userDynamicComment.getCommentUserId());
			}
			if(userDynamicComment.getComment() != null && !"".equals(userDynamicComment.getComment())){
				sql.append(" AND _this.`comment` = ?");
				param.add(userDynamicComment.getComment());
			}
			if(userDynamicComment.getPraiseNum() != null){
				sql.append(" AND _this.`praise_num` = ?");
				param.add(userDynamicComment.getPraiseNum());
			}
			if(userDynamicComment.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userDynamicComment.getCreateDate());
			}
			if(userDynamicComment.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userDynamicComment.getUpdateDate());
			}
			if(userDynamicComment.getIsDel() != null && !"".equals(userDynamicComment.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userDynamicComment.getIsDel());
			}
			if(userDynamicComment.getShowLocation() != null && !"".equals(userDynamicComment.getShowLocation())){
				sql.append(" AND _this.`show_location` = ?");
				param.add(userDynamicComment.getShowLocation());
			}
			if(userDynamicComment.getLocal() != null && !"".equals(userDynamicComment.getLocal())){
				sql.append(" AND _this.`local` = ?");
				param.add(userDynamicComment.getLocal());
			}
			if(userDynamicComment.getGiveUserId() != null){
				sql.append(" AND _this.`give_user_id` = ?");
				param.add(userDynamicComment.getGiveUserId());
			}
			if(userDynamicComment.getImagePath() != null && !"".equals(userDynamicComment.getImagePath())){
				sql.append(" AND _this.`image_path` = ?");
				param.add(userDynamicComment.getImagePath());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserDynamicComment.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userDynamicComment
	 * @return Long
	 */
	@Override
	public Long count(UserDynamicComment userDynamicComment){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM udc_user_dynamic_comment  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userDynamicComment != null){
			if(userDynamicComment.getCommentId() != null){
				sql.append(" AND _this.`comment_id` = ? ");
				param.add(userDynamicComment.getCommentId());
			}
			if(userDynamicComment.getDynamicId() != null){
				sql.append(" AND _this.`dynamic_id` = ? ");
				param.add(userDynamicComment.getDynamicId());
			}
			if(userDynamicComment.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userDynamicComment.getUserId());
			}
			if(userDynamicComment.getCommentUserId() != null){
				sql.append(" AND _this.`comment_user_id` = ? ");
				param.add(userDynamicComment.getCommentUserId());
			}
			if(userDynamicComment.getComment() != null && !"".equals(userDynamicComment.getComment())){
				sql.append(" AND _this.`comment` = ? ");
				param.add(userDynamicComment.getComment());
			}
			if(userDynamicComment.getPraiseNum() != null){
				sql.append(" AND _this.`praise_num` = ? ");
				param.add(userDynamicComment.getPraiseNum());
			}
			if(userDynamicComment.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userDynamicComment.getCreateDate());
			}
			if(userDynamicComment.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userDynamicComment.getUpdateDate());
			}
			if(userDynamicComment.getIsDel() != null && !"".equals(userDynamicComment.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userDynamicComment.getIsDel());
			}
			if(userDynamicComment.getShowLocation() != null && !"".equals(userDynamicComment.getShowLocation())){
				sql.append(" AND _this.`show_location` = ? ");
				param.add(userDynamicComment.getShowLocation());
			}
			if(userDynamicComment.getLocal() != null && !"".equals(userDynamicComment.getLocal())){
				sql.append(" AND _this.`local` = ? ");
				param.add(userDynamicComment.getLocal());
			}
			if(userDynamicComment.getGiveUserId() != null){
				sql.append(" AND _this.`give_user_id` = ? ");
				param.add(userDynamicComment.getGiveUserId());
			}
			if(userDynamicComment.getImagePath() != null && !"".equals(userDynamicComment.getImagePath())){
				sql.append(" AND _this.`image_path` = ? ");
				param.add(userDynamicComment.getImagePath());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}