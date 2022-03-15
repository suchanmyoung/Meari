<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored="false"%>
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
    <link rel="stylesheet" href="/resources/css/commerce/board_info.css?after">
    <link rel="stylesheet" href="/resources/css/nav.css">
    
    
    
    <!-- to use google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    
    
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">

   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <!-- Link Swiper's CSS -->
   <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
   
   <!-- Demo styles -->
   <style>
     .swiper {
       width: 100%;
       height: 100%;
     }

     .swiper-slide {
       text-align: center;
       font-size: 18px;
       background: #fff;

       /* Center slide text vertically */
       display: -webkit-box;
       display: -ms-flexbox;
       display: -webkit-flex;
       display: flex;
       -webkit-box-pack: center;
       -ms-flex-pack: center;
       -webkit-justify-content: center;
       justify-content: center;
       -webkit-box-align: center;
       -ms-flex-align: center;
       -webkit-align-items: center;
       align-items: center;
     }

     .swiper-slide img {
       display: block;
       width: 100%;
       height: 100%;
       object-fit: cover;
     }
   </style>
   
   
   <script>
   $(document).ready(function(){
      $("#heart").click(function(){
         $.ajax({
            method:"GET",
            url: "${contextPath}/commerce/addHeart",
            data: {"articleNO" : ${article.article.commerce_articleNO}},
            success:function(data){
               $('#heart').attr("src", "/resources/images/sns/heart_icon2.png");
               var no = data
               $('#likecnt').text(no);
            },
            error:function(){
              // alert("로그인 후 이용해주세요.");
               Swal.fire({
                 position: 'top-end',
                 icon: 'success',
                 title: '로그인 후 이용해주세요',
                 showConfirmButton: false,
                 timer: 1500
               });
            }
            
         })
         
      })
   });
    
    function fn_remove_article(url, articleNO){
        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", url);
         var articleNOInput = document.createElement("input");
         articleNOInput.setAttribute("type","hidden");
         articleNOInput.setAttribute("name","articleNO");
         articleNOInput.setAttribute("value", articleNO);
         form.appendChild(articleNOInput);
         document.body.appendChild(form);
         form.submit();
     
     } 
    
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#preview').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }  
 </script>
</head>

<body>
     <form name="frmArticle" method="post"  action="/commerce/comment"  enctype="multipart/form-data">
       <div class="wrap">
          <div class="commerce_img">
               <div class="commerce_img_box">
                   <!-- Swiper -->
               <div class="swiper mySwiper">
                  <div class="swiper-wrapper">
                       <c:forEach var="item" items="${article.imageFileList}" varStatus="status">
                        <div class="swiper-slide"><img src="${contextPath}/commerce_download?commerce_articleNO=${item.commerce_articleNO}&commerce_thumbnailfilename=${item.commerce_imageFileName}"                
                            width="150" height="150" /><br>
                        </div>
                        </c:forEach>
                      </div>
                  <div class="swiper-button-next"></div>
                  <div class="swiper-button-prev"></div>
                  <div class="swiper-pagination"></div>
               </div>
                 </div>
                 
           <!-- 게시글 상세페이지 유저 정보-->
           <div class="UserInfo">
               <!-- 유저 게시글 썻을 떄 유저 정보 나오는 곳,,,-->
               <div class="UserProfile">
                   <img src="/resources/images/commerce/board_img/defaut_profile.png" alt="" />
                   
                   <div class="UserProfileInfo">
                   
                   		<div class="item1">
	                       <span class="UserGrade bold" style = "font-size : 20px;">${article.article.member_id}</span>
	                       <div class="UserData">
	                           <div class="location thin" style = "font-size : 12px; margin-top:-4px; margin-bottom:4px">서초구 방배동</div>
	                       </div>
	                       <p class="board_title regular" style = "font-size : 18px;"> ${article.article.commerce_price}원</p>
                       </div>
                       
                       
              		   
                       <div class ="item2">
                       		<div class="heartContainer">
	                       	    <img class="heartImage" id="heart" src="/resources/images/sns/하트.png">
	              		   		<strong id = "likecnt">${article.article.commerce_like}</strong>
              		   		</div>
   
	                       <c:if test="${member.member_id == article.article.member_id}">
			              		<div id = "modify">
			                        <button style = "color : rgb(120,120,120); margin-right : -10px; font-size : 12px" onClick="location.href='/commerce/update?articleNO=${article.article.commerce_articleNO}'"><p>수정</p></button>
							        <button style = "color : rgb(120,120,120); margin-right : -8px; font-size : 12px" onClick="fn_remove_article('/commerce/removeArticle', ${article.article.commerce_articleNO} ) "><p>삭제</p></button>
						    	</div>
					   	   </c:if>
				   	   </div>
				   	   
                   </div>
               </div>
   
           </div>
           <hr style = "margin-top: -12px;"/>
           <div class="board">
               <p class="board_title regular"> ${article.article.commerce_title}  </p>
                
               
   				
   			
               <!-- 게시글 상세페이지 게시글 내용 -->
               <div class="board_contents">
               		<div class = "flex_colume">
               			 <p class="category thin"> 카테고리 · ${article.article.commerce_writeDate} </p>
               		</div>
               		
       
                  
                   <div class="board_comment" style="font-size:16px">
                      ${article.article.commerce_content}
                   </div>
                   
                   	
                            <input type="hidden" id="articleNO" name="commerce_articleNO" value="${article.article.commerce_articleNO}">
                            <input type="hidden" id="member_id" name="member_id" value="${member.member_id}">
                            <input type="text"  class="comment" name="commerce_reply" placeholder="${member.member_id}로 댓글 달기">
                             <input type="image" class="comImage" src="/resources/images/comment.png" width=20px height=20px>
                       
                       
                       
                  	 <c:forEach var="item" items="${replyList}" varStatus="status">
			  	         			 <c:if test="${not empty replyList[0].commerce_reply && replyList[0].commerce_reply!='null'}">
	          				 <p style = "margin-left : 10px;"><strong>${item.member_id}</strong>  ${item.commerce_reply}</p>
	           			   </c:if>
              		</c:forEach>
               </div>
               
           </div>
           <!-- 게시글 상세페이지 문의하기-->
           <div class="board_btn" style="background-color:white;">      
               <a onclick="location.href='/chat/test?username=${member.member_id}&roomNum=${article.article.commerce_articleNO}'">
               		<img src="/resources/images/commerce/board_img/chat.png">
               </a>
           </div>
           <img src="/resources/images/home/error.png" onclick="location.href='/errorGo'">
   
           
       </div>
   </div>
   
      <!-- Swiper JS -->
       <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
   
       <!—  Initialize Swiper —>
       <script>
         var swiper = new Swiper(".mySwiper", {
           cssMode: true,
           navigation: {
             nextEl: ".swiper-button-next",
             prevEl: ".swiper-button-prev",
           },
           pagination: {
             el: ".swiper-pagination",
           },
           mousewheel: true,
           keyboard: true,
         });
       </script>
</form>
</body>

</html>