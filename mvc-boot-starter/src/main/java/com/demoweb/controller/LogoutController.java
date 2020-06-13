package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

public class LogoutController implements Controller {

	@Override
	public ActionResult processRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		ActionResult result = new ActionResult();
		
		//req.getSession().invalidate();
		req.getSession().removeAttribute("loginuser");
		
		result.setViewName("home.action");
		result.setRedirect(true);
		
		return result;
		
	}

}
