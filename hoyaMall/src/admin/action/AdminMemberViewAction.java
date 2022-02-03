package admin.action;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminMemberViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("id");	
		// 회원 아이디 : 어떤 회원의 정보인지를 구분하기 위해서 구분자로 반드시 필요함
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		// 현재 페이지번호 : 페이지번호는 필수이므로 받으면서 바로 정수형으로 변환시킴

		String schtype = request.getParameter("schtype");	// 검색조건
		String keyword = request.getParameter("keyword");	// 검색어
		
		AdminMemberViewSvc adminMemberViewSvc = new AdminMemberViewSvc();
		MemberInfo adminMemberArticle = adminMemberViewSvc.getArticle(uid);
		// 지정한 게시글을 FreeInfo형 인스턴스로 받아옴
		
		ActionForward forward = new ActionForward();
		request.setAttribute("adminMemberArticle", adminMemberArticle);
		// 이동할 페이지에 request에 게시물 데이터를 담아 넘겨줌(dispatch방식이므로 request를 넘길수 있음)
		forward.setPath("admin/member/admin_member_view.jsp");
		// 이동할 페이지 지정
		return forward;
	}
}
