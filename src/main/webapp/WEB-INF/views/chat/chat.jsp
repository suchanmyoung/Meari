<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />


<!DOCTYPE html>
<html>

<head>
  <title>What's App</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/sns_new.js"></script>
    <link rel="stylesheet" href="/resources/css/chatstyle.css">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
  
  
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
  <div class="container-fluid">

    <div class="row">

      <div class="col-sm-12">


        <div id="user_chat_data" class="user_chat_data">
          <div class="profile_name">
            &nbsp;&nbsp;&nbsp;&nbsp; <!-- <img src="./img/profile.png" class="mr-3 rounded-circle"> &nbsp;&nbsp; -->
            <span id="username"></span>
          </div>
         
          <div class="container-fluid chat_section" id="chat-box">

          </div>

          <div class="type_msg">
            <div class="input_msg_write">
              <input id="chat-outgoing-msg" type="text" class="write_msg" placeholder="Type a message" />
              <button id="chat-outgoing-button" class="msg_send_btn" type="button"><i class="fa fa-paper-plane"
                  aria-hidden="true"></i></button>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>


  </div>

  </div>
  <!-- script src="/resources/js/chat.js"></script>  -->
  <script>
//로그인 시스템 대신 임시 방편
  let username = '${username}';
  let roomNum = ${roomNum};
  
  //alert(username);
  
  //alert('http://localhost:8080/chat/roomNum/${roomNum}');

  document.querySelector("#username").innerHTML = username;

  // SSE 연결하기
  const eventSource = new EventSource(`http://localhost:8080/chat/roomNum/${roomNum}`);
  eventSource.onmessage = (event) => {
     const data = JSON.parse(event.data);     
     if (data.sender === username) { // 로그인한 유저가 보낸 메시지
        // 파란박스(오른쪽)
        initMyMessage(data);
     } else {
        // 회색박스(왼쪽)
        initYourMessage(data);
     }
  }

  // 파란박스 만들기
  function getSendMsgBox(data) {

     let md = data.createdAt.substring(5, 10)
     let tm = data.createdAt.substring(11, 16)
     convertTime = tm + " | " + md
   
     return `<div class="sent_msg">
     <p>` + data.msg + `</p>
     <span class="time_date"> ` + convertTime + ` / <b>`  + data.sender + `</b> </span>
  </div>`;
  }

  // 회식박스 만들기
  function getReceiveMsgBox(data) {

     let md = data.createdAt.substring(5, 10)
     let tm = data.createdAt.substring(11, 16)
     convertTime = tm + " | " + md

     return `<div class="received_withd_msg">
     <p> ` + data.msg + `</p>
     <span class="time_date">` + convertTime + ` / <b>` + data.sender + `</b> </span>
  </div>`;
  }


  function initMyMessage(data) {
     let chatBox = document.querySelector("#chat-box");

     let sendBox = document.createElement("div");
     sendBox.className = "outgoing_msg";

     sendBox.innerHTML = getSendMsgBox(data);
     chatBox.append(sendBox);

     document.documentElement.scrollTop = document.body.scrollHeight;
  }

  // 회색박스 초기화하기
  function initYourMessage(data) {
     let chatBox = document.querySelector("#chat-box");

     let receivedBox = document.createElement("div");
     receivedBox.className = "received_msg";

     receivedBox.innerHTML = getReceiveMsgBox(data);
     chatBox.append(receivedBox);

     document.documentElement.scrollTop = document.body.scrollHeight;
  };


  async function addMessage() {
     let msgInput = document.querySelector("#chat-outgoing-msg");

     let chat = {
        sender: username,
        roomNum: roomNum,
        msg: msgInput.value
     };

     fetch("http://localhost:8080/chat", {
        method: "post", //http post 메서드 (새로운 데이터를 write)
        body: JSON.stringify(chat), // JS -> JSON
        headers: {   
           "Content-Type": "application/json; charset=utf-8"
        }
     });

     msgInput.value = "";
  };

  // 버튼 클릭시 메시지 전송
  document.querySelector("#chat-outgoing-button").addEventListener("click", () => {
     addMessage();
  });

  // 엔터를 치면 메시지 전송
  document.querySelector("#chat-outgoing-msg").addEventListener("keydown", (e) => {
     if (e.keyCode === 13) {
        addMessage();
     }
  });
  </script>

  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
    integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
    integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
    crossorigin="anonymous"></script>
</body>

</html>