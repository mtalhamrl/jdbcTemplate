package com.jdbcTemplate.jdbc.dao.testQuestion;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbcTemplate.jdbc.entities.TestQuestion;
import com.jdbcTemplate.jdbc.model.Mappers.TestQuestionRowMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component("TestQuestionDao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestQuestionDaoImpl implements TestQuestionDao{
	JdbcTemplate jdbcTemplate;
	TestQuestion testQuestion;
	@Override
	public TestQuestion getById(int id) {
		String sql="select *from test_question where id=?";
		return jdbcTemplate.queryForObject(sql,new TestQuestionRowMapper(),id );
	}

	@Override
	public int insert(TestQuestion testQuestion) {
		String sql="insert into test_question values(?,?,?)";
		return jdbcTemplate.update(sql,testQuestion.getId(),testQuestion.getQuestion_no(),testQuestion.getQuestion_answer());
	}

	@Override
	public List<TestQuestion> getAll() {
		String sql="select *from test_question";
		return jdbcTemplate.query(sql, new TestQuestionRowMapper());
	}
	
	@Override
	public int update(TestQuestion testQuestion) {
		String sql="update test_question set question_no,question_answer where id=?";
		return jdbcTemplate.update(sql,testQuestion.getId());
	}

	@Override
	public int deleteById(int id) {
		String sql="delete from test_question where id=?";
		return jdbcTemplate.update(sql,id);
	}

}
