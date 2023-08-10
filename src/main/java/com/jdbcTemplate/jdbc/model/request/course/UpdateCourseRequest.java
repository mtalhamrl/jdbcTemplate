package com.jdbcTemplate.jdbc.model.request.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseRequest {

	private String course_name;
	private int grade_id;
}
