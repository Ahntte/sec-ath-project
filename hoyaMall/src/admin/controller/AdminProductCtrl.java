package admin.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.action.*;
import vo.*;


@WebServlet("*.apdt")
public class AdminProductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminProductCtrl() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ������� ��û�� get�̵� post�̵� ��� ó���ϴ� �޼ҵ�
    		request.setCharacterEncoding("utf-8");
    		String requestUri = request.getRequestURI();
    		System.out.println(requestUri);
    		String contextPath = request.getContextPath();
    		System.out.println(contextPath);
    		String command = requestUri.substring(contextPath.length());
    		System.out.println(command);

    		ActionForward forward = null;
    		Action action = null;

    		switch (command) {
    			case "/admin_product_list.apdt" :						// �����ڸ��(��ǰ����) ��ǰ ����Ʈ ȭ��
    				action = new AdminProductListAction();			break;
    			case "/admin_product_in_form.apdt" :					// �����ڸ��(��ǰ���) ��ǰ ��� �� ȭ��
    				action = new AdminProductInFormAction();		break;
    			case "/admin_product_in_proc.apdt" :					// �����ڸ��(��ǰ���) ��ǰ ��� ó��
    				action = new AdminProductInProcAction();		break;
    			case "/admin_product_view.apdt" :						// �����ڸ��(��ǰ ����) ��ǰ �� ���� ȭ��
    				action = new AdminProductViewAction();			break;
    			case "/admin_product_up_form.apdt" :					// �����ڸ��(��ǰ ����) ��ǰ ���� ���� ȭ��
    				action = new AdminProductUpFormAction();		break;
    			case "/admin_product_up_proc.apdt" :					// �����ڸ��(��ǰ ����) ��ǰ ���� ���� ó��
    				action = new AdminProductUpProcAction();		break;
    		}
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		if (forward != null) {
    			if (forward.isRedirect()) {
    				response.sendRedirect(forward.getPath());	
    			} else {
    				RequestDispatcher dispatcher = 
    				request.getRequestDispatcher(forward.getPath());
    				dispatcher.forward(request, response);
    			}
    		}
    	}
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doProcess(request, response);
    	}
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doProcess(request, response);
    	}
}
