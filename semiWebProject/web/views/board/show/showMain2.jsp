<%@page import="board.show.controller.ShowListExtXml"%>
<%@page import="board.show.model.vo.ShowVo2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.show.model.vo.ShowVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<ShowVo2> list = null;
	String category = "AAAB";
	int currentPage = 1;
	System.out.println(request.getParameter("category"));
	if ("AAAA".equals(request.getParameter("category"))) {
		category = "AAAA";
	}
	if (null != request.getParameter("page")) {
		currentPage = Integer.parseInt(request.getParameter("page"));
	}
	if (category == "AAAB") {
		ShowListExtXml ext = new ShowListExtXml();
		list = ext.getXmlDataSAX(currentPage, "AAAB");
	} else {
		ShowListExtXml ext = new ShowListExtXml();
		list = ext.getXmlDataSAX(currentPage, "AAAA");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%@ include file="/views/common/header2.jsp"%>
		<div class="section">
			<table width="100%" border=0 cellpadding=0 cellspacing=0>
				<%
					for (int i = 0; i < list.size(); i++) {
						ShowVo2 show = list.get(i);
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
										<li class="ltShowStar"><img
											src='http://www.kkongal.co.kr/shop/data/skin/everybag_C/img/new/star02.jpg'
											class="starImg" /><img
											src='http://www.kkongal.co.kr/shop/data/skin/everybag_C/img/new/star02.jpg'
											class="starImg" /><img
											src='http://www.kkongal.co.kr/shop/data/skin/everybag_C/img/new/star02.jpg'
											class="starImg" /><img
											src='http://www.kkongal.co.kr/shop/data/skin/everybag_C/img/new/star02.jpg'
											class="starImg" /><img
											src='http://www.kkongal.co.kr/shop/data/skin/everybag_C/img/new/star02.jpg'
											class="starImg" />
											<p class='listReview'>
												리뷰(<b>0</b>)
											</p></li>
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
	</div>
	</div>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>