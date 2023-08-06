package com.jdbcTemplate.jdbc.model.request.studentsGrade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentsGradeRequest {
	private int grade;
}
