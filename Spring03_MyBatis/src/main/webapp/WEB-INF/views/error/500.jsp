<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>서버 내부 오류입니다. 제 잘못이라고요? 어쩌라구요. 돌아가세요.</p>
<p>${excetion.message }</p>
<a href="${pageContext.request.contextPath }/">인덱스로 돌아가기</a>
</body>
</html>