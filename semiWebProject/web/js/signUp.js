//Problem: Hints are shown even when form is valid
//Solution: Hide and show them at appropriate times
var $name = $("#name");
var $nickname = $("#nickname");
var $email = $("#email");
var $password = $("#password");
var $confirmPassword = $("#confirm_password");
var $gender = $("#gender");
var $birth = $("#birth");

//Hide hints
$("form span").hide();


function canSubmit() {
	return isNameValid && isNicknameValid() && isPasswordValid() && arePasswordsMatching() && isGenderValid() && isBirthValid();
}

function enableSubmitEvent() {
	$("#submit").prop("disabled", !canSubmit());
}

function validate(){
	if($("#password").val() !== $("#confirm_password").val()){
		$password.next().show();
		return false;
	}
	return true;
}


//


