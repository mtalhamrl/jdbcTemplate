package com.jdbcTemplate.jdbc.model.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbcTemplate.jdbc.entities.TestQuestion;

public class TestQuestionRowMapper implements RowMapper<TestQuestion>{

	@Override
	public TestQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
		TestQuestion testQuestion = new TestQuestion();
		testQuestion.setId(rs.getInt("id"));
		testQuestion.setQuestion_no(rs.getInt("question_no"));
		testQuestion.setQuestion_answer(rs.getString("question_answer"));
		return testQuestion;
	}

}
