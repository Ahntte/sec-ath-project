package admin.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.action.*;
import vo.*;

@WebServlet("*.amm")
public class AdminMemberManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminMemberManagement() {
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
    			case "/admin_member_list.amm" :					// �����ڸ��(ȸ������) ȸ�� ���
    				action = new AdminMemberListAction();		break;
    			case "/admin_member_view.amm" :					// �����ڸ��(ȸ������) ȸ�� �� ����
    				action = new AdminMemberViewAction();		break;
    			case "/admin_member_form.amm" :					// �����ڸ��(ȸ������) ȸ�� ���� ������
    				action = new AdminMemberFormAction();		break;
    			case "/admin_member_proc.amm" :					// �����ڸ��(ȸ������) ȸ�� ���� ������
    				action = new AdminMemberProcAction();		break;
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
