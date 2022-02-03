package admin.action;

import java.io.PrintWriter;	// 등록 실패시 자바스크립트 사용을 위한 import
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
		System.out.println("맴버포인트:"+memberInfo.getMlpoint());
		
		int pageCnt = Integer.parseInt(request.getParameter("pageCnt"));
		// 수정한 회원데이터들을 저장할 인스턴스 생성
		if (wtype.equals("up")) {
		// 회원수정일 경우 회원데이터들을 받아옴
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
			// 받아 온 데이터들을 하나의 게시물을 저장하는 freeInfo 인스턴스에 setter를 이용하여 담음
		}
		if (wtype.equals("del")) {
		// 회원삭제일 경우 회원아이디를 받아옴
			String uid = request.getParameter("id");
			memberInfo.setMlid(uid);
		}

		AdminMemberProcSvc adminMemberProcSvc = new AdminMemberProcSvc();
		// 비즈니스 로직을 처리할 서비스 클래스의 인스턴스 생성
		boolean isSuccess = false;	// 쿼리(수정, 삭제) 성공여부를 저장할 변수
		String link = null;			// 작업(수정, 삭제) 후 이동할 URL을 저장할 변수
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
			if (!isSuccess) {	// 삭제 실패시
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			link = "admin_member_list.amm" + "?pageCnt=" + pageCnt;
		}
		if (isSuccess) {	// 성공시
			forward = new ActionForward();
			forward.setRedirect(true);	// 이동방식을 redirect로 하겠다는 의미
			forward.setPath(link);
		}
		return forward;
	}
}
