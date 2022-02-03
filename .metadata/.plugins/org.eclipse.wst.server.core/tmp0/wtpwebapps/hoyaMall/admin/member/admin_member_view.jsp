<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%
request.setCharacterEncoding("utf-8");
MemberInfo adminMemberArticle = (MemberInfo)request.getAttribute("adminMemberArticle");
if (adminMemberArticle == null) {
// 저장된 게시물이 없으면
	out.println("<script>");
	out.println("alert('잘못된 경로로 들어오셨습니다.');");
	out.println("history.back();");
	out.println("</script>");
}
int pageCnt = Integer.parseInt(request.getParameter("pageCnt"));
System.out.println(pageCnt + "뷰");

String uid = null;
AdminInfo adminLoginMember = (AdminInfo)session.getAttribute("adminLoginMember");
if (adminLoginMember != null)	uid = adminLoginMember.getAl_id();
// 현재 로그인한 상태이면 관리자 로그인 아이디를 uid에 저장

String id = request.getParameter("id");
int cpage = Integer.parseInt(request.getParameter("cpage"));
String schtype = request.getParameter("schtype");
String keyword = request.getParameter("keyword");
String args = "?cpage=" + cpage;
if (schtype != null && keyword != null && !keyword.equals("")) {
	args += "&schtype=" + schtype + "&keyword=" + keyword;
	// 검색어가 있으면 검색어를 쿼리스트링으로 가져감
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.viewContainer {
	width: 800px;
	border: 1px solid black;
	margin: 0 auto;
}
.viewContainer h2 {
	width: 400px;
	text-align:center;
	margin: 0 auto;
}
.viewMove {
	width: 285px;
	margin: 0 auto;
	margin-top: 10px;
}
</style>
</head>
<body>
<div class="viewContainer">
<h2>회원 상세보기 화면</h2>
<div class="viewMove">
<table cellpadding="5">
<tr><th>아이디</th>
<td colspan="3"><%=adminMemberArticle.getMlid() %></td></tr>
<tr><th>비밀번호</th>
<td colspan="3"><%=adminMemberArticle.getMlpwd() %></td></tr>
<tr><th>이름</th>
<td colspan="3"><%=adminMemberArticle.getMlname() %></td></tr>
<tr><th>성별</th>
<td colspan="3"><%=adminMemberArticle.getMlgender() %></td></tr>
<tr><th>생일</th>
<td colspan="3"><%=adminMemberArticle.getMlbirth() %></td></tr>
<tr><th>휴대폰</th>
<td colspan="3"><%=adminMemberArticle.getMlphone() %></td></tr>
<tr><th>이메일</th>
<td colspan="3"><%=adminMemberArticle.getMlemail()%></td></tr>
<tr><th>보유 포인트</th>
<td colspan="3"><%=adminMemberArticle.getMlpoint()%></td></tr>
<tr><th>가입일</th>
<td colspan="3"><%=adminMemberArticle.getMldate()%></td></tr>
<tr><th>최종로그인</th>
<td colspan="3"><%=adminMemberArticle.getMllast()%></td></tr>
<tr><th>상태</th>
<td colspan="3"><%=adminMemberArticle.getMlstatus()%></td></tr>

<tr><td colspan="4" align="center">
	<input type="button" value="목록으로" onclick="location.href='admin_member_list.amm<%=args %>&pageCnt=<%=++pageCnt %>';" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="수정" onclick="location.href='admin_member_form.amm<%=args + "&wtype=up" + "&id=" + adminMemberArticle.getMlid() + "&pageCnt=" + pageCnt %>'" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="삭제" onclick="location.href='admin_member_proc.amm<%=args + "&wtype=del" + "&id=" + adminMemberArticle.getMlid() + "&pageCnt=" + pageCnt %>'" />
</td></tr>
</table>
</div>
</div>
</body>
</html>
