<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>공지사항 작성</title>
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
    	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        
 <!--  ************************* Page Title Starts Here ************************** -->
        <div class="page-nav no-margin row">
            <div class="container">
                <div class="row">
                    <h2>공지사항 작성</h2>
                    <ul>
                        <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                        <li><i class="fas fa-angle-double-right"></i> 공지사항</li>
                    </ul>
                </div>
            </div>
        </div>
              
    <!--################### Destinations Starts Here #######################--->
        <form action="/notice/regist" method="POST">
        <div class="destinations container-fluid">
        <div class="container">
                <div class="session-title">
                    <h5 style="font-weight: bold; color: rgb(78, 163, 215);">서비스 공지사항 등록</h5>
                    <hr>   
                </div>
                <div class="col-md-7 center" style="margin-bottom: 70px;">
                    <div class="row g-0 position-relative test2">
                        <div class="col-md-6 p-6 ps-md-0">
                            <div style="float: left; font-size: 21px; font-weight: bold">
								<input name="noticeTitle" class="form-control form-control-lg" type="text" placeholder="제목을 입력해주세요." aria-label=".form-control-lg example" required>
							</div>
                        </div>
                    </div>
                    <div class="mb-3">				  
					  <textarea name="noticeContents" class="form-control" id="exampleFormControlTextarea1" rows="30" cols="200" placeholder="내용을 입력해주세요." style="resize:none" required></textarea>
					</div>  
                </div>
            </div>
        </div> 
        <br>
        <div>
            <div style="text-align: center; margin-bottom: 100px;">
                <input type="submit" class="btn btn-outline-success" value="작성">
                <a class="btn btn-outline-success" href="#"  onclick="cancle();">취소</a>
            </div>
        </div>     
        </form> 
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </body>
    <script src="/resources/assets/js/jquery-3.2.1.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
    <script>
    	function cancle() {
    		if(confirm("작성을 취소하시겠습니까?")) {
    			location.href="/notice/list";
    		}
    	}
    </script>
</html>