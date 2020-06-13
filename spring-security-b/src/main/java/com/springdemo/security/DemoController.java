package com.springdemo.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springdemo.security.model.Member;
import com.springdemo.security.model.MemberRepository;

@Controller
public class DemoController {
	
	@Autowired
	@Qualifier("memberRepository")
	private MemberRepository memberRepository;
	
	@Autowired
	@Qualifier("bcryptEncoder")
	private BCryptPasswordEncoder bcryptEncoder;
	
	@RequestMapping(value = { "/about" })
	public String showAbout(HttpServletRequest req) {
		
		Authentication authentication = (Authentication)req.getUserPrincipal();
		if (authentication != null) {
			System.out.println("Login User 1 : " + authentication.getName());
			System.out.println("Login User 1 Type : " + authentication.getClass());
		}
	
		return "about";
	}
	
	@RequestMapping(value = { "/service" })
	public String showService(
		@AuthenticationPrincipal UsernamePasswordAuthenticationToken user) {
		if (user != null) {
			System.out.println("Login User 2 : " + user.getName());
		}
		return "service";
	}
	
	@RequestMapping(value = { "/contact" })
	public String showContact() {
		Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication();
		System.out.println("Login User 3 : " + auth.getName());
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
	public String register(Member member) {
		
		//아래 두 줄의 코드는 provider의 password-encoder와 매칭되도록 구현
		String encodedPassword = bcryptEncoder.encode(member.getPasswd());
		member.setPasswd(encodedPassword);
		
		memberRepository.insertMember(member);
		memberRepository.insertMemberRole(member.getMemberId(), 
										  member.getUserType().contentEquals("user") ? 1 : 2);
		
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
