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

import com.lhy.adminj.basic.dao.base.MyGroupBaseDao;
import com.lhy.adminj.basic.model.MyGroup;

/**
 * 我的组合表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class MyGroupBaseDaoImpl implements MyGroupBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`group_id`, _this.`parent_group_id`, _this.`user_id`, _this.`group_name`, _this.`group_desc`, _this.`group_type`, _this.`total_trade_income`, _this.`today_trade_income`, _this.`total_cost`, _this.`follow_buy_num`, _this.`trade_count`, _this.`profit_count`, _this.`loss_count`, _this.`create_date`, _this.`update_date`, _this.`is_del`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`group_id`, _this.`parent_group_id`, _this.`user_id`, _this.`group_name`, _this.`group_desc`, _this.`group_type`, _this.`total_trade_income`, _this.`today_trade_income`, _this.`total_cost`, _this.`follow_buy_num`, _this.`trade_count`, _this.`profit_count`, _this.`loss_count`, _this.`create_date`, _this.`update_date`, _this.`is_del` FROM tmc_my_group _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO tmc_my_group(`group_id`, `parent_group_id`, `user_id`, `group_name`, `group_desc`, `group_type`, `total_trade_income`, `today_trade_income`, `total_cost`, `follow_buy_num`, `trade_count`, `profit_count`, `loss_count`, `create_date`, `update_date`, `is_del`) VALUES (:group_id, :parent_group_id, :user_id, :group_name, :group_desc, :group_type, :total_trade_income, :today_trade_income, :total_cost, :follow_buy_num, :trade_count, :profit_count, :loss_count, :create_date, :update_date, :is_del)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE tmc_my_group SET `group_id` = :group_id, `parent_group_id` = :parent_group_id, `user_id` = :user_id, `group_name` = :group_name, `group_desc` = :group_desc, `group_type` = :group_type, `total_trade_income` = :total_trade_income, `today_trade_income` = :today_trade_income, `total_cost` = :total_cost, `follow_buy_num` = :follow_buy_num, `trade_count` = :trade_count, `profit_count` = :profit_count, `loss_count` = :loss_count, `create_date` = :create_date, `update_date` = :update_date, `is_del` = :is_del WHERE `group_id` = :group_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM tmc_my_group WHERE `group_id` = ?";

	@Override
	public void save(MyGroup myGroup) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroup);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		myGroup.setGroupId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(MyGroup myGroup) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(myGroup);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(MyGroup myGroup) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE tmc_my_group SET ");
		if(myGroup.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(myGroup.getGroupId());
		}
		if(myGroup.getParentGroupId() != null){
			sql.append(" parent_group_id = ?, ");
			param.add(myGroup.getParentGroupId());
		}
		if(myGroup.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(myGroup.getUserId());
		}
		if(myGroup.getGroupName() != null){
			sql.append(" group_name = ?, ");
			param.add(myGroup.getGroupName());
		}
		if(myGroup.getGroupDesc() != null){
			sql.append(" group_desc = ?, ");
			param.add(myGroup.getGroupDesc());
		}
		if(myGroup.getGroupType() != null){
			sql.append(" group_type = ?, ");
			param.add(myGroup.getGroupType());
		}
		if(myGroup.getTotalTradeIncome() != null){
			sql.append(" total_trade_income = ?, ");
			param.add(myGroup.getTotalTradeIncome());
		}
		if(myGroup.getTodayTradeIncome() != null){
			sql.append(" today_trade_income = ?, ");
			param.add(myGroup.getTodayTradeIncome());
		}
		if(myGroup.getTotalCost() != null){
			sql.append(" total_cost = ?, ");
			param.add(myGroup.getTotalCost());
		}
		if(myGroup.getFollowBuyNum() != null){
			sql.append(" follow_buy_num = ?, ");
			param.add(myGroup.getFollowBuyNum());
		}
		if(myGroup.getTradeCount() != null){
			sql.append(" trade_count = ?, ");
			param.add(myGroup.getTradeCount());
		}
		if(myGroup.getProfitCount() != null){
			sql.append(" profit_count = ?, ");
			param.add(myGroup.getProfitCount());
		}
		if(myGroup.getLossCount() != null){
			sql.append(" loss_count = ?, ");
			param.add(myGroup.getLossCount());
		}
		if(myGroup.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(myGroup.getCreateDate());
		}
		if(myGroup.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(myGroup.getUpdateDate());
		}
		if(myGroup.getIsDel() != null){
			sql.append(" is_del = ? ");
			param.add(myGroup.getIsDel());
		}
		sql.append(" WHERE group_id = ? ");
		param.add(myGroup.getGroupId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param myGroups
	 * @return
	 */
	public Map<String, Object>[] toMap(List<MyGroup> myGroups){
		Map<String, Object>[] maps = new Map[myGroups.size()];
		for(int i = 0; i < myGroups.size(); i++){
			MyGroup myGroup = myGroups.get(i);
			maps[i] = toMap(myGroup);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param myGroup
	 * @return
	 */
	public Map<String, Object> toMap(MyGroup myGroup){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("group_id", myGroup.getGroupId());
        paramMap.put("parent_group_id", myGroup.getParentGroupId());
        paramMap.put("user_id", myGroup.getUserId());
        paramMap.put("group_name", myGroup.getGroupName());
        paramMap.put("group_desc", myGroup.getGroupDesc());
        paramMap.put("group_type", myGroup.getGroupType());
        paramMap.put("total_trade_income", myGroup.getTotalTradeIncome());
        paramMap.put("today_trade_income", myGroup.getTodayTradeIncome());
        paramMap.put("total_cost", myGroup.getTotalCost());
        paramMap.put("follow_buy_num", myGroup.getFollowBuyNum());
        paramMap.put("trade_count", myGroup.getTradeCount());
        paramMap.put("profit_count", myGroup.getProfitCount());
        paramMap.put("loss_count", myGroup.getLossCount());
        paramMap.put("create_date", myGroup.getCreateDate());
        paramMap.put("update_date", myGroup.getUpdateDate());
        paramMap.put("is_del", myGroup.getIsDel());
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
	public void delete(Long groupId){
		jdbcTemplate.update(DELETE_SQL, groupId);
	}

	@Override
	public void batchSave(List<MyGroup> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<MyGroup> list){
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
	 * @param groupId 组合ID
	 * @return MyGroup
	 */
	@Override
	public MyGroup findById(Long groupId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`group_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(MyGroup.class), groupId);
	}

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @return List
	 */
	@Override
	public List<MyGroup> find(MyGroup myGroup){
		return this.find(myGroup, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<MyGroup> find(MyGroup myGroup, String[][] orders){
		return this.find(myGroup, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param myGroup
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroup> find(MyGroup myGroup, Long offset, Long rows){
		return this.find(myGroup, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param myGroup
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<MyGroup> find(MyGroup myGroup, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(myGroup != null){
			if(myGroup.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(myGroup.getGroupId());
			}
			if(myGroup.getParentGroupId() != null){
				sql.append(" AND _this.`parent_group_id` = ?");
				param.add(myGroup.getParentGroupId());
			}
			if(myGroup.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(myGroup.getUserId());
			}
			if(myGroup.getGroupName() != null && !"".equals(myGroup.getGroupName())){
				sql.append(" AND _this.`group_name` = ?");
				param.add(myGroup.getGroupName());
			}
			if(myGroup.getGroupDesc() != null && !"".equals(myGroup.getGroupDesc())){
				sql.append(" AND _this.`group_desc` = ?");
				param.add(myGroup.getGroupDesc());
			}
			if(myGroup.getGroupType() != null && !"".equals(myGroup.getGroupType())){
				sql.append(" AND _this.`group_type` = ?");
				param.add(myGroup.getGroupType());
			}
			if(myGroup.getFollowBuyNum() != null){
				sql.append(" AND _this.`follow_buy_num` = ?");
				param.add(myGroup.getFollowBuyNum());
			}
			if(myGroup.getTradeCount() != null){
				sql.append(" AND _this.`trade_count` = ?");
				param.add(myGroup.getTradeCount());
			}
			if(myGroup.getProfitCount() != null){
				sql.append(" AND _this.`profit_count` = ?");
				param.add(myGroup.getProfitCount());
			}
			if(myGroup.getLossCount() != null){
				sql.append(" AND _this.`loss_count` = ?");
				param.add(myGroup.getLossCount());
			}
			if(myGroup.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(myGroup.getCreateDate());
			}
			if(myGroup.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(myGroup.getUpdateDate());
			}
			if(myGroup.getIsDel() != null && !"".equals(myGroup.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(myGroup.getIsDel());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(MyGroup.class));
	}


	/**
	 * 根据对象查询条数
	 * @param myGroup
	 * @return Long
	 */
	@Override
	public Long count(MyGroup myGroup){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM tmc_my_group  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(myGroup != null){
			if(myGroup.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(myGroup.getGroupId());
			}
			if(myGroup.getParentGroupId() != null){
				sql.append(" AND _this.`parent_group_id` = ? ");
				param.add(myGroup.getParentGroupId());
			}
			if(myGroup.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(myGroup.getUserId());
			}
			if(myGroup.getGroupName() != null && !"".equals(myGroup.getGroupName())){
				sql.append(" AND _this.`group_name` = ? ");
				param.add(myGroup.getGroupName());
			}
			if(myGroup.getGroupDesc() != null && !"".equals(myGroup.getGroupDesc())){
				sql.append(" AND _this.`group_desc` = ? ");
				param.add(myGroup.getGroupDesc());
			}
			if(myGroup.getGroupType() != null && !"".equals(myGroup.getGroupType())){
				sql.append(" AND _this.`group_type` = ? ");
				param.add(myGroup.getGroupType());
			}
			if(myGroup.getFollowBuyNum() != null){
				sql.append(" AND _this.`follow_buy_num` = ? ");
				param.add(myGroup.getFollowBuyNum());
			}
			if(myGroup.getTradeCount() != null){
				sql.append(" AND _this.`trade_count` = ? ");
				param.add(myGroup.getTradeCount());
			}
			if(myGroup.getProfitCount() != null){
				sql.append(" AND _this.`profit_count` = ? ");
				param.add(myGroup.getProfitCount());
			}
			if(myGroup.getLossCount() != null){
				sql.append(" AND _this.`loss_count` = ? ");
				param.add(myGroup.getLossCount());
			}
			if(myGroup.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(myGroup.getCreateDate());
			}
			if(myGroup.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(myGroup.getUpdateDate());
			}
			if(myGroup.getIsDel() != null && !"".equals(myGroup.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(myGroup.getIsDel());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}