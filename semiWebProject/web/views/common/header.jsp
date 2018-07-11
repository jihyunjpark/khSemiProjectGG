<%@page import="member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		MemberVo member = (MemberVo) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/swp/slick/slick-theme.css">
<link rel="stylesheet" type="text/css" href="/swp/slick/slick.css">
<link rel="stylesheet" href="http://icono-49d6.kxcdn.com/icono.min.css">
<link rel="stylesheet" type="text/css" href="/swp/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Rubik" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Song+Myung" rel="stylesheet">
<!-- (1) LoginWithNaverId Javscript SDK -->
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>
<script src="http://thecodeplayer.com/uploads/js/prefixfree-1.0.7.js"
	type="text/javascript" type="text/javascript"></script>
<script type="text/javascript" src="/swp/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=MiE7za1q2r2x8mnXzzsu&submodules=geocoder"></script>
<script>
function logout(){
	location.href = "/swp/userLogout.do";		
}
<% if(null != session.getAttribute("user")){%>
$(function() {
$("#top-Login").attr("href", "#");
$("#top-Login").attr("onclick", "logout();");
});
<%}	%>



	/* jQuery timeㄴ */
	var subMenuName = null;

	var naverLogin = new naver.LoginWithNaverId({
		clientId : "{MiE7za1q2r2x8mnXzzsu}",
		callbackUrl : "http://localhost:8081/swp/index.jsp",
		isPopup : false,
		callbackHandle : false
	});

	naverLogin.init();

	naverLogin.getLoginStatus(function(status) {
		if (status) {
			var email = naverLogin.user.getEmail();
			var name = naverLogin.user.getNickName();
			var profileImage = naverLogin.user.getProfileImage();
			var birthday = naverLogin.user.getBirthday();
			var uniqId = naverLogin.user.getId();
			var age = naverLogin.user.getAge();
		} else {
			console.log("AccessToken이 올바르지 않습니다.");
		}
	});

	/* (5) 현재 로그인 상태를 확인 */
	window.addEventListener('load', function() {
		naverLogin.getLoginStatus(function(status) {
			if (status) {
				/* (6) 로그인 상태가 "true" 인 경우 로그인 버튼을 없애고 사용자 정보를 출력합니다. */
				setLoginStatus();
			}
		});
	});

	/* (6) 로그인 상태가 "true" 인 경우 로그인 버튼을 없애고 사용자 정보를 출력합니다. */
	function setLoginStatus() {
		var profileImage = naverLogin.user.getProfileImage();
		var nickName = naverLogin.user.getNickName();
		$("#top-Login").html("로그아웃");
		$("#top-Login").attr("href", "#");
		/* (7) 로그아웃 버튼을 설정하고 동작을 정의합니다. */
		$("#top-Login").click(function() {
			naverLogin.logout();
			location.reload();
		});
	}

	function confirmEmail() {
		naverLogin.getLoginStatus(function(status) {
			if (status) {
				var email = naverLogin.user.getEmail();
				console.log(naverLogin);
			} else {
				console.log("AccessToken이 올바르지 않습니다.");
			}
		});
	}

	$(function() {
		$("#accordian h3").click(function() {
			console.log('test');
			$("#accordian ul ul").slideUp();
			if (!$(this).next().is(":visible")) {
				$(this).next().slideDown();
			}
		})

		var menuName = sessionStorage.getItem('menu');
		console.log(menuName);
		if (menuName == null || menuName == 'home') {
			$("#accordian").hide();
		} else if (menuName != null && menuName != 'home') {
			$("#" + menuName + "Menu").click();
		}
	})

	function setLeftMenu(menu) {
		sessionStorage.setItem('menu', menu);
	}

	$(document).ready(function() {

		// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
		var floatPosition = parseInt($("#floatMenu").css('top'));
		// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

		$(window).scroll(function() {
			// 현재 스크롤 위치를 가져온다.
			var scrollTop = $(window).scrollTop();
			var newPosition = scrollTop + floatPosition + "px";

			/* 애니메이션 없이 바로 따라감
			 $("#floatMenu").css('top', newPosition);
			 */

			$("#floatMenu").stop().animate({}, 300);

		}).scroll();

	});
	
	$(function(){
		if(sessionStorage.getItem("floatImg") != null){
			$("#floatLink").attr("href", sessionStorage.getItem("floatLink"));
			$("#floatImg").attr("src", sessionStorage.getItem("floatImg"));
			$("#floatTitle").text(sessionStorage.getItem("floatTitle"));
		}
	});
</script>

</head>

