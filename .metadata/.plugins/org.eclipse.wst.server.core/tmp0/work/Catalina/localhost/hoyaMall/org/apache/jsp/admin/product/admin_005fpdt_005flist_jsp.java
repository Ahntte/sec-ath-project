/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-08-23 15:50:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import vo.*;

public final class admin_005fpdt_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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

ArrayList<PdtInfo> pdtList = (ArrayList<PdtInfo>)request.getAttribute("pdtList");
ArrayList<CataBigInfo> cataBigList = (ArrayList<CataBigInfo>)request.getAttribute("cataBigList");
ArrayList<CataSmallInfo> cataSmallList = (ArrayList<CataSmallInfo>)request.getAttribute("cataSmallList");
PdtPageInfo pageInfo = (PdtPageInfo)request.getAttribute("pageInfo");

String isview, schtype, keyword, sdate, edate, bcata, scata, sprice, eprice, stock, ord;
isview =	pageInfo.getIsview();	// 게시여부(전체게시, 게시상품, 미게시상품)
schtype =	pageInfo.getSchtype();	// 검색조건(상품코드, 상품명)
keyword =	pageInfo.getKeyword();	// 검색어
sdate =		pageInfo.getSdate();	// 등록일 검색 시작일
edate =		pageInfo.getEdate();	// 등록일 검색 종료일
bcata =		pageInfo.getBcata();	// 대분류
scata =		pageInfo.getScata();	// 소분류
sprice =	pageInfo.getSprice();	// 가격대 시작 가격
eprice =	pageInfo.getEprice();	// 가격대 종료 가격
stock =		pageInfo.getStock();	// 재고량(이상)
ord =		pageInfo.getOrd();		// 정렬조건
System.out.println("재고량"+stock);
String args = "", schArgs = "";
if (isview != null)		schArgs += "&isview=" + isview;		else	isview = "";
if (sdate != null)		schArgs += "&sdate=" + sdate;		else	sdate = "";
if (edate != null)		schArgs += "&edate=" + edate;		else	edate = "";
if (bcata != null)		schArgs += "&bcata=" + bcata;		else	bcata = "";
if (scata != null)		schArgs += "&scata=" + scata;		else	scata = "";
if (sprice != null)		schArgs += "&sprice=" + sprice;		else	sprice = "";
if (eprice != null)		schArgs += "&eprice=" + eprice;		else	eprice = "";
if (stock != null)		schArgs += "&stock=" + stock;		else	stock = "";
if (keyword != null && !keyword.equals("")) {
	schArgs += "&schtype=" + schtype + "&keyword=" + keyword;
} else {
	schtype = "";	keyword = "";
}

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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("td { font-size:11; }\r\n");
      out.write(".date { width:80px; }\r\n");
      out.write(".pr { width:50px; }\r\n");
      out.write(".pdtBox3 { width:266px; height:250px; border:1px solid black; }\r\n");
      out.write(".pdtBox4 { width:195px; height:200px; border:1px solid black; }\r\n");
      out.write("</style>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css\" />\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("<script src=\"http://code.jquery.com/ui/1.10.3/jquery-ui.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("$(function() {\r\n");
      out.write("\t$.datepicker.regional['ko'] = {\r\n");
      out.write("\t\tcloseText: '닫기', prevText: '이전달', nextText: '다음달', currentText: '오늘',\r\n");
      out.write("\t\tmonthNames: ['1월','2월','3월','4월','5월','6월', '7월','8월','9월','10월','11월','12월'],\r\n");
      out.write("\t\tmonthNamesShort: ['1월','2월','3월','4월','5월','6월', '7월','8월','9월','10월','11월','12월'],\r\n");
      out.write("\t\tdayNames: ['일','월','화','수','목','금','토'],\r\n");
      out.write("\t\tdayNamesShort: ['일','월','화','수','목','금','토'],\r\n");
      out.write("\t\tdayNamesMin: ['일','월','화','수','목','금','토'],\r\n");
      out.write("\t\tbuttonImageOnly: true, weekHeader: 'Wk', dateFormat: 'yy-mm-dd', firstDay: 0,\r\n");
      out.write("\t\tisRTL: false, duration:200, showAnim:'show', showMonthAfterYear: false\r\n");
      out.write("\t};\r\n");
      out.write("\t$.datepicker.setDefaults($.datepicker.regional['ko']);\r\n");
      out.write("\r\n");
      out.write("\t$( \"#sdate\" ).datepicker({\r\n");
      out.write("\t\tchangeMonth: true, dateFormat:\"yy-mm-dd\", onClose: function( selectedDate ) {}\r\n");
      out.write("\t});\r\n");
      out.write("\t$( \"#edate\" ).datepicker({\r\n");
      out.write("\t\tchangeMonth: true, dateFormat:\"yy-mm-dd\", onClose: function( selectedDate ) {}\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");

String scName = null;
int bc = 0, sc = 0;
for (int i = 0, j = 1 ; i < cataSmallList.size() ; i++, j++) {
	if (bc != cataSmallList.get(i).getCb_idx()) {
		j = 1;

      out.write("\r\n");
      out.write("var arr");
      out.print(cataSmallList.get(i).getCb_idx());
      out.write(" = new Array();\r\n");
      out.write("arr");
      out.print(cataSmallList.get(i).getCb_idx());
      out.write("[0] = new Option(\"\", \"소분류 선택\");\r\n");

	}
	bc = cataSmallList.get(i).getCb_idx();	// 대분류 idx를 bc에 저장
	sc = cataSmallList.get(i).getCs_idx();	// 소분류 idx를 sc에 저장
	scName = cataSmallList.get(i).getCs_name();	// 대분류명을 scName에 저장

      out.write("\r\n");
      out.write("arr");
      out.print(bc);
      out.write('[');
      out.print(j);
      out.write("] = new Option(\"");
      out.print(sc);
      out.write("\", \"");
      out.print(scName);
      out.write("\");\r\n");

}

      out.write("\r\n");
      out.write("\r\n");
      out.write("function setCategory(obj, target) {\r\n");
      out.write("\tvar x = obj.value;\t// 대분류에서 선택한 값을 x에 담음\r\n");
      out.write("\r\n");
      out.write("\tfor (var m = target.options.length - 1 ; m > 0 ; m--) {\r\n");
      out.write("\t\ttarget.options[m] = null;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tif (x != \"\") {\r\n");
      out.write("\t\tvar selectedArray = eval(\"arr\" + x);\t// 보여줄 배열 지정\r\n");
      out.write("\t\tfor (var i = 0 ; i < selectedArray.length ; i++) {\r\n");
      out.write("\t\t\ttarget.options[i] = new Option(selectedArray[i].value, selectedArray[i].text);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttarget.options[0].selected = true;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>상품 목록 화면</h2>\r\n");
      out.write("<form name=\"frmSch\" action=\"\" method=\"get\">\r\n");
      out.write("<table width=\"800\" cellpadding=\"5\">\r\n");
      out.write("<tr>\r\n");
      out.write("<th width=\"15%\">분류선택</th>\r\n");
      out.write("<td width=\"35%\">\r\n");
      out.write("\t<select name=\"bcata\" onchange=\"setCategory(this, this.form.scata);\">\r\n");
      out.write("\t\t<option value=\"\" ");
 if (bcata.equals("")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">대분류 선택</option>\r\n");
 for (int i = 0 ; i < cataBigList.size() ; i++) { 
      out.write("\r\n");
      out.write("\t\t<option value=\"");
      out.print(cataBigList.get(i).getCb_idx());
      out.write("\" \r\n");
      out.write("\t\t");
 if (bcata.equals(cataBigList.get(i).getCb_idx() + "")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">\r\n");
      out.write("\t\t");
      out.print(cataBigList.get(i).getCb_name());
      out.write("</option>\r\n");
 } 
      out.write("\r\n");
      out.write("\t</select>&nbsp;\r\n");
      out.write("\t<select name=\"scata\">\r\n");
      out.write("\t\t<option value=\"\" ");
 if (scata.equals("")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">소분류 선택</option>\r\n");

if (!bcata.equals("")) {	// 대분류를 이용하여 검색한 상태이면(소분류도 보여줘야 함)
	for (int i = 0 ; i < cataSmallList.size() ; i++) {
		if (bcata.equals((cataSmallList.get(i).getCs_idx() + "").substring(0, 2))) {
		// 현재 선택된 대분류에 속한 소분류들만 보여줌

      out.write("\r\n");
      out.write("\t<option value=\"");
      out.print(cataSmallList.get(i).getCs_idx());
      out.write("\" \r\n");
      out.write("\t");
 if (scata.equals(cataSmallList.get(i).getCs_idx() + "")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">\r\n");
      out.write("\t");
      out.print(cataSmallList.get(i).getCs_name());
      out.write("</option>\r\n");

		}
	}
}

      out.write("\r\n");
      out.write("\t</select>\r\n");
      out.write("</td>\r\n");
      out.write("<th width=\"15%\">등록기간</th>\r\n");
      out.write("<td>\r\n");
      out.write("\t<input type=\"text\" name=\"sdate\" id=\"sdate\" class=\"date\" value=\"");
      out.print(sdate);
      out.write("\"/> 이후&nbsp;\r\n");
      out.write("\t<input type=\"text\" name=\"edate\" id=\"edate\" class=\"date\" value=\"");
      out.print(edate);
      out.write("\"/> 이전\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>가격대</th>\r\n");
      out.write("<td>\r\n");
      out.write("\t<input type=\"text\" name=\"sprice\" class=\"pr\" value=\"");
      out.print(sprice);
      out.write("\"/>원 이상\r\n");
      out.write("\t<input type=\"text\" name=\"eprice\" class=\"pr\" value=\"");
      out.print(eprice);
      out.write("\"/>원 이하\r\n");
      out.write("</td>\r\n");
      out.write("<th>검색어</th>\r\n");
      out.write("<td colspan=\"3\">\r\n");
      out.write("\t<select name=\"schtype\">\r\n");
      out.write("\t\t<option value=\"\" ");
 if (schtype.equals("")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">검색조건</option>\r\n");
      out.write("\t\t<option value=\"id\" ");
 if (schtype.equals("id")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">상품 아이디</option>\r\n");
      out.write("\t\t<option value=\"name\" ");
 if (schtype.equals("name")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">상품 이름</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<input type=\"text\" name=\"keyword\" class=\"date\"/>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>재고량</th>\r\n");
      out.write("<td>\r\n");
      out.write("\t<select name=\"stock\">\r\n");
      out.write("\t\t<option value=\"\" ");
 if (stock.equals("")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">재고량 선택</option>\r\n");
      out.write("\t\t<option value=\"-1\" ");
 if (stock.equals("-1")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">무한대</option>\r\n");
 for (int i = 0 ; i < 100 ; i++) { 
      out.write("\r\n");
      out.write("\t\t<option value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
 if (stock.equals(i + "")) { 
      out.write("selected=\"selected\"");
 } 
      out.write('>');
      out.print(i);
      out.write("</option>\r\n");
 } 
      out.write("\r\n");
      out.write("\t</select>개 이상\r\n");
      out.write("</td>\r\n");
      out.write("<th>게시여부</th>\r\n");
      out.write("<td>\r\n");
      out.write("\t<input type=\"radio\" name=\"isview\" value=\"\" ");
 if (isview.equals("")) { 
      out.write("checked=\"checked\"");
 } 
      out.write(" />전체 보기\r\n");
      out.write("\t&nbsp;<input type=\"radio\" name=\"isview\" value=\"y\" ");
 if (isview.equals("y")) { 
      out.write("checked=\"checked\"");
 } 
      out.write(" />게시중\r\n");
      out.write("\t&nbsp;<input type=\"radio\" name=\"isview\" value=\"n\" ");
 if (isview.equals("n")) { 
      out.write("checked=\"checked\"");
 } 
      out.write(" />미게시\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<th>정렬방식</th>\r\n");
      out.write("<td>\r\n");
      out.write("\t<select name=\"ord\">\r\n");
      out.write("\t\t<option value=\"\" ");
 if (ord.equals("")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">상품아이디(오름차순)</option>\r\n");
      out.write("\t\t<option value=\"namea\" ");
 if (ord.equals("namea")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">상품명(오름차순)</option>\r\n");
      out.write("\t\t<option value=\"pricea\" ");
 if (ord.equals("pricea")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">낮은 가격순(오름차순)</option>\r\n");
      out.write("\t\t<option value=\"priced\" ");
 if (ord.equals("priced")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">높은 가격순(내림차순)</option>\r\n");
      out.write("\t\t<option value=\"datea\" ");
 if (ord.equals("datea")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">오래된 등록일순(오름차순)</option>\r\n");
      out.write("\t\t<option value=\"dated\" ");
 if (ord.equals("dated")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">최근 등록일순(내림차순)</option>\r\n");
      out.write("\t\t<option value=\"salecntd\" ");
 if (ord.equals("salecntd")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">많이 팔린순(내림차순)</option>\r\n");
      out.write("\t\t<option value=\"reviewd\" ");
 if (ord.equals("reviewd")) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">리뷰 개수순(내림차순)</option>\r\n");
      out.write("\t</select>\r\n");
      out.write("</td>\r\n");
      out.write("<th>페이지 크기</th>\r\n");
      out.write("<td>\r\n");
      out.write("\t<select name=\"psize\">\r\n");
      out.write("\t\t<option value=\"12\" ");
 if (psize == 12) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">12 개</option>\r\n");
      out.write("\t\t<option value=\"6\" ");
 if (psize == 6) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">6 개</option>\r\n");
      out.write("\t\t<option value=\"8\" ");
 if (psize == 8) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">8 개</option>\r\n");
      out.write("\t\t<option value=\"10\" ");
 if (psize == 10) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">10 개</option>\r\n");
      out.write("\t\t<option value=\"24\" ");
 if (psize == 24) { 
      out.write("selected=\"selected\"");
 } 
      out.write(">24 개</option>\r\n");
      out.write("\t</select> 씩 보여주기\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr><td colspan=\"4\" align=\"center\">\r\n");
      out.write("\t<input type=\"submit\" value=\"상품 검색\" />\r\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"reset\" value=\"조건 초기화\" />\r\n");
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<br /><br />\r\n");
      out.write("<table width=\"800\" cellpadding=\"5\">\r\n");

