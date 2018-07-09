<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>






</style>
</head>
<body>
	<div class="rankings">
		<div class="rankingTitle">
			<a href="/Contents/Ranking"></a>
			<ul class="rankingTab">
				<li class="selected"><a href="javascript:;"
					onclick="rankingTabClick('01011', j$(this));">뮤지컬</a></li>
				<li class=""><a href="javascript:;"
					onclick="rankingTabClick('01003', j$(this));">콘서트</a></li>
				<li class=""><a href="javascript:;"
					onclick="rankingTabClick('01009', j$(this));">연극</a></li>
				<li class="type2"><a href="javascript:;"
					onclick="rankingTabClick('C', j$(this));">클래식/무용</a></li>
				<li class="type2"><a href="javascript:;"
					onclick="rankingTabClick('01007', j$(this));">스포츠/레저</a></li>
				<li class="type3"><a href="javascript:;"
					onclick="rankingTabClick('01008', j$(this));">전시/행사</a></li>
				<li class="type3"><a href="javascript:;"
					onclick="rankingTabClick('F', j$(this));">아동/가족</a></li>
			</ul>
			<a href="/Contents/Ranking" class="rankMore"><img
				src="http://ticketimage.interpark.com/TicketImage/2015/20150429_main/img/rankingMore.gif"
				alt=""></a>
		</div>
		<div class="rankingBody">
			<div class="rankingContentWrap">
				<div class="rankingContent" id="target_ranking1">
					<div class="rankingContentTitle">
						라이선스/내한 뮤지컬<a
							href="http://ticket.interpark.com/contents/Ranking/RankList?pKind=01011&amp;pCate=RK312&amp;pType=D"
							class="contentMore">더보기</a>
					</div>
					<ul>
						<li><span class="rankingNum num1"></span> <a
							href="http://ticket.interpark.com/Ticket/Goods/GoodsInfo.asp?GoodsCode=18004552"
							class="prdImg"><img
								src="http://ticketimage.interpark.com/rz/image/play/goods/poster/18/18004552_p_s.jpg"
								onerror="this.src=&quot;http://ticketimage.interpark.com/Play/image/large/NoImage.gif&quot;"
								alt=""></a> <a
							href="http://ticket.interpark.com/Ticket/Goods/GoodsInfo.asp?GoodsCode=18004552"
							class="prdName">
								<div class="prdTxt">뮤지컬 노트르담 드 파리 - 한국어버전 10주년</div>
								<div class="prdMove">&nbsp;</div>
						</a></li>
					</ul>
				</div>
				<div class="rankingContent" id="target_ranking3"></div>
			</div>
		</div>
	</div>

</body>
</html>