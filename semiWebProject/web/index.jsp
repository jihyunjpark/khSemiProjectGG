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
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbb돼라 제발 좀ㅇㅇ ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅇㅇㅇㅇ
			<section class="vertical-center slider">
				<div>
					<img src="/swp/images/main_flash_1_180625.jpg">
				</div>
				<div>
					<img src="/swp/images/main_flash_2_180625.jpg">
				</div>
				<div>
					<img src="/swp/images/main_flash_3_180625.jpg">
				</div>
				<div>
					<img src="/swp/images/main_flash_4_180625.jpg">
				</div>
				<div>
					<img src="/swp/images/main_flash_4_180625.jpg">
				</div>
				<div>
					<img src="/swp/images/main_flash_4_180625.jpg">
				</div>
				<div>
					<img src="/swp/images/main_flash_1_180625.jpg">
				</div>
			</section>


			<script src="https://code.jquery.com/jquery-2.2.0.min.js"
				type="text/javascript"></script>
			<script src="./slick/slick.js" type="text/javascript" charset="utf-8"></script>
			<script type="text/javascript">
				$(document).on('ready', function() {
					$(".vertical-center").slick({
						dots : true,
						vertical : true,
						centerMode : true,
					});
					$(".lazy").slick({
						lazyLoad : 'ondemand', // ondemand progressive anticipated
						infinite : true
					});
				});
			</script>
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			

<%@ include file="/views/common/footer.jsp"%>
</div>

</body>
</html>