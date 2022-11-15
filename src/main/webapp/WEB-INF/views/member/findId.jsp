<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="shortcut icon" href="/resources/assets/images/fav.png"
	type="image/x-icon">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap"
	rel="stylesheet">
<link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
<link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/assets/css/all.min.css">
<link rel="stylesheet" href="/resources/assets/css/animate.css">
<link rel="stylesheet" type="text/css"
	href="/resources/assets/css/style.css" />
<script src="https://kit.fontawesome.com/422d96f707.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
.findIdForm {
	margin: 100px auto;
	text-align: center;
	width: 400px;
	height: 400px;
	border: 1px solid gray;
	border-radius: 10px;
	box-shadow: 5px 5px 5px 5px gray;
}

.findIdForm button, .findIdForm input {
	width: 250px;
	height: 40px;
}

.findIdForm label {
	margin-right: 200px;
}

span.email, #certificationNumber {
	display: none;
	font-size: 12px;
	top: 12px;
	right: 10px;
}

span.error {
	color: red
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<!--  ************************* Page Title Starts Here ************************** -->
	<div class="page-nav no-margin row">
		<div class="container">
			<div class="row">
				<h2></h2>

			</div>
		</div>
	</div>

	<div class="findIdForm">
		<form action="/member/findIdResult" method="post">
			<br>
			<h3>아이디 찾기</h3>
			<hr>
			<label for="memberEmail">이메일</label><br>
			<div class="email_auth">
				<input type="text" placeholder="이메일" name="memberEmail" id="email"
					class="email">
				<button type="button" id="email_auth_btn" class="email_auth_btn">인증번호
					받기</button>
			</div>
			<input type="text" placeholder="인증번호 입력" id="email_auth_key">
			<button type="submit" id="findIdBtn" onclick=""
				location.href='/member/findIdResult'" >아이디 찾기</button>
		</form>
	</div>

	<script>
		var email_auth_cd = '';
		$(".email_auth_btn").click(function() {
			var email = $('#email').val();
			if (email == '') {
				alert("이메일을 입력해주세요.");
				return false;
			} else {

				$.ajax({
					type : "POST",
					url : "/emailAuth",
					data : {
						"email" : email
					},
					success : function(data) {
						alert("인증번호가 발송되었습니다.");
						email_auth_cd = data;
					},
					error : function(data) {
						alert("메일 발송에 실패했습니다.");
					}
				});
			}
		});
		$("#email_auth_key").blur(
				function() {
					if ($('#email_auth_key').val() != email_auth_cd
							|| $('#email_auth_key').val() == '') {
						alert("인증번호가 일치하지 않습니다.");
						return false;
					} else {
						alert("일치합니다!");
					}
				});
	</script>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
<script src="/resources/assets/js/jquery-3.2.1.min.js"></script>
<script src="/resources/assets/js/popper.min.js"></script>
<script src="/resources/assets/js/bootstrap.min.js"></script>
<script
	src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
<script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
<script src="/resources/assets/js/script.js"></script>
</html>