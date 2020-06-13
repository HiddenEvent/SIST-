package com.demoweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demoweb.entity.MemberEntity;
import com.demoweb.repository.AccountRepository;

public class DemoWebUserService implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository; //JPA를 사용했을 때 기준
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		MemberEntity member = 
			accountRepository.findById(username).orElse(null); // orElse(null) 쓰는이유는 널체크를 해서 보내라!
		
		if(member == null) {
			throw new UsernameNotFoundException(username);
		} else {
			return new DemoWebUserDetails(member);
		}
	}

}
