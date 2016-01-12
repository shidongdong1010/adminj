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

import com.lhy.adminj.basic.dao.base.UserBaseDao;
import com.lhy.adminj.basic.model.User;

/**
 * 用户表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserBaseDaoImpl implements UserBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`user_id`, _this.`user_name`, _this.`password`, _this.`mobile`, _this.`reg_ip`, _this.`type`, _this.`status`, _this.`client_id`, _this.`client_type`, _this.`push_switch`, _this.`sail_currency`, _this.`level`, _this.`email`, _this.`user_source`, _this.`qq`, _this.`we_chat`, _this.`weibo`, _this.`create_date`, _this.`update_date`, _this.`open_id`, _this.`longitude`, _this.`latitude`, _this.`lastcity`, _this.`version`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`user_id`, _this.`user_name`, _this.`password`, _this.`mobile`, _this.`reg_ip`, _this.`type`, _this.`status`, _this.`client_id`, _this.`client_type`, _this.`push_switch`, _this.`sail_currency`, _this.`level`, _this.`email`, _this.`user_source`, _this.`qq`, _this.`we_chat`, _this.`weibo`, _this.`create_date`, _this.`update_date`, _this.`open_id`, _this.`longitude`, _this.`latitude`, _this.`lastcity`, _this.`version` FROM umc_user _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user(`user_id`, `user_name`, `password`, `mobile`, `reg_ip`, `type`, `status`, `client_id`, `client_type`, `push_switch`, `sail_currency`, `level`, `email`, `user_source`, `qq`, `we_chat`, `weibo`, `create_date`, `update_date`, `open_id`, `longitude`, `latitude`, `lastcity`, `version`) VALUES (:user_id, :user_name, :password, :mobile, :reg_ip, :type, :status, :client_id, :client_type, :push_switch, :sail_currency, :level, :email, :user_source, :qq, :we_chat, :weibo, :create_date, :update_date, :open_id, :longitude, :latitude, :lastcity, :version)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user SET `user_id` = :user_id, `user_name` = :user_name, `password` = :password, `mobile` = :mobile, `reg_ip` = :reg_ip, `type` = :type, `status` = :status, `client_id` = :client_id, `client_type` = :client_type, `push_switch` = :push_switch, `sail_currency` = :sail_currency, `level` = :level, `email` = :email, `user_source` = :user_source, `qq` = :qq, `we_chat` = :we_chat, `weibo` = :weibo, `create_date` = :create_date, `update_date` = :update_date, `open_id` = :open_id, `longitude` = :longitude, `latitude` = :latitude, `lastcity` = :lastcity, `version` = :version WHERE `user_id` = :user_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user WHERE `user_id` = ?";

	@Override
	public void save(User user) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(user);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		user.setUserId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(User user) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(user);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(User user) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user SET ");
		if(user.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(user.getUserId());
		}
		if(user.getUserName() != null){
			sql.append(" user_name = ?, ");
			param.add(user.getUserName());
		}
		if(user.getPassword() != null){
			sql.append(" password = ?, ");
			param.add(user.getPassword());
		}
		if(user.getMobile() != null){
			sql.append(" mobile = ?, ");
			param.add(user.getMobile());
		}
		if(user.getRegIp() != null){
			sql.append(" reg_ip = ?, ");
			param.add(user.getRegIp());
		}
		if(user.getType() != null){
			sql.append(" type = ?, ");
			param.add(user.getType());
		}
		if(user.getStatus() != null){
			sql.append(" status = ?, ");
			param.add(user.getStatus());
		}
		if(user.getClientId() != null){
			sql.append(" client_id = ?, ");
			param.add(user.getClientId());
		}
		if(user.getClientType() != null){
			sql.append(" client_type = ?, ");
			param.add(user.getClientType());
		}
		if(user.getPushSwitch() != null){
			sql.append(" push_switch = ?, ");
			param.add(user.getPushSwitch());
		}
		if(user.getSailCurrency() != null){
			sql.append(" sail_currency = ?, ");
			param.add(user.getSailCurrency());
		}
		if(user.getLevel() != null){
			sql.append(" level = ?, ");
			param.add(user.getLevel());
		}
		if(user.getEmail() != null){
			sql.append(" email = ?, ");
			param.add(user.getEmail());
		}
		if(user.getUserSource() != null){
			sql.append(" user_source = ?, ");
			param.add(user.getUserSource());
		}
		if(user.getQq() != null){
			sql.append(" qq = ?, ");
			param.add(user.getQq());
		}
		if(user.getWeChat() != null){
			sql.append(" we_chat = ?, ");
			param.add(user.getWeChat());
		}
		if(user.getWeibo() != null){
			sql.append(" weibo = ?, ");
			param.add(user.getWeibo());
		}
		if(user.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(user.getCreateDate());
		}
		if(user.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(user.getUpdateDate());
		}
		if(user.getOpenId() != null){
			sql.append(" open_id = ?, ");
			param.add(user.getOpenId());
		}
		if(user.getLongitude() != null){
			sql.append(" longitude = ?, ");
			param.add(user.getLongitude());
		}
		if(user.getLatitude() != null){
			sql.append(" latitude = ?, ");
			param.add(user.getLatitude());
		}
		if(user.getLastcity() != null){
			sql.append(" lastcity = ?, ");
			param.add(user.getLastcity());
		}
		if(user.getVersion() != null){
			sql.append(" version = ? ");
			param.add(user.getVersion());
		}
		sql.append(" WHERE user_id = ? ");
		param.add(user.getUserId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param users
	 * @return
	 */
	public Map<String, Object>[] toMap(List<User> users){
		Map<String, Object>[] maps = new Map[users.size()];
		for(int i = 0; i < users.size(); i++){
			User user = users.get(i);
			maps[i] = toMap(user);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param user
	 * @return
	 */
	public Map<String, Object> toMap(User user){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", user.getUserId());
        paramMap.put("user_name", user.getUserName());
        paramMap.put("password", user.getPassword());
        paramMap.put("mobile", user.getMobile());
        paramMap.put("reg_ip", user.getRegIp());
        paramMap.put("type", user.getType());
        paramMap.put("status", user.getStatus());
        paramMap.put("client_id", user.getClientId());
        paramMap.put("client_type", user.getClientType());
        paramMap.put("push_switch", user.getPushSwitch());
        paramMap.put("sail_currency", user.getSailCurrency());
        paramMap.put("level", user.getLevel());
        paramMap.put("email", user.getEmail());
        paramMap.put("user_source", user.getUserSource());
        paramMap.put("qq", user.getQq());
        paramMap.put("we_chat", user.getWeChat());
        paramMap.put("weibo", user.getWeibo());
        paramMap.put("create_date", user.getCreateDate());
        paramMap.put("update_date", user.getUpdateDate());
        paramMap.put("open_id", user.getOpenId());
        paramMap.put("longitude", user.getLongitude());
        paramMap.put("latitude", user.getLatitude());
        paramMap.put("lastcity", user.getLastcity());
        paramMap.put("version", user.getVersion());
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
	public void delete(Long userId){
		jdbcTemplate.update(DELETE_SQL, userId);
	}

	@Override
	public void batchSave(List<User> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<User> list){
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
	 * @param userId 用户ID,自增序列
	 * @return User
	 */
	@Override
	public User findById(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`user_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(User.class), userId);
	}

	/**
	 * 根据对象查询
	 * @param user
	 * @return List
	 */
	@Override
	public List<User> find(User user){
		return this.find(user, null, null);
	}

	/**
	 * 根据对象查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<User> find(User user, String[][] orders){
		return this.find(user, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param user
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<User> find(User user, Long offset, Long rows){
		return this.find(user, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<User> find(User user, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(user != null){
			if(user.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(user.getUserId());
			}
			if(user.getUserName() != null && !"".equals(user.getUserName())){
				sql.append(" AND _this.`user_name` = ?");
				param.add(user.getUserName());
			}
			if(user.getPassword() != null && !"".equals(user.getPassword())){
				sql.append(" AND _this.`password` = ?");
				param.add(user.getPassword());
			}
			if(user.getMobile() != null && !"".equals(user.getMobile())){
				sql.append(" AND _this.`mobile` = ?");
				param.add(user.getMobile());
			}
			if(user.getRegIp() != null && !"".equals(user.getRegIp())){
				sql.append(" AND _this.`reg_ip` = ?");
				param.add(user.getRegIp());
			}
			if(user.getType() != null && !"".equals(user.getType())){
				sql.append(" AND _this.`type` = ?");
				param.add(user.getType());
			}
			if(user.getStatus() != null && !"".equals(user.getStatus())){
				sql.append(" AND _this.`status` = ?");
				param.add(user.getStatus());
			}
			if(user.getClientId() != null && !"".equals(user.getClientId())){
				sql.append(" AND _this.`client_id` = ?");
				param.add(user.getClientId());
			}
			if(user.getClientType() != null && !"".equals(user.getClientType())){
				sql.append(" AND _this.`client_type` = ?");
				param.add(user.getClientType());
			}
			if(user.getPushSwitch() != null && !"".equals(user.getPushSwitch())){
				sql.append(" AND _this.`push_switch` = ?");
				param.add(user.getPushSwitch());
			}
			if(user.getLevel() != null){
				sql.append(" AND _this.`level` = ?");
				param.add(user.getLevel());
			}
			if(user.getEmail() != null && !"".equals(user.getEmail())){
				sql.append(" AND _this.`email` = ?");
				param.add(user.getEmail());
			}
			if(user.getUserSource() != null && !"".equals(user.getUserSource())){
				sql.append(" AND _this.`user_source` = ?");
				param.add(user.getUserSource());
			}
			if(user.getQq() != null && !"".equals(user.getQq())){
				sql.append(" AND _this.`qq` = ?");
				param.add(user.getQq());
			}
			if(user.getWeChat() != null && !"".equals(user.getWeChat())){
				sql.append(" AND _this.`we_chat` = ?");
				param.add(user.getWeChat());
			}
			if(user.getWeibo() != null && !"".equals(user.getWeibo())){
				sql.append(" AND _this.`weibo` = ?");
				param.add(user.getWeibo());
			}
			if(user.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(user.getCreateDate());
			}
			if(user.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(user.getUpdateDate());
			}
			if(user.getOpenId() != null && !"".equals(user.getOpenId())){
				sql.append(" AND _this.`open_id` = ?");
				param.add(user.getOpenId());
			}
			if(user.getLastcity() != null && !"".equals(user.getLastcity())){
				sql.append(" AND _this.`lastcity` = ?");
				param.add(user.getLastcity());
			}
			if(user.getVersion() != null){
				sql.append(" AND _this.`version` = ?");
				param.add(user.getVersion());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(User.class));
	}


	/**
	 * 根据对象查询条数
	 * @param user
	 * @return Long
	 */
	@Override
	public Long count(User user){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(user != null){
			if(user.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(user.getUserId());
			}
			if(user.getUserName() != null && !"".equals(user.getUserName())){
				sql.append(" AND _this.`user_name` = ? ");
				param.add(user.getUserName());
			}
			if(user.getPassword() != null && !"".equals(user.getPassword())){
				sql.append(" AND _this.`password` = ? ");
				param.add(user.getPassword());
			}
			if(user.getMobile() != null && !"".equals(user.getMobile())){
				sql.append(" AND _this.`mobile` = ? ");
				param.add(user.getMobile());
			}
			if(user.getRegIp() != null && !"".equals(user.getRegIp())){
				sql.append(" AND _this.`reg_ip` = ? ");
				param.add(user.getRegIp());
			}
			if(user.getType() != null && !"".equals(user.getType())){
				sql.append(" AND _this.`type` = ? ");
				param.add(user.getType());
			}
			if(user.getStatus() != null && !"".equals(user.getStatus())){
				sql.append(" AND _this.`status` = ? ");
				param.add(user.getStatus());
			}
			if(user.getClientId() != null && !"".equals(user.getClientId())){
				sql.append(" AND _this.`client_id` = ? ");
				param.add(user.getClientId());
			}
			if(user.getClientType() != null && !"".equals(user.getClientType())){
				sql.append(" AND _this.`client_type` = ? ");
				param.add(user.getClientType());
			}
			if(user.getPushSwitch() != null && !"".equals(user.getPushSwitch())){
				sql.append(" AND _this.`push_switch` = ? ");
				param.add(user.getPushSwitch());
			}
			if(user.getLevel() != null){
				sql.append(" AND _this.`level` = ? ");
				param.add(user.getLevel());
			}
			if(user.getEmail() != null && !"".equals(user.getEmail())){
				sql.append(" AND _this.`email` = ? ");
				param.add(user.getEmail());
			}
			if(user.getUserSource() != null && !"".equals(user.getUserSource())){
				sql.append(" AND _this.`user_source` = ? ");
				param.add(user.getUserSource());
			}
			if(user.getQq() != null && !"".equals(user.getQq())){
				sql.append(" AND _this.`qq` = ? ");
				param.add(user.getQq());
			}
			if(user.getWeChat() != null && !"".equals(user.getWeChat())){
				sql.append(" AND _this.`we_chat` = ? ");
				param.add(user.getWeChat());
			}
			if(user.getWeibo() != null && !"".equals(user.getWeibo())){
				sql.append(" AND _this.`weibo` = ? ");
				param.add(user.getWeibo());
			}
			if(user.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(user.getCreateDate());
			}
			if(user.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(user.getUpdateDate());
			}
			if(user.getOpenId() != null && !"".equals(user.getOpenId())){
				sql.append(" AND _this.`open_id` = ? ");
				param.add(user.getOpenId());
			}
			if(user.getLastcity() != null && !"".equals(user.getLastcity())){
				sql.append(" AND _this.`lastcity` = ? ");
				param.add(user.getLastcity());
			}
			if(user.getVersion() != null){
				sql.append(" AND _this.`version` = ? ");
				param.add(user.getVersion());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}