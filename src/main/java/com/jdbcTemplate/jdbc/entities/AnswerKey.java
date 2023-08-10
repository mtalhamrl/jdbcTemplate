package com.jdbcTemplate.jdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerKey {
	private int id;
	private String grade_name;
	private int grade_id;
	private String course_name;
	private int course_id;
	private String coursesunit_name;
	private int coursesunit_id;
	private String test_name;
	private int test_id;
	private String question_no;
	private String question_answer;
	private int question_id;
}
