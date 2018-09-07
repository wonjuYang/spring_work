<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
<h3>인덱스 페이지입니다.</h3>
<!-- session 영역에 id 가 비어 있지않으면 (로그인 된 상태라면) -->
<c:if test="${ not empty sessionScope.id }">
	<p> <strong><a href="users/info.do">${id }</a></strong> 님 로그인중...</p>
	<a href="users/logout.do">로그아웃</a>
</c:if>
<ul>
	<li><a href="users/signupform.do">회원가입</a></li>
	<li><a href="users/loginform.do">로그인</a></li>
</ul>
</body>
</html>