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

import com.lhy.adminj.basic.dao.base.AnnouncementInfoBaseDao;
import com.lhy.adminj.basic.model.AnnouncementInfo;

/**
 * 公告信息表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class AnnouncementInfoBaseDaoImpl implements AnnouncementInfoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`announcement_id`, _this.`announcement_title`, _this.`announcement_logo`, _this.`announcement_url`, _this.`announcement_desc`, _this.`announcement_create_id`, _this.`create_time`, _this.`announcement_update_id`, _this.`update_time`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`announcement_id`, _this.`announcement_title`, _this.`announcement_logo`, _this.`announcement_url`, _this.`announcement_desc`, _this.`announcement_create_id`, _this.`create_time`, _this.`announcement_update_id`, _this.`update_time`, _this.`is_del` FROM umc_announcement_info _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_announcement_info(`announcement_id`, `announcement_title`, `announcement_logo`, `announcement_url`, `announcement_desc`, `announcement_create_id`, `create_time`, `announcement_update_id`, `update_time`, `is_del`) VALUES (:announcement_id, :announcement_title, :announcement_logo, :announcement_url, :announcement_desc, :announcement_create_id, :create_time, :announcement_update_id, :update_time, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_announcement_info SET `announcement_id` = :announcement_id, `announcement_title` = :announcement_title, `announcement_logo` = :announcement_logo, `announcement_url` = :announcement_url, `announcement_desc` = :announcement_desc, `announcement_create_id` = :announcement_create_id, `create_time` = :create_time, `announcement_update_id` = :announcement_update_id, `update_time` = :update_time, `is_del` = :is_del WHERE `announcement_id` = :announcement_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_announcement_info WHERE `announcement_id` = ?";

	@Override
	public void save(AnnouncementInfo announcementInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(announcementInfo);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		announcementInfo.setAnnouncementId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(AnnouncementInfo announcementInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(announcementInfo);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(AnnouncementInfo announcementInfo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_announcement_info SET ");
		if(announcementInfo.getAnnouncementId() != null){
			sql.append(" announcement_id = ?, ");
			param.add(announcementInfo.getAnnouncementId());
		}
		if(announcementInfo.getAnnouncementTitle() != null){
			sql.append(" announcement_title = ?, ");
			param.add(announcementInfo.getAnnouncementTitle());
		}
		if(announcementInfo.getAnnouncementLogo() != null){
			sql.append(" announcement_logo = ?, ");
			param.add(announcementInfo.getAnnouncementLogo());
		}
		if(announcementInfo.getAnnouncementUrl() != null){
			sql.append(" announcement_url = ?, ");
			param.add(announcementInfo.getAnnouncementUrl());
		}
		if(announcementInfo.getAnnouncementDesc() != null){
			sql.append(" announcement_desc = ?, ");
			param.add(announcementInfo.getAnnouncementDesc());
		}
		if(announcementInfo.getAnnouncementCreateId() != null){
			sql.append(" announcement_create_id = ?, ");
			param.add(announcementInfo.getAnnouncementCreateId());
		}
		if(announcementInfo.getCreateTime() != null){
			sql.append(" create_time = ?, ");
			param.add(announcementInfo.getCreateTime());
		}
		if(announcementInfo.getAnnouncementUpdateId() != null){
			sql.append(" announcement_update_id = ?, ");
			param.add(announcementInfo.getAnnouncementUpdateId());
		}
		if(announcementInfo.getUpdateTime() != null){
			sql.append(" update_time = ?, ");
			param.add(announcementInfo.getUpdateTime());
		}
		if(announcementInfo.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(announcementInfo.getIsDel());
		}
		sql.append(" WHERE announcement_id = ? ");
		param.add(announcementInfo.getAnnouncementId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param announcementInfos
	 * @return
	 */
	public Map<String, Object>[] toMap(List<AnnouncementInfo> announcementInfos){
		Map<String, Object>[] maps = new Map[announcementInfos.size()];
		for(int i = 0; i < announcementInfos.size(); i++){
			AnnouncementInfo announcementInfo = announcementInfos.get(i);
			maps[i] = toMap(announcementInfo);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param announcementInfo
	 * @return
	 */
	public Map<String, Object> toMap(AnnouncementInfo announcementInfo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("announcement_id", announcementInfo.getAnnouncementId());
        paramMap.put("announcement_title", announcementInfo.getAnnouncementTitle());
        paramMap.put("announcement_logo", announcementInfo.getAnnouncementLogo());
        paramMap.put("announcement_url", announcementInfo.getAnnouncementUrl());
        paramMap.put("announcement_desc", announcementInfo.getAnnouncementDesc());
        paramMap.put("announcement_create_id", announcementInfo.getAnnouncementCreateId());
        paramMap.put("create_time", announcementInfo.getCreateTime());
        paramMap.put("announcement_update_id", announcementInfo.getAnnouncementUpdateId());
        paramMap.put("update_time", announcementInfo.getUpdateTime());
        paramMap.put("is_del", announcementInfo.getIsDel());
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
	public void delete(Long announcementId){
		jdbcTemplate.update(DELETE_SQL, announcementId);
	}

	@Override
	public void batchSave(List<AnnouncementInfo> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<AnnouncementInfo> list){
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
	 * @param announcementId 公告信息ID
	 * @return AnnouncementInfo
	 */
	@Override
	public AnnouncementInfo findById(Long announcementId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`announcement_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(AnnouncementInfo.class), announcementId);
	}

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @return List
	 */
	@Override
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo){
		return this.find(announcementInfo, null, null);
	}

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, String[][] orders){
		return this.find(announcementInfo, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param announcementInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, Long offset, Long rows){
		return this.find(announcementInfo, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param announcementInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<AnnouncementInfo> find(AnnouncementInfo announcementInfo, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(announcementInfo != null){
			if(announcementInfo.getAnnouncementId() != null){
				sql.append(" AND _this.`announcement_id` = ?");
				param.add(announcementInfo.getAnnouncementId());
			}
			if(announcementInfo.getAnnouncementTitle() != null && !"".equals(announcementInfo.getAnnouncementTitle())){
				sql.append(" AND _this.`announcement_title` = ?");
				param.add(announcementInfo.getAnnouncementTitle());
			}
			if(announcementInfo.getAnnouncementLogo() != null && !"".equals(announcementInfo.getAnnouncementLogo())){
				sql.append(" AND _this.`announcement_logo` = ?");
				param.add(announcementInfo.getAnnouncementLogo());
			}
			if(announcementInfo.getAnnouncementUrl() != null && !"".equals(announcementInfo.getAnnouncementUrl())){
				sql.append(" AND _this.`announcement_url` = ?");
				param.add(announcementInfo.getAnnouncementUrl());
			}
			if(announcementInfo.getAnnouncementDesc() != null && !"".equals(announcementInfo.getAnnouncementDesc())){
				sql.append(" AND _this.`announcement_desc` = ?");
				param.add(announcementInfo.getAnnouncementDesc());
			}
			if(announcementInfo.getAnnouncementCreateId() != null){
				sql.append(" AND _this.`announcement_create_id` = ?");
				param.add(announcementInfo.getAnnouncementCreateId());
			}
			if(announcementInfo.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(announcementInfo.getCreateTime());
			}
			if(announcementInfo.getAnnouncementUpdateId() != null){
				sql.append(" AND _this.`announcement_update_id` = ?");
				param.add(announcementInfo.getAnnouncementUpdateId());
			}
			if(announcementInfo.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ?");
				param.add(announcementInfo.getUpdateTime());
			}
			if(announcementInfo.getIsDel() != null && !"".equals(announcementInfo.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(announcementInfo.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(AnnouncementInfo.class));
	}


	/**
	 * 根据对象查询条数
	 * @param announcementInfo
	 * @return Long
	 */
	@Override
	public Long count(AnnouncementInfo announcementInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_announcement_info  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(announcementInfo != null){
			if(announcementInfo.getAnnouncementId() != null){
				sql.append(" AND _this.`announcement_id` = ? ");
				param.add(announcementInfo.getAnnouncementId());
			}
			if(announcementInfo.getAnnouncementTitle() != null && !"".equals(announcementInfo.getAnnouncementTitle())){
				sql.append(" AND _this.`announcement_title` = ? ");
				param.add(announcementInfo.getAnnouncementTitle());
			}
			if(announcementInfo.getAnnouncementLogo() != null && !"".equals(announcementInfo.getAnnouncementLogo())){
				sql.append(" AND _this.`announcement_logo` = ? ");
				param.add(announcementInfo.getAnnouncementLogo());
			}
			if(announcementInfo.getAnnouncementUrl() != null && !"".equals(announcementInfo.getAnnouncementUrl())){
				sql.append(" AND _this.`announcement_url` = ? ");
				param.add(announcementInfo.getAnnouncementUrl());
			}
			if(announcementInfo.getAnnouncementDesc() != null && !"".equals(announcementInfo.getAnnouncementDesc())){
				sql.append(" AND _this.`announcement_desc` = ? ");
				param.add(announcementInfo.getAnnouncementDesc());
			}
			if(announcementInfo.getAnnouncementCreateId() != null){
				sql.append(" AND _this.`announcement_create_id` = ? ");
				param.add(announcementInfo.getAnnouncementCreateId());
			}
			if(announcementInfo.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(announcementInfo.getCreateTime());
			}
			if(announcementInfo.getAnnouncementUpdateId() != null){
				sql.append(" AND _this.`announcement_update_id` = ? ");
				param.add(announcementInfo.getAnnouncementUpdateId());
			}
			if(announcementInfo.getUpdateTime() != null){
				sql.append(" AND _this.`update_time` = ? ");
				param.add(announcementInfo.getUpdateTime());
			}
			if(announcementInfo.getIsDel() != null && !"".equals(announcementInfo.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(announcementInfo.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}