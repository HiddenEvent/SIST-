package com.springexample.customview;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

//Custom View는 View interface를 구현합니다.
//public class MyView implements View {
public class MyView extends AbstractView {

	@Override
	public String getContentType() {
		return "text/plain;charset=utf-8";
	}
	
	//응답 컨텐츠를 만드는 메서드 (View interface 구현 메서드)
//	@Override
//	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		
//	}
	
	//응답 컨텐츠를 만드는 메서드 (AbstractView 상속 추상 메서드 구현)
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(getContentType());
		PrintWriter out = response.getWriter();
		out.println("Hello, Spring Custom View!!!" + new Date());
	}

}
