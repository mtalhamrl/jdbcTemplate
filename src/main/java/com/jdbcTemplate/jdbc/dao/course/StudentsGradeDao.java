package com.jdbcTemplate.jdbc.dao.course;

import java.util.List;

import com.jdbcTemplate.jdbc.entities.StudentsGrade;

public interface StudentsGradeDao {
	public int insert(StudentsGrade studentsGrade);
	public List<StudentsGrade> getAll();
	public int update(StudentsGrade studentsGrade);
	public StudentsGrade getById(int id);
	public int deleteById(int id);
}
