<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>회원가입</title>
      <link rel="stylesheet" href="/swp/css/signUp.css">
</head>
<body>
<form action="#" method="post" onsubmit="validate();">
  <h2>회원 가입</h2>
  		<p>
			<label for="name" class="floatLabel">이름</label>
			<input id="name" name="name" type="text">
			<span>이름을 입력해주세요.</span>
		</p>
		<p>
			<label for="nickname" class="floatLabel">별명</label>
			<input id="nickname" name="nickname" type="text">
			<span>닉네임을 입력해주세요.</span>
			<span>이미 사용중인 닉네임 입니다.</span>
		</p>
		<p>
			<label for="email" class="floatLabel">이메일</label>
			<input id="email" name="email" type="text">
			<span>이미 사용중인 이메일 입니다.</span>
		</p>
		<p>
			<label for="password" class="floatLabel">비밀번호</label>
			<input id="password" name="password" type="password">
			<span>비밀번호를 8자 이상으로 입력해주세요.</span>
		</p>
		<p>
			<label for="confirm_password" class="floatLabel">비밀번호 확인</label>
			<input id="confirm_password" name="confirm_password" type="password">
			<span>비밀번호가 일치하지 않습니다.</span>
		</p>
		<p>
			<label for="gender" class="floatLabel">성별</label>
			<fieldset>
    			<input id="gender_m" name="gender" type="radio" value="M">남자
    			<input id="gender_f" name="gender" type="radio" value="F">여자
  			</fieldset>
  			<span>성별을 선택해주세요.</span>
		</p>
		
		<div class="container-login100-form-btn m-t-20">
						<button id="submit" class="login100-form-btn">
							Create My Account
						</button>
					</div>
<!-- 		<p> -->
<!-- 			<input type="submit" value="Create My Account" id="submit"> -->
<!-- 		</p> -->
		
	</form>
  <script src='/swp/js/jquery-3.3.1.min.js'></script>
  <script  src="/swp/js/signUp.js"></script>




</body>
</html>