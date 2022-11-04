<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>후기 조회</title>
    <link rel="shortcut icon" href="/resources/assets/images/fav.png" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="/resources/assets/images/fav.jpg">
    <link rel="stylesheet" href="/resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/all.min.css">
    <link rel="stylesheet" href="/resources/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/assets/css/style.css" />
    <script src="https://kit.fontawesome.com/422d96f707.js" crossorigin="anonymous"></script>
    <style>
    	p:after {
		   content: none;
		}
    </style>
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
        
 <!--  ************************* Page Title Starts Here ************************** -->
    <div class="page-nav no-margin row">
        <div class="container">
            <div class="row">
                <h2>후기 조회</h2>
                <ul>
                    <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                    <li><i class="fas fa-angle-double-right"></i>마이페이지</li>
                </ul>
            </div>
        </div>
    </div>
        
    <section class="customer-serv">
        <div class="container">
            <div class="row session-title"><h2>${rList[0].memberId }님의 후기 ${totalCount }개 <i class="fa-solid fa-comments"></i></h2></div>
            <div class="row ro-clo">
            	<c:forEach items="${rList }" var="review" varStatus="vs">
	            	<div class="col-12  col-md-6 col-lg-4">
	                    <div class="shado-2 card-b">
	                        <p>${review.reviewContents }</p>
	                    </div>
	                    <div class="cust-det row">
	                        <div class="col-sm-3 col-3 img-circl">
	                            <a class="btn btn-outline-success" href="/pension/detailView2?pensionNo=${review.pensionNo }">작성일 ${review.regDate } 숙소로 이동</a>
	                        </div><br><br>
	                    </div>
	                    <button class="btn btn-outline-success" data-toggle='modal' data-target='#modifyModal${vs.index }'>수정</button>
	                    <button class="btn btn-outline-danger" onclick="removeReview(${review.reviewNo})">삭제</button>
	                </div>
                    <form action="/review/modify" method="post">
                    	<input type="hidden" name="reviewNo" value="${review.reviewNo }">
			            <div class="modal fade" id="modifyModal${vs.index }" role="dialog">
						  <div class="modal-dialog">
						      <div class="modal-content">
						          <div class="modal-header">
						              <h4 class="modal-title">수정</h4>
						              <button type="button" class="close" data-dismiss="modal">&times;</button>
						          </div>
						          <div class="modal-body">
						              <div class="form-group">
						                  <label for="replyText">후기</label>
						                  <textarea class="form-control" name="reviewContents" rows="18" cols="20" placeholder="후기를 입력해주세요." style="resize:none" required>${review.reviewContents }</textarea>
						              </div>
						          </div>
						          <div class="modal-footer">
						              <input type="submit" value="수정" class="btn btn-success modalModBtn" >
						              <button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
						          </div>
						      </div>
						  </div>
						</div>
				   </form>
                </c:forEach>
            </div>
            <nav aria-label="Page navigation example" >
				<ul class="pagination" style="justify-content: center;">
					<li class="page-item">
						<c:if test="${currentPage > 5}">
							<a class="page-link" href="/mypage/${urlVal }?page=${startNavi - 1 }" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
					  		</a>
					  	</c:if>
					</li>
					<c:forEach var="p" begin="${startNavi }" end="${endNavi }">	
					    <li class="page-item"><a class="page-link" href="/mypage/${urlVal }?page=${p }">${p }</a></li>
					</c:forEach>
					<c:if test="${maxPage-4 > currentPage }">
					    <li class="page-item">
					    	<a class="page-link" href="/mypage/${urlVal }?page=${endNavi + 1 }" aria-label="Next">
					     		<span aria-hidden="true">&raquo;</span>
					   		</a>
						</li>
					</c:if>
				</ul>
			</nav>
        </div>
    </section>  
   
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
    	function removeReview(reviewNo){
    		if(confirm("후기를 삭제하시겠습니까?")){
    			location.href="/review/remove?reviewNo="+reviewNo;
    		}
    	}
    </script>
</html>
