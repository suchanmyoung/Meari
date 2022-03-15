<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/profile/profile.css?after">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>프로필</title>
</head>

<body>
<div class="wrap">
    <!--탑 메뉴 바-->
  <div class="feed_up">
        <div class="up_line1">
            <div class="round"> <span><p style="font-size : 14px;">등산 신동</p></span></div>
            <div class="round"><span><p style="font-size : 14px;">등산의 신</p></span></div>
        </div>

        <div class="up_line2">
            <div class="my_profile">
              <p class="bold" style="margin-bottom:8px; font-size:20px;">${userProfile[0].member_id}</p>
                <div class="image_box"><img class=profile_img src="${contextPath}/userProfileDownload?member_id=${userProfile[0].member_id}&user_imageFileName=${userProfile[0].user_imageFileName}"  onclick="location.href='/profile/update'"/></div>
            </div>
            <div class="my_info">
                <div class="alert">
                    <div class="alert_box">
                        <p class="bold" style="font-size:16px;">스탬프</p>
                        <p>42</p>
                    </div>
                    <div class="alert_box">
                        <p class="bold" style="font-size:16px;">팔로워</p>
                        <p>378Km</p>
                    </div>
                    <div class="alert_box">
                       <p class="bold" style="font-size:16px;">팔로잉</p>
                        <p>376</p>
                    </div>
                </div>
                <div class="percent_medal">
                    <div class="graph">
                        <span></span>
                    </div>
                    <div class="percent">73%</div>
                </div>
            </div>
        </div>
        
        <div class="my_condition">
            <c:if test="${not empty userProfile[0].user_content && userProfile[0].user_content!='null'}">
           		<p style="margin-left: 10px; margin-bottom: 6px; font-size : 14px;">${userProfile[0].user_content}</p>
        	</c:if>
        </div>
            
         
        <nav class="btn_group">
            <!-- 버튼 50%로 크기 조절 -->
            <button id="btn_feed" style="color:rgb(1,199,60)" >
                <h3>사진</h3>
            </button>
            <button id="btn_popular" onclick="location.href='/profile/commerce'">
                <h3>판매물건</h3>
            </button>
        </nav>
        
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
                <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"  width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'" id="preview"/></a>
                </c:if>
              </c:forEach>
              </div>
              <div class="img_sort">
    <c:forEach var="item" items="${newImageList}" begin="12" step="1" end="14" varStatus="status">
             <c:if test="${not empty newImageList[0].sns_imageFileName && newImageList[0].sns_imageFileName!='null'}">
              <input  type= "hidden"   name="originalFileName" value="${item.sns_imageFileName}" />
                <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"  width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'" id="preview"/></a>
                </c:if>
              </c:forEach>
              </div>
              <div class="img_sort">
    <c:forEach var="item" items="${newImageList}" begin="15" step="1" end="17" varStatus="status">
             <c:if test="${not empty newImageList[0].sns_imageFileName && newImageList[0].sns_imageFileName!='null'}">
              <input  type= "hidden"   name="originalFileName" value="${item.sns_imageFileName}" />
                <a class="img_link"> <img src="${contextPath}/download?sns_articleNO=${item.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"  width="122px" height="122px" onClick="location.href='/sns/feed?articleNO=${item.sns_articleNO}'" id="preview"/></a>
                </c:if>
              </c:forEach>
              
        
     </div>

    </div>    

</div>
</body>

</html>