package com.springdemo.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	@RequestMapping(value = { "/about" })
	public String showAbout() {
	
		return "about";
	}
	
	@RequestMapping(value = { "/service" })
	public String showService() {

		return "service";
	}
	
	@RequestMapping(value = { "/contact" })
	public String showContact() {
		
		return "contact";
	}	
	
	@RequestMapping(value = { "/admin" })
	public String showAdmin() {
		
		return "admin";
	}	
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String showRegisterForm() {
		
		return "register";
	}
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String register() {
		
				
		return "redirect:/login";
	}	
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = { "/access-denied" }, method = RequestMethod.GET)
	public String accessDenied() {
		return "access-denied";
	}


}
