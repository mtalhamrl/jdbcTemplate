package com.jdbcTemplate.jdbc.model.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbcTemplate.jdbc.entities.StudentsGrade;

public class StudentsGradeRowMapper implements RowMapper<StudentsGrade>{

	@Override
	public StudentsGrade mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentsGrade studentsGrade = new StudentsGrade();
		studentsGrade.setId(rs.getInt("id"));
		studentsGrade.setGrade(rs.getInt("grade"));
		studentsGrade.setCourse_id(rs.getInt("course_id"));
	  return studentsGrade; 
	}
}
