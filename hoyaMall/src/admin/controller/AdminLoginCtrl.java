package admin.controller;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import admin.action.*;
import vo.*;

@WebServlet("*.adminlog")
public class AdminLoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginCtrl() {
        super();
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 사용자의 요청이 get이든 post이든 모두 처리하는 메소드
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
    			case "/admin_login_view.adminlog" :			// 관리자 로그인 화면
    				action = new AdminLoginViewAction();		break;
    			case "/admin_login_proc.adminlog" :			// 관리자 로그인 처리 
    				action = new AdminLoginProcAction();		break;
    			case "/admin_logout.adminlog" :				// 관리자 로그아웃 
    				action = new AdminLogoutAction();			break;
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
