<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="vo.*" %>
<%
// dispatch방식으로 이동했기 때문에 이전 파일의 request와 response를 사용할 수 있음
//AdminInfo loginMember = (AdminInfo)session.getAttribute("loginMember");
ArrayList<MemberInfo> adminMemberList = 
	(ArrayList<MemberInfo>)request.getAttribute("adminMemberList");
// 화면에서 보여줄 게시글들의 목록을 articleList에 담음
PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
// 페이징에 필요한 각종 데이터들을 담은 인스턴스
int pageCnt = Integer.parseInt(request.getParameter("pageCnt"));
int pageReCnt = 0;
System.out.println(pageCnt +"리스트");

String schtype = null, keyword = null, schargs = "", args = "";
if (pageInfo.getSchtype() == null || pageInfo.getKeyword() == null) {
// 검색을 하지 않은 경우에는 검색조건과 검색어를 빈 문자열로 지정
	schtype = "";	keyword = "";
} else {	// 검색을 했을 경우
	schtype = pageInfo.getSchtype();	// 검색조건
	keyword = pageInfo.getKeyword();	// 검색어
	if (keyword != null && !keyword.equals("")) {
		schargs = "&schtype=" + schtype + "&keyword=" + keyword;
		// 검색어가 있을 경우 검색관련 데이터를 쿼리스트링으로 지정
	}
}
int cpage = pageInfo.getCpage();	// 현재 페이지 번호
int pcnt = pageInfo.getPcnt();		// 전체 페이지 수
int spage = pageInfo.getSpage();	// 블록 시작 페이지 번호
int epage = pageInfo.getEpage();	// 블록 종료 페이지 번호
int rcnt = pageInfo.getRcnt();		// 검색된 게시물 개수

