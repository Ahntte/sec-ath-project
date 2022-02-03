package svc;

import static db.JdbcUtil.*;
import java.sql.*;
import dao.*;
import vo.*;

public class JoinProcSvc {
	public boolean memberInsert(MemberInfo memberInfo) {
		boolean isSuccess = false;
		Connection conn = getConnection();
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.setConnection(conn);

		int result = memberDao.memberInsert(memberInfo);
		if(result > 0) {
			commit(conn); 
			isSuccess = true;
		} else {
			rollback(conn);
		}
		close(conn);
		return isSuccess;
	}
}
