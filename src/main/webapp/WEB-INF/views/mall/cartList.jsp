<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<!-- 타이틀, 수량, 가격, 총 가격 -->
	<div class="container">
		<!-- <form id="frm" method="post" action="./cartDelete"> -->
		<table class="table table-hover">
			<tr>
				<td>
					<p>전체선택</p>
					<p><input type="checkbox"></p>
				</td>
				<td>제품명</td>
				<td>옵션</td>
				<td>수량</td>
				<td>가격</td>
				<td>합계</td>
			</tr>
			
			<c:forEach items="${cartList}" var="cart">
				<tr>
					<td><input type="checkbox" name="checkboxs" value="${cart.num }"></td>
					<td>${cart.title }</td>
					<td>${cart.contents }</td>
					<td><input type="number" name="amount" value="${cart.amount}"><input type="button" data-num="${cart.num }" class="updateBtn" value="수정">
					<td>${cart.price }</td>
					<td>${cart.amount * cart.price }</td>
				</tr>
			</c:forEach>
		</table>
	<!-- 	</form> -->
		<div>
			<input type="button" value="Delete" id="del" class="btn btn-danger">
		</div>
	</div>
	
	<script type="text/javascript">
		$(".updateBtn").click(function() {
			var amount=$(this).prev().val();
			//var num =$(this).prev().attr("title");
			var num =$(this).attr("data-num");
			
			$.ajax({
				url:"./cartUpdate",
				type:"POST",
				data:{
					num:num,
					amount:amount
				},
				success:function(data){
					if(data=='1'){
						alert("수량을 변경했습니다.");
					}else{
						location.href="./cartList";
					}
				}
			});
		});
		
		var checkArr = new Array();
		$("#del").click(function() {
			 $("input[name=checkboxs]:checked").each(function() {
				checkArr.push($(this).val()*1);
			});
		
			if(checkArr.length==0){
				alert("삭제할 장바구니를 선택하세요");
			}else{
				//ajax로 배열을 전송하고자 할때 추가
				jQuery.ajaxSettings.traditional=true;
				$.ajax({
					type:"POST",
					url:"./cartDelete",
					data:{
						checkArr:checkArr
					},
					success:function(data){
						if(data=='1'){
							alert("선택한 장바구니를 삭제했습니다.");
						}else{
							alert("장바구니 삭제 실패했습니다.");
						}
							location.href="./cartList";
					}
				});
			} 
			//$("#frm").submit();
		});
	</script>
</body>
</html>