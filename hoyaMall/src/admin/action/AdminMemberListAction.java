package admin.action;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminMemberListAction implements Action {
	// ȸ������� �޾ƿ� �����ϴ� Ŭ����
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MemberInfo> adminMemberList = new ArrayList<MemberInfo>();
		// ArrayList�� �⺻�� objectŬ����Ÿ������ �����Ͱ� ����� ���� Ư�� Ŭ������ �����͵��� ����Ʈ�������� �����ϱ� ���ؼ��� �ݵ�� ������ �ν����� Ŭ����Ÿ������ ����ȯ�Ͽ� ����ؾ���
		// ȸ������� ������ ArrayList��ü�� MemberInfo�� �ν��Ͻ��� ������

		request.setCharacterEncoding("utf-8");
		int cpage = 1, limit = 10;
		// ���� ��������ȣ�� ������������ ������ ȸ���� �����ϴ� ����
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		// cpage���� �޾� ������ ���������� ����ȯ�Ͽ� ���
		String schtype = request.getParameter("schtype");
		// �˻��������� �ۼ���(���̵�), ����, ����, ����+���� // ����-> �̸� , ����-> �̸���
		String keyword = request.getParameter("keyword");	// �˻���

		String where = "";	// ���� �۾��� ����� ������ ������ ����
		if (keyword != null && !keyword.equals("")) {
		// �˻�� ������ �˻������� ����
			if (schtype.equals("ie")) {	// �˻� ������ '���̵�+�̸���' �̸�
				where = " and (ml_id like '%" + keyword + "%' " + 
					" or ml_email like '%" + keyword + "%') ";
			} else {	// �˻������� ���̵� �Ǵ� �̸� �Ǵ� �̸��� �̸�
				where = " and ml_" + schtype + " like '%" + keyword + "%' ";
			}
		}

		AdminMemberListSvc adminMemberListSvc = new AdminMemberListSvc();
		// �Խ��� ����� ���� ����Ͻ� ������ ó���ϱ� ���� FreeListSvc �ν��Ͻ� ����

		int rcnt = adminMemberListSvc.getMemberArticleCount(where);
		// �� ���ڵ� ������ �޾ƿ�(��ü ���������� ����ϱ� ����)

		adminMemberList = adminMemberListSvc.getMemberArticleList(where, cpage, limit);
		// ���ȭ�鿡�� ������ �Խñ� ����� ArrayList������ �޾ƿ�

		int pcnt = rcnt / limit;
		if (rcnt % limit > 0)	pcnt++;
		// ��ü �������� ����
		int spage = (cpage - 1) / limit * limit + 1;
		// ��� ���������� ��ȣ
		int epage = spage + limit - 1;
		if (epage > pcnt)	epage = pcnt;
		// ��� ���������� ��ȣ

		PageInfo pageInfo = new PageInfo();
		pageInfo.setCpage(cpage);		// ���� ������ ��ȣ
		pageInfo.setRcnt(rcnt);			// ��ü �Խñ� ��
		pageInfo.setPcnt(pcnt);			// ��ü ������ ��
		pageInfo.setSpage(spage);		// ��� ���� ������ ��ȣ
		pageInfo.setEpage(epage);		// ��� ���� ������ ��ȣ
		pageInfo.setSchtype(schtype);	// �˻�����
		pageInfo.setKeyword(keyword);	// �˻���
		// ����¡ ���� ������� �˻������� PageInfo �ν��Ͻ��� ����
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("adminMemberList", adminMemberList);
		// free_list.jsp�� request�� ���� �������� ��ü�� request�� ����

		ActionForward forward = new ActionForward();
		forward.setPath("admin/member/admin_member_list.jsp");
		// �̵��� �������� URL�� forward�ν��Ͻ��� ����
		return forward;
	}
}
