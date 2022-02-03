<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.*" %>
<%@ page import="java.net.*" %>
<%
AdminInfo adminLoginMember = (AdminInfo)session.getAttribute("adminLoginMember");
// 로그인 되어 있을 경우 로그인 정보(현재 로그인 한 회원의 정보)를 받아옴

System.out.println("어드민 맴버 수정 폼");
request.setCharacterEncoding("utf-8");
String wtype = request.getParameter("wtype");
System.out.println(wtype);
String args = "";
String msg = "수정";
String uid = "" , pwd = "", name = "", gender = "", birth = "", phone = "", email = "", date = "", last = "", status = "";
int point = 0;

	int pageCnt = Integer.parseInt(request.getParameter("pageCnt"));

	if (wtype.equals("up")) {	// 게시글 수정일 경우
	MemberInfo article = (MemberInfo)request.getAttribute("article");
	// 수정할 게시글의 데이터가 저장된 article 인스턴스를 request에서 받아 생성	
	uid = article.getMlid();
	pwd = article.getMlpwd();
	name = article.getMlname();
	gender = article.getMlgender();
	birth = article.getMlbirth();
	phone = article.getMlphone();
	email = article.getMlemail();
	date = article.getMldate();
	last = article.getMllast();
	status = article.getMlstatus();
	point = article.getMlpoint();
	
	int cpage = Integer.parseInt(request.getParameter("cpage"));
	args = "?cpage=" + cpage;
	String schtype = request.getParameter("schtype");
	String keyword = request.getParameter("keyword");
	if (keyword != null && !keyword.equals("")) {
		args += "&schtype=" + schtype + "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
	}
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
<h2>회원정보 <%=msg %> 폼</h2>
<div class="viewMove">
<form name="frmUp" action="admin_member_proc.amm<%=args %>&pageCnt=<%=++pageCnt %>" method="post">
<input type="hidden" value="<%=wtype%>" name="wtype"/>
<input type="hidden" value="<%=uid %>" name="uid"/>
<table cellpadding="5">
<tr><th>아이디</th>
<td colspan="3"><input type="text" value="<%=uid%>" name="id" readonly/></td></tr>
<tr><th>비밀번호</th>
<td colspan="3"><input type="password" value="<%=pwd%>" name="pwd"/></td></tr>
<tr><th>이름</th>
<td colspan="3"><input type="text" value="<%=name%>" name="name"/></td></tr>
<tr><th>성별</th>
<td colspan="3"><input type="text" value="<%=gender%>" name="gender" readonly/></td></tr>
<tr><th>생일</th>
<td colspan="3"><input type="text" value="<%=birth%>" name="birth" readonly/></td></tr>
<tr><th>휴대폰</th>
<td colspan="3"><input type="text" value="<%=phone%>" name="phone"/></td></tr>
<tr><th>이메일</th>
<td colspan="3"><input type="text" value="<%=email%>" name="email"/></td></tr>
<tr><th>보유 포인트</th>
<td colspan="3"><input type="text" value="<%=point%>" name="point"/></td></tr>
<tr><th>가입일</th>
<td colspan="3"><input type="text" value="<%=date%>" name="date" readonly/></td></tr>
<tr><th>최종로그인</th>
<td colspan="3"><input type="text" value="<%=last%>" name="last" readonly/></td></tr>
<tr><th>상태</th>
<td colspan="3"><input type="text" value="<%=status%>" name="status"/></td></tr>

<tr><td colspan="4" align="center">
<% if(msg == "수정") { %>
	<input type="submit" value="<%=msg %>"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="취소" onclick="history.back();" />
	<% } %>
</td></tr>
</table>
</form>
</div>
</div>
</body>
</html>
