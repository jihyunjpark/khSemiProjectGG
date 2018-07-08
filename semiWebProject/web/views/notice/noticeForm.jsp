<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<form method="post" action="/swp/writeNotice.do">
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" size="30"></td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="content" cols="40" rows="15"></textarea></td>
					</tr>
				</table>
				<div align="center">
					<input type="submit" value="작성"/>
					<input type="button" value="취소" onclick="noticePage();"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>