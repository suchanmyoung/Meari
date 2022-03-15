<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:set var="article"  value="${articleMap.article}"  />
<c:set var="imageFileList"  value="${articleMap.imageFileList}"  /> --%>


<%
  request.setCharacterEncoding("UTF-8");
%> 

<head>
   <meta charset="UTF-8">
   <title>글보기</title>
   <style>
     #tr_file_upload{
       display:none;
     }
     #tr_btn_modify{
       display:none;
     }   
   </style>
   <link rel="stylesheet" href="/resources/css/nav.css">
   <link rel="stylesheet" href="/resources/css/sns/sns_feed.css?after">
   
   <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
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
   
   <script type="text/javascript" >
   
  	$(document).ready(function(){
		$("#heart").click(function(){
			$.ajax({
				method:"GET",
				url: "${contextPath}/sns/addHeart",
				data: {"articleNO" : ${article.article.sns_articleNO}},
				 success:function(data){
					$('#heart').attr("src", "/resources/images/sns/heart_icon2.png");
					var no = data
					$('#likecnt').text(no);
				},
				error:function(){
					 //alert("로그인 후 이용해주세요."); 
					  Swal.fire({
			                 position: 'cneter',
			                 icon: 'error',
			                 title: '로그인 후 이용해주세요',
			                 showConfirmButton: false,
			                 timer: 1500
			          });
				}
				
			})
			
		})
	});
  	
  	
  	
   
     function backToList(obj){
       obj.action="/sns/feed";
       obj.submit();
     }
     
    
    function fn_enable(obj){
       document.getElementById("i_title").disabled=false;
       document.getElementById("i_content").disabled=false;
       document.getElementById("i_imageFileName").disabled=false;
       document.getElementById("tr_btn_modify").style.display="block";
       document.getElementById("tr_file_upload").style.display="block";
       document.getElementById("tr_btn").style.display="none";
    }
    
/*     function fn_modify_article(obj){
       obj.action="${contextPath}/board/modArticle.do";
       obj.submit();
    }
  */
    
    function fn_remove_article(url,articleNO){
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
    
    function fn_reply_form(url, parentNO){
       var form = document.createElement("form");
       form.setAttribute("method", "post");
       form.setAttribute("action", url);
        var parentNOInput = document.createElement("input");
        parentNOInput.setAttribute("type","hidden");
        parentNOInput.setAttribute("name","parentNO");
        parentNOInput.setAttribute("value", parentNO);
       
        form.appendChild(parentNOInput);
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
		<div class="wrap">
            <div class="feed_area">
                <div class="feed">
                    <div class="feed_img">
                        <div class="feed_img_box">
                        	<!-- Swiper -->
						    <div class="swiper mySwiper">
						    	<div class="swiper-wrapper">
							    	<c:forEach var="item" items="${article.imageFileList}" varStatus="status">
							            <div class="swiper-slide"><img src="${contextPath}/download?sns_articleNO=${article.article.sns_articleNO}&sns_imageFileName=${item.sns_imageFileName}"
							                width="150" height="150" /><br></div>
									</c:forEach>
						      	</div>
						      	<div class="swiper-button-next"></div>
							    <div class="swiper-button-prev"></div>
							    <div class="swiper-pagination"></div>
						    </div>
                        </div>

                        <div class="profile_box">
                            <a href=" " class="image_box"><img class=profile src="/resources/images/sns/PARK.jpg" /></a>
                            <div class="profile_info">
                                <p id="name">${article.article.member_id }</p>
                                <p id="rank">등산의 신</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="feed_content">
                        <div class="content_btn">
                        	
                            <img class="btn_img" id="heart" style="margin:0px 2px" src="/resources/images/sns/하트.png" />                       
                           <!--   <button><img class="btn_img" id="comment" src="/resources/images/comment.png" /></button>-->
                            
                             <c:if test="${member.member_id == article.article.member_id}">
	                			<div id = "modify">
		                            <button style = "color : rgb(120,120,120); margin-right : 10px; font-size : 12px" onClick="location.href='/sns/update?articleNO=${article.article.sns_articleNO}'"><p>수정</p></button>
							        <button style = "color : rgb(120,120,120); margin-right : 2px; font-size : 12px" onClick="fn_remove_article('${contextPath}/board/removeArticle',${article.article.sns_articleNO} ) "><p>삭제</p></button>
						    	</div>
					   		 </c:if>
                            
                        </div>
                        
                        <hr style ="margin : 5px 5px;">
                        
                        <div class="content_info">
                         	<strong>좋아요 </strong> <strong id = "likecnt">${article.article.sns_heart}</strong>
                        	<p style ="margin-top : 5px;">${article.article.sns_content }</p>
                            <div class="time">${article.article.sns_writeDate }</div> 
                           
                            <form action="/comment" method="post">
                            <input type="hidden" id="articleNO" name="sns_articleNO" value="${article.article.sns_articleNO}">
                            
                      		<input type="hidden" id="member_id" name="member_id" value="${member.member_id}">
                            
                            
                            <input type="text"  class="comment" name="sns_reply" placeholder="${member.member_id}로 댓글 달기">
                            
                            <input type="image" class="comImage" src="/resources/images/comment.png" width=20px height=20px>
                            </form>
                            
                            <!-- 여기도 바꿔줘야함~ -->
                           <c:forEach var="item" items="${replyList}" varStatus="status">
					             <c:if test="${not empty replyList[0].sns_reply && replyList[0].sns_reply!='null'}">
					              <p class = "commentText" style = "margin-left : 10px;"><strong>${item.member_id}</strong>    ${item.sns_reply}</p>
					                </c:if>
					        </c:forEach>
					     </div>
                         
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!— Swiper JS —>
	    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	
	    <!— Initialize Swiper —>
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
</body>
</html>