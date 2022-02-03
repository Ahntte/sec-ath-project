package admin.action;

import javax.servlet.http.*;
import java.io.PrintWriter;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminProductUpFormAction implements admin.action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminPdtInFormSvc adminPdtInFormSvc = new AdminPdtInFormSvc();
		// 대분류, 소분류 목록을 가져오기 위한 Svc클래스
		ArrayList<CataBigInfo> cataBigList = adminPdtInFormSvc.getCataBigList();			// 대분류 목록
		ArrayList<CataSmallInfo> cataSmallList = adminPdtInFormSvc.getCataSmallList();	// 소분류 목록
		// 수정폼에서 상품의 정보들중 분류와 관련된 것들도 가져와야하기에 콤보박스로 분류를 선택할수있게끔 대분류와 소분류를 가지고온다
		AdminProductViewSvc adminProductViewSvc = new AdminProductViewSvc();
		String id = request.getParameter("id");
		PdtInfo pdtInfo = adminProductViewSvc.getPdtInfo(id);
		// 상품정보를 상품보기의 PdtViewSvc를 이용하여 받아 옴

		request.setAttribute("cataBigList", cataBigList);
		request.setAttribute("cataSmallList", cataSmallList);
		request.setAttribute("pdtInfo", pdtInfo);
		// 수정 폼에서 보여줄 분류들과 브랜드 목록, 상품정보를 request객체에 속성으로 담음

		ActionForward forward = new ActionForward();
		forward.setPath("/admin/product/admin_pdt_up_form.jsp");	// 이동할 URL 지정
		return forward;
	}
}
