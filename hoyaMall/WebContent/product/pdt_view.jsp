<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
MemberInfo loginMember = (MemberInfo)session.getAttribute("loginMember");
//로그인 되어 있을 경우 로그인 정보(현재 로그인 한 회원의 정보)를 받아옴

request.setCharacterEncoding("utf-8");
int cpage = Integer.parseInt(request.getParameter("cpage"));
int psize = Integer.parseInt(request.getParameter("psize"));

// 검색조건 및 정렬조건 쿼리스트링을 받음
String id, keyword, bcata, scata, brand, sprice, eprice, ord;
id		= request.getParameter("id");		keyword = request.getParameter("keyword");
bcata	= request.getParameter("bcata");	scata	= request.getParameter("scata");	sprice	= request.getParameter("sprice");
eprice	= request.getParameter("eprice");	ord 	= request.getParameter("ord");

String args = "?cpage=" + cpage + "&psize=" + psize;
if (bcata != null && !bcata.equals(""))		args += "&bcata=" + bcata;
if (scata != null && !scata.equals(""))		args += "&scata=" + scata;
if (sprice != null && !sprice.equals(""))	args += "&sprice=" + sprice;
if (eprice != null && !eprice.equals(""))	args += "&eprice=" + eprice;
if (keyword != null && !keyword.equals(""))	args += "&keyword=" + keyword;
if (ord != null && !ord.equals(""))			args += "&ord=" + ord;

PdtInfo pdtInfo = (PdtInfo)request.getAttribute("pdtInfo");

String soldout = "";
if (pdtInfo.getPl_stock() == 0)
	soldout = " <img src='/hoyaMall/images/soldout.png' width='80' align='absmiddle' />";

String plstock = String.valueOf(pdtInfo.getPl_stock());
if (plstock.equals("-1"))	plstock = "무제한";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#thImg img { margin:10px; }
</style>
<script>
function showImg(imgName) {
	var bigImg = document.getElementById("bigImg");
	bigImg.src = "/hoyaMall/product/pdt_img/" + imgName;
}

function goCart() {	// 장바구니에 담기 버튼 클릭시
	var frm = document.frmPdt;
	frm.action = "cart_in.ord";
	frm.submit();
}

