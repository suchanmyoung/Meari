<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅창</title>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/commerce/chat_room.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>

<div id="chat-body">
    <!-- 프로필 사진, 프로필명 -->
    <header>
        <img class="profile-img" src="/resources/images/캡처.PNG" alt="프로필사진">
        <div class="profile-col">
            <span class="profile-name">김민석</span>
        </div>
    </header>
    <main>
        <!-- 고정된 공지사항 영역 -->
        <div class="notice-bar">
            <i class="icon-bullhorn"></i>
            <span>대화 중 상대방이 의심스럽다면, 거래를 하지 않는 것이 좋아요.</span>
            <i class="icon-down-open-big"></i>
        </div>
        <!-- 채팅 내용 시작 -->
        <div class="chat-content">
            <!-- 메시지 시작 날짜 -->
            <div class="date-line">
                <time datetime="2021-03-29">2021년 9월 23일 목요일</time>
            </div>
            <!-- 채팅 내용 -->
            <div class="main-chat">
                <div class="friend-chat">
                    <img class="profile-img" src="/resources/images/캡처.PNG" alt="프로필사진">
                    <div class="friend-chat-col">
                        <span class="profile-name">김민석</span>
                        <span class="balloon">​
                                ​[솔라] 어떻게 한순간의 떨림이
                                소리 없이 너의 두 눈을 가리니
                                ​[화사] 너의 뜻대로 흘러가네
                                내게 상처를 주면 안 돼</span>
                        <span class="balloon">​[문별] 넌 네 생각만 하지
                                그래 뭐 그게 참 당연한 듯이
                                어리석게 너에게만 맞춰 왔던 게
                                날 괴롭히네 마지막까지 외롭게 해</span>
                    </div>
                    <time datetime="07:30:00+09:00">오전 7:30</time>
                </div>
                <div class="me-chat">
                    <div class="me-chat-col">
                            <span class="balloon">​[휘인] 할 말이 없어 Go away
                                설명이 더 필요해?
                                ​[솔라] 화를 내도 내 입만 아프다니까
                                넌 멋대로만 해</span>
                    </div>
                    <time datetime="07:32:00+09:00">오전 7:32</time>
                </div>
                <div class="me-chat">
                    <div class="me-chat-col">
                            <span class="balloon">​[화사] 난 언제나 너너너너 해
                                넌 언제나 나나나나 해
                                ​[휘인] 움띠야이야 띠야이야
                                네 멋대로 중심이 돼</span>
                    </div>
                    <time datetime="07:33:00+09:00">오전 7:33</time>
                </div>
                <div class="friend-chat">
                    <img class="profile-img" src="/resources/images/캡처.PNG" alt="프로필사진">
                    <div class="friend-chat-col">
                        <span class="profile-name">김민석</span>
                        <span class="balloon">​
                                [솔라] 넌 너만 생각해
                                ​[휘인] 밤을 새워 버렸어
                                차갑게 식은 머리도
                                ​[솔라] 너의 태도가 이해 안 돼
                                이젠 조금씩 지쳐 가네</span>
                        <span class="balloon">​
                                [문별] 이젠 나도 내 앞길 챙기지
                                ​[문별] 내가 맞춰야 돼 AY
                                매번 That's OK man
                                이런 식으로 매일 반복 돼
                                나의 호의 에도 너의 권리만 있다면
                                뭔가 잘못된 거지</span>
                        <span class="balloon">​[솔라] 뭘 그렇게 놀래 당연한 이야긴데
                                ​[화사] 화를 내도 내 입만 아프다니까
                                ​[문별] 네 멋대로만 해</span>
                    </div>
                    <time datetime="07:35:00+09:00">오전 7:35</time>
                </div>
                <div class="me-chat">
                    <div class="me-chat-col">
                            <span class="balloon">[휘인] 난 언제나 너너너너 해
                                넌 언제나 나나나나 해</span>
                    </div>
                    <time datetime="07:36:00+09:00">오전 7:36</time>
                </div>
                <div class="me-chat">
                    <div class="me-chat-col">
                            <span class="balloon">​[화사] 움띠야이야 띠야이야
                                네 멋대로 중심이 돼</span>
                    </div>
                    <time datetime="07:49:00+09:00">오전 7:49</time>
                </div>
                <div class="friend-chat">
                    <img class="profile-img" src="/resources/images/캡처.PNG" alt="프로필사진">
                    <div class="friend-chat-col">
                        <span class="profile-name">김민석</span>
                        <span class="balloon">​[솔라] 넌 너만 생각해
                                그럴 거면 너너너나 해 에이에
                                움띠야이야 띠야이야
                                ​[화사] 네 멋대로 굴면 안 돼
                                ​[솔라] 멋대로만 해 넌 너나 해</span>
                        <span class="balloon">​[화사] I'm ready to go on my way</span>
                    </div>
                    <time datetime="09:00:00+09:00">오전 9:00</time>
                </div>
                <div class="me-chat">
                    <div class="me-chat-col">
                            <span class="balloon">​[휘인] 할 말이 없어 Go away
                                설명이 더 필요해?
                                ​[솔라] 화를 내도 내 입만 아프다니까
                                ​[문별] 나도 멋대로 할래
                                ​[화사] Bicho Malo</span>
                    </div>
                    <time datetime="09:30:00+09:00">오전 9:30</time>
                </div>
                <div class="friend-chat">
                    <img class="profile-img" src="/resources/images/캡처.PNG" alt="프로필사진">
                    <div class="friend-chat-col">
                        <span class="profile-name">김민석</span>
                        <span class="balloon">​[화사] 난 언제나 너너너너 해
                                넌 언제나 나나나나 해
                                ​[휘인] 움띠야이야 띠야이야
                                ​[휘인]&[화사] 네 멋대로 중심이 돼
                                ​[솔라] 넌 너만 생각해
                                그럴 거면 너너너나 해 에이에
                                움띠야이야 띠야이야
                                ​[휘인] 네 멋대로 굴면 안 돼
                                ​[휘인] 내 멋대로 할래</span>
                    </div>
                    <time datetime="10:15:00+09:00">오전 10:15</time>
                </div>
            </div>
        </div>
        <!-- 채팅 입력창 -->
        <div class="insert-content">
            <form name="chatform" action="#" method="post">
                <textarea name="chat-insert" required></textarea>
                <input type="submit" class="chat-submit" value="전송">
            </form>
            <!-- 채팅 입력 관련 기능(파일 첨부, 캡쳐 등) -->
            <div class="insert-menu">
                <i class="icon-smile"></i>
                <i class="icon-attach"></i>
                <i class="icon-phone"></i>
                <i class="icon-calendar-empty"></i>
                <i class="icon-camera"></i>
            </div>
        </div>
    </main>
</div>

</body>

</html>