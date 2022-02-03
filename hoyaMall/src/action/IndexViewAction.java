package action;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import svc.*;
import vo.*;

public class IndexViewAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ArrayList<PdtInfo> pdtMainBpList = new ArrayList<PdtInfo>();
		// ��ǰ�������� �������� ����Ʈ���� �ν��Ͻ���� ������ ��� �迭�� �����Ͽ� �����ð��� 
		request.setCharacterEncoding("utf-8");
		PdtListSvc pdtListSvc = new PdtListSvc();
		pdtMainBpList = pdtListSvc.getMainBpdtList();
		
		request.setAttribute("pdtMainBpList", pdtMainBpList);
		forward.setPath("/index.jsp");	// �̵��� URL����
		return forward;
	}
}
