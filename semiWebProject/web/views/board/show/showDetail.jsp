<%@page import="java.util.ArrayList"%>
<%@page import="board.review.model.vo.ReviewVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/* if (null != request.getAttribute("reviewList")) {
		ArrayList<ReviewVo> list = (ArrayList<ReviewVo>) request.getAttribute("reviewList");
		
	} */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/views/common/header.jsp"%>
<div class="wrap">
<div id="container ">
<div class="wrapper">
<div id="subContainer">
<div id="detailMain">
	<div id="contentsLeft">
		<img
			src='http://www.kkongal.co.kr/shop/data/goods/1526622298788m0.gif'
			width=350 id="objImg" class="subDetailImg"   />
		

	</div>

	<div id="contentsRight">
	<div class="iconArea"></div>
	<ul id="eventContents">
		<li class="detailCntExp"><2018-19 세종시즌></li>
		<li class="detailCntName">뮤지컬<b>번지 점프를 하다</b></li>
		<li>
		<table border=0 cellpadding=0 cellspacing=0 id="contentsDetailTB">
		   <tr>
				<th>장&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;르 :</th>
				<td>뮤지컬</td>
			</tr>
			<tr>
				<th>공연시간 :</th>
				<td>120분</td>
			</tr>
			<tr>
				<th>인터미션 :</th>
				<td>15분</td>
			</tr>
			<tr>
				<th>관람등급 :</th>
				<td>만 7세이상</td>
			</tr>
			<tr>
				<th>공연장소 :</th>
				<td>세종문화회관 M씨어터</td>
			</tr>
			<tr>
				<th>공연기간 :</th>
				<td>2018.06.12 ~ 2018.08.26</td>
			</tr>
			<tr>
				<th>출&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;연 :</th>
				<td>강필석,이지훈,임강희,김지현,최우혁,이휘종,이지민,최호중,진상현</td>
			</tr>
			<tr>
				<th>홈페이지 :</th>
				<td><a href="http://xn--6h5by1a/" target="new">http://없음</a></td>
			</tr>
		</table>
		</li>
	</ul>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
		</div>
	
	<div class="review_area">
		<h1 align="center">리뷰 게시판</h1>
		<div class="tableArea">
			<table align="center">
				<tr>
					<th width="100">번호</th>
					<th width="300">제목</th>
					<th width="100">작성자</th>
					<th width="100">조회수</th>
					<th width="150">작성일</th>
				</tr>
				<%
					/* if (list.size() == 0) { */
				%>
				<tr>
					<td colspan="5">조회 된 게시글이 없습니다.</td>
				</tr>
				<%-- <%
					} else {
				%>
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=list.get(i).getMemberName()%></td>
					<td><%=list.get(i).getPointgrade()%></td>
					<td><%=list.get(i).getContent()%></td>
					<td><%=list.get(i).getReviewDate()%></td>
				</tr>
				<%
					}
				%>
				<%
					}
				%> --%>
			</table>
		</div>

		<%-- 		<!-- 페이징 처리 부분     <<	1 2 3 4 5 6 7 ... >>  -->
		<div class="pageArea" align="center">
			<button onclick="movePage(1);"><<</button>
			<%
				for (int i = startPage; i <= endPage; i++) {
			%>
			<button onclick="movePage(<%=i%>);" <%if (currentPage == i) {%>
				disabled <%}%>><%=i%></button>
			<%
				}
			%>
			<button onclick="movePage(<%=maxPage%>);">>></button>
		</div> --%>
	</div>



	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>