function goDirect() {	// 바로 구매하기 버튼 클릭시
	var frm = document.frmPdt;
<%
if (loginMember == null) {	// 로그인을 하지 않은 상태일 경우
	session.setAttribute("url", "order_form.ord");
%>
	frm.action = "login_form.jsp";
<% } else {	// 로그인을 한 상태일 경우 %>
	frm.action = "ord_form.ord";
<% } %>
	frm.submit();
}
</script>
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
	input[type="button"] {
	  -moz-appearance: none;
	  -webkit-appearance: none;
	  appearance: none;
	  border: none;
	  border-radius: 0.5em;
	  box-shadow: 0 1px 0 1px rgba(0,0,0,0.04);
	  color: #ffffff;
	  background-color:rgba(33, 33, 33, 0.9);
	  margin: 0;
	  font-family: "Noto Sansf KR", sans-serif;
	  font-size: 1rem;
	  font-weight: 400;
	  line-height: 1.5;
	  height: 33px;
	  cursor: pointer;
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
      .pdtViewBox {
      margin: 0 auto;
      width: auto;
      height: 650px;
      margin-bottom: 22px;
      }
      .pdtView {
      width: 800px;
      height: auto;
      margin: 0 auto;
      margin-top: 60px;
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
<div class="pdtViewBox">
<div class="pdtView">
<table width="800" cellpadding="5">
<tr>
<td width="40%" align="center" valign="middle">
	<table width="100%">
	<tr><td align="center" valign="middle">
		<img src="/hoyaMall/product/pdt_img/<%=pdtInfo.getPl_img1() %>" width="300" id="bigImg" />
	</td></tr>
	<tr><td align="center" valign="middle" id="thImg">
		<img src="/hoyaMall/product/pdt_img/<%=pdtInfo.getPl_img1() %>" width="80" onclick="showImg('<%=pdtInfo.getPl_img1() %>');" />
<% if (pdtInfo.getPl_img2() != null && !pdtInfo.getPl_img2().equals("")) { %>
		<img src="/hoyaMall/product/pdt_img/<%=pdtInfo.getPl_img2() %>" width="80" onclick="showImg('<%=pdtInfo.getPl_img2() %>');" /><% } %>
<% if (pdtInfo.getPl_img3() != null && !pdtInfo.getPl_img3().equals("")) { %>
		<img src="/hoyaMall/product/pdt_img/<%=pdtInfo.getPl_img3() %>" width="80" onclick="showImg('<%=pdtInfo.getPl_img3() %>');" /><% } %>
	</td></tr>
	</table>
</td>
<td width="*" valign="top">
	<table width="100%" cellpadding="8">
	<tr>
	<td width="100">분류</td>
	<td width="*"><%=pdtInfo.getCb_name() + " - " + pdtInfo.getCs_name() %></td>
	</tr>
	<tr><td>상품명</td><td><%=pdtInfo.getPl_name() + soldout %></td></tr>
	<tr><td>원산지</td><td><%=pdtInfo.getPl_orig() %></td></tr>
	<tr><td>가격</td><td><%=pdtInfo.getPl_price() %></td></tr>
<%
int price = pdtInfo.getPl_price();	// 실 구매가
if (pdtInfo.getPl_discount() > 0) {
	float rate = (float)pdtInfo.getPl_discount() / 100;
	price = Math.round(pdtInfo.getPl_price() - (pdtInfo.getPl_price() * rate));
%>
	<tr><td>할인율</td><td><%=pdtInfo.getPl_discount() %>% (할인가격 : <%=price %>)</td></tr>
<% } %>
	<form name="frmPdt" action="" method="post">
	<input type="hidden" name="kind" value="direct" />
	<input type="hidden" name="id" value="<%=id %>" />
	<input type="hidden" name="args" value="<%=args %>" />
	<input type="hidden" name="price" value="<%=price %>" />
	<tr><td>수량</td>
	<td>
<%
String dis = "";
int max = pdtInfo.getPl_stock();
if (max == -1)		max = 100;
else if (max == 0) {
	dis = " disabled=\"disabled\"";		max = 1;
}
%>
		<select name="cnt" <%=dis %>>
<% for (int i = 1 ; i <= max ; i++) { %>
			<option value="<%=i%>"><%=i%></option>
<% } %>
		</select>
	</td>
	</tr>
<%
if (pdtInfo.getPl_opt() != null && !pdtInfo.getPl_opt().equals("")) {
// 현 상품에 선택할 옵션이 있으면
	String[] arrOpt = pdtInfo.getPl_opt().split(":");
%>
	<input type="hidden" name="optCnt" value="<%=arrOpt.length %>" />
<%
	for (int i = 0 ; i < arrOpt.length ; i++) {
		String[] arrTmp = arrOpt[i].split(",");
		out.println("<tr><td>" + arrTmp[0] + "</td><td>");
		out.println("<select name='opt" + i + "' " + dis + ">");
		for (int j = 1 ; j < arrTmp.length ; j++) {
			out.println("<option value='" + arrTmp[j] + "'>" + arrTmp[j] + "</option>");
		}
		out.println("</select></td></tr>");
	}
}
%>
	<tr><td colspan="2" align="center">
		<input type="button" value="장바구니" onclick="goCart();" <%=dis%> />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="바로 구매하기" onclick="goDirect();" <%=dis%> />
	</td></tr>
	</form>
	</table>
</td>
</tr>
<tr><td colspan="2" align="center"><hr width="100%" /></td></tr>
<tr><td colspan="2" align="center">
	<img src="/hoyaMall/product/pdt_img/<%=pdtInfo.getPl_desc() %>" width="780" />
</td></tr>
<tr><td colspan="2" align="center"><hr width="100%" /></td></tr>
<tr><td colspan="2" align="center">
	<input type="button" value="목록" onclick="location.href='pdt_list.pdt<%=args %>';" />
</td></tr>
</table>
</div>
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
</body>
</html>
