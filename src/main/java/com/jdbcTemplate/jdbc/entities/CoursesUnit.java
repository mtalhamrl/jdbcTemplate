package com.jdbcTemplate.jdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesUnit {
	private int id;
	private String unit;
	private int test_id;
}