args = "&cpage=" + cpage + schargs;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
html, body {
background-color: #fcfafa;
}
#brdList tr { height:40px; }
#brdList td, #brdList th { border-bottom:1px black solid; }
a:link { color:#4f4f4f; text-decoration:none; }
a:visited { color:#4f4f4f; text-decoration:none; }
a:hover { color:pink; text-decoration:underline; font-weight:bold; }
a:active { color:#f00; text-decoration:none; }	
a:focus { color:#f00; text-decoration:underline; }
.container { width: 1200px; margin: 0 auto;}
.form { width: 700px; margin: 0 auto;}
.backWrap {
		width:100%; 
		height: auto; 
  		display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
        justify-content: flex-end;
        align-items: center;
  }
#backImg {
		margin-right: 6px;
}
</style>
</head>
<body>
<div class="backWrap">
<img src="images/back.png" alt="뒤로가기" width="23px" height="23px" style="cursor: pointer;" title="뒤로가기" id="backImg" 
onclick="history.go(<%=pageCnt*(-1)+1%>);"/>
<script type="text/javascript">
//페이지 이동시 페이지 인덱스번호를 추출할 방법이 없으니 인덱스 번호를 대신할 카운트변수를 만들어서 이동시마다 1이 더해지게끔 설계
</script>
</div>
<div class="container">
<div class="form wrap">
<h2>회원 관리 화면</h2>
<form name="frmSch" method="get">
<table width="700" cellpadding="5">
<tr><td align="right">
	<select name="schtype">
		<option value="id" <% if (schtype.equals("id")) { %>
			selected="selected"<% } %>>아이디</option>
		<option value="name" <% if (schtype.equals("name")) { %>
			selected="selected"<% } %>>이름</option>
		<option value="ie" <% if (schtype.equals("ie")) { %>
			selected="selected"<% } %>>아이디+이메일</option>
		<option value="email" <% if (schtype.equals("email")) { %>
			selected="selected"<% } %>>이메일</option>
	</select>
	<input type="text" name="keyword" value="<%=keyword %>" />
	<input type="submit" value="검색" />
</td></tr>
</table>
</form>
<table width="700" cellpadding="5" cellspacing="0" id="brdList">
<tr>
<th width="8%">번호</th><th width="*">아이디</th><th width="15%">이름</th>
<th width="15%">등록일</th><th width="8%">성별</th>
</tr>
<%
if (adminMemberList != null && rcnt > 0) {	// 검색결과가 있으면 (회원정보가 있고 게시물이 존재하면)
	int seq = rcnt - (10 * (cpage - 1));	// 현재 페이지에서의 시작번호 :  회원수 - (10 * (현재페이지-1))
	String title = "", reply = "", lnk = "";
	for (int i = 0 ; i < adminMemberList.size() ; i++) {
	// articleList에 들어있는 데이터의 개수만큼 루프를 돔
		pageReCnt = pageCnt;
		title = adminMemberList.get(i).getMlid();
		lnk = "<a href='admin_member_view.amm?id=" + 
				adminMemberList.get(i).getMlid() +"&pageCnt=" + ++pageReCnt + args + 
			"' title='" + title + "'>";
		// 제목에 달릴 링크 제작(title속성으로 제목을 툴팁을 통해서도 보여줌)
		
		if (title.length() > 28)
			title = title.substring(0, 26) + "...";
		// 제목이 너무 길어 두 줄이 되는 것을 막아줌
%>
<tr align="center" onmouseover="this.style.background='#efefef';" 
	onmouseout="this.style.background='';">
<td><%=seq-- %></td>
<td align="left"><%=lnk + title + "</a>" + reply %></td>
<td><%=adminMemberList.get(i).getMlname() %></td>
<td><%=adminMemberList.get(i).getMldate().substring(2, 10).replace('-', '.') %></td>
<td><%=adminMemberList.get(i).getMlgender().equals("M") ? "남" : "여" %></td>
</tr>
<%
	}
} else {	// 검색결과가 없으면
	out.println("<tr align='center'><td colspan='5'>");
	out.println("검색 결과가 없습니다.</td></tr>");
}
%>
</table>
<br />
<table width="700" cellpadding="5">
<tr>
<td width="*" align="center">
<%
if (rcnt > 0) {
// 검색결과 게시물이 있을 경우에만 페이징을 함
	pcnt = rcnt / 10;
	if (rcnt % 10 > 0)	pcnt++;
	// 전체 페이지수 = 전체게시물수 / 페이지크기 -> 나머지가 있으면 1증가

	if (cpage == 1) {
		out.println("[<<]&nbsp;&nbsp;[<]&nbsp;&nbsp;");
	} else {
		out.print("<a href='admin_member_list.amm?cpage=1" + schargs + "'>");
		out.println("[<<]</a>&nbsp;&nbsp;");
		out.print("<a href='admin_member_list.amm?cpage=" + (cpage - 1) + schargs + "'>");
		out.println("[<]</a>&nbsp;&nbsp;");
	}

	for (int i = 1, j = spage ; i <= 10 && j <= pcnt ; i++, j++) {
	// i : 루프돌릴 횟수를 지정하기 위해 사용되는 변수
	// j : 페이지 번호 출력용 변수
	// 조건 : 10번을 도는데 페이지가 마지막 페이지 일 경우 10보다 작아도 멈춤
		if (cpage == j) {
		// 현재 페이지일 경우 링크 없이 굵은 글씨체로 출력
			out.println("&nbsp;<strong>" + j + "</strong>&nbsp;");
		} else {
			out.print("&nbsp;<a href='admin_member_list.amm?cpage=" + j + schargs + "'>");
			out.println(j + "</a>&nbsp;");
		}
	}

	if (cpage == pcnt) {
		out.println("&nbsp;&nbsp;[>]&nbsp;&nbsp;[>>]");
	} else {
		out.print("&nbsp;&nbsp;<a href='admin_member_list.amm?cpage=" + (cpage + 1) + schargs + "'>");
		out.println("[>]</a>");
		out.print("&nbsp;&nbsp;<a href='admin_member_list.amm?cpage=" + pcnt + schargs + "'>");
		out.println("[>>]</a>");
	}
}
%>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>
