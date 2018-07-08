<%@page import="admin.notice.model.vo.NoticeVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<NoticeVo> list = (ArrayList<NoticeVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.outer {
	width: 800px;
	height: 500px;
	background: white;
	color: black;
	margin-left: auto;
	margin-right: auto;
	padding: 20px;
	border: 1px solid #7c65b2;
}

.tableArea {
	width: 800px;
	height: 400px;
	margin-left: auto;
	margin-right: auto;
}

table td {
	text-align: center;
}
#writeBtn{
	width:150px;
	height:30px;
	color:white;
	background:#7c65b2;
	border-radius:5px;
	text-align:center;
	vertical-align:middle;
	display:table-cell;
	cursor:pointer;
}
</style>
<title>Insert title here</title>
<script>
	function writeNotice(){
		location.href="/swp/views/notice/noticeForm.jsp";
	}
</script>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<div class="outer">
		<h1 align="center">공지사항</h1>
		<div class="tableArea">
			<table align="center">
				<tr>
					<th width="150">글번호</th>
					<th width="400">글제목</th>
					<th width="250">작성일</th>
				</tr>
				<%
					if (list.size() == 0) {
				%>
				<tr>
					<td colspan="3">조회 된 공지사항이 없습니다.</td>
				</tr>
				<%
					} else {
				%>
				<%
					for (NoticeVo n : list) {
				%>
				<tr>
					<td><%=n.getNotice_no()%></td>
					<td><a
						href="/swp/noticeDetail.do?notice_no=<%=n.getNotice_no()%>"><%=n.getNotice_title()%></a>
					</td>
					<td><%=n.getNotice_date()%></td>
				</tr>
				<%
					}
				%>
				<%
					}
				%>
			</table>
		</div>
		<div id="writeBtn" onclick="writeNotice();">작성</div>
	</div>
</body>
</html>