<!-- 미사용################################################################################################################################################################################################################################################################## -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp"%>





	<div class="section">
		<table width="100%" border=0 cellpadding=0 cellspacing=0>
			<tr>
				<td valign=top width="33.3333333333%">
					<table border="0" cellpadding="0" cellspacing="0" id="subList">
						<tr>
							<td valign=top><a target="_self" href="showSub.jsp"
								id="listImgA"><!-- <img>공연포스터 --></a></td>
							<td class="subListText">
								<ul>
									<li class="ltShowKind"><!-- txt장르 --></li>
									<li class="ltShowName"><!-- <a>공연디테일 --><!-- txt제목 --></a></li>
									<li class="ltShowDetail"><!-- txt코멘트 --></li>
									<li class="ltShowPlace"><!-- txt극장 --></li>
									<li class="ltdate"><!-- txt기간 --></li>

									<li class="ltShowStar">
										<!-- <img>별이미지 1~5 -->
										<p class='listReview'>
											리뷰(<b><!-- txt리뷰갯수 --></b>)
										</p>
									</li>
								</ul>
							</td>
						</tr>
					</table>
				</td>
		</table>
	</div> <!-- section -->






	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>