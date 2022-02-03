package admin.action;

import java.io.PrintWriter;	// ��� ���н� �ڹٽ�ũ��Ʈ ����� ���� import
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import admin.svc.*;
import vo.*;

public class AdminMemberProcAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		request.setCharacterEncoding("utf-8");
		String wtype = request.getParameter("wtype");
		
		MemberInfo memberInfo = new MemberInfo();
		System.out.println("�ɹ�����Ʈ:"+memberInfo.getMlpoint());
		
		int pageCnt = Integer.parseInt(request.getParameter("pageCnt"));
		// ������ ȸ�������͵��� ������ �ν��Ͻ� ����
		if (wtype.equals("up")) {
		// ȸ�������� ��� ȸ�������͵��� �޾ƿ�
			memberInfo.setMlid(request.getParameter("id").trim());
			memberInfo.setMlpwd(request.getParameter("pwd").trim());
			memberInfo.setMlname(request.getParameter("name").trim());
			memberInfo.setMlgender(request.getParameter("gender").trim());
			memberInfo.setMlbirth(request.getParameter("birth").trim());
			memberInfo.setMlphone(request.getParameter("phone").trim());
			memberInfo.setMlemail(request.getParameter("email").trim());
			memberInfo.setMlpoint(Integer.parseInt(request.getParameter("point")));
			memberInfo.setMldate(request.getParameter("date"));
			memberInfo.setMllast(request.getParameter("last"));
			memberInfo.setMlstatus(request.getParameter("status"));
			// �޾� �� �����͵��� �ϳ��� �Խù��� �����ϴ� freeInfo �ν��Ͻ��� setter�� �̿��Ͽ� ����
		}
		if (wtype.equals("del")) {
		// ȸ�������� ��� ȸ�����̵� �޾ƿ�
			String uid = request.getParameter("id");
			memberInfo.setMlid(uid);
		}

		AdminMemberProcSvc adminMemberProcSvc = new AdminMemberProcSvc();
		// ����Ͻ� ������ ó���� ���� Ŭ������ �ν��Ͻ� ����
		boolean isSuccess = false;	// ����(����, ����) �������θ� ������ ����
		String link = null;			// �۾�(����, ����) �� �̵��� URL�� ������ ����
		HttpSession session = request.getSession();

		  if (wtype.equals("up")) {
			isSuccess = adminMemberProcSvc.memberUpdate(memberInfo);
			//System.out.println(request.getParameter("cpage"));
			int cpage = Integer.parseInt(request.getParameter("cpage"));
			String args = "?cpage=" + cpage;
			String schtype = request.getParameter("schtype");
			String keyword = request.getParameter("keyword");
			if (keyword != null && !keyword.equals("")) {
				args += "&schtype=" + schtype + "&keyword=" + URLEncoder.encode(keyword, "UTF-8");
			}
			link = "admin_member_view.amm" + args + "&id=" + memberInfo.getMlid() + "&pageCnt=" + pageCnt;
		} else {
			isSuccess = adminMemberProcSvc.memberDelete(memberInfo);
			if (!isSuccess) {	// ���� ���н�
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('���� ����');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			link = "admin_member_list.amm" + "?pageCnt=" + pageCnt;
		}
		if (isSuccess) {	// ������
			forward = new ActionForward();
			forward.setRedirect(true);	// �̵������ redirect�� �ϰڴٴ� �ǹ�
			forward.setPath(link);
		}
		return forward;
	}
}
