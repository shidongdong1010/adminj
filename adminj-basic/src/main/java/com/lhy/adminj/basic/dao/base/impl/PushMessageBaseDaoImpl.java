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

import com.lhy.adminj.basic.dao.base.PushMessageBaseDao;
import com.lhy.adminj.basic.model.PushMessage;

/**
 * 推送消息表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class PushMessageBaseDaoImpl implements PushMessageBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`push_id`, _this.`push_title`, _this.`push_content`, _this.`push_time`, _this.`client_type`, _this.`client_network`, _this.`template_type`, _this.`push_result`, _this.`push_response`, _this.`client_id`, _this.`is_push`, _this.`is_online_push`, _this.`msg_type`, _this.`bue_type`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`push_id`, _this.`push_title`, _this.`push_content`, _this.`push_time`, _this.`client_type`, _this.`client_network`, _this.`template_type`, _this.`push_result`, _this.`push_response`, _this.`client_id`, _this.`is_push`, _this.`is_online_push`, _this.`msg_type`, _this.`bue_type` FROM fe_push_message _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO fe_push_message(`push_id`, `push_title`, `push_content`, `push_time`, `client_type`, `client_network`, `template_type`, `push_result`, `push_response`, `client_id`, `is_push`, `is_online_push`, `msg_type`, `bue_type`) VALUES (:push_id, :push_title, :push_content, :push_time, :client_type, :client_network, :template_type, :push_result, :push_response, :client_id, :is_push, :is_online_push, :msg_type, :bue_type)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE fe_push_message SET `push_id` = :push_id, `push_title` = :push_title, `push_content` = :push_content, `push_time` = :push_time, `client_type` = :client_type, `client_network` = :client_network, `template_type` = :template_type, `push_result` = :push_result, `push_response` = :push_response, `client_id` = :client_id, `is_push` = :is_push, `is_online_push` = :is_online_push, `msg_type` = :msg_type, `bue_type` = :bue_type WHERE `push_id` = :push_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM fe_push_message WHERE `push_id` = ?";

	@Override
	public void save(PushMessage pushMessage) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(pushMessage);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		pushMessage.setPushId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(PushMessage pushMessage) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(pushMessage);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(PushMessage pushMessage) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE fe_push_message SET ");
		if(pushMessage.getPushId() != null){
			sql.append(" push_id = ?, ");
			param.add(pushMessage.getPushId());
		}
		if(pushMessage.getPushTitle() != null){
			sql.append(" push_title = ?, ");
			param.add(pushMessage.getPushTitle());
		}
		if(pushMessage.getPushContent() != null){
			sql.append(" push_content = ?, ");
			param.add(pushMessage.getPushContent());
		}
		if(pushMessage.getPushTime() != null){
			sql.append(" push_time = ?, ");
			param.add(pushMessage.getPushTime());
		}
		if(pushMessage.getClientType() != null){
			sql.append(" client_type = ?, ");
			param.add(pushMessage.getClientType());
		}
		if(pushMessage.getClientNetwork() != null){
			sql.append(" client_network = ?, ");
			param.add(pushMessage.getClientNetwork());
		}
		if(pushMessage.getTemplateType() != null){
			sql.append(" template_type = ?, ");
			param.add(pushMessage.getTemplateType());
		}
		if(pushMessage.getPushResult() != null){
			sql.append(" push_result = ?, ");
			param.add(pushMessage.getPushResult());
		}
		if(pushMessage.getPushResponse() != null){
			sql.append(" push_response = ?, ");
			param.add(pushMessage.getPushResponse());
		}
		if(pushMessage.getClientId() != null){
			sql.append(" client_id = ?, ");
			param.add(pushMessage.getClientId());
		}
		if(pushMessage.getIsPush() != null){
			sql.append(" is_push = ?, ");
			param.add(pushMessage.getIsPush());
		}
		if(pushMessage.getIsOnlinePush() != null){
			sql.append(" is_online_push = ?, ");
			param.add(pushMessage.getIsOnlinePush());
		}
		if(pushMessage.getMsgType() != null){
			sql.append(" msg_type = ?, ");
			param.add(pushMessage.getMsgType());
		}
		if(pushMessage.getBueType() != null){
			sql.append(" bue_type = ? ");
			param.add(pushMessage.getBueType());
		}
		sql.append(" WHERE push_id = ? ");
		param.add(pushMessage.getPushId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param pushMessages
	 * @return
	 */
	public Map<String, Object>[] toMap(List<PushMessage> pushMessages){
		Map<String, Object>[] maps = new Map[pushMessages.size()];
		for(int i = 0; i < pushMessages.size(); i++){
			PushMessage pushMessage = pushMessages.get(i);
			maps[i] = toMap(pushMessage);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param pushMessage
	 * @return
	 */
	public Map<String, Object> toMap(PushMessage pushMessage){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("push_id", pushMessage.getPushId());
        paramMap.put("push_title", pushMessage.getPushTitle());
        paramMap.put("push_content", pushMessage.getPushContent());
        paramMap.put("push_time", pushMessage.getPushTime());
        paramMap.put("client_type", pushMessage.getClientType());
        paramMap.put("client_network", pushMessage.getClientNetwork());
        paramMap.put("template_type", pushMessage.getTemplateType());
        paramMap.put("push_result", pushMessage.getPushResult());
        paramMap.put("push_response", pushMessage.getPushResponse());
        paramMap.put("client_id", pushMessage.getClientId());
        paramMap.put("is_push", pushMessage.getIsPush());
        paramMap.put("is_online_push", pushMessage.getIsOnlinePush());
        paramMap.put("msg_type", pushMessage.getMsgType());
        paramMap.put("bue_type", pushMessage.getBueType());
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
	public void delete(Long pushId){
		jdbcTemplate.update(DELETE_SQL, pushId);
	}

	@Override
	public void batchSave(List<PushMessage> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<PushMessage> list){
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
	 * @param pushId 推送ID
	 * @return PushMessage
	 */
	@Override
	public PushMessage findById(Long pushId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`push_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(PushMessage.class), pushId);
	}

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @return List
	 */
	@Override
	public List<PushMessage> find(PushMessage pushMessage){
		return this.find(pushMessage, null, null);
	}

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<PushMessage> find(PushMessage pushMessage, String[][] orders){
		return this.find(pushMessage, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param pushMessage
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<PushMessage> find(PushMessage pushMessage, Long offset, Long rows){
		return this.find(pushMessage, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param pushMessage
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<PushMessage> find(PushMessage pushMessage, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(pushMessage != null){
			if(pushMessage.getPushId() != null){
				sql.append(" AND _this.`push_id` = ?");
				param.add(pushMessage.getPushId());
			}
			if(pushMessage.getPushTitle() != null && !"".equals(pushMessage.getPushTitle())){
				sql.append(" AND _this.`push_title` = ?");
				param.add(pushMessage.getPushTitle());
			}
			if(pushMessage.getPushContent() != null && !"".equals(pushMessage.getPushContent())){
				sql.append(" AND _this.`push_content` = ?");
				param.add(pushMessage.getPushContent());
			}
			if(pushMessage.getPushTime() != null){
				sql.append(" AND _this.`push_time` = ?");
				param.add(pushMessage.getPushTime());
			}
			if(pushMessage.getClientType() != null){
				sql.append(" AND _this.`client_type` = ?");
				param.add(pushMessage.getClientType());
			}
			if(pushMessage.getClientNetwork() != null){
				sql.append(" AND _this.`client_network` = ?");
				param.add(pushMessage.getClientNetwork());
			}
			if(pushMessage.getTemplateType() != null){
				sql.append(" AND _this.`template_type` = ?");
				param.add(pushMessage.getTemplateType());
			}
			if(pushMessage.getPushResult() != null){
				sql.append(" AND _this.`push_result` = ?");
				param.add(pushMessage.getPushResult());
			}
			if(pushMessage.getPushResponse() != null && !"".equals(pushMessage.getPushResponse())){
				sql.append(" AND _this.`push_response` = ?");
				param.add(pushMessage.getPushResponse());
			}
			if(pushMessage.getClientId() != null && !"".equals(pushMessage.getClientId())){
				sql.append(" AND _this.`client_id` = ?");
				param.add(pushMessage.getClientId());
			}
			if(pushMessage.getIsPush() != null){
				sql.append(" AND _this.`is_push` = ?");
				param.add(pushMessage.getIsPush());
			}
			if(pushMessage.getIsOnlinePush() != null){
				sql.append(" AND _this.`is_online_push` = ?");
				param.add(pushMessage.getIsOnlinePush());
			}
			if(pushMessage.getMsgType() != null){
				sql.append(" AND _this.`msg_type` = ?");
				param.add(pushMessage.getMsgType());
			}
			if(pushMessage.getBueType() != null){
				sql.append(" AND _this.`bue_type` = ?");
				param.add(pushMessage.getBueType());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(PushMessage.class));
	}


	/**
	 * 根据对象查询条数
	 * @param pushMessage
	 * @return Long
	 */
	@Override
	public Long count(PushMessage pushMessage){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM fe_push_message  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(pushMessage != null){
			if(pushMessage.getPushId() != null){
				sql.append(" AND _this.`push_id` = ? ");
				param.add(pushMessage.getPushId());
			}
			if(pushMessage.getPushTitle() != null && !"".equals(pushMessage.getPushTitle())){
				sql.append(" AND _this.`push_title` = ? ");
				param.add(pushMessage.getPushTitle());
			}
			if(pushMessage.getPushContent() != null && !"".equals(pushMessage.getPushContent())){
				sql.append(" AND _this.`push_content` = ? ");
				param.add(pushMessage.getPushContent());
			}
			if(pushMessage.getPushTime() != null){
				sql.append(" AND _this.`push_time` = ? ");
				param.add(pushMessage.getPushTime());
			}
			if(pushMessage.getClientType() != null){
				sql.append(" AND _this.`client_type` = ? ");
				param.add(pushMessage.getClientType());
			}
			if(pushMessage.getClientNetwork() != null){
				sql.append(" AND _this.`client_network` = ? ");
				param.add(pushMessage.getClientNetwork());
			}
			if(pushMessage.getTemplateType() != null){
				sql.append(" AND _this.`template_type` = ? ");
				param.add(pushMessage.getTemplateType());
			}
			if(pushMessage.getPushResult() != null){
				sql.append(" AND _this.`push_result` = ? ");
				param.add(pushMessage.getPushResult());
			}
			if(pushMessage.getPushResponse() != null && !"".equals(pushMessage.getPushResponse())){
				sql.append(" AND _this.`push_response` = ? ");
				param.add(pushMessage.getPushResponse());
			}
			if(pushMessage.getClientId() != null && !"".equals(pushMessage.getClientId())){
				sql.append(" AND _this.`client_id` = ? ");
				param.add(pushMessage.getClientId());
			}
			if(pushMessage.getIsPush() != null){
				sql.append(" AND _this.`is_push` = ? ");
				param.add(pushMessage.getIsPush());
			}
			if(pushMessage.getIsOnlinePush() != null){
				sql.append(" AND _this.`is_online_push` = ? ");
				param.add(pushMessage.getIsOnlinePush());
			}
			if(pushMessage.getMsgType() != null){
				sql.append(" AND _this.`msg_type` = ? ");
				param.add(pushMessage.getMsgType());
			}
			if(pushMessage.getBueType() != null){
				sql.append(" AND _this.`bue_type` = ? ");
				param.add(pushMessage.getBueType());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}