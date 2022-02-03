<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
// 로그인화면 -> 관리자인덱스화면 -> 특정메뉴로 이동(회원관리) 
// 다시 관리자인덱스로 가려면 링크를 어떻게 걸어야하고 무슨 방법이 필요할까
// 리스트에서 메인으로 가기를 누르면 로그인화면 이동하면서 로그아웃됨
// 현재 로그인한 관리자정보가 계속 살아있다면 
int pageCnt = 0;
AdminInfo adminLoginMember = (AdminInfo)session.getAttribute("adminLoginMember");
if(adminLoginMember != null) {
	//pageCnt = 0;
	out.println("<script>");
	out.println("history.forward();");
	out.println("</script>");
}
System.out.println(pageCnt +"로그인");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
      html {
        background-color: #fcfafa;
      }
      * {
        box-sizing: border-box;
      }
      body {
        margin: 0;
      }
      a {
        text-decoration: none;
        color: black;
      }
      a:visited {
        text-decoration: none;
      }
      a:hover {
        text-decoration: none;
      }
      a:focus {
        text-decoration: none;
      }
      a:hover,
      a:active {
        text-decoration: none;
      }
      input:focus {
        outline: none;
      }
      .container {
        width: 100%;
      }
      .header {
        width: 100%;
        margin: 0 auto;
      }
      .logoBox {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
        width: 410px;
        margin: 0 auto;
      }
      .box {
        margin-top: 10px;
      }
      .left {
        width: 300px;
        text-align: left;
        padding: 15px;
      }
      .right {
        width: 300px;
        text-align: right;
        padding: 15px;
      }
      .line {
        display: inline-block;
      }
      .lineItem {
        border: 1px solid black;
        width: 0.1px;
        height: 11px;
        vertical-align: middle;
        margin: 0px 3px;
      }
      .topMenu {
        height: 50px;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: space-between;
      }
      .gnb {
        height: 57px;
      }
      .cata {
        border: 1px solid rgb(226, 226, 226);
        margin: 0px;
        padding: 0px;
        list-style: none;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
        height: 57px;
        font-size: 15px;
        font-weight: 700;
      }
      .menuTitle {
        margin: 0px 30px;
        font-family: "Montserrat", sans-serif;
      }
      .effCancle {
        margin-right: 0px;
      }

      /*
           flex-direction으로 정렬방향을 지정하면 그 방향에 대한 축이 main축(axis)이된다.
           main축이 정해지면 자동으로 그에 수직으로 떨어지는 cross축이 그려진다.
           flex-wrap : 자식요소의 사이즈가 부모요소의 사이즈를 초과할 경우에 자식요소들을 감싸지 않고 무조건 한 줄에 요소들을 배치하겠다.
           여러줄로 감싸는것이 아닌 한 줄로 감쌈
           자식사이즈를 줄여서라도 한 줄로 만듦
           wrap : 여러줄로 감싸겠다 자식요소의 크기를 줄이지 않고
           main axis를 기준으로 요소들을 정렬하고자 할땐 justify-content속성을 사용
           cross axis를 기준으로 요소들을 정렬하고자 할땐 align-content속성이나 align-item을 사용

           요약
           1.나 플렉스박스 사용할거임
           2.정렬 방향 결정
           3.단 한줄로 모든 요소들을 배치할것인지 여러줄로 감싸 요소들을 배치할것인지 결정
           4.플렉스박스 타임
        */
      .subMenu {
        display: none;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
        background-color: #212121;
        opacity: 0.9;
        color: white;
        z-index: 1;
      }
      .Title {
        width: 100px;
        height: 110px;
        /* margin-right: 15px; */
        font-family: "Montserrat", sans-serif;
        font-size: 14px;
        line-height: 1.5;
      }
      .SuvMenu {
        list-style: none;
        text-align: left;
        padding-left: 0px;
      }
      .sec {
        margin: 0px 50px;
        text-align: left;
      }
      .sec li {
        padding-left: 20px;
        padding-right: 10px;
      }
      .frt li {
        padding-left: 20px;
      }
      .gnb {
        height: auto;
      }
      .loginContainer {
        width: 100%;
        height: 400px;
        /* border: 1px solid black; */
        margin-top: 13%;
      }
      .loginContainer h1 {
        text-align: center;
      }
      .loginBox {
        width: 500px;
        height: auto;
        margin: 0 auto;
      }
      .logTxt {
        display: flex;
        flex-direction: column;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
      }
      .lineBar {
        border: 1px solid rgb(226, 226, 226);
        width: 400px;
        height: 1px;
        margin: 0 auto;
        margin-bottom: 10px;
      }
      .logTxt input {
        width: 400px;
        height: 50px;
        margin-top: 5px;
      }
      #logBtn {
        width: 400px;
        height: 50px;
        margin-top: 10px;
        background-color: #212121d9;
        border: none;
        font-size: 18px;
        color: white;
        cursor: pointer;
      }
      .saveLogin {
        width: 400px;
        margin-top: 6px;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: left;
        align-items: center;
        font-size: 13px;
      }
      footer {
        height: 300px;
        background-color: #212121d9;
        margin-top: 50px;
      }
    </style>
    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600;700&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
    <script src="js/jquery-3.5.1.js"></script>
    <script>
      //마우스커서가 해당 요소위에 올라가면 동작이 되는 코드
      //제이쿼리 문법을 쓰기위해 현재 이벤트를 먹인 문서를 브라우저가 다운로드 받아 준비된 상태로 만든다
      //처음에 메뉴가 숨겨진상태여야함
      //마우스 포인터가 해당 요소에 오버가 되면 동작이됨
      //포인터가 열린 서브메뉴판에서 벗어나면 다시 메뉴가 들어감
      //문제점: 메뉴에 오버했을때 나오는거는 ok 그런데 그 요소에 대해서만 이벤트가 적용이된상태임
      $(document).ready(function () {
        $(".menuTitle").mouseover(function () {
          $(".subMenu").css("display", "flex").stop().slideDown();
        });
        $(".subMenu").mouseleave(function () {
          $(this).css("display", "none").stop().slideUp();
        });
      });
    </script>
  </head>
  <body>
    <div class="loginContainer">
      <header class="header">
        <div class="logoBox">
          <img
            src="images/포에트리 가든.png"
            alt="메인로고"
            width="406px"
            height="73px"
            id="logoImg"
          />
        </div>
      </header>
      <div class="loginBox">
        <h1>Login(Admin)</h1>
        <div class="lineBar"></div>
        <form action="admin_login_proc.adminlog" method="POST" name="logForm">
        <input type="hidden" name="pageCnt" value="<%=++pageCnt%>"/> 
          <div class="logTxt">
            <input type="text" autocomplete="off" placeholder="아이디" name="getId" /><input
              type="password"
              autocomplete="off"
              placeholder="비밀번호"
              name="getPwd"
            />

            <div class="saveLogin">
              로그인상태유지<input
                type="checkbox"
                style="width: 15px; height: 15px"
              />
            </div>
            <button type="submit" id="logBtn" onclick="">관리자 로그인</button>
            <button type="button" id="logBtn" onclick="">아이디 비밀번호 찾기</button>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
