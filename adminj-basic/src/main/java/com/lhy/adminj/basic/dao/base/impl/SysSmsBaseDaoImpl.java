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

import com.lhy.adminj.basic.dao.base.SysSmsBaseDao;
import com.lhy.adminj.basic.model.SysSms;

/**
 * 短信信息表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysSmsBaseDaoImpl implements SysSmsBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`sms_id`, _this.`user_id`, _this.`user_phone`, _this.`status`, _this.`sms_desc`, _this.`create_time`, _this.`send_time`, _this.`send_type`, _this.`send_ip`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`sms_id`, _this.`user_id`, _this.`user_phone`, _this.`status`, _this.`sms_desc`, _this.`create_time`, _this.`send_time`, _this.`send_type`, _this.`send_ip` FROM sys_sms _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO sys_sms(`sms_id`, `user_id`, `user_phone`, `status`, `sms_desc`, `create_time`, `send_time`, `send_type`, `send_ip`) VALUES (:sms_id, :user_id, :user_phone, :status, :sms_desc, :create_time, :send_time, :send_type, :send_ip)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE sys_sms SET `sms_id` = :sms_id, `user_id` = :user_id, `user_phone` = :user_phone, `status` = :status, `sms_desc` = :sms_desc, `create_time` = :create_time, `send_time` = :send_time, `send_type` = :send_type, `send_ip` = :send_ip WHERE `sms_id` = :sms_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM sys_sms WHERE `sms_id` = ?";

	@Override
	public void save(SysSms sysSms) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(sysSms);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		sysSms.setSmsId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(SysSms sysSms) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(sysSms);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(SysSms sysSms) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE sys_sms SET ");
		if(sysSms.getSmsId() != null){
			sql.append(" sms_id = ?, ");
			param.add(sysSms.getSmsId());
		}
		if(sysSms.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(sysSms.getUserId());
		}
		if(sysSms.getUserPhone() != null){
			sql.append(" user_phone = ?, ");
			param.add(sysSms.getUserPhone());
		}
		if(sysSms.getStatus() != null){
			sql.append(" status = ?, ");
			param.add(sysSms.getStatus());
		}
		if(sysSms.getSmsDesc() != null){
			sql.append(" sms_desc = ?, ");
			param.add(sysSms.getSmsDesc());
		}
		if(sysSms.getCreateTime() != null){
			sql.append(" create_time = ?, ");
			param.add(sysSms.getCreateTime());
		}
		if(sysSms.getSendTime() != null){
			sql.append(" send_time = ?, ");
			param.add(sysSms.getSendTime());
		}
		if(sysSms.getSendType() != null){
			sql.append(" send_type = ?, ");
			param.add(sysSms.getSendType());
		}
		if(sysSms.getSendIp() != null){
			sql.append(" send_ip = ? ");
			param.add(sysSms.getSendIp());
		}
		sql.append(" WHERE sms_id = ? ");
		param.add(sysSms.getSmsId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param sysSmss
	 * @return
	 */
	public Map<String, Object>[] toMap(List<SysSms> sysSmss){
		Map<String, Object>[] maps = new Map[sysSmss.size()];
		for(int i = 0; i < sysSmss.size(); i++){
			SysSms sysSms = sysSmss.get(i);
			maps[i] = toMap(sysSms);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param sysSms
	 * @return
	 */
	public Map<String, Object> toMap(SysSms sysSms){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("sms_id", sysSms.getSmsId());
        paramMap.put("user_id", sysSms.getUserId());
        paramMap.put("user_phone", sysSms.getUserPhone());
        paramMap.put("status", sysSms.getStatus());
        paramMap.put("sms_desc", sysSms.getSmsDesc());
        paramMap.put("create_time", sysSms.getCreateTime());
        paramMap.put("send_time", sysSms.getSendTime());
        paramMap.put("send_type", sysSms.getSendType());
        paramMap.put("send_ip", sysSms.getSendIp());
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
	public void delete(Long smsId){
		jdbcTemplate.update(DELETE_SQL, smsId);
	}

	@Override
	public void batchSave(List<SysSms> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<SysSms> list){
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
	 * @param smsId 短信ID
	 * @return SysSms
	 */
	@Override
	public SysSms findById(Long smsId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`sms_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(SysSms.class), smsId);
	}

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @return List
	 */
	@Override
	public List<SysSms> find(SysSms sysSms){
		return this.find(sysSms, null, null);
	}

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<SysSms> find(SysSms sysSms, String[][] orders){
		return this.find(sysSms, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param sysSms
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<SysSms> find(SysSms sysSms, Long offset, Long rows){
		return this.find(sysSms, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param sysSms
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<SysSms> find(SysSms sysSms, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(sysSms != null){
			if(sysSms.getSmsId() != null){
				sql.append(" AND _this.`sms_id` = ?");
				param.add(sysSms.getSmsId());
			}
			if(sysSms.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(sysSms.getUserId());
			}
			if(sysSms.getUserPhone() != null && !"".equals(sysSms.getUserPhone())){
				sql.append(" AND _this.`user_phone` = ?");
				param.add(sysSms.getUserPhone());
			}
			if(sysSms.getStatus() != null && !"".equals(sysSms.getStatus())){
				sql.append(" AND _this.`status` = ?");
				param.add(sysSms.getStatus());
			}
			if(sysSms.getSmsDesc() != null && !"".equals(sysSms.getSmsDesc())){
				sql.append(" AND _this.`sms_desc` = ?");
				param.add(sysSms.getSmsDesc());
			}
			if(sysSms.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(sysSms.getCreateTime());
			}
			if(sysSms.getSendTime() != null){
				sql.append(" AND _this.`send_time` = ?");
				param.add(sysSms.getSendTime());
			}
			if(sysSms.getSendType() != null && !"".equals(sysSms.getSendType())){
				sql.append(" AND _this.`send_type` = ?");
				param.add(sysSms.getSendType());
			}
			if(sysSms.getSendIp() != null && !"".equals(sysSms.getSendIp())){
				sql.append(" AND _this.`send_ip` = ?");
				param.add(sysSms.getSendIp());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(SysSms.class));
	}


	/**
	 * 根据对象查询条数
	 * @param sysSms
	 * @return Long
	 */
	@Override
	public Long count(SysSms sysSms){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM sys_sms  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(sysSms != null){
			if(sysSms.getSmsId() != null){
				sql.append(" AND _this.`sms_id` = ? ");
				param.add(sysSms.getSmsId());
			}
			if(sysSms.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(sysSms.getUserId());
			}
			if(sysSms.getUserPhone() != null && !"".equals(sysSms.getUserPhone())){
				sql.append(" AND _this.`user_phone` = ? ");
				param.add(sysSms.getUserPhone());
			}
			if(sysSms.getStatus() != null && !"".equals(sysSms.getStatus())){
				sql.append(" AND _this.`status` = ? ");
				param.add(sysSms.getStatus());
			}
			if(sysSms.getSmsDesc() != null && !"".equals(sysSms.getSmsDesc())){
				sql.append(" AND _this.`sms_desc` = ? ");
				param.add(sysSms.getSmsDesc());
			}
			if(sysSms.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(sysSms.getCreateTime());
			}
			if(sysSms.getSendTime() != null){
				sql.append(" AND _this.`send_time` = ? ");
				param.add(sysSms.getSendTime());
			}
			if(sysSms.getSendType() != null && !"".equals(sysSms.getSendType())){
				sql.append(" AND _this.`send_type` = ? ");
				param.add(sysSms.getSendType());
			}
			if(sysSms.getSendIp() != null && !"".equals(sysSms.getSendIp())){
				sql.append(" AND _this.`send_ip` = ? ");
				param.add(sysSms.getSendIp());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}