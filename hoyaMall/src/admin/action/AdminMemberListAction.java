package admin.action;

import javax.servlet.http.*;
import java.util.*;
import admin.svc.*;
import vo.*;

public class AdminMemberListAction implements Action {
	// 회원목록을 받아와 연결하는 클래스
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MemberInfo> adminMemberList = new ArrayList<MemberInfo>();
		// ArrayList는 기본이 object클래스타입으로 데이터가 저장됨 따라서 특정 클래스의 데이터들을 리스트형식으로 저장하기 위해서는 반드시 저장할 인스턴의 클래스타입으로 형변환하여 사용해야함
		// 회원목록을 저장할 ArrayList객체로 MemberInfo형 인스턴스만 저장함

		request.setCharacterEncoding("utf-8");
		int cpage = 1, limit = 10;
		// 현재 페이지번호와 한페이지에서 보여줄 회원을 저장하는 변수
		if (request.getParameter("cpage") != null)
			cpage = Integer.parseInt(request.getParameter("cpage"));
		// cpage값을 받아 왔으면 정수형으로 형변환하여 사용
		String schtype = request.getParameter("schtype");
		// 검색조건으로 작성자(아이디), 제목, 내용, 제목+내용 // 제목-> 이름 , 내용-> 이메일
		String keyword = request.getParameter("keyword");	// 검색어

		String where = "";	// 쿼리 작업시 사용할 조건을 저장할 변수
		if (keyword != null && !keyword.equals("")) {
		// 검색어가 있으면 검색조건을 만듦
			if (schtype.equals("ie")) {	// 검색 조건이 '아이디+이메일' 이면
				where = " and (ml_id like '%" + keyword + "%' " + 
					" or ml_email like '%" + keyword + "%') ";
			} else {	// 검색조건이 아이디 또는 이름 또는 이메일 이면
				where = " and ml_" + schtype + " like '%" + keyword + "%' ";
			}
		}

		AdminMemberListSvc adminMemberListSvc = new AdminMemberListSvc();
		// 게시판 목록을 위한 비즈니스 로직을 처리하기 위해 FreeListSvc 인스턴스 생성

		int rcnt = adminMemberListSvc.getMemberArticleCount(where);
		// 총 레코드 개수를 받아옴(전체 페이지수를 계산하기 위해)

		adminMemberList = adminMemberListSvc.getMemberArticleList(where, cpage, limit);
		// 목록화면에서 보여줄 게시글 목록을 ArrayList형으로 받아옴

		int pcnt = rcnt / limit;
		if (rcnt % limit > 0)	pcnt++;
		// 전체 페이지수 구함
		int spage = (cpage - 1) / limit * limit + 1;
		// 블록 시작페이지 번호
		int epage = spage + limit - 1;
		if (epage > pcnt)	epage = pcnt;
		// 블록 종료페이지 번호

		PageInfo pageInfo = new PageInfo();
		pageInfo.setCpage(cpage);		// 현재 페이지 번호
		pageInfo.setRcnt(rcnt);			// 전체 게시글 수
		pageInfo.setPcnt(pcnt);			// 전체 페이지 수
		pageInfo.setSpage(spage);		// 블록 시작 페이지 번호
		pageInfo.setEpage(epage);		// 블록 종료 페이지 번호
		pageInfo.setSchtype(schtype);	// 검색조건
		pageInfo.setKeyword(keyword);	// 검색어
		// 페이징 관련 정보들과 검색조건을 PageInfo 인스턴스에 저장
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("adminMemberList", adminMemberList);
		// free_list.jsp로 request를 통해 전달해줄 객체를 request에 저장

		ActionForward forward = new ActionForward();
		forward.setPath("admin/member/admin_member_list.jsp");
		// 이동할 페이지의 URL을 forward인스턴스에 저장
		return forward;
	}
}
