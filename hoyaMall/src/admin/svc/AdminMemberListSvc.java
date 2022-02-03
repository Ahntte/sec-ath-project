package admin.svc;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminMemberListSvc {
	public int getMemberArticleCount(String where) {
		// �Խñ��� ��ü ������ �����ϴ� �޼ҵ�
			int rcnt = 0;	// ��ü ���ڵ� ������ ������ ����
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);
			rcnt = adminMemberDao.getMemberArticleCount(where);
			close(conn);

			return rcnt;
		}
		
		public ArrayList<MemberInfo> getMemberArticleList(String where, int cpage, int limit) {
		// �Խñ� ����� ArrayList�� �����ϸ�, �ݵ�� FreeInfo�� �ν��Ͻ��� ����Ǿ�� ��
		// �Ű����� : ����, ���� ������ ��ȣ, ������ ���ڵ� ����
			ArrayList<MemberInfo> adminMemberList = null;
			// �Խù� ����� ���� ArrayList ����
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);
			adminMemberList = adminMemberDao.getMemberArticleList(where, cpage, limit);
			close(conn);

			return adminMemberList;
		}
}
