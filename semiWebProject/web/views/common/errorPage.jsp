<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<div>
		<p>에러 발생</p>
		<p><%=msg%></p>
	</div>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>