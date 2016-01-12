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

import com.lhy.adminj.basic.dao.base.UserDynamicInfoBaseDao;
import com.lhy.adminj.basic.model.UserDynamicInfo;

/**
 * 用户动态表Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class UserDynamicInfoBaseDaoImpl implements UserDynamicInfoBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`dynamic_id`, _this.`user_id`, _this.`original_user_id`, _this.`type`, _this.`title`, _this.`mark`, _this.`see_range`, _this.`comment_range`, _this.`show_location`, _this.`local`, _this.`image_path`, _this.`see_is_reward`, _this.`see_reward_sail_coin_num`, _this.`is_del`, _this.`forward_num`, _this.`praise_num`, _this.`comment_num`, _this.`share_num`, _this.`is_forward`, _this.`create_date`, _this.`update_date`, _this.`remark`, _this.`parent_dynamic_id`, _this.`audit_status`, _this.`audit_date`, _this.`audit_desc`, _this.`audit_name`, _this.`give_user_id`, _this.`group_id`, _this.`is_input`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`dynamic_id`, _this.`user_id`, _this.`original_user_id`, _this.`type`, _this.`title`, _this.`mark`, _this.`see_range`, _this.`comment_range`, _this.`show_location`, _this.`local`, _this.`image_path`, _this.`see_is_reward`, _this.`see_reward_sail_coin_num`, _this.`is_del`, _this.`forward_num`, _this.`praise_num`, _this.`comment_num`, _this.`share_num`, _this.`is_forward`, _this.`create_date`, _this.`update_date`, _this.`remark`, _this.`parent_dynamic_id`, _this.`audit_status`, _this.`audit_date`, _this.`audit_desc`, _this.`audit_name`, _this.`give_user_id`, _this.`group_id`, _this.`is_input` FROM udc_user_dynamic_info _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO udc_user_dynamic_info(`dynamic_id`, `user_id`, `original_user_id`, `type`, `title`, `mark`, `see_range`, `comment_range`, `show_location`, `local`, `image_path`, `see_is_reward`, `see_reward_sail_coin_num`, `is_del`, `forward_num`, `praise_num`, `comment_num`, `share_num`, `is_forward`, `create_date`, `update_date`, `remark`, `parent_dynamic_id`, `audit_status`, `audit_date`, `audit_desc`, `audit_name`, `give_user_id`, `group_id`, `is_input`) VALUES (:dynamic_id, :user_id, :original_user_id, :type, :title, :mark, :see_range, :comment_range, :show_location, :local, :image_path, :see_is_reward, :see_reward_sail_coin_num, :is_del, :forward_num, :praise_num, :comment_num, :share_num, :is_forward, :create_date, :update_date, :remark, :parent_dynamic_id, :audit_status, :audit_date, :audit_desc, :audit_name, :give_user_id, :group_id, :is_input)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE udc_user_dynamic_info SET `dynamic_id` = :dynamic_id, `user_id` = :user_id, `original_user_id` = :original_user_id, `type` = :type, `title` = :title, `mark` = :mark, `see_range` = :see_range, `comment_range` = :comment_range, `show_location` = :show_location, `local` = :local, `image_path` = :image_path, `see_is_reward` = :see_is_reward, `see_reward_sail_coin_num` = :see_reward_sail_coin_num, `is_del` = :is_del, `forward_num` = :forward_num, `praise_num` = :praise_num, `comment_num` = :comment_num, `share_num` = :share_num, `is_forward` = :is_forward, `create_date` = :create_date, `update_date` = :update_date, `remark` = :remark, `parent_dynamic_id` = :parent_dynamic_id, `audit_status` = :audit_status, `audit_date` = :audit_date, `audit_desc` = :audit_desc, `audit_name` = :audit_name, `give_user_id` = :give_user_id, `group_id` = :group_id, `is_input` = :is_input WHERE `dynamic_id` = :dynamic_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM udc_user_dynamic_info WHERE `dynamic_id` = ?";

	@Override
	public void save(UserDynamicInfo userDynamicInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicInfo);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		userDynamicInfo.setDynamicId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(UserDynamicInfo userDynamicInfo) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(userDynamicInfo);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(UserDynamicInfo userDynamicInfo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE udc_user_dynamic_info SET ");
		if(userDynamicInfo.getDynamicId() != null){
			sql.append(" dynamic_id = ?, ");
			param.add(userDynamicInfo.getDynamicId());
		}
		if(userDynamicInfo.getUserId() != null){
			sql.append(" user_id = ?, ");
			param.add(userDynamicInfo.getUserId());
		}
		if(userDynamicInfo.getOriginalUserId() != null){
			sql.append(" original_user_id = ?, ");
			param.add(userDynamicInfo.getOriginalUserId());
		}
		if(userDynamicInfo.getType() != null){
			sql.append(" type = ?, ");
			param.add(userDynamicInfo.getType());
		}
		if(userDynamicInfo.getTitle() != null){
			sql.append(" title = ?, ");
			param.add(userDynamicInfo.getTitle());
		}
		if(userDynamicInfo.getMark() != null){
			sql.append(" mark = ?, ");
			param.add(userDynamicInfo.getMark());
		}
		if(userDynamicInfo.getSeeRange() != null){
			sql.append(" see_range = ?, ");
			param.add(userDynamicInfo.getSeeRange());
		}
		if(userDynamicInfo.getCommentRange() != null){
			sql.append(" comment_range = ?, ");
			param.add(userDynamicInfo.getCommentRange());
		}
		if(userDynamicInfo.getShowLocation() != null){
			sql.append(" show_location = ?, ");
			param.add(userDynamicInfo.getShowLocation());
		}
		if(userDynamicInfo.getLocal() != null){
			sql.append(" local = ?, ");
			param.add(userDynamicInfo.getLocal());
		}
		if(userDynamicInfo.getImagePath() != null){
			sql.append(" image_path = ?, ");
			param.add(userDynamicInfo.getImagePath());
		}
		if(userDynamicInfo.getSeeIsReward() != null){
			sql.append(" see_is_reward = ?, ");
			param.add(userDynamicInfo.getSeeIsReward());
		}
		if(userDynamicInfo.getSeeRewardSailCoinNum() != null){
			sql.append(" see_reward_sail_coin_num = ?, ");
			param.add(userDynamicInfo.getSeeRewardSailCoinNum());
		}
		if(userDynamicInfo.getIsDel() != null){
			sql.append(" is_del = ?, ");
			param.add(userDynamicInfo.getIsDel());
		}
		if(userDynamicInfo.getForwardNum() != null){
			sql.append(" forward_num = ?, ");
			param.add(userDynamicInfo.getForwardNum());
		}
		if(userDynamicInfo.getPraiseNum() != null){
			sql.append(" praise_num = ?, ");
			param.add(userDynamicInfo.getPraiseNum());
		}
		if(userDynamicInfo.getCommentNum() != null){
			sql.append(" comment_num = ?, ");
			param.add(userDynamicInfo.getCommentNum());
		}
		if(userDynamicInfo.getShareNum() != null){
			sql.append(" share_num = ?, ");
			param.add(userDynamicInfo.getShareNum());
		}
		if(userDynamicInfo.getIsForward() != null){
			sql.append(" is_forward = ?, ");
			param.add(userDynamicInfo.getIsForward());
		}
		if(userDynamicInfo.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(userDynamicInfo.getCreateDate());
		}
		if(userDynamicInfo.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(userDynamicInfo.getUpdateDate());
		}
		if(userDynamicInfo.getRemark() != null){
			sql.append(" remark = ?, ");
			param.add(userDynamicInfo.getRemark());
		}
		if(userDynamicInfo.getParentDynamicId() != null){
			sql.append(" parent_dynamic_id = ?, ");
			param.add(userDynamicInfo.getParentDynamicId());
		}
		if(userDynamicInfo.getAuditStatus() != null){
			sql.append(" audit_status = ?, ");
			param.add(userDynamicInfo.getAuditStatus());
		}
		if(userDynamicInfo.getAuditDate() != null){
			sql.append(" audit_date = ?, ");
			param.add(userDynamicInfo.getAuditDate());
		}
		if(userDynamicInfo.getAuditDesc() != null){
			sql.append(" audit_desc = ?, ");
			param.add(userDynamicInfo.getAuditDesc());
		}
		if(userDynamicInfo.getAuditName() != null){
			sql.append(" audit_name = ?, ");
			param.add(userDynamicInfo.getAuditName());
		}
		if(userDynamicInfo.getGiveUserId() != null){
			sql.append(" give_user_id = ?, ");
			param.add(userDynamicInfo.getGiveUserId());
		}
		if(userDynamicInfo.getGroupId() != null){
			sql.append(" group_id = ?, ");
			param.add(userDynamicInfo.getGroupId());
		}
		if(userDynamicInfo.getIsInput() != null){
			sql.append(" is_input = ? ");
			param.add(userDynamicInfo.getIsInput());
		}
		sql.append(" WHERE dynamic_id = ? ");
		param.add(userDynamicInfo.getDynamicId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicInfos
	 * @return
	 */
	public Map<String, Object>[] toMap(List<UserDynamicInfo> userDynamicInfos){
		Map<String, Object>[] maps = new Map[userDynamicInfos.size()];
		for(int i = 0; i < userDynamicInfos.size(); i++){
			UserDynamicInfo userDynamicInfo = userDynamicInfos.get(i);
			maps[i] = toMap(userDynamicInfo);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param userDynamicInfo
	 * @return
	 */
	public Map<String, Object> toMap(UserDynamicInfo userDynamicInfo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("dynamic_id", userDynamicInfo.getDynamicId());
        paramMap.put("user_id", userDynamicInfo.getUserId());
        paramMap.put("original_user_id", userDynamicInfo.getOriginalUserId());
        paramMap.put("type", userDynamicInfo.getType());
        paramMap.put("title", userDynamicInfo.getTitle());
        paramMap.put("mark", userDynamicInfo.getMark());
        paramMap.put("see_range", userDynamicInfo.getSeeRange());
        paramMap.put("comment_range", userDynamicInfo.getCommentRange());
        paramMap.put("show_location", userDynamicInfo.getShowLocation());
        paramMap.put("local", userDynamicInfo.getLocal());
        paramMap.put("image_path", userDynamicInfo.getImagePath());
        paramMap.put("see_is_reward", userDynamicInfo.getSeeIsReward());
        paramMap.put("see_reward_sail_coin_num", userDynamicInfo.getSeeRewardSailCoinNum());
        paramMap.put("is_del", userDynamicInfo.getIsDel());
        paramMap.put("forward_num", userDynamicInfo.getForwardNum());
        paramMap.put("praise_num", userDynamicInfo.getPraiseNum());
        paramMap.put("comment_num", userDynamicInfo.getCommentNum());
        paramMap.put("share_num", userDynamicInfo.getShareNum());
        paramMap.put("is_forward", userDynamicInfo.getIsForward());
        paramMap.put("create_date", userDynamicInfo.getCreateDate());
        paramMap.put("update_date", userDynamicInfo.getUpdateDate());
        paramMap.put("remark", userDynamicInfo.getRemark());
        paramMap.put("parent_dynamic_id", userDynamicInfo.getParentDynamicId());
        paramMap.put("audit_status", userDynamicInfo.getAuditStatus());
        paramMap.put("audit_date", userDynamicInfo.getAuditDate());
        paramMap.put("audit_desc", userDynamicInfo.getAuditDesc());
        paramMap.put("audit_name", userDynamicInfo.getAuditName());
        paramMap.put("give_user_id", userDynamicInfo.getGiveUserId());
        paramMap.put("group_id", userDynamicInfo.getGroupId());
        paramMap.put("is_input", userDynamicInfo.getIsInput());
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
	public void delete(Long dynamicId){
		jdbcTemplate.update(DELETE_SQL, dynamicId);
	}

	@Override
	public void batchSave(List<UserDynamicInfo> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<UserDynamicInfo> list){
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
	 * @param dynamicId 动态ID,自增ID
	 * @return UserDynamicInfo
	 */
	@Override
	public UserDynamicInfo findById(Long dynamicId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`dynamic_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(UserDynamicInfo.class), dynamicId);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @return List
	 */
	@Override
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo){
		return this.find(userDynamicInfo, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, String[][] orders){
		return this.find(userDynamicInfo, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, Long offset, Long rows){
		return this.find(userDynamicInfo, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param userDynamicInfo
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<UserDynamicInfo> find(UserDynamicInfo userDynamicInfo, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(userDynamicInfo != null){
			if(userDynamicInfo.getDynamicId() != null){
				sql.append(" AND _this.`dynamic_id` = ?");
				param.add(userDynamicInfo.getDynamicId());
			}
			if(userDynamicInfo.getUserId() != null){
				sql.append(" AND _this.`user_id` = ?");
				param.add(userDynamicInfo.getUserId());
			}
			if(userDynamicInfo.getOriginalUserId() != null){
				sql.append(" AND _this.`original_user_id` = ?");
				param.add(userDynamicInfo.getOriginalUserId());
			}
			if(userDynamicInfo.getType() != null && !"".equals(userDynamicInfo.getType())){
				sql.append(" AND _this.`type` = ?");
				param.add(userDynamicInfo.getType());
			}
			if(userDynamicInfo.getTitle() != null && !"".equals(userDynamicInfo.getTitle())){
				sql.append(" AND _this.`title` = ?");
				param.add(userDynamicInfo.getTitle());
			}
			if(userDynamicInfo.getMark() != null && !"".equals(userDynamicInfo.getMark())){
				sql.append(" AND _this.`mark` = ?");
				param.add(userDynamicInfo.getMark());
			}
			if(userDynamicInfo.getSeeRange() != null && !"".equals(userDynamicInfo.getSeeRange())){
				sql.append(" AND _this.`see_range` = ?");
				param.add(userDynamicInfo.getSeeRange());
			}
			if(userDynamicInfo.getCommentRange() != null && !"".equals(userDynamicInfo.getCommentRange())){
				sql.append(" AND _this.`comment_range` = ?");
				param.add(userDynamicInfo.getCommentRange());
			}
			if(userDynamicInfo.getShowLocation() != null && !"".equals(userDynamicInfo.getShowLocation())){
				sql.append(" AND _this.`show_location` = ?");
				param.add(userDynamicInfo.getShowLocation());
			}
			if(userDynamicInfo.getLocal() != null && !"".equals(userDynamicInfo.getLocal())){
				sql.append(" AND _this.`local` = ?");
				param.add(userDynamicInfo.getLocal());
			}
			if(userDynamicInfo.getImagePath() != null && !"".equals(userDynamicInfo.getImagePath())){
				sql.append(" AND _this.`image_path` = ?");
				param.add(userDynamicInfo.getImagePath());
			}
			if(userDynamicInfo.getSeeIsReward() != null && !"".equals(userDynamicInfo.getSeeIsReward())){
				sql.append(" AND _this.`see_is_reward` = ?");
				param.add(userDynamicInfo.getSeeIsReward());
			}
			if(userDynamicInfo.getIsDel() != null && !"".equals(userDynamicInfo.getIsDel())){
				sql.append(" AND _this.`is_del` = ?");
				param.add(userDynamicInfo.getIsDel());
			}
			if(userDynamicInfo.getForwardNum() != null){
				sql.append(" AND _this.`forward_num` = ?");
				param.add(userDynamicInfo.getForwardNum());
			}
			if(userDynamicInfo.getPraiseNum() != null){
				sql.append(" AND _this.`praise_num` = ?");
				param.add(userDynamicInfo.getPraiseNum());
			}
			if(userDynamicInfo.getCommentNum() != null){
				sql.append(" AND _this.`comment_num` = ?");
				param.add(userDynamicInfo.getCommentNum());
			}
			if(userDynamicInfo.getShareNum() != null){
				sql.append(" AND _this.`share_num` = ?");
				param.add(userDynamicInfo.getShareNum());
			}
			if(userDynamicInfo.getIsForward() != null && !"".equals(userDynamicInfo.getIsForward())){
				sql.append(" AND _this.`is_forward` = ?");
				param.add(userDynamicInfo.getIsForward());
			}
			if(userDynamicInfo.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(userDynamicInfo.getCreateDate());
			}
			if(userDynamicInfo.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(userDynamicInfo.getUpdateDate());
			}
			if(userDynamicInfo.getRemark() != null && !"".equals(userDynamicInfo.getRemark())){
				sql.append(" AND _this.`remark` = ?");
				param.add(userDynamicInfo.getRemark());
			}
			if(userDynamicInfo.getParentDynamicId() != null){
				sql.append(" AND _this.`parent_dynamic_id` = ?");
				param.add(userDynamicInfo.getParentDynamicId());
			}
			if(userDynamicInfo.getAuditStatus() != null && !"".equals(userDynamicInfo.getAuditStatus())){
				sql.append(" AND _this.`audit_status` = ?");
				param.add(userDynamicInfo.getAuditStatus());
			}
			if(userDynamicInfo.getAuditDate() != null){
				sql.append(" AND _this.`audit_date` = ?");
				param.add(userDynamicInfo.getAuditDate());
			}
			if(userDynamicInfo.getAuditDesc() != null && !"".equals(userDynamicInfo.getAuditDesc())){
				sql.append(" AND _this.`audit_desc` = ?");
				param.add(userDynamicInfo.getAuditDesc());
			}
			if(userDynamicInfo.getAuditName() != null && !"".equals(userDynamicInfo.getAuditName())){
				sql.append(" AND _this.`audit_name` = ?");
				param.add(userDynamicInfo.getAuditName());
			}
			if(userDynamicInfo.getGiveUserId() != null){
				sql.append(" AND _this.`give_user_id` = ?");
				param.add(userDynamicInfo.getGiveUserId());
			}
			if(userDynamicInfo.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ?");
				param.add(userDynamicInfo.getGroupId());
			}
			if(userDynamicInfo.getIsInput() != null && !"".equals(userDynamicInfo.getIsInput())){
				sql.append(" AND _this.`is_input` = ?");
				param.add(userDynamicInfo.getIsInput());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(UserDynamicInfo.class));
	}


	/**
	 * 根据对象查询条数
	 * @param userDynamicInfo
	 * @return Long
	 */
	@Override
	public Long count(UserDynamicInfo userDynamicInfo){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM udc_user_dynamic_info  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(userDynamicInfo != null){
			if(userDynamicInfo.getDynamicId() != null){
				sql.append(" AND _this.`dynamic_id` = ? ");
				param.add(userDynamicInfo.getDynamicId());
			}
			if(userDynamicInfo.getUserId() != null){
				sql.append(" AND _this.`user_id` = ? ");
				param.add(userDynamicInfo.getUserId());
			}
			if(userDynamicInfo.getOriginalUserId() != null){
				sql.append(" AND _this.`original_user_id` = ? ");
				param.add(userDynamicInfo.getOriginalUserId());
			}
			if(userDynamicInfo.getType() != null && !"".equals(userDynamicInfo.getType())){
				sql.append(" AND _this.`type` = ? ");
				param.add(userDynamicInfo.getType());
			}
			if(userDynamicInfo.getTitle() != null && !"".equals(userDynamicInfo.getTitle())){
				sql.append(" AND _this.`title` = ? ");
				param.add(userDynamicInfo.getTitle());
			}
			if(userDynamicInfo.getMark() != null && !"".equals(userDynamicInfo.getMark())){
				sql.append(" AND _this.`mark` = ? ");
				param.add(userDynamicInfo.getMark());
			}
			if(userDynamicInfo.getSeeRange() != null && !"".equals(userDynamicInfo.getSeeRange())){
				sql.append(" AND _this.`see_range` = ? ");
				param.add(userDynamicInfo.getSeeRange());
			}
			if(userDynamicInfo.getCommentRange() != null && !"".equals(userDynamicInfo.getCommentRange())){
				sql.append(" AND _this.`comment_range` = ? ");
				param.add(userDynamicInfo.getCommentRange());
			}
			if(userDynamicInfo.getShowLocation() != null && !"".equals(userDynamicInfo.getShowLocation())){
				sql.append(" AND _this.`show_location` = ? ");
				param.add(userDynamicInfo.getShowLocation());
			}
			if(userDynamicInfo.getLocal() != null && !"".equals(userDynamicInfo.getLocal())){
				sql.append(" AND _this.`local` = ? ");
				param.add(userDynamicInfo.getLocal());
			}
			if(userDynamicInfo.getImagePath() != null && !"".equals(userDynamicInfo.getImagePath())){
				sql.append(" AND _this.`image_path` = ? ");
				param.add(userDynamicInfo.getImagePath());
			}
			if(userDynamicInfo.getSeeIsReward() != null && !"".equals(userDynamicInfo.getSeeIsReward())){
				sql.append(" AND _this.`see_is_reward` = ? ");
				param.add(userDynamicInfo.getSeeIsReward());
			}
			if(userDynamicInfo.getIsDel() != null && !"".equals(userDynamicInfo.getIsDel())){
				sql.append(" AND _this.`is_del` = ? ");
				param.add(userDynamicInfo.getIsDel());
			}
			if(userDynamicInfo.getForwardNum() != null){
				sql.append(" AND _this.`forward_num` = ? ");
				param.add(userDynamicInfo.getForwardNum());
			}
			if(userDynamicInfo.getPraiseNum() != null){
				sql.append(" AND _this.`praise_num` = ? ");
				param.add(userDynamicInfo.getPraiseNum());
			}
			if(userDynamicInfo.getCommentNum() != null){
				sql.append(" AND _this.`comment_num` = ? ");
				param.add(userDynamicInfo.getCommentNum());
			}
			if(userDynamicInfo.getShareNum() != null){
				sql.append(" AND _this.`share_num` = ? ");
				param.add(userDynamicInfo.getShareNum());
			}
			if(userDynamicInfo.getIsForward() != null && !"".equals(userDynamicInfo.getIsForward())){
				sql.append(" AND _this.`is_forward` = ? ");
				param.add(userDynamicInfo.getIsForward());
			}
			if(userDynamicInfo.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(userDynamicInfo.getCreateDate());
			}
			if(userDynamicInfo.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(userDynamicInfo.getUpdateDate());
			}
			if(userDynamicInfo.getRemark() != null && !"".equals(userDynamicInfo.getRemark())){
				sql.append(" AND _this.`remark` = ? ");
				param.add(userDynamicInfo.getRemark());
			}
			if(userDynamicInfo.getParentDynamicId() != null){
				sql.append(" AND _this.`parent_dynamic_id` = ? ");
				param.add(userDynamicInfo.getParentDynamicId());
			}
			if(userDynamicInfo.getAuditStatus() != null && !"".equals(userDynamicInfo.getAuditStatus())){
				sql.append(" AND _this.`audit_status` = ? ");
				param.add(userDynamicInfo.getAuditStatus());
			}
			if(userDynamicInfo.getAuditDate() != null){
				sql.append(" AND _this.`audit_date` = ? ");
				param.add(userDynamicInfo.getAuditDate());
			}
			if(userDynamicInfo.getAuditDesc() != null && !"".equals(userDynamicInfo.getAuditDesc())){
				sql.append(" AND _this.`audit_desc` = ? ");
				param.add(userDynamicInfo.getAuditDesc());
			}
			if(userDynamicInfo.getAuditName() != null && !"".equals(userDynamicInfo.getAuditName())){
				sql.append(" AND _this.`audit_name` = ? ");
				param.add(userDynamicInfo.getAuditName());
			}
			if(userDynamicInfo.getGiveUserId() != null){
				sql.append(" AND _this.`give_user_id` = ? ");
				param.add(userDynamicInfo.getGiveUserId());
			}
			if(userDynamicInfo.getGroupId() != null){
				sql.append(" AND _this.`group_id` = ? ");
				param.add(userDynamicInfo.getGroupId());
			}
			if(userDynamicInfo.getIsInput() != null && !"".equals(userDynamicInfo.getIsInput())){
				sql.append(" AND _this.`is_input` = ? ");
				param.add(userDynamicInfo.getIsInput());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}