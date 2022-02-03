package action;

import javax.servlet.http.*;
import java.util.*;
import svc.*;
import vo.*;

public class SearchListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<PdtInfo> pdtSearchList = new ArrayList<PdtInfo>();
		// ��� ���� �κп��� ȸ�� ���̵�� ��� ��������
		// ��ǰ ����� ������ ArrayList��ü�� PdtInfo�� �ν��Ͻ��� ������
		int cpage = 1, pcnt, spage, epage, rcnt, bsize = 10, psize = 12;
		// ����¡�� �ʿ��� ������ ������ ���� ���� �� �ʱ�ȭ
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		if (request.getParameter("psize") != null)
			psize = Integer.parseInt(request.getParameter("psize"));

		// �˻����� ������Ʈ���� ����
		String keyword;
		keyword = request.getParameter("keyword");	// �˻���
		String where = " and a.pl_view = 'y' ";
		if (keyword != null && !keyword.equals(""))	where += " and a.pl_name like '%" + keyword + "%' ";
		// �˻����ǿ� where�� ����

		SearchListSvc searchListSvc = new SearchListSvc();
		rcnt = searchListSvc.getPdtCount(where);	// �˻��� ��ǰ�� �� ����(������ ������ ���ϱ� ���� �ʿ�)
		pdtSearchList = searchListSvc.getPdtSearchList(where,cpage, psize);
		// �� ���������� ������ �˻��� ��ǰ���
		// �˻�����, ��������, limit���� ����� ���� ���ϱ� ���� ������������ ������ũ�⸦ �μ��� ������

		pcnt = rcnt / psize;
		if (rcnt % psize > 0)	pcnt++;				// ��ü �������� ����
		spage = (cpage - 1) / psize * psize + 1;	// ��� ���������� ��ȣ
		epage = spage + psize - 1;
		if (epage > pcnt)	epage = pcnt;			// ��� ���������� ��ȣ

		PdtPageInfo pageInfo = new PdtPageInfo();	// ����¡�� �ʿ��� ������ ���� �ν��Ͻ� ����
		pageInfo.setCpage(cpage);		// ���� ������ ��ȣ
		pageInfo.setPcnt(pcnt);			// ��ü ������ ����
		pageInfo.setSpage(spage);		// ��� ���������� ��ȣ
		pageInfo.setEpage(epage);		// ��� ���������� ��ȣ
		pageInfo.setRcnt(rcnt);			// ��ü ��ǰ(���ڵ�) ����
		pageInfo.setBsize(bsize);		// ��ϳ� ������ ����
		pageInfo.setPsize(psize);		// �������� ��ǰ ����
		pageInfo.setKeyword(keyword);	// �˻���
	
		request.setAttribute("pdtSearchList", pdtSearchList);
		request.setAttribute("pageInfo", pageInfo);
		// ��ǰ��� ȭ��(pdt_list.jsp)���� ���(pdtList)�� ����¡ ����(pageInfo), �з����� request�� ��� ������

		ActionForward forward = new ActionForward();
		forward.setPath("/product/search_list.jsp");
		return forward;
	}
}
