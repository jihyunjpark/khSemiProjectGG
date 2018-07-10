<%@page import="board.show.model.vo.BoxofficeShowVo"%>
<%@page import="java.util.List"%>
<%@page import="board.show.controller.BoxofficeListExtXml"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoxofficeListExtXml boxExt = new BoxofficeListExtXml();
String category = "AAAA";
String type = "week";
if(null != request.getParameter("category")) {
		category = request.getParameter("category");
	}
if(null != request.getParameter("type")) {
	type = request.getParameter("type");
}
List<BoxofficeShowVo> list = boxExt.getXmlDataSAX(category, type);
System.out.println(list.size());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>

<script>


</script>

</head>
<body>

	<div class="poster_rank">
		<div class="title">
			<h1>
				박스오피스<span id="genreTitle"> - 연극</span>
			</h1>
			<p>
				<!-- <span class="d1Dt">2018.07.02 ~ 2018.07.08</span><span class="text">
					기준</span> -->
			</p>
		</div>
		
		<div class="main_wrap">
			<form name="boxoffice" method="post">
				<input type="hidden" name="genre" id="genre" value="Theatre">
				<input type="hidden" name="specificGubun" id="specificGubun" value="">
				<div class="main_menu1">
					<select id="period" name="period" title="기간">
						<option value="day">일간</option>
						<option value="week" selected>주간</option>
						<option value="month">월간</option>
					</select>
				</div>
				<div class="main_menu2">
					<p><a href="#none" class="m01 m01_on" id="Theatre" onclick=><span class="text_none">연극</span></a></p>
					<p><a href="#none" class="m02" id="Musical"><span class="text_none">뮤지컬</span></a></p>
					<p><a href="#none" class="m03" id="Classic"><span class="text_none">클래식/오페라</span></a></p>
				</div>
				<div class="main_menu3">
					<p><a href="#none" class="m06" id="kid"><span class="text_none">아동</span></a></p>
					<p><a href="#none" class="m07" id="varsity"><span class="text_none">대학로</span></a></p>
					<p class="back_none2"><a href="#none" class="m08" id="openRun"><span class="text_none">오픈런</span></a></p>
				</div>
			</form>
			</div>

		<ul class="boxOfficePoster">
		<%for(int i = 0; i < 10; i++){%> 
		<% if(list.get(i).getPoster().charAt(0) == '/') {
			list.get(i).setPoster("http://www.kopis.or.kr/" + list.get(i).getPoster());
		}%>
			
			<li><a href=""><div class="poster">
						<span class="num"><img src="/swp/images/main/poster_rank_<%=i+1%>.png"
							alt="<%=list.get(i).getRnum() %>>"></span><span class="poster_img"><img
							src="<%=list.get(i).getPoster() %>"
							alt="<%=list.get(i).getPrfnm() %>"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px"><%=list.get(i).getPrfnm() %></dt>
							<dt><%=list.get(i).getMt20id() %></dt>
							<dt><%=list.get(i).getPrfplcnm() %></dt>
						</dl>
					</div></a></li>
					<%} %>
					
		</ul>

	</div>


</body>
</html>