<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="member.model.vo.MemberVo"%>
<!DOCTYPE html>
<html>
<head>
<script src='/swp/js/jquery-3.3.1.min.js'></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#updateForm {
  background: #fff;
  padding: 4em 4em 2em;
  max-width: 400px;
  margin: 50px auto 0;
  border-radius: 10px;
}
.outer>form h2 {
  margin: 0 0 50px 0;
  padding: 10px;
  text-align: center;
  font-size: 30px;
  color: #666666;
  border-bottom: solid 1px #e5e5e5;
}
.outer>form p {
  margin: 0 0 3em 0;
  position: relative;
}
#userId, #name, #nickname, #email, #password, #confirm_password {
  display: block;
  box-sizing: border-box;
  width: 100%;
  outline: none;
  margin: 0;
}

#userId, #name, #nickname, #email, #password, #confirm_password {
  background: #fff;
  border: 1px solid #dbdbdb;
  font-size: 1.6em;
  padding: .8em .5em;
  border-radius: 2px;
}
#userId, #name, #nickname, #email, #password, #confirm_password {
  background: #fff;
}
.outer>form span {
  display: block;
  background: #F9A5A5;
  padding: 2px 5px;
  color: #666;
}
.outer>form label {
  position: absolute;
  left: 8px;
  top: 12px;
  color: #999;
  font-size: 16px;
  display: inline-block;
  padding: 4px 10px;
  font-weight: 400;
  background-color: rgba(255, 255, 255, 0);
  -moz-transition: color 0.3s, top 0.3s, background-color 0.8s;
  -o-transition: color 0.3s, top 0.3s, background-color 0.8s;
  -webkit-transition: color 0.3s, top 0.3s, background-color 0.8s;
  transition: color 0.3s, top 0.3s, background-color 0.8s;
}
.outer>form label.floatLabel {
  top: -11px;
  background-color: rgba(255, 255, 255, 0.8);
  font-size: 14px;
}

.container-login100-form-btn {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
}

.login100-form-btn {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  width: 100%;
  height: 60px;
  background-color: #4272d7;

  font-family: OpenSans-Regular;
  font-size: 14px;
  color: #fff;
  line-height: 1.2;
  text-transform: uppercase;

  transition: all 0.4s;
}

/* input[type="button" i], input[type="submit" i], input[type="reset" i], input[type="file" i]::-webkit-file-upload-button, button {
    align-items: flex-start;
    text-align: center;
    cursor: default;
    color: buttontext;
    background-color: buttonface;
    box-sizing: border-box;
    padding: 2px 6px 3px;
    border-width: 2px;
    border-style: none;
    border-color: buttonface;
    border-image: initial;
}

fieldset {
	 background: #fff;
  border: 1px solid #dbdbdb;
  font-size: 1.6em;
  padding: 1.0em .5em;
  border-radius: 2px;
  color: #999;
	
} */
#gender {
	display: inline-block;
	margin-left: 100px;
	width:10px;
}
.login100-form-btn:hover {
  background-color: #333333;
}
.outer {
	width: 800px;
	height: auto;
	background: white;
	color: black;
	margin-left: auto;
	margin-right: auto;
	margin-bottom: 20px;
	padding-bottom: 20px;
	border: 1px solid #7c65b2;
}

#idCheckBtn, #joinMainBtn, #updateBtn, #deleteBtn {
	font-size: 14px;
	font-weight: bold;
	color: white;
	background: #7c65b2;
	border-radius: 5px;
	width: 200px;
	height: 50px;
	text-align: center;
	vertical-align: middle;
	cursor: pointer;
	border: 3px solid white;
}

#joinMainBtn, #updateBtn, #deleteBtn {
	display: table-cell;
}

#searchAddressBtn, #updateBtn, #joinMainBtn {
	background: #7c65b2;
}
</style>
<script>
	function memberJoin(){
		$("#joinForm").submit();		
	}
	
	function validate(){
		if($("#password").val() != $("#confirm_password").val()){
			$("#passChkSpan").text("비밀번호가 일치하지 않습니다.");
			$("#confirm_password").focus();
			return false;
		}
		//다른 값들을 체크 하는 로직 추가(유효성 검사 로직 추가 영역)
		return true;
	}
	function updateMember(){
		$("#updateForm").submit();
	}
	</script>

</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="outer" align="center">
		<form id="updateForm" name="updateForm" action="/swp/updateMember.au"
			method="post" onsubmit="validate();">
			<h2>회원정보 수정</h2>
			<p>
				<label for="id" class="floatLabel">ID</label>
				<input id="userId" name="userId" type="text">
				<span>id를 입력해주세요.</span>
				<!-- <span>이미 사용중인 id 입니다.</span> -->
			</p>
			<p>
				<label for="name" class="floatLabel">이름</label>
				<input id="name" name="name" type="text">
				<!--<span>이름을 입력해주세요.</span>-->
			</p>
			<p>
				<label for="nickname" class="floatLabel">별명</label>
				<input id="nickname" name="nickname" type="text">
				<span>닉네임을 입력해주세요.</span>
				<!--	<span>이미 사용중인 닉네임 입니다.</span>   -->
			</p>
			<p>
				<label for="email" class="floatLabel">이메일</label>
				<input id="email" name="email" type="text">
				<!--<span>이미 사용중인 이메일 입니다.</span>-->
			</p>
			<p>
				<label for="password" class="floatLabel">비밀번호</label> <input
					id="password" name="password" type="password">
				<!--<span>비밀번호를 8자 이상으로 입력해주세요.</span>-->
			</p>
			<p>
				<label for="confirm_password" class="floatLabel">비밀번호 확인</label>
				<input id="confirm_password" name="confirm_password" type="password">
				<!--<span>비밀번호가 일치하지 않습니다.</span>-->
			</p>
			<p>
				<label for="gender" class="floatLabel">성별</label>
			<fieldset>
				<input id="gender_m" name="gender" type="radio" value="M">남자
				<input id="gender_f" name="gender" type="radio" value="F">여자
			</fieldset>
			<!--<span>성별을 선택해주세요.</span>-->
			</p>
			<br>
			<div class="btns" align="center">
				<div id="updateBtn" onclick="updateMember();">회원 수정</div>
				<div id="deleteBtn" onclick="deleteMember();">회원 탈퇴</div>
			</div>
		</form>
	</div>

	<script>
		$(function(){
			$("input:radio").each(function(){
				if($(this).val() == '<%=member.getGender()%>'){
					$(this).prop("checked", true);
				}
			});
		});
		function deleteMember(){
			location.href = "/swp/deleteMember.do?userid=<%=member.getUserId()%>";
		}
	</script>
	<%@ include file="../common/footer.jsp"%>

</body>

</html>