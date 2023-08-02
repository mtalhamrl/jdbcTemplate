package com.jdbcTemplate.jdbc.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcTemplate.jdbc.model.request.CreateCourseRequest;
import com.jdbcTemplate.jdbc.model.request.UpdateCourseRequest;
import com.jdbcTemplate.jdbc.model.response.CourseResponse;
import com.jdbcTemplate.jdbc.service.course.CourseService;

@RestController
@RequestMapping("/course/v1")
public class CourseCtrl {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/add")
	ResponseEntity<?> insert(@RequestBody CreateCourseRequest createCourseRequest) {
		boolean isOk = courseService.insert(createCourseRequest);
		if(isOk)
		return ResponseEntity.ok("ok");
		else {
			return ResponseEntity.ok("failed");
		}
	}
	@GetMapping("/getall")
	public CourseResponse getAll() {
		return courseService.getAll();
	}
	@PutMapping("/update")
	ResponseEntity<?> update(@RequestBody() UpdateCourseRequest updateCourseRequest ) {
		boolean isOk = courseService.update(updateCourseRequest);
		if(isOk) {
			return ResponseEntity.ok("ok");
		} else {
			return ResponseEntity.ok("failed");
		}
	}
}
