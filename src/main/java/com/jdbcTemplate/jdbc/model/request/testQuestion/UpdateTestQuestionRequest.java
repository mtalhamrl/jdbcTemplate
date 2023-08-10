package com.jdbcTemplate.jdbc.model.request.testQuestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTestQuestionRequest {
	private String question_no;
	private String question_answer;
	private int test_id;
}
