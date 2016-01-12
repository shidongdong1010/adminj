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

import com.lhy.adminj.basic.dao.base.SysSensitiveWordBaseDao;
import com.lhy.adminj.basic.model.SysSensitiveWord;

/**
 * 敏感词库Dao基础操作接口实现
 *
 * @author SDD
 * @version $v: 1.0.0, $time:2015-09-29 15:57:00 Exp $
 */
public class SysSensitiveWordBaseDaoImpl implements SysSensitiveWordBaseDao{
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 查询字段的SQL **/
	public static String SELECT_COLUMN_SQL = "_this.`word_id`, _this.`word`, _this.`math_type`, _this.`create_date`, _this.`update_date`, _this.`is_valid`";
	/** 查询SQL **/
	public static String SELECT_SQL = "SELECT _this.`word_id`, _this.`word`, _this.`math_type`, _this.`create_date`, _this.`update_date`, _this.`is_valid` FROM sys_sensitive_word _this";
	/** 插入SQL **/
	public static String INSERT_SQL = "INSERT INTO sys_sensitive_word(`word_id`, `word`, `math_type`, `create_date`, `update_date`, `is_valid`) VALUES (:word_id, :word, :math_type, :create_date, :update_date, :is_valid)";
	/** 更新SQL **/
	public static String UPDATE_SQL = "UPDATE sys_sensitive_word SET `word_id` = :word_id, `word` = :word, `math_type` = :math_type, `create_date` = :create_date, `update_date` = :update_date, `is_valid` = :is_valid WHERE `word_id` = :word_id";
	/** 删除SQL **/
	public static String DELETE_SQL = "DELETE FROM sys_sensitive_word WHERE `word_id` = ?";

	@Override
	public void save(SysSensitiveWord sysSensitiveWord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(sysSensitiveWord);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		new NamedParameterJdbcTemplate(jdbcTemplate).update(INSERT_SQL, new MapSqlParameterSource(paramMap), keyHolder);
		
		// 生成主键
		sysSensitiveWord.setWordId(keyHolder.getKey().longValue());
	}
	
	@Override
	public void update(SysSensitiveWord sysSensitiveWord) {
		// 构造SQL的参数
		Map<String, Object> paramMap = toMap(sysSensitiveWord);
		new NamedParameterJdbcTemplate(jdbcTemplate).update(UPDATE_SQL, paramMap);
	}

	@Override
	public void modify(SysSensitiveWord sysSensitiveWord) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new ArrayList<Object>();
		sql.append(" UPDATE sys_sensitive_word SET ");
		if(sysSensitiveWord.getWordId() != null){
			sql.append(" word_id = ?, ");
			param.add(sysSensitiveWord.getWordId());
		}
		if(sysSensitiveWord.getWord() != null){
			sql.append(" word = ?, ");
			param.add(sysSensitiveWord.getWord());
		}
		if(sysSensitiveWord.getMathType() != null){
			sql.append(" math_type = ?, ");
			param.add(sysSensitiveWord.getMathType());
		}
		if(sysSensitiveWord.getCreateDate() != null){
			sql.append(" create_date = ?, ");
			param.add(sysSensitiveWord.getCreateDate());
		}
		if(sysSensitiveWord.getUpdateDate() != null){
			sql.append(" update_date = ?, ");
			param.add(sysSensitiveWord.getUpdateDate());
		}
		if(sysSensitiveWord.getIsValid() != null){
			sql.append(" is_valid = ? ");
			param.add(sysSensitiveWord.getIsValid());
		}
		sql.append(" WHERE word_id = ? ");
		param.add(sysSensitiveWord.getWordId());

