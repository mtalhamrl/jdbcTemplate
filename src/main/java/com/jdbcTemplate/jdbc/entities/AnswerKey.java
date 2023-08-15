package com.jdbcTemplate.jdbc.entities;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerKey {
	private String grade_name;
	private String course_name;
	private String unit;
	private String test_no;
	private Map<String, String> answerMap;
	
}
