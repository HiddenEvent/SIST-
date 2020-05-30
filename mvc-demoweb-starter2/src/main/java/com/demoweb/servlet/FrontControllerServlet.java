package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.demoweb.controller.ActionResult;
import com.demoweb.controller.Controller;

//@WebServlet("*.action")
public class FrontControllerServlet extends HttpServlet {

	private GenericXmlApplicationContext ctx = null;
	
	//서블릿 초기화를 위해 사용되는 함수
	@Override
	public void init(ServletConfig config) throws ServletException {
		ctx = new GenericXmlApplicationContext("config/app-context.xml");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 요청분석
		String uri = req.getRequestURI();
		//1-1. /mvc-demoweb/abc/xyz.action?... -> /mvc-demoweb/abc/xyz.action 
		if (uri.contains("?")) { 
			uri = uri.substring(0, uri.indexOf("?"));
		}
		//1-2. /mvc-demoweb/abc/xyz.action -> abc_xyz
		int from = "/mvc-demoweb/".length();
		int to = uri.lastIndexOf(".action");
		String actionName = uri.substring(from, to).replace("/", "_");
		System.out.println(actionName);
		
		//2. 요청 처리기(Controller) 선택		
		Controller controller = 
				ctx.getBean(actionName, Controller.class);
		
		//3. 요청 처리기 호출 (인터페이스 메서드 호출)
		ActionResult result = controller.processRequest(req, resp);
		
		//4. 결과에 따라 view 선택
		//5. view를 호출 (forward or redirect)
		if (result.isRedirect()) {
			resp.sendRedirect("/mvc-demoweb/" + result.getViewName());
		} else {
			RequestDispatcher dispatcher = 
				req.getRequestDispatcher(
					"/WEB-INF/views/" + result.getViewName() + ".jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp);
	}
	
}







