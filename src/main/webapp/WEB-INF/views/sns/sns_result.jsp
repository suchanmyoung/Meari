<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
   <link rel="stylesheet" type="text/css" href="/resources/css/sns/sns_result.css">
   <link rel="stylesheet" href="/resources/css/style.css">
   <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">

   <title>운동결과</title>
</head>

<body>
<div class="wrap">
   <div class="share_box">
      <span>운동 결과</span>
      <button id="btn_share" style="color:rgb(1,199,60)">
         <h3>공유</h3>
      </button>
   </div>

   <div class="result_area">
      <div class="circular_group">
         <div class="circular">
            <h1 class="numb">
               92.1
            </h1>
            <h4 class="numb2">
               EXP.
            </h4>
         </div>
         <div class="circular">
            <h1 class="numb">
               A+
            </h1>
            <h4 class="numb2">
               Rank
            </h4>
            <img class="stamp_img" src="/resources/images/sns/red.png" alt="stamp">
         </div>
      </div>

      <div class="percent_medal">
         <div class="graph">
            <span></span>
         </div>
         <div class="percent">73%</div>
         <div><img src="/resources/images/sns/star.png" alt="medal"></div>
      </div>


      <div class="alert">
         <div class="alert_box">
            <p>거리</p>
            <div class="round">
               <p>50.65Km</p>
            </div>
         </div>
         <div class="alert_box">
            <p>시간</p>
            <div class="round">
               <p>1024분</p>
            </div>
         </div>
         <div class="alert_box">
            <p>걸음</p>
            <div class="round">
               <p>13.18만</p>
            </div>
         </div>
      </div>
   </div>

   <div class="result_record">
      <div class="box">
         <div class="box_line1">
            <div class="date">
               <p>11.3(일) 오후 12시 30분</p>
            </div>

            <div class="mount_info">
               <div class="mount"></div>
               <div class="mount_name">
                  <p>관악산</p>
               </div>
            </div>
         </div>

         <div class="alert2">
            <div class="alert_box">
               <p>거리</p>
               <p>50.65Km</p>
            </div>
            <div class="alert_box">
               <p>시간</p>
               <p>1024분</p>
            </div>
            <div class="alert_box">
               <p>걸음</p>
               <p>13.18만</p>
            </div>
            <div class="alert_box">
               <div class="alert_name">EXP.</div>
               <div class="alert_result">33.2</div>
            </div>
            <div class="alert_box">
               <div class="alert_name">Rank</div>
               <div class="alert_result">A+</div>
            </div>
         </div>
      </div>

      <div class="box">
         <div class="box_line1">
            <div class="date">
               <p>11.3(일) 오후 12시 30분</p>
            </div>

            <div class="mount_info">

               <div class="mount">
               </div>
               <div class="mount_name">
                  <p>관악산</p>
               </div>

            </div>

         </div>

         <div class="alert2">
            <div class="alert_box">
               <p>거리</p>
               <p>50.65Km</p>
            </div>
            <div class="alert_box">
               <p>시간</p>
               <p>1024분</p>
            </div>
            <div class="alert_box">
               <p>걸음</p>
               <p>13.18만</p>
            </div>
            <div class="alert_box">
               <div class="alert_name">EXP.</div>
               <div class="alert_result">33.2</div>
            </div>
            <div class="alert_box">

               <div class="alert_name">Rank</div>
               <div class="alert_result">A+</div>
            </div>
         </div>
      </div>

      <div class="box">
         <div class="box_line1">
            <div class="date">
               <p>11.3(일) 오후 12시 30분</p>
            </div>

            <div class="mount_info">

               <div class="mount">
               </div>
               <div class="mount_name">
                  <p>관악산</p>
               </div>

            </div>

         </div>


         <div class="alert2">
            <div class="alert_box">
               <p>거리</p>
               <p>50.65Km</p>
            </div>
            <div class="alert_box">
               <p>시간</p>
               <p>1024분</p>
            </div>
            <div class="alert_box">
               <p>걸음</p>
               <p>13.18만</p>
            </div>
            <div class="alert_box">
               <div class="alert_name">EXP.</div>
               <div class="alert_result">33.2</div>

            </div>
            <div class="alert_box">

               <div class="alert_name">Rank</div>
               <div class="alert_result">A+</div>
            </div>
         </div>
      </div>

      <div class="box">
         <div class="box_line1">
            <div class="date">
               <p>11.3(일) 오후 12시 30분</p>
            </div>

            <div class="mount_info">

               <div class="mount">
               </div>
               <div class="mount_name">
                  <p>관악산</p>
               </div>
            </div>
         </div>


         <div class="alert2">
            <div class="alert_box">
               <p>거리</p>
               <p>50.65Km</p>
            </div>
            <div class="alert_box">
               <p>시간</p>
               <p>1024분</p>
            </div>
            <div class="alert_box">
               <p>걸음</p>
               <p>13.18만</p>
            </div>
            <div class="alert_box">
               <div class="alert_name">EXP.</div>
               <div class="alert_result">33.2</div>

            </div>
            <div class="alert_box">

               <div class="alert_name">Rank</div>
               <div class="alert_result">A+</div>
            </div>
         </div>
      </div>

      <div class="box">
         <div class="box_line1">
            <div class="date">
               <p>11.3(일) 오후 12시 30분</p>
            </div>

            <div class="mount_info">

               <div class="mount">
               </div>
               <div class="mount_name">
                  <p>관악산</p>
               </div>

            </div>

         </div>


         <div class="alert2">
            <div class="alert_box">
               <p>거리</p>
               <p>50.65Km</p>
            </div>
            <div class="alert_box">
               <p>시간</p>
               <p>1024분</p>
            </div>
            <div class="alert_box">
               <p>걸음</p>
               <p>13.18만</p>
            </div>
            <div class="alert_box">
               <div class="alert_name">EXP.</div>
               <div class="alert_result">33.2</div>
            </div>
            <div class="alert_box">
               <div class="alert_name">Rank</div>
               <div class="alert_result">A+</div>
            </div>
         </div>
      </div>
   </div>
</div>
</body>

</html>