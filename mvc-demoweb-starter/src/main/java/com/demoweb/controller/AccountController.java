package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.demoweb.service.MemberService;
import com.demoweb.vo.Member;

@Controller
@RequestMapping("/account/")
public class AccountController {

	@Autowired
	@Qualifier("memberService")
	private MemberService memberService;
	
	@GetMapping(path = { "/login.action" })
	public String showLoginForm() {
		
		return "account/login"; // /WEB-INF/views/ + account/login + .jsp
	}
	
	@PostMapping(path = { "/login.action" })
	public String login(String memberId, String passwd, HttpSession session) {
		
		Member member = memberService.login(memberId, passwd);
		if (member != null) { // 로그인 성공
			// 로그인 처리 --> Session 객체에 데이터 저장
			session.setAttribute("loginuser", member);
			return "redirect:/";
		} else { //로그인 실패
			return "account/login"; // /WEB-INF/views/ + account/login + .jsp
		}
		
	}
	
	@GetMapping(path = { "/logout.action" })
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginuser");
		//return new RedirectView("/")
		return "redirect:/";
	}
	
}













