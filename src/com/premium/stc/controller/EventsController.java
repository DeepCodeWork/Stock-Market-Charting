package com.premium.stc.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.premium.stc.service.EventsServiceInterface;

@Controller
public class EventsController {
	
	@Autowired
	EventsServiceInterface eventsServiceInterface;
	
	@GetMapping("/")
	public String x() {
		return "file";
	}
	
	@PostMapping("ab")
	
	public void importData(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException,InvalidFormatException {

		
		eventsServiceInterface.importData(file);
		   
		 
	}
	
}
