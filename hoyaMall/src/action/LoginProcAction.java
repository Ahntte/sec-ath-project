package action;

import java.io.PrintWriter;	// ��� ���н� �ڹٽ�ũ��Ʈ ����� ���� import
import javax.servlet.http.*;
import svc.*;
import vo.*;


public class LoginProcAction implements Action {
	// ȸ�� �α��� ó�� Ŭ����
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		// �Է� �޾ƿ��� ���̵�� ��й�ȣ ������ �����͸� ������
		String uid = request.getParameter("getId").trim();
		String upwd = request.getParameter("getPwd").trim();
		
		LoginSvc loginSvc = new LoginSvc();
		MemberInfo loginMember = loginSvc.getLoginMember(uid, upwd);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (loginMember != null) {	// �α��� ������
			session.setAttribute("loginMember", loginMember);
		}else{
			out.println("<script>");
			out.println("alert('�α��ο� �����߽��ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		ActionForward forward = new ActionForward();
		forward.setPath("index_view.main");
		return forward;
	}
}
