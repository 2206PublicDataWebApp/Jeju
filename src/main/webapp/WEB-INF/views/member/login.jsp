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
.loginbox{
    width: 780px; height: 550px;
    margin: 0 auto; /* 블록요소를 부모영역에서 가운데 처리 */
}
.loginbox h2{
    width: 100%; /* 부모영역을 상속 */

    /* 한줄텍스트인 경우만 height와 line-height가 같으면 세로 가운데 처리 */
    height: 100px; line-height: 100px;
    text-align: center; font-size: 20px;
    font-weight: normal;
}
.loginbox form{
    width: 100%; height: 450px;
    background-color: #fff;
    /* 패딩수치를 인사이드 처리 */
    padding: 60px; box-sizing: border-box;
}
.loginbox fieldset{
    border: none; /* 테두리 제거 */
}
.loginbox legend{
    /* 요소를 화면 밖으로 처리 */
    position: absolute; left: -999em;

    /* 웹접근성으로 스크린리더기가 읽어줘야 하므로 display: none;을 사용하지 말것 */
}
.loginbox label{
    display: block;
    font-size: 12px; color: #333;
    margin-bottom: 10px; /* 동위선택자와의 간격 조정 */
}
.loginbox input{
    display: block;
    width: 100%; height: 50px;
    margin-bottom: 25px; /* 동위선택자와의 간격 조정 */
    border: none; background-color: #ededed;
    padding: 0 20px; /* 앞상하 뒷좌우 */
    box-sizing: border-box; /* 패딩수치를 인사이드 처리 */
}

.loginbox ul{
    width: 100%;
    text-align: right; /* 글자를 오른쪽으로 처리 */
    margin-bottom: 60px;
}
.loginbox li{
    display: inline-block;
    height: 12px; line-height: 12px;
}
.loginbox li:last-child{
    border-left: 1px solid #333;
    padding-left: 10px; /* 테두리 안쪽 여백 */
    margin-left: 4px; /* 테두리 바깥쪽 여백 */
}
.loginbox a{
    /* 글자관련은 보통 최종태그에 줘야 적용 */
    color: #333; font-size: 12px;

    /* 현재 위치에서 상대적 이동 */
    position: relative; top: -2px;
}
.loginbox button{
    display: block;
    width: 220px; height: 50px;
    margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
    border: none;
    background-color: #1673ea;
    color: #fff; font-size: 14px; font-weight: bold;
}
{ padding: 0; margin: 0; } /* 태그 여백 없앰 */
li{ list-style: none; } /* 기호나 번호를 제거 */
a{ text-decoration: none; } /* 링크텍스트에 밑줄없앰 */
button{ cursor: pointer; } /* 모든 버튼에 마우스손모양 처리 */
</style>
</head>

<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>        
<!--  ************************* Page Title Starts Here ************************** -->
       <div class="page-nav no-margin row">
           <div class="container">
               <div class="row">
                   <h2>로그인</h2>
                   <ul>
                       <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                       <li><i class="fas fa-angle-double-right"></i> 로그인</li>
                   </ul>
               </div>
           </div>
       </div>
<br></br>
<div class="loginbox">
     		<h2 style="font-weight : bold;">로그인</h2>
         <form action="/member/login" method="post">
         <fieldset style="position : relative; bottom : 50px;">
          <legend>로그인 구역</legend>
         	<input type="hidden" name="pensionNo" value="${pensionNo }">
     		 <label for="memberId">아이디</label>
               <input id="memberId" type="text" name="memberId" placeholder="아이디를 입력해 주세요.">
                <label for="memberPwd">비밀번호</label>
               <input id="memberPwd" type="password" name="memberPwd" placeholder="비밀번호를 입력해주세요">

          <ul>
        <li><a href="/member/findId">아이디 찾기</a></li>
        <li><a href="/member/findPwd">| 비밀번호찾기</a></li>
        <li><a href="/member/joinView.kh">회원가입</a></li>
      </ul>
         <button type="submit">로그인</button>
			 </fieldset>
        </form>
   </div>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
</html>