package controller;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import action.*;
import vo.*;


@WebServlet("*.join")
public class MemberJoinCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberJoinCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 사용자의 요청이 get이든 post이든 모두 처리하는 메소드
    		request.setCharacterEncoding("utf-8");
    		String requestUri = request.getRequestURI();
    		String contextPath = request.getContextPath();
    		String command = requestUri.substring(contextPath.length());

    		ActionForward forward = null;
    		Action action = null;
    		
    		switch (command) {
    			case "/join_view.join" :			// 회원가입 동의 화면
    				action = new JoinViewAction();		break;
    			case "/join_form.join" :			// 회원가입 폼 화면
    				action = new JoinFormAction();		break;
    			case "/join_proc.join" :			// 회원가입 처리
    				action = new JoinProcAction();		break;
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
