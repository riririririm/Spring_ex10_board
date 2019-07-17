<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Home</title>
<c:import url="./temp/boot.jsp"/>
</head>
<body>



<a href="./qna/qnaList">Qna List</a>

<c:choose>
	<c:when test="${not empty member}">
	<h1><spring:message code="login.message" arguments="${member.id },my Home" argumentSeparator=","/></h1>
		<a href="./member/memberLogout">logout</a>
		<a href="./cart/cartList" class="btn btn-default">장바구니</a>
		<c:if test="${member.grade eq '0'}">
			<a href="./member/memberAdmin">Admin Page</a>
		</c:if>
	</c:when>
	<c:otherwise>
		<a href="./member/memberJoin" class="btn btn-default">Join</a>
		<a href="./member/memberLogin" class="btn btn-default">Login</a>
	</c:otherwise>
</c:choose>

<a href="./mall/productWrite" class="btn btn-primary">Product Write</a>
<a href="./mall/productList" class="btn btn-default">Product List</a>

</body>
</html>
