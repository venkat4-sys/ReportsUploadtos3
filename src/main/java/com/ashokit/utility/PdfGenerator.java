package com.ashokit.utility;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Component;

import com.ashokit.entity.Citizen;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
	

	public byte[] generatePdf(Integer id,Citizen entity ) throws Exception{
		
		Document document = new Document(PageSize.A4);
		
		 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		PdfWriter.getInstance(document,outputStream);
		
		document.open();
		
		Paragraph p = new Paragraph("Citizen Information");
		document.add(p);
		
		PdfPTable table = new PdfPTable(3);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Citizen PhoneNumber");
		
		//Optional<Citizen> findById = citizenrepo.findById(id);
		
		
			
			table.addCell(String.valueOf(entity.getCitizenId()));
			table.addCell(entity.getCitizenName());
			table.addCell(entity.getContactNumber());
			
		
		
		document.add(table);
		document.close();

		
		return outputStream.toByteArray();
	}
	

}
