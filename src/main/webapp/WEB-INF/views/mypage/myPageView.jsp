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
	<style>
		#img{
			width:125px;
			height:110px;
		}
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
   	<div class="page-nav no-margin row">
		<div class="container">
	    	<div class="row">
                <h2>마이페이지</h2>
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
	                        <div class="dest-img" >
	                            <img id="img" src="/resources/images/bill.png" alt="">
	                        </div>
	                        <h3>이용내역</h3>
	                        <a class="btn btn-outline-success" href="#" id="reservationList">바로가기</a>
	                    </div>
		            </div>
	            	<c:if test="${!empty sessionScope.loginUser }">
		                <div class="col-lg-4 col-md-6">
		                    <div class="dest-col">
		                        <div class="dest-img">
		                            <img id="img" src="/resources/images/my.png" alt="">
		                        </div>
		                        <h3>내 정보</h3>
		                        <a class="btn btn-outline-success" href="/mypage/modifyView">바로가기</a>
		                    </div>
		                </div>
		                <div class="col-lg-4 col-md-6">
		                    <div class="dest-col">
		                        <div class="dest-img">
		                            <img id="img" src="/resources/images/pension.png" alt="">
		                        </div>
		                        <h3>숙소관리</h3>
		                        <a class="btn btn-outline-success" href="/mypage/pensionManagement">바로가기</a>
		                    </div>
		                </div>
		                <div class="col-lg-4 col-md-6">
		                    <br><br><br><br><br>
		                    <div class="dest-col">
		                        <div class="dest-img">
		                            <img id="img" src="/resources/images/review.png" alt="">
		                        </div>
		                        <h3>후기 조회</h3>
		                        <a class="btn btn-outline-success" href="/mypage/review">바로가기</a>
		                    </div>
		                </div>
		                <div class="col-lg-4 col-md-6">
		                    <br><br><br><br><br>
		                    <div class="dest-col">
		                        <div class="dest-img">
		                            <img id="img" src="/resources/images/jjim.png" alt="">
		                        </div>
		                        <h3>찜 내역</h3>
		                        <a class="btn btn-outline-success" href="/mypage/jjimView">바로가기</a>
		                    </div>
		                </div>
		                <div class="col-lg-4 col-md-6">
		                    <br><br><br><br><br>
		                    <div class="dest-col">
		                        <div class="dest-img">
		                            <img id="img" src="/resources/images/coupon.png" alt="">
		                        </div>
		                        <h3>내 쿠폰함</h3>
		                        <a class="btn btn-outline-success" href="/coupon/couponList">바로가기</a>
		                    </div>
		                </div>
		        	</c:if>
	            </div>
	       </div>
	    </div> 
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
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