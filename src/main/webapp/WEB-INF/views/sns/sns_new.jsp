<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
  request.setCharacterEncoding("UTF-8");
%>  


<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.w3.org/1999/xhtml">
<head>

 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/sns_new.js"></script>
    <link rel="stylesheet" href="/resources/css/sns/sns_new.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- 구글 폰트 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <title>SNS최신</title>
</head>


<body>

<div class="wrap">
    
    <div class="feed_up">
        <div class="search_box">
            <input type="search" class="search" placeholder="검색">
        </div>
        <nav class="btn_group">
            <button id="btn_popular" onclick="location.href='/sns/popular'">
                <h3>인기</h3>
            </button>
            <button id="btn_new" style="color:rgb(1,199,60)" onclick="location.href='/sns/new'">
                <h3>최신</h3>
            </button>
        </nav>
    </div>




    <!-- 버튼 크기 조절하기 -->

	<div class="feed_btn">
 <a class="feed_btn" href="" target="_blank"><img src="/resources/images/sns/plus.png" onclick="location.href='/sns/write'"></a>
    </div>

    <div class="feed_area">
    
          <div class="img_sort">
          
          
    <c:forEach var="item" items="${newImageList}" begin="0" step="1" end="2" varStatus="status">
		       <c:if test="${not empty newImageList[0].sns_imageFileName && newImageList[0].sns_imageFileName!='null'}">
     		   <input  type= "hidden"   name="originalFileName" value="${item.sns_imageFileName}" />
  	    		 <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}" width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'" id="preview"/></a>
   				 </c:if>
    	       </c:forEach>
  	</div>

      <div class="img_sort">
    <c:forEach var="item" items="${newImageList}" begin="3" step="1" end="5" varStatus="status">
		       <c:if test="${not empty newImageList[0].sns_imageFileName && newImageList[0].sns_imageFileName!='null'}">
     		   <input  type= "hidden"   name="originalFileName" value="${item.sns_imageFileName}" />
  	    		 <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"  width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'" id="preview"/></a>
   				 </c:if>
    	       </c:forEach>
  	</div>

  <div class="img_sort">
    <c:forEach var="item" items="${newImageList}" begin="6" step="1" end="8" varStatus="status">
		       <c:if test="${not empty newImageList[0].sns_imageFileName && newImageList[0].sns_imageFileName!='null'}">
     		   <input  type= "hidden"   name="originalFileName" value="${item.sns_imageFileName}" />
  	    		 <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"  width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'" id="preview"/></a>
   				 </c:if>
    	       </c:forEach>
  	</div>
  	
  	  <div class="img_sort">
    <c:forEach var="item" items="${newImageList}" begin="9" step="1" end="11" varStatus="status">
		       <c:if test="${not empty newImageList[0].sns_imageFileName && newImageList[0].sns_imageFileName!='null'}">
     		   <input  type= "hidden"   name="originalFileName" value="${item.sns_imageFileName}" />
  	    		 <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"  width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'"  id="preview"/></a>
   				 </c:if>
    	       </c:forEach>
  	</div>
  	
  	 <div class="img_sort">
    <c:forEach var="item" items="${newImageList}" begin="12" step="1" end="14" varStatus="status">
		       <c:if test="${not empty newImageList[0].sns_imageFileName && newImageList[0].sns_imageFileName!='null'}">
     		   <input  type= "hidden"   name="originalFileName" value="${item.sns_imageFileName}" />
  	    		 <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"  width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'"  id="preview"/></a>
   				 </c:if>
    	       </c:forEach>
  	</div>
  	
  	 <div class="img_sort">
    <c:forEach var="item" items="${newImageList}" begin="15" step="1" end="17" varStatus="status">
		       <c:if test="${not empty newImageList[0].sns_imageFileName && newImageList[0].sns_imageFileName!='null'}">
     		   <input  type= "hidden"   name="originalFileName" value="${item.sns_imageFileName}" />
  	    		 <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"  width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'"  id="preview"/></a>
   				 </c:if>
    	       </c:forEach>
  	</div>
  	
  	
  	 
    </div>
    
</div>
</body>





</body>
</html>