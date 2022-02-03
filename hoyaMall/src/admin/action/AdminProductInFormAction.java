package admin.action;

import javax.servlet.http.*;	// 받아 온 request와 response를 위해 import
import java.io.PrintWriter;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminProductInFormAction implements admin.action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AdminPdtInFormSvc adminPdtInFormSvc = new AdminPdtInFormSvc();
		// 대분류, 소분류 목록을 가져오기 위한 svc클래스
		ArrayList<CataBigInfo> cataBigList = adminPdtInFormSvc.getCataBigList();			// 대분류 목록
		// 제네릭을 사용하여 특정 클래스타입의 인스턴스(데이터)만을 리스트형태로 저장하기 위해 cataBigList이름을 갖는 배열변수를 선언함
		// 제네릭을 사용하지 않으면 ArrayList 배열에 들어가는 모든 데이터는 기본적으로 Object형으로 저장됨
		// 요 ArrayList에 넣는 데이터는 아무거나 다 넣어도 됨 넣는건 쉬움
		// 근데 후에 이 배열 안에 들어있는 데이터를 사용할때 문제가 발생함 중립적인 데이터이기에 필요 혹은 상황에따라 형변환을 해서 사용해야함
		ArrayList<CataSmallInfo> cataSmallList = adminPdtInFormSvc.getCataSmallList();		// 소분류 목록

		if (cataBigList != null && cataSmallList != null) {
			request.setAttribute("cataBigList", cataBigList);
			request.setAttribute("cataSmallList", cataSmallList);
			// 등록 폼에서 보여줄 분류들과 브랜드 목록을 request객체에 속성으로 담음
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('잘못된 경로로 들어오셨습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		forward.setPath("/admin/product/admin_pdt_in_form.jsp");	// 이동할 URL 지정
		return forward;
	}
}
