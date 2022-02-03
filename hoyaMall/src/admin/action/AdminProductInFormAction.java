package admin.action;

import javax.servlet.http.*;	// �޾� �� request�� response�� ���� import
import java.io.PrintWriter;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminProductInFormAction implements admin.action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		AdminPdtInFormSvc adminPdtInFormSvc = new AdminPdtInFormSvc();
		// ��з�, �Һз� ����� �������� ���� svcŬ����
		ArrayList<CataBigInfo> cataBigList = adminPdtInFormSvc.getCataBigList();			// ��з� ���
		// ���׸��� ����Ͽ� Ư�� Ŭ����Ÿ���� �ν��Ͻ�(������)���� ����Ʈ���·� �����ϱ� ���� cataBigList�̸��� ���� �迭������ ������
		// ���׸��� ������� ������ ArrayList �迭�� ���� ��� �����ʹ� �⺻������ Object������ �����
		// �� ArrayList�� �ִ� �����ʹ� �ƹ��ų� �� �־ �� �ִ°� ����
		// �ٵ� �Ŀ� �� �迭 �ȿ� ����ִ� �����͸� ����Ҷ� ������ �߻��� �߸����� �������̱⿡ �ʿ� Ȥ�� ��Ȳ������ ����ȯ�� �ؼ� ����ؾ���
		ArrayList<CataSmallInfo> cataSmallList = adminPdtInFormSvc.getCataSmallList();		// �Һз� ���

		if (cataBigList != null && cataSmallList != null) {
			request.setAttribute("cataBigList", cataBigList);
			request.setAttribute("cataSmallList", cataSmallList);
			// ��� ������ ������ �з���� �귣�� ����� request��ü�� �Ӽ����� ����
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�߸��� ��η� �����̽��ϴ�.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		forward.setPath("/admin/product/admin_pdt_in_form.jsp");	// �̵��� URL ����
		return forward;
	}
}
