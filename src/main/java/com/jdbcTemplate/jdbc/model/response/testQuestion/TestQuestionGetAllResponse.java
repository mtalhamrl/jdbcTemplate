package com.jdbcTemplate.jdbc.model.response.testQuestion;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.TestQuestion;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TestQuestionGetAllResponse extends BaseResponse{
	List<TestQuestion> testQuestions;

}
