<%@page import="board.show.model.vo.BoxofficeShowVo"%>
<%@page import="java.util.List"%>
<%@page import="board.show.controller.BoxofficeListExtXml"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
    width: 1200px;
    margin: 0 auto;
    background-color: #f5f5f5;
    color: #666;
}

body, input, textarea, select, button, table {
	font-family: Nanum Gothic, dotum, sans-serif;
	font-size: 12px;
}

.bold, h1, h2, strong, b {
    font-weight: bold;
}

ul, menu, dir {
	display: block;
	list-style-type: disc;
	-webkit-margin-before: 1em;
	-webkit-margin-after: 1em;
	-webkit-margin-start: 0px;
	-webkit-margin-end: 0px;
	-webkit-padding-start: 40px;
}

.bold, h1, h2, strong, b {
	font-weight: bold;
}

h1 {
	display: block;
	font-size: 2em;
	-webkit-margin-before: 0.67em;
	-webkit-margin-after: 0.67em;
	-webkit-margin-start: 0px;
	-webkit-margin-end: 0px;
	font-weight: bold;
}

.main_wrap {
    overflow: hidden;
    border-top: 1px solid #bbc5db;
    border-bottom: 1px solid #bbc5db;
    margin: 0 32px 20px 32px;
}

.main_menu1 {
    float: left;
    margin-right: 12px;
    padding: 14px 12px 14px 0;
    background: url(/swp/images/main/mline_dot.gif) repeat-y right top;
}

.main_menu1 select {
    width: 198px;
    border: 1px solid #c9c9c9;
    font-size: 15px;
    height: 35px;
}

option {
    font-weight: normal;
    display: block;
    white-space: pre;
    min-height: 1.2em;
    padding: 0px 2px 1px;
}

.main_menu2 {
    float: left;
    overflow: hidden;
    padding: 10px 0;
    background: url(/swp/images/main/mline_dot.gif) repeat-y right top;
}

.main_menu2 p {
    float: left;
    background: url(/swp/images/main/mlist_dot.gif) no-repeat right 50%;
    padding-right: 12px;
    margin-right: 9px;
}

.main_menu3 {
    float: left;
    overflow: hidden;
    padding: 10px 12px 10px 12px;
}

.main_menu3 p {
    float: left;
    background: url(/swp/images/main/mline_dot.gif) no-repeat right 50%;
    padding-right: 12px;
    margin-right: 9px;
}

.back_none {
    background: none!important;
    margin-right: 0px!important;
}


.m01 {
    background: url(/swp/images/main/m01_off.jpg) no-repeat;
    width: 77px;
    height: 42px;
    display: inline-block;
}
.m01_on {
    background: url(/swp/images/main/m01_on.jpg) no-repeat;
    width: 77px;
    height: 42px;
    display: inline-block;
}
.m01:hover {
    background: url(/swp/images/main/m01_on.jpg) no-repeat;
    width: 77px;
    height: 42px;
    display: inline-block;
}

.m02 {
    background: url(/swp/images/main/m02_off.jpg) no-repeat;
    width: 86px;
    height: 42px;
    display: inline-block;
}

.m02_on {
    background: url(/swp/images/main/m02_on.jpg) no-repeat;
    width: 86px;
    height: 42px;
    display: inline-block;
}
.m02:hover {
    background: url(/swp/images/main/m02_on.jpg) no-repeat;
    width: 86px;
    height: 42px;
    display: inline-block;
}

.m03 {
    background: url(/swp/images/main/m03_off.jpg) no-repeat;
    width: 122px;
    height: 42px;
    display: inline-block;
}
.m03:hover {
    background: url(/swp/images/main/m03_on.jpg) no-repeat;
    width: 122px;
    height: 42px;
    display: inline-block;
}

.m03_on {
    background: url(/swp/images/main/m03_on.jpg) no-repeat;
    width: 122px;
    height: 42px;
    display: inline-block;
}

.m04 {
    background: url(/swp/images/main/m04_off.jpg) no-repeat;
    width: 75px;
    height: 42px;
    display: inline-block;
}
.m04:hover {
    background: url(/swp/images/main/m04_on.jpg) no-repeat;
    width: 75px;
    height: 42px;
    display: inline-block;
}

.m04_on{
    background: url(/swp/images/main/m04_on.jpg) no-repeat;
    width: 75px;
    height: 42px;
    display: inline-block;
}

.m05 {
    background: url(/swp/images/main/m05_off.jpg) no-repeat;
    width: 104px;
    height: 42px;
    display: inline-block;
}
.m05:hover {
    background: url(/swp/images/main/m05_on.jpg) no-repeat;
    width: 104px;
    height: 42px;
    display: inline-block;
}

