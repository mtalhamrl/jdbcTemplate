package com.jdbcTemplate.jdbc.model.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbcTemplate.jdbc.entities.AnswerKey;

public class AnswerKeyRowMapper implements RowMapper<AnswerKey>{

	@Override
	public AnswerKey mapRow(ResultSet rs, int rowNum) throws SQLException {
		AnswerKey answerKey = new AnswerKey();
		answerKey.setId(rs.getInt("id"));
		answerKey.setGrade_name(rs.getString("grade_name"));
		answerKey.setGrade_id(rs.getInt("grade_id"));
		answerKey.getCourse_name(rs.getString("course_name"));
		
		return null;
	}

}
