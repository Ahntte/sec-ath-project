<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
AdminInfo adminLoginMember = (AdminInfo)session.getAttribute("adminLoginMember");
int pageCnt = Integer.parseInt(request.getParameter("pageCnt"));
System.out.println(pageCnt + "어드민인덱스");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <!-- 관리자 메인페이지로써 페이지가 로드될때 자연스럽게 배경이 어두워지고 이미지형식의 카드가 메뉴로 나타난다 -->
    <style>
    body{
    animation: fadein 2000ms ease-out;
    -moz-animation: fadein 2000ms ease-out; /* Firefox */
    -webkit-animation: fadein 2000ms ease-out; /* Safari and  Chrome */
    -o-animation: fadein 2000ms ease-out; /* Opera */
}
@keyframes fadein {
    from {opacity:0;}
    to {opacity:1;}
}
@-moz-keyframes fadein { /* Firefox */
    from {opacity:0;}
    to {opacity:1;}
}
@-webkit-keyframes fadein { /* Safari and Chrome */
    from {opacity:0;}
    to {opacity:1;}
}
@-o-keyframes fadein { /* Opera */
    from {opacity:0;}
    to {opacity: 1;}
}
      .container {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100vh;
        background-color: rgba(0, 0, 0, 0.4);
        z-index: 1000;
      }
      .sort {
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
      }
      .wrap {
        margin: 0 auto;
        width: 800px;
        display: flex;
        flex-direction: row;
        flex-wrap: wrap;
        justify-content: center;
        align-items: center;
      }
      .std {
        width: 200px;
        height: 200px;
        border: 1px solid white;
        margin: 26px;
        background-color: #ffffff;
        border-radius: 10%;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: center;
        align-items: center;
      }
      #outBtn {
      	background:none;
      	border: none;
      }
      .log {
       	display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content:space-between;
        align-items: center;
        margin-top: 10px;
        padding: 0px 10px;
      }
      .std {
      	cursor:pointer;
      }
    </style>
    <script src="jquery-3.5.1.js"></script>
    <script>
	$(function($) {
	$("body").css("display", "none");
	$("body").fadeIn(2000);
	$("a.transition").click(function(event){
	event.preventDefault();
	linkLocation = this.href;
	$("body").fadeOut(1000, redirectPage);
		});
	function redirectPage() {
	window.location = linkLocation;
		}
	});
	</script>
  </head>
  <body>
    <!-- 컨테이너는 배경색을 어둡게 만들어주기위해서도 필요함 -->
    <div class="container">
    
    <%
    	if(adminLoginMember != null){
    %>
    <div class="log Status" style="color:#ffffff;"><%=adminLoginMember.getAl_id() %>(<%=adminLoginMember.getAl_name() %>)
    <button type="button" onclick="location.href='admin_logout.adminlog';" id="outBtn" ><img src="images/out.png" alt="로그아웃" width="23px" height="23px" style="cursor: pointer;" title="로그아웃"/></button>
    </div>
    <% }else{ %>
    	<script type="text/javascript">
    		alert("잘못된 경로로 들어왔습니다.");
    		location.href="admin_login_view.adminlog";
    	</script>
    <% } %>
      <div class="sort">
        <div class="wrap">
          <div class="adminManage std">
            <img
              src="images/manage.png"
              alt="관리자관리"
              width="120px"
              height="120px"
              id="img1"
            />
          </div>
          <div class="memManage std" onclick="location.href='admin_member_list.amm?pageCnt=<%=++pageCnt%>'">
            <img
              src="images/member.png"
              alt="회원관리"
              width="120px"
              height="120px"
              id="img2"
            />
          </div>
          <div class="product std" onclick="location.href='admin_product_list.apdt';">
            <img
              src="images/product.png"
              alt="상품관리"
              width="120px"
              height="120px"
              id="img3"
            />
          </div>
          <div class="ord std">
            <img src="images/order.png" alt="주문관리" width="120px" height="120px"  />
          </div>
          <div class="board std">
            <img src="images/cum.png" alt="게시판관리" width="120px" height="120px" />
          </div>
          <div class="stats std">
            <img src="images/setting.png" alt="통계" width="120px" height="120px" />
          </div>
        </div>
      </div>
    </div>
  </body>
  <script>
    const adminManage = document.querySelector(".adminManage");
    const memManage = document.querySelector(".memManage");
    const product = document.querySelector(".product");
    const order = document.querySelector(".ord");
    const board = document.querySelector(".board");
    const stats = document.querySelector(".stats");

    adminManage.addEventListener("mouseover", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      adminManage.innerHTML = "";
      adminManage.innerText = "관리자관리";
    });
    adminManage.addEventListener("mouseout", () => {
      adminManage.innerText = "";
      adminManage.innerHTML =
        "<img src='images/manage.png' alt='관리자관리' width='120px' height='120px' id='img1'/>";
    });

    memManage.addEventListener("mouseover", () => {
      memManage.innerHTML = "";
      memManage.innerText = "회원관리";
    });
    memManage.addEventListener("mouseout", () => {
      memManage.innerText = "";
      memManage.innerHTML =
        "<img src='images/member.png' alt='회원관리' width='120px' height='120px' id='img1'/>";
    });

    product.addEventListener("mouseover", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      product.innerHTML = "";
      product.innerText = "상품관리";
    });
    product.addEventListener("mouseout", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      product.innerText = "";
      product.innerHTML =
        "<img src='images/product.png' alt='상품관리' width='120px' height='120px' id='img1'/>";
    });

    order.addEventListener("mouseover", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      order.innerHTML = "";
      order.innerText = "주문관리";
    });
    order.addEventListener("mouseout", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      order.innerText = "";
      order.innerHTML =
        "<img src='images/order.png' alt='주문관리' width='120px' height='120px' id='img1'/>";
    });

    board.addEventListener("mouseover", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      board.innerHTML = "";
      board.innerText = "게시판관리";
    });
    board.addEventListener("mouseout", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      board.innerText = "";
      board.innerHTML =
        "<img src='images/cum.png' alt='게시판관리' width='120px' height='120px' id='img1'/>";
    });

    stats.addEventListener("mouseover", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      stats.innerHTML = "";
      stats.innerText = "통계관리";
    });
    stats.addEventListener("mouseout", () => {
      // 6개를 개별로 이벤트리스너를 먹이는것이 아니라 하나의 작업으로 해결할수있지않을까
      // 여섯개의 이벤트는 전부 동일 그리고 이미지를 특정 글자로 바꾸는것임
      stats.innerText = "";
      stats.innerHTML =
        "<img src='images/setting.png' alt='통계관리' width='120px' height='120px' id='img1'/>";
    });
  </script>
</html>