.m05_on {
    background: url(/swp/images/main/m05_on.jpg) no-repeat;
    width: 104px;
    height: 42px;
    display: inline-block;
}


.m06 {
    background: url(/swp/images/main/m06_off.jpg) no-repeat;
    width: 78px;
    height: 42px;
    display: inline-block;
}
.m06:hover {
    background: url(/swp/images/main/m06_on.jpg) no-repeat;
    width: 78px;
    height: 42px;
    display: inline-block;
}

.m06_on {
    background: url(/swp/images/main/m06_on.jpg) no-repeat;
    width: 78px;
    height: 42px;
    display: inline-block;
}

.m07 {
    background: url(/swp/images/main/m07_off.jpg) no-repeat;
    width: 84px;
    height: 42px;
    display: inline-block;
}
.m07:hover {
    background: url(/swp/images/main/m07_on.jpg) no-repeat;
    width: 84px;
    height: 42px;
    display: inline-block;
}

.m07_on {
    background: url(/swp/images/main/m07_on.jpg) no-repeat;
    width: 84px;
    height: 42px;
    display: inline-block;
}

.m08 {
    background: url(/swp/images/main/m08_off.jpg) no-repeat;
    width: 95px;
    height: 42px;
    display: inline-block;
}
.m08:hover {
    background: url(/swp/images/main/m08_on.jpg) no-repeat;
    width: 95px;
    height: 42px;
    display: inline-block;
}

.m08_on {
    background: url(/swp/images/main/m08_on.jpg) no-repeat;
    width: 95px;
    height: 42px;
    display: inline-block;
}

a, a:hover {
    text-decoration: none;
    color: #000;
}

.boxOfficePoster{
padding: 0px;

}

.text_none {
    display: none;
}


.poster_rank {
	position: relative;
	float: left;
	width: 1200px;
	height: 879px;
	background: #fff;
	margin-bottom: 45px;
	border: 1px solid #e9e9e9;
	margin-top: 20px;
}

.poster_rank .title {
	padding: 40px 48px 16px 48px;
	line-height: 24px;
	color: #000;
}

#visual {
	position: relative;
	height: 486px;
	margin-top: 30px;
	border: 1px solid #e9e9e9;
	color: #fff;
	box-sizing: border-box;
}

.poster_rank .title h1 span {
	font-size: 15px;
}

.poster_rank .title p {
	position: absolute;
	top: 47px;
	right: 42px;
}

.poster_rank .title p span {
	font-size: 15px;
	font-family: Nanum Gothic;
	font-weight: 800;
}

.poster_rank .title p .text {
	font-size: 14px;
	font-weight: normal;
}

.poster_rank ul {
	width: 100%;
	margin: 0 auto;
}

ul, ol {
	list-style-type: none;
}

a, a:hover {
	text-decoration: none;
	color: #000;
}

.poster_rank ul li {
	position: relative;
	float: left;
	width: 20%;
	margin-bottom: 142px;
	margin-left: -12px;
	text-align: center;
}

.poster_rank ul li a {
	display: block;
	width: 120px;
	height: 169px;
	margin: 0 auto;
}

.poster_rank .poster {
	position: relative;
	height: 100%;
}

.poster_rank .poster .num {
	position: absolute;
	left: 0;
}

img {
	max-width: 100%;
}

img, fieldset {
	border: none;
}

.poster_rank .poster .poster_img {
	display: block;
	width: 198px;
	height: 277px;
	background: #5288AE;
	line-height: 183px;
	color: #fff;
}

.poster_rank .poster .poster_img img {
	width: 100%;
	height: 100%;
	border: 1px solid #cccccc;
	box-sizing: border-box;
}

</style>

<script>
var ccategory = "AAAA";
var cid = "Theatre";
var ctype = "week";

$(function() {
	$("#period").change(function() {
		ctype = $("#period").val();
		selectGenre(ccategory, cid);
		console.log(ccategory);
		console.log(cid);
		
	});
});

