package admin.action;

import javax.servlet.http.*;	// �޾� �� request�� response�� ���� import
import java.io.PrintWriter;
import admin.svc.*;
import vo.*;

public class AdminMemberFormAction implements Action{
	// ȸ�� ���� �������� �̵��� ���� Ŭ����
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String wtype = request.getParameter("wtype");
		// ����(up) ����(del) ����
		ActionForward forward = new ActionForward();
		// �۾��� �̵��� �� �̵��ϴ� ���(redirect or dispatch)�� ���ؼ� �����ϴ� �ν��Ͻ�

		if (wtype.equals("up")) {
		// �� �����̸�(����� ��� ���� ������ �۾��� ����)
			HttpSession session = request.getSession();
			// JSP�� �ƴϹǷ� HttpSession �ν��Ͻ��� ���� ������ ��
			AdminInfo adminLoginMember = (AdminInfo)session.getAttribute("adminLoginMember");
			// ������ ȸ�������� ������ ����
			String memberId = request.getParameter("id");
			String uid = "";
			if (memberId != null) uid = memberId;
			// ȸ�� ���̵� ������ uid������ ȸ�����̵� ���Ҵ�
			AdminMemberFormSvc adminMemberFormSvc = new AdminMemberFormSvc();
			MemberInfo article = adminMemberFormSvc.getArticleUp(uid);
			if (article != null) {
			// �޾ƿ� ȸ�������� ������
				request.setAttribute("article", article);
				// ������ �Խñ��� �����͸� request��ü�� ����
				// dispatcher�� �̵��ϹǷ� request�� ���� �������� ������� �ѱ�Ƿ� request�� �Խù��� ��� ��
			} else {
			// �޾ƿ� �Խù��� ������
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('ȸ�������� �����ϴ�.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				// ���� ���¿��� ����(response)�� ����ٴ� �ǹ̷� �Ʒ��� �ִ� �ٸ� �ڵ带 �������� �ʰڴٴ� �ǹ�
				// ��, �Ʒ��� �ڵ忡 ������ ������ close()�� �������� �ʰ� ������ �߻��� ���� ����
			}
		}
		forward.setPath("admin/member/admin_member_form.jsp");	// �̵��� URL ����
		return forward;
	}
}
