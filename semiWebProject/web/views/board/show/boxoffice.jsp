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

body, input, textarea, select, button, table {
	font-family: 'y740', Nanum Gothic, dotum, sans-serif;
	font-size: 12px;
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

.poster_rank {
	position: relative;
	float: left;
	width: 1200px;
	height: 879px;
	background: #fff;
	margin-bottom: 45px;
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




</head>
<body>

	<div class="poster_rank">
		<div class="title">
			<h1>
				박스오피스<span id="genreTitle"> - 연극</span>
			</h1>
			<p>
				<span class="d1Dt">2018.07.02 ~ 2018.07.08</span><span class="text">
					기준</span>
			</p>
		</div>
		<div class="main_wrap">
			<form name="boxoffice" method="post">
				<input type="hidden" name="genre" id="genre" value="Theatre">
				<input type="hidden" name="specificGubun" id="specificGubun"
					value="">
				<div class="main_menu1">
					<select id="period" name="period" title="기간">
						<option value="daily">일간</option>
						<option value="weekly" selected="">주간</option>
						<option value="monthly">월간</option>
					</select>
				</div>
				<div class="main_menu2">
					<p>
						<a href="#none" class="m01 m01_on" id="Theatre"><span
							class="text_none">연극</span></a>
					</p>
					<p>
						<a href="#none" class="m02" id="Musical"><span
							class="text_none">뮤지컬</span></a>
					</p>
					<p>
						<a href="#none" class="m03" id="Classic"><span
							class="text_none">클래식/오페라</span></a>
					</p>
					<p>
						<a href="#none" class="m04" id="Dance"><span class="text_none">무용</span></a>
					</p>
					<p class="back_none">
						<a href="#none" class="m05" id="Gukak"><span class="text_none">국악/복합</span></a>
					</p>
				</div>
				<div class="main_menu3">
					<p>
						<a href="#none" class="m06" id="kid"><span class="text_none">아동</span></a>
					</p>
					<p>
						<a href="#none" class="m07" id="varsity"><span
							class="text_none">대학로</span></a>
					</p>
					<p class="back_none2">
						<a href="#none" class="m08" id="openRun"><span
							class="text_none">오픈런</span></a>
					</p>
				</div>
			</form>
		</div>

		<ul class="boxOfficePoster">
			<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>	
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
					v
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
					<li><a href=""><div class="poster">
						<span class="num"><img src="/images/main/poster_rank_1.png"
							alt="1"></span><span class="poster_img"><img
							src="/upload/pfmPoster/PF_PF143281_180615_095319.gif"
							alt="러브 스코어"></span>
					</div>
					<div class="poster_hover" style="display: none; opacity: 1;">
						<dl>
							<dt style="margin-bottom: 30px">러브 스코어</dt>
							<dt>18.06.29 ~ 18.10.14</dt>
							<dt>상명아트홀</dt>
						</dl>
					</div></a></li>
		</ul>

		<div class="icon_wrap">
			<p>
				<img src="/images/main/m_icon01.png" alt="공연DB icon"> <span>공연DB</span>
				<span class="num_color">17,042</span><span>건</span>
			</p>
			<p>
				<img src="/images/main/m_icon02.png" alt="공연시설DB icon"> <span>공연시설DB</span>
				<span class="num_color">1,132</span><span>건</span>
			</p>
			<p class="back_none2">
				<img src="/images/main/m_icon03.png" alt="기획·제작사DB icon"> <span>기획·제작사DB</span>
				<span class="num_color">4,124</span><span>건</span>
			</p>
		</div>

	</div>


</body>
</html>