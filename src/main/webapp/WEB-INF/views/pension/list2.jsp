<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>펜션 목록</title>

   <style>
        .test4 {
            margin-bottom: 15px;
        }

    </style>
</head>
<body>
   <c:if test="${!empty cList }">
      <c:forEach items="${cList }" var="search">
         <div class="col-md-4 mb-md-0 p-md-2" id="tableBody1">
            <img src="${search.filePath}" alt="Image" class="img-fluid">
         </div>
         <div class="col-md-6 p-4 ps-md-0" id="tableBody2">
            <ul class="modify">
               <li class="test4"><h2 style="font-size: 25px;">${search.pensionName }</h2></li>
               <li class="test4">${search.pensionAddr }</li>
               <c:if test="${search.pensionPrice == '판매 완료'}">
                  <li class="test4">${search.pensionPrice }</li>
               </c:if>
               <c:if test="${search.pensionPrice != '판매 완료' && search.pensionPrice != '다른날짜 확인'}">
                  <li class="test4">${search.pensionPrice }원</li>
               </c:if>
               <c:if test="${search.pensionPrice == '다른날짜 확인' }">
                  <li class="test4">${search.pensionPrice }</li>
               </c:if>
               <li class="test4">리뷰 364</li>
            </ul>
         </div>
      </c:forEach>
   </c:if>
</body>
</html>