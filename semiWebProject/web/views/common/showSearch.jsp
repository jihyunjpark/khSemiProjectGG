<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="board.show.controller.ShowReviewCount"%>
<%@page import="board.show.controller.ShowPointgrade"%>
<%@page import="board.show.controller.ShowListExtXml"%>
<%@page import="board.show.model.vo.ShowVo2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.show.model.vo.ShowVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<ShowVo2> list = null;
	int currentPage = 1;
	String query = "";
	if (null != request.getParameter("page")) {
		currentPage = Integer.parseInt(request.getParameter("page"));
	}
	if(null != request.getParameter("query")) {
		query = request.getParameter("query");
	}
	ShowListExtXml slext = new ShowListExtXml();
	list = slext.getSearchShow(currentPage, query);
	//System.out.println(list.size());
	
	ShowPointgrade sp = new ShowPointgrade();
	int point = 0;
	ShowReviewCount src = new ShowReviewCount();
	int count = 0;
%>
<%
	int limitPage; //한페이지에 출력할 페이지 갯수
	int maxPage; //가장 마지막 페이지
	int startPage; //시작 페이지 변수
	int endPage; //마지막 페이지 변수
	int limit; //한페이지에 출력할 글에 갯수

	limit = 12;
	limitPage = 10;

	int listCount = 0;
	//게시글의 총 갯수
	listCount = 100;
	
	
	
	
	//134 -> 14
	maxPage = (int) ((double) listCount / limit + 0.9);

	//현재 페이지 번호
	//12 - 10
	/* startPage = (int) (currentPage / limitPage * limitPage) + 1; */
	startPage = ((currentPage - 1) / 10) * 10 + 1;

	//11~20  -> 134 -> 14
	endPage = startPage + limitPage - 1;
	if (maxPage < endPage) {
		endPage = maxPage;
	}

	System.out.println("request.category:" + request.getParameter("category"));
	System.out.println("limitPage:" + limitPage);
	System.out.println("maxPage:" + maxPage);
	System.out.println("startPage:" + startPage);
	System.out.println("endPage:" + endPage);
	System.out.println("limit:" + limit);
	System.out.println("currentPage:" + currentPage);
	System.out.println("listCount:" + listCount);
	System.out.println();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function movePage(page) {
var query = $("#nquery").val();
	location.href="http://localhost:8081/swp/views/common/showSearch.jsp?page=" + page + "&query=" + query;
}
function prevPage(page) {
var query = $("#nquery").val();
	page -= 1;
	location.href="http://localhost:8081/swp/views/common/showSearch.jsp?page=" + page + "&query=" + query;
}
function nextPage(page) {
var query = $("#nquery").val();
	page += 1;
	location.href="http://localhost:8081/swp/views/common/showSearch.jsp?page=" + page + "&query=" + query;
}

</script>
<style>
.showListTable {
	margin: 0 auto;
	width: 1140px;
	border: 0;
	cellpadding: 0;
	cellspacing: 0;
	border-spacing: 7px;
	width: 1140px;
}

.listReview {
	margin: 0px;
	padding: 0px;
}

.pageArea {
	width: 520px;
	height: 1400px;
	margin: 20px auto;
}

.pageArea button {
	
}

#mnImage {
	padding-bottom: 10px;
	margin-bottom: 30px;
	border-bottom: 2px solid #e5e5e5;
}
</style>
</head>
<body>
	<div>
		<%@ include file="/views/common/header.jsp"%>
		<script>
		$(function() {
			$("#nquery").val('<%=query%>');
			
		});
		</script>
		<div class="section">
		<h1>검색 결과</h1>
			<table class="showListTable">
			<%if(list.size() == 0){ %>
			<h2>검색결과가 없습니다.</h2>
			<%} %>
			
				<%
					for (int i = 0; i < list.size(); i++) {
						ShowVo2 show = list.get(i);
						point = sp.getShowPointgrade(show.getMt20id());
						count = src.getShowReviewCount(show.getMt20id());
				%>
				<%
					if (i % 3 == 0) {
				%>
				<tr>
					<%
						}
					%>
					<td valign=top width="33.3333333333%">
						<table border="0" cellpadding="0" cellspacing="0" id="subList">
							<tr>
								<td valign=top><a target="_self"
									href="/swp/reviewList.do?showId=<%=show.getMt20id()%>"
									id="listImgA"><img src=<%=show.getPoster()%> width="184" /></a></td>
								<td class="subListText">
									<ul>
										<li class="ltShowKind"><%=show.getGenrenm()%></li>
										<li class="ltShowName"><a
											href="/swp/reviewList.do?showId=<%=show.getMt20id()%>"
											title="<%=show.getPrfnm()%>"><%=show.getPrfnm()%></a></li>
										<li class="ltShowDetail"><%=show.getGenrenm()%></li>
										<li class="ltShowPlace"><%=show.getFcltynm()%></li>
										<li class="ltdate"><%=show.getPrfpdfrom()%>-<%=show.getPrfpdto()%></li>
										<li class="ltShowStar">
											<%
												for (int star = 0; star < point; star++) {
											%> <img src='/swp/images/star01.jpg' class="starImg" /> <% } %>
											<% for(int idx = point; idx < 5; idx++){ %> <img
											src='/swp/images/star02.jpg' class="starImg" /> <%} %>
											<p class='listReview'>
												리뷰(<b><%=count%></b>)
											</p>
										</li>
									</ul>
								</td>
							</tr>
						</table>
					</td>
					<%
						if (i % 3 == 2) {
					%>
				</tr>
				<%
					}
				%>
				<%
					}
				%>
			</table>
		</div>

		<!-- 페이징 처리 부분     <<	1 2 3 4 5 6 7 ... >>  -->
		<div class="pageArea">
			<button onclick="movePage(1);"><<</button>
			<button onclick="prevPage(<%=currentPage%>)"
				<%if (1 == currentPage) {%> disabled <%}%>><</button>
			<%
				for (int i = startPage; i <= endPage; i++) {
			%>

			<button onclick="movePage(<%=i%>);" <%if (currentPage == i) {%>
				disabled <%}%>><%=i%></button>
			<%
				}
			%>
			<button onclick="nextPage(<%=currentPage%>)"
				<%if (maxPage == currentPage) {%> disabled <%}%>>></button>
		</div>
	</div>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>