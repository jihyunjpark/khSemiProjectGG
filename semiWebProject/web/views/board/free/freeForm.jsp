<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//MemberVo member = (MemberVo) session.getAttribute("user");
	%>
<!DOCTYPE html>
<html>
<head>
<style>
.outer{
	width:800px;
	height:500px;
	background:white;
	color:black;
	margin-left:auto;
	margin-right:auto;
	padding:20px;
	border:1px solid #7c65b2;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/views/common/header.jsp" %>
	<div class="outer">
		<div class="tableArea" align="center">
			<form method="post" action="/swp/writeFree.do">
			<input type="hidden" name="userid" value="<%=member.getUserId() %>"/>
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" id="title" name="title" size="30"></td>
					</tr>
					<tr>
						<td colspan="2"><textarea id="content" name="content" cols="40" rows="15"></textarea></td>
					</tr>
				</table>
				<div align="center">
					<input type="submit" value="작성"/>
					<input type="button" value="취소" onclick="moveListPage();"/>
				</div>
			</form>
		</div>
	</div>
<%@ include file="/views/common/footer.jsp"%>
</body>
<script>
function moveListPage(){
	if($("#title").val() == "" && $("#content").val() == ""){
		location.href = "/swp/freeList.do?currentPage=<%=currentPage%>";
	}else{
		if(confirm("작성 중인 내용이 있습니다. 작성을 종료 하시겠습니까?")){
			location.href = "/swp/freeList.do?currentPage=<%=currentPage%>";
		}
	}
}
</script>
</html>