<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="member.model.vo.MemberVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width:600px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		padding:20px;
		border:1px solid white;
	}
	
	#idCheckBtn, #joinMainBtn, #updateBtn, #deleteBtn{
		background:orangered;
		border-radius:5px;
		width:100px;
		height:25px;
		text-align:center;
		cursor:pointer;
	} 
	#joinMainBtn, #updateBtn, #deleteBtn {
		display:inline-block;
	}
	#searchAddressBtn, #updateBtn, #joinMainBtn{
		background:yellowgreen;
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
<%@ include file="header.jsp" %>
		<form id="updateForm" name="updateForm" action="/swp/updateMember.au" method="post" onsubmit="validate();">
  		<h2>회원 가입</h2>
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
			<label for="password" class="floatLabel">비밀번호</label>
			<input id="password" name="password" type="password">
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
				<td></td>
		<br>
		<div class="btns" align="center">	
			<div id="updateBtn" onclick="updateMember();">회원 수정</div>		
			<div id="deleteBtn" onclick="deleteMember();">회원 탈퇴</div>		
		</div>
		</form>

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
	<%@ include file="../common/footer.jsp" %>
</body>

</html>