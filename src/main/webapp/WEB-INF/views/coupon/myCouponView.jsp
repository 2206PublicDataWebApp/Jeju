<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>마이페이지 이용내역</title>
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
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>        
    <div class="page-nav no-margin row">
        <div class="container">
            <div class="row">
                <h2>내 쿠폰함</h2>
                <ul>
                    <li> <a href="#"><i class="fas fa-home"></i>마이페이지</a></li>
                    <li><i class="fas fa-angle-double-right"></i>내 쿠폰함</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="destinations container-fluid">
       <div class="container">
            <div class="session-title">
                <h2>내 쿠폰함</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sollicitudin nisi id consequat bibendum. Phasellus at convallis elit. In purus enim, scelerisque id arcu vitae</p>
            </div>
            <div class="dest-row row">
            	<c:if test="${!empty mList }">
            		<c:forEach items="${mList }" var="myCoupon">
		                <div class="col-lg-4 col-md-6">
		                    <div class="dest-col">
		                        <div class="dest-img">
		                            <img src="${myCoupon.couponImage }" alt="">
		                        </div>
		                        <h3>${myCoupon.couponTitle }</h3>
		                        <p>${myCoupon.couponComments }</p>
		                        <button class="btn btn-outline-success">Book Now</button>
		                    </div>
		                </div>
		            </c:forEach>    
                </c:if>
            </div>
       </div>
    </div>   
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    </body>
    <script>
    </script>

    
    <script src="/resources/assets/js/popper.min.js"></script>
    <script src="/resources/assets/js/bootstrap.min.js"></script>
    <script src="/resources/assets/plugins/scroll-fixed/jquery-scrolltofixed-min.js"></script>
    <script src="/resources/assets/plugins/slider/js/owl.carousel.min.js"></script>
    <script src="/resources/assets/js/script.js"></script>
</html>
