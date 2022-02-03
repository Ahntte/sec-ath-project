<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
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
        background-color: #fcfafa;
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
        height: auto;
      }
      .loginContainer h1 {
        text-align: left;
        margin-top: 50px;
      }
      .loginBox {
        width: 1000px;
        height: auto;
        margin: 0 auto;
      }
      .logTxt {
        display: flex;
        flex-direction: column;
        flex-wrap: nowrap;
        justify-content: flex-start;
        align-items: flex-start;
      }
      .lineBar {
        border: 1px solid rgb(226, 226, 226);
        width: 400px;
        height: 1px;

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
      .formContainer {
        width: 900px;
        margin: 0 auto;
        margin-top: 60px;
      }
      .subWrap {
        width: 800px;
        margin: 0 auto;
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
      }
      .txtId {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
        width: 450px;
        height: 60px;
        /* border: 1px solid black; */
      }
      .txtPwd {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
        width: 450px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .chkPwd {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
        width: 450px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .txtName {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
        width: 450px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .txtPhone {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: start;
        align-items: center;
        width: 352px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .txtEmail {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
        width: 450px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .zip {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: start;
        align-items: center;
        width: 352px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .addrBox1 {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: start;
        align-items: center;
        width: 352px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .addrBox2 {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: start;
        align-items: center;
        width: 352px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .choGender {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: start;
        align-items: center;
        width: 352px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .txtbirth {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: start;
        align-items: center;
        width: 352px;
        height: 60px;
        /* border: 1px solid black; */
        border-top: none;
      }
      .sameCtr {
        display: inline-block;
        /* margin-top: 12px;
        margin-left: 100px; */
        height: 40px;
      }
      #s {
        height: 40px;
      }

      .pxt {
        height: 40px;
      }
      .zipNum {
        height: 40px;
      }
      .addr {
        height: 40px;
      }
      .btnBox {
        width: 520px;
        /* border: 1px solid black; */
        text-align: center;
        margin: 0 auto;
        margin-top: 25px;
      }

      .btnSize {
        width: 300px;
        height: 50px;
        border: none;
        background-color: #212121d9;
        color: #ffffff;
        font-size: 18px;
        cursor: pointer;
      }
      .ctrName {
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: start;
        align-items: center;
        width: 352px;
        height: 10px;
        /* border: 1px solid black; */
        border-top: none;
      }
      /*
      #pho {
        margin-left: 100px;
        display: inline-block;
      }
      #pw {
        margin-left: 83px;
      }
      #cpw {
        margin-left: 49px;
      }
      #nm {
        margin-left: 117px;
      }
      #ema {
        margin-left: 100px;
      }
      */
      #idMsg {
        font-size: 11px;
      }
      footer {
        height: 300px;
        background-color: #212121d9;
        margin-top: 50px;
      }
      .spanBox {
        display: inline-block;
        width: 100px;
        margin-left: 10px;
      }
      .zipFindBtn {
        width: 90px;
        height: 40px;
        border: none;
        background-color: #212121d9;
        color: #ffffff;
        font-size: 16px;
        cursor: pointer;
      }
      .menuTitle {
        margin: 0px 30px;
        cursor: pointer;
        font-family: "Montserrat", sans-serif;
      }
      .footer {
      width: 100%;
      height: 300px;
      border:1px solid black;
      background-color: #1D3932;
      color: #ffffff;
      text-align: center;
      padding-top: 60px;
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
    <script>
      function checkAll() {
        // 회원가입 양식의 필수컨트롤을 제어하는 함수 (유효성 검사)
        const form = document.frmJoin;

        if (!checkUserId(form.id.value, form.id)) {
          return false;
        } else if (
          !checkUserPwd(
            form.pwd.value,
            form.pwd,
            form.chkpwd.value,
            form.id.value
          )
        ) {
          return false;
        } else if (!checkUserName(form.name.value, form.name)) {
          return false;
        } else if (!checkUserGender(form.radio)) {
          return false;
        } else if (
          !checkUserPhone(
            form.secnumber.value,
            form.trdnumber.value,
            form.secnumber,
            form.trdnumber
          )
        ) {
          return false;
        } else if (!checkUserEmail(form.email.value)) {
          return false;
        }
        return true;
      }

      function checkGap(value, ctrlMsg, ctrlName) {
        // 빈문자를 검사하는 함수
        if (value == "") {
          alert(ctrlMsg + "입력해주세요.");
          // 커서를 해당 컨트롤에 위치시키려고함
          ctrlName.focus();
          return false;
        }
        return true;
      }
      // 각 컨트롤을 검사하는 함수들
      function checkUserId(uid, ctrl) {
        // 입력 받는 아이디값을 검사하는 함수
        if (!checkGap(uid, "아이디를", ctrl)) {
          return false;
        }
        const idRegExp = /^[a-zA-z0-9]{4,16}$/;
        if (!idRegExp.test(uid)) {
          alert("아이디는 영문 대소문자와 숫자 4~16자리로 입력해야합니다!");
          frmJoin.id.value = "";
          frmJoin.id.focus();
          return false;
        }
        return true;
      }
      function checkUserPwd(pwd, ctrl, chkpwd, uid) {
        if (!checkGap(pwd, "비밀번호를", ctrl)) {
          return false;
        }
        if (!checkGap(chkpwd, "비밀번호 확인을", ctrl)) {
          return false;
        }
        const password1RegExp = /^[a-zA-z0-9]{4,16}$/; //비밀번호 유효성 검사
        if (!password1RegExp.test(pwd)) {
          alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
          frmJoin.pwd.value = "";
          frmJoin.pwd.focus();
          return false;
        }
        if (pwd != chkpwd) {
          alert("두 비밀번호가 일치하지 않습니다.");
          frmJoin.chkpwd.value = "";
          frmJoin.chkpwd.focus();
          return false;
        }
        if (pwd == uid) {
          alert("아이디와 비밀번호는 같을 수 없습니다.");
          frmJoin.pwd.value = "";
          frmJoin.chkpwd.value = "";
          frmJoin.pwd.focus();
          return false;
        }
        return true;
      }
      function checkUserName(name, ctrl) {
        if (!checkGap(name, "이름을", ctrl)) {
          return false;
        }
        const nameRegExp = /^[가-힣]{2,4}$/;
        if (!nameRegExp.test(name)) {
          alert("이름이 올바르지 않습니다.");
          ctrl.value = "";
          ctrl.focus();
          return false;
        }
        return true;
      }
      function checkUserGender(choGender) {
        let isChkCnt = false; //flag기법 어떤 조건에 대한 실행을 논리값으로 구분하여 동작을 나눔
        for (let i = 0; i < choGender.length; i++) {
          if (choGender[i].checked == true) {
            isChkCnt = true;
          }
        }
        if (isChkCnt == false) {
          alert("성별을 선택해주세요.");
          choGender[0].focus();
          return false;
        }
        return true;
      }
      function checkUserPhone(p1, p2, pctrl1, pctrl2) {
        if (p1.length != 4 || p2.length != 4) {
          alert("전화번호 4자리를 정확히 입력해주세요.");
          p1 = "";
          p2 = "";
          pctrl1.focus();
          return false;
        }
        return true;
      }
      function checkUserEmail(e) {
        if (e.indexOf("@") == -1 || e.indexOf(".") == -1) {
          alert("잘못된 이메일 형식입니다.");
          frmJoin.email.value = "";
          frmJoin.email.focus();
          return false;
        }
        return true;
      }
    </script>
  </head>
  <body>
    <div class="container">
      <header class="header">
        <div class="topMenu">
          <div class="box left">
            <a href="login_view.login"><span>LOGIN</span></a>
            <div class="line"><div class="lineItem"></div></div>
            <a href="#"><span>JOIN</span></a>
          </div>
          <div class="box right">
            <a href="#"
              ><span><i class="fas fa-shopping-cart"></i></span
            ></a>
            <div class="line"><div class="lineItem"></div></div>
            <a href="#"
              ><span><i class="fas fa-search"></i></span
            ></a>
          </div>
        </div>
        <div class="logoBox">
          <a href="index_view.main">
            <img
              src="./images/포에트리 가든.png"
              alt="메인로고"
              width="406px"
              height="73px"
              id="logoImg"
            />
          </a>
        </div>
      </header>
      <nav class="gnb">
        <div class="list cata">
        <div class="menuTitle" onclick="location.href='pdt_list.pdt';">SHOP</div>
          <div class="menuTitle">POST</div>
          <div class="menuTitle" id="effCancle">CENTER</div>
        </div>
        <div class="slideShow">
          <div class="subMenu">
            <div class="frt Title">
              <ul class="frt SuvMenu">
                <li>PLANTS</li>
                <li>PLANT+POT</li>
                <li>POTS</li>
                <li>OTHER</li>
              </ul>
            </div>
            <div class="sec Title">
              <ul class="secc SuvMenu">
                <li>POST</li>
              </ul>
            </div>
            <div class="thd Title">
              <ul class="trd SuvMenu">
                <li>NOTICE</li>
                <li>REVIEW</li>
                <li>Q&N</li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
      <div class="formContainer">
        <form name="frmJoin" action="join_proc.join" method="post">
          <input type="hidden" name="idChk" id="idChk" value="N" />
          <div class="subWrap">
            <div class="txtId">
              <!-- <span class="spanBox">아이디</span> -->
              <input
                type="text"
                name="id"
                size="45"
                maxlength="16"
                class="sameCtr"
                placeholder="아이디 (영소문자/숫자,4~16자)"
                autocomplete="off"
                id="uid"
              />
            </div>
            <div class="txtPwd">
              <!-- <span class="spanBox">비밀번호</span> -->
              <input
                type="password"
                name="pwd"
                size="45"
                maxlength="16"
                class="sameCtr"
                id="pw"
                placeholder="비밀번호"
              />
            </div>
            <div class="chkPwd">
              <!-- <span class="spanBox">비밀번호확인</span> -->
              <input
                type="password"
                name="chkpwd"
                size="45"
                maxlength="16"
                class="sameCtr"
                id="cpw"
                placeholder="비밀번호확인"
              />
            </div>
            <span
              class="ctrName"
              style="display: block; margin-top: 10px; margin-bottom: 10px"
              >이름<span style="color: red">*</span></span
            >
            <div class="txtName">
              <!-- <span class="spanBox">이름</span> -->
              <input
                type="text"
                name="name"
                size="45"
                class="sameCtr"
                id="nm"
                placeholder="이름"
                autocomplete="off"
              />
            </div>
            <span class="ctrName" style="display: block; margin-top: 10px"
              >성별<span style="color: red">*</span></span
            >
            <div class="choGender">
              <!-- <span class="spanBox">성별</span> -->
              남자
              <input
                type="radio"
                name="radio"
                size="45"
                class="sameCtr"
                id="rdo1"
                value="M"
              />
              &nbsp;&nbsp;&nbsp; 여자
              <input
                type="radio"
                name="radio"
                size="45"
                class="sameCtr"
                id="rdo2"
                value="W"
              />
            </div>
            <span class="ctrName" style="display: block; margin-bottom: 10px"
              >생년월일<span style="color: red">*</span></span
            >
            <div class="txtbirth">
              <!-- <span class="spanBox">생년월일</span> -->
              <div class="sameCtr" id="bmd">
                <select name="yearbox" id="yearbox">
                  <option value="">년</option>
                  <!-- 1900 ~ 2021 -->
                </select>
                <select name="mthbox" id="month">
                  <option value="">월</option>
                </select>
                <select name="daybox" id="day">
                  <option value="" class="op">일</option>
                </select>
                <!-- 년도에 따른 일수 계산을 해서 찍어주기 -->
              </div>
            </div>
            <span class="ctrName" style="display: block; margin-bottom: 10px"
              >연락처</span
            >
            <div class="txtPhone">
              <!-- <span class="spanBox">휴대폰</span> -->
              <div class="sameCtr" id="pho">
                <select name="phbox" id="phbox">
                  <option value="010" class="op">010</option>
                  <option value="010" class="op">011</option>
                  <option value="010" class="op">019</option>
                </select>
                -
                <input
                  type="text"
                  size="6"
                  class="pxt"
                  name="secnumber"
                  id="phtxt2"
                  maxlength="4"
                  onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"
                />
                -
                <input
                  type="text"
                  size="6"
                  class="pxt"
                  name="trdnumber"
                  id="phtxt3"
                  maxlength="4"
                  onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"
                />
              </div>
            </div>
            <span class="ctrName" style="display: block; margin-bottom: 10px"
              >주소<span style="color: red">*</span></span
            >
            <div class="zip">
              <!-- <span class="spanBox">우편번호</span> -->
              <input
                type="text"
                size="6"
                class="zipNum"
                name="secnumber"
                id="postcode"
                maxlength="4"
                readonly
              />

              &nbsp;&nbsp;
              <button
                type="button"
                class="zipFindBtn"
                onclick="execDaumPostcode()"
              >
                우편번호
              </button>
            </div>
            <div class="addrBox1">
              <input
                type="text"
                name="email"
                size="45"
                class="addr"
                id="address"
                placeholder="주소"
                autocomplete="off"
                readonly
              />
            </div>
            <div class="addrBox2">
              <input
                type="text"
                name="email"
                size="45"
                class="addr"
                placeholder="상세주소"
                autocomplete="off"
                required
              />
            </div>
            <span class="ctrName" style="display: block; margin-bottom: 10px"
              >이메일<span style="color: red">*</span></span
            >
            <div class="txtEmail">
              <!-- <span class="spanBox">이메일</span> -->
              <input
                type="text"
                name="email"
                size="45"
                class="sameCtr"
                id="ema"
                placeholder="이메일"
                autocomplete="off"
              />
            </div>
          </div>
          <div class="btnBox">
            <button
              type="submit"
              id="btnGap"
              class="btnSize"
              name="joinBtn"
              onclick="checkAll();"
            >
              회원가입
            </button>
          </div>
        </form>
      </div>
       <footer>
     	<div class="footer">
     		<p>
     		<strong>Poetry garden(포에트리 가든)</strong>
     		<br>
     		Company: 포에트리가든 | 대표자: 홍길동
     		<br>
     		Addr: 서울시 마포구  26길 18-4(픽업 예약방문)
     		</p>
     		<p>
     		E-mail: gksdidwnd91@naver.com
     		<br>
     		CS: 010-3322-5232 (AM.10 ~ PM.6 주말 및 공휴일 휴무)
     		</p>
     		이용약관ㆍ개인정보처리방침
     	</div>
     </footer>
    </div>
    <script>
      const yearbox = document.getElementById("yearbox");
      yearbox.addEventListener(
        "click",
        () => {
          let startYear = 1900;
          let i = 0;
          let yearCnt = 121; // 콤보박스에 출력할 옵션의 초기 옵션의 갯수
          const date = new Date(); // 년도를 찾기위해 date객체의 인스턴스 생성
          let curYear = date.getFullYear(); // 현재 년도를 구하여 저장
          // let cata1 = obj;

          if (curYear < curYear + 1) {
            yearCnt += 1;
            while (i < yearCnt) {
              i++;
              yearbox.options[i] = new Option(startYear, startYear);
              startYear++;
            }
          }
        },
        { once: true }
      );
    </script>
    <script>
      // 월(1~12)별 일수를 콤보박스의 옵션으로 나열하여 보여주기
      // 1.월에 따라서 조작됨
      // 2.월을 기준으로 조건을 주고 루프를 돌려서 해당 월에 대한 일수를 콤보박스의 옵션으로 찍어주기
      // 일단 월을 갖고 작업을 시작한다
      const year = document.getElementById("yearbox");
      const month = document.getElementById("month");
      const monthOfdate = document.getElementById("day");

      let checkYear = year.selectedIndex;
      let checkMonth = month.selectedIndex;
      let setOfYear,
        setOfMonth = null;
      //블록 바깥에 선언함 전역변수

      function setYear(y) {
        setOfYear = year.options[y].value;
      }
      function getYear() {
        return setOfYear;
      }
      function setMonth(m) {
        setOfMonth = month.options[m].value;
      }
      function getMonth() {
        return setOfMonth;
      }
      function fn_DayOfMonth(a, b) {
        //month 는 0 부터 시작해서..
        return 32 - new Date(a, b - 1, 32).getDate();
      }
      year.addEventListener("change", () => {
        if (year.selectedIndex) {
          setYear(year.selectedIndex); //현재 선택한 년도의 인덱스값을 세팅함(그 값이 setOfYear에 저장됨)
          let mthCnt = 1;
          for (let i = 1; i <= 12; i++) {
            month.options[i] = new Option(mthCnt, mthCnt);
            mthCnt++;
          }
        }
      });
      month.addEventListener(
        "change",
        () => {
          // 루프안에 조건을 넣어 그 조건에 맞는 옵션이 자동으로 배열로 만들어지게끔
          // 그 특정 월을 기준으로 그 월에 대한 옵션을 생성하여 보여주기
          // 일단 년도 월을 세팅한 다음에 다시 년도를 다른 년도로 바꾸면 월은 변함없고 다시 월에 대한 일수를 출력해줘야함...

          //for(let i = 1; i < month.options.length ; i++){
          if (month.selectedIndex) {
            // 월에 대한 콤보박스에서 옵션을 선택했다면
            // 현재 선택한 옵션의 인덱스와 특정 인덱스에 대한 옵션의 값이 같으면
            //const day = new Date(, month.options[month.selectedIndex].value);
            // 현재 선택된 년도랑 월에 대하여 인스턴스를 초기화함
            setMonth(month.selectedIndex);
            let dayCnt = 1;
            for (let j = 1; j <= fn_DayOfMonth(getYear(), getMonth()); j++) {
              // 두번째 콤보박스의 옵션을 생성하기위한 루프
              // 특정 달을 기준으로 3월을 선택하면 그 3월에 대한 일이 쫙 나오게

              // new Date()에서 Date()생성자함수에 매개변수로 특정값을 넣어서 특정값에대한 데이터를 추출했는데
              // 그 특정값을 변수로 받아 집어넣어보자
              // new Date(selectYear,selectMonth)
              // 현재 선택된 년도랑 선택된 월
              monthOfdate.options[j] = new Option(dayCnt, dayCnt);
              ++dayCnt;
            }
          }
        }
        //}
      );
    </script>
  </body>
  <script src="js/jquery-3.5.1.js"></script>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    /** 우편번호 찾기 */
    function execDaumPostcode() {
      daum.postcode.load(function () {
        new daum.Postcode({
          oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            $("#postcode").val(data.zonecode);
            $("#address").val(data.roadAddress);
          },
        }).open();
      });
    }
  </script>
</html>
