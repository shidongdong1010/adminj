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

import com.lhy.adminj.basic.dao.base.UserKhnoBaseDao;
import com.lhy.adminj.basic.model.UserKhno;

/**
 * 用户卷商表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserKhnoBaseDaoImpl implements UserKhnoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`id`, _this.`brokerid`, _this.`khno`, _this.`userid`, _this.`create_time`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`id`, _this.`brokerid`, _this.`khno`, _this.`userid`, _this.`create_time`, _this.`is_del` FROM smc_user_khno _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO smc_user_khno(`id`, `brokerid`, `khno`, `userid`, `create_time`, `is_del`) VALUES (:id, :brokerid, :khno, :userid, :create_time, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE smc_user_khno SET `id` = :id, `brokerid` = :brokerid, `khno` = :khno, `userid` = :userid, `create_time` = :create_time, `is_del` = :is_del WHERE `id` = :id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM smc_user_khno WHERE `id` = ?";

	@Override
	public void save(UserKhno userKhno) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userKhno);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userKhno.setId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserKhno userKhno) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userKhno);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserKhno userKhno) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE smc_user_khno SET ");
		if(userKhno.getId() != null){
			sql.append(" id = ?, ");
			param.add(userKhno.getId());
		}
		if(userKhno.getBrokerid() != null){
			sql.append(" brokerid = ?, ");
			param.add(userKhno.getBrokerid());
		}
		if(userKhno.getKhno() != null){
			sql.append(" khno = ?, ");
			param.add(userKhno.getKhno());
		}
		if(userKhno.getUserid() != null){
			sql.append(" userid = ?, ");
			param.add(userKhno.getUserid());
		}
		if(userKhno.getCreateTime() != null){
			sql.append(" create_time = ?, ");
			param.add(userKhno.getCreateTime());
		}
		if(userKhno.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(userKhno.getIsDel());
		}
		sql.append(" WHERE id = ? ");
		param.add(userKhno.getId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userKhnos
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserKhno> userKhnos){
		Map<String, Object>[] maps = new Map[userKhnos.size()];
		for(int i = 0; i < userKhnos.size(); i++){
			UserKhno userKhno = userKhnos.get(i);
			maps[i] = toMap(userKhno);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userKhno
	 * @return
	 */
	public Map<String, Object> toMap(UserKhno userKhno){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", userKhno.getId());
        paramMap.put("brokerid", userKhno.getBrokerid());
        paramMap.put("khno", userKhno.getKhno());
        paramMap.put("userid", userKhno.getUserid());
        paramMap.put("create_time", userKhno.getCreateTime());
        paramMap.put("is_del", userKhno.getIsDel());
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
	public void delete(Long id){
		jdbcTemplate.update(DELETE_SQL, id);
	}

	@Override
	public void batchSave(List<UserKhno> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserKhno> list){
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
	 * @param id ID
	 * @return UserKhno
	 */
	@Override
	public UserKhno findById(Long id){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserKhno.class), id);
	}

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @return List
	 */
	@Override
	public List<UserKhno> find(UserKhno userKhno){
		return this.find(userKhno, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserKhno> find(UserKhno userKhno, String[][] orders){
		return this.find(userKhno, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userKhno
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserKhno> find(UserKhno userKhno, Long offset, Long rows){
		return this.find(userKhno, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userKhno
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserKhno> find(UserKhno userKhno, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userKhno != null){
			if(userKhno.getId() != null){
				sql.append(" AND _this.`id` = ?");
				param.add(userKhno.getId());
			}
			if(userKhno.getBrokerid() != null){
				sql.append(" AND _this.`brokerid` = ?");
				param.add(userKhno.getBrokerid());
			}
			if(userKhno.getKhno() != null && !"".equals(userKhno.getKhno())){
				sql.append(" AND _this.`khno` = ?");
				param.add(userKhno.getKhno());
			}
			if(userKhno.getUserid() != null){
				sql.append(" AND _this.`userid` = ?");
				param.add(userKhno.getUserid());
			}
			if(userKhno.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ?");
				param.add(userKhno.getCreateTime());
			}
			if(userKhno.getIsDel() != null && !"".equals(userKhno.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userKhno.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserKhno.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userKhno
	 * @return Long
	 */
	@Override
	public Long count(UserKhno userKhno){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM smc_user_khno  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userKhno != null){
			if(userKhno.getId() != null){
				sql.append(" AND _this.`id` = ? ");
				param.add(userKhno.getId());
			}
			if(userKhno.getBrokerid() != null){
				sql.append(" AND _this.`brokerid` = ? ");
				param.add(userKhno.getBrokerid());
			}
			if(userKhno.getKhno() != null && !"".equals(userKhno.getKhno())){
				sql.append(" AND _this.`khno` = ? ");
				param.add(userKhno.getKhno());
			}
			if(userKhno.getUserid() != null){
				sql.append(" AND _this.`userid` = ? ");
				param.add(userKhno.getUserid());
			}
			if(userKhno.getCreateTime() != null){
				sql.append(" AND _this.`create_time` = ? ");
				param.add(userKhno.getCreateTime());
			}
			if(userKhno.getIsDel() != null && !"".equals(userKhno.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userKhno.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}