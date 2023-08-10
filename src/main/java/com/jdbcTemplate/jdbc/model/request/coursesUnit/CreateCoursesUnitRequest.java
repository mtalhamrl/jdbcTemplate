package com.jdbcTemplate.jdbc.model.request.coursesUnit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCoursesUnitRequest {
	private int id;
	private String unit;
	private int course_id;
}
