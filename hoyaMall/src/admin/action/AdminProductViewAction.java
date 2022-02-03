package admin.action;

import javax.servlet.http.*;
import java.io.PrintWriter;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminProductViewAction implements admin.action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminProductViewSvc adminproductViewSvc = new AdminProductViewSvc();
		String id = request.getParameter("id");
		PdtInfo pdtInfo = adminproductViewSvc.getPdtInfo(id);
		// ������ ���̵� �ش��ϴ� ��ǰ�� �������� PdtInfo�� �ν��Ͻ��� �޾� ��
		request.setAttribute("pdtInfo", pdtInfo);

		ActionForward forward = new ActionForward();
		forward.setPath("/admin/product/admin_pdt_view.jsp");

		return forward;
	}
}
