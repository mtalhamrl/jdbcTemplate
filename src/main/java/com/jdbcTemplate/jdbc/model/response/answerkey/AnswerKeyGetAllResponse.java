package com.jdbcTemplate.jdbc.model.response.answerkey;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.AnswerKey;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AnswerKeyGetAllResponse extends BaseResponse{
		List<AnswerKey> answerKeys;
}
