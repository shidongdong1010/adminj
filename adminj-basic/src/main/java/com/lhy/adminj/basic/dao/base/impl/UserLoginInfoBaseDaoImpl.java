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

import com.lhy.adminj.basic.dao.base.UserLoginInfoBaseDao;
import com.lhy.adminj.basic.model.UserLoginInfo;

/**
 * 用户登陆日志Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserLoginInfoBaseDaoImpl implements UserLoginInfoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`login_id`, _this.`user_id`, _this.`user_name`, _this.`login_ip`, _this.`client_id`, _this.`client_type`, _this.`create_date`, _this.`login_continue_num`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`login_id`, _this.`user_id`, _this.`user_name`, _this.`login_ip`, _this.`client_id`, _this.`client_type`, _this.`create_date`, _this.`login_continue_num` FROM umc_user_login_info _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_login_info(`login_id`, `user_id`, `user_name`, `login_ip`, `client_id`, `client_type`, `create_date`, `login_continue_num`) VALUES (:login_id, :user_id, :user_name, :login_ip, :client_id, :client_type, :create_date, :login_continue_num)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_login_info SET `login_id` = :login_id, `user_id` = :user_id, `user_name` = :user_name, `login_ip` = :login_ip, `client_id` = :client_id, `client_type` = :client_type, `create_date` = :create_date, `login_continue_num` = :login_continue_num WHERE `login_id` = :login_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_login_info WHERE `login_id` = ?";

	@Override
	public void save(UserLoginInfo userLoginInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userLoginInfo);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userLoginInfo.setLoginId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserLoginInfo userLoginInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userLoginInfo);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserLoginInfo userLoginInfo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_login_info SET ");
		if(userLoginInfo.getLoginId() != null){
			sql.append(" login_id = ?, ");
			param.add(userLoginInfo.getLoginId());
		}
		if(userLoginInfo.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userLoginInfo.getUserId());
		}
		if(userLoginInfo.getUserName() != null){
			sql.append(" user_name = ?, ");
			param.add(userLoginInfo.getUserName());
		}
		if(userLoginInfo.getLoginIp() != null){
			sql.append(" login_ip = ?, ");
			param.add(userLoginInfo.getLoginIp());
		}
		if(userLoginInfo.getClientId() != null){
			sql.append(" client_id = ?, ");
			param.add(userLoginInfo.getClientId());
		}
		if(userLoginInfo.getClientType() != null){
			sql.append(" client_type = ?, ");
			param.add(userLoginInfo.getClientType());
		}
		if(userLoginInfo.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userLoginInfo.getCreateDate());
		}
		if(userLoginInfo.getLoginContinueNum() != null){
			sql.append(" login_continue_num = ? ");
			param.add(userLoginInfo.getLoginContinueNum());
		}
		sql.append(" WHERE login_id = ? ");
		param.add(userLoginInfo.getLoginId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userLoginInfos
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserLoginInfo> userLoginInfos){
		Map<String, Object>[] maps = new Map[userLoginInfos.size()];
		for(int i = 0; i < userLoginInfos.size(); i++){
			UserLoginInfo userLoginInfo = userLoginInfos.get(i);
			maps[i] = toMap(userLoginInfo);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userLoginInfo
	 * @return
	 */
	public Map<String, Object> toMap(UserLoginInfo userLoginInfo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("login_id", userLoginInfo.getLoginId());
        paramMap.put("user_id", userLoginInfo.getUserId());
        paramMap.put("user_name", userLoginInfo.getUserName());
        paramMap.put("login_ip", userLoginInfo.getLoginIp());
        paramMap.put("client_id", userLoginInfo.getClientId());
        paramMap.put("client_type", userLoginInfo.getClientType());
        paramMap.put("create_date", userLoginInfo.getCreateDate());
        paramMap.put("login_continue_num", userLoginInfo.getLoginContinueNum());
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
	public void delete(Long loginId){
		jdbcTemplate.update(DELETE_SQL, loginId);
	}

	@Override
	public void batchSave(List<UserLoginInfo> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserLoginInfo> list){
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
	 * @param loginId 登陆表主键
	 * @return UserLoginInfo
	 */
	@Override
	public UserLoginInfo findById(Long loginId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`login_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserLoginInfo.class), loginId);
	}

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @return List
	 */
	@Override
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo){
		return this.find(userLoginInfo, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, String[][] orders){
		return this.find(userLoginInfo, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userLoginInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, Long offset, Long rows){
		return this.find(userLoginInfo, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userLoginInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserLoginInfo> find(UserLoginInfo userLoginInfo, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userLoginInfo != null){
			if(userLoginInfo.getLoginId() != null){
				sql.append(" AND _this.`login_id` = ?");
				param.add(userLoginInfo.getLoginId());
			}
			if(userLoginInfo.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userLoginInfo.getUserId());
			}
			if(userLoginInfo.getUserName() != null && !"".equals(userLoginInfo.getUserName())){
				sql.append(" AND _this.`user_name` = ?");
				param.add(userLoginInfo.getUserName());
			}
			if(userLoginInfo.getLoginIp() != null && !"".equals(userLoginInfo.getLoginIp())){
				sql.append(" AND _this.`login_ip` = ?");
				param.add(userLoginInfo.getLoginIp());
			}
			if(userLoginInfo.getClientId() != null && !"".equals(userLoginInfo.getClientId())){
				sql.append(" AND _this.`client_id` = ?");
				param.add(userLoginInfo.getClientId());
			}
			if(userLoginInfo.getClientType() != null){
				sql.append(" AND _this.`client_type` = ?");
				param.add(userLoginInfo.getClientType());
			}
			if(userLoginInfo.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userLoginInfo.getCreateDate());
			}
			if(userLoginInfo.getLoginContinueNum() != null){
				sql.append(" AND _this.`login_continue_num` = ?");
				param.add(userLoginInfo.getLoginContinueNum());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserLoginInfo.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userLoginInfo
	 * @return Long
	 */
	@Override
	public Long count(UserLoginInfo userLoginInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_login_info  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userLoginInfo != null){
			if(userLoginInfo.getLoginId() != null){
				sql.append(" AND _this.`login_id` = ? ");
				param.add(userLoginInfo.getLoginId());
			}
			if(userLoginInfo.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userLoginInfo.getUserId());
			}
			if(userLoginInfo.getUserName() != null && !"".equals(userLoginInfo.getUserName())){
				sql.append(" AND _this.`user_name` = ? ");
				param.add(userLoginInfo.getUserName());
			}
			if(userLoginInfo.getLoginIp() != null && !"".equals(userLoginInfo.getLoginIp())){
				sql.append(" AND _this.`login_ip` = ? ");
				param.add(userLoginInfo.getLoginIp());
			}
			if(userLoginInfo.getClientId() != null && !"".equals(userLoginInfo.getClientId())){
				sql.append(" AND _this.`client_id` = ? ");
				param.add(userLoginInfo.getClientId());
			}
			if(userLoginInfo.getClientType() != null){
				sql.append(" AND _this.`client_type` = ? ");
				param.add(userLoginInfo.getClientType());
			}
			if(userLoginInfo.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userLoginInfo.getCreateDate());
			}
			if(userLoginInfo.getLoginContinueNum() != null){
				sql.append(" AND _this.`login_continue_num` = ? ");
				param.add(userLoginInfo.getLoginContinueNum());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}