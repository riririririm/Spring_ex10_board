<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./qna/qnaList">Qna List</a>

<c:choose>
	<c:when test="${not empty member}">
		<a href="./member/memberLogout">Logout</a>
		<c:if test="${member.grade eq '0' }">
			<a href="./member/memberAdmin">Admin Page</a>
		</c:if>
		<!-- <a href="./member/memberPage">MyPage</a> -->
	</c:when>
	<c:otherwise>
		<a href="./member/memberJoin">Member Join</a>
		<a href="./member/memberLogin">Member Login</a>
	</c:otherwise>
</c:choose>
</body>
</html>
