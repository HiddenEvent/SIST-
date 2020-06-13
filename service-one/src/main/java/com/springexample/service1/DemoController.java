package com.springexample.service1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping(path = {"/"})
	public String home() {
		return "This is service one 이당";
	}
	@GetMapping(path = {"/get-time-string"})
	public String getTimeString() {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
}
