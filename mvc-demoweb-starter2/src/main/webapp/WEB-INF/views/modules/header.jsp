<%@page import="com.demoweb.vo.Member"%>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
    	 
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core" %>
				
		<div id="header">		
            <div class="title">
                <a href="/mvc-demoweb/home.action">DEMO WEBSITE</a>
            </div>
            <div class="links">
            	<c:choose>
            	<c:when test="${ empty loginuser }">
            	<a href="/mvc-demoweb/account/login.action">로그인</a>
                <a href="/mvc-demoweb/account/register.action">회원가입</a>
            	</c:when>
            	<c:otherwise>
            	<a href="/mvc-demoweb/account/update.action">
                	${ loginuser.memberId }
                </a>님 환영합니다.
                <a href="/mvc-demoweb/account/logout.action">로그아웃</a>
            	</c:otherwise>
            	</c:choose>
            	
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="#">게시판</a></li>
                </ul>
            </div>
		</div>
    	 