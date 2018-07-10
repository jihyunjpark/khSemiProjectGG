<%@page import="board.faq.model.vo.FaqVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<FaqVo> list = (ArrayList<FaqVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.faqMenu {
	margin-left: auto;
	margin-right: auto;
	width: 800px;
	height: 500px;
	background: white;
}

.accordionMenu {
	background: white;
	padding: 10px;
	margin-left: auto;
	margin-right: auto;
	width: 500px;
}

.accordionMenu h2 {
	text-align: center;
	margin: 5px 0;
	padding: 0;
}

.accordionMenu h2 a {
	font-size: 18px;
	display: block;
	font-weight: normal;
	text-decoration: none;
	margin: 0;
	padding: 10px;
	background: #7c65b2;
	color: white;
	border-radius: 5px;
}

.accordionMenu :target h2 a, .accordionMenu h2 a:focus, .accordionMenu h2 a:hover,
	.accordionMenu h2 :active {
	background: #7c65b2;
	color: white;
	text-weight: bold;
}
a{
	text-decoration: none;
	color: red;
}
.accordionMenu p{
	font-size:16px;
	padding: 0 10px;
	margin: 0;
	height: 0;
	overflow: hidden;
	transition: none;
	text-align: center;
}
.accordionMenu :target p{
	background: white;
	color: #7c65b2;
	overflow:auto;
	height: auto;
	padding-top: 20px;
	padding-bottom: 25px;
	border: 1px solid #7c65b2;
	border-radius: 5px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@include file="/views/common/header.jsp"%>
	<div class="faqMenu">
		<div class="accordionMenu">
			<%
				for (FaqVo n : list) {
			%>
			<div id="a<%=n.getFaq_no()%>" class="menuSection">
				<h2>
					<a href="#a<%=n.getFaq_no()%>"><%=n.getFaq_title()%></a>
				</h2>
				<p><%=n.getFaq_content()%></p>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<div class="btnArea">
	</div>
</body>
</html>