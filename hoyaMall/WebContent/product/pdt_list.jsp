<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
ArrayList<PdtInfo> pdtList = (ArrayList<PdtInfo>)request.getAttribute("pdtList");
ArrayList<PdtInfo> pdtPotList = (ArrayList<PdtInfo>)request.getAttribute("pdtPotList");
ArrayList<CataBigInfo> cataBigList = (ArrayList<CataBigInfo>)request.getAttribute("cataBigList");
ArrayList<CataSmallInfo> cataSmallList = (ArrayList<CataSmallInfo>)request.getAttribute("cataSmallList");
PdtPageInfo pageInfo = (PdtPageInfo)request.getAttribute("pageInfo");
MemberInfo loginMember = (MemberInfo)session.getAttribute("loginMember");

String keyword, bcata, scata, sprice, eprice, ord;
keyword =	pageInfo.getKeyword();	// 검색어
bcata =		pageInfo.getBcata();	// 대분류
scata =		pageInfo.getScata();	// 소분류
sprice =	pageInfo.getSprice();	// 가격대 시작 가격
eprice =	pageInfo.getEprice();	// 가격대 종료 가격
ord =		pageInfo.getOrd();		// 정렬조건

String args = "", schArgs = "";
if (bcata != null)		schArgs += "&bcata=" + bcata;		else	bcata = "";
if (scata != null)		schArgs += "&scata=" + scata;		else	scata = "";
if (sprice != null)		schArgs += "&sprice=" + sprice;		else	sprice = "";
if (eprice != null)		schArgs += "&eprice=" + eprice;		else	eprice = "";
if (keyword != null)	schArgs += "&keyword=" + keyword;	else	keyword = "";
if (ord != null)		schArgs += "&ord=" + ord;			else	ord = "";

int cpage	= pageInfo.getCpage();	// 현재 페이지 번호
int pcnt	= pageInfo.getPcnt();	// 전체 페이지 수
int psize	= pageInfo.getPsize();	// 페이지 크기
int bsize	= pageInfo.getBsize();	// 블록 페이지 개수
int spage	= pageInfo.getSpage();	// 블록 시작 페이지 번호
int epage	= pageInfo.getEpage();	// 블록 종료 페이지 번호
int rcnt	= pageInfo.getRcnt();	// 검색된 게시물 개수
schArgs = "&psize=" + psize + schArgs;
args = "&cpage=" + cpage + schArgs;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link
      href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600;700&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
