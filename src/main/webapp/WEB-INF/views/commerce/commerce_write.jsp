<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

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
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <!-- 파일 가지고오기 -->
    <script type="text/javascript">
    var previewCnt = 1;
   /* 프리뷰하기 */
    function readURL(input) {
       
       $('#fileSelecter'+previewCnt).css('pointer-events', 'none');
        
        if (input.files && input.files[0]) {
           var reader = new FileReader();
           reader.onload = function (e) {     
	             if(previewCnt <= 3){ 
	               $('#preview'+previewCnt).attr('src', e.target.result);
	                previewCnt++;
	               $(".imageContainer").append("<div>"+"<img id='preview"+previewCnt+"' src='#' width='100px' height='100px' onerror=\"this.src='/resources/images/defaultImage.png'\" />");
	               fn_addFile(previewCnt);
	             }else{
	                alert("사진은 3개이상 등록할 수 없습니다.");
	             }
           }
           reader.readAsDataURL(input.files[0]);
        }
    }
    
     function backToList(obj){
      /*  obj.action="${contextPath}/board/listArticles.do"; */
       obj.submit();
     } 
     
     var cnt=1;
     function fn_addFile(){
         $("#d_file").append("<br>"+
               "<label class='input-file-button' for='fileSelecter"+cnt+"'>파일 선택</label>"+
               "<br>"+
               "<input id='fileSelecter"+previewCnt+"' type='file'  name='file"+cnt+"' onchange='readURL(this,"+cnt+");' />");
         cnt++;
     }  
   </script>
   
</head>

<body>
<form action="/commercePost" method="post" enctype="multipart/form-data">
    <div class="commercePostWrap">
       
        <!--  <p class="share">공유</p> -->
        <div class="postContainer">
           <p class="main">새 거래글</p>
           <div class="submit"> <input class="shareButton" type="submit" value="공유"> </div>
          
       </div>
       <hr>
       
       <div>
          <div class="fileContainer">
             <div> 이미지파일 첨부 </div>
          </div>
          <div class = "imageContainer">
             <img  id="preview1" src="#"   width=100px height=100px onerror="this.src='/resources/images/defaultImage.png'"/>
             
          </div>
         
           <label class="input-file-button" for="fileSelecter1">
           파일 선택
         </label>
          <input id="fileSelecter1" type="file" name="sns_imageFileName" onchange="readURL(this);"/>
          <br>　
          <div id="d_file" ></div>
       </div>    
       
       <div class="contantsContainer">
           <input type="text" class="title" placeholder="글 제목" name="commerce_title">
           <input type="text" class="price" placeholder="가격" name="commerce_price">
           <textarea class="detail" cols="10" rows="10" name="commerce_content"></textarea>  
        </div>        
          
    </div>
</form>
</body>

</html> 