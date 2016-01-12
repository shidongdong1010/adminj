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

import com.lhy.adminj.basic.dao.base.UserStatRecordBaseDao;
import com.lhy.adminj.basic.model.UserStatRecord;

/**
 * 用户统计记录表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserStatRecordBaseDaoImpl implements UserStatRecordBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`user_id`, _this.`dynamic_num`, _this.`attention_num`, _this.`follow_buy_num`, _this.`friends_num`, _this.`group_num`, _this.`trade_num`, _this.`create_date`, _this.`update_date`, _this.`login_num`, _this.`talk_num`, _this.`order_num`, _this.`forward_num`, _this.`praise_num`, _this.`comment_num`, _this.`share_num`, _this.`coin_num`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`user_id`, _this.`dynamic_num`, _this.`attention_num`, _this.`follow_buy_num`, _this.`friends_num`, _this.`group_num`, _this.`trade_num`, _this.`create_date`, _this.`update_date`, _this.`login_num`, _this.`talk_num`, _this.`order_num`, _this.`forward_num`, _this.`praise_num`, _this.`comment_num`, _this.`share_num`, _this.`coin_num` FROM umc_user_stat_record _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO umc_user_stat_record(`user_id`, `dynamic_num`, `attention_num`, `follow_buy_num`, `friends_num`, `group_num`, `trade_num`, `create_date`, `update_date`, `login_num`, `talk_num`, `order_num`, `forward_num`, `praise_num`, `comment_num`, `share_num`, `coin_num`) VALUES (:user_id, :dynamic_num, :attention_num, :follow_buy_num, :friends_num, :group_num, :trade_num, :create_date, :update_date, :login_num, :talk_num, :order_num, :forward_num, :praise_num, :comment_num, :share_num, :coin_num)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE umc_user_stat_record SET `user_id` = :user_id, `dynamic_num` = :dynamic_num, `attention_num` = :attention_num, `follow_buy_num` = :follow_buy_num, `friends_num` = :friends_num, `group_num` = :group_num, `trade_num` = :trade_num, `create_date` = :create_date, `update_date` = :update_date, `login_num` = :login_num, `talk_num` = :talk_num, `order_num` = :order_num, `forward_num` = :forward_num, `praise_num` = :praise_num, `comment_num` = :comment_num, `share_num` = :share_num, `coin_num` = :coin_num WHERE `user_id` = :user_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM umc_user_stat_record WHERE `user_id` = ?";

	@Override
	public void save(UserStatRecord userStatRecord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userStatRecord);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userStatRecord.setUserId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserStatRecord userStatRecord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userStatRecord);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserStatRecord userStatRecord) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE umc_user_stat_record SET ");
		if(userStatRecord.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userStatRecord.getUserId());
		}
		if(userStatRecord.getDynamicNum() != null){
			sql.append(" dynamic_num = ?, ");
			param.add(userStatRecord.getDynamicNum());
		}
		if(userStatRecord.getAttentionNum() != null){
			sql.append(" attention_num = ?, ");
			param.add(userStatRecord.getAttentionNum());
		}
		if(userStatRecord.getFollowBuyNum() != null){
			sql.append(" follow_buy_num = ?, ");
			param.add(userStatRecord.getFollowBuyNum());
		}
		if(userStatRecord.getFriendsNum() != null){
			sql.append(" friends_num = ?, ");
			param.add(userStatRecord.getFriendsNum());
		}
		if(userStatRecord.getGroupNum() != null){
			sql.append(" group_num = ?, ");
			param.add(userStatRecord.getGroupNum());
		}
		if(userStatRecord.getTradeNum() != null){
			sql.append(" trade_num = ?, ");
			param.add(userStatRecord.getTradeNum());
		}
		if(userStatRecord.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userStatRecord.getCreateDate());
		}
		if(userStatRecord.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userStatRecord.getUpdateDate());
		}
		if(userStatRecord.getLoginNum() != null){
			sql.append(" login_num = ?, ");
			param.add(userStatRecord.getLoginNum());
		}
		if(userStatRecord.getTalkNum() != null){
			sql.append(" talk_num = ?, ");
			param.add(userStatRecord.getTalkNum());
		}
		if(userStatRecord.getOrderNum() != null){
			sql.append(" order_num = ?, ");
			param.add(userStatRecord.getOrderNum());
		}
		if(userStatRecord.getForwardNum() != null){
			sql.append(" forward_num = ?, ");
			param.add(userStatRecord.getForwardNum());
		}
		if(userStatRecord.getPraiseNum() != null){
			sql.append(" praise_num = ?, ");
			param.add(userStatRecord.getPraiseNum());
		}
		if(userStatRecord.getCommentNum() != null){
			sql.append(" comment_num = ?, ");
			param.add(userStatRecord.getCommentNum());
		}
		if(userStatRecord.getShareNum() != null){
			sql.append(" share_num = ?, ");
			param.add(userStatRecord.getShareNum());
		}
		if(userStatRecord.getCoinNum() != null){
			sql.append(" coin_num = ? ");
			param.add(userStatRecord.getCoinNum());
		}
		sql.append(" WHERE user_id = ? ");
		param.add(userStatRecord.getUserId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userStatRecords
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserStatRecord> userStatRecords){
		Map<String, Object>[] maps = new Map[userStatRecords.size()];
		for(int i = 0; i < userStatRecords.size(); i++){
			UserStatRecord userStatRecord = userStatRecords.get(i);
			maps[i] = toMap(userStatRecord);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userStatRecord
	 * @return
	 */
	public Map<String, Object> toMap(UserStatRecord userStatRecord){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userStatRecord.getUserId());
        paramMap.put("dynamic_num", userStatRecord.getDynamicNum());
        paramMap.put("attention_num", userStatRecord.getAttentionNum());
        paramMap.put("follow_buy_num", userStatRecord.getFollowBuyNum());
        paramMap.put("friends_num", userStatRecord.getFriendsNum());
        paramMap.put("group_num", userStatRecord.getGroupNum());
        paramMap.put("trade_num", userStatRecord.getTradeNum());
        paramMap.put("create_date", userStatRecord.getCreateDate());
        paramMap.put("update_date", userStatRecord.getUpdateDate());
        paramMap.put("login_num", userStatRecord.getLoginNum());
        paramMap.put("talk_num", userStatRecord.getTalkNum());
        paramMap.put("order_num", userStatRecord.getOrderNum());
        paramMap.put("forward_num", userStatRecord.getForwardNum());
        paramMap.put("praise_num", userStatRecord.getPraiseNum());
        paramMap.put("comment_num", userStatRecord.getCommentNum());
        paramMap.put("share_num", userStatRecord.getShareNum());
        paramMap.put("coin_num", userStatRecord.getCoinNum());
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
	public void batchSave(List<UserStatRecord> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserStatRecord> list){
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
	 * @param userId 用户ID
	 * @return UserStatRecord
	 */
	@Override
	public UserStatRecord findById(Long userId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`user_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserStatRecord.class), userId);
	}

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @return List
	 */
	@Override
	public List<UserStatRecord> find(UserStatRecord userStatRecord){
		return this.find(userStatRecord, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserStatRecord> find(UserStatRecord userStatRecord, String[][] orders){
		return this.find(userStatRecord, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userStatRecord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserStatRecord> find(UserStatRecord userStatRecord, Long offset, Long rows){
		return this.find(userStatRecord, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userStatRecord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserStatRecord> find(UserStatRecord userStatRecord, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userStatRecord != null){
			if(userStatRecord.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userStatRecord.getUserId());
			}
			if(userStatRecord.getDynamicNum() != null){
				sql.append(" AND _this.`dynamic_num` = ?");
				param.add(userStatRecord.getDynamicNum());
			}
			if(userStatRecord.getAttentionNum() != null){
				sql.append(" AND _this.`attention_num` = ?");
				param.add(userStatRecord.getAttentionNum());
			}
			if(userStatRecord.getFollowBuyNum() != null){
				sql.append(" AND _this.`follow_buy_num` = ?");
				param.add(userStatRecord.getFollowBuyNum());
			}
			if(userStatRecord.getFriendsNum() != null){
				sql.append(" AND _this.`friends_num` = ?");
				param.add(userStatRecord.getFriendsNum());
			}
			if(userStatRecord.getGroupNum() != null){
				sql.append(" AND _this.`group_num` = ?");
				param.add(userStatRecord.getGroupNum());
			}
			if(userStatRecord.getTradeNum() != null){
				sql.append(" AND _this.`trade_num` = ?");
				param.add(userStatRecord.getTradeNum());
			}
			if(userStatRecord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userStatRecord.getCreateDate());
			}
			if(userStatRecord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userStatRecord.getUpdateDate());
			}
			if(userStatRecord.getLoginNum() != null){
				sql.append(" AND _this.`login_num` = ?");
				param.add(userStatRecord.getLoginNum());
			}
			if(userStatRecord.getTalkNum() != null){
				sql.append(" AND _this.`talk_num` = ?");
				param.add(userStatRecord.getTalkNum());
			}
			if(userStatRecord.getOrderNum() != null){
				sql.append(" AND _this.`order_num` = ?");
				param.add(userStatRecord.getOrderNum());
			}
			if(userStatRecord.getForwardNum() != null){
				sql.append(" AND _this.`forward_num` = ?");
				param.add(userStatRecord.getForwardNum());
			}
			if(userStatRecord.getPraiseNum() != null){
				sql.append(" AND _this.`praise_num` = ?");
				param.add(userStatRecord.getPraiseNum());
			}
			if(userStatRecord.getCommentNum() != null){
				sql.append(" AND _this.`comment_num` = ?");
				param.add(userStatRecord.getCommentNum());
			}
			if(userStatRecord.getShareNum() != null){
				sql.append(" AND _this.`share_num` = ?");
				param.add(userStatRecord.getShareNum());
			}
			if(userStatRecord.getCoinNum() != null){
				sql.append(" AND _this.`coin_num` = ?");
				param.add(userStatRecord.getCoinNum());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserStatRecord.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userStatRecord
	 * @return Long
	 */
	@Override
	public Long count(UserStatRecord userStatRecord){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM umc_user_stat_record  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userStatRecord != null){
			if(userStatRecord.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userStatRecord.getUserId());
			}
			if(userStatRecord.getDynamicNum() != null){
				sql.append(" AND _this.`dynamic_num` = ? ");
				param.add(userStatRecord.getDynamicNum());
			}
			if(userStatRecord.getAttentionNum() != null){
				sql.append(" AND _this.`attention_num` = ? ");
				param.add(userStatRecord.getAttentionNum());
			}
			if(userStatRecord.getFollowBuyNum() != null){
				sql.append(" AND _this.`follow_buy_num` = ? ");
				param.add(userStatRecord.getFollowBuyNum());
			}
			if(userStatRecord.getFriendsNum() != null){
				sql.append(" AND _this.`friends_num` = ? ");
				param.add(userStatRecord.getFriendsNum());
			}
			if(userStatRecord.getGroupNum() != null){
				sql.append(" AND _this.`group_num` = ? ");
				param.add(userStatRecord.getGroupNum());
			}
			if(userStatRecord.getTradeNum() != null){
				sql.append(" AND _this.`trade_num` = ? ");
				param.add(userStatRecord.getTradeNum());
			}
			if(userStatRecord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userStatRecord.getCreateDate());
			}
			if(userStatRecord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userStatRecord.getUpdateDate());
			}
			if(userStatRecord.getLoginNum() != null){
				sql.append(" AND _this.`login_num` = ? ");
				param.add(userStatRecord.getLoginNum());
			}
			if(userStatRecord.getTalkNum() != null){
				sql.append(" AND _this.`talk_num` = ? ");
				param.add(userStatRecord.getTalkNum());
			}
			if(userStatRecord.getOrderNum() != null){
				sql.append(" AND _this.`order_num` = ? ");
				param.add(userStatRecord.getOrderNum());
			}
			if(userStatRecord.getForwardNum() != null){
				sql.append(" AND _this.`forward_num` = ? ");
				param.add(userStatRecord.getForwardNum());
			}
			if(userStatRecord.getPraiseNum() != null){
				sql.append(" AND _this.`praise_num` = ? ");
				param.add(userStatRecord.getPraiseNum());
			}
			if(userStatRecord.getCommentNum() != null){
				sql.append(" AND _this.`comment_num` = ? ");
				param.add(userStatRecord.getCommentNum());
			}
			if(userStatRecord.getShareNum() != null){
				sql.append(" AND _this.`share_num` = ? ");
				param.add(userStatRecord.getShareNum());
			}
			if(userStatRecord.getCoinNum() != null){
				sql.append(" AND _this.`coin_num` = ? ");
				param.add(userStatRecord.getCoinNum());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}