package com.jdbcTemplate.jdbc.service.unitTest;

import static com.jdbcTemplate.jdbc.model.response.BaseResponse.IS_OK_ITEM;
import static com.jdbcTemplate.jdbc.model.response.BaseResponse.NOT_FOUND_ITEM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcTemplate.jdbc.dao.unitTest.UnitTestDao;
import com.jdbcTemplate.jdbc.entities.UnitTest;
import com.jdbcTemplate.jdbc.model.request.unitTest.CreateUnitTestRequest;
import com.jdbcTemplate.jdbc.model.request.unitTest.UpdateUnitTestRequest;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.unitTest.UnitTestGetByIdResponse;
@Service

public class UnitTestServiceImpl implements UnitTestService{
	@Autowired
	UnitTestDao unitTestDao;
	@Override
	public UnitTestGetByIdResponse insert(CreateUnitTestRequest createUnitTestRequest) {
		UnitTestGetByIdResponse insertResponse = new UnitTestGetByIdResponse();
		UnitTest unitTestDb= new UnitTest();
		unitTestDb.setId(createUnitTestRequest.getId());
		unitTestDb.setTest_no(createUnitTestRequest.getTest_no());
		unitTestDb.setCoursesunit_id(createUnitTestRequest.getCoursesunit_id());
		int isOk= unitTestDao.insert(unitTestDb);
		if(isOk>0) {
			return this.getById(createUnitTestRequest.getId());
		}else {
			insertResponse.setCode(405);
			insertResponse.setOperationMessage("couldnt save check again");
			return insertResponse;
		}
	}

	@Override
	public UnitTestGetAllResponse getAll() {
		UnitTestGetAllResponse getAllResponse = new UnitTestGetAllResponse();
		List<UnitTest> unitTests = unitTestDao.getAll();
		if(unitTests!=null && unitTests.size()>0) {
			getAllResponse.setCode(IS_OK_ITEM);
			getAllResponse.setOperationMessage("ok");
			getAllResponse.setUnitTests(unitTests);
			}else {
				getAllResponse.setCode(NOT_FOUND_ITEM);
				getAllResponse.setOperationMessage("course has not found");
			}
			return getAllResponse;
		
	}
	

	@Override
	public UnitTestGetByIdResponse update(UpdateUnitTestRequest updateUnitTestRequest, int id) {
		UnitTestGetByIdResponse updateResponse = new UnitTestGetByIdResponse();
		UnitTest unitTest = unitTestDao.getById(id);
		if(unitTest==null) {
			updateResponse.setCode(NOT_FOUND_ITEM);
			updateResponse.setOperationMessage("unit tests didnt find");
			return updateResponse;
		}
		unitTest.setTest_no(updateUnitTestRequest.getTest_no());
		unitTest.setCoursesunit_id(updateUnitTestRequest.getCoursesunit_id());
		int isOk= unitTestDao.update(unitTest);
		if(isOk>0) {
			return this.getById(id);
		}else {
			updateResponse.setCode(NOT_FOUND_ITEM);
			updateResponse.setOperationMessage("there is not any update");
			return updateResponse;
		}
	}

	@Override
	public UnitTestGetByIdResponse getById(int id) {
		UnitTestGetByIdResponse getByIdResponse = new UnitTestGetByIdResponse();
		UnitTest unitTest = unitTestDao.getById(id);
		if(unitTest!=null) {
			getByIdResponse.setCode(IS_OK_ITEM);
			getByIdResponse.setOperationMessage("ok");
			return getByIdResponse;
		}else {
			getByIdResponse.setCode(NOT_FOUND_ITEM);
			getByIdResponse.setOperationMessage("the id didnt match");
		}
		return getByIdResponse;
	}

	@Override
	public UnitTestDeleteByIdResponse deleteById(int id) {
		UnitTestDeleteByIdResponse deleteByIdResponse = new UnitTestDeleteByIdResponse();
		UnitTestGetByIdResponse getByIdResponse= this.getById(id);
		if(getByIdResponse.getCode()==IS_OK_ITEM) {
			int response = unitTestDao.deleteById(id);
			if(response<=0) {
				deleteByIdResponse.setCode(NOT_FOUND_ITEM);
				deleteByIdResponse.setOperationMessage("problem at deleted");
			}
		}
		deleteByIdResponse.setCode(IS_OK_ITEM);
		deleteByIdResponse.setOperationMessage("deleted");
		return deleteByIdResponse;
	}
}
