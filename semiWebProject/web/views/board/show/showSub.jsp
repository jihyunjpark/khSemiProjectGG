<%@page import="board.show.model.vo.ShowVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ShowVo show = (ShowVo) request.getAttribute("show");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>긴장감고조아묵너ㅏ</title>

<style>
/*-------- showSub --------- */
/* -- */
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
	width: 870px; /*width:930px; height:563px*/
	padding: 29px;
	border: solid 1px #c2c2c2;
	overflow: hidden;
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
	width: 1140px;
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
	width: 228px;
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
</style>


</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<div class="wrap">
		<div id="container">
			<div id="detailMain">
				<div id="contentsLeft">
					<img src="/swp/resource/upload/<%=show.getShow_image()%>" width=350
						id="objImg" class="subDetailImg" />
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
						<li class="detailCntName">
							<%
								if (show.getCategory().equals("Y")) {
							%> &lt연극&gt <%
 	} else {
 %> &lt뮤지컬&gt <%
 	}
 %> <b><%=show.getShow_name()%></b>
						</li>
						<li>
							<table border=0 cellpadding=0 cellspacing=0 id="contentsDetailTB">
								<tr>
									<th>장&nbsp;&nbsp;&nbsp;&nbsp;르 :</th>
									<td><%=show.getGenre()%></td>
								</tr>
								<tr>
									<th>공연시간 :</th>
									<td><%=show.getShow_runtime()%>분</td>
								</tr>
								<tr>
									<th>관람등급 :</th>
									<td><%=show.getShow_grade()%>세이상</td>
								</tr>
								<tr>
									<th>공연장소 :</th>
									<td><%=show.getLocation()%></td>
								</tr>
								<tr>
									<th>공연기간 :</th>
									<td><%=show.getPeriod()%></td>
								</tr>
								<tr>
									<th>출&nbsp;&nbsp;&nbsp;&nbsp;연 :</th>
									<td><%=show.getGuest()%></td>
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
						<li><a onclick="setSubMenu('subImage');">공연정보</a></li>
						<li><a onclick="setSubMenu('showLocation');">공연장정보</a></li>
						<li><a onclick="setSubMenu('calendar');">캘린더</a></li>
						<li><a onclick="setSubMenu('comment');">리뷰</a></li>
					</ul>
				</div>

				<div class="subImage menuSubArea">
					<%
						String[] subs = show.getSub_image().split(",");
						for (String name : subs) {
					%>
					<img src="/swp/resource/upload/<%=name%>" alt="<%=name%>" />
					<%
						}
					%>
				</div>
				<div class="showLocation menuSubArea">
					<div id="map" style="width: 100%; height: 400px;"></div>
					<div id="map-description">
					극장설명<%=request.getParameter("showCode")%>
					
					</div>
					<script>
						var map = new naver.maps.Map('map');
						var myaddress = '불정로 6';// 도로명 주소나 지번 주소만 가능 (건물명 불가!!!!)
						naver.maps.Service
								.geocode(
										{
											address : myaddress
										},
										function(status, response) {
											if (status !== naver.maps.Service.Status.OK) {
												return alert(myaddress
														+ '의 검색 결과가 없거나 기타 네트워크 에러');
											}
											var result = response.result;
											// 검색 결과 갯수: result.total
											// 첫번째 결과 결과 주소: result.items[0].address
											// 첫번째 검색 결과 좌표: result.items[0].point.y, result.items[0].point.x
											var myaddr = new naver.maps.Point(
													result.items[0].point.x,
													result.items[0].point.y);
											map.setCenter(myaddr); // 검색된 좌표로 지도 이동
											// 마커 표시
											var marker = new naver.maps.Marker(
													{
														position : myaddr,
														map : map
													});
											// 마커 클릭 이벤트 처리
											naver.maps.Event
													.addListener(
															marker,
															"click",
															function(e) {
																if (infowindow
																		.getMap()) {
																	infowindow
																			.close();
																} else {
																	infowindow
																			.open(
																					map,
																					marker);
																}
															});
											// 마크 클릭시 인포윈도우 오픈
											var infowindow = new naver.maps.InfoWindow(
													{
														content : '<h4> [네이버 개발자센터]</h4><a href="https://developers.naver.com" target="_blank"><img src="https://developers.naver.com/inc/devcenter/images/nd_img.png"></a>'
													});
										});
					</script>
				</div>

				<div class="calendar menuSubArea">달력</div>
				<div class="comment menuSubArea">
					<div class="commentArea">
						<table class="type09">
							<thead>
								<tr>
									<th scope="cols">평점</th>
									<th scope="cols">내용</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row">평점1</th>
									<td>내용</td>
								</tr>
								<tr>
									<th scope="row">평점</th>
									<td>내용</td>
								</tr>
								<tr>
									<th scope="row">평점</th>
									<td>내용</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>



			</div>
		</div>
	</div>
	<div></div>
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

	function setSubMenu(area) {
		$(".menuSubArea").hide();
		$("." + area).show();
	}
</script>
</html>