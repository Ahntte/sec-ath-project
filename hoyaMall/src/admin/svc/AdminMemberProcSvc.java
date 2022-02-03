package admin.svc;

import static db.JdbcUtil.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminMemberProcSvc {
	// �Խñۿ� ���� ���� �۾��� ó���ϴ� Ŭ����
		public boolean memberUpdate(MemberInfo memberInfo) throws Exception {
		// �Խñ� ������ ���� �޼ҵ�
			boolean isSuccess = false;
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);

			int result = adminMemberDao.memberUpdate(memberInfo);
			if (result > 0) {
				commit(conn);
				isSuccess = true;
			} else {
				rollback(conn);
			}
			close(conn);
			return isSuccess;
		}
		public boolean memberDelete(MemberInfo memberInfo) throws Exception {
		// ȸ�������� ���� �޼ҵ�
			boolean isSuccess = false;
			Connection conn = getConnection();
			AminMemberDao adminMemberDao = AminMemberDao.getInstance();
			adminMemberDao.setConnection(conn);

			int result = adminMemberDao.memberDelete(memberInfo);
			if (result > 0) {
				commit(conn);
				isSuccess = true;
			} else {
				rollback(conn);
			}
			close(conn);
			return isSuccess;
		}
}
