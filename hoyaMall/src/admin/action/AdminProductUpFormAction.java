package admin.action;

import javax.servlet.http.*;
import java.io.PrintWriter;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminProductUpFormAction implements admin.action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminPdtInFormSvc adminPdtInFormSvc = new AdminPdtInFormSvc();
		// ��з�, �Һз� ����� �������� ���� SvcŬ����
		ArrayList<CataBigInfo> cataBigList = adminPdtInFormSvc.getCataBigList();			// ��з� ���
		ArrayList<CataSmallInfo> cataSmallList = adminPdtInFormSvc.getCataSmallList();	// �Һз� ���
		// ���������� ��ǰ�� �������� �з��� ���õ� �͵鵵 �����;��ϱ⿡ �޺��ڽ��� �з��� �����Ҽ��ְԲ� ��з��� �Һз��� ������´�
		AdminProductViewSvc adminProductViewSvc = new AdminProductViewSvc();
		String id = request.getParameter("id");
		PdtInfo pdtInfo = adminProductViewSvc.getPdtInfo(id);
		// ��ǰ������ ��ǰ������ PdtViewSvc�� �̿��Ͽ� �޾� ��

		request.setAttribute("cataBigList", cataBigList);
		request.setAttribute("cataSmallList", cataSmallList);
		request.setAttribute("pdtInfo", pdtInfo);
		// ���� ������ ������ �з���� �귣�� ���, ��ǰ������ request��ü�� �Ӽ����� ����

		ActionForward forward = new ActionForward();
		forward.setPath("/admin/product/admin_pdt_up_form.jsp");	// �̵��� URL ����
		return forward;
	}
}
