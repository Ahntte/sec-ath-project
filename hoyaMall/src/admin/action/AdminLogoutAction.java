package admin.action;

import javax.servlet.http.*;
import java.io.PrintWriter;
import admin.svc.*;
import vo.*;

public class AdminLogoutAction implements admin.action.Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setPath("admin_login_view.adminlog");
		forward.setRedirect(true);
		return forward;
	}
}
