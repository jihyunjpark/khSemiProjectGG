<%@page import="common.PageInfo"%>
<%@page import="report.board.model.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<BoardVo> list = (ArrayList<BoardVo>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getTotalCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 자유게시판 목록</title>
<style>
.outer{
	width:800px;
	height:570px;
	color:#7c65b2;
	margin-left:auto;
	margin-right:auto;
	border:1px solid #7c65b2;
}
.tableArea{
	width:800px;
	height:300px;
	margin-left:auto;
	margin-right:auto;
}
table td{
	text-align:center;
}
.searchArea{
	width:650px;
	margin-left:auto;
	margin-right:auto;
}
</style>
<script>
	
</script>
</head>
<body>
<div class="outer">
	<h1 align="center">신고 자유게시판 목록</h1>
	<div class="tableArea">
		<table align="center">
			<tr>
				<th width="100">글번호</th>
				<th width="300">글제목</th>
				<th width="100">작성자</th>
				<th width="100">조회수</th>
				<th width="150">작성일</th>
			</tr>
			<tr>
				<th colspan="5" bgcolor="#7c65b3">
			</tr>
			<%if(list.size() == 0){ %>
				<tr>
					<td colspan="5">조회 된 게시글이 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(BoardVo n : list){ %>
				<tr>
					<td><%=n.getNo()%></td>			
					<td><%=n.getTitle()%></td>			
					<td><%=n.getWriterName() %></td>			
					<td><%=n.getCount()%></td>			
					<td><%=n.getWriteDate() %></td>			
				</tr>
				<%} %>
			<%} %>
		</table>
	</div>
	
	<!-- 페이징 처리 부분     <<	1 2 3 4 5 6 7 ... >>  -->	
	<div class="pageArea" align="center">
		<button onclick="movePage(1);"> << </button>
		<%for(int i = startPage ; i <= endPage ; i++){ %>
			<%if(currentPage == i){ %>
				<button disabled><%=i %></button>
			<%}else{ %>
				<button onclick="movePage(<%=i%>);"><%=i %></button>
			<%} %>
		<%} %>
		<button onclick="movePage(<%=maxPage%>);"> >> </button>
	</div>
	
	
	
	
	
	
</div>
<script>
$(function(){
	$(".tableArea td").mouseenter(function(){

		$(this).parent().css("cursor","pointer");
	}).click(function(){
		var boardNo = $(this).parent().children().eq(0).text();
		location.href = "/mwp/selectBoard.do?boardNo=" + boardNo + "&currentPage=" + <%=currentPage%>; 		
	});
});
function movePage(pageNum){
	location.href = "/mwp/boardList.do?currentPage=" + pageNum;
}

</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>









