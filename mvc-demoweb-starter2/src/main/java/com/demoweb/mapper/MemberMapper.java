package com.demoweb.mapper;

import java.util.HashMap;

import com.demoweb.vo.Member;

public interface MemberMapper {
	void insertMember(Member member);
	Member selectMemberByIdAndPasswd(HashMap<String, Object> params);
	void updateMember(Member member);
}
