package com.jdbcTemplate.jdbc.dao.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbcTemplate.jdbc.entities.Course;
import com.jdbcTemplate.jdbc.model.Mappers.CourseRowMapperImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component("CourseDao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDaoImpl implements CourseDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int insert(Course createCourseRequest) {
		return jdbcTemplate.update("insert into Course values(?,?) ", createCourseRequest.getId(),createCourseRequest.getName());	      
	}
	@Override

	public List<Course> getAll() {
		String Sql="select * from Course";
		List<Course> courses = jdbcTemplate.query(Sql,new CourseRowMapperImpl());
		return courses;
	}
	@Override
	public int update(Course course) {
		String sql="update course set name=? where id =? ";
		return jdbcTemplate.update(sql,course.getName(),course.getId());

	}
	@Override
	public Course getById(int id) {
		String sql="select * from course where id=?";
		try {
		return jdbcTemplate.queryForObject(sql, new CourseRowMapperImpl(),id);		
	}catch(Exception e){
		if(!(e instanceof DataAccessException)) {
			return null;
		}
		return null;
	}
	}
	@Override
	public int deleteById(int id) {
		String sql="delete from course where id =?";
		return jdbcTemplate.update(sql,id);
		
	}
	
	
	}
	
	
		
	


