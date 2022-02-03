package action;

import java.io.PrintWriter;	// 등록 실패시 자바스크립트 사용을 위한 import
import javax.servlet.http.*;
import svc.*;
import vo.*;

public class JoinProcAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 회원가입 처리를 위한 클래스
		MemberInfo memberInfo = new MemberInfo();
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		// 회원가입폼에서 받아오는 데이터를 request객체를 이용하여 가지고오고 해당 vo클래스에 데이터를 저장함
		String phone1 = request.getParameter("phbox").trim();
		String phone2 = request.getParameter("secnumber").trim();
		String phone3 = request.getParameter("trdnumber").trim();
		String phone = phone1+"-"+phone2+"-"+phone3;
		
		String userYear = request.getParameter("yearbox").trim();
		String userMonth = request.getParameter("mthbox").trim();
		String userDate = request.getParameter("daybox").trim();
		
		// 년,월,일 데이터를 받은후에 처리할 로직
		// 한자릿수 월일땐 앞에 0을 붙여주고 그렇지 않을땐 그대로 출력 한자리 일일땐 0을 붙여주고 그렇지않을땐 그대로 출력
		if(userMonth.length() == 1) {
			char zero = '0';
			userMonth = zero+userMonth;
		}
		if(userDate.length() == 1) {
			char zero = '0';
			userDate = zero+userDate;
		}
		String birth = userYear + "-" + userMonth + "-" + userDate;
		// 현재 출력값: 20200105
		// 고쳐야할 출력값의 형태 : 2020-01-05
		
		System.out.println(birth);

	
		
		// 생년월일은 한꺼번에 1991.06.03
		// 한자릿수일땐 앞에 0을 지우고 두자릿수를일땐 0을 붙이고 (자바스크립트 이용해서 처리)
		memberInfo.setMlid(request.getParameter("id"));
		memberInfo.setMlpwd(request.getParameter("pwd"));
		memberInfo.setMlname(request.getParameter("name"));
		memberInfo.setMlgender(request.getParameter("radio"));
		memberInfo.setMlbirth(birth);
		memberInfo.setMlphone(phone);
		memberInfo.setMlemail(request.getParameter("email"));
		memberInfo.setMlpoint(1000);
		memberInfo.setMlstatus("a");
		
		System.out.println(memberInfo.getMlbirth());
		JoinProcSvc joinProcSvc = new JoinProcSvc();
		
		// 주소등록은 회원가입에서 하지않고 마이페이지 주소지 등록에서 하는걸로.. 물론 저장은 회원정보클래스에 저장해야겠지
		boolean isSuccess = false;
		isSuccess = joinProcSvc.memberInsert(memberInfo);
		forward.setPath("./index.jsp");
		forward.setRedirect(true);
		return forward;
	}
}