<body>
	<button onclick="confirmEmail();">정보확인-네이버</button>
	<div class="header">
		<header id="header" class="">
			<div id="top-menu">
				<div id="top-menu-right">
					<a
						href="<%=request.getContextPath() + "/views/common/loginPage.html"%>"
						id="top-Login">로그인/로그아웃</a><span class="al_bar"></span> <a
						href="<%=request.getContextPath() + "/views/common/myPage.jsp"%>"
						id="top-profile">마이페이지</a><span class="al_bar"></span> <a
						href="<%=request.getContextPath() + "/views/service.jsp"%>"
						id="top-service">고객센터</a>
				</div>
			</div>
		</header>
		<br>
		<div class="search_area">
			<div id="logo_image" >
				<a href="<%=request.getContextPath()%>/index.jsp"><img src="/swp/images/logo.png" width="80px" height="80px"></img></a>
			</div>
			<form id="search_form" name="search" action="/swp/views/common/showSearch.jsp"  method="get"
				role="search">
				<fieldset class="greenwindow">
					<legend>검색</legend>
					<div class="greenbox">
						<span class="keyword"> <input type="text" id="nquery"
							name="query" class="box_window" maxlength="255" title="검색어 입력">
						</span>
					</div>
					<button type="submit" class="bt_search">
						<span class="spnew ico_search">검색</span> <span
							class="ico_search_submit"></span>
					</button>
				</fieldset>
			</form>
		</div>

		<div class="menubar">
			<ul>
				<li><a href="<%=request.getContextPath()%>/index.jsp" onclick="setLeftMenu('home');">Home</a></li>
				<li><a
					href="http://localhost:8081/swp/views/board/show/showMain.jsp"
					id="current" onclick="setLeftMenu('show');">공연</a>
					<ul>
						<li><a
							href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=AAAA"
							onclick="setLeftMenu('show');">연극</a></li>
						<li><a
							href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=AAAB"
							onclick="setLeftMenu('show');">뮤지컬</a></li>
						<li><a
							href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=CCCA"
							onclick="setLeftMenu('show');">클래식</a></li>
						<li><a
							href="http://localhost:8081/swp/views/board/theater/theaterList.jsp"
							onclick="setLeftMenu('show');">극장 목록</a></li>
					</ul></li>
				<li><a href="/swp/freeList.do"
					onclick="setLeftMenu('community');">커뮤니티</a>
					<ul>
						<li><a href="/swp/freeList.do"
							onclick="setLeftMenu('community');">자유게시판</a></li>
						<li><a href="/swp/noticeList.do"
							onclick="setLeftMenu('community');">공지사항</a></li>
						<!-- <li><a href="/swp/totalReviewList.do"
							onclick="setLeftMenu('community');">리뷰 게시판</a></li> -->
					</ul></li>
				<li><a href="/swp/magazineList.do"
					onclick="setLeftMenu('magazine');">매거진</a>
					<ul>
						<li><a href="/swp/magazineList.do" onclick="/swp/magazineList.do">매거진</a></li>
					</ul></li>
				<li><a href="/swp/faqList.do"
					onclick="setLeftMenu('question');">문의</a>
					<ul>
						<!-- <li><a href="#" onclick="setLeftMenu('question');">문의게시판</a></li> -->
						<li><a href="/swp/faqList.do"
							onclick="setLeftMenu('question');">FAQ</a></li>
					</ul></li>
			</ul>
		</div>
		<br>

	</div>
	<br>
	</div>
	<div id="left-header">
		<!-- 사이드메뉴 -->
		<div id="accordian">
			<ul>
				<li class="active">
					<h3 id="homeMenu">
						<span class="icon-dashboard"></span><a href="<%=request.getContextPath()%>/index.jsp"
							onclick="setLeftMenu('home');">HOME</a>
					</h3>
				</li>
				<!-- we will keep this LI open by default -->
				<li>
					<h3 id="showMenu">
						<span class="icon-tasks"></span><a
							href="http://localhost:8081/swp/views/board/show/showMain.jsp"
							id="current" onclick="setLeftMenu('show');">공연</a>
					</h3>
					<ul>
						<li><a
							href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=AAAA"
							onclick="setLeftMenu('show');">연극</a></li>
						<li><a
							href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=AAAB"
							onclick="setLeftMenu('show');">뮤지컬</a></li>
						<li><a
							href="http://localhost:8081/swp/views/board/show/showMain.jsp?category=CCCA"
							onclick="setLeftMenu('show');">클래식</a></li>
						<li><a
							href="http://localhost:8081/swp/views/board/theater/theaterList.jsp"
							onclick="setLeftMenu('show');">극장 목록</a></li>
					</ul>
				</li>
				<li>
					<h3 id="communityMenu">
						<span class="icon-calendar"></span>커뮤니티
					</h3>
					<ul>
						<li><a href="#">자유 게시판</a></li>
						<li><a href="#">공지사항</a></li>
						<!-- <li><a href="#">리뷰 게시판</a></li> -->
					</ul>
				</li>
				<li>
					<h3 id="magazineMenu">
						<span class="icon-heart"></span>매거진
					</h3>
					<ul>
						<li><a href="/swp/magazineList.do">매거진</a></li>
					</ul>
				</li>
				<li>
					<h3 id="questionMenu">
						<span class="icon-heart"></span>문의
					</h3>
					<ul>
						<li><a href="/swp/faqList.do">FAQ</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<div id="right-header">
		<div id="floatparent">
			<div id="floatMenu">
			<div id="floatp">최근 본 공연</div>
				<a id="floatLink"> <img id="floatImg" width="100"
					height="100" /> <div id="floatTitle"></div>
				</a>
			</div>
		</div>
	</div>
</body>
</html>