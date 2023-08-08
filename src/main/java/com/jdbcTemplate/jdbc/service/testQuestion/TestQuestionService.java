package com.jdbcTemplate.jdbc.service.testQuestion;

import com.jdbcTemplate.jdbc.model.request.testQuestion.CreateTestQuestionRequest;
import com.jdbcTemplate.jdbc.model.request.testQuestion.UpdateTestQuestionRequest;
import com.jdbcTemplate.jdbc.model.response.testQuestion.TestQuestionGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.testQuestion.TestQuestionGetByIdResponse;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestDeleteByIdResponse;

public interface TestQuestionService {
	public TestQuestionGetByIdResponse getById(int id);
	public TestQuestionGetByIdResponse insert(CreateTestQuestionRequest createTestQuestionRequest);
	public TestQuestionGetAllResponse getAll();
	public TestQuestionGetByIdResponse update(UpdateTestQuestionRequest updateTestQuestionRequest,int id);
	public UnitTestDeleteByIdResponse deleteById(int id);
}
