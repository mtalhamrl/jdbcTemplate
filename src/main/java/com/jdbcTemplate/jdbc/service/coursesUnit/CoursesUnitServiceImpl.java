package com.jdbcTemplate.jdbc.service.coursesUnit;

import static com.jdbcTemplate.jdbc.model.response.BaseResponse.IS_OK_ITEM;
import static com.jdbcTemplate.jdbc.model.response.BaseResponse.NOT_FOUND_ITEM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbcTemplate.jdbc.dao.coursesunit.CoursesUnitDao;
import com.jdbcTemplate.jdbc.entities.CoursesUnit;
import com.jdbcTemplate.jdbc.model.request.coursesUnit.CreateCoursesUnitRequest;
import com.jdbcTemplate.jdbc.model.request.coursesUnit.UpdateCoursesUnitRequest;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitDeleteByIdResponse;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.coursesUnit.CoursesUnitGetByIdResponse;
@Service
public class CoursesUnitServiceImpl implements CoursesUnitService{
	@Autowired
	CoursesUnitDao coursesUnitDao;
	@Override
	public CoursesUnitGetByIdResponse insert(CreateCoursesUnitRequest createCoursesUnitRequest) {
		CoursesUnitGetByIdResponse insertResponse = new CoursesUnitGetByIdResponse();
		CoursesUnit unitDb= new CoursesUnit();
		unitDb.setId(createCoursesUnitRequest.getId());
		unitDb.setUnit(createCoursesUnitRequest.getUnit());
		int isOk = coursesUnitDao.insert(unitDb);
		if(isOk>0) {
			return this.insert(createCoursesUnitRequest);
		}else {
			insertResponse.setCode(405);
			insertResponse.setOperationMessage("couldnt save check again");
			return insertResponse;
		}
	}

	@Override
	public CoursesUnitGetAllResponse getAll() {
		CoursesUnitGetAllResponse getAllResponse = new CoursesUnitGetAllResponse();
		List<CoursesUnit> coursesUnits = coursesUnitDao.getAll();
		if(coursesUnits!=null && coursesUnits.size()>0) {
			getAllResponse.setCode(IS_OK_ITEM);
			getAllResponse.setOperationMessage("ok");
			getAllResponse.setCoursesUnits(coursesUnits);
		}else {
			getAllResponse.setCode(NOT_FOUND_ITEM);
			getAllResponse.setOperationMessage("course has not found");
		}
		return getAllResponse;
		
	}

	@Override
	public CoursesUnitGetByIdResponse update(UpdateCoursesUnitRequest updateCoursesUnitRequest, int id) {
		CoursesUnitGetByIdResponse getByIdResponse = new CoursesUnitGetByIdResponse();
		CoursesUnit unitDb = coursesUnitDao.getById(id);
		if(unitDb==null) {
			getByIdResponse.setCode(NOT_FOUND_ITEM);
			getByIdResponse.setOperationMessage("courses unit didnt find");
			return getByIdResponse;
		}
		unitDb.setUnit(updateCoursesUnitRequest.getUnit());
		int isOk = coursesUnitDao.update(unitDb);
		if(isOk>0) {
			return getById(id);
		}else {
			getByIdResponse.setCode(NOT_FOUND_ITEM);
			getByIdResponse.setOperationMessage("courses unit didnt update");
			return getByIdResponse;
		}
	}

	@Override
	public CoursesUnitGetByIdResponse getById(int id) {
		CoursesUnitGetByIdResponse getByIdResponse = new CoursesUnitGetByIdResponse();
		CoursesUnit unitDb=coursesUnitDao.getById(id);
		if(unitDb!=null) {
			getByIdResponse.setCode(IS_OK_ITEM);
			getByIdResponse.setOperationMessage("ok");
			return getByIdResponse;
		}else {
			getByIdResponse.setCode(NOT_FOUND_ITEM);
			getByIdResponse.setOperationMessage("there isnt any id");
		}
		return getByIdResponse;
	}

	@Override
	public CoursesUnitDeleteByIdResponse deleteById(int id) {
		CoursesUnitDeleteByIdResponse deleteByIdResponse = new CoursesUnitDeleteByIdResponse();
		CoursesUnitGetByIdResponse getByIdResponse = this.getById(id);
		if(getByIdResponse.getCode()==IS_OK_ITEM) {
			int response = coursesUnitDao.deleteById(id);
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
