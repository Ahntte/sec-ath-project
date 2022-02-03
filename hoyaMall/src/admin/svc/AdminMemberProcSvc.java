package admin.svc;

import static db.JdbcUtil.*;
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminMemberProcSvc {
	// 게시글에 대한 실제 작업을 처리하는 클래스
		public boolean memberUpdate(MemberInfo memberInfo) throws Exception {
		// 게시글 수정을 위한 메소드
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
		// 회원삭제를 위한 메소드
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
