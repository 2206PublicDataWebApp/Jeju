<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>

    <body>
         <header class="container-flui">
           <div class="header-top">
               <div class="container">
                    <div class="row">
                        <div class="col-md-4 d-none d-md-block mail-detail"></div>
                        <div class="col-md-4 logo">
                            <img src="/resources/assets/images/logo.png" alt="">
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
                  <a href="/">${sessionScope.loginUser.memberId }</a>님 환영합니다
               </td>
            </tr>
            <tr>
               <td><a href="/member/logout.kh">로그아웃</a></td>
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
                           <li><a href="/pension/list">숙소 리스트</a></li>
                           <li><a href="/community/chat">커뮤니티</a></li>
                           <li><a href="/mypage/myPage">마이페이지</a></li>
                           <li><a href="/admin/adminPage">관리자페이지(임시)</a></li>
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

       
         <!--*************** Blog Starts Here ***************-->
                     
    <div class="container-fluid blog">
        <div class="container">
            <hr>
             <div class="session-title">
                <h5 style="font-size: 20px; font-weight : bold;">예약 내역</h5>     
            </div>
            <hr>
           <div style="font-size: 16px; color : red; font-weight : bold; margin-bottom: 15px;">결제 대기</div>
                <div class="blog-row row">     
                    <c:if test="${!empty wList}">
                    	<c:forEach items="${wList }" var="wait">
	                    	<div class="col-lg-4 col-md-6 ">
		                    	<div class="blog-col">
		                            <img src="${wait.reFilePath}">
		                            <span>${wait.rePayDate} 결제</span>
		                            <a href="/reservation/cancel?reservationNo=${wait.reservationNo }"><div style="text-align: center;"><button class="btn btn-info btn-sm" style="font-size: 8px;">결제 대기</button></div></a>
		                            <div style="text-align: center; font-size: 20px; font-weight: bold; margin-bottom: 5px; margin-top: 5px;">${wait.rePensionName }</div>
		                            <div style="text-align: center;">${wait.reStartDate } ~ ${wait.reEndDate }</div>
		                            <div style="text-align: center; font-size: 15px; font-weight: bold; margin-top: 10px;">결제 금액 <span style="font-size: 15px; color: red;">${wait.rePrice }원</span></div>
		                        </div>
		                     </div>  
                    	</c:forEach>                  
                    </c:if>  
            </div>
        </div>

        
        <div class="container">
            <hr>
          <div style="font-size: 16px; font-weight : bold; margin-bottom: 15px;">예약 내역</div>
               <div class="blog-row row">
                <c:if test="${!empty rList}">
                   	<c:forEach items="${rList }" var="success">
                    	<div class="col-lg-4 col-md-6 ">
	                    	<div class="blog-col">
	                            <img src="${success.reFilePath}">
	                            <span>${success.rePayDate} 결제</span>
	                            <div style="text-align: center;"><button class="btn btn-info btn-sm" style="font-size: 8px;">예약 완료</button></div>
	                            <div style="text-align: center; font-size: 20px; font-weight: bold; margin-bottom: 5px; margin-top: 5px;">${success.rePensionName }</div>
	                            <div style="text-align: center;">${success.reStartDate } ~ ${success.reEndDate }</div>
	                            <div style="text-align: center; font-size: 15px; font-weight: bold; margin-top: 10px;">결제 금액 <span style="font-size: 15px; color: red;">${success.rePrice }원</span></div>
	                        </div>
	                     </div>  
                   	</c:forEach>                  
                 </c:if>           
           </div>
       </div>

       <div class="container">
        <hr>
      <div style="font-size: 16px; font-weight : bold; margin-bottom: 15px;">이용 내역</div>
           <div class="blog-row row">
            
       </div>
   </div>
        
    </div>    
    
      
      
       
   <!--*************** Footer  Starts Here *************** -->   

   <footer>
    <div class="container">
        <div class="row">
            <div class="col-md-3 about">
                <h2>About Us</h2>
                <p>Phasellus scelerisque ornare nisl sit amet pulvinar. Nunc non scelerisque augue. Proin et sollicitudin velit. </p>
                
                <div class="foot-address">
                    <div class="icon">
                        <i class="fas fa-map-marker-alt"></i>
                    </div>
                    <div class="addet">
                        BlueDart
                        Marthandam (K.K District)
                        Tamil Nadu, IND 
                    </div>
                </div>
                <div class="foot-address">
                    <div class="icon">
                        <i class="far fa-envelope-open"></i>
                    </div>
                    <div class="addet">
                        info@smarteyeapps.com <br>
                        sales@smarteyeapps.com
                    </div>
                </div>
                <div class="foot-address">
                    <div class="icon">
                         <i class="fas fa-mobile-alt"></i>
                    </div>
                    <div class="addet">
                        +23 323 43434 <br>
                        +1 3232 434 55
                    </div>
                </div>
            </div>
            <div class="col-md-3 fotblog">
                <h2>From latest Blog</h2>
                <div class="blohjb">
                    <p>dignissim. Integer tempor facilisis malesuada. Proin ac varius velit, tincidunt condimentum</p>
                    <span>22-1-2019</span>
                </div>
                <div class="blohjb">
                    <p>dignissim. Integer tempor facilisis malesuada. Proin ac varius velit, tincidunt condimentum</p>
                    <span>22-1-2019</span>
                </div>
                <div class="blohjb">
                    <p>dignissim. Integer tempor facilisis malesuada. Proin ac varius velit, tincidunt condimentum</p>
                    <span>22-1-2019</span>
                </div>
            </div>
            <div class="col-md-3 glink">
                <h2>Quick Links</h2>
                <ul>
                    <li><a href="index.html"><i class="fas fa-angle-double-right"></i>Home</a></li>
                    <li><a href="about_us.html"><i class="fas fa-angle-double-right"></i>About Us</a></li>
                    <li><a href="services.html"><i class="fas fa-angle-double-right"></i>Services</a></li>
                    <li><a href="blog.html"><i class="fas fa-angle-double-right"></i>Blog</a></li>
                    <li><a href="pricing.html"><i class="fas fa-angle-double-right"></i>Gallery</a></li>
                    <li><a href="contact_us.html"><i class="fas fa-angle-double-right"></i>Contact Us</a></li>
                </ul>
            </div>
            <div class="col-md-3 tags">
                <h2>Easy Tags</h2>
                <ul>
                    <li>Finance</li>
                    <li>Web Design</li>
                    <li>Internet Pro</li>
                    <li>Node Js</li>
                    <li>Java Swing</li>
                    <li>Angular Js</li>
                    <li>Vue Js</li>
                </ul>
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

    <script src="/resources/assets/js/jquery-3.2.1.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>