		jdbcTemplate.update(sql.toString(), param.toArray());
	}

	/**
	 * 将对象转换成Map
	 * @param sysSensitiveWords
	 * @return
	 */
	public Map<String, Object>[] toMap(List<SysSensitiveWord> sysSensitiveWords){
		Map<String, Object>[] maps = new Map[sysSensitiveWords.size()];
		for(int i = 0; i < sysSensitiveWords.size(); i++){
			SysSensitiveWord sysSensitiveWord = sysSensitiveWords.get(i);
			maps[i] = toMap(sysSensitiveWord);
		}
		return maps;
	}

	/**
	 * 将对象转换成Map
	 * @param sysSensitiveWord
	 * @return
	 */
	public Map<String, Object> toMap(SysSensitiveWord sysSensitiveWord){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("word_id", sysSensitiveWord.getWordId());
        paramMap.put("word", sysSensitiveWord.getWord());
        paramMap.put("math_type", sysSensitiveWord.getMathType());
        paramMap.put("create_date", sysSensitiveWord.getCreateDate());
        paramMap.put("update_date", sysSensitiveWord.getUpdateDate());
        paramMap.put("is_valid", sysSensitiveWord.getIsValid());
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
	public void delete(Long wordId){
		jdbcTemplate.update(DELETE_SQL, wordId);
	}

	@Override
	public void batchSave(List<SysSensitiveWord> list){
		Map<String, Object>[] params = toMap(list);
		new NamedParameterJdbcTemplate(jdbcTemplate).batchUpdate(INSERT_SQL, params);
	}

	@Override
	public void batchUpdate(List<SysSensitiveWord> list){
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
	 * @param wordId 敏感词ID
	 * @return SysSensitiveWord
	 */
	@Override
	public SysSensitiveWord findById(Long wordId){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE _this.`word_id` = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(SysSensitiveWord.class), wordId);
	}

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @return List
	 */
	@Override
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord){
		return this.find(sysSensitiveWord, null, null);
	}

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
	 * @return List
	 */
	@Override
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, String[][] orders){
		return this.find(sysSensitiveWord, orders, null, null);
	}

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, Long offset, Long rows){
		return this.find(sysSensitiveWord, null, offset, rows);
	}

	/**
	 * 根据对象查询
	 * @param sysSensitiveWord
	 * @param orders 排序字段，可多字段排序。格式{{"字段名", "asc"}, {"字段名, "desc"}}
     * @param offset 开始索引
     * @param rows 条数(从第offset+1条开始，取rows条)
	 * @return List
	 */
	@Override
	public List<SysSensitiveWord> find(SysSensitiveWord sysSensitiveWord, String[][] orders, Long offset, Long rows){
		StringBuilder sql = new StringBuilder();
		sql.append(SELECT_SQL);
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
    	if(sysSensitiveWord != null){
			if(sysSensitiveWord.getWordId() != null){
				sql.append(" AND _this.`word_id` = ?");
				param.add(sysSensitiveWord.getWordId());
			}
			if(sysSensitiveWord.getWord() != null && !"".equals(sysSensitiveWord.getWord())){
				sql.append(" AND _this.`word` = ?");
				param.add(sysSensitiveWord.getWord());
			}
			if(sysSensitiveWord.getMathType() != null && !"".equals(sysSensitiveWord.getMathType())){
				sql.append(" AND _this.`math_type` = ?");
				param.add(sysSensitiveWord.getMathType());
			}
			if(sysSensitiveWord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ?");
				param.add(sysSensitiveWord.getCreateDate());
			}
			if(sysSensitiveWord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ?");
				param.add(sysSensitiveWord.getUpdateDate());
			}
			if(sysSensitiveWord.getIsValid() != null && !"".equals(sysSensitiveWord.getIsValid())){
				sql.append(" AND _this.`is_valid` = ?");
				param.add(sysSensitiveWord.getIsValid());
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
		return jdbcTemplate.query(sql.toString(), param.toArray(), BeanPropertyRowMapper.newInstance(SysSensitiveWord.class));
	}


	/**
	 * 根据对象查询条数
	 * @param sysSensitiveWord
	 * @return Long
	 */
	@Override
	public Long count(SysSensitiveWord sysSensitiveWord){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT count(*) ");
		sql.append(" FROM sys_sensitive_word  _this ");
		sql.append(" WHERE 1 = 1 ");

		List<Object> param = new ArrayList<Object>();
        if(sysSensitiveWord != null){
			if(sysSensitiveWord.getWordId() != null){
				sql.append(" AND _this.`word_id` = ? ");
				param.add(sysSensitiveWord.getWordId());
			}
			if(sysSensitiveWord.getWord() != null && !"".equals(sysSensitiveWord.getWord())){
				sql.append(" AND _this.`word` = ? ");
				param.add(sysSensitiveWord.getWord());
			}
			if(sysSensitiveWord.getMathType() != null && !"".equals(sysSensitiveWord.getMathType())){
				sql.append(" AND _this.`math_type` = ? ");
				param.add(sysSensitiveWord.getMathType());
			}
			if(sysSensitiveWord.getCreateDate() != null){
				sql.append(" AND _this.`create_date` = ? ");
				param.add(sysSensitiveWord.getCreateDate());
			}
			if(sysSensitiveWord.getUpdateDate() != null){
				sql.append(" AND _this.`update_date` = ? ");
				param.add(sysSensitiveWord.getUpdateDate());
			}
			if(sysSensitiveWord.getIsValid() != null && !"".equals(sysSensitiveWord.getIsValid())){
				sql.append(" AND _this.`is_valid` = ? ");
				param.add(sysSensitiveWord.getIsValid());
			}
		}
        return jdbcTemplate.queryForObject(sql.toString(), Long.class, param.toArray());
	}
}