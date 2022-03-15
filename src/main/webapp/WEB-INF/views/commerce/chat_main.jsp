<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅목록</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/commerce/chat.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>
<div class="chat_list_wrap">
    
    <div class="button">
        <input type='button' value="SNS">
        <input type='button' value="COMMERCE">
    </div>
    <div class="list">
        <ul>
            <li>
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <td class="profile_td">
                            <!--프로필이미지-->
                            <img src="/resources/images/메아리.png" />
                        </td>
                        <td class="chat_td">
                            <!--Email & Preview-->
                            <div class="email">
                                ohmygirl@gmail.com
                            </div>
                            <div class="chat_preview">
                                네 마음 위로 번지
                            </div>
                        </td>
                        <td class="time_td">
                            <!--Time & Check-->
                            <div class="time">
                                2021-09-23-05:00
                            </div>
                            <div class="check">

                            </div>
                        </td>
                    </tr>
                </table>
            </li>
            <li>
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <td class="profile_td">
                            <!--Img-->
                            <img src="/resources/images/메아리.png" />
                        </td>
                        <td class="chat_td">
                            <!--Email & Preview-->
                            <div class="email">
                                asd@asd.asd
                            </div>
                            <div class="chat_preview">
                                test
                            </div>
                        </td>
                        <td class="time_td">
                            <!--Time & Check-->
                            <div class="time">
                                YYYY:MM:DD:HH:MM24
                            </div>
                            <div class="check">

                            </div>
                        </td>
                    </tr>
                </table>
            </li>
        </ul>
    </div>
    
</div>
</body>

</html>