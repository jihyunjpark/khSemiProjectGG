<%@page import="board.theater.model.vo.TheaterVo"%>
<%@page import="java.util.List"%>
<%@page import="board.theater.controller.XmlExtractionSAX"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<TheaterVo> theaterList = null;
	XmlExtractionSAX xmlES = new XmlExtractionSAX();
	theaterList = xmlES.getXmlDataSAX();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<h2>극장 리스트</h2>
	
	<table class="">
	<tr>
	
	
	</table>

	공연시설명 공연장 수 시설특성 지역(시도) 지역(구군) 개관연도
	<br>
	<%for(TheaterVo a : theaterList) {
		%>
		<%=a.getFcltynm() %>
		<%=a.getMt13cnt() %>
		<%=a.getFcltychartr() %>
		<%=a.getSidonm() %>
		<%=a.getGugunnm() %>
		<%=a.getOpende() %>
		<br>
	<% }%>

















	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>