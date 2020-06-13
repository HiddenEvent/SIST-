package com.springexample.servicetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.servicetwo.client.ServiceOneDiscoveryClient;
import com.springexample.servicetwo.client.ServiceOneFeignClient;
import com.springexample.servicetwo.client.ServiceOneRestTemplateClient;

@RestController
public class DemoController {
	
	 @Autowired
	    ServiceOneFeignClient serviceOneFeignClient;

    @Autowired
    ServiceOneRestTemplateClient serviceOneRestClient;

    @Autowired
    ServiceOneDiscoveryClient serviceOneDiscoveryClient;

	@GetMapping(value = { "/", })
	public String home() {
		return "This is Service Two";
	}
	
	@GetMapping(value = { "/get-time-string2" })
	public String getTimeString() {
		
//		String timeString = serviceOneDiscoveryClient.getTimeString();
		String timeString = serviceOneRestClient.getTimeString();
//		String timeString = serviceOneFeignClient.getTimeString();
		
		return timeString;
	
		
		
	}
}
