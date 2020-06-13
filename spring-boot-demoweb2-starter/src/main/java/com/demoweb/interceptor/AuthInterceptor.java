package com.demoweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.demoweb.entity.MemberEntity;


public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String url = request.getRequestURI();
		MemberEntity member =  (MemberEntity) request.getSession().getAttribute("loginuser");
		
		// 게시글 작성시 로그인이 되어있는지 확인
		if(url.contains("/board") && member == null) {
			response.sendRedirect("/account/login.action");
			return false;
		}
		
		
		return true;
	}
	

}