function selectGenre(category, id){
	console.log(id);	
	

	for(var idx=1; idx < 9; idx++) {
		$('.m0' + idx + '_on').removeClass('m0' + idx + '_on');
		//console.log('m0' + idx + '_on');
	}
	
	if(id == "Theatre"){
		$("#Theatre").addClass("m01_on");
		$("#genreTitle").text(" - 연극");
		$("#genre").val(id);
		$("#specificGubun").val("");
	}else if(id == "Musical"){
		$("#Musical").addClass("m02_on");
		$("#genreTitle").text(" - 뮤지컬");
		$("#genre").val(id);
		$("#specificGubun").val("");
	}else if(id == "Classic"){
		$("#Classic").addClass("m03_on");
		$("#genreTitle").text(" - 클래식/오페라");
		$("#genre").val(id);
		$("#specificGubun").val("");
	}else if(id == "Dance"){
		$("#Dance").addClass("m04_on");
		$("#genreTitle").text(" - 무용");
		$("#genre").val(id);
		$("#specificGubun").val("");
	}else if(id == "Gukak"){
		$("#Gukak").addClass("m05_on");
		$("#genreTitle").text(" - 국악/복합");
		$("#genre").val(id);
		$("#specificGubun").val("");
	}else if(id == "kid"){
		$("#kid").addClass("m06_on");
		$("#genreTitle").text(" - 아동");
		$("#genre").val("");
		$("#specificGubun").val(id);
	}else if(id == "varsity"){
		$("#varsity").addClass("m07_on");
		$("#genreTitle").text(" - 대학로");
		$("#genre").val("");
		$("#specificGubun").val(id);
	}else if(id == "openRun"){
		$("#openRun").addClass("m08_on");
		$("#genreTitle").text(" - 오픈런");
		$("#genre").val("");
		$("#specificGubun").val(id);
	}
		//$(obj).addClass('m0' + num + '_on');
	/* m01 m01_on */
	$.ajax({
		url:"/swp/boxofficeAjax.do?category=" + category + "&type=" + ctype,
		type:"get",
		success: function(data) {
			console.log(data.length);
			var resultStr = "";
			console.log(0 < data.length);
			if(0 < data.length){
			for(var i=0; i < 10; i++){
				resultStr += "<li><a href='/swp/reviewList.do?showId=" + data[i].mt20id +"'><div class='poster'>";
				resultStr += "<span class='num'><img src='/swp/images/main/poster_rank_" + (i+1) + ".png'";
				resultStr += "alt='" + data[i].rnum + "'></span><span class='poster_img'><img ";
				resultStr += "src='" + data[i].poster + "'";
				resultStr += "alt='" + data[i].prfnm + "'></span>";
				resultStr += "</div>";
				resultStr += "<div class='poster_hover' style='display: none; opacity: 1;'>"
					resultStr += "<dl>";
					resultStr += "<dt style='margin-bottom: 30px'>" + data[i].prfnm + "</dt>";
					resultStr += "<dt>" + data[i].mt20id + "</dt>";
					resultStr += "<dt>" + data[i].prfplcnm + "</dt>";
					resultStr += "</dl>";
					resultStr += "</div></a></li>";
			}
			} else {
				resultStr += "<li style='width:100%; height:100%; color:#000; margin:0; text-align:center; line-height:400px;'>" +
				"등록된 공연이 없습니다."+	                    		
				"</li>";
			}
				cid = id;
				ccategory = category;
				$(".boxOfficePoster").html(resultStr);
			
		}, error:function(e) {
			console.log(e);
		} 
		
	});
}




selectGenre(ccategory, cid);
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
					<p><a href="#none" class="m01 m01_on" id="Theatre" onclick="selectGenre('AAAA', this.id);"><span class="text_none">연극</span></a></p>
					<p><a href="#none" class="m02" id="Musical" onclick="selectGenre('AAAB', this.id);"><span class="text_none">뮤지컬</span></a></p>
					<p><a href="#none" class="m03" id="Classic" onclick="selectGenre('CCCA', this.id);"><span class="text_none">클래식/오페라</span></a></p>
					<p><a href="#none" class="m04" id="Dance" onclick="selectGenre('BBBA', this.id);"><span class="text_none">무용</span></a></p>
					<p class="back_none"><a href="#none" class="m05" id="Gukak" onclick="selectGenre('CCCC', this.id);"><span class="text_none">국악/복합</span></a></p>
					
				</div>
				<div class="main_menu3">
					<p><a href="#none" class="m06" id="kid" onclick="selectGenre('KID', this.id);"><span class="text_none">아동</span></a></p>
					<p><a href="#none" class="m07" id="varsity" onclick="selectGenre('', this.id);"><span class="text_none">대학로</span></a></p>
					<p class="back_none2"><a href="#none" class="m08" id="openRun" onclick="selectGenre('OPEN', this.id);"><span class="text_none">오픈런</span></a></p>
				</div>
			</form>
			</div>

		<ul class="boxOfficePoster">
		<%-- <%for(int i = 0; i < 10; i++){%> 
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
					<%} %> --%>
					
		</ul>

	</div>


</body>
</html>