int max = 3;	// 한 행에서 보여줄 상품의 최대 개수
switch (psize) {
	case 8 :	max = 4;	break;
	case 10 :	max = 1;	break;
}

if (pdtList != null && rcnt > 0) {	// 검색결과가 있으면
	if (max == 1) {		// 한 행에서 보여줄 상품의 최대 개수가 1이면 게시판 형식으로 보여줌

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<th width=\"7%\">번호</th><th width=\"10%\">상품분류<br />소분류</th>\r\n");
      out.write("<th width=\"15%\">이미지</th><th width=\"*\">상품아이디<br />상품명</th>\r\n");
      out.write("<th width=\"10%\">가격<br />원가</th><th width=\"15%\">등록일<br />게시</th>\r\n");
      out.write("</tr>\r\n");

		int seq = rcnt - (10 * (cpage - 1));	// 현재 페이지에서의 시작번호
		String lnk = "";
		for (int i = 0 ; i < pdtList.size() && i < psize ; i++) {
			lnk = "<a href='admin_product_view.apdt?id=" + pdtList.get(i).getPl_id() + args + "'>";

      out.write("\r\n");
      out.write("<tr align=\"center\">\r\n");
      out.write("<td>");
      out.print(seq-- );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(pdtList.get(i).getCb_name() + "<br />" + pdtList.get(i).getCs_name() );
      out.write("</td>\r\n");
      out.write("<td><img src=\"/hoyaMall/product/pdt_img/");
      out.print(pdtList.get(i).getPl_img1() );
      out.write("\" width=\"100\" height=\"100\" /></td>\r\n");
      out.write("<td align=\"left\">");
      out.print(lnk + pdtList.get(i).getPl_id() + "<br />" + lnk + pdtList.get(i).getPl_name());
      out.write("</a></td>\r\n");
      out.write("<td>");
      out.print(pdtList.get(i).getPl_price() + "<br />" + pdtList.get(i).getPl_cost() );
      out.write("</td>\r\n");
      out.write("<td>");
      out.print(pdtList.get(i).getPl_date().substring(0, 10) );
      out.write("<br />\r\n");
      out.print(pdtList.get(i).getPl_view().equals("y") ? "게시" : "미게시" );
      out.write("</td>\r\n");
      out.write("</tr>\r\n");

		}
	} else {	// 한 행에서 보여줄 상품의 최대 개수가 3이나 4이면
		String lnk = "";
		for (int i = 0 ; i < pdtList.size() && i < psize ; i++) {
			lnk = "<a href='admin_product_view.apdt?id=" + pdtList.get(i).getPl_id() + args + "'>";
			if (i % max == 0)	out.println("<tr align=\"center\">");

      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("\t<div class=\"pdtBox");
      out.print(max);
      out.write("\">\r\n");
      out.write("\t\t");
      out.print(lnk );
      out.write("<img src=\"/hoyaMall/product/pdt_img/");
      out.print(pdtList.get(i).getPl_img1() );
      out.write("\" width=\"");
      out.print(max == 3 ? 250 : 190 );
      out.write("\" height=\"");
      out.print(max == 3 ? 200 : 140 );
      out.write("\" /></a><br />\r\n");
      out.write("\t\t");
      out.print(lnk + pdtList.get(i).getPl_name() );
      out.write("</a><br />\r\n");
      out.write("\t\t판매가 : ");
      out.print(pdtList.get(i).getPl_price() );
      out.write("<br />\r\n");
      out.write("\t\t할인가 : \r\n");
      out.write("\t</div>\r\n");
      out.write("</td>\r\n");

			if (i % max == max - 1)	out.println("</tr>");
		}
	}
} else {
	out.println("<tr><td align='center'>검색결과가 없습니다.</td></tr>");
}

      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("<br />\r\n");
      out.write("<table width=\"800\" cellpadding=\"5\">\r\n");
      out.write("<tr>\r\n");
      out.write("<td width=\"*\">\r\n");

