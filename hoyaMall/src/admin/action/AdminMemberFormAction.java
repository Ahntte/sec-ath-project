package admin.action;

import javax.servlet.http.*;	// 받아 온 request와 response를 위해 import
import java.io.PrintWriter;
import admin.svc.*;
import vo.*;

public class AdminMemberFormAction implements Action{
	// 회원 수정 폼으로의 이동을 위한 클래스
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String wtype = request.getParameter("wtype");
		// 수정(up) 삭제(del) 여부
		ActionForward forward = new ActionForward();
		// 작업후 이동할 때 이동하는 방식(redirect or dispatch)을 정해서 저장하는 인스턴스

		if (wtype.equals("up")) {
		// 글 수정이면(등록의 경우 따로 진행할 작업이 없음)
			HttpSession session = request.getSession();
			// JSP가 아니므로 HttpSession 인스턴스를 직접 만들어야 함
			AdminInfo adminLoginMember = (AdminInfo)session.getAttribute("adminLoginMember");
			// 수정할 회원정보를 저장할 변수
			String memberId = request.getParameter("id");
			String uid = "";
			if (memberId != null) uid = memberId;
			// 회원 아이디가 있으면 uid변수에 회원아이디 재할당
			AdminMemberFormSvc adminMemberFormSvc = new AdminMemberFormSvc();
			MemberInfo article = adminMemberFormSvc.getArticleUp(uid);
			if (article != null) {
			// 받아온 회원정보가 있으면
				request.setAttribute("article", article);
				// 수정할 게시글의 데이터를 request객체에 담음
				// dispatcher로 이동하므로 request를 다음 페이지로 제어권을 넘기므로 request에 게시물을 담아 감
			} else {
			// 받아온 게시물이 없으면
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보가 없습니다.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				// 현재 상태에서 응답(response)을 멈춘다는 의미로 아래에 있는 다른 코드를 실행하지 않겠다는 의미
				// 단, 아래쪽 코드에 오류가 있으면 close()가 동작하지 않고 오류가 발생할 수도 있음
			}
		}
		forward.setPath("admin/member/admin_member_form.jsp");	// 이동할 URL 지정
		return forward;
	}
}
