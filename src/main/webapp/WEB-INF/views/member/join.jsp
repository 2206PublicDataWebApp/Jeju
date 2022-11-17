<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>회원가입</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/422d96f707.js"
	crossorigin="anonymous"></script>
<style>
#container {
	width: 100%;
	height: 100%;
	position: relative;
}

span.guide {
	display: none;
	font-size: 12px;
	top: 12px;
	right: 10px;
}

#idCheck {
	display: none;
	color: green;
}

#nonId {
	display: none;
	color: red;
}

.dpn {
	display: none !important;
}

.join_wrap {
	width: 550px;
	margin: 0 auto;
	border: 1px solid #dadada;
	padding: 24px;
	border-radius: 5px;
}

.join_title {
	width: 100%;
	height: 35px;
	font-size: 19px;
	font-weight: bold;
	padding-left: 10px;
	padding: 0 0 10px 10px;
}

.join_box {
	width: 100%;
}

.join_box .join-box__input {
	width: 100%;
	height: 50px;
	border: 1px solid #dadada;
	padding: 17px;
	border-radius: 5px;
	margin-top: 20px;
}

.join_box span {
	display: inline-block;
	color: red;
	font-size: 12px;
	padding-left: 1px;
	padding-top: 8px;
}

.email_auth {
	width: 100%;
	margin-top: 10px;
}

.email_auth input {
	display: inline-block;
	width: calc(100% - 121px);
	vertical-align: top;
	margin: 0;
}

.email_auth_btn {
	display: inline-block;
	width: 115px;
	height: 50px;
	padding: 17px 0 15px;
	border-radius: 6px;
	border: solid 1px rgba(0, 0, 0, .15);
	background-color: #03c75a;
	color: white;
	font-size: 17px;
	font-weight: bold;
	line-height: 1;
}

.join_btn {
	display: block;
	width: 100%;
	padding: 17px 0 15px;
	border-radius: 6px;
	border: solid 1px rgba(0, 0, 0, .15);
	background-color: #03c75a;
	color: white;
	font-size: 19px;
	font-weight: bold;
	margin-top: 20px;
}
</style>
</head>

