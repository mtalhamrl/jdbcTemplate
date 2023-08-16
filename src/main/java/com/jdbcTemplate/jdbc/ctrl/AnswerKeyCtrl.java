package com.jdbcTemplate.jdbc.ctrl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcTemplate.jdbc.dao.answerkey.AnswerKeyDao;
import com.jdbcTemplate.jdbc.model.response.answerkey.AnswerKeyGetAllResponse;
import com.jdbcTemplate.jdbc.model.response.answerkey.AnswerKeyPDFExporter;
import com.jdbcTemplate.jdbc.service.answerkey.AnswerKeyService;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/answerkey/v1")
public class AnswerKeyCtrl {
	@Autowired
	AnswerKeyService answerKeyService;
	AnswerKeyDao answerKeyDao;
	
	  @GetMapping("/getall") 
	  public AnswerKeyGetAllResponse getAll() {
		  return answerKeyService.getAll(); }
	 
	 @GetMapping("/export")
	 public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		 response.setContentType("application/pdf");
		 DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());        
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=answerkey_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	        AnswerKeyGetAllResponse answerKey =	answerKeyService.getAll();       
	        AnswerKeyPDFExporter exporter = new AnswerKeyPDFExporter(answerKey.getAnswerKeys());
	        exporter.export(response);
	    
	 }
	
	

	
}
