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

import com.jdbcTemplate.jdbc.model.request.unitTest.CreateUnitTestRequest;
import com.jdbcTemplate.jdbc.model.request.unitTest.UpdateUnitTestRequest;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestGetByIdResponse;
import com.jdbcTemplate.jdbc.service.unitTest.UnitTestService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/tests/v1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitTestCtrl {
	@Autowired
	private UnitTestService unitTestService;
	@PostMapping("/add")
	ResponseEntity<?> insert(@RequestBody CreateUnitTestRequest createUnitTestRequest){
		return ResponseEntity.ok(unitTestService.insert(createUnitTestRequest));
	}
	@GetMapping("/getall")
	public UnitTestGetAllResponse getAll() {
		return unitTestService.getAll(); 
	}
	@PutMapping("/update/{id}")
	ResponseEntity<?> update(@RequestBody UpdateUnitTestRequest unitTestRequest , @PathVariable int id){
		return ResponseEntity.ok(unitTestService.update(unitTestRequest, id));
	}
	@GetMapping("/{id}")
	public UnitTestGetByIdResponse getById(@PathVariable int id) {
		return unitTestService.getById(id);
	}
	@DeleteMapping("/{id}")
	public UnitTestDeleteByIdResponse deleteById(@PathVariable int id) {
		return this.unitTestService.deleteById(id);
	}
	
}
