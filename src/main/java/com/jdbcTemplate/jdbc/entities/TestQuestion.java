package com.jdbcTemplate.jdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestQuestion {
	private int id;
	private String question_no;
	private String question_answer;
	private int test_id;
}
