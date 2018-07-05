<%@page import="java.util.ArrayList"%>
<%@page import="board.show.model.vo.ShowVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ShowVo> list = (ArrayList<ShowVo>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<%@ include file="/views/common/header.jsp"%>
<div class="section">
<table width="100%" border=0 cellpadding=0 cellspacing=0>
			<%for(int i = 0 ; i < list.size(); i++){ 
						ShowVo show = list.get(i);	%>
				<%if(i % 3 == 0){ %>
					<tr>
				<%} %>
					<td valign=top width="33.3333333333%">
						<table border="0" cellpadding="0" cellspacing="0" id="subList">
							<tr>
								<td valign=top><a
								target="_self"
									href="/swp/showSub.do?showCode=<%=show.getShow_code()%>"
									id="listImgA"><img
										src='/swp/resource/upload/<%=show.getShow_image() %>'
										width=184 /></a></td>
								<td class="subListText">
									<ul>
										<li class="ltShowKind">
										<%if(show.getCategory().equals("Y")){ %>
											&lt연극&gt
										<%}else{ %>
											&lt뮤지컬&gt
										<%} %>
										</li>
										<li class="ltShowName"><a
											href="/swp/showSub.do?showCode=<%=show.getShow_code()%>"
											title="<%=show.getShow_name() %>"><%=show.getShow_name() %></a></li>
										<li class="ltShowDetail">
										<%=show.getGenre() %>
										</li>
										<li class="ltShowPlace"><%=show.getLocation() %></li>
										<li class="ltdate"><%=show.getPeriod() %></li>
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
				<%if(i % 3 == 2){ %>	
					</tr>
				<%} %>
			<%} %>
		</table>
</div>
	</div>
	</div>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>