<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>        
 <!--  ************************* Page Title Starts Here ************************** -->
        <div class="page-nav no-margin row">
            <div class="container">
                <div class="row">
                    <h2>회원가입</h2>
                    <ul>
                        <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                        <li><i class="fas fa-angle-double-right"></i> 회원가입</li>
                    </ul>
                </div>
            </div>
        </div>
	<br></br>
	<div id="container" class="container">
		<div class="content">
			<div class="join_wrap">
				<div class="join_title"></div>
				<div class="join_box">
					<form action="/member/register.kh" method="post">
						아이디 <input class="form-control join-box__input" type="text"
							id="memberId" name="memberId" required> <span
							id="idCheck">이 아이디는 사용 가능합니다.</span> <span id="nonId">이
							아이디는 이미 사용중입니다.</span> <br></br> <label id="memberPwd"
							class="text-start">비밀번호</label> <input
							class="form-control join-box__input" type="password"
							name="memberPwd" id="pw" placeholder="비밀번호 입력" onblur="pwCheck()"
							required>
						<div id="pw_input_result"></div>

						<div class="email_auth">
							<input type="text" placeholder="이메일(*하나의 이메일당 하나의 아이디만 가능)"
								name="memberEmail" id="email" class="email join-box__input" style="margin-bottom : 15px;">
							<span class="test ok" style="">이 메일은 사용 가능합니다.</span> <span
								class="test error" style="">이 메일 이미 사용중입니다.</span>

							<button type="button" id="email_auth_btn" class="email_auth_btn">인증번호
								받기</button>
						</div>
						<input type="text" class="join-box__input" placeholder="인증번호 입력"
							id="email_auth_key">
						<tr>
							<td>* 이름</td>
							<td><input type="text" class="join-box__input"
								name="memberName"></td>
						</tr>

						<tr>
							<td>* 전화번호</td>
							<td><input type="text" class="join-box__input"
								placeholder="ex>01000000000" name="memberPhone"></td>
						</tr>

						<tr>
							<td>* 생년월일</td>
							<td><input type="text" class="join-box__input"
								placeholder="ex>19950215" name="birthDate"></td>
						</tr>
						<tr>
							<td>* 성별</td>
							<br></br>
							<td>
							<input type="radio" value="Woman" name="gender" id="Woman">여자 /
							<input type="radio" value="Man" name="gender" id="Man">남자
							</td>
						</tr>
						
						<tr>
						<br></br> 
							<td>우편 번호</td>
							<td><input type="text" name="post" class="postcodify_postcode5 join-box__input" style="margin-bottom : 15px;">
						<button type="button" id="postcodify_search_button" class="email_auth_btn">검색</button>
						<br></br>
							</td>
						</tr>
						<tr>
							<td>도로 주소</td>
							<td><input type="text"
								name="address1" class="postcodify_address join-box__input" ></td>
						</tr>
						<tr>
						<br></br>
							<td>상세 주소</td>
							<td><input type="text" 
								name="address2" class="postcodify_details join-box__input"></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input type="submit"class="join-box__input"
							
								value="가입하기"></td>
						</tr>
						</table>
					</form>

				</div>
				<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
				<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
				<script>
					$("#postcodify_search_button").postcodifyPopUp();
					/**
					 *  회원가입 관련 처리
					 */
					/////////////////////////////아이디 ////////////////////////////
					$(document).ready(function inputCheck() {
						var chk = $("#email").val();
						if (chk == "") {
							$(".ok").hide();
							$(".error").hide();
						}
					});
					$("#memberId").on("blur", function() {
						var memberId = $("#memberId").val();
						$.ajax({
							url : "/member/checkDupId.kh",
							data : {
								"memberId" : memberId
							},
							type : "get",
							success : function(result) {
								console.log(result);
								if (result != 0) {
									// 아이디를 사용할 수 없습니다.
									// $(".guide.ok").css("display", "none");
									// $(".guide.ok").css("display", "inline-block");
									$("#idCheck").css("display", "none");
									$("#nonId").css("display", "block");
								} else {
									// 아이디를 사용할 수 있습니다.
									$("#idCheck").css("display", "block");
									$("#nonId").css("display", "none");
								}
							},
							error : function() {
								alert("ajax 통신 실패!")
							}
						});
					});
					////////////////////////////비밀번호 검사////////////////////////////////////////////////

					function pwCheck() {
						const pw = document.getElementById('pw').value;
						const pwResult = document
								.getElementById('pw_input_result');
						const exp2 = /^(?=.*[a-z])(?=.*\d)(?=.*[-_!*])[a-z\d-_!*]{8,20}$/;
						if (pw.match(exp2)) {
							pwResult.innerHTML = '조건이 만족 되었습니다';
							pwResult.style.color = 'green';
						} else {
							pwResult.innerHTML = '8~20자리 소문자, 특수기호(-_!*), 숫자 포함해주세요';
							pwResult.style.color = 'red';
						}
					}
					/////////////이메일 정규식 검사/////////

					// 					///////////////////////////////////////메일인증//////////////////////////////////////////		  
					var email_auth_cd = '';

					$("#email_auth_btn")
							.click(
									function() {
										$(document)
												.ready(
														function emailCheck() {
															var echk = $(
																	"#memberEmail")
																	.val();
															if (echk == "") {
																$(".ok").hide();
																$(".error")
																		.hide();
															}
														});
										$("#email")
												.on(
														"blur",
														function() {
															var memberEmail = $(
																	"#email")
																	.val();
															$
																	.ajax({
																		url : "/member/checkDupEmail.kh",
																		data : {
																			"memberEmail" : memberEmail
																		},
																		type : "get",
																		success : function(
																				result) {
																			console
																					.log(result);
																			if (result != 0) {
																				$(
																						".test.ok")
																						.hide();
																				$(
																						".test.error")
																						.show();
																			} else {

																				$(
																						".test.error")
																						.hide();
																				$(
																						".test.ok")
																						.show();
																			}
																		},
																		error : function() {
																			alert("ajax 통신 실패!")
																		}
																	});
														});
										$("#email_auth_btn")
												.click(
														function() {
															var email = $(
																	'#email')
																	.val();
															if (email == '') {
																alert("이메일을 입력해주세요.");
																return false;
															} else {

																$
																		.ajax({
																			type : "POST",
																			url : "/emailAuth",
																			data : {
																				"email" : email
																			},
																			success : function(
																					data) {
																				alert("인증번호가 발송되었습니다.");
																				email_auth_cd = data;
																			},
																			error : function(
																					data) {
																				alert("메일 발송에 실패했습니다.");
																			}
																		});
															}
														});
										$("#email_auth_key")
												.blur(
														function() {
															if ($(
																	'#email_auth_key')
																	.val() != email_auth_cd
																	|| $(
																			'#email_auth_key')
																			.val() == '') {
																alert("인증번호가 일치하지 않습니다.");
																return false;
															} else {
																alert("일치합니다!");
															}
														});
									});
				</script>
</body>
</html>