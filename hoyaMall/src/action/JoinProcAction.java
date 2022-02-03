package action;

import java.io.PrintWriter;	// ��� ���н� �ڹٽ�ũ��Ʈ ����� ���� import
import javax.servlet.http.*;
import svc.*;
import vo.*;

public class JoinProcAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ȸ������ ó���� ���� Ŭ����
		MemberInfo memberInfo = new MemberInfo();
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		// ȸ������������ �޾ƿ��� �����͸� request��ü�� �̿��Ͽ� ��������� �ش� voŬ������ �����͸� ������
		String phone1 = request.getParameter("phbox").trim();
		String phone2 = request.getParameter("secnumber").trim();
		String phone3 = request.getParameter("trdnumber").trim();
		String phone = phone1+"-"+phone2+"-"+phone3;
		
		String userYear = request.getParameter("yearbox").trim();
		String userMonth = request.getParameter("mthbox").trim();
		String userDate = request.getParameter("daybox").trim();
		
		// ��,��,�� �����͸� �����Ŀ� ó���� ����
		// ���ڸ��� ���϶� �տ� 0�� �ٿ��ְ� �׷��� ������ �״�� ��� ���ڸ� ���϶� 0�� �ٿ��ְ� �׷��������� �״�� ���
		if(userMonth.length() == 1) {
			char zero = '0';
			userMonth = zero+userMonth;
		}
		if(userDate.length() == 1) {
			char zero = '0';
			userDate = zero+userDate;
		}
		String birth = userYear + "-" + userMonth + "-" + userDate;
		// ���� ��°�: 20200105
		// ���ľ��� ��°��� ���� : 2020-01-05
		
		System.out.println(birth);

	
		
		// ��������� �Ѳ����� 1991.06.03
		// ���ڸ����϶� �տ� 0�� ����� ���ڸ������϶� 0�� ���̰� (�ڹٽ�ũ��Ʈ �̿��ؼ� ó��)
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
		
		// �ּҵ���� ȸ�����Կ��� �����ʰ� ���������� �ּ��� ��Ͽ��� �ϴ°ɷ�.. ���� ������ ȸ������Ŭ������ �����ؾ߰���
		boolean isSuccess = false;
		isSuccess = joinProcSvc.memberInsert(memberInfo);
		forward.setPath("./index.jsp");
		forward.setRedirect(true);
		return forward;
	}
}
