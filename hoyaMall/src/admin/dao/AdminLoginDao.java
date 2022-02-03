package admin.dao;

import static db.JdbcUtil.*;
import java.sql.*;
import vo.*;

public class AdminLoginDao {
	private static AdminLoginDao adminLoginDao;
	private Connection conn;
	private AdminLoginDao() {}
	
	public static AdminLoginDao getInstance() {
		if (adminLoginDao == null) {
			adminLoginDao = new AdminLoginDao();
		}
		return adminLoginDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public AdminInfo getAdminLoginMember(String uid, String upwd) {
		AdminInfo adminLoginMember = null;	// AdminInfo형 인스턴스를 관리자정보로써 들고다닐거임 여러정보를 들고다니기엔 객체가 편함
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select a.* " + 
					" from t_admin_list a " + 
					" where a.al_status != 'c' " + 
					" and a.al_id = '" + uid + "' and a.al_pwd = '" + upwd + "'";
			
			rs = stmt.executeQuery(sql);
			if (rs.next()) {	
				// 로그인 성공시
				adminLoginMember = new AdminInfo();
				adminLoginMember.setAl_idx(rs.getInt("al_idx"));
				adminLoginMember.setAl_id(uid);
				adminLoginMember.setAl_pwd(upwd);
				adminLoginMember.setAl_name(rs.getString("al_name"));
				adminLoginMember.setAl_phone(rs.getString("al_phone"));
				adminLoginMember.setAl_email(rs.getString("al_email"));
				adminLoginMember.setAl_date(rs.getString("al_date"));
				adminLoginMember.setAl_status(rs.getString("al_status"));	
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);	close(stmt);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return adminLoginMember;
	}
}
