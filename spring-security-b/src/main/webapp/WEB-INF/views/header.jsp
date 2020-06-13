<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="/spring-security-b/home">Home</a></li>
					<li class="nav-item active"><a class="nav-link" href="/spring-security-b/about">About</a></li>
					<li class="nav-item active"><a class="nav-link" href="/spring-security-b/service">Services</a></li>
					<li class="nav-item active"><a class="nav-link" href="/spring-security-b/contact">Contact</a></li>
					<sec:authorize access="hasRole('ADMIN')">
					<li class="nav-item active"><a class="nav-link" href="/spring-security-b/admin">Admin</a></li>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
					<li class="nav-item active"><a class="nav-link" href="/spring-security-b/register">Register</a></li>
					<li class="nav-item active"><a class="nav-link" href="/spring-security-b/login">Login</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
					<li class="nav-item active">
						<a class="nav-link" href="javascript:">
							<%-- <sec:authentication property="name"/>님 환영합니다. --%>
							<sec:authentication property="principal.username"/>님 환영합니다.
						</a>
					</li>
					<li class="nav-item active"><a class="nav-link" href="/spring-security-b/logout">Logout</a></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</nav>
	
	
	
	
	
	
	
	
	
	
	
	
	