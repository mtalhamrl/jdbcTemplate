package com.jdbcTemplate.jdbc.dao.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbcTemplate.jdbc.entities.StudentsGrade;
import com.jdbcTemplate.jdbc.model.Mappers.StudentsGradeRowMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component("StudentsGradeDao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsGradeDaoImpl implements StudentsGradeDao{
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	@Override
	public int insert(StudentsGrade studentsGrade) {
		String sql=" insert into studentsgrade values(?,?)";
		return jdbcTemplate.update(sql,studentsGrade.getId(),studentsGrade.getGrade());
	}

	@Override
	public List<StudentsGrade> getAll() {
		String Sql="select * from studentsgrade";
		List<StudentsGrade> studentsGrades = jdbcTemplate.query(Sql,new StudentsGradeRowMapper());
		return studentsGrades;
	}

	@Override
	public int update(StudentsGrade studentsGrade) {
		return 0;
	}

	@Override
	public StudentsGrade getById(int id) {
		return null;
	}

	@Override
	public int deleteById(int id) {
		return 0;
	}

}
