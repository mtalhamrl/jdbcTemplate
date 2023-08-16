package com.jdbcTemplate.jdbc.model.response.answerkey;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import com.jdbcTemplate.jdbc.entities.AnswerKey;
import com.jdbcTemplate.jdbc.model.response.BaseResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class AnswerKeyPDFExporter extends BaseResponse{
		private List<AnswerKey> answerKey;
		
		 private void writeTableHeader(PdfPTable table) {
		        PdfPCell cell = new PdfPCell();
		        cell.setBackgroundColor(Color.BLUE);
		        cell.setPadding(5);
		         
		        Font font = FontFactory.getFont(FontFactory.HELVETICA);
		        font.setColor(Color.WHITE);
		         
		        cell.setPhrase(new Phrase("Grade Name", font));
		         
		        table.addCell(cell);
		         
		        cell.setPhrase(new Phrase("Course Name", font));
		        table.addCell(cell);
		         
		        cell.setPhrase(new Phrase("Unit", font));
		        table.addCell(cell);
		         
		        cell.setPhrase(new Phrase("Test No", font));
		        table.addCell(cell);
		         
		        cell.setPhrase(new Phrase("Question No&Answer", font));
		        table.addCell(cell);  
		        
		       
		    }
		     
		    private void writeTableData(PdfPTable table) {
		        for (AnswerKey answerKeys : answerKey) {
		            table.addCell(String.valueOf(answerKeys.getGrade_name()));
		            table.addCell(answerKeys.getCourse_name());
		            table.addCell(answerKeys.getUnit());
		            table.addCell(answerKeys.getTest_no());
		            table.addCell(answerKeys.getAnswerMap().toString());

		        }
		    }
		     
		    public void export(HttpServletResponse response) throws DocumentException, IOException {
		        Document document = new Document(PageSize.A4);
		        PdfWriter.getInstance(document, response.getOutputStream());
		        document.open();
		        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		        font.setSize(18);
		        font.setColor(Color.BLUE);
		         
		        Paragraph p = new Paragraph("List of All Answerkeys", font);
		        p.setAlignment(Paragraph.ALIGN_CENTER);
		         
		        document.add(p);
		         
		        PdfPTable table = new PdfPTable(5);
		        table.setWidthPercentage(100f);
		        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
		        table.setSpacingBefore(10);
		         
		        writeTableHeader(table);
		        writeTableData(table);
		         
		        document.add(table);
		         
		        document.close();
		         
		    }
}
