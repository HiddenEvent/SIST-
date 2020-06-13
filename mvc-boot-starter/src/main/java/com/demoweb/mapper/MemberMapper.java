package com.demoweb.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.demoweb.vo.Member;

//TODO @Mapper 어노테이션 1번째 작업
@Mapper
public interface MemberMapper {
	void insertMember(Member member);
	Member selectMemberByIdAndPasswd(HashMap<String, Object> params);
	void updateMember(Member member);
}
