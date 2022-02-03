package admin.action;

import java.io.PrintWriter;	// ��� ���н� �ڹٽ�ũ��Ʈ ����� ���� import
import javax.servlet.http.*;
import admin.svc.*;
import svc.LoginSvc;
import vo.*;

public class AdminLoginProcAction implements admin.action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		// �Է� �޾ƿ��� ���̵�� ��й�ȣ ������ �����͸� ������
		String uid = request.getParameter("getId").trim();
		String upwd = request.getParameter("getPwd").trim();
		
		AdminLoginSvc adminLoginSvc = new AdminLoginSvc();
		AdminInfo adminloginMember = adminLoginSvc.getAdminLoginMember(uid, upwd);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (adminloginMember != null) {	// �α��� ������
			session.setAttribute("adminLoginMember", adminloginMember);
		}else{
			out.println("<script>");
			out.println("alert('�α��ο� �����߽��ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		ActionForward forward = new ActionForward();
		forward.setPath("admin/adminIndex.jsp");
		return forward;
	}
}
