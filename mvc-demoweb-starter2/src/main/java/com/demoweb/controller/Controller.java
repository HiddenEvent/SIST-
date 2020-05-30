package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 개별 요청 처리 Controller가 구현해야 할 인터페이스
 * 
 * @author instructor
 *
 */
public interface Controller {
	
	ActionResult processRequest(
			HttpServletRequest req, HttpServletResponse resp);

}
