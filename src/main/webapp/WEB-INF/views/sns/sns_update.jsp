<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/sns/sns_share.css">
    <link rel="stylesheet" href="/resources/css/nav.css">
    
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/sns_write.js"></script>

</head>
<body>
<form name="articleForm" method="post"   action="/sns/updating"   enctype="multipart/form-data">
<input type="hidden" name="sns_articleNO" value="${article.article.sns_articleNO}">
<c:forEach var="item" items="${article.imageFileList}" varStatus="status">
	<input type="hidden" name="sns_imageFileName" value="${item.sns_imageFileName}">
</c:forEach>

		<div class="share_box" style="text-align: center;line-height: 100px;">
            <span">정보 수정</span>
            <button type="submit" id="btn_share" style="color:rgb(1,199,60)">
            	<h3>완료</h3>
            </button>		                
        </div>

        <div class="feed_area">
        
            <div class="feed_images">
            	<c:forEach var="item" items="${article.imageFileList}" varStatus="status">
		            <div class="swiper-slide"><img src="${contextPath}/download?sns_articleNO=${article.article.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"
		                width="150" height="150" /></div>
				</c:forEach>
            	
            </div>

            <div class="auth">
                <input type="text" size="20" maxlength="100"  value="${member.member_id}" readonly/>
            </div>

            <div class="feed_content">
                <textarea class="feed_text" name="sns_content" placeholder="내용을 입력하세요">${article.article.sns_content }</textarea>
            </div>
        </div>
        </form>
</body>
</html>