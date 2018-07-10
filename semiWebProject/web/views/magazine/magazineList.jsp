<%@page import="magazine.model.vo.AttachmentVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<AttachmentVo> list = (ArrayList<AttachmentVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.outer {
	margin-left: auto;
	margin-right: auto;
	width: 800px;
	height: auto;
	background: white;
	color: #7c65b2;
	border: 1px solid #7c65b2;
}

.row {
	display: flex;
	flex-wrap: wrap;
}

.column {
	flex: 50%;
	max-width: 50%;
}

.image-list:hover {
	opacity: 0.7;
	cursor: pointer;
}
</style>
<title>Insert title here</title>
<script>
function moveMagazineForm(){
	location.href="/swp/views/magazine/magazineForm.jsp";
}
function attachDetailPage(bno){
	location.href="/swp/selectAttachDetail.do?bno="+bno;
}
</script>
</head>
<body>
	<%@include file="/views/common/header.jsp"%>
	<div class="outer">
		<div class="row">
			<div class="column">
				<%
					for (AttachmentVo av : list) {
				%>
				<div class="image-list"
					onclick="attachDetailPage(<%=av.getBno()%>);" align="center">
					<div>
						<img src="/swp/upload_gallery/<%=av.getChange_name()%>"
							width="390px" height="auto" />
					</div>
				</div>
				<%
					}
				%>
			</div>
			<div class="column">
				<%
					for (AttachmentVo av : list) {
				%>
				<div class="image-list"
					onclick="attachDetailPage(<%=av.getBno()%>);" align="center">
					<div>
						<img src="/swp/upload_gallery/<%=av.getChange_name()%>"
							width="390px" height="auto" />
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>