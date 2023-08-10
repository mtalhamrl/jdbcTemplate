package com.jdbcTemplate.jdbc.dao.studentsGrade;

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
		return jdbcTemplate.update(sql,studentsGrade.getId(),studentsGrade.getGrade_name());
	}

	@Override
	public List<StudentsGrade> getAll() {
		String Sql="select * from studentsgrade";
		List<StudentsGrade> studentsGrades = jdbcTemplate.query(Sql,new StudentsGradeRowMapper());
		return studentsGrades;
	}

	@Override
	public int update(StudentsGrade studentsGrade) {
		String Sql="update studentsgrade set grade_name=? where id=?";
		return jdbcTemplate.update(Sql,studentsGrade.getGrade_name(),studentsGrade.getId());
	}

	@Override
	public StudentsGrade getById(int id) {
		String Sql= "select * from studentsgrade where id =?";
		return jdbcTemplate.queryForObject(Sql,new StudentsGradeRowMapper(),id);
	}

	@Override
	public int deleteById(int id) {
		String Sql="delete from studentsgrade where id=?";
		return jdbcTemplate.update(Sql,id);
	}

}
