<%@page import="admin.notice.model.vo.NoticeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%NoticeVo notice = (NoticeVo)request.getAttribute("notice"); %>
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
	#deleteBtn{
		width:150px;
		height:30px;
		background:#7c65b2;
		color:white;
		text-align:center;
		vertical-align:middle;
		display:table-cell;
		border-radius:5px;
		cursor:pointer;
	}
</style>
<meta charset="UTF-8">
<script>
	function deleteNotice(){
		if(confirm("삭제하시겠습니까?")){
			location.href="/swp/deleteNotice.do?noticeNo=<%=notice.getNotice_no()%>";
		}
	}

</script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<div class="outer">
		<div class="tableArea">
			<table>
				<tr>
					<th>제목: </th>
					<td><%=notice.getNotice_title() %></td>
				</tr>
				<tr>
					<th>작성일: </th>
					<td><%=notice.getNotice_date() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><%=notice.getNotice_content() %></td>
				</tr>
			</table>
			<div align="center">
				<div id="deleteBtn" onclick="deleteNotice();">삭제</div>
			</div>
			
		</div>
	</div>
</body>
</html>