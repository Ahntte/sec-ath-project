/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2021-09-23 01:49:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.http");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <style>\r\n");
      out.write("      * {\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("      }\r\n");
      out.write("      body {\r\n");
      out.write("        margin: 0;\r\n");
      out.write("      }\r\n");
      out.write("      a {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        color: black;\r\n");
      out.write("      }\r\n");
      out.write("      a:visited {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("      }\r\n");
      out.write("      a:hover {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("      }\r\n");
      out.write("      a:focus {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("      }\r\n");
      out.write("      a:hover,\r\n");
      out.write("      a:active {\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("      }\r\n");
      out.write("      input:focus {\r\n");
      out.write("        outline: none;\r\n");
      out.write("      }\r\n");
      out.write("      .container {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        background-color: #fcfafa;\r\n");
      out.write("      }\r\n");
      out.write("      .header {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("      }\r\n");
      out.write("      .logoBox {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        flex-direction: row;\r\n");
      out.write("        flex-wrap: nowrap;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        width: 410px;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("      }\r\n");
      out.write("      .box {\r\n");
      out.write("        margin-top: 10px;\r\n");
      out.write("      }\r\n");
      out.write("      .left {\r\n");
      out.write("        width: 300px;\r\n");
      out.write("        text-align: left;\r\n");
      out.write("        padding: 15px;\r\n");
      out.write("      }\r\n");
      out.write("      .right {\r\n");
      out.write("        width: 300px;\r\n");
      out.write("        text-align: right;\r\n");
      out.write("        padding: 15px;\r\n");
      out.write("      }\r\n");
      out.write("      .line {\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("      }\r\n");
      out.write("      .lineItem {\r\n");
      out.write("        border: 1px solid black;\r\n");
      out.write("        width: 0.1px;\r\n");
      out.write("        height: 11px;\r\n");
      out.write("        vertical-align: middle;\r\n");
      out.write("        margin: 0px 3px;\r\n");
      out.write("      }\r\n");
      out.write("      .topMenu {\r\n");
      out.write("        height: 50px;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        flex-direction: row;\r\n");
      out.write("        flex-wrap: nowrap;\r\n");
      out.write("        justify-content: space-between;\r\n");
      out.write("      }\r\n");
      out.write("      .gnb {\r\n");
      out.write("        height: 57px;\r\n");
      out.write("      }\r\n");
      out.write("      .cata {\r\n");
      out.write("        border: 1px solid rgb(226, 226, 226);\r\n");
      out.write("        margin: 0px;\r\n");
      out.write("        padding: 0px;\r\n");
      out.write("        list-style: none;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        flex-direction: row;\r\n");
      out.write("        flex-wrap: nowrap;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        height: 57px;\r\n");
      out.write("        font-size: 15px;\r\n");
      out.write("        font-weight: 700;\r\n");
      out.write("      }\r\n");
      out.write("      .menuTitle {\r\n");
      out.write("        margin: 0px 30px;\r\n");
      out.write("        font-family: \"Montserrat\", sans-serif;\r\n");
      out.write("      }\r\n");
      out.write("      .effCancle {\r\n");
      out.write("        margin-right: 0px;\r\n");
      out.write("      }\r\n");
      out.write("\r\n");
      out.write("      /*\r\n");
      out.write("           flex-direction으로 정렬방향을 지정하면 그 방향에 대한 축이 main축(axis)이된다.\r\n");
      out.write("           main축이 정해지면 자동으로 그에 수직으로 떨어지는 cross축이 그려진다.\r\n");
      out.write("           flex-wrap : 자식요소의 사이즈가 부모요소의 사이즈를 초과할 경우에 자식요소들을 감싸지 않고 무조건 한 줄에 요소들을 배치하겠다.\r\n");
      out.write("           여러줄로 감싸는것이 아닌 한 줄로 감쌈\r\n");
      out.write("           자식사이즈를 줄여서라도 한 줄로 만듦\r\n");
      out.write("           wrap : 여러줄로 감싸겠다 자식요소의 크기를 줄이지 않고\r\n");
      out.write("           main axis를 기준으로 요소들을 정렬하고자 할땐 justify-content속성을 사용\r\n");
      out.write("           cross axis를 기준으로 요소들을 정렬하고자 할땐 align-content속성이나 align-item을 사용\r\n");
      out.write("\r\n");
      out.write("           요약\r\n");
      out.write("           1.나 플렉스박스 사용할거임\r\n");
      out.write("           2.정렬 방향 결정\r\n");
      out.write("           3.단 한줄로 모든 요소들을 배치할것인지 여러줄로 감싸 요소들을 배치할것인지 결정\r\n");
      out.write("           4.플렉스박스 타임\r\n");
      out.write("        */\r\n");
      out.write("      .subMenu {\r\n");
      out.write("        display: none;\r\n");
      out.write("        flex-direction: row;\r\n");
      out.write("        flex-wrap: nowrap;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        background-color: #212121;\r\n");
      out.write("        opacity: 0.9;\r\n");
      out.write("        color: white;\r\n");
      out.write("        z-index: 1;\r\n");
      out.write("      }\r\n");
      out.write("      .Title {\r\n");
      out.write("        width: 100px;\r\n");
      out.write("        height: 110px;\r\n");
      out.write("        /* margin-right: 15px; */\r\n");
      out.write("        font-family: \"Montserrat\", sans-serif;\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("        line-height: 1.5;\r\n");
      out.write("      }\r\n");
      out.write("      .SuvMenu {\r\n");
      out.write("        list-style: none;\r\n");
      out.write("        text-align: left;\r\n");
      out.write("        padding-left: 0px;\r\n");
      out.write("      }\r\n");
      out.write("      .sec {\r\n");
      out.write("        margin: 0px 50px;\r\n");
      out.write("        text-align: left;\r\n");
      out.write("      }\r\n");
      out.write("      .sec li {\r\n");
      out.write("        padding-left: 20px;\r\n");
      out.write("        padding-right: 10px;\r\n");
      out.write("      }\r\n");
      out.write("      .frt li {\r\n");
      out.write("        padding-left: 20px;\r\n");
      out.write("      }\r\n");
      out.write("      .gnb {\r\n");
      out.write("        height: auto;\r\n");
      out.write("      }\r\n");
      out.write("      .loginContainer {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 600px;\r\n");
      out.write("      }\r\n");
      out.write("      .loginContainer h1 {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("      }\r\n");
      out.write("      .loginBox {\r\n");
      out.write("        width: 500px;\r\n");
      out.write("        height: auto;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("        padding-top: 130px;\r\n");
      out.write("      }\r\n");
      out.write("      .logTxt {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        flex-direction: column;\r\n");
      out.write("        flex-wrap: nowrap;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("      }\r\n");
      out.write("      .lineBar {\r\n");
      out.write("        border: 1px solid rgb(226, 226, 226);\r\n");
      out.write("        width: 400px;\r\n");
      out.write("        height: 1px;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("        margin-bottom: 10px;\r\n");
      out.write("      }\r\n");
      out.write("      .logTxt input {\r\n");
      out.write("        width: 400px;\r\n");
      out.write("        height: 50px;\r\n");
      out.write("        margin-top: 5px;\r\n");
      out.write("      }\r\n");
      out.write("      #logBtn {\r\n");
      out.write("        width: 400px;\r\n");
      out.write("        height: 50px;\r\n");
      out.write("        margin-top: 10px;\r\n");
      out.write("        background-color: #212121d9;\r\n");
      out.write("        border: none;\r\n");
      out.write("        font-size: 18px;\r\n");
      out.write("        color: white;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("      }\r\n");
      out.write("      .saveLogin {\r\n");
      out.write("        width: 400px;\r\n");
      out.write("        margin-top: 6px;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        flex-direction: row;\r\n");
      out.write("        flex-wrap: nowrap;\r\n");
      out.write("        justify-content: left;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("        font-size: 13px;\r\n");
      out.write("      }\r\n");
      out.write("      footer {\r\n");
      out.write("        height: 300px;\r\n");
      out.write("        background-color: #212121d9;\r\n");
      out.write("        margin-top: 50px;\r\n");
      out.write("      }\r\n");
      out.write("      .menuTitle {\r\n");
      out.write("        margin: 0px 30px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        font-family: \"Montserrat\", sans-serif;\r\n");
      out.write("      }\r\n");
      out.write("      .footer {\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      height: 300px;\r\n");
      out.write("      border:1px solid black;\r\n");
      out.write("      background-color: #1D3932;\r\n");
      out.write("      color: #ffffff;\r\n");
      out.write("      text-align: center;\r\n");
      out.write("      padding-top: 60px;\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("    <link\r\n");
      out.write("      href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@600;700&display=swap\"\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("    />\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\r\n");
      out.write("    />\r\n");
      out.write("    <script src=\"js/jquery-3.5.1.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("      //마우스커서가 해당 요소위에 올라가면 동작이 되는 코드\r\n");
      out.write("      //제이쿼리 문법을 쓰기위해 현재 이벤트를 먹인 문서를 브라우저가 다운로드 받아 준비된 상태로 만든다\r\n");
      out.write("      //처음에 메뉴가 숨겨진상태여야함\r\n");
      out.write("      //마우스 포인터가 해당 요소에 오버가 되면 동작이됨\r\n");
      out.write("      //포인터가 열린 서브메뉴판에서 벗어나면 다시 메뉴가 들어감\r\n");
      out.write("      //문제점: 메뉴에 오버했을때 나오는거는 ok 그런데 그 요소에 대해서만 이벤트가 적용이된상태임\r\n");
      out.write("      $(document).ready(function () {\r\n");
      out.write("        $(\".menuTitle\").mouseover(function () {\r\n");
      out.write("          $(\".subMenu\").css(\"display\", \"flex\").stop().slideDown();\r\n");
      out.write("        });\r\n");
      out.write("        $(\".subMenu\").mouseleave(function () {\r\n");
      out.write("          $(this).css(\"display\", \"none\").stop().slideUp();\r\n");
      out.write("        });\r\n");
      out.write("      });\r\n");
      out.write("    </script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <header class=\"header\">\r\n");
      out.write("        <div class=\"topMenu\">\r\n");
      out.write("          <div class=\"box left\">\r\n");
      out.write("            <a href=\"login_view.login\"><span>LOGIN</span></a>\r\n");
      out.write("            <div class=\"line\"><div class=\"lineItem\"></div></div>\r\n");
      out.write("            <a href=\"join_view.join\"><span>JOIN</span></a>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"box right\">\r\n");
      out.write("            <a href=\"#\"\r\n");
      out.write("              ><span><i class=\"fas fa-shopping-cart\"></i></span\r\n");
      out.write("            ></a>\r\n");
      out.write("            <div class=\"line\"><div class=\"lineItem\"></div></div>\r\n");
      out.write("            <a href=\"#\"\r\n");
      out.write("              ><span><i class=\"fas fa-search\"></i></span\r\n");
      out.write("            ></a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"logoBox\">\r\n");
      out.write("          <a href=\"index_view.main\">\r\n");
      out.write("            <img\r\n");
      out.write("              src=\"./images/포에트리 가든.png\"\r\n");
      out.write("              alt=\"메인로고\"\r\n");
      out.write("              width=\"406px\"\r\n");
      out.write("              height=\"73px\"\r\n");
      out.write("              id=\"logoImg\"\r\n");
      out.write("            />\r\n");
      out.write("          </a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </header>\r\n");
      out.write("      <nav class=\"gnb\">\r\n");
      out.write("        <div class=\"list cata\">\r\n");
      out.write("        <div class=\"menuTitle\" onclick=\"location.href='pdt_list.pdt';\">SHOP</div>\r\n");
      out.write("          <div class=\"menuTitle\">POST</div>\r\n");
      out.write("          <div class=\"menuTitle\" id=\"effCancle\">CENTER</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"slideShow\">\r\n");
      out.write("          <div class=\"subMenu\">\r\n");
      out.write("            <div class=\"frt Title\">\r\n");
      out.write("              <ul class=\"frt SuvMenu\">\r\n");
      out.write("                <li>PLANTS</li>\r\n");
      out.write("                <li>PLANT+POT</li>\r\n");
      out.write("                <li>POTS</li>\r\n");
      out.write("                <li>OTHER</li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"sec Title\">\r\n");
      out.write("              <ul class=\"secc SuvMenu\">\r\n");
      out.write("                <li>POST</li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"thd Title\">\r\n");
      out.write("              <ul class=\"trd SuvMenu\">\r\n");
      out.write("                <li>NOTICE</li>\r\n");
      out.write("                <li>REVIEW</li>\r\n");
      out.write("                <li>Q&N</li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </nav>\r\n");
      out.write("      <div class=\"loginContainer\">\r\n");
      out.write("        <div class=\"loginBox\">\r\n");
      out.write("          <h1>Login</h1>\r\n");
      out.write("          <div class=\"lineBar\"></div>\r\n");
      out.write("          <form action=\"login_proc.login\" method=\"POST\" name=\"logForm\">\r\n");
      out.write("            <div class=\"logTxt\">\r\n");
      out.write("              <input\r\n");
      out.write("                type=\"text\"\r\n");
      out.write("                autocomplete=\"off\"\r\n");
      out.write("                placeholder=\"아이디\"\r\n");
      out.write("                name=\"getId\"\r\n");
      out.write("              /><input type=\"password\" autocomplete=\"off\" placeholder=\"비밀번호\" name=\"getPwd\"/>\r\n");
      out.write("              <div class=\"saveLogin\">\r\n");
      out.write("                로그인상태유지<input\r\n");
      out.write("                  type=\"checkbox\"\r\n");
      out.write("                  style=\"width: 15px; height: 15px\"\r\n");
      out.write("                />\r\n");
      out.write("              </div>\r\n");
      out.write("              <button type=\"submit\" id=\"logBtn\">로그인</button>\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("       <footer>\r\n");
      out.write("     \t<div class=\"footer\">\r\n");
      out.write("     \t\t<p>\r\n");
      out.write("     \t\t<strong>Poetry garden(포에트리 가든)</strong>\r\n");
      out.write("     \t\t<br>\r\n");
      out.write("     \t\tCompany: 포에트리가든 | 대표자: 홍길동\r\n");
      out.write("     \t\t<br>\r\n");
      out.write("     \t\tAddr: 서울시 마포구  26길 18-4(픽업 예약방문)\r\n");
      out.write("     \t\t</p>\r\n");
      out.write("     \t\t<p>\r\n");
      out.write("     \t\tE-mail: gksdidwnd91@naver.com\r\n");
      out.write("     \t\t<br>\r\n");
      out.write("     \t\tCS: 010-3322-5232 (AM.10 ~ PM.6 주말 및 공휴일 휴무)\r\n");
      out.write("     \t\t</p>\r\n");
      out.write("     \t\t이용약관ㆍ개인정보처리방침\r\n");
      out.write("     \t</div>\r\n");
      out.write("     </footer>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
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
