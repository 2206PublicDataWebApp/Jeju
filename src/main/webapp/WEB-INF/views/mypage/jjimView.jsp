<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>찜 내역</title>
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
    <div class="page-nav no-margin row">
        <div class="container">
            <div class="row">
                <h2>찜 내역</h2>
                <ul>
                    <li> <a href="/home"><i class="fas fa-home"></i> 홈</a></li>
                    <li><i class="fas fa-angle-double-right"></i>마이페이지</li>
                </ul>
            </div>
        </div>
    </div>
    <c:if test="${empty pList }">
    	<div class="destinations container-fluid">
       		<div class="container">
       			<div class="row session-title"><h2>찜 하신 숙소가 존재하지않습니다.</h2></div>
       		</div>
       	</div>
    </c:if>
    <div class="destinations container-fluid">
       <div class="container">
            <div class="session-title"></div>
            <div class="dest-row row">
            	<c:forEach items="${pList }" var="pension">
	                <div class="col-lg-4 col-md-6">
	                    <div class="dest-col">
	                        <div class="dest-img">
	                            <img src="${pension.filePath }" alt="">
	                        </div>
	                        <h3>${pension.pensionName }</h3>
	                        <h5><i class="fa-solid fa-comments"></i>후기 ${pension.reviewCount }개</h5>
	                        <a class="btn btn-outline-success" href="/pension/detailView2?pensionNo=${pension.pensionNo }">바로가기</a>
	                    </div>
	                </div>
                </c:forEach>
            </div>
       </div><br><br><br>
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
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
    <script src="/resources/assets/js/jquery-3.2.1.min.js"></script>
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>