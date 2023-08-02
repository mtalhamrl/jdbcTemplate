package com.jdbcTemplate.jdbc.dao.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jdbcTemplate.jdbc.entities.Course;
import com.jdbcTemplate.jdbc.model.Mappers.CourseRowMapperImpl;
import com.jdbcTemplate.jdbc.model.request.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.UpdateCourseRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component("CourseDao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDaoImpl implements CourseDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int insert(CreateCourseRequest createCourseRequest) {
		return jdbcTemplate.update("insert into Course values(?,?) ", createCourseRequest.getId(),createCourseRequest.getName());	      
	}
	@Override

	public List<Course> getAll() {
		String Sql="select * from Course";
		List<Course> courses = jdbcTemplate.query(Sql,new CourseRowMapperImpl());
		return courses;
	}
	@Override
	public int update(UpdateCourseRequest updateCourseRequest) {
		String sql="update course set name=? where id =? ";
		return jdbcTemplate.update(sql,updateCourseRequest);

	}
	}
	
	
		
	


