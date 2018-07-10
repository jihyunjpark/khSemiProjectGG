<%@page import="common.PageInfo"%>
<%@page import="board.review.model.vo.ReviewVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.theater.controller.TheaterDetailExtXml"%>
<%@page import="board.theater.model.vo.TheaterDetailVo"%>
<%@page import="board.show.controller.ShowDetailExtXml"%>
<%@page import="board.show.model.vo.ShowDetailVo"%>
<%@page import="board.show.model.vo.ShowVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ShowDetailExtXml extXmlsd = new ShowDetailExtXml();
	TheaterDetailExtXml extXmltd = new TheaterDetailExtXml();
	String showId = request.getParameter("showId");
	ShowDetailVo show = extXmlsd.getXmlDataSAX(showId);
	String theaterId = show.getMt10id();
	TheaterDetailVo theater = extXmltd.getXmlDataSAX(theaterId);

	/* 페이징 */
	ArrayList<ReviewVo> list = (ArrayList<ReviewVo>) request.getAttribute("list");
	PageInfo pi = (PageInfo) request.getAttribute("pi");
	int listCount = pi.getTotalCount();
	int currentPage;
	if (null == request.getParameter("currentPage")) {
		currentPage = 1;
	} else {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>긴장감고조</title>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e8c4fb9a405e63f9eb58467ef526fb71&libraries=services"></script>
<style>
/*-------- showSub --------- */
/* -- */
#container {
	overflow: hidden;
	width: 1002px;
	margin: 0 auto;
}

#subContainer {
	width: 960px;
	margin: auto;
	padding-top: 35px;
	padding-left: 10px;
	height: auto;
	font-family: "나눔고딕", "NanumGothic", NanumGothicWeb, sans-serif;
	width: 960px;
}

.iconArea {
	padding: 4px 0 0;
	height: 23px;
	margin: 6px 0;
}

.wrapper {
	overflow: hidden;
	width: 960px;
}

}
/* -- */
#eventContents {
	margin-top: 3px;
	float: left;
	width: 100%;
}

#eventContents li {
	display: block;
	margin-bottom: 5px;
}

.detailCntExp {
	font-size: 13px;
	color: #999;
}

.detailCntName {
	color: #f79323;
	font-size: 16px;
}

.detailCntName b {
	color: #333;
	font-size: 20px;
	padding: 0 8px;
}

#detailMain {
	overflow: hidden;
	width: 960px;
	padding: 20px;
	border: solid 1px #c2c2c2;
}

#contentsLeft {
	overflow: hidden;
	width: 390px;
	float: left;
	width: 390px;
}

#contentsRight {
	overflow: hidden;
	float: left;
	width: 480px;
	padding: 0;
}

img.subDetailImg {
	width: 348px;
	height: 472px;
	border: solid 1px #c2c2c2;
	float: left;
	margin-bottom: 10px;
	z-index: -50;
}

#contentsDetailTB {
	margin-top: 10px;
}

#contentsDetailTB th {
	font-weight: bold;
	height: 28px;
	width: 65px;
}

#contentsDetailTB td {
	height: 28px;
	line-height: 16px;
	color: #666;
}

#contentsDetailTB td b {
	color: #fdb930;
}
/*-------- showSub --------- */
/*-------- 별점 --------- */
.star-input>.input, .star-input>.input>label:hover, .star-input>.input>input:focus+label,
	.star-input>.input>input:checked+label {
	display: inline-block;
	vertical-align: middle;
	background: url("/swp/images/one2.png") no-repeat;
}

.star-input {
	position: relative;
	top: -200px;
	display: inline-block;
	white-space: nowrap;
	width: 300px;
	height: 40px;
	padding: 25px;
	line-height: 30px;
	background: gray;
}

.star-input>.input {
	display: inline-block;
	width: 150px;
	background-size: 150px;
	height: 28px;
	white-space: nowrap;
	overflow: hidden;
	position: relative;
}

.star-input>.input>input {
	position: absolute;
	width: 1px;
	height: 1px;
	opacity: 0;
}

star-input>.input.focus {
	outline: 1px dotted #ddd;
}

.star-input>.input>label {
	width: 30px;
	height: 0;
	padding: 28px 0 0 0;
	overflow: hidden;
	float: left;
	cursor: pointer;
	position: absolute;
	top: 0;
	left: 0;
}

.star-input>.input>label:hover, .star-input>.input>input:focus+label,
	.star-input>.input>input:checked+label {
	background-size: 150px;
	background-position: 0 bottom;
}

.star-input>.input>label:hover ~label {
	background-image: none;
}

.star-input>.input>label[for="p1"] {
	width: 30px;
	z-index: 5;
}

.star-input>.input>label[for="p2"] {
	width: 60px;
	z-index: 4;
}

.star-input>.input>label[for="p3"] {
	width: 90px;
	z-index: 3;
}

