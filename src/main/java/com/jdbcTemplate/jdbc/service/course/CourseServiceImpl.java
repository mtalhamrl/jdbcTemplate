package com.jdbcTemplate.jdbc.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcTemplate.jdbc.dao.course.CourseDao;
import com.jdbcTemplate.jdbc.entities.Course;
import com.jdbcTemplate.jdbc.model.request.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.UpdateCourseRequest;
import com.jdbcTemplate.jdbc.model.response.CourseResponse;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseDao courseDao;
	@Override
	public boolean insert(CreateCourseRequest createCourseRequest) {
		int isOk = courseDao.insert(createCourseRequest);
		return isOk>0 ?true : false ;
		
	}
	@Override
	public CourseResponse getAll() {
		CourseResponse response = new CourseResponse(); 
		List<Course> courses = courseDao.getAll();
		if(courses!=null && courses.size()>0) {
		response.setCode(200);
		response.setOperationMessage("ok");
		response.setCourses(courses);	
		}else {
			response.setCode(404);
			response.setOperationMessage("course haven't found");
		}
		return response;
	}
	@Override
	public boolean update(UpdateCourseRequest updateCourseRequest) {
		int isOk = courseDao.update(updateCourseRequest);
		return isOk>0 ?true:false ;
	}
}
