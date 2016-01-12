package com.lhy.adminj.basic.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.lhy.adminj.basic.dao.UserDao;
import com.lhy.adminj.basic.dao.base.impl.UserBaseDaoImpl;
import com.lhy.adminj.basic.model.User;

/**
 * 用户表Dao接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
@Repository
public class UserDaoImpl extends UserBaseDaoImpl implements UserDao {

	/**
	 * 根据对象查询支持用户名模糊查询
	 * @param user
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<User> findLikeName(User user, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(user != null){
			if(user.getUserId() != null){
				sql.append(" AND _this.user_id = ?");
				param.add(user.getUserId());
			}
			if(user.getUserName() != null && !"".equals(user.getUserName())){
				sql.append(" AND _this.user_name like'%"+user.getUserName()+"%' ");
			}
			if(user.getPassword() != null && !"".equals(user.getPassword())){
				sql.append(" AND _this.password = ?");
				param.add(user.getPassword());
			}
			if(user.getMobile() != null && !"".equals(user.getMobile())){
				sql.append(" AND _this.mobile = ?");
				param.add(user.getMobile());
			}
			if(user.getRegIp() != null && !"".equals(user.getRegIp())){
				sql.append(" AND _this.reg_ip = ?");
				param.add(user.getRegIp());
			}
			if(user.getType() != null && !"".equals(user.getType())){
				sql.append(" AND _this.type = ?");
				param.add(user.getType());
			}
			if(user.getStatus() != null && !"".equals(user.getStatus())){
				sql.append(" AND _this.status = ?");
				param.add(user.getStatus());
			}
			if(user.getClientId() != null && !"".equals(user.getClientId())){
				sql.append(" AND _this.client_id = ?");
				param.add(user.getClientId());
			}
			if(user.getClientType() != null && !"".equals(user.getClientType())){
				sql.append(" AND _this.client_type = ?");
				param.add(user.getClientType());
			}
			if(user.getPushSwitch() != null && !"".equals(user.getPushSwitch())){
				sql.append(" AND _this.push_switch = ?");
				param.add(user.getPushSwitch());
			}
			if(user.getLevel() != null){
				sql.append(" AND _this.level = ?");
				param.add(user.getLevel());
			}
			if(user.getEmail() != null && !"".equals(user.getEmail())){
				sql.append(" AND _this.email = ?");
				param.add(user.getEmail());
			}
			if(user.getUserSource() != null && !"".equals(user.getUserSource())){
				sql.append(" AND _this.user_source = ?");
				param.add(user.getUserSource());
			}
			if(user.getQq() != null && !"".equals(user.getQq())){
				sql.append(" AND _this.qq = ?");
				param.add(user.getQq());
			}
			if(user.getWeChat() != null && !"".equals(user.getWeChat())){
				sql.append(" AND _this.we_chat = ?");
				param.add(user.getWeChat());
			}
			if(user.getWeibo() != null && !"".equals(user.getWeibo())){
				sql.append(" AND _this.weibo = ?");
				param.add(user.getWeibo());
			}
			if(user.getCreateDate() != null){
				sql.append(" AND _this.create_date = ?");
				param.add(user.getCreateDate());
			}
			if(user.getUpdateDate() != null){
				sql.append(" AND _this.update_date = ?");
				param.add(user.getUpdateDate());
			}
			if(user.getOpenId() != null && !"".equals(user.getOpenId())){
				sql.append(" AND _this.open_id = ?");
				param.add(user.getOpenId());
			}
			if(user.getLastcity() != null && !"".equals(user.getLastcity())){
				sql.append(" AND _this.lastcity = ?");
				param.add(user.getLastcity());
			}
		}

		// 排序
		if(orders != null && orders.length > 0){
   			sql.append(" ORDER BY ");
			for(int i = 0; i < orders.length; i++){
    			String[] order = orders[i];
				if(i != 0){
    				sql.append(order[0]).append(", ");
				}
				if(order.length == 1){
    				sql.append(order[0]).append(" ASC");
				}else{
    				sql.append(order[0]).append(" ").append(order[1]);
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
	 * 注册数量按月统计
	 * @return List<Map<String, Object>> 字段描述year, month, num
	 */
	public List<Map<String, Object>> registMonthCount(Integer year){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" 	b.year, b.month, b.num ");
		sql.append(" FROM ");
		sql.append(" 	(SELECT ");
		sql.append(" 		YEAR(a.create_date) year, ");
		sql.append(" 		MONTH(a.create_date) month, ");
		sql.append(" 		COUNT(*) num ");
		sql.append(" 	 FROM  umc_user a ");

		List<Object> param = new ArrayList<>();
		if(year != null){
			sql.append(" WHERE YEAR(a.create_date) = ? ");
			param.add(year);
		}
		sql.append(" 	 GROUP BY YEAR(a.create_date) , MONTH(a.create_date)");
		sql.append("	) b ");
		sql.append(" ORDER BY b.year asc, b.month asc, b.num ");
		return jdbcTemplate.queryForList(sql.toString(), param.toArray());
	}
}
