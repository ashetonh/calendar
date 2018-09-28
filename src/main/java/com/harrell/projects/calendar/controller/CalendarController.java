package com.harrell.projects.calendar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalendarController {
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from the calendar app!";
	}

}
