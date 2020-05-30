<%@page import="com.demoweb.vo.Member"%>
<%@page import="com.demoweb.vo.BoardAttach"%>
<%@page import="com.demoweb.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>

<%-- c: 라고 쓰면 "http://java.sun.com/jsp/jstl/core"로 등록된 태그라이브러리를 의미합니다. --%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
<head>

	<meta charset="utf-8" />
	<title>글쓰기</title>
	
	<link rel="Stylesheet" href="/spring-mvc-demoweb/resources/styles/default.css" />
	<link rel="Stylesheet" href="/spring-mvc-demoweb/resources/styles/input2.css" />
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
	
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시판 글 내용</div>
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>${ requestScope.board.title }</td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>${ board.writer }</td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td>
		                	${ board.regDate }
		                	<br>
		                	<fmt:formatDate value="${ board.regDate }" 
		                					pattern="yyyy년 MM월 dd일 (E)" />
		                </td>
		            </tr>
					<tr>
		                <th>조회수</th>
		                <td>${ board.readCount }</td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>
		                <c:forEach var="attach" items="${ board.attachments }">
		                <a href="download.action?attachno=${ attach.attachNo }">
		                	${ attach.userFileName }
		                </a>
		                </c:forEach>
		                
		                <br>
		                
		                </td>
		            </tr>
		            <tr>
		                <th>내용</th>
		                <td style="height:200px;vertical-align:top">
<c:set var="enter" value="
" />
             				${ fn:replace( board.content, enter, "<br>") }
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<c:if test="${ not empty loginuser and board.writer eq loginuser.memberId }">
		        	[&nbsp;<a id='update-btn' href='javascript:'>수정</a>&nbsp;]
		        	[&nbsp;<a id='delete-btn' href='javascript:'>삭제</a>&nbsp;]
		        	</c:if>        	
		        	
		        	[&nbsp;<a href='list.action?pageno=${ pageno }'>목록보기</a>&nbsp;]
		        </div>
		    </div>
		</div>

	</div>
	</div>
	<br><br><br><br><br>

	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	
	<script type="text/javascript">
	$(function() {

		$('#delete-btn').on('click', function(event) {
			var ok = confirm('${ board.boardNo }번 글을 삭제할까요?')
			if (ok) {
				location.href='delete.action?boardno=${ board.boardNo }' + 
							  '&pageno=${ pageno }';
			}
		});
		$('#update-btn').on('click', function(event) {
			location.href='update.action?boardno=${ board.boardNo }' + 
			  			  '&pageno=${ pageno }';
		});
	});

	</script>	

</body>
</html>