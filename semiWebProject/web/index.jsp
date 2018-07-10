<%@page import="board.show.model.vo.BoxofficeShowVo"%>
<%@page import="java.util.List"%>
<%@page import="board.show.controller.BoxofficeListExtXml"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoxofficeListExtXml boxExt = new BoxofficeListExtXml();
	String category = "AAAA";
	String type = "week";
	if (null != request.getParameter("category")) {
		category = request.getParameter("category");
	}
	if (null != request.getParameter("type")) {
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
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<section class="vertical-center slider">
		<div>
			<img src="/swp/images/main_flash_1_180625.jpg">
		</div>
		<div>
			<img src="/swp/images/main_flash_2_180625.jpg">
		</div>
		<div>
			<img src="/swp/images/main_flash_3_180625.jpg">
		</div>
		<div>
			<img src="/swp/images/main_flash_4_180625.jpg">
		</div>
		<div>
			<img src="/swp/images/main_flash_4_180625.jpg">
		</div>
		<div>
			<img src="/swp/images/main_flash_4_180625.jpg">
		</div>
		<div>
			<img src="/swp/images/main_flash_1_180625.jpg">
		</div>
	</section>

	<div>
		<!-- 박스오피스 -->

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
					<input type="hidden" name="specificGubun" id="specificGubun"
						value="">
					<div class="main_menu1">
						<select id="period" name="period" title="기간">
							<option value="week" selected>주간</option>
							<option value="month">월간</option>
						</select>
					</div>
					<div class="main_menu2">
						<p>
							<a href="#none" class="m01 m01_on" id="Theatre"
								onclick="searchCategory('AAAA')"><span class="text_none">연극</span></a>
						</p>
						<p>
							<a href="#none" class="m02" id="Musical"
								onclick="searchCategory('AAAB')"><span class="text_none">뮤지컬</span></a>
						</p>
						<p>
							<a href="#none" class="m03" id="Classic"
								onclick="searchCategory('CCCA')"><span class="text_none">클래식/오페라</span></a>
						</p>
					</div>
				</form>
			</div>

			<ul class="boxOfficePoster">
				<%
					for (int i = 0; i < 10; i++) {
				%>
				<%
					if (list.get(i).getPoster().charAt(0) == '/') {
							list.get(i).setPoster("http://www.kopis.or.kr/" + list.get(i).getPoster());
						}
				%>

				<li><a href=""><div class="poster">
							<span class="num"><img
								src="/swp/images/main/poster_rank_<%=i + 1%>.png"
								alt="<%=list.get(i).getRnum()%>>"></span><span class="poster_img"><img
								src="<%=list.get(i).getPoster()%>"
								alt="<%=list.get(i).getPrfnm()%>"></span>
						</div>
						<div class="poster_hover" style="display: none; opacity: 1;">
							<dl>
								<dt style="margin-bottom: 30px"><%=list.get(i).getPrfnm()%></dt>
								<dt><%=list.get(i).getMt20id()%></dt>
								<dt><%=list.get(i).getPrfplcnm()%></dt>
							</dl>
						</div></a></li>
				<%
					}
				%>

			</ul>

		</div>

	</div>


	<script src="https://code.jquery.com/jquery-2.2.0.min.js"
		type="text/javascript"></script>
	<script src="./slick/slick.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
				$(document).on('ready', function() {
					$(".vertical-center").slick({
						dots : true,
						vertical : true,
						centerMode : true,
					});
					$(".lazy").slick({
						lazyLoad : 'ondemand', // ondemand progressive anticipated
						infinite : true
					});
				});
			</script>
	<script>
			$(function(){
				$('#period').val('<%=type%>');
				$('#period').change(function(){
					location.href="/swp/index.jsp?category=<%=category%>&type="	+ $('#period').val();
					});
				
		});
			
			function searchCategory(category) {
				location.href="/swp/index.jsp?category=" + category +"&type=" + $('#period').val();
			}
			
			
	</script>


	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>