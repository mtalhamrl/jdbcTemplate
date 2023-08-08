package com.jdbcTemplate.jdbc.model.response.testQuestion;

import com.jdbcTemplate.jdbc.entities.TestQuestion;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TestQuestionGetByIdResponse extends BaseResponse{
	TestQuestion testQuestion;

}
