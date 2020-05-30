package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.demoweb.service.MemberService;
import com.demoweb.vo.Member;

public class LoginController implements Controller {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public ActionResult processRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		String method = req.getMethod().toLowerCase();//요청 method: get OR post
		ActionResult ar = new ActionResult();
		
		if (method.equals("get")) {
			//로그인 화면 제공
			ar.setViewName("account/login");
			ar.setRedirect(false);
		} else {
			//로그인 처리 (id, pwd로 데이터베이스 조회)
			// 1. 데이터 읽기
			String memberId = req.getParameter("memberId");
			String passwd = req.getParameter("passwd");
			
			// 2. 데이터 처리			
			Member member = memberService.login(memberId, passwd);
			if (member != null) { // 로그인 성공
				// 로그인 처리 --> Session 객체에 데이터 저장
				HttpSession session =  req.getSession();
				session.setAttribute("loginuser", member);
				
				ar.setViewName("home.action");
				ar.setRedirect(true);
			} else { //로그인 실패
				ar.setViewName("account/login");
				ar.setRedirect(false);
			}
		}
		
		return ar;
	}

}













