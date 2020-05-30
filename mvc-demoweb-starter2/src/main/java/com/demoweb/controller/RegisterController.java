package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.demoweb.service.MemberService;
import com.demoweb.vo.Member;

public class RegisterController implements Controller {

	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public ActionResult processRequest(HttpServletRequest req, HttpServletResponse resp) {

		ActionResult result = new ActionResult();
		
		String method = req.getMethod().toLowerCase();
		if (method.equals("get")) {
			
			result.setViewName("account/register");
			//result.setRedirect(false);
			
		} else {
			
			//회원가입 처리
			String memberId = req.getParameter("memberId");
			String passwd = req.getParameter("passwd");
			String email = req.getParameter("email");
			
			Member member = new Member();
			member.setMemberId(memberId);
			member.setPasswd(passwd);
			member.setEmail(email);
			
			//MemberService memberService = new MemberService();
			memberService.registerMember(member);
			
			//로그인 화면으로이동
			result.setViewName("account/login.action");
			result.setRedirect(true);
		}
		
		return result;
		
	}

}




