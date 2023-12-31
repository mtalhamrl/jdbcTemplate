package com.jdbcTemplate.jdbc.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcTemplate.jdbc.model.request.course.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.course.UpdateCourseRequest;
import com.jdbcTemplate.jdbc.model.response.course.CourseDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.course.CourseGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.course.CourseGetByIdResponse;
import com.jdbcTemplate.jdbc.service.course.CourseService;

@RestController
@RequestMapping("/course/v1")
public class CourseCtrl {
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	ResponseEntity<?> insert(@RequestBody CreateCourseRequest createCourseRequest) {
	return ResponseEntity.ok(courseService.insert(createCourseRequest));
	}
	@GetMapping
	public CourseGetAllResponse getAll() {
		return courseService.getAll();
	}
	@PutMapping
	ResponseEntity<?> update(@RequestBody  UpdateCourseRequest updateCourseRequest,@PathVariable int id ) {
		return ResponseEntity.ok(courseService.update(updateCourseRequest,id));
		
	}
	@GetMapping("/{id}")
	public CourseGetByIdResponse getById(@PathVariable int id) {
		return courseService.getById(id);
	}
	@DeleteMapping("/{id}")
	CourseDeleteByIdResponse deleteById(@PathVariable int id) {
		return this.courseService.deleteById(id);
	}
}
