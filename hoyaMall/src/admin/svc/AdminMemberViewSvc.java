package admin.svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminMemberViewSvc {
	// ȸ�� ������ ����Ͻ� ������ ó���ϴ� Ŭ����
		public MemberInfo getArticle(String uid) {
		// �μ��� �޾ƿ� uid�� �ش��ϴ� ȸ�� �ϳ������� ������ MemberInfo�� �ν��Ͻ��� �����ϴ� �޼ҵ�
			MemberInfo adminMemberViewArticle = null;	// ������ ȸ�� ������ ���� �ν��Ͻ� ����
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);
			
			adminMemberViewArticle = adminMemberDao.getArticle(uid);	// ������ �Խñ� �ޱ�

			close(conn);
			return adminMemberViewArticle;
		}
}
