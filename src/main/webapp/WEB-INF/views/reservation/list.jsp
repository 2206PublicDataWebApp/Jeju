<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Travelet Free Website Tempalte | Smarteyeapps.com</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />

    <style>
        .myGrade {
            font-size: 13px;
            margin-bottom: 5px;
            color: rgb(154, 153, 153);
        }
        
        .card-title {
            font-size: 15px;
            font-weight: bold;
        }

        .test15 {
            font-size: 13px;
            font-weight: 540;
        }

        .list-group-item {
            text-align: center;
            font-size: 16px;
            font-weight: bold;
        }

        #price {
            color: red;
        }
        .card {
            margin-top: 15px;
            margin-bottom: 70px;
        }
        .reserve {
            font-size: 15px;
            font-weight: bold;
            color: rgb(191, 191, 191);
        }
        #reserveInfo {
            margin-bottom: 23px;
            font-size: 20px;
            font-weight: bold;
        }

        .info {
            margin-bottom: 10px;
        } 

        .inputInfo {
            margin-bottom: 10px;
        }
        .inputInfo1 {
            margin-bottom: 10px;
        }
        #info2 {
            margin-top: 30px;
        }
        .login {
            font-size: 15px;
            font-weight: bold;
            color: white;
        }
        #check1 {
            font-size: 15px;
            font-weight: bold;
            margin-top: 15px;
            margin-bottom: 10px;
        }
        .check6 {
            font-size: 13px;
            font-weight: bold;
        }
        .check7 {
            margin-left: 6px;
        }

        #price1 {
            font-weight: bold;
        }

        .test5 {
            color: red;
        }

    </style>
</head>

    <body>
        <header class="container-flui">
           <div class="header-top">
               <div class="container">
                    <div class="row">
                        <div class="col-md-4 d-none d-md-block mail-detail">
                            <ul>
                                <li>Call US : +12 878 777 76765</li>
                                <li>Email : info@thetraveller.com</li>
                            </ul>
                        </div>
                        <div class="col-md-4 logo">
                            <img src="assets/images/logo.png" alt="">
                            <a data-toggle="collapse" data-target="#menu-jk" href="#menu-jk"><i class="fas d-block d-sm-block d-md-none small-menu fa-bars"></i></a>
                        </div>
                        <div class="col-md-4 d-none d-md-block social-link ">
                            <ul>
                                <li>
                                    <i class="fab fa-facebook-square"></i>
                                </li>
                                <li>
                                    <i class="fab fa-twitter-square"></i>
                                </li>
                                <li>
                                    <i class="fab fa-instagram"></i>
                                </li>
                                <li>
                                    <i class="fab fa-linkedin"></i>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
           </div>
           <div id="menu-jk" class="header-nav d-none d-md-block">
               <div class="container">
                   <div class="row nav-row">
                       <ul>
                           <li><a href="index.html">Home</a></li>
                           <li><a href="about_us.html">About Us</a></li>
                           <li><a href="destinations.html">Destinations</a></li>
                           <li><a href="blog.html">Blog</a></li>
                           <li><a href="gallery.html">Gallery</a></li>
                           <li><a href="contact_us.html">Contact Us</a></li>
                       </ul>
                   </div>
               </div>
           </div>
            
        </header>   
        
        
 <!--  ************************* Page Title Starts Here ************************** -->
    <div class="page-nav no-margin row">
        <div class="container">
            <div class="row">
                <h2>About Traveler</h2>
                <ul>
                    <li> <a href="#"><i class="fas fa-home"></i> Home</a></li>
                    <li><i class="fas fa-angle-double-right"></i> About Us</li>
                </ul>
            </div>
        </div>
    </div>

  

      <!--  ************************* Contact Us Starts Here ************************** -->
    <div class="row contact-rooo no-margin">
        
        <div class="container">
        	<br>
            <hr>
            <div class="row">


                <div style="padding:20px; " class="col-sm-9" >
                    <div id="reserveInfo">예약자 정보</div>
                    <div class="row cont-row info">
                        <div class="col-sm-3 reserve"><label>예약자 이름</label></div>
                    </div>
                    <div class="col-sm-8 inputInfo1"><input type="text" placeholder="체크인시 필요한 정보입니다." name="name" class="form-control input-sm"></div>
                    <div  class="row cont-row info" id="info2">
                        <div  class="col-sm-3 reserve"><label>휴대폰 번호 (비회원)</label></div>   
                    </div>
                    <div class="col-sm-8 inputInfo" style="display: inline-block; ">
                        <input type="text" name="name" placeholder="전화번호를 입력해주세요." class="form-control input-sm"> 
                    </div>
                    <button class="btn btn-info btn-md-4">인증</button>
                    <div  class="row cont-row info3">
                        <div  class="col-sm-3 reserve"><label>등급 할인</label></div>
                    </div>
                    <div class="myGrade">나의 등급(플래티넘)</div>
                    <div class="myGrade" style="display: inline-block;">할인할 수 있는 금액 : <span id="price1">300,000원</span></div>
                    <button class="btn btn-info btn-sm" style="font-size: 8px;">할인 적용</button>
                    <br><br>
                    <div style="margin-top:10px;" class="row">
                        <div style=" text-align: center; background-color: lightblue;" class="col-sm-9"><br><div class="login">로그인 후 예약하시면</div><div class="login"> 등급할인이 적용됩니다.</div><div class="login" style="margin-top: 10px;">로그인</div><br>
                    </div></div>
                    <form action="">
                        <div id="check1">이용 약관</div>
                        <ul>
                            <li class="check6"><input type="checkbox"><span class="check7">전체동의</span></li>
                            <li class="check6"><input type="checkbox"><span class="check7">개인정보 동의</span><span class="test5">(필수)</span></li>
                            <li class="check6"><input type="checkbox"><span class="check7">숙소 이용규칙 및 환불 규정</span><span class="test5">(필수)</span></li>
                            <li class="check6" style="margin-bottom: 20px;"><input type="checkbox"><span class="check7">만 14세 이상 확인</span><span class="test5">(필수)</span></li>
                        </ul>
                    </form>
                </div>
                
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                      <h5 class="card-title">숙소 이름</h5>
                      <p class="card-text">제주도 서귀포 펜션</p>
                      <br>
                      <h5 class="card-title">객실 타입 / 기간</h5>
                      <p class="card-text">제주도 서귀포 펜션</p>
                      <br>
                      <h5 class="card-title">체크인</h5>
                      <p class="card-text">10.13 목 15:00</p>
                      <br>
                      <h5 class="card-title">체크 아웃</h5>
                      <p class="card-text">10.14 금 15:00</p>
                      <hr>
                      <h5 class="card-title">총 결제 금액</h5>
                      <h5 class="card-title" id="price">300,000원</h5>
                      <ul>
                        <li class="test15">ㆍ결제완료 후 내 정보에서 예약 내</li>
                        <li style="margin-left: 16px;" class="test15">역을 확인해주세요.</li>
                      </ul>

                    </div>
                    
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item">결제하기</li>
                      <li class="list-group-item">나중에 결제<div>(회원만 가능)</div></li>   
                    </ul>

                  </div>
            </div>
        </div>

    </div>
    

      
      
       
   <!--*************** Footer  Starts Here *************** -->   

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

    <script src="/resources/assets/js/jquery-3.6.1.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>
