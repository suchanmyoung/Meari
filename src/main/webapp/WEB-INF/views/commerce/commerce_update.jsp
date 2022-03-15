<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커머스</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/commerce/commerce_write.css?after">
    <link rel="stylesheet" href="/resources/css/style.css">

    <!-- 제이쿼리 가지고오기-->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>

<body>
    <form name="articleForm" action="/commerce/updating" method="post" enctype="multipart/form-data">
        <input type="hidden" name="commerce_articleNO" value="${article.article.commerce_articleNO}">
        <c:forEach var="item" items="${article.imageFileList}" varStatus="status">
            <input type="hidden" name="commerce_imageFileName" value="${item.commerce_imageFileName}">
        </c:forEach>
        <div class="commercePostWrap">
            <div class="postContainer">
                <p class="main">정보 수정</p>
                <div class="submit"> <input class="shareButton" type="submit" value="완료"> </div>

            </div>
            <hr>

            <div>
                <div class="fileContainer">
                    <div> 이미지파일 </div>
                </div>

                <div class="imageContainer">
                    <c:forEach var="item" items="${article.imageFileList}" varStatus="status">
                        <div class="swiper-slide"><img
                                src="${contextPath}/commerce_download?commerce_articleNO=${item.commerce_articleNO}&commerce_thumbnailfilename=${item.commerce_imageFileName}"
                                width="150" height="150" /><br></div>
                    </c:forEach>
                </div>
            </div>

            <div class="contantsContainer">
                <input type="text" class="title" placeholder="글 제목" name="commerce_title"
                    value="${article.article.commerce_title }">
                <input type="text" class="price" placeholder="가격" name="commerce_price"
                    value="${article.article.commerce_price }">
                <textarea class="detail" cols="10" rows="10"
                    name="commerce_content">${article.article.commerce_content }</textarea>
            </div>

        </div>
    </form>
</body>

</html>