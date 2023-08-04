package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.ReportsService;

@RestController
public class PdfUpload {
	
	@Autowired
	private ReportsService service;
	
	@PostMapping("/save")
	public String pdfUpload(@RequestParam("id") Integer id) throws Exception {
		
		return service.pdfexport(id);
		
		
	}

}
