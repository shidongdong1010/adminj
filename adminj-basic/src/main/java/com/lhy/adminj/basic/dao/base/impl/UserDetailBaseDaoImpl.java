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

import com.lhy.adminj.basic.dao.base.UserDetailBaseDao;
import com.lhy.adminj.basic.model.UserDetail;

/**
 * 用户简介表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDetailBaseDaoImpl implements UserDetailBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`user_id`, _this.`nick_name`, _this.`sex`, _this.`age`, _this.`head_img_path`, _this.`company_duties`, _this.`city_code`, _this.`city_name`, _this.`province_code`, _this.`province_name`, _this.`resume`, _this.`signature`, _this.`create_date`, _this.`update_date`, _this.`is_perfect_data`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`user_id`, _this.`nick_name`, _this.`sex`, _this.`age`, _this.`head_img_path`, _this.`company_duties`, _this.`city_code`, _this.`city_name`, _this.`province_code`, _this.`province_name`, _this.`resume`, _this.`signature`, _this.`create_date`, _this.`update_date`, _this.`is_perfect_data` FROM umc_user_detail _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_detail(`user_id`, `nick_name`, `sex`, `age`, `head_img_path`, `company_duties`, `city_code`, `city_name`, `province_code`, `province_name`, `resume`, `signature`, `create_date`, `update_date`, `is_perfect_data`) VALUES (:user_id, :nick_name, :sex, :age, :head_img_path, :company_duties, :city_code, :city_name, :province_code, :province_name, :resume, :signature, :create_date, :update_date, :is_perfect_data)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_detail SET `user_id` = :user_id, `nick_name` = :nick_name, `sex` = :sex, `age` = :age, `head_img_path` = :head_img_path, `company_duties` = :company_duties, `city_code` = :city_code, `city_name` = :city_name, `province_code` = :province_code, `province_name` = :province_name, `resume` = :resume, `signature` = :signature, `create_date` = :create_date, `update_date` = :update_date, `is_perfect_data` = :is_perfect_data WHERE `user_id` = :user_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_detail WHERE `user_id` = ?";

	@Override
	public void save(UserDetail userDetail) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDetail);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userDetail.setUserId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserDetail userDetail) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDetail);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserDetail userDetail) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_detail SET ");
		if(userDetail.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userDetail.getUserId());
		}
		if(userDetail.getNickName() != null){
			sql.append(" nick_name = ?, ");
			param.add(userDetail.getNickName());
		}
		if(userDetail.getSex() != null){
			sql.append(" sex = ?, ");
			param.add(userDetail.getSex());
		}
		if(userDetail.getAge() != null){
			sql.append(" age = ?, ");
			param.add(userDetail.getAge());
		}
		if(userDetail.getHeadImgPath() != null){
			sql.append(" head_img_path = ?, ");
			param.add(userDetail.getHeadImgPath());
		}
		if(userDetail.getCompanyDuties() != null){
			sql.append(" company_duties = ?, ");
			param.add(userDetail.getCompanyDuties());
		}
		if(userDetail.getCityCode() != null){
			sql.append(" city_code = ?, ");
			param.add(userDetail.getCityCode());
		}
		if(userDetail.getCityName() != null){
			sql.append(" city_name = ?, ");
			param.add(userDetail.getCityName());
		}
		if(userDetail.getProvinceCode() != null){
			sql.append(" province_code = ?, ");
			param.add(userDetail.getProvinceCode());
		}
		if(userDetail.getProvinceName() != null){
			sql.append(" province_name = ?, ");
			param.add(userDetail.getProvinceName());
		}
		if(userDetail.getResume() != null){
			sql.append(" resume = ?, ");
			param.add(userDetail.getResume());
		}
		if(userDetail.getSignature() != null){
			sql.append(" signature = ?, ");
			param.add(userDetail.getSignature());
		}
		if(userDetail.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userDetail.getCreateDate());
		}
		if(userDetail.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userDetail.getUpdateDate());
		}
		if(userDetail.getIsPerfectData() != null){
			sql.append(" is_perfect_data = ? ");
			param.add(userDetail.getIsPerfectData());
		}
		sql.append(" WHERE user_id = ? ");
		param.add(userDetail.getUserId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userDetails
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserDetail> userDetails){
		Map<String, Object>[] maps = new Map[userDetails.size()];
		for(int i = 0; i < userDetails.size(); i++){
			UserDetail userDetail = userDetails.get(i);
			maps[i] = toMap(userDetail);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userDetail
	 * @return
	 */
	public Map<String, Object> toMap(UserDetail userDetail){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userDetail.getUserId());
        paramMap.put("nick_name", userDetail.getNickName());
        paramMap.put("sex", userDetail.getSex());
        paramMap.put("age", userDetail.getAge());
        paramMap.put("head_img_path", userDetail.getHeadImgPath());
        paramMap.put("company_duties", userDetail.getCompanyDuties());
        paramMap.put("city_code", userDetail.getCityCode());
        paramMap.put("city_name", userDetail.getCityName());
        paramMap.put("province_code", userDetail.getProvinceCode());
        paramMap.put("province_name", userDetail.getProvinceName());
        paramMap.put("resume", userDetail.getResume());
        paramMap.put("signature", userDetail.getSignature());
        paramMap.put("create_date", userDetail.getCreateDate());
        paramMap.put("update_date", userDetail.getUpdateDate());
        paramMap.put("is_perfect_data", userDetail.getIsPerfectData());
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
	public void batchSave(List<UserDetail> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserDetail> list){
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
	 * @return UserDetail
	 */
	@Override
	public UserDetail findById(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`user_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserDetail.class), userId);
	}

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @return List
	 */
	@Override
	public List<UserDetail> find(UserDetail userDetail){
		return this.find(userDetail, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserDetail> find(UserDetail userDetail, String[][] orders){
		return this.find(userDetail, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDetail
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDetail> find(UserDetail userDetail, Long offset, Long rows){
		return this.find(userDetail, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDetail
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDetail> find(UserDetail userDetail, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userDetail != null){
			if(userDetail.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userDetail.getUserId());
			}
			if(userDetail.getNickName() != null && !"".equals(userDetail.getNickName())){
				sql.append(" AND _this.`nick_name` = ?");
				param.add(userDetail.getNickName());
			}
			if(userDetail.getSex() != null && !"".equals(userDetail.getSex())){
				sql.append(" AND _this.`sex` = ?");
				param.add(userDetail.getSex());
			}
			if(userDetail.getAge() != null && !"".equals(userDetail.getAge())){
				sql.append(" AND _this.`age` = ?");
				param.add(userDetail.getAge());
			}
			if(userDetail.getHeadImgPath() != null && !"".equals(userDetail.getHeadImgPath())){
				sql.append(" AND _this.`head_img_path` = ?");
				param.add(userDetail.getHeadImgPath());
			}
			if(userDetail.getCompanyDuties() != null && !"".equals(userDetail.getCompanyDuties())){
				sql.append(" AND _this.`company_duties` = ?");
				param.add(userDetail.getCompanyDuties());
			}
			if(userDetail.getCityCode() != null && !"".equals(userDetail.getCityCode())){
				sql.append(" AND _this.`city_code` = ?");
				param.add(userDetail.getCityCode());
			}
			if(userDetail.getCityName() != null && !"".equals(userDetail.getCityName())){
				sql.append(" AND _this.`city_name` = ?");
				param.add(userDetail.getCityName());
			}
			if(userDetail.getProvinceCode() != null && !"".equals(userDetail.getProvinceCode())){
				sql.append(" AND _this.`province_code` = ?");
				param.add(userDetail.getProvinceCode());
			}
			if(userDetail.getProvinceName() != null && !"".equals(userDetail.getProvinceName())){
				sql.append(" AND _this.`province_name` = ?");
				param.add(userDetail.getProvinceName());
			}
			if(userDetail.getResume() != null && !"".equals(userDetail.getResume())){
				sql.append(" AND _this.`resume` = ?");
				param.add(userDetail.getResume());
			}
			if(userDetail.getSignature() != null && !"".equals(userDetail.getSignature())){
				sql.append(" AND _this.`signature` = ?");
				param.add(userDetail.getSignature());
			}
			if(userDetail.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userDetail.getCreateDate());
			}
			if(userDetail.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userDetail.getUpdateDate());
			}
			if(userDetail.getIsPerfectData() != null && !"".equals(userDetail.getIsPerfectData())){
				sql.append(" AND _this.`is_perfect_data` = ?");
				param.add(userDetail.getIsPerfectData());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserDetail.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userDetail
	 * @return Long
	 */
	@Override
	public Long count(UserDetail userDetail){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_detail  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userDetail != null){
			if(userDetail.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userDetail.getUserId());
			}
			if(userDetail.getNickName() != null && !"".equals(userDetail.getNickName())){
				sql.append(" AND _this.`nick_name` = ? ");
				param.add(userDetail.getNickName());
			}
			if(userDetail.getSex() != null && !"".equals(userDetail.getSex())){
				sql.append(" AND _this.`sex` = ? ");
				param.add(userDetail.getSex());
			}
			if(userDetail.getAge() != null && !"".equals(userDetail.getAge())){
				sql.append(" AND _this.`age` = ? ");
				param.add(userDetail.getAge());
			}
			if(userDetail.getHeadImgPath() != null && !"".equals(userDetail.getHeadImgPath())){
				sql.append(" AND _this.`head_img_path` = ? ");
				param.add(userDetail.getHeadImgPath());
			}
			if(userDetail.getCompanyDuties() != null && !"".equals(userDetail.getCompanyDuties())){
				sql.append(" AND _this.`company_duties` = ? ");
				param.add(userDetail.getCompanyDuties());
			}
			if(userDetail.getCityCode() != null && !"".equals(userDetail.getCityCode())){
				sql.append(" AND _this.`city_code` = ? ");
				param.add(userDetail.getCityCode());
			}
			if(userDetail.getCityName() != null && !"".equals(userDetail.getCityName())){
				sql.append(" AND _this.`city_name` = ? ");
				param.add(userDetail.getCityName());
			}
			if(userDetail.getProvinceCode() != null && !"".equals(userDetail.getProvinceCode())){
				sql.append(" AND _this.`province_code` = ? ");
				param.add(userDetail.getProvinceCode());
			}
			if(userDetail.getProvinceName() != null && !"".equals(userDetail.getProvinceName())){
				sql.append(" AND _this.`province_name` = ? ");
				param.add(userDetail.getProvinceName());
			}
			if(userDetail.getResume() != null && !"".equals(userDetail.getResume())){
				sql.append(" AND _this.`resume` = ? ");
				param.add(userDetail.getResume());
			}
			if(userDetail.getSignature() != null && !"".equals(userDetail.getSignature())){
				sql.append(" AND _this.`signature` = ? ");
				param.add(userDetail.getSignature());
			}
			if(userDetail.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userDetail.getCreateDate());
			}
			if(userDetail.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userDetail.getUpdateDate());
			}
			if(userDetail.getIsPerfectData() != null && !"".equals(userDetail.getIsPerfectData())){
				sql.append(" AND _this.`is_perfect_data` = ? ");
				param.add(userDetail.getIsPerfectData());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}