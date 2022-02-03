package admin.action;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminMemberViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("id");	
		// ȸ�� ���̵� : � ȸ���� ���������� �����ϱ� ���ؼ� �����ڷ� �ݵ�� �ʿ���
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		// ���� ��������ȣ : ��������ȣ�� �ʼ��̹Ƿ� �����鼭 �ٷ� ���������� ��ȯ��Ŵ

		String schtype = request.getParameter("schtype");	// �˻�����
		String keyword = request.getParameter("keyword");	// �˻���
		
		AdminMemberViewSvc adminMemberViewSvc = new AdminMemberViewSvc();
		MemberInfo adminMemberArticle = adminMemberViewSvc.getArticle(uid);
		// ������ �Խñ��� FreeInfo�� �ν��Ͻ��� �޾ƿ�
		
		ActionForward forward = new ActionForward();
		request.setAttribute("adminMemberArticle", adminMemberArticle);
		// �̵��� �������� request�� �Խù� �����͸� ��� �Ѱ���(dispatch����̹Ƿ� request�� �ѱ�� ����)
		forward.setPath("admin/member/admin_member_view.jsp");
		// �̵��� ������ ����
		return forward;
	}
}
