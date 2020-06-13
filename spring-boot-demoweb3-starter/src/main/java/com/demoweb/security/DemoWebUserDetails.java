package com.demoweb.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demoweb.entity.MemberEntity;
import com.demoweb.entity.MemberRoleEntity;

public class DemoWebUserDetails implements UserDetails {
	
	// Vo 객체는 Autowired 대상이 아니다 -> 계속 바뀌기 때문에
	private MemberEntity memberEntity;
	
	public DemoWebUserDetails() {
		
	}
	
	public DemoWebUserDetails(MemberEntity memberEntity) {
		this.memberEntity = memberEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (MemberRoleEntity role : memberEntity.getMemberRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}		
		return authorities;
	}

	@Override
	public String getPassword() {

		return memberEntity.getPasswd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return memberEntity.getMemberId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return memberEntity.isActive();
	}

}
