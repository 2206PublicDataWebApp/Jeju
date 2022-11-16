<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>제주어때 예약페이지</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
	<script src="/resources/js/jquery-3.6.1.min.js"></script>
	<link rel="stylesheet" href="/resources/assets/css/reservationStyle.css">   
	<style>
	.modal-title{
	 font-size: 17px;
	 text-align:left;
	 font-weight: bold;
	}
	.modal_table{
	  width:100%;
	}
	#modal_userImg{
	  width:170px;
	  height:80px;
	  margin-right : 180px;
	/*   border-radius: 75%; */
	}
	#modal_userId{
	  width:200px;
	}
	#modal_userFollow{
	  margin:10px;
	  text-align: right;
	}
	
	#couponCancel {
	  display : none;
	}

	</style>
</head>
    <body>
            

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
 <!--  ************************* Page Title Starts Here ************************** -->
    <div class="page-nav no-margin row">
        <div class="container">
            <div class="row">
                <h2>숙소 상세 페이지</h2>
                <ul>
                    <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                    <li><i class="fas fa-angle-double-right"></i> 숙소 상세 페이지</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="row contact-rooo no-margin">
        
        <div class="container">
        	<br>
            <hr>
            <div class="row">

				
                <div style="padding:20px; margin-bottom : -50px; height : " class="col-sm-9" >
	                <form action="/reservation/searchNonMember" method="post">
	                    <div id="reserveInfo">비회원 예약 조회</div>
	                    <div class="row cont-row info">
	                        <div class="col-sm-3 reserve"><label>예약자 이름</label></div>
	                    </div>
	                    <div class="col-sm-8 inputInfo1" style="display: inline-block; ">
		                    <input type="text" placeholder="비회원 조회시 필요한 정보입니다." name="reservationName" class="form-control input-sm" id="nameChk"> 	                    
	                    </div>
	                      <span id="successNameChk" style="font-size : 13px;"></span>     
	                    <div  class="row cont-row info" id="info2">
	                        <div  class="col-sm-3 reserve"><label>예약 번호</label></div>   
	                    </div>
	                    <div class="col-sm-8 inputInfo" style="display: inline-block;">
	                        <input type="text" id="reservationCode" name="reservationCode" placeholder="예약번호를 입력해주세요." class="form-control input-sm">                          
	                    </div>
	                    <button id="phoneChk" class="btn btn-info btn-md-4" type="submit">조회</button>           			
	                 </form>
                </div>                                       
            </div>                    
        </div>
    </div>
    <br><br>
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
		<div class="copy">
            <div class="container">
                <a href="https://www.smarteyeapps.com/">2015 &copy; All Rights Reserved | Designed and Developed by Smarteyeapps</a>              
                <span>
	                <a><i class="fab fa-github"></i></a>
	                <a><i class="fab fa-google-plus-g"></i></a>
	                <a><i class="fab fa-pinterest-p"></i></a>
	                <a><i class="fab fa-twitter"></i></a>
	                <a><i class="fab fa-facebook-f"></i></a>
        		</span>
            </div>
        </div>  
    </body>
     <script>
    </script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>