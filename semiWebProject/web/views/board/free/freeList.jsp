<%@page import="common.PageInfo"%>
<%@page import="board.free.model.vo.FreeVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<FreeVo> list = (ArrayList<FreeVo>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getTotalCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
/* 	MemberVo member = (MemberVo) session.getAttribute("user"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.freeListArea {
height:300px;


}

.pageArea {
margin-top: 10px;
}
.tableArea {
	width: 1000px;
	height: 250px;
	margin-left: auto;
	margin-right: auto;
}

td{
	text-align:center;
}

tr:hover{
background-color: #f5f5f5;
}

</style>
</head>
<body>
<div>
	<%@ include file="/views/common/header.jsp"%>
	<div class="freeListArea">
	<div class="section">
		<table class="tableArea" width="100%" border=0 cellpadding=0 cellspacing=0 align="center">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<%if(list.size() == 0){	%>
				<tr>
					<td colspan="5">조회 된 데이터가 없습니다.</td>
				</tr>
			<%}else{%>
				<%for(FreeVo free: list){ %>
					<tr onclick="moveFreeSub(<%=free.getBoard_no() %>);">
						<td><%=free.getBoard_no() %></td>
						<td><%=free.getTitle() %></td>
						<td><%=free.getNickname() %></td>
						<td><%=free.getBoard_count() %></td>
						<td><%=free.getBoard_date() %></td>
					</tr>
				<%} %>
			<%} %>
		</table>
		
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
	<div class="searchArea" align="center">
		<select id="searchCondition">
			<option value="1">제목</option>
			<option value="2">내용</option>
			<option value="3">작성자</option>
		</select>		
		<input type="text" id="searchText" placeholder="검색어 입력"/>
		<input type="button" value="검색하기" onclick="searchBoard();"/>
		<%if(null != member){%>
			<input type="button" value="작성하기" onclick="writeBoard();"/>
		<%} %>
	</div>
	
	
	
	</div>
</div>
<%@ include file="/views/common/footer.jsp"%>
</body>

<script>
$(function(){
	$("#searchText").change(searchBoard);
})

function writeBoard(){
	location.href = "/swp/views/board/free/freeForm.jsp?currentPage=<%=currentPage%>";
}

function searchBoard(){
	var condition = $("#searchCondition").val();
	var searchText = $("#searchText").val();
	if(searchText == ""){
		location.href = "/swp/freeList.do";		
	}else{
		location.href = "/swp/searchFreeList.do?condition=" + condition + "&keyword=" + searchText;
	}
}

function movePage(pageNum){
	location.href = "/swp/freeList.do?currentPage=" + pageNum;
}

function moveFreeSub(bno){
	location.href = "/swp/freeSub.do?currentPage=<%=currentPage%>&bno=" + bno;
}

</script>
</html>