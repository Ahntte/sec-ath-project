<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="java.util.*"%>
<%
request.setCharacterEncoding("utf-8");
MemberInfo loginMember = (MemberInfo)session.getAttribute("loginMember");
ArrayList<PdtInfo> pdtSearchList = (ArrayList<PdtInfo>)request.getAttribute("pdtSearchList");
//회원이 보는 상품정보는 회원 로그인 유무와는 상관없이 보이는거임 누구에게나 
PdtPageInfo pdtSearchPage = (PdtPageInfo)request.getAttribute("pageInfo");
%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>포에트리가든</title>
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
        cursor: pointer;
        font-family: "Montserrat", sans-serif;
      }
      .effCancle {
        margin-right: 0px;
      }
	.bestContainer { 
	width: 100%;
	height:auto;
	background-color: #fcfafa;
	}
	.mainWrap h1{
	margin: 50px 50px;
	}
	.bestWrap { 
	margin: 0 auto;
	width: 1200px; 
	height: auto; 
	display: flex;
	flex-direction: row;
	flex-wrap: no-wrap;
	justify-content: flex-start;
	align-items: center;
	 }
	.bestItem { 
	width: 400px;
	height: 500px;
	  }
	.fntCenter{
	text-align: center;
	}
	.bestItem:nth-child(2){
	margin-left:10px;
	margin-right:10px;
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
      .SuvMenu li {
      	cursor:pointer;
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
      .mainContainer {
        width:auto;
        height: 80px;
        background-color: #fcfafa;
        margin-top: 55px;
      }
      .mainContents {
        margin-top: 13px;
        text-align: center;
        font-size: 45px;
        font-weight: 600;
      }
      .modalBackground {
        position: fixed;
	    top:0; left: 0; bottom: 0; right: 0;
        background: rgba(0, 0, 0, 0.8);
        display:none;
      }
      .modalBox {
       position: absolute;
	   top: calc(50vh - 100px); 
	   left: calc(50vw - 200px);
	   background-color: white;
	   display: flex; 
	   justify-content: center;
	   align-items: center;
	   border-radius: 10px;
	   width: 400px;
	   height: 200px;
      }
      input[type="text"] {
      -moz-appearance: none;
	  -webkit-appearance: none;
	  appearance: none;
	  border: none;
	  width: 250px;
	  height:50px;
	  border-bottom:1px solid black;
	  font-size: 20px;
      }
      button[type="submit"]{
      -moz-appearance: none;
	  -webkit-appearance: none;
	  appearance: none;
	  width: 50px;
	  height:50px;
	  font-size: 15px;
	  font-weight: 700;
	  background-color: #ffffff;
	  border: none;
	  cursor:pointer
      }
      .closeBtn {
       -moz-appearance: none;
	  -webkit-appearance: none;
	  appearance: none;
	  width: 50px;
	  height:50px;
	  font-size: 15px;
	  font-weight: 700;
	  background-color: #ffffff;
	  border: none;
	  position: absolute;
	  right:5px;
	  top:0px;
	  cursor:pointer
      }
      .schItemBox {
      width: 50%;
      height: auto;
      margin: 0 auto;
      margin-top: 100px;
      }
      .schItem {
      border: 1px solid black;
      width: 1000px;
      height: auto;
      margin-bottom: 10px;
      display:flex;
      flex-direction: row;
      flex-wrap:wrap;
      justify-content:start;
      align-items: center;
      }
      .pdtContents {
      font-size: 20px;
      line-height: 1.7;
      margin-left: 10px;
      width: 300px;
      }
      .cart {
      border: 1px solid black;
      border-radius: 50%;
      width: 70px;
      height:70px;
      background-color: #000000;
      color: #ffffff;
      text-align:center;
      margin-left: 75px;
      cursor:pointer;
      }
      .cart span {
      display: inline-block;
      margin-top: 24.5px;
      }
      .star {
      margin-left: 40px;
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
      .noSearch {
      width: 100%;
      height: 500px;
      text-align: center;
      font-weight: 700;
      font-size: 20px;
      padding-top: 100px;
      }
      .noSearchCts {
      border: 1px solid black;
      display: inline-block;
      width: 100%;
      height: 150px;
      padding-top: 60px;
      background-color: #1D3932;
      color: #ffffff;
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
    let isClick;
    function ocToggle(click) {
    	//닫기버튼을 눌렀을때 동작(함수호출)
    	isClick = click;
    	const closeModal = document.querySelector(".modalBackground");
    	if(isClick == true) {
    		closeModal.style.display="block";
    		//isClick = false;
    	}else{
    		closeModal.style.display="none";
    		//isClick = true;
    	}
    }
    </script>
  </head>
  <body>
  <div class="modalBackground">
  	<div class="modalBox">
  	<button type="button" class="closeBtn" onclick="ocToggle(false);"><img src="images/close.png"/ width="20px" height="20px" ></button>
  	<form action="search_list.sch" method="post" name="srhFrm">
  	<% if(loginMember != null) { %>
  		<input type="hidden" name="uid" value="<%=loginMember.getMlid()%>"/>
  		<input type="hidden" name="uname" value="<%=loginMember.getMlname()%>"/>
  	<% } %>
  		<input type="text" name="keyword" placeholder="검색" autocomplete="off"/><button type="submit"><i class="fas fa-search"></i></button>
  	</form>
  	</div>
  </div>
    <div class="container">
      <header class="header">
        <div class="topMenu">
          <div class="box left">
<%
if (loginMember == null) {
%>
            <a href="login_view.login"><span>LOGIN</span></a>
            <div class="line"><div class="lineItem"></div></div>
            <a href="join_view.join"><span>JOIN</span></a>
<%
} else {
%>
<%=loginMember.getMlid() + "(" + loginMember.getMlname() + ")" %> <div class="line"><div class="lineItem"></div></div>
<a href="logout_proc.login">LOGOUT</a>
<%
}
%>
          </div>
          <div class="box right">
            <a href="#"
              ><span><i class="fas fa-shopping-cart"></i></span
            ></a>
            <div class="line"><div class="lineItem"></div></div>
            <a href="#" onclick="ocToggle(true);"
              ><span><i class="fas fa-search"></i></span
            ></a>
          </div>
        </div>
        <div class="logoBox">
          <a href="index_view.main">
            <img
              src="images/포에트리 가든.png"
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
          <div class="menuTitle" onclick="location.href='pdt_list.pdt?loginMember=<%=loginMember%>';">SHOP</div>
          <div class="menuTitle">POST</div>
          <div class="menuTitle" id="effCancle">CENTER</div>
        </div>
        <div class="slideShow" id="slide">
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
      <main>
      	<div class="schItemBox">
      	<div class="noSearch"><span class="noSearchCts"><%=pdtSearchPage.getRcnt()%>개 검색됨</span></div>
      	<% for(int i = 0 ; i < pdtSearchList.size() ; i++) { %>
      		<div class="schItem">
      			<img src="/hoyaMall/product/pdt_img/<%=pdtSearchList.get(i).getPl_img1()%>" width="300" height="300"/>
      			<div class="pdtContents">
      			품명: <span><%=pdtSearchList.get(i).getPl_name() %></span><br>
      			가격: <span><%=pdtSearchList.get(i).getPl_price() %></span><br>
      			재고량: <span><%=pdtSearchList.get(i).getPl_stock() < 0? "무제한" : pdtSearchList.get(i).getPl_stock() == 0 ? "품절" 
      					: pdtSearchList.get(i).getPl_stock() > 0? "재고있음" : "품절"
      					%></span>
      			</div>
      			<div class="cart push">
      				<span>장바구니</span>
      			</div>
      			<div class="cart star">
      				<span>찜하기</span>
      			</div>
      		</div>
      	<% } %>
      	</div>
      </main>
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
</body>
</html>