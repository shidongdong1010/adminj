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

import com.lhy.adminj.basic.dao.base.UserMobileBookBaseDao;
import com.lhy.adminj.basic.model.UserMobileBook;

/**
 * 用户手机通讯表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserMobileBookBaseDaoImpl implements UserMobileBookBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`book_id`, _this.`user_id`, _this.`mobile`, _this.`mobile_name`, _this.`is_member`, _this.`link_user_id`, _this.`create_date`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`book_id`, _this.`user_id`, _this.`mobile`, _this.`mobile_name`, _this.`is_member`, _this.`link_user_id`, _this.`create_date` FROM umc_user_mobile_book _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_mobile_book(`book_id`, `user_id`, `mobile`, `mobile_name`, `is_member`, `link_user_id`, `create_date`) VALUES (:book_id, :user_id, :mobile, :mobile_name, :is_member, :link_user_id, :create_date)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_mobile_book SET `book_id` = :book_id, `user_id` = :user_id, `mobile` = :mobile, `mobile_name` = :mobile_name, `is_member` = :is_member, `link_user_id` = :link_user_id, `create_date` = :create_date WHERE `book_id` = :book_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_mobile_book WHERE `book_id` = ?";

	@Override
	public void save(UserMobileBook userMobileBook) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userMobileBook);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userMobileBook.setBookId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserMobileBook userMobileBook) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userMobileBook);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserMobileBook userMobileBook) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_mobile_book SET ");
		if(userMobileBook.getBookId() != null){
			sql.append(" book_id = ?, ");
			param.add(userMobileBook.getBookId());
		}
		if(userMobileBook.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userMobileBook.getUserId());
		}
		if(userMobileBook.getMobile() != null){
			sql.append(" mobile = ?, ");
			param.add(userMobileBook.getMobile());
		}
		if(userMobileBook.getMobileName() != null){
			sql.append(" mobile_name = ?, ");
			param.add(userMobileBook.getMobileName());
		}
		if(userMobileBook.getIsMember() != null){
			sql.append(" is_member = ?, ");
			param.add(userMobileBook.getIsMember());
		}
		if(userMobileBook.getLinkUserId() != null){
			sql.append(" link_user_id = ?, ");
			param.add(userMobileBook.getLinkUserId());
		}
		if(userMobileBook.getCreateDate() != null){
			sql.append(" create_date = ? ");
			param.add(userMobileBook.getCreateDate());
		}
		sql.append(" WHERE book_id = ? ");
		param.add(userMobileBook.getBookId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userMobileBooks
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserMobileBook> userMobileBooks){
		Map<String, Object>[] maps = new Map[userMobileBooks.size()];
		for(int i = 0; i < userMobileBooks.size(); i++){
			UserMobileBook userMobileBook = userMobileBooks.get(i);
			maps[i] = toMap(userMobileBook);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userMobileBook
	 * @return
	 */
	public Map<String, Object> toMap(UserMobileBook userMobileBook){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("book_id", userMobileBook.getBookId());
        paramMap.put("user_id", userMobileBook.getUserId());
        paramMap.put("mobile", userMobileBook.getMobile());
        paramMap.put("mobile_name", userMobileBook.getMobileName());
        paramMap.put("is_member", userMobileBook.getIsMember());
        paramMap.put("link_user_id", userMobileBook.getLinkUserId());
        paramMap.put("create_date", userMobileBook.getCreateDate());
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
	public void delete(Long bookId){
		jdbcTemplate.update(DELETE_SQL, bookId);
	}

	@Override
	public void batchSave(List<UserMobileBook> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserMobileBook> list){
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
	 * @param bookId 通讯录ID
	 * @return UserMobileBook
	 */
	@Override
	public UserMobileBook findById(Long bookId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`book_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserMobileBook.class), bookId);
	}

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @return List
	 */
	@Override
	public List<UserMobileBook> find(UserMobileBook userMobileBook){
		return this.find(userMobileBook, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserMobileBook> find(UserMobileBook userMobileBook, String[][] orders){
		return this.find(userMobileBook, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userMobileBook
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserMobileBook> find(UserMobileBook userMobileBook, Long offset, Long rows){
		return this.find(userMobileBook, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userMobileBook
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserMobileBook> find(UserMobileBook userMobileBook, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userMobileBook != null){
			if(userMobileBook.getBookId() != null){
				sql.append(" AND _this.`book_id` = ?");
				param.add(userMobileBook.getBookId());
			}
			if(userMobileBook.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userMobileBook.getUserId());
			}
			if(userMobileBook.getMobile() != null && !"".equals(userMobileBook.getMobile())){
				sql.append(" AND _this.`mobile` = ?");
				param.add(userMobileBook.getMobile());
			}
			if(userMobileBook.getMobileName() != null && !"".equals(userMobileBook.getMobileName())){
				sql.append(" AND _this.`mobile_name` = ?");
				param.add(userMobileBook.getMobileName());
			}
			if(userMobileBook.getIsMember() != null && !"".equals(userMobileBook.getIsMember())){
				sql.append(" AND _this.`is_member` = ?");
				param.add(userMobileBook.getIsMember());
			}
			if(userMobileBook.getLinkUserId() != null){
				sql.append(" AND _this.`link_user_id` = ?");
				param.add(userMobileBook.getLinkUserId());
			}
			if(userMobileBook.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userMobileBook.getCreateDate());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserMobileBook.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userMobileBook
	 * @return Long
	 */
	@Override
	public Long count(UserMobileBook userMobileBook){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_mobile_book  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userMobileBook != null){
			if(userMobileBook.getBookId() != null){
				sql.append(" AND _this.`book_id` = ? ");
				param.add(userMobileBook.getBookId());
			}
			if(userMobileBook.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userMobileBook.getUserId());
			}
			if(userMobileBook.getMobile() != null && !"".equals(userMobileBook.getMobile())){
				sql.append(" AND _this.`mobile` = ? ");
				param.add(userMobileBook.getMobile());
			}
			if(userMobileBook.getMobileName() != null && !"".equals(userMobileBook.getMobileName())){
				sql.append(" AND _this.`mobile_name` = ? ");
				param.add(userMobileBook.getMobileName());
			}
			if(userMobileBook.getIsMember() != null && !"".equals(userMobileBook.getIsMember())){
				sql.append(" AND _this.`is_member` = ? ");
				param.add(userMobileBook.getIsMember());
			}
			if(userMobileBook.getLinkUserId() != null){
				sql.append(" AND _this.`link_user_id` = ? ");
				param.add(userMobileBook.getLinkUserId());
			}
			if(userMobileBook.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userMobileBook.getCreateDate());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}