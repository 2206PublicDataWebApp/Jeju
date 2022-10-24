<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>공지사항 수정</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
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
            <div    div id="menu-jk" class="header-nav d-none d-md-block">
                <div class="container">
                    <div class="row nav-row">
                        <ul>
                            <li><a href="/home">홈</a></li>
                            <li><a href="/notice/list">공지사항</a></li>
                            <li><a href="detail.html">숙소 리스트</a></li>
                            <li><a href="destinations.html">커뮤니티</a></li>
                            <li><a href="MyPensionList.html">마이페이지</a></li>
                        </ul>
                    </div>
                </div>
            </div> 
        </header>   
        
 <!--  ************************* Page Title Starts Here ************************** -->
        <div class="page-nav no-margin row">
            <div class="container">
                <div class="row">
                    <h2>공지사항 수정</h2>
                    <ul>
                        <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                        <li><i class="fas fa-angle-double-right"></i> 공지사항</li>
                    </ul>
                </div>
            </div>
        </div>

              
    <!--################### Destinations Starts Here #######################--->
        <form action="/notice/modify" method="POST">
        	<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
	        <div class="destinations container-fluid">
	        <div class="container">
	                <div class="session-title">
	                    <h5 style="font-weight: bold; color: rgb(78, 163, 215);">서비스 공지사항 수정</h5>
	                    <hr>   
	                </div>
	                <div class="col-md-7 center" style="margin-bottom: 70px;">
	                    <div class="row g-0 position-relative test2">
	                        <div class="col-md-6 p-6 ps-md-0">
	                            <div style="float: left; font-size: 21px; font-weight: bold">
									<input name="noticeTitle" class="form-control form-control-lg" type="text" placeholder="제목을 입력해주세요." aria-label=".form-control-lg example" value="${notice.noticeTitle }" required>
								</div>
	                        </div>
	                    </div>
	                    <div class="mb-3">				  
						  <textarea name="noticeContents" class="form-control" id="exampleFormControlTextarea1" rows="30" cols="200" placeholder="내용을 입력해주세요." style="resize:none" required>${notice.noticeContents } </textarea>
						</div>  
	                </div>
	            </div>
	        </div> 
	        <br>
	        <div>
	            <div style="text-align: center; margin-bottom: 100px;">
	                <input type="submit" class="btn btn-outline-success" value="수정"></a>
	                <a class="btn btn-outline-success" href="#"  onclick="cancle(${notice.noticeNo});">취소</a>
	            </div>
	        </div>     
        </form> 
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
    	function cancle(noticeNo) {
    		if(confirm("수정을 취소하시겠습니까?")) {
    			location.href="/notice/detail?noticeNo="+noticeNo;
    		}
    	}
    </script>
</html>