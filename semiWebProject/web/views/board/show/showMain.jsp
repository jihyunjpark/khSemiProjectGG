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
	String category = "AAAA";
	if (null != request.getParameter("category")) {
		category = request.getParameter("category");
	} else {
		category = "AAAA";
	}
	int currentPage = 1;
	if (null != request.getParameter("page")) {
		currentPage = Integer.parseInt(request.getParameter("page"));
	}
	if (category.equals("AAAA")) {
		ShowListExtXml ext = new ShowListExtXml();
		list = ext.getXmlDataSAX(currentPage, "AAAA");
	} else if (category.equals("AAAB")) {
		ShowListExtXml ext = new ShowListExtXml();
		list = ext.getXmlDataSAX(currentPage, "AAAB");
	} else if (category.equals("CCCA")) {
		ShowListExtXml ext = new ShowListExtXml();
		list = ext.getXmlDataSAX(currentPage, "CCCA");
	}

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

	if (request.getParameter("page") != null) {
		currentPage = Integer.parseInt(request.getParameter("page"));
	} else {
		currentPage = 1;
	}
	int listCount = 0;
	//게시글의 총 갯수
	switch (category) {
		case "AAAA" :
			listCount = 527;
			break;
		case "AAAB" :
			listCount = 587;
			break;
		case "CCCA" :
			listCount = 885;
			break;
	}
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
	System.out.println("category:" + category);
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
	location.href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=<%=category%>&page=" + page;
}
function prevPage(page) {
	page -= 1;
	location.href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=<%=category%>&page=" + page;
}
function nextPage(page) {
	page += 1;
	location.href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=<%=category%>&page=" + page;
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
	width: 720px;
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
		<div class="section">
			<div id="mnImage"><img src="/swp/images/mnImage_<%=category%>.png" class="mnImage"/></div>
			<table class="showListTable">
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
											<%-- 											href="http://localhost:8081/swp/views/board/show/showSub2.jsp?showId=<%=show.getMt20id()%>" --%>
											title="<%=show.getPrfnm()%>"><%=show.getPrfnm()%></a></li>
										<li class="ltShowDetail"><%=show.getGenrenm()%></li>
										<li class="ltShowPlace"><%=show.getFcltynm()%></li>
										<li class="ltdate"><%=show.getPrfpdfrom()%>-<%=show.getPrfpdto()%></li>
										<li class="ltShowStar">
											<%
												for (int star = 0; star < point; star++) {
											%> <img src='/swp/images/star01.jpg' class="starImg" /> 
											<% } %>
											<% for(int idx = point; idx < 5; idx++){ %>
											<img src='/swp/images/star02.jpg' class="starImg" />
											<%} %>
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

		<!-- 페이징 처리     <<	1 2 3 4 5 6 7 ... >>  -->
		<div class="pageArea">
			<i class="icono-rewind" onclick="movePage(1);"><<</i>
			<i class="icono-previous" onclick="prevPage(<%=currentPage%>)"
				<%if (1 == currentPage) {%> disabled <%}%>><</i>
			<%
				for (int i = startPage; i <= endPage; i++) {
			%>

			<button class="numberCircle" onclick="movePage(<%=i%>);" <%if (currentPage == i) {%>
				disabled <%}%>><%=i%></button>
			<%
				}
			%>
			<i class="icono-next" onclick="nextPage(<%=currentPage%>)"
				<%if (maxPage == currentPage) {%> disabled <%}%>>></i>
			<i class="icono-forward" onclick="movePage(<%=maxPage%>);">>></i>
		</div>
	</div>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>