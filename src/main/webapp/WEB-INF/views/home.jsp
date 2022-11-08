<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
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
   <title>제주어때 홈</title>
   <style>
   		#logo{
   			color:white;
   			font-family:'여기어때 잘난체 OTF', GungsuhChe , "궁서체";
   		}
   </style>
</head>

<body>
   <header class="container-flui">
           <div class="header-top">
               <div class="container">
                    <div class="row">
     
                        <div class="col-md-4 d-none d-md-block mail-detail"></div>
                        <div class="col-md-4 logo">
                        	<h1 id="logo">제주어때</h1>
<!--                             <img src="/resources/assets/images/logo.png" alt=""> -->
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
                  
                <a href="#"><img onclick="location.href='/chat/login2.do'"
					src="/resources/images/chatting.png"style="width:30px; height:30px; background-color: white;">
					
					</a>
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
        
        
<!--################### Slider Starts Here #######################--->

    <div class="slider-detail">

        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item ">
                    <img class="d-block w-100" src="/resources/assets/images/slider/slider-5.jpg" alt="First slide">
                    <div class="carousel-caption fvgb d-none d-md-block">
                        <h5 class="animated bounceInDown">여러분의 숙소를 보여주세요 ! </h5>
                        <div class="row vbh">
                            <div class="btn btn-primary animated bounceInUp"><a href="#" onclick="registPension('${sessionScope.loginUser.memberId}');" style="color:white">숙소 등록 하러가기</a></div>
                        </div>
                    </div>
                </div>

                <div class="carousel-item active">
                    <img class="d-block w-100" src="/resources/assets/images/slider/slider-3.jpg" alt="Third slide">
                    <div class="carousel-caption vdg-cur d-none d-md-block">
                        <h5 class="animated bounceInDown">자신의 숙소를 등록하고 싶다면?</h5>
                        <div class="row vbh">
                            <div class="btn btn-primary animated bounceInUp"><a href="#" onclick="registPension('${sessionScope.loginUser.memberId}');" style="color:white">숙소 등록 하러가기</a></div>
                        </div>
                    </div>
                </div>

            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>


    </div>
       
       
          <!--*************** About Us Starts Here ***************-->
   
   <section id="about" class="contianer-fluid about-us">
       <div class="container">
            <div class="row">
                <div class="col-md-7 text">
                    <h2>About Smart Traveler</h2>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                    <p> It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. dummy text of the printing and  been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.dummy text of the has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                    <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some formhumour, or randomised words which don't look even slightly believable. If you are going to use a passage.There are many variations of passages of Lorem Ipsum available slightly believable. If you are going to use a passage.</p>
                </div>
                <div class="col-md-5 center image">
                    <img src="/resources/assets/images/about.png" alt="">
                </div>
            </div>
       </div>
   </section>
      
        <!--  *************************Our Team Start Here ************************** -->
        
        <div class="our-team">
            <div class="container">
                <div class="row session-title">
                    <h2>What We Offer</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sollicitudin nisi id consequat bibendum. Phasellus at convallis elit. In purus enim, scelerisque id arcu vitae</p>
                </div>  
            <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="card-1 team-member">
                            <img src="/resources/assets/images/team/team-1.jpg" alt="Team Member 1">
                            <p><b>Siva Kumar</b> (CEO & Chairman)</p>
                            <ul class="row">
                                <li><i class="fab fa-facebook-f"></i></li>
                                <li><i class="fab fa-twitter"></i></li>
                                <li><i class="fab fa-linkedin-in"></i></li>
                                <li><i class="fab fa-google-plus-g"></i></li>
                                <li><i class="fab fa-pinterest-p"></i></li>
                            </ul>
                        </div>
                    </div>
                        <div class="col-md-3 col-sm-6">
                        <div class="card-1 team-member">
                            <img src="/resources/assets/images/team/team-2.jpg" alt="Team Member 1">                            
                            <p><b>Siva Kumar</b> (CEO & Chairman)</p>
                            <ul class="row">
                                <li><i class="fab fa-facebook-f"></i></li>
                                <li><i class="fab fa-twitter"></i></li>
                                <li><i class="fab fa-linkedin-in"></i></li>
                                <li><i class="fab fa-google-plus-g"></i></li>
                                <li><i class="fab fa-pinterest-p"></i></li>
                            </ul>
                        </div>
                    </div>
                        <div class="col-md-3 col-sm-6">
                        <div class="card-1 team-member">
                            <img src="/resources/assets/images/team/team-3.jpg" alt="Team Member 1">
                            <p><b>Siva Kumar</b> (CEO & Chairman)</p>
                            <ul class="row">
                                <li><i class="fab fa-facebook-f"></i></li>
                                <li><i class="fab fa-twitter"></i></li>
                                <li><i class="fab fa-linkedin-in"></i></li>
                                <li><i class="fab fa-google-plus-g"></i></li>
                                <li><i class="fab fa-pinterest-p"></i></li>
                            </ul>
                        </div>
                     </div>
                        <div class="col-md-3 col-sm-6">
                        <div class="card-1 team-member">
                            <img src="/resources/assets/images/team/team-4.jpg" alt="Team Member 1">                          
                            <p><b>Siva Kumar</b> (CEO & Chairman)</p>
                            <ul class="row">
                                <li><i class="fab fa-facebook-f"></i></li>
                                <li><i class="fab fa-twitter"></i></li>
                                <li><i class="fab fa-linkedin-in"></i></li>
                                <li><i class="fab fa-google-plus-g"></i></li>
                                <li><i class="fab fa-pinterest-p"></i></li>
                            </ul>
                        </div>
                     </div>
                 </div>
           </div>      
        </div>
        
  <!-- ######## Our Team End ####### --> 
       
        
    <!--################### Destinations Starts Here #######################--->
        
    <div class="destinations container-fluid">
       <div class="container">
            <div class="session-title">
                <h2>Our Destinations</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sollicitudin nisi id consequat bibendum. Phasellus at convallis elit. In purus enim, scelerisque id arcu vitae</p>
            </div>
            <div class="dest-row row">
                <div class="col-lg-4 col-md-6">
                    <div class="dest-col">
                        <div class="dest-img">
                            <img src="/resources/assets/images/destination/d2.jpg" alt="">
                        </div>
                        <h3>Switzerland</h3>
                        <p>Duis neque sem, ultrices et erat</p>
                        <button class="btn btn-outline-success">Book Now</button>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="dest-col">
                        <div class="dest-img">
                            <img src="/resources/assets/images/destination/d3.jpg" alt="">
                        </div>
                        <h3>Maldives</h3>
                        <p>Duis neque sem, ultrices et erat</p>
                        <button class="btn btn-outline-success">Book Now</button>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="dest-col">
                        <div class="dest-img">
                            <img src="/resources/assets/images/destination/d4.jpg" alt="">
                        </div>
                        <h3>Srilanka</h3>
                        <p>Duis neque sem, ultrices et erat</p>
                        <button class="btn btn-outline-success">Book Now</button>
                    </div>
                </div>
            </div>
       </div>      
    </div>  
  
      <!--*************** Testionial  Starts Here *************** -->
    <section class="customer-serv">
            <div class="container">
                <div class="row session-title">
                    <h2>Happy Customers</h2>

                </div>

                <div class="row ro-clo">
                    <div data-anijs="if: scroll, on: window, do: bounceInLeft animated, before: scrollReveal" class="col-12  col-md-6 col-lg-4">
                        <div class="shado-2 card-b">
                            <p>Classic Aqua water purify is good.Because its cure our purify that is called  health and gives good life. I suggest classic aqua for its best purify of water</p>
                        </div>
                        <div class="cust-det row">
                            <div class="col-sm-3 col-3 img-circl">
                                <img alt="" src="/resources/assets/images/testimonial/member-01.jpg">
                            </div>
                            <div class="col-sm-5 col-5 an-mtc no-padding">
                                <b>Sarath Ali</b>
                                <p>(Sales Agent)</p>
                            </div>
                            <div class="col-sm-4 col-4 star-par">
                                <ul class="stars">
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-12  col-md-6 col-lg-4">
                        <div class="shado-2 card-b">
                            <p> have use this product at my home last 1 and half year of this. This product quality is good.Its good quality product for use it can improve water Quality.
                            </p>
                        </div>
                        <div class="cust-det row">
                            <div class="col-sm-3 col-3 img-circl">
                                <img alt="" src="/resources/assets/images/testimonial/member-02.jpg">
                            </div>
                            <div class="col-sm-5 col-5 an-mtc no-padding">
                                <b>Binny Aderson</b>
                                <p>(Sales Agent)</p>
                            </div>
                            <div class="col-sm-4  col-4 star-par">
                                <ul class="stars">
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div data-anijs="if: scroll, on: window, do: bounceInRight animated, before: scrollReveal" class="col-12  col-md-6 col-lg-4">
                        <div class="shado-2 card-b">
                            <p>Very essensial product.it is clean and helthy water is mutually most important so that acqa is fufil its quality.our life now a days very tressful and restless</p>
                        </div>
                        <div class="cust-det row">
                            <div class="col-sm-3 col-3 img-circl">
                                <img alt="" src="/resources/assets/images/testimonial/member-03.jpg">
                            </div>
                            <div class="col-sm-5 col-5 an-mtc no-padding">
                                <b>Arjun Samluel</b>
                                <p>(Sales Agent)</p>
                            </div>
                            <div class="col-sm-4 col-4 star-par">
                                <ul class="stars">
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                    <li><i class="fa fa-star"></i></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
       
     <!--*************** Key Features Starts Here ***************-->

    <div id="features" class="features container-fluid">
        <div class="container">
            <div class="session-title">
                <h2>Key Features of this Phone</h2>
            </div>
            <div class="ker-featur-row row">
                <div data-aos="fade-right" data-aos-duration="1500" class="col-md-4 featurecol feature-left">
                    <div class="single-feature">
                       
                       <div class="detail">
                           <h6>100% Safety</h6>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                 Voluptatem, inventore</p>
                       </div>
                       <div class="icon">
                           <i class="far fa-bell"></i>
                       </div>
                        
                        
                    </div>
                    <div class="single-feature">
                       
                         <div class="detail">
                        <h6>Afordable Packages</h6>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                Voluptatem, inventore</p>
                        </div>
                        <div class="icon">
                             <i class="far fa-heart"></i>
                        </div>
                    </div>
                    
                </div>
                <div class="col-md-4 featur-image">
                    <img src="/resources/assets/images/traveler.png" alt="">
                </div>
                <div data-aos="fade-left" data-aos-duration="1500" class="col-md-4 featurecol feature-right">
                    
                    <div class="single-feature">
                       <div class="icon">
                        <i class="far fa-images"></i>
                        </div>
                        <div class="detail">
                        <h6>Tourist Guid</h6>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                Voluptatem, inventore</p>
                        </div>
                    </div>
                    <div class="single-feature">
                           <div class="icon">
                            <i class="fab fa-audible"></i>
                          </div>
                            <div class="detail">
                            <h6>Exciting Places</h6>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                    Voluptatem, inventore</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
                    
                    
     <!--*************** Blog Starts Here ***************-->
                     
    <div class="container-fluid blog">
        <div class="container">
             <div class="session-title">
                <h2>Our Blog</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sollicitudin nisi id consequat bibendum. Phasellus at convallis elit. In purus enim, scelerisque id arcu vitae</p>
            </div>
                <div class="blog-row row">
                    <div class="col-lg-4 col-md-6 ">
                       <div class="blog-col">
                            <img src="/resources/assets/images/destination/d1.jpg" alt="">
                            <span>August 9, 2019</span>
                            <h4>Orci varius consectetur adipiscing natoque penatibus</h4>
                            <p>Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent accumsan, leo in venenatis dictum, </p>
                       </div>
                       
                    </div>
                     <div class="col-lg-4 col-md-6">
                       <div class="blog-col">
                            <img src="/resources/assets/images/destination/d2.jpg" alt="">
                            <span>August 9, 2019</span>
                            <h4>Orci varius consectetur adipiscing natoque penatibus</h4>
                            <p>Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent accumsan, leo in venenatis dictum, </p>
                       </div>
                       
                    </div>
                     <div class="col-lg-4 col-md-6 ">
                       <div class="blog-col">
                            <img src="/resources/assets/images/destination/d3.jpg" alt="">
                            <span>August 9, 2019</span>
                            <h4>Orci varius consectetur adipiscing natoque penatibus</h4>
                            <p>Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent accumsan, leo in venenatis dictum, </p>
                       </div>
                       
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
    </body>
    <script src="/resources/assets/js/jquery-3.2.1.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
    <script>
       function registPension(memberId) {
    	   if(memberId == "") {
    		   if(confirm("로그인이 필요한 서비스입니다. 로그인 하시겠습니까?")){
    			   location.href="/member/loginView.kh"
    		   }
    	   }else{
	          location.href="/pension/registForm";
    	   }
       }
    </script>
</html>