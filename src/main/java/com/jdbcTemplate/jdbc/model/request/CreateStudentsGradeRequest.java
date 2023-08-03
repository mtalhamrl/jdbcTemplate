package com.jdbcTemplate.jdbc.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentsGradeRequest {
	private int id;
	private int grade;
}
