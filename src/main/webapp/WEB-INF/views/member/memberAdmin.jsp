<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp" />
</head>
<body>
	<div class="container">
		<h1>Admin Page</h1>

		<!-- 회원들의 정보 ID, Email, grade -->
		<div>
			<form class="form-inline" action="./memberAdmin">
				<div class="form-group col-xs-2">
					<select class="form-control" name="kind">
						<option class="k" value="1">ID</option>
						<option class="k" value="2">EMAIL</option>
						<option class="k" value="3">GRADE</option>
					</select>
				</div>

				<div class="form-group col-xs-2">
					<input type="text" class="form-control" value="${pager.search}"
						name="search">
				</div>

				<div class="form-group col-xs-2">
					<button class="form-control">Search</button>
				</div>

			</form>
		</div>


		<form id="frm" action="./memberAdmin" method="post">
			<table class="table table-hover">
				<tr>
					<td><input type="checkbox" id="checkAll"></td>
					<td>아이디</td>
					<td>이메일</td>
					<td>등급</td>
				</tr>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td><input type="checkbox" class="check" name="id" value="${dto.id }"></td>
						<td>${dto.id }</td>
						<td>${dto.email }</td>
						<td>${dto.grade }</td>
					</tr>
				</c:forEach>
			</table>
		</form>

		<div>
			<input type="button" id="deleteBtn" value="delete"
				class="btn btn-primary">
		</div>
	</div>

	<script type="text/javascript">
		var num = $(".check").length;
		var num2 = 0;
		$("#checkAll").click(function() {
			if ($(this).prop("checked") == true) {
				$(".check").prop("checked", true);
			} else {
				$(".check").prop("checked", false);
			}

		});
		$(".check").click(function() {
			var c2 = true;
			$(".check").each(function() {
				if (!$(this).prop("checked")) {
					c2 = false;
				}
			});
			$("#checkAll").prop("checked",c2);

		});

		$("#deleteBtn").click(function() {
			//$("#frm").submit();
			var ids = [];
			$(".check").each(function() {
				if($(this).prop("checked")){
					ids.push($(this).val());
				}
			});
			//ajax로 배열을 전송하고자 할때 추가
			jQuery.ajaxSettings.traditional=true;
			
			$.ajax({
				url:"./memberAdmin",
				type: "POST",
				data:{id:ids},
				success:function(data){
					console.log(data);
					location.reload();
				},
				error:function(){
					console.log('error');
				}
			});
		});

		var kind = '${pager.kind}';
		$(".k").each(function() {
			if ($(this).val() == kind) {
				$(this).prop("selected", true);
			}
		});
	</script>
</body>
</html>