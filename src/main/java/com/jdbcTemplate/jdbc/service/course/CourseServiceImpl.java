package com.jdbcTemplate.jdbc.service.course;

import static com.jdbcTemplate.jdbc.model.response.BaseResponse.IS_OK_ITEM;
import static com.jdbcTemplate.jdbc.model.response.BaseResponse.NOT_FOUND_ITEM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcTemplate.jdbc.dao.course.CourseDao;
import com.jdbcTemplate.jdbc.entities.Course;
import com.jdbcTemplate.jdbc.model.request.course.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.course.UpdateCourseRequest;
import com.jdbcTemplate.jdbc.model.response.course.CourseDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.course.CourseGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.course.CourseGetByIdResponse;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseDao courseDao;
	@Override
	public CourseGetByIdResponse insert(CreateCourseRequest createCourseRequest) {
		CourseGetByIdResponse insertResponse = new CourseGetByIdResponse();
		Course course = new Course();
		course.setId(createCourseRequest.getId());
		course.setCourse_name(createCourseRequest.getCourse_name());
		course.setGrade_id(createCourseRequest.getGrade_id());
		int isOk = courseDao.insert(course);
		if(isOk>0) {
			return this.getById(createCourseRequest.getId());
		}else {
		insertResponse.setCode(405);
		insertResponse.setOperationMessage("couldnt save check again");
		return insertResponse;
		}
		
	}
	@Override
	public CourseGetAllResponse getAll() {
		CourseGetAllResponse response = new CourseGetAllResponse(); 
		List<Course> courses = courseDao.getAll();
		if(courses!=null && courses.size()>0) {
		response.setCode(IS_OK_ITEM);
		response.setOperationMessage("ok");
		response.setCourses(courses);	
		}else {
			response.setCode(NOT_FOUND_ITEM);
			response.setOperationMessage("course has not found");
		}
		return response;
	}
	@Override
	public CourseGetByIdResponse update(UpdateCourseRequest updateCourseRequest,int id) {
		CourseGetByIdResponse updateResponse= new CourseGetByIdResponse();
		Course courseDb = courseDao.getById(id);
		if(courseDb==null) {
			updateResponse.setCode(NOT_FOUND_ITEM);
			updateResponse.setOperationMessage("course didnt find"); 
			return updateResponse;
		}
		courseDb.setCourse_name(updateCourseRequest.getCourse_name());
		courseDb.setGrade_id(updateCourseRequest.getGrade_id());
		int isOk = courseDao.update(courseDb);
		if(isOk>0) {
			return this.getById(id);
		}else {
			updateResponse.setCode(NOT_FOUND_ITEM);
			updateResponse.setOperationMessage("course didnt update"); 
			return updateResponse;
		}
	}
	@Override
	public CourseGetByIdResponse getById(int id) {
		CourseGetByIdResponse response = new CourseGetByIdResponse();
		Course courses= courseDao.getById(id);
		if(courses!=null) {
			response.setCode(IS_OK_ITEM);
			response.setOperationMessage("ok");
			response.setCourse(courses);
		}
		else {
			response.setCode(NOT_FOUND_ITEM);
			response.setOperationMessage("id has not matched");
		}
		return response;
	}
	@Override
	public CourseDeleteByIdResponse deleteById(int id) {
		CourseDeleteByIdResponse courseDeleteByIdResponse = new CourseDeleteByIdResponse();
		CourseGetByIdResponse course = this.getById(id);
		if(course.getCode()==IS_OK_ITEM) {
			int response= courseDao.deleteById(id);
			if(response<=0) {
				courseDeleteByIdResponse.setCode(NOT_FOUND_ITEM);
				courseDeleteByIdResponse.setOperationMessage("problem at deleted");
				return courseDeleteByIdResponse;
			}
			
		}
		courseDeleteByIdResponse.setCode(IS_OK_ITEM);
		courseDeleteByIdResponse.setOperationMessage("deleted");
		return courseDeleteByIdResponse;
	}
	
	
	}

