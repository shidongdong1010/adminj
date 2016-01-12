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

import com.lhy.adminj.basic.dao.base.AdvertisingInfoBaseDao;
import com.lhy.adminj.basic.model.AdvertisingInfo;

/**
 * 广告信息表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class AdvertisingInfoBaseDaoImpl implements AdvertisingInfoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`advertising_id`, _this.`advertising_url`, _this.`advertising_logo`, _this.`advertising_create_id`, _this.`create_time`, _this.`advertising_update_id`, _this.`update_time`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`advertising_id`, _this.`advertising_url`, _this.`advertising_logo`, _this.`advertising_create_id`, _this.`create_time`, _this.`advertising_update_id`, _this.`update_time`, _this.`is_del` FROM umc_advertising_info _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_advertising_info(`advertising_id`, `advertising_url`, `advertising_logo`, `advertising_create_id`, `create_time`, `advertising_update_id`, `update_time`, `is_del`) VALUES (:advertising_id, :advertising_url, :advertising_logo, :advertising_create_id, :create_time, :advertising_update_id, :update_time, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_advertising_info SET `advertising_id` = :advertising_id, `advertising_url` = :advertising_url, `advertising_logo` = :advertising_logo, `advertising_create_id` = :advertising_create_id, `create_time` = :create_time, `advertising_update_id` = :advertising_update_id, `update_time` = :update_time, `is_del` = :is_del WHERE `advertising_id` = :advertising_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_advertising_info WHERE `advertising_id` = ?";

	@Override
	public void save(AdvertisingInfo advertisingInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(advertisingInfo);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		advertisingInfo.setAdvertisingId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(AdvertisingInfo advertisingInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(advertisingInfo);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(AdvertisingInfo advertisingInfo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_advertising_info SET ");
		if(advertisingInfo.getAdvertisingId() != null){
			sql.append(" advertising_id = ?, ");
			param.add(advertisingInfo.getAdvertisingId());
		}
		if(advertisingInfo.getAdvertisingUrl() != null){
			sql.append(" advertising_url = ?, ");
			param.add(advertisingInfo.getAdvertisingUrl());
		}
		if(advertisingInfo.getAdvertisingLogo() != null){
			sql.append(" advertising_logo = ?, ");
			param.add(advertisingInfo.getAdvertisingLogo());
		}
		if(advertisingInfo.getAdvertisingCreateId() != null){
			sql.append(" advertising_create_id = ?, ");
			param.add(advertisingInfo.getAdvertisingCreateId());
		}
		if(advertisingInfo.getCreateTime() != null){
			sql.append(" create_time = ?, ");
			param.add(advertisingInfo.getCreateTime());
		}
		if(advertisingInfo.getAdvertisingUpdateId() != null){
			sql.append(" advertising_update_id = ?, ");
			param.add(advertisingInfo.getAdvertisingUpdateId());
		}
		if(advertisingInfo.getUpdateTime() != null){
			sql.append(" update_time = ?, ");
			param.add(advertisingInfo.getUpdateTime());
		}
		if(advertisingInfo.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(advertisingInfo.getIsDel());
		}
		sql.append(" WHERE advertising_id = ? ");
		param.add(advertisingInfo.getAdvertisingId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param advertisingInfos
	 * @return
	 */
	public Map<String, Object>[] toMap(List<AdvertisingInfo> advertisingInfos){
		Map<String, Object>[] maps = new Map[advertisingInfos.size()];
		for(int i = 0; i < advertisingInfos.size(); i++){
			AdvertisingInfo advertisingInfo = advertisingInfos.get(i);
			maps[i] = toMap(advertisingInfo);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param advertisingInfo
	 * @return
	 */
	public Map<String, Object> toMap(AdvertisingInfo advertisingInfo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("advertising_id", advertisingInfo.getAdvertisingId());
        paramMap.put("advertising_url", advertisingInfo.getAdvertisingUrl());
        paramMap.put("advertising_logo", advertisingInfo.getAdvertisingLogo());
        paramMap.put("advertising_create_id", advertisingInfo.getAdvertisingCreateId());
        paramMap.put("create_time", advertisingInfo.getCreateTime());
        paramMap.put("advertising_update_id", advertisingInfo.getAdvertisingUpdateId());
        paramMap.put("update_time", advertisingInfo.getUpdateTime());
        paramMap.put("is_del", advertisingInfo.getIsDel());
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
	public void delete(Long advertisingId){
		jdbcTemplate.update(DELETE_SQL, advertisingId);
	}

	@Override
	public void batchSave(List<AdvertisingInfo> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<AdvertisingInfo> list){
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
	 * @param advertisingId 广告信息ID
	 * @return AdvertisingInfo
	 */
	@Override
	public AdvertisingInfo findById(Long advertisingId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`advertising_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(AdvertisingInfo.class), advertisingId);
	}

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @return List
	 */
	@Override
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo){
		return this.find(advertisingInfo, null, null);
	}

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, String[][] orders){
		return this.find(advertisingInfo, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param advertisingInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, Long offset, Long rows){
		return this.find(advertisingInfo, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param advertisingInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<AdvertisingInfo> find(AdvertisingInfo advertisingInfo, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(advertisingInfo != null){
			if(advertisingInfo.getAdvertisingId() != null){
				sql.append(" AND _this.`advertising_id` = ?");
				param.add(advertisingInfo.getAdvertisingId());
			}
			if(advertisingInfo.getAdvertisingUrl() != null && !"".equals(advertisingInfo.getAdvertisingUrl())){
				sql.append(" AND _this.`advertising_url` = ?");
				param.add(advertisingInfo.getAdvertisingUrl());
			}
			if(advertisingInfo.getAdvertisingLogo() != null && !"".equals(advertisingInfo.getAdvertisingLogo())){
				sql.append(" AND _this.`advertising_logo` = ?");
				param.add(advertisingInfo.getAdvertisingLogo());
			}
			if(advertisingInfo.getAdvertisingCreateId() != null){
				sql.append(" AND _this.`advertising_create_id` = ?");
				param.add(advertisingInfo.getAdvertisingCreateId());
			}
			if(advertisingInfo.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(advertisingInfo.getCreateTime());
			}
			if(advertisingInfo.getAdvertisingUpdateId() != null){
				sql.append(" AND _this.`advertising_update_id` = ?");
				param.add(advertisingInfo.getAdvertisingUpdateId());
			}
			if(advertisingInfo.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ?");
				param.add(advertisingInfo.getUpdateTime());
			}
			if(advertisingInfo.getIsDel() != null && !"".equals(advertisingInfo.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(advertisingInfo.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(AdvertisingInfo.class));
	}


	/**
	 * 根据对象查询条数
	 * @param advertisingInfo
	 * @return Long
	 */
	@Override
	public Long count(AdvertisingInfo advertisingInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_advertising_info  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(advertisingInfo != null){
			if(advertisingInfo.getAdvertisingId() != null){
				sql.append(" AND _this.`advertising_id` = ? ");
				param.add(advertisingInfo.getAdvertisingId());
			}
			if(advertisingInfo.getAdvertisingUrl() != null && !"".equals(advertisingInfo.getAdvertisingUrl())){
				sql.append(" AND _this.`advertising_url` = ? ");
				param.add(advertisingInfo.getAdvertisingUrl());
			}
			if(advertisingInfo.getAdvertisingLogo() != null && !"".equals(advertisingInfo.getAdvertisingLogo())){
				sql.append(" AND _this.`advertising_logo` = ? ");
				param.add(advertisingInfo.getAdvertisingLogo());
			}
			if(advertisingInfo.getAdvertisingCreateId() != null){
				sql.append(" AND _this.`advertising_create_id` = ? ");
				param.add(advertisingInfo.getAdvertisingCreateId());
			}
			if(advertisingInfo.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(advertisingInfo.getCreateTime());
			}
			if(advertisingInfo.getAdvertisingUpdateId() != null){
				sql.append(" AND _this.`advertising_update_id` = ? ");
				param.add(advertisingInfo.getAdvertisingUpdateId());
			}
			if(advertisingInfo.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ? ");
				param.add(advertisingInfo.getUpdateTime());
			}
			if(advertisingInfo.getIsDel() != null && !"".equals(advertisingInfo.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(advertisingInfo.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}