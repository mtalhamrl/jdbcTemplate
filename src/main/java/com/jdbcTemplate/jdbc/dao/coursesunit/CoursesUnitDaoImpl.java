package com.jdbcTemplate.jdbc.dao.coursesunit;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbcTemplate.jdbc.entities.CoursesUnit;
import com.jdbcTemplate.jdbc.model.Mappers.CoursesUnitRowMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component("CoursesUnitDao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoursesUnitDaoImpl implements CoursesUnitDao{
	private JdbcTemplate jdbcTemplate;
	private CoursesUnit coursesUnit;
	@Override
	public int insert(CoursesUnit coursesUnit) {
		String sql="insert into coursesunit values(?,?)";
		return jdbcTemplate.update(sql,coursesUnit.getId(),coursesUnit.getUnit());
	}

	@Override
	public List<CoursesUnit> getAll() {
		String sql="select *from coursesunit";
		List<CoursesUnit> coursesUnits = jdbcTemplate.query(sql, new CoursesUnitRowMapper());
		return coursesUnits;
	}

	@Override
	public int update(CoursesUnit coursesUnit) {
		String sql="update coursesunit set unit=? where id=?";
		return jdbcTemplate.update(sql,coursesUnit.getUnit(),coursesUnit.getId());
	}

	@Override
	public CoursesUnit getById(int id) {
		String sql="select *from coursesunit where id=?";
		return jdbcTemplate.queryForObject(sql, new CoursesUnitRowMapper(),id);
	}

	@Override
	public int deleteById(int id) {
		String sql="delete from coursesunit where id=?";
		return jdbcTemplate.update(sql,id);
	}

}
