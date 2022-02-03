package action;

import java.io.PrintWriter;	// 등록 실패시 자바스크립트 사용을 위한 import
import javax.servlet.http.*;
import svc.*;
import vo.*;


public class LoginProcAction implements Action {
	// 회원 로그인 처리 클래스
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		// 입력 받아오는 아이디와 비밀번호 각각의 데이터를 저장함
		String uid = request.getParameter("getId").trim();
		String upwd = request.getParameter("getPwd").trim();
		
		LoginSvc loginSvc = new LoginSvc();
		MemberInfo loginMember = loginSvc.getLoginMember(uid, upwd);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (loginMember != null) {	// 로그인 성공시
			session.setAttribute("loginMember", loginMember);
		}else{
			out.println("<script>");
			out.println("alert('로그인에 실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		ActionForward forward = new ActionForward();
		forward.setPath("index_view.main");
		return forward;
	}
}
