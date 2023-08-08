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

import com.jdbcTemplate.jdbc.model.request.coursesUnit.CreateCoursesUnitRequest;
import com.jdbcTemplate.jdbc.model.request.coursesUnit.UpdateCoursesUnitRequest;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitGetByIdResponse;
import com.jdbcTemplate.jdbc.service.coursesUnit.CoursesUnitService;

@RestController
@RequestMapping("/units/v1")
public class CoursesUnitCtrl {
	@Autowired
	CoursesUnitService coursesUnitService;
	
	@PostMapping("/add")
	ResponseEntity<?> insert(@RequestBody() CreateCoursesUnitRequest createCoursesUnitRequest){
		return ResponseEntity.ok(coursesUnitService.insert(createCoursesUnitRequest));
	}
	@GetMapping("/getall")
	CoursesUnitGetAllResponse getAll(){
		return coursesUnitService.getAll();
	}
	@PutMapping("/update/{id}")
	ResponseEntity<?> update(@RequestBody UpdateCoursesUnitRequest updateCoursesUnitRequest,@PathVariable int id){
		return ResponseEntity.ok(coursesUnitService.update(updateCoursesUnitRequest, id));
	}
	@GetMapping("/{id}")
	CoursesUnitGetByIdResponse getById(@PathVariable int id) {
		return coursesUnitService.getById(id);
	}
	@DeleteMapping("/{id}")
	CoursesUnitDeleteByIdResponse deleteById(@PathVariable int id) {
		return coursesUnitService.deleteById(id);
	}
}
