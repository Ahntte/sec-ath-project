package action;

import javax.servlet.http.*;
import java.io.PrintWriter;
import svc.*;
import vo.*;

public class LogOutProcAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		
		ActionForward forward = new ActionForward();
		forward.setPath("index_view.main");
		forward.setRedirect(true);
		return forward;
	}
}
