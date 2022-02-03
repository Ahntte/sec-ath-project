package admin.svc;

import static db.JdbcUtil.*;	
import java.sql.*;
import admin.dao.*;
import vo.*;

public class AdminLoginSvc {
	public AdminInfo getAdminLoginMember(String uid, String upwd) {
		AdminLoginDao adminLoginDao = AdminLoginDao.getInstance();
		Connection conn = getConnection();
		adminLoginDao.setConnection(conn);
		AdminInfo adminLoginMember = adminLoginDao.getAdminLoginMember(uid, upwd);
		close(conn);
		
		return adminLoginMember;
	}
}
