<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
<link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
<link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/assets/css/all.min.css">
<link rel="stylesheet" href="/resources/assets/css/animate.css">
<link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ce0b65b35053a74c5f16b289cf432142"></script>
<script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
	#logo{
		color:white;
		font-family:'여기어때 잘난체 OTF', GungsuhChe , "궁서체";
		font-size:50px;
	}
	.idui{
		color:white;
	}
</style>
</head>
<body>
   <header class="container-fluid">
           <div class="header-top">
               <div class="container">
                    <div class="row">
                        <div class="col-md-4 d-none d-md-block mail-detail"></div>
                        <div class="col-md-4 logo">
                            <h1 id="logo">제주어때 </h1>
                            <a data-toggle="collapse" data-target="#menu-jk" href="#menu-jk"><i class="fas d-block d-sm-block d-md-none small-menu fa-bars"></i></a>
                        </div>
                        <div class="col-md-4 d-none d-md-block social-link ">
                               <c:if test="${empty sessionScope.loginUser  }">
						         <div class="login-area">
						            <table align="right">
						               <tr>
						                  <td rowspan="2">
						                     <button onclick="location.href='/member/loginView.kh'" class="btn btn-primary">로그인</button>
						                     <button onclick="location.href='/member/joinView.kh'" class="btn btn-secondary">회원가입</button>
						                  </td>
						               </tr>
						            </table>
						         </div>
						      </c:if>
						      <c:if test="${not empty sessionScope.loginUser }">
						         <table align="right">
						            <tr>
						               <td>
						                  ${sessionScope.loginUser.memberId } 님 환영합니다
							              <a href="#"><img onclick="location.href='/chat/login2.do'"
										src="/resources/images/consultimg.png"style="width:60px; height:60px;">
						               	  </a>
						               </td>
						            </tr>
						            <tr>
						               <td><a href="/member/logout.kh"style="width:30px; height:30px; color : white;" >로그아웃</a></td>
						            </tr>
						         </table>
						      </c:if>
                        </div>
                    </div>
                </div>
           </div>
           <div id="menu-jk" class="header-nav d-none d-md-block">
               <div class="container">
                   <div class="row nav-row">
                       <ul>
                           <li><a href="/home">홈</a></li>
                           <li><a href="/notice/list">공지사항</a></li>
                           <li><a href="/community/chat">커뮤니티</a></li>
                           <li><a href="/coupon/couponEventList">쿠폰 이벤트</a></li>
                           <li><a href="/mypage/myPage">마이페이지</a></li>
                           <c:if test="${sessionScope.loginUser.memberId eq 'admin' }">
                           	   <li><a href="/admin/adminPage">관리자페이지</a></li>
                           </c:if>
                       </ul>
                   </div>
               </div>
           </div>
        </header>
</body>
</html>