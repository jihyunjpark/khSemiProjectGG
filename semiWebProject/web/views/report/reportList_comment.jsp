<%@page import="common.PageInfo"%>
<%@page import="report.comment.model.vo.CommentVo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<CommentVo> list = (ArrayList<CommentVo>)request.getAttribute("list");
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
<title>코멘트 신고 목록</title>
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
.searchArea{
	width:650px;
	margin-left:auto;
	margin-right:auto;
}
</style>

</head>
<body>

<div class="outer">
	<h1 align="center">코멘트 신고 목록</h1>
	
	<div class="tableArea"  align="center">
		<table align="center">
			<tr >
				<th width="60">신고수</th>
				<th width="60">번호</th>
				<th width="100">작성자</th>
				<th width="300">내용</th>
				<th width="100">게시판번호</th>
				<th width="150">작성일</th>
			</tr>
			<tr><th bgcolor="#7c65b2" colspan="6"></th></tr>
			<%if(list.size() == 0){ %>
				<tr align="center">
					<td colspan="5">신고 된 리뷰가 없습니다.</td>
				</tr>
			<%}else{ %>
				<%for(CommentVo n : list){ %>
				<tr>
					<td><%=n.getRcount()%></td>
					<td><%=n.getBno()%></td>			
					<td><%=n.getWriterName() %></td>			
					<td><%=n.getContent()%></td>		
					<td><%=n.getBno()%></td>				
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
	<br>
</div>
</script>
<script>
$(function(){
	$(".tableArea td").mouseenter(function(){
		$(this).parent().css("cursor","pointer");
	})//.click(function(){
		//var reviewNo = $(this).parent().children().eq(0).text();
		//location.href = 
	});
});
function movePage(pageNum){
	location.href = "/swp/commentList_r.do?currentPage=" + pageNum;
}

</script>
<%@ include file="../common/footer.jsp" %>
</body>
</html>









