<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
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
       
        padding-left: 50px;
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
      .agree {
        margin-top: 40px;
      }
      .agreeBox1 {
        border: 1px solid black;
        border-bottom: none;
        width: 900px;
        height: 55px;
        /* margin: 0 auto; */
      }
      .agreeBox2 {
        border: 1px solid black;
        border-bottom: none;
        width: 900px;
        height: 200px;
        /* margin: 0 auto; */
      }
      .agreeBox3 {
        border: 1px solid black;
        border-bottom: none;
        width: 900px;
        height: 200px;
        /* margin: 0 auto; */
      }
      .agreeBox4 {
        border: 1px solid black;
        width: 900px;
        height: 200px;
        /* margin: 0 auto; */
      }
      .agrTxt {
        line-height: 1.5;
        margin-top: 20px;
        height: 140.5px;
        border-top: 1px solid black;
        padding: 20px;
        font-size: 14px;
        overflow: auto;
      }
      .joinbtn {
        width: 898px;
        text-align: center;
        margin-top: 50px;
      }
      #joinBtn {
        width: 300px;
        height: 50px;
        font-size: 24px;
        background-color: black;
        color: #ffffff;
        border: none;
        cursor: pointer;
        margin-bottom: 60px;
      }
      #cancleBtn {
        width: 300px;
        height: 50px;
        font-size: 24px;
        background-color: black;
        color: #ffffff;
        border: none;
        cursor: pointer;
        margin-bottom: 60px;
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
      function join() {
        var agreeChk1 = document.getElementById("chk1").checked;
        var agreeChk2 = document.getElementById("chk2").checked;
        var agreeChk3 = document.getElementById("chk3").checked;

        if (!agreeChk1) {
          alert("필수항목을 체크해주세요");
          return;
        }
        if (!agreeChk2) {
          alert("필수항목을 체크해주세요");
          return;
        }
        if (!agreeChk3) {
          alert("필수항목을 체크해주세요");
          return;
        }
        location.href="join_form.join";
      }
      function agreeChk() {
        var arrChk = document.logForm.agrchk;
        for (var i = 0; i < arrChk.length; i++) {
          arrChk[i].checked = all.checked;
        }
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
            <a href="join_view.join"><span>JOIN</span></a>
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
      <div class="loginContainer">
        <div class="loginBox">
          <h1>Terms & Policy</h1>
          <div class="lineBar"></div>
          <form action="join_form.join" method="POST" name="logForm">
            <div class="agree">
              <div class="agreeBox1">
                <input
                  style="zoom: 2; margin-top: 7px"
                  type="checkbox"
                  class="checkbox"
                  name="all"
                  id="all"
                  onclick="agreeChk(this);"
                /><span class="agrTitle" style="vertical-align: 7px"
                  >모든 항목에 동의합니다.</span
                >
              </div>
              <div class="agreeBox2">
                <input
                  style="
                    zoom: 2;
                    position: relative;
                    top: 5px;
                    vertical-align: 1px;
                  "
                  type="checkbox"
                  class="checkbox"
                  name="agrchk"
                  id="chk1"
                />[개인정보 수집 및 이용 동의]에 동의합니다. (필수)
                <div class="agrTxt">
                  ③ '비회원'은 회원으로 가입하지 않고 회사가 제공하는
                  온라인스토어를 이용하는 자를 말합니다. ④ '이용자'는
                  온라인스토어에 접속하여 본 약관에 따라 회사가 제공하는
                  온라인스토어 서비스를 받는 회원과 비회원을 말합니다. ⑤ 'ID'는
                  회원을 식별하고 온라인스토어 이용을 위하여 회사가 설정한
                  기준에 따라 회원 본인이 정하고 회사가 승인한 문자열을
                  말합니다. ⑥ '비밀번호'는 ID와 함께 회원 본인 확인 및 안전한
                  온라인스토어 이용을 위하여 회사가 설정한 기준에 따라 회원
                  본인이 정하고 회사가 승인한 문자열을 말합니다. 제3조 (약관의
                  게시와 변경) ① 회사는 본 약관의 내용과 상호, 대표자 성명,
                  영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를
                  포함) 전화번호, 이메일주소, 호스팅서비스 사업자,
                  사업자등록번호, 통신판매업신고번호, 개인정보보호책임자 등을
                  이용자가 쉽게 알 수 있도록 온라인스토어의 초기화면에
                  게시합니다. 다만, 회사는 이용자가 본 약관의 내용을 초기화면의
                  연결화면을 통하여 볼 수 있도록 할 수 있습니다. ② 회사는
                  이용자가 본 약관에 동의하기에 앞서 본 약관에 정해져 있는 내용
                  중 청약철회, 배송책임, 환불조건 등과 같은 중요한 내용을
                  이용자가 이해할 수 있도록 별도의 연결화면 또는 팝업화면 등을
                  제공하여 이용자의 확인을 구하여야 합니다. ※ 청약철회, 배송,
                  환불에 대한 안내 보기 ③ 회사는「전자상거래 등에서의
                  소비자보호에 관한 법률」, 「약관의 규제에 관한 법률」,
                  「전자문서 및 전자거래기본법」, 「전자금융거래법」,
                  「전자서명법」, 「정보통신망 이용촉진 및 정보보호 등에 관한
                  법률」, 「방문판매 등에 관한 법률」, 「소비자기본법」 등 관련
                  법을 위배하지 않는 범위에서 본 약관을 개정할 수 있습니다. ④
                  회사는 본 약관을 개정할 경우에는 적용일자 및 개정사유를
                  명시하여 현행약관과 함께 온라인스토어의 초기화면에 그 적용일
                  7일 이전부터 적용일자 전일까지 공지합니다. 다만, 이용자에게
                  불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전
                  유예기간을 두고 공지합니다. 이 경우 회사는 개정전 내용과
                  개정후 내용을 명확하게 비교하여 이용자가 알기 쉽도록
                  표시합니다. ⑤ 변경된 약관 조항 중 상품의 구매계약에 관한
                  조항은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에
                  이미 체결된 계약에 대해서는 변경 전의 조항이 그대로
                  적용됩니다. 다만, 이미 상품의 구매계약을 체결한 이용자가
                  변경된 조항의 적용을 받기를 원하는 뜻을 상기 제4항에 의한
                  변경약관의 공지기간 내에 회사에 고지하여 회사의 동의를 받은
                  경우에는 변경된 조항이 적용됩니다. ⑥ 회사가 개정약관을 공지
                  또는 통지하면서 회원에게 일정기간 내에 개정약관에 대한 특별한
                  의사표시를 하지 않으면 동의한 것으로 본다는 뜻을 명확하게 따로
                  공지 또는 고지하였음에도 회원이 명시적으로 거부의사를 표시하지
                  아니한 경우 회원이 개정약관에 동의한 것으로 봅니다. 또한
                  회원이 개정약관의 적용에 동의하지 않는 경우 회사는 개정약관의
                  내용을 적용할 수 없으며, 이 경우, 회원은 본 약관을 통한
                  이용계약을 해지할 수 있습니다. 다만, 기존약관을 적용할 수 없는
                  특별한 사정이 있는 경우에는 회사는 본 약관을 통한 이용계약을
                  해지할 수 있습니다. ⑦ 본 약관에서 정하지 아니한 내용과 본
                  약관의 해석에 관하여는「전자상거래 등에서의 소비자보호에 관한
                  법률」, 「약관의 규제에 관한 법률」, 공정거래위원회가 정하는
                  「전자상거래 등에서의 소비자보호 지침」 및 관계법령 또는
                  상관례에 따릅니다. 제4조 (온라인스토어 서비스의 제공 및 변경)
                  ① 회사는 다음과 같은 서비스를 제공합니다. 1. 상품 또는 용역에
                  대한 정보 제공 및 구매계약의 체결 2. 구매계약이 체결된 상품
                  또는 용역의 배송 3. 회원제 온라인스토어 4. 기타 회사가 정하는
                  업무 ② 회사는 상품이 품절되거나 기술적 사양의 변경 등으로 더
                  이상 제공할 수 없는 경우에는 장차 체결되는 계약에 의해 제공할
                  상품의 내용을 변경할 수 있습니다. 이 경우에는 변경된 상품의
                  내용 및 제공일자를 명시하여 현재의 상품의 내용을 게시한 곳
                  혹은 이용자가 알기 쉬운 곳에 즉시 공지합니다. ③ 회사가 본
                  약관을 통하여 이용자에게 제공하기로 한 상품이 품절 또는 기타
                  관리적, 기술적 사유로 변경할 경우에는 그 사유를 이용자에게 본
                  약관 제8조에서 정한 방법으로 즉시 통지합니다. 제5조
                  (온라인스토어의 중단) ① 회사는 컴퓨터 등 전기통신설비의
                  보수점검·교체 및 고장, 통신의 두절 등의 사유가 발생한 경우,
                  또는 온라인스토어의 운영과 관련하여 회사가 판단한 관리적,
                  기술적 필요에 있는 경우, 온라인스토어의 제공을 일시적 혹은
                  영구적으로 중단할 수 있습니다. ② 제1항에 의한 온라인스토어
                  중단이 발생하는 경우, 회사는 제8조에 정한 방법으로 해당 사실을
                  이용자에게 통지합니다. 제6조 (회원가입) ① 이용자는 무료로
                  회원으로 가입할 수 있으며, 회사가 정한 가입 양식에 회원정보를
                  기입한 후 본 약관과 개인정보의 수집, 제공 및 활용에 동의한다는
                  의사표시를 함으로서 회원가입을 신청합니다. ②
                </div>
              </div>
              <div class="agreeBox3">
                <input
                  style="
                    zoom: 2;
                    position: relative;
                    top: 5px;
                    vertical-align: 1px;
                  "
                  type="checkbox"
                  class="checkbox"
                  name="agrchk"
                  id="chk2"
                />[개인정보 수집 및 이용 동의]에 동의합니다. (필수)
                <div class="agrTxt">
                  ③ '비회원'은 회원으로 가입하지 않고 회사가 제공하는
                  온라인스토어를 이용하는 자를 말합니다. ④ '이용자'는
                  온라인스토어에 접속하여 본 약관에 따라 회사가 제공하는
                  온라인스토어 서비스를 받는 회원과 비회원을 말합니다. ⑤ 'ID'는
                  회원을 식별하고 온라인스토어 이용을 위하여 회사가 설정한
                  기준에 따라 회원 본인이 정하고 회사가 승인한 문자열을
                  말합니다. ⑥ '비밀번호'는 ID와 함께 회원 본인 확인 및 안전한
                  온라인스토어 이용을 위하여 회사가 설정한 기준에 따라 회원
                  본인이 정하고 회사가 승인한 문자열을 말합니다. 제3조 (약관의
                  게시와 변경) ① 회사는 본 약관의 내용과 상호, 대표자 성명,
                  영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를
                  포함) 전화번호, 이메일주소, 호스팅서비스 사업자,
                  사업자등록번호, 통신판매업신고번호, 개인정보보호책임자 등을
                  이용자가 쉽게 알 수 있도록 온라인스토어의 초기화면에
                  게시합니다. 다만, 회사는 이용자가 본 약관의 내용을 초기화면의
                  연결화면을 통하여 볼 수 있도록 할 수 있습니다. ② 회사는
                  이용자가 본 약관에 동의하기에 앞서 본 약관에 정해져 있는 내용
                  중 청약철회, 배송책임, 환불조건 등과 같은 중요한 내용을
                  이용자가 이해할 수 있도록 별도의 연결화면 또는 팝업화면 등을
                  제공하여 이용자의 확인을 구하여야 합니다. ※ 청약철회, 배송,
                  환불에 대한 안내 보기 ③ 회사는「전자상거래 등에서의
                  소비자보호에 관한 법률」, 「약관의 규제에 관한 법률」,
                  「전자문서 및 전자거래기본법」, 「전자금융거래법」,
                  「전자서명법」, 「정보통신망 이용촉진 및 정보보호 등에 관한
                  법률」, 「방문판매 등에 관한 법률」, 「소비자기본법」 등 관련
                  법을 위배하지 않는 범위에서 본 약관을 개정할 수 있습니다. ④
                  회사는 본 약관을 개정할 경우에는 적용일자 및 개정사유를
                  명시하여 현행약관과 함께 온라인스토어의 초기화면에 그 적용일
                  7일 이전부터 적용일자 전일까지 공지합니다. 다만, 이용자에게
                  불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전
                  유예기간을 두고 공지합니다. 이 경우 회사는 개정전 내용과
                  개정후 내용을 명확하게 비교하여 이용자가 알기 쉽도록
                  표시합니다. ⑤ 변경된 약관 조항 중 상품의 구매계약에 관한
                  조항은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에
                  이미 체결된 계약에 대해서는 변경 전의 조항이 그대로
                  적용됩니다. 다만, 이미 상품의 구매계약을 체결한 이용자가
                  변경된 조항의 적용을 받기를 원하는 뜻을 상기 제4항에 의한
                  변경약관의 공지기간 내에 회사에 고지하여 회사의 동의를 받은
                  경우에는 변경된 조항이 적용됩니다. ⑥ 회사가 개정약관을 공지
                  또는 통지하면서 회원에게 일정기간 내에 개정약관에 대한 특별한
                  의사표시를 하지 않으면 동의한 것으로 본다는 뜻을 명확하게 따로
                  공지 또는 고지하였음에도 회원이 명시적으로 거부의사를 표시하지
                  아니한 경우 회원이 개정약관에 동의한 것으로 봅니다. 또한
                  회원이 개정약관의 적용에 동의하지 않는 경우 회사는 개정약관의
                  내용을 적용할 수 없으며, 이 경우, 회원은 본 약관을 통한
                  이용계약을 해지할 수 있습니다. 다만, 기존약관을 적용할 수 없는
                  특별한 사정이 있는 경우에는 회사는 본 약관을 통한 이용계약을
                  해지할 수 있습니다. ⑦ 본 약관에서 정하지 아니한 내용과 본
                  약관의 해석에 관하여는「전자상거래 등에서의 소비자보호에 관한
                  법률」, 「약관의 규제에 관한 법률」, 공정거래위원회가 정하는
                  「전자상거래 등에서의 소비자보호 지침」 및 관계법령 또는
                  상관례에 따릅니다. 제4조 (온라인스토어 서비스의 제공 및 변경)
                  ① 회사는 다음과 같은 서비스를 제공합니다. 1. 상품 또는 용역에
                  대한 정보 제공 및 구매계약의 체결 2. 구매계약이 체결된 상품
                  또는 용역의 배송 3. 회원제 온라인스토어 4. 기타 회사가 정하는
                  업무 ② 회사는 상품이 품절되거나 기술적 사양의 변경 등으로 더
                  이상 제공할 수 없는 경우에는 장차 체결되는 계약에 의해 제공할
                  상품의 내용을 변경할 수 있습니다. 이 경우에는 변경된 상품의
                  내용 및 제공일자를 명시하여 현재의 상품의 내용을 게시한 곳
                  혹은 이용자가 알기 쉬운 곳에 즉시 공지합니다. ③ 회사가 본
                  약관을 통하여 이용자에게 제공하기로 한 상품이 품절 또는 기타
                  관리적, 기술적 사유로 변경할 경우에는 그 사유를 이용자에게 본
                  약관 제8조에서 정한 방법으로 즉시 통지합니다. 제5조
                  (온라인스토어의 중단) ① 회사는 컴퓨터 등 전기통신설비의
                  보수점검·교체 및 고장, 통신의 두절 등의 사유가 발생한 경우,
                  또는 온라인스토어의 운영과 관련하여 회사가 판단한 관리적,
                  기술적 필요에 있는 경우, 온라인스토어의 제공을 일시적 혹은
                  영구적으로 중단할 수 있습니다. ② 제1항에 의한 온라인스토어
                  중단이 발생하는 경우, 회사는 제8조에 정한 방법으로 해당 사실을
                  이용자에게 통지합니다. 제6조 (회원가입) ① 이용자는 무료로
                  회원으로 가입할 수 있으며, 회사가 정한 가입 양식에 회원정보를
                  기입한 후 본 약관과 개인정보의 수집, 제공 및 활용에 동의한다는
                  의사표시를 함으로서 회원가입을 신청합니다. ②
                </div>
              </div>
              <div class="agreeBox4">
                <input
                  style="
                    zoom: 2;
                    position: relative;
                    top: 5px;
                    vertical-align: 1px;
                  "
                  type="checkbox"
                  class="checkbox"
                  name="agrchk"
                  id="chk3"
                />[개인정보 수집 및 이용 동의]에 동의합니다. (필수)
                <div class="agrTxt">
                  ③ '비회원'은 회원으로 가입하지 않고 회사가 제공하는
                  온라인스토어를 이용하는 자를 말합니다. ④ '이용자'는
                  온라인스토어에 접속하여 본 약관에 따라 회사가 제공하는
                  온라인스토어 서비스를 받는 회원과 비회원을 말합니다. ⑤ 'ID'는
                  회원을 식별하고 온라인스토어 이용을 위하여 회사가 설정한
                  기준에 따라 회원 본인이 정하고 회사가 승인한 문자열을
                  말합니다. ⑥ '비밀번호'는 ID와 함께 회원 본인 확인 및 안전한
                  온라인스토어 이용을 위하여 회사가 설정한 기준에 따라 회원
                  본인이 정하고 회사가 승인한 문자열을 말합니다. 제3조 (약관의
                  게시와 변경) ① 회사는 본 약관의 내용과 상호, 대표자 성명,
                  영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를
                  포함) 전화번호, 이메일주소, 호스팅서비스 사업자,
                  사업자등록번호, 통신판매업신고번호, 개인정보보호책임자 등을
                  이용자가 쉽게 알 수 있도록 온라인스토어의 초기화면에
                  게시합니다. 다만, 회사는 이용자가 본 약관의 내용을 초기화면의
                  연결화면을 통하여 볼 수 있도록 할 수 있습니다. ② 회사는
                  이용자가 본 약관에 동의하기에 앞서 본 약관에 정해져 있는 내용
                  중 청약철회, 배송책임, 환불조건 등과 같은 중요한 내용을
                  이용자가 이해할 수 있도록 별도의 연결화면 또는 팝업화면 등을
                  제공하여 이용자의 확인을 구하여야 합니다. ※ 청약철회, 배송,
                  환불에 대한 안내 보기 ③ 회사는「전자상거래 등에서의
                  소비자보호에 관한 법률」, 「약관의 규제에 관한 법률」,
                  「전자문서 및 전자거래기본법」, 「전자금융거래법」,
                  「전자서명법」, 「정보통신망 이용촉진 및 정보보호 등에 관한
                  법률」, 「방문판매 등에 관한 법률」, 「소비자기본법」 등 관련
                  법을 위배하지 않는 범위에서 본 약관을 개정할 수 있습니다. ④
                  회사는 본 약관을 개정할 경우에는 적용일자 및 개정사유를
                  명시하여 현행약관과 함께 온라인스토어의 초기화면에 그 적용일
                  7일 이전부터 적용일자 전일까지 공지합니다. 다만, 이용자에게
                  불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전
                  유예기간을 두고 공지합니다. 이 경우 회사는 개정전 내용과
                  개정후 내용을 명확하게 비교하여 이용자가 알기 쉽도록
                  표시합니다. ⑤ 변경된 약관 조항 중 상품의 구매계약에 관한
                  조항은 그 적용일자 이후에 체결되는 계약에만 적용되고 그 이전에
                  이미 체결된 계약에 대해서는 변경 전의 조항이 그대로
                  적용됩니다. 다만, 이미 상품의 구매계약을 체결한 이용자가
                  변경된 조항의 적용을 받기를 원하는 뜻을 상기 제4항에 의한
                  변경약관의 공지기간 내에 회사에 고지하여 회사의 동의를 받은
                  경우에는 변경된 조항이 적용됩니다. ⑥ 회사가 개정약관을 공지
                  또는 통지하면서 회원에게 일정기간 내에 개정약관에 대한 특별한
                  의사표시를 하지 않으면 동의한 것으로 본다는 뜻을 명확하게 따로
                  공지 또는 고지하였음에도 회원이 명시적으로 거부의사를 표시하지
                  아니한 경우 회원이 개정약관에 동의한 것으로 봅니다. 또한
                  회원이 개정약관의 적용에 동의하지 않는 경우 회사는 개정약관의
                  내용을 적용할 수 없으며, 이 경우, 회원은 본 약관을 통한
                  이용계약을 해지할 수 있습니다. 다만, 기존약관을 적용할 수 없는
                  특별한 사정이 있는 경우에는 회사는 본 약관을 통한 이용계약을
                  해지할 수 있습니다. ⑦ 본 약관에서 정하지 아니한 내용과 본
                  약관의 해석에 관하여는「전자상거래 등에서의 소비자보호에 관한
                  법률」, 「약관의 규제에 관한 법률」, 공정거래위원회가 정하는
                  「전자상거래 등에서의 소비자보호 지침」 및 관계법령 또는
                  상관례에 따릅니다. 제4조 (온라인스토어 서비스의 제공 및 변경)
                  ① 회사는 다음과 같은 서비스를 제공합니다. 1. 상품 또는 용역에
                  대한 정보 제공 및 구매계약의 체결 2. 구매계약이 체결된 상품
                  또는 용역의 배송 3. 회원제 온라인스토어 4. 기타 회사가 정하는
                  업무 ② 회사는 상품이 품절되거나 기술적 사양의 변경 등으로 더
                  이상 제공할 수 없는 경우에는 장차 체결되는 계약에 의해 제공할
                  상품의 내용을 변경할 수 있습니다. 이 경우에는 변경된 상품의
                  내용 및 제공일자를 명시하여 현재의 상품의 내용을 게시한 곳
                  혹은 이용자가 알기 쉬운 곳에 즉시 공지합니다. ③ 회사가 본
                  약관을 통하여 이용자에게 제공하기로 한 상품이 품절 또는 기타
                  관리적, 기술적 사유로 변경할 경우에는 그 사유를 이용자에게 본
                  약관 제8조에서 정한 방법으로 즉시 통지합니다. 제5조
                  (온라인스토어의 중단) ① 회사는 컴퓨터 등 전기통신설비의
                  보수점검·교체 및 고장, 통신의 두절 등의 사유가 발생한 경우,
                  또는 온라인스토어의 운영과 관련하여 회사가 판단한 관리적,
                  기술적 필요에 있는 경우, 온라인스토어의 제공을 일시적 혹은
                  영구적으로 중단할 수 있습니다. ② 제1항에 의한 온라인스토어
                  중단이 발생하는 경우, 회사는 제8조에 정한 방법으로 해당 사실을
                  이용자에게 통지합니다. 제6조 (회원가입) ① 이용자는 무료로
                  회원으로 가입할 수 있으며, 회사가 정한 가입 양식에 회원정보를
                  기입한 후 본 약관과 개인정보의 수집, 제공 및 활용에 동의한다는
                  의사표시를 함으로서 회원가입을 신청합니다. ②
                </div>
              </div>
              <div class="joinbtn">
                <button type="button" id="cancleBtn" onclick="history.back();">
                  취소
                </button>
                <button type="button" id="joinBtn" onclick="join();">
                  회원가입
                </button>
              </div>
            </div>
            <!-- agree -->
          </form>
        </div>
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
  </body>
</html>
