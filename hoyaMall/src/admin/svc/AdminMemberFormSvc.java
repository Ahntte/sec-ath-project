package admin.svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminMemberFormSvc {
	public MemberInfo getArticleUp(String uid) {
		// 수정할 글에 대한 권한이 있을 경우 해당 데이터를 가져와 리턴할 메소드
			MemberInfo article = null;
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);

			article = adminMemberDao.getArticleUp(uid);
			// 수정할 회원 있을 경우 해당 데이터를 가져옴

			close(conn);
			return article;
		}
}
