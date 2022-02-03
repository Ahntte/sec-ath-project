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
		// 지정한 아이디에 해당하는 상품의 정보들을 PdtInfo형 인스턴스로 받아 옴
		request.setAttribute("pdtInfo", pdtInfo);

		ActionForward forward = new ActionForward();
		forward.setPath("/admin/product/admin_pdt_view.jsp");

		return forward;
	}
}
