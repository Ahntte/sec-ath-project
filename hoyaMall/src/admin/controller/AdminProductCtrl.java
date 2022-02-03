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
    			case "/admin_product_list.apdt" :						// 관리자모드(상품관리) 상품 리스트 화면
    				action = new AdminProductListAction();			break;
    			case "/admin_product_in_form.apdt" :					// 관리자모드(상품등록) 상품 등록 폼 화면
    				action = new AdminProductInFormAction();		break;
    			case "/admin_product_in_proc.apdt" :					// 관리자모드(상품등록) 상품 등록 처리
    				action = new AdminProductInProcAction();		break;
    			case "/admin_product_view.apdt" :						// 관리자모드(상품 보기) 상품 상세 보기 화면
    				action = new AdminProductViewAction();			break;
    			case "/admin_product_up_form.apdt" :					// 관리자모드(상품 수정) 상품 정보 수정 화면
    				action = new AdminProductUpFormAction();		break;
    			case "/admin_product_up_proc.apdt" :					// 관리자모드(상품 수정) 상품 정보 수정 처리
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
