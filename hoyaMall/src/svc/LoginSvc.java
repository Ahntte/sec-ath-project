package svc;

import static db.JdbcUtil.*;	
import java.sql.*;
import dao.*;
import vo.*;

public class LoginSvc {
	public MemberInfo getLoginMember(String uid, String upwd) {
		LoginDao loginDao = LoginDao.getInstance();
		Connection conn = getConnection();
		loginDao.setConnection(conn);
		MemberInfo loginMember = loginDao.getLoginMember(uid, upwd);
		close(conn);
		
		return loginMember;
	}
}
