package com.demoweb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

public class HomeController implements Controller {

	@Override
	public ActionResult processRequest(HttpServletRequest req, HttpServletResponse resp) {
				
		//1. 요청 처리		
		//2. 반환
		ActionResult ar = new ActionResult();
		ar.setViewName("home");
		ar.setRedirect(false);
		
		return ar;
		
	}

}
