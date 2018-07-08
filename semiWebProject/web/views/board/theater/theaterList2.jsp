<%@page import="board.theater.controller.TheaterListExtXml"%>
<%@page import="board.theater.model.vo.TheaterVo"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int currentPage = 1;
	if(null != request.getParameter("page")) {
		currentPage = Integer.parseInt(request.getParameter("page"));
	}
	List<TheaterVo> list = null;
	TheaterListExtXml extXml = new TheaterListExtXml();
	list = extXml.getXmlDataSAX(currentPage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function movePage(page) {
	location.href="http://localhost:8081/swp/views/board/theater/theaterList2.jsp?page=" + page;
}
function nextPage(page) {
	page += 1;
	location.href="http://localhost:8081/swp/views/board/theater/theaterList2.jsp?page=" + page;
}
function prevPage(page) {
	page -= 1;
	location.href="http://localhost:8081/swp/views/board/theater/theaterList2.jsp?page=" + page;
}

</script>
<style>
td {
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<%@ include file="/views/common/header2.jsp"%>
		<div class="section">
			<table width="100%" border=0 cellpadding=0 cellspacing=0
				align="center">
				<tr>
					<th>공연시설명</th>
					<th>공연장 수</th>
					<th>시설 특성</th>
					<th>지역(시도)</th>
					<th>지역(구군)</th>
					<th>개관연도</th>
				</tr>
				<%
					if (list.size() == 0) {
				%>
				<tr>
					<td colspan="5">조회 된 데이터가 없습니다.</td>
				</tr>
				<%
					} else {
				%>
				<%
					for (TheaterVo theater : list) {
				%>
				<tr>
					<td><%=theater.getFcltynm()%></td>
					<td><%=theater.getMt13cnt()%></td>
					<td><%=theater.getFcltychartr()%></td>
					<td><%=theater.getSidonm()%></td>
					<td><%=theater.getGugunnm()%></td>
					<td><%=theater.getOpende()%></td>
				</tr>
				<%
					}
				%>
				<%
					}
				%>
			</table>

			<!-- 페이징 처리 부분     <<	1 2 3 4 5 6 7 ... >>  -->
			<div class="pageArea" align="center">
				<button onclick="movePage(1);"><<</button>
				<button onclick="prevPage(<%=currentPage%>);"><</button>
				<%
					for (int i = currentPage; i <= currentPage + 10; i++) {
				%>
				<%
					if (currentPage == i) {
				%>
				<button disabled><%=i%></button>
				<%
					} else {
				%>
				<button onclick="movePage(<%=i%>);"><%=i%></button>
				<%
					}
				%>
				<%
					}
				%>
				<button onclick="nextPage(<%=currentPage%>);">></button>
			</div>
		</div>
	</div>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>