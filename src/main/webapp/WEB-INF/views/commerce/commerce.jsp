<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<% request.setCharacterEncoding("UTF-8"); %>  

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>commerce</title>
    
    <!-- to use google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    
    <!-- alert install -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- jquery install -->
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <!-- googlefonts install -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
	<!-- fontaweseome install -->
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <!--body css link -->
    <link rel="stylesheet" href="/resources/css/commerce/commerce.css?after">
    <!-- header css link -->
    <link rel="stylesheet" href="/resources/css/style.css">
   
    <script>	
    
    
    	function executeAlert(){
    		alert('test성공')
    	}
    	
    	/* 초기값 설정 */
    	var lastNO = ${newArticleList[4].commerce_articleNO}
		var emptyNO = 0;
		console.log("lastNO : "+lastNO);
		
	    /* 스크롤이 하단에 닿으면 */
		$(window).scroll(function() { 
			if($(window).scrollTop() + $(window).height() == $(document).height()) { 
			 	/* new list up */
			 	 console.log("lastNO : "+lastNO);
				 emptyNO = moerList(lastNO);
				 console.log("emptyNO : "+emptyNO);
				 lastNO = emptyNO;
				} 
			});

		function moerList(lastNO){
			
			const size = 5;
	    	//get ajax data[s]
	    	$.ajax({
	    		type : 'POST',
	    		url : "test.action",
	    		data : {
	    			/* ArticleId */
	    			lastArticleId: lastNO, 
	    			/* page size */
	    			size: size,
	    		},
	    		success : function(data) {
	    			console.log("success");
	    			console.log(data);
	    			
	    			for(var i = 0; i < data.length; i++){
	    				var articleNO = data[i].commerce_articleNO;
		    		 	var title = data[i].commerce_title;
		    		 	var member_id = data[i].member_id;
		    		 	var price = data[i].commerce_price;
		    		 	var thumbnail = data[i].commerce_thumbnailfilename;
		    		 	var like = data[i].commerce_like;
		    		 	
		    		 	var $div = $('<div class = "itemContainer">' 
			    		 	+'<a class="img_link"> <img class = "imagebox" src="${contextPath}/commerce_download?commerce_articleNO='+articleNO+'&commerce_thumbnailfilename='+thumbnail+'"  width="100px" height="100px" onClick="location.href=\'/commerce/detail?articleNO="'+articleNO+'\'id="preview"/></a>'
			   					+'<div class = "itemInfo">'
				   					+'<p class = "title reqular">'+title+'</p> <p class = "name thin">'+member_id+'</p> <p class = "price bold">'+price+'</p>'
					       			+'<div class = heartImageBox>'
					       				+'<img class="heartImage" src="/resources/images/commerce/commerce_img/heart_empty.png">'
					       				+'<p class = "like thin">'+like+'</p>'
			       					+'</div>'
		      		   			+'</div>'
		    				+'</div>'
		    				+'<hr class="line" > ');
	    		
		    		 	
		    			
		    			$('.wrap').append($($div));
	    			}
	    			
	    		},
	    		error : function(error) {
	    			console.log("error");
	    			console.log(err);
	    		}
	    	});
	    		
	    	const afterNO = lastNO - size; 
	    	return afterNO;
		  }
		
		
	   /*  var last_articleNO = ${newArticleList[9].commerce_articleNO}
		console.log(last_articleNO); */
    </script>
</head>
<body>
	<div class="wrap">         	
     	<c:forEach  var="article" items="${newArticleList}" varStatus="articleNum" >
    		<div class = "itemContainer">
     				<!-- photo link -->
     			<a class="img_link"> 
     				<%-- <c:if test="${not empty newArticleList.commerce_thumbnailfilename && newArticleList.commerce_thumbnailfilename != 'null'}"> --%>
     				<c:if test="${article.commerce_thumbnailfilename ne 'null'}">
       			<%-- <p>${article.commerce_thumbnailfilename}</p> --%>
       			<img class = "imagebox" 
       			src="${contextPath}/commerce_download?commerce_articleNO=${article.commerce_articleNO}&commerce_thumbnailfilename=${article.commerce_thumbnailfilename}"  
       			width="100px" 
       			height="100px"   			 
       			onClick="location.href='/commerce/detail?articleNO=${article.commerce_articleNO}'"
       			id="preview"/>
      			</c:if>  
      			<%-- <c:if test="${article.commerce_thumbnailfilename eq 'null'}">
      				<p>사진이 없습니다.</p>
      			</c:if>  --%> 			
     			</a>
    				
    				
   				<div class = "itemInfo">
	   				<%-- <p>${articleNum.count}</p> --%>
	       			<p class = "title reqular">${article.commerce_title}</p>
	       			<p class = "name thin">${article.member_id}</p>
	       			<p class = "price bold">${article.commerce_price}</p>
	       			<div class = heartImageBox>
       					<img class="heartImage" src="/resources/images/commerce/commerce_img/heart_empty.png">
       					<p class = "like thin">${article.commerce_like}</p>
       				</div>
      		    </div>
    		</div>
    		<hr class="line" > 		
       	</c:forEach>
       	
       	<div class="feed_btn">
	 <a class="feed_btn" href="" target="_blank"><img src="/resources/images/sns/plus.png" onclick="location.href='/commerce/write'"></a>
	    </div>
    
	</div>
</body>
</html>