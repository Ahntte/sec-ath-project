package admin.action;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import admin.svc.*;
import vo.*;

public class AdminLoginViewAction implements admin.action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("action");
		ActionForward forward = new ActionForward();
		forward.setPath("admin/login/adminLogin.jsp");	// 이동할 URL지정
		return forward;
	}
}
