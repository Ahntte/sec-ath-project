/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-08-16 02:34:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;

public final class admin_005fmember_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("html, body {\r\n");
      out.write("background-color: #fcfafa;\r\n");
      out.write("}\r\n");
      out.write("#brdList tr { height:40px; }\r\n");
      out.write("#brdList td, #brdList th { border-bottom:1px black solid; }\r\n");
      out.write("a:link { color:#4f4f4f; text-decoration:none; }\r\n");
      out.write("a:visited { color:#4f4f4f; text-decoration:none; }\r\n");
      out.write("a:hover { color:pink; text-decoration:underline; font-weight:bold; }\r\n");
      out.write("a:active { color:#f00; text-decoration:none; }\t\r\n");
      out.write("a:focus { color:#f00; text-decoration:underline; }\r\n");
      out.write(".container { width: 1200px; margin: 0 auto;}\r\n");
      out.write(".form { width: 700px; margin: 0 auto;}\r\n");
      out.write(".backWrap {\r\n");
      out.write("\t\twidth:100%; \r\n");
      out.write("\t\theight: auto; \r\n");
      out.write("  \t\tdisplay: flex;\r\n");
      out.write("        flex-direction: row;\r\n");
      out.write("        flex-wrap: nowrap;\r\n");
      out.write("        justify-content: flex-end;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("  }\r\n");
      out.write("#backImg {\r\n");
      out.write("\t\tmargin-right: 6px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"backWrap\">\r\n");
      out.write("<img src=\"images/back.png\" alt=\"뒤로가기\" width=\"23px\" height=\"23px\" style=\"cursor: pointer;\" title=\"뒤로가기\" id=\"backImg\" \r\n");
      out.write("onclick=\"history.go(");
      out.print(pageCnt*(-1)+1);
      out.write(");\"/>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//페이지 이동시 페이지 인덱스번호를 추출할 방법이 없으니 인덱스 번호를 대신할 카운트변수를 만들어서 이동시마다 1이 더해지게끔 설계\r\n");
      out.write("</script>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<div class=\"form wrap\">\r\n");
      out.write("<h2>회원 관리 화면</h2>\r\n");
      out.write("<form name=\"frmSch\" method=\"get\">\r\n");
      out.write("<table width=\"700\" cellpadding=\"5\">\r\n");
      out.write("<tr><td align=\"right\">\r\n");
      out.write("\t<select name=\"schtype\">\r\n");
      out.write("\t\t<option value=\"id\" ");
 if (schtype.equals("id")) { 
      out.write("\r\n");
      out.write("\t\t\tselected=\"selected\"");
 } 
      out.write(">아이디</option>\r\n");
      out.write("\t\t<option value=\"name\" ");
 if (schtype.equals("name")) { 
      out.write("\r\n");
      out.write("\t\t\tselected=\"selected\"");
 } 
      out.write(">이름</option>\r\n");
      out.write("\t\t<option value=\"ie\" ");
 if (schtype.equals("ie")) { 
      out.write("\r\n");
      out.write("\t\t\tselected=\"selected\"");
 } 
      out.write(">아이디+이메일</option>\r\n");
      out.write("\t\t<option value=\"email\" ");
 if (schtype.equals("email")) { 
      out.write("\r\n");
      out.write("\t\t\tselected=\"selected\"");
 } 
      out.write(">이메일</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<input type=\"text\" name=\"keyword\" value=\"");
      out.print(keyword );
      out.write("\" />\r\n");
      out.write("\t<input type=\"submit\" value=\"검색\" />\r\n");
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<table width=\"700\" cellpadding=\"5\" cellspacing=\"0\" id=\"brdList\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th width=\"8%\">번호</th><th width=\"*\">아이디</th><th width=\"15%\">이름</th>\r\n");
      out.write("<th width=\"15%\">등록일</th><th width=\"8%\">성별</th>\r\n");
      out.write("</tr>\r\n");

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

      out.write("\r\n");
      out.write("<tr align=\"center\" onmouseover=\"this.style.background='#efefef';\" \r\n");
      out.write("\tonmouseout=\"this.style.background='';\">\r\n");
      out.write("<td>");
      out.print(seq-- );
      out.write("</td>\r\n");
      out.write("<td align=\"left\">");
      out.print(lnk + title + "</a>" + reply );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(adminMemberList.get(i).getMlname() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(adminMemberList.get(i).getMldate().substring(2, 10).replace('-', '.') );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(adminMemberList.get(i).getMlgender().equals("M") ? "남" : "여" );
      out.write("</td>\r\n");
      out.write("</tr>\r\n");

	}
} else {	// 검색결과가 없으면
	out.println("<tr align='center'><td colspan='5'>");
	out.println("검색 결과가 없습니다.</td></tr>");
}

      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<br />\r\n");
      out.write("<table width=\"700\" cellpadding=\"5\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"*\" align=\"center\">\r\n");

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

      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
