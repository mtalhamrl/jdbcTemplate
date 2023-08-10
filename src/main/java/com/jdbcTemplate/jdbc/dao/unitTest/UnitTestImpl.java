package com.jdbcTemplate.jdbc.dao.unitTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbcTemplate.jdbc.entities.UnitTest;
import com.jdbcTemplate.jdbc.model.Mappers.UnitTestRowMapper;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Component("UnitTestDao")
@Data
@RequiredArgsConstructor

public class UnitTestImpl implements UnitTestDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int insert(UnitTest unitTest) {
		String sql="insert into unit_test values(?,?,?)";
		return jdbcTemplate.update(sql,unitTest.getId(),unitTest.getTest_no(),unitTest.getCoursesunit_id());
	}

	@Override
	public List<UnitTest> getAll() {
		String sql="select * from unit_test";
		return jdbcTemplate.query(sql, new UnitTestRowMapper());
	}

	@Override
	public int update(UnitTest unitTest) {
		String sql="update unit_test set unit where id=?";
		return jdbcTemplate.update(sql,unitTest.getId());
	}

	@Override
	public UnitTest getById(int id) {
		String sql="select *from unit_test where id=?";
		return jdbcTemplate.queryForObject(sql, new UnitTestRowMapper(),id);
	}

	@Override
	public int deleteById(int id) {
		String sql="delete from unit_test where id=?";
		return jdbcTemplate.update(sql,id);
	}

}