if (rcnt > 0) {	// 검색결과 상품들이 있을 경우에만 페이징을 함
	if (cpage == 1) {
		out.println("[<<]&nbsp;&nbsp;[<]&nbsp;&nbsp;");
	} else {
		out.print("<a href='admin_product_list.apdt?cpage=1" + schArgs + "'>");
		out.println("[<<]</a>&nbsp;&nbsp;");
		out.print("<a href='admin_product_list.apdt?cpage=" + (cpage - 1) + schArgs + "'>");
		out.println("[<]</a>&nbsp;&nbsp;");
	}

	for (int i = 1, j = spage ; i <= bsize && j <= pcnt ; i++, j++) {
		if (cpage == j) {
			out.println("&nbsp;<strong>" + j + "</strong>&nbsp;");
		} else {
			out.print("&nbsp;<a href='admin_product_list.apdt?cpage=" + j + schArgs + "'>");
			out.println(j + "</a>&nbsp;");
		}
	}

	if (cpage == pcnt) {
		out.println("&nbsp;&nbsp;[>]&nbsp;&nbsp;[>>]");
	} else {
		out.print("&nbsp;&nbsp;<a href='admin_product_list.apdt?cpage=" + (cpage + 1) + schArgs + "'>");
		out.println("[>]</a>");
		out.print("&nbsp;&nbsp;<a href='admin_product_list.apdt?cpage=" + pcnt + schArgs + "'>");
		out.println("[>>]</a>");
	}
}

      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("<td width=\"10%\">\r\n");
      out.write("\t<input type=\"button\" value=\"상품 등록\" onclick=\"location.href='admin_product_in_form.apdt';\" />\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
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