.star-input>.input>label[for="p4"] {
	width: 120px;
	z-index: 2;
}

.star-input>.input>label[for="p5"] {
	width: 150px;
	z-index: 1;
}

.star-input>output {
	display: inline-block;
	width: 60px;
	font-size: 18px;
	text-align: right;
	vertical-align: middle;
}
/*-------- 별점 --------- */

/* 테이블 */
table.type09 {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
}

table.type09 thead th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #369;
	border-bottom: 3px solid #036;
}

table.type09 tbody th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #f3f6f7;
}

table.type09 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

.commentArea table {
	width: 60%;
	margin: 150px auto;
}

#sub_menu {
	background-color: #e5e5e5;
}

/* menubar */
.menuSub {
	display: inline;
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
	height: 48px;
}

.menuSub ul {
	overflow: hidden;
	width: 100%;
	margin: 0 auto;
	padding: 0px 0px 0px 0px;
	list-style: none;
	line-height: normal;
	text-align: center;
}

.menuSub li {
	overflow: hidden;
	width: 240px;
	float: left;
	padding: 0px;
}

.menuSub li a {
	background: #7C65B2;
	color: #cccccc;
	display: block;
	font-weight: normal;
	line-height: 50px;
	margin: 0px;
	padding: 0px 25px;
	text-align: center;
	text-decoration: none;
}

.menuSub li a:hover, .menuSub ul li:hover a {
	background: #5c4396;
	color: #FFFFFF;
	text-decoration: none;
	border-bottom: 5px solid lightgreen;
}

.menuSub li a.highlight {
	border-bottom: 5px solid lightgreen;
}

.menuSub li ul {
	background: #7C65B2;
	display: none; /* 평상시에는 드랍메뉴가 안보이게 하기 */
	height: auto;
	padding: 0px;
	margin: 0px;
	border: 0px;
	position: absolute;
	width: 228px;
	z-index: 200;
	/*top:1em;
/*left:0;*/
}

.menuSub li:hover ul {
	display: block; /* 마우스 커서 올리면 드랍메뉴 보이게 하기 */
}

.menuSub li li {
	background: #7C65B2;
	display: block;
	float: none;
	margin: 0px;
	padding: 0px;
	width: 228px;
}

.menuSub li:hover li a {
	background: none;
}

.menuSub li ul a {
	display: block;
	height: 50px;
	font-size: 12px;
	font-style: normal;
	margin: 0px;
	padding: 0px 10px 0px 15px;
	text-align: left;
}

.menuSub li ul a:hover, .menuSub li ul li:hover a {
	background: #5c4396;
	border: 0px;
	color: #ffffff;
	text-decoration: none;
}

.menuSub p {
	clear: left;
}

.menuSubArea {
	padding: 20px;
}

.subImage img {
	width: 960px;
	margin: 0 auto;
}

.reviewSection {
	
}

