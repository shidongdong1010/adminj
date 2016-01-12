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

import com.lhy.adminj.basic.dao.base.UserMessageBaseDao;
import com.lhy.adminj.basic.model.UserMessage;

/**
 * 用户消息表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserMessageBaseDaoImpl implements UserMessageBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`message_id`, _this.`message_type_id`, _this.`message_type`, _this.`sent_user_id`, _this.`get_user_id`, _this.`create_time`, _this.`message_desc`, _this.`is_read`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`message_id`, _this.`message_type_id`, _this.`message_type`, _this.`sent_user_id`, _this.`get_user_id`, _this.`create_time`, _this.`message_desc`, _this.`is_read`, _this.`is_del` FROM umc_user_message _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_message(`message_id`, `message_type_id`, `message_type`, `sent_user_id`, `get_user_id`, `create_time`, `message_desc`, `is_read`, `is_del`) VALUES (:message_id, :message_type_id, :message_type, :sent_user_id, :get_user_id, :create_time, :message_desc, :is_read, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_message SET `message_id` = :message_id, `message_type_id` = :message_type_id, `message_type` = :message_type, `sent_user_id` = :sent_user_id, `get_user_id` = :get_user_id, `create_time` = :create_time, `message_desc` = :message_desc, `is_read` = :is_read, `is_del` = :is_del WHERE `message_id` = :message_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_message WHERE `message_id` = ?";

	@Override
	public void save(UserMessage userMessage) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userMessage);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userMessage.setMessageId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserMessage userMessage) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userMessage);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserMessage userMessage) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_message SET ");
		if(userMessage.getMessageId() != null){
			sql.append(" message_id = ?, ");
			param.add(userMessage.getMessageId());
		}
		if(userMessage.getMessageTypeId() != null){
			sql.append(" message_type_id = ?, ");
			param.add(userMessage.getMessageTypeId());
		}
		if(userMessage.getMessageType() != null){
			sql.append(" message_type = ?, ");
			param.add(userMessage.getMessageType());
		}
		if(userMessage.getSentUserId() != null){
			sql.append(" sent_user_id = ?, ");
			param.add(userMessage.getSentUserId());
		}
		if(userMessage.getGetUserId() != null){
			sql.append(" get_user_id = ?, ");
			param.add(userMessage.getGetUserId());
		}
		if(userMessage.getCreateTime() != null){
			sql.append(" create_time = ?, ");
			param.add(userMessage.getCreateTime());
		}
		if(userMessage.getMessageDesc() != null){
			sql.append(" message_desc = ?, ");
			param.add(userMessage.getMessageDesc());
		}
		if(userMessage.getIsRead() != null){
			sql.append(" is_read = ?, ");
			param.add(userMessage.getIsRead());
		}
		if(userMessage.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(userMessage.getIsDel());
		}
		sql.append(" WHERE message_id = ? ");
		param.add(userMessage.getMessageId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userMessages
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserMessage> userMessages){
		Map<String, Object>[] maps = new Map[userMessages.size()];
		for(int i = 0; i < userMessages.size(); i++){
			UserMessage userMessage = userMessages.get(i);
			maps[i] = toMap(userMessage);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userMessage
	 * @return
	 */
	public Map<String, Object> toMap(UserMessage userMessage){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("message_id", userMessage.getMessageId());
        paramMap.put("message_type_id", userMessage.getMessageTypeId());
        paramMap.put("message_type", userMessage.getMessageType());
        paramMap.put("sent_user_id", userMessage.getSentUserId());
        paramMap.put("get_user_id", userMessage.getGetUserId());
        paramMap.put("create_time", userMessage.getCreateTime());
        paramMap.put("message_desc", userMessage.getMessageDesc());
        paramMap.put("is_read", userMessage.getIsRead());
        paramMap.put("is_del", userMessage.getIsDel());
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
	public void delete(Long messageId){
		jdbcTemplate.update(DELETE_SQL, messageId);
	}

	@Override
	public void batchSave(List<UserMessage> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserMessage> list){
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
	 * @param messageId 用户消息表ID
	 * @return UserMessage
	 */
	@Override
	public UserMessage findById(Long messageId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`message_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserMessage.class), messageId);
	}

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @return List
	 */
	@Override
	public List<UserMessage> find(UserMessage userMessage){
		return this.find(userMessage, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserMessage> find(UserMessage userMessage, String[][] orders){
		return this.find(userMessage, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userMessage
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserMessage> find(UserMessage userMessage, Long offset, Long rows){
		return this.find(userMessage, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserMessage> find(UserMessage userMessage, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userMessage != null){
			if(userMessage.getMessageId() != null){
				sql.append(" AND _this.`message_id` = ?");
				param.add(userMessage.getMessageId());
			}
			if(userMessage.getMessageTypeId() != null){
				sql.append(" AND _this.`message_type_id` = ?");
				param.add(userMessage.getMessageTypeId());
			}
			if(userMessage.getMessageType() != null && !"".equals(userMessage.getMessageType())){
				sql.append(" AND _this.`message_type` = ?");
				param.add(userMessage.getMessageType());
			}
			if(userMessage.getSentUserId() != null){
				sql.append(" AND _this.`sent_user_id` = ?");
				param.add(userMessage.getSentUserId());
			}
			if(userMessage.getGetUserId() != null){
				sql.append(" AND _this.`get_user_id` = ?");
				param.add(userMessage.getGetUserId());
			}
			if(userMessage.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(userMessage.getCreateTime());
			}
			if(userMessage.getMessageDesc() != null && !"".equals(userMessage.getMessageDesc())){
				sql.append(" AND _this.`message_desc` = ?");
				param.add(userMessage.getMessageDesc());
			}
			if(userMessage.getIsRead() != null && !"".equals(userMessage.getIsRead())){
				sql.append(" AND _this.`is_read` = ?");
				param.add(userMessage.getIsRead());
			}
			if(userMessage.getIsDel() != null && !"".equals(userMessage.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userMessage.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserMessage.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userMessage
	 * @return Long
	 */
	@Override
	public Long count(UserMessage userMessage){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_message  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userMessage != null){
			if(userMessage.getMessageId() != null){
				sql.append(" AND _this.`message_id` = ? ");
				param.add(userMessage.getMessageId());
			}
			if(userMessage.getMessageTypeId() != null){
				sql.append(" AND _this.`message_type_id` = ? ");
				param.add(userMessage.getMessageTypeId());
			}
			if(userMessage.getMessageType() != null && !"".equals(userMessage.getMessageType())){
				sql.append(" AND _this.`message_type` = ? ");
				param.add(userMessage.getMessageType());
			}
			if(userMessage.getSentUserId() != null){
				sql.append(" AND _this.`sent_user_id` = ? ");
				param.add(userMessage.getSentUserId());
			}
			if(userMessage.getGetUserId() != null){
				sql.append(" AND _this.`get_user_id` = ? ");
				param.add(userMessage.getGetUserId());
			}
			if(userMessage.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(userMessage.getCreateTime());
			}
			if(userMessage.getMessageDesc() != null && !"".equals(userMessage.getMessageDesc())){
				sql.append(" AND _this.`message_desc` = ? ");
				param.add(userMessage.getMessageDesc());
			}
			if(userMessage.getIsRead() != null && !"".equals(userMessage.getIsRead())){
				sql.append(" AND _this.`is_read` = ? ");
				param.add(userMessage.getIsRead());
			}
			if(userMessage.getIsDel() != null && !"".equals(userMessage.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userMessage.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}