package com.jdbcTemplate.jdbc.model.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.jdbcTemplate.jdbc.entities.AnswerKey;

public class AnswerKeyRowMapper implements RowMapper<List<AnswerKey>>{

	@Override
	public List<AnswerKey> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, AnswerKey> answerKeyMap = new LinkedHashMap<>();	                
        while (rs.next()) {
    String testNo =	rs.getString("id"); //id= unit_test table primary key.
	AnswerKey answer= answerKeyMap.getOrDefault(testNo, new AnswerKey(
			rs.getString("grade_name"),
			rs.getString("course_name"),
			rs.getString("unit"),
			rs.getString("test_no"),
			new HashMap<String, String>()
			));
	answer.getAnswerMap().put(rs.getString("question_no"),rs.getString("question_answer"));
	answerKeyMap.put(testNo,answer);
        }
	return new ArrayList<AnswerKey>(answerKeyMap.values());
        }                            
	}


