<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp" />
<c:import url="../temp/summernote.jsp" />
<style type="text/css">
	/* summernote class name */
	.note-editable	{
		height: 300px;
	}
</style>
</head>
<body>
	<div class="container">
		<h1>Product Write Page</h1>
		
		<!-- method 디폴트가 POST -->
		<!-- action 안쓰면 URL 주소 -->
		<form:form commandName="productVO" enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">Category:</label>
				<form:select cssClass="form-control" path="category">
					<option>-- 선택 -- </option>
					<form:options cssClass="form-control" items="${list}"/>
				</form:select>
			</div>
			
			<div class="form-group">
		      <label for="title">Title:</label>
		      <form:input path="title" cssClass="form-control" id="title"/>
		    </div>
		    
		    <div class="form-group">
		      <label for="price">Price:</label>
		      <form:input path="price" cssClass="form-control" id="price"/>
		    </div>
		    
		    <div class="form-group">
		      <label for="SubContents">SubContents:</label>
		      <form:textarea path="subContents" cssClass="form-control" cols="" rows="8"/>
		    </div>
		    
		    <div>
		    	<label for="mainContents">MainContents</label>
		    	<form:textarea id="contents" path="mainContents" cssClass="form-control"/>
		    </div>
		    
		     <div class="form-group">
		      <label for="amount">Amount:</label>
		      <form:input path="amount" cssClass="form-control" id="amount"/>
		    </div>
		    
			
			<div>
		    	<input type="button" class="btn btn-info" id="add" value="ADD FILE">
		    	<div id="files"></div>
		    </div>
			
			<button class="btn btn-default">Write</button>
			
			
		</form:form>
		
	</div>

<script type="text/javascript" src="../resources/js/summernote.js"></script>
<script type="text/javascript">

	var count=0;
	
	$("#add").click(function() {
		if(count<5){
			var result ='<div class="input-group col-xs-3"><input type="file" name="f1" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-remove del"></i></span> </div>';
			$("#files").append(result);
			count++;
		}else {
			alert("첨부파일은 최대 5개만 가능합니다.");
		}
	});
	
	$("#files").on("click", ".del", function() {
		$(this).parent().parent().remove();
		//$(this).remove();
		count--;
	});
</script>
</body>
</html>