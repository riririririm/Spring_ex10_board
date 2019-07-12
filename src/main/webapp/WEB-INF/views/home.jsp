<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./temp/boot.jsp"/>
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
		<a href="./mall/productWrite">Product Write</a>
		<a href="./mall/productList">Product List</a>
	</c:otherwise>
</c:choose>

<div>
	<a href="./mall/productWrite" class="btn btn-default">상품등록</a>
</div>
</body>
</html>
