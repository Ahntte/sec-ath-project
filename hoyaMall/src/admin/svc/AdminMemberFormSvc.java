package admin.svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminMemberFormSvc {
	public MemberInfo getArticleUp(String uid) {
		// ������ �ۿ� ���� ������ ���� ��� �ش� �����͸� ������ ������ �޼ҵ�
			MemberInfo article = null;
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);

			article = adminMemberDao.getArticleUp(uid);
			// ������ ȸ�� ���� ��� �ش� �����͸� ������

			close(conn);
			return article;
		}
}
