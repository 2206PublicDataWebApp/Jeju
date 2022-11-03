<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>마이페이지</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
	<script src="/resources/js/jquery-3.6.1.min.js"></script>

</head>
<body>
   <header class="container-flui">
              <div class="header-top">
                  <div class="container">
                       <div class="row">
                           <div class="col-md-4 d-none d-md-block mail-detail">
                           </div>
                           <div class="col-md-4 logo">
                               <img src="/resources/assets/images/logo.png" alt="">
                               <a data-toggle="collapse" data-target="#menu-jk" href="#menu-jk"><i class="fas d-block d-sm-block d-md-none small-menu fa-bars"></i></a>
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
                              <li><a href="/pension/list">숙소 리스트</a></li>
                              <li><a href="destinations.html">커뮤니티</a></li>
                              <li><a href="/mypage/myPage">마이페이지</a></li>
                          </ul>
                      </div>
                  </div>
              </div>
           </header>

            <div class="page-nav no-margin row">
           <div class="container">
               <div class="row">
                   <h2> 마이페이지</h2>
                   <ul>
                       <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                       <li><i class="fas fa-angle-double-right"></i> 마이페이지</li>
                   </ul>
               </div>
           </div>
       </div>
       <div class="destinations container-fluid">
          <div class="container">
               <div class="session-title"></div>
               <div class="dest-row row">
                  <div class="col-lg-4 col-md-6">
                          <div class="dest-col">
                              <div class="dest-img">
                                  <img src="/resources/assets/images/destination/d4.jpg" alt="">
                              </div>
                              <h3>이용내역</h3>
                              <a class="btn btn-outline-success" id="reservationList">바로가기</a>
                          </div>
                      </div>
                  <c:if test="${!empty sessionScope.loginUser }">
                      <div class="col-lg-4 col-md-6">
                          <div class="dest-col">
                              <div class="dest-img">
                                  <img src="/resources/assets/images/destination/d4.jpg" alt="">
                              </div>
                              <h3>내 정보</h3>
                              <a class="btn btn-outline-success" href="/mypage/modifyView">바로가기</a>
                          </div>
                      </div>
                      <div class="col-lg-4 col-md-6">
                          <div class="dest-col">
                              <div class="dest-img">
                                  <img src="/resources/assets/images/destination/d4.jpg" alt="">
                              </div>
                              <h3>숙소관리</h3>
                              <a class="btn btn-outline-success" href="/mypage/pensionManagement">바로가기</a>
                          </div>
                      </div>
                      <div class="col-lg-4 col-md-6">
                          <br><br><br><br><br>
                          <div class="dest-col">
                              <div class="dest-img">
                                  <img src="/resources/assets/images/destination/d4.jpg" alt="">
                              </div>
                              <h3>후기 조회</h3>
                              <a class="btn btn-outline-success" href="/mypage/review">바로가기</a>
                          </div>
                      </div>
                      <div class="col-lg-4 col-md-6">
                          <br><br><br><br><br>
                          <div class="dest-col">
                              <div class="dest-img">
                                  <img src="/resources/assets/images/destination/d4.jpg" alt="">
                              </div>
                              <h3>찜 내역</h3>
                              <a class="btn btn-outline-success" href="/mypage/jjimView">바로가기</a>
                          </div>
                      </div>
                 </c:if>
               </div>
          </div>
       </div>

      <footer>
           <div class="container">
               <div class="row">
                   <div class="col-md-3 fotblog">
                       <p class="fab fa-instagram"></p>
                       <a href="https://www.instagram.com/explore/tags/%EC%A0%9C%EC%A3%BC%EB%8F%84/?next=%2Fspecial_jejudo%2F" style="color: white;" target="_blank">Instagram</a> <br>
                       <a href="https://www.instagram.com/explore/tags/%EC%A0%9C%EC%A3%BC%EB%8F%84%EB%A7%9B%EC%A7%91/?next=%2Fspecial_jejudo%2F" style="color: white;" target="_blank">Restaurant</a> <br>
                       <a href="https://www.instagram.com/explore/tags/%EC%A0%9C%EC%A3%BC%EB%8F%84%EC%B9%B4%ED%8E%98/?next=%2Fspecial_jejudo%2F" style="color: white;" target="_blank">Cafe</a>
                   </div>
                   <div class="col-md-3 fotblog">
                       <p class="fab fa-facebook-square"></p>
                       <a href="https://www.facebook.com/happyjejudo" style="color: white;" target="_blank">Facebook</a>
                   </div>
                   <div class="col-md-3 glink">
                       <p class="fab fa-twitter-square"></p>
                       <a href="https://twitter.com/happyjejudo" style="color: white;" target="_blank">Twiter</a>
                   </div>
                   <div class="col-md-3 tags">
                       <h2>Contect</h2>
                       <p>email@email.com</p>
                   </div>
               </div>
           </div>
       </footer>
</body>

   <script>
      $("#reservationList").click(function() {
          $.ajax({
                url : "/reservation/checkSessionId",
                type : "post",
                success : function(result) {
                   if(result != "") {
                      location.href="/reservation/myPage";
                   }else {
                      alert("로그인 후 이용가능합니다.");
                   }
                }
         });
      });
   </script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>