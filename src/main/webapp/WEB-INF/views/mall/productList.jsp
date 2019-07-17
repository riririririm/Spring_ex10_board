<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp" />
</head>
<body>

	<div class="container">
		<c:forEach items="${productList}" var="product" varStatus="i">
			<div class="col-md-4">
				<div class="thumbnail">
					<a href="./productSelect?pid=${product.pid}"> 
						<img src="../resources/mall/${product.nailVOs['0'].fname}" alt="" style="width: 100%">
						<div class="caption">
							<h3>${product.title }</h3>
							<p>${product.price}</p>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>

	</div>


</body>
</html>