<style>
td { font-size:11; }
.pr { width:50px; }
.pdtBox3 { width:266px; height:265px;  }
.pdtBox4 { width:195px; height:215px; }
.bestContainer { width: 100%; height:auto;}
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
  * {
        box-sizing: border-box;
      }
      body {
        margin: 0;
        background-color: #fcfafa;
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
	background-color: #ffffff;
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
      #pdtListTitle {
      	text-align: center;
      	margin-top: 110px;
      }
      .sort {
      	width: auto;
      	height: auto;
      	margin: 0 auto;
      	padding-top: 15px;
      }
      .table {
      	margin: 0 auto;
      }
      select {
	  -moz-appearance: none;
	  -webkit-appearance: none;
	  appearance: none;
	  font-family: "Noto Sansf KR", sans-serif;
	  font-size: 1rem;
	  font-weight: 400;
	  line-height: 1.5;
	  color: #444;
	  background-color: #fff;
	  margin: 0;
	  border: 1px solid #aaa;
	  border-radius: 0.5em;
	  box-shadow: 0 1px 0 1px rgba(0, 0, 0, 0.04);
	}
	input[type="text"] {
	  -moz-appearance: none;
	  -webkit-appearance: none;
	  appearance: none;
	  border: 1px solid #aaa;
	  border-radius: 0.5em;
	  box-shadow: 0 1px 0 1px rgba(0,0,0,0.04);
	  color: #444;
	  background-color: #fff;
	  margin: 0;
	  font-family: "Noto Sansf KR", sans-serif;
	  font-size: 1rem;
	  font-weight: 400;
	  line-height: 1.5;
	}
	.pr {
	  width: 60px;
	}
	.iptBtn {
	  -moz-appearance: none;
	  -webkit-appearance: none;
	  appearance: none;
	  border: none;
	  border-radius: 0.5em;
	  width: 90px;
	  height:40px;
	  font-size: 15px;
	  font-weight: 700;
	  background-color: #424141;
	  color: #ffffff;
	  margin-top: 17px;
	}
	.pdtTbl {
	  margin: 0 auto;
	}
	.blockTbl {
	  margin: 0 auto;
	}
	.pdtImg {
	  padding-bottom: 10px;
	}
	.topTitle {
	  background-color:#1D3932;
	  text-align:center;
	  border:1px solid black;
      padding:20px;
      color: #ffffff;
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
</head>
<body>
<main>
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
            <a href="#"
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
<h2 id="pdtListTitle">SHOP</h2>
<div class="item sort">
<form name="frmSch" action="" method="get" >
<table width="800" cellpadding="5" class="table">
<tr>
<th width="15%">가격대</th>
<td width="35%">
	<input type="text" name="sprice" class="pr" value="<%=sprice%>"/>원 이상
	<input type="text" name="eprice" class="pr" value="<%=eprice%>"/>원 이하
</td>
<th width="15%">상품명</th>
<td width="35%"><input type="text" name="keyword" class="date"/></td>
</tr>
<tr>
<th>정렬방식</th>
<td>
	<select name="ord">
		<option value="" <% if (ord.equals("")) { %>selected="selected"<% } %>>상품아이디(오름차순)</option>
		<option value="namea" <% if (ord.equals("namea")) { %>selected="selected"<% } %>>상품명(오름차순)</option>
		<option value="pricea" <% if (ord.equals("pricea")) { %>selected="selected"<% } %>>낮은 가격순(오름차순)</option>
		<option value="priced" <% if (ord.equals("priced")) { %>selected="selected"<% } %>>높은 가격순(내림차순)</option>
		<option value="datea" <% if (ord.equals("datea")) { %>selected="selected"<% } %>>오래된 등록일순(오름차순)</option>
		<option value="dated" <% if (ord.equals("dated")) { %>selected="selected"<% } %>>최근 등록일순(내림차순)</option>
		<option value="salecntd" <% if (ord.equals("salecntd")) { %>selected="selected"<% } %>>많이 팔린순(내림차순)</option>
		<option value="reviewd" <% if (ord.equals("reviewd")) { %>selected="selected"<% } %>>리뷰 개수순(내림차순)</option>
	</select>
</td>
<th>페이지 크기</th>
<td>
	<select name="psize">
		<option value="12" <% if (psize == 12) { %>selected="selected"<% } %>>12 개</option>
		<option value="6" <% if (psize == 6) { %>selected="selected"<% } %>>6 개</option>
		<option value="8" <% if (psize == 8) { %>selected="selected"<% } %>>8 개</option>
		<option value="24" <% if (psize == 24) { %>selected="selected"<% } %>>24 개</option>
	</select> 씩 보여주기
</td>
</tr>
<tr><td colspan="4" align="center">
	<input type="submit" value="상품 검색" class="iptBtn" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="다시 입력" class="iptBtn"/>
</td></tr>
</table>
</form>
<h1 class="topTitle">HOYAS</h1>
<table width="800" cellpadding="5" class="pdtTbl">
<%
int max = 3;	// 한 행에서 보여줄 상품의 최대 개수
if (psize == 8)	max = 4;

if (pdtList != null && rcnt > 0) {	// 검색결과가 있으면
	String lnk = "", price = "", soldout = "";
	for (int i = 0 ; i < pdtList.size() && i < psize ; i++) {
		lnk = "<a href='pdt_view.pdt?id=" + pdtList.get(i).getPl_id() + args + "'>";
		if (i % max == 0)	out.println("<tr align=\"center\">");
		price = pdtList.get(i).getPl_price() + "";
		if (pdtList.get(i).getPl_discount() > 0) {	// 할인율이 있으면
			float rate = (float)pdtList.get(i).getPl_discount() / 100;
			int dcPrice = Math.round(pdtList.get(i).getPl_price() - (pdtList.get(i).getPl_price() * rate));
			price = "<del>" + price + "</del><br />할인가 : " + dcPrice;
		}
		soldout = "";
		if (pdtList.get(i).getPl_stock() == 0)
			soldout = " <img src='/hoyaMall/images/soldout.png' width='50' align='absmiddle' />";
%>

<td class="itemList">
	<div class="pdtBox<%=max%>">		
		<%=lnk %><img src="/hoyaMall/product/pdt_img/<%=pdtList.get(i).getPl_img1() %>" width="<%=max == 3 ? 265 : 190 %>" height="<%=max == 3 ? 230 : 140 %>" class="pdtImg"/></a><br />
		<%=lnk + pdtList.get(i).getPl_name()%></a><%=soldout %><br />판매가 : <%=price %>
	</div>
</td>
	
<%
		if (i % max == max - 1)	out.println("</tr>");
	}
} else {
	out.println("<tr><td align='center'>검색결과가 없습니다.</td></tr>");
}
%>
</table>
<br />
<table width="800" cellpadding="5" class="blockTbl">
<tr><td align="center">
<%
if (rcnt > 0) {	// 검색결과 상품들이 있을 경우에만 페이징을 함
	if (cpage == 1) {
		out.println("[<<]&nbsp;&nbsp;[<]&nbsp;&nbsp;");
	} else {
		out.print("<a href='pdt_list.pdta?cpage=1" + schArgs + "'>");
		out.println("[<<]</a>&nbsp;&nbsp;");
		out.print("<a href='pdt_list.pdta?cpage=" + (cpage - 1) + schArgs + "'>");
		out.println("[<]</a>&nbsp;&nbsp;");
	}

	for (int i = 1, j = spage ; i <= bsize && j <= pcnt ; i++, j++) {
		if (cpage == j) {
			out.println("&nbsp;<strong>" + j + "</strong>&nbsp;");
		} else {
			out.print("&nbsp;<a href='pdt_list.pdta?cpage=" + j + schArgs + "'>");
			out.println(j + "</a>&nbsp;");
		}
	}

	if (cpage == pcnt) {
		out.println("&nbsp;&nbsp;[>]&nbsp;&nbsp;[>>]");
	} else {
		out.print("&nbsp;&nbsp;<a href='pdt_list.pdta?cpage=" + (cpage + 1) + schArgs + "'>");
		out.println("[>]</a>");
		out.print("&nbsp;&nbsp;<a href='pdt_list.pdta?cpage=" + pcnt + schArgs + "'>");
		out.println("[>>]</a>");
	}
}
%>
</td></tr>
</table>
</div>
</main>
<h1 class="topTitle">POTS</h1>
<article class="bestContainer">
 <section class="bestWrap">
 <% for(int i = 0 ; i < pdtPotList.size() ; i++) { %>
  <div class="bestItem">
  <div class="image">
 	<img src="/hoyaMall/product/pdt_img/<%=pdtPotList.get(i).getPl_img1() %>" width="400px" height="400px"/>
 	<% System.out.println(pdtPotList.get(i).getPl_img1()); %>
  </div>
  	<div class="fntCenter"><%=pdtPotList.get(i).getPl_name() %></div>
  	<div class="fntCenter"><%=pdtPotList.get(i).getPl_price() %></div>
  </div>
 <% } %>
 </section>
</article>
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
