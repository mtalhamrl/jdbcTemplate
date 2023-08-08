package com.jdbcTemplate.jdbc.dao.testQuestion;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.TestQuestion;

public interface TestQuestionDao {
	public TestQuestion getById(int id);
	public int insert(TestQuestion testQuestion);
	public List<TestQuestion> getAll();
	public int update(TestQuestion testQuestion);
	public int deleteById(int id);
}
