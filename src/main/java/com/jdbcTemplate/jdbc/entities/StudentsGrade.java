package com.jdbcTemplate.jdbc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsGrade {
private int id;
private int grade;
private int course_id;
}
