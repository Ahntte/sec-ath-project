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
		// 상품정보들을 가져오되 리스트형태 인스턴스라는 가방을 담는 배열로 선언하여 가져올것임 
		request.setCharacterEncoding("utf-8");
		PdtListSvc pdtListSvc = new PdtListSvc();
		pdtMainBpList = pdtListSvc.getMainBpdtList();
		
		request.setAttribute("pdtMainBpList", pdtMainBpList);
		forward.setPath("/index.jsp");	// 이동할 URL지정
		return forward;
	}
}
