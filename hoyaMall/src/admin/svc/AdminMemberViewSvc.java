package admin.svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminMemberViewSvc {
	// 회원 보기의 비즈니스 로직을 처리하는 클래스
		public MemberInfo getArticle(String uid) {
		// 인수로 받아온 uid에 해당하는 회원 하나에대한 정보를 MemberInfo형 인스턴스로 리턴하는 메소드
			MemberInfo adminMemberViewArticle = null;	// 리턴할 회원 정보를 담을 인스턴스 선언
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);
			
			adminMemberViewArticle = adminMemberDao.getArticle(uid);	// 보여줄 게시글 받기

			close(conn);
			return adminMemberViewArticle;
		}
}