#reviewTable {
	width: 960px;
	width: 100%;
	border: 0;
	cellpadding: 0;
	cellspacing: 0;
	text-align: left;
}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<div class="wrap">
		<div id="container">
			<div id="detailMain">
				<div id="contentsLeft">
					<img src="<%=show.getPoster()%>" width=350 id="objImg"
						class="subDetailImg" />
					<div class="star-input" id="won">
						<span class="input"> <input type="radio" name="star-input"
							value="1" id="p1"> <label for="p1">1</label> <input
							type="radio" name="star-input" value="2" id="p2"> <label
							for="p2">2</label> <input type="radio" name="star-input"
							value="3" id="p3"> <label for="p3">3</label> <input
							type="radio" name="star-input" value="4" id="p4"> <label
							for="p4">4</label> <input type="radio" name="star-input"
							value="5" id="p5"> <label for="p5">5</label>
						</span>
						<output for="star-input">
							<b>0</b>점
						</output>
					</div>
				</div>

				<div id="contentsRight">
					<div class="iconArea"></div>
					<ul id="eventContents">
						<li class="detailCntName"><%=show.getGenrenm()%> <b><%=show.getPrfnm()%></b>
						</li>
						<li>
							<table border=0 cellpadding=0 cellspacing=0 id="contentsDetailTB">
								<tr>
									<th>장&nbsp;&nbsp;&nbsp;&nbsp;르 :</th>
									<td><%=show.getGenrenm()%></td>
								</tr>
								<tr>
									<th>공연시간 :</th>
									<td><%=show.getPrfruntime()%></td>
								</tr>
								<tr>
									<th>관람등급 :</th>
									<td><%=show.getPrfage()%></td>
								</tr>
								<tr>
									<th>공연장소 :</th>
									<td><%=show.getFcltynm()%></td>
								</tr>
								<tr>
									<th>공연기간 :</th>
									<td><%=show.getPrfpdfrom()%> - <%=show.getPrfpdto()%></td>
								</tr>
								<tr>
									<th>출&nbsp;&nbsp;&nbsp;&nbsp;연 :</th>
									<td><%=show.getPrfcast()%></td>
								</tr>
								<tr>
									<th>홈페이지 :</th>
									<td><a href="http://xn--6h5by1a/" target="new">http://없음</a></td>
								</tr>
							</table>
						</li>
					</ul>
				</div>
				<div class="menuSub">
					<ul>
						<li><a id="subImage" onclick="setSubMenu('subImage', this);">공연정보</a></li>
						<li><a id="showLocation" onclick="setSubMenu('showLocation', this);">공연장정보</a></li>
						<li><a onclick="setSubMenu('calendar', this);">캘린더</a></li>
						<li><a id="comment" onclick="setSubMenu('comment', this);">리뷰</a></li>
					</ul>
				</div>

				<div class="subImage menuSubArea">
					<%
						for (int i = 0; i < show.getStyurls().length; i++) {
					%>
					<img src="<%=show.getStyurls()[i]%>" alt="소개이미지" /><br>
					<%
						}
					%>
				</div>
				<div class="showLocation menuSubArea">
					<div id="map" style="width: 100%; height: 400px;"></div>
					<div id="map-description">
						<p>극장정보</p>
						<p>
							공연장 이름 :
							<%=theater.getFcltynm()%></p>
						<p>
							공연장 주소 :
							<%=theater.getAdres()%></p>
						<p>
							개관연도 :
							<%=theater.getOpende()%></p>
						<p>
							객석 수 :
							<%=theater.getSeatscale()%></p>
						<p>
							전화번호 :
							<%=theater.getTelno()%></p>
						<p>
							홈페이지 :
							<%=theater.getRelateurl()%></p>


					</div>
					<script>
						var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
						var options = { //지도를 생성할 때 필요한 기본 옵션
							center : new daum.maps.LatLng(
					<%=theater.getLa()%>
						,
					<%=theater.getLo()%>
						), //지도의 중심좌표.
							level : 3
						//지도의 레벨(확대, 축소 정도)
						};

						var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

						// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
						var zoomControl = new daum.maps.ZoomControl();
						map.addControl(zoomControl,
								daum.maps.ControlPosition.RIGHT);

						// 지도가 확대 또는 축소되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
						daum.maps.event.addListener(map, 'zoom_changed',
								function() {

									// 지도의 현재 레벨을 얻어옵니다
									var level = map.getLevel();

									var resultDiv = document
											.getElementById('result');
								});

						var markerPosition = new daum.maps.LatLng(
					<%=theater.getLa()%>
						,
					<%=theater.getLo()%>
						);

						// 마커를 생성합니다
						var marker = new daum.maps.Marker({
							position : markerPosition
						});

						// 마커가 지도 위에 표시되도록 설정합니다
						marker.setMap(map);

						// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
						// marker.setMap(null);
					</script>
				</div>

				<div class="calendar menuSubArea" >달력
					<div id="calendar">
					</div>				
				</div>
				<div class="comment menuSubArea">
					<div class="reviewSection">
						<table id="reviewTable">
							<tr>
								<th>별점</th>
								<th>내용</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
							<%
								if (list.size() == 0) {
							%>
							<tr>
								<td colspan="5">이 공연에 리뷰가 없습니다.</td>
							</tr>
							<%
								} else {
							%>
							<%
								for (ReviewVo n : list) {
							%>
							<tr>
								<td>
									<%%>
								</td>
								<td><%=n.getContent()%></td>
								<td><%=n.getMemberId()%></td>
								<td><%=n.getReviewDate()%></td>
							</tr>
							<%
								}
								}
							%>
						</table>

					</div>

				</div>

			</div>
		</div>
	</div>
	<%@ include file="/views/common/footer.jsp"%>
</body>

<script src="/swp/js/star.js"></script>
<script>
	$(function() {
		//$("#won").hide();
		$("#objImg").hover(function() {
			$("#won").show();
		}, function() {
			$("#won").hide();
		});

		$("#won").hover(function(event) {
			$("#won").show();
			event.stopPropagation();
		}, function() {
			$("#won").hide();
		});

		//setSubMenu('subImage');
		$(".menuSubArea").hide(); //원 로직
	});

	function setSubMenu(area, obj) {
		sessionStorage.setItem('subMenu', area);
		console.log(sessionStorage.getItem('subMenu'));
		$(".menuSubArea").hide();
		$("." + area).show();
		$(".menuSub a").removeClass("highlight");
		$(obj).toggleClass("highlight");
	}

	function movePage(pageNum) {
		location.href = "/swp/reviewList.do?showId=" + showId + "currentPage="
				+ pageNum;
	}
	
	$(function() {
		subMenuName = sessionStorage.getItem('subMenu');
		console.log(subMenuName);
		if (subMenuName != null) {
			$("." + subMenuName).show();
			$(".menuSub a").removeClass("highlight");
			$("#subMenuName").toggleClass("highlight");
		}
	});
	
	
</script>
</html>