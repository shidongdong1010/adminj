package com.lhy.adminj.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.lhy.adminj.basic.dao.base.impl.UserFeedBackInfoBaseDaoImpl;
import com.lhy.adminj.basic.dao.UserFeedBackInfoDao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.lhy.adminj.basic.model.UserFeedBackInfo;

/**
 * 意见反馈信息表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UserFeedBackInfoDaoImpl extends UserFeedBackInfoBaseDaoImpl implements UserFeedBackInfoDao {
	/**
	 * 根据对象查询
	 * @param userFeedBackInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserFeedBackInfo> findList(UserFeedBackInfo userFeedBackInfo, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
        sql.append("     " + selectColumn1());
		sql.append("   FROM umc_user_feed_back_info f left join umc_user u on u.user_id =  f.user_id ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userFeedBackInfo != null && userFeedBackInfo.getFeedbackId() != null){
			sql.append("  AND f.feedback_id = ? ");
			param.add(userFeedBackInfo.getFeedbackId());
        }
        if(userFeedBackInfo != null && userFeedBackInfo.getUserId() != null){
			sql.append("  AND f.user_id = ? ");
			param.add(userFeedBackInfo.getUserId());
        }
		if(userFeedBackInfo != null && userFeedBackInfo.getContect() != null && !"".equals(userFeedBackInfo.getContect())){
            sql.append("  AND f.contect = ? ");
			param.add(userFeedBackInfo.getContect());
		}
        if(userFeedBackInfo != null && userFeedBackInfo.getCreateTime() != null){
			sql.append("  AND f.create_time = ? ");
			param.add(userFeedBackInfo.getCreateTime());
        }
		if(offset != null  && rows != null){
        	sql.append("  limit ?,? ");
        	param.add(offset);
        	param.add(rows);
		} else if(rows != null){
			sql.append("  limit ? ");
			param.add(rows);
		}
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserFeedBackInfo.class));
	}
	
	/**
	 * 查询的字段字符串
	 * @return
	 */
	public String selectColumn1(){
		StringBuilder sql = new StringBuilder();
        sql.append("f.feedback_id, ");
        sql.append("f.user_id, ");
        sql.append("f.contect, ");
		sql.append("f.create_time, ");
		sql.append("u.user_name ");
		return sql.toString();
	}

	
}
