package admin.svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminMemberListSvc {
	public int getMemberArticleCount(String where) {
		// 게시글의 전체 개수를 리턴하는 메소드
			int rcnt = 0;	// 전체 레코드 개수를 저장할 변수
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);
			rcnt = adminMemberDao.getMemberArticleCount(where);
			close(conn);

			return rcnt;
		}
		
		public ArrayList<MemberInfo> getMemberArticleList(String where, int cpage, int limit) {
		// 게시글 목록을 ArrayList로 리턴하며, 반드시 FreeInfo형 인스턴스만 저장되어야 함
		// 매개변수 : 조건, 현재 페이지 번호, 가져올 레코드 개수
			ArrayList<MemberInfo> adminMemberList = null;
			// 게시물 목록을 담을 ArrayList 선언
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);
			adminMemberList = adminMemberDao.getMemberArticleList(where, cpage, limit);
			close(conn);

			return adminMemberList;
		}
}
