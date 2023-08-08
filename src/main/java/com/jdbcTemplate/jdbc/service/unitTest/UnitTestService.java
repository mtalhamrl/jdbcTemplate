package com.jdbcTemplate.jdbc.service.unitTest;

import com.jdbcTemplate.jdbc.model.request.unitTest.CreateUnitTestRequest;
import com.jdbcTemplate.jdbc.model.request.unitTest.UpdateUnitTestRequest;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestGetByIdResponse;

public interface UnitTestService {
	public UnitTestGetByIdResponse insert(CreateUnitTestRequest createUnitTestRequest);
	public UnitTestGetAllResponse getAll();
	public UnitTestGetByIdResponse update(UpdateUnitTestRequest updateUnitTestRequest,int id);
	public UnitTestGetByIdResponse getById(int id);
	public UnitTestDeleteByIdResponse deleteById(int id);
}
