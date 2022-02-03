package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import vo.*;

public class LoginDao {
	private static LoginDao loginDao;
	private Connection conn;
	private LoginDao() {}
	
	public static LoginDao getInstance() {
		if (loginDao == null) {
			loginDao = new LoginDao();
		}
		return loginDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public MemberInfo getLoginMember(String uid, String upwd) {
		MemberInfo loginMember = null;	
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select m.* " + 
					" from t_member_list m " + 
					" where m.ml_status != 'c' " + 
					" and m.ml_id = '" + uid + "' and m.ml_pwd = '" + upwd + "'";
			
			rs = stmt.executeQuery(sql);
			if (rs.next()) {	
				// 로그인 성공시
				loginMember = new MemberInfo();
				loginMember.setMlid(uid);
				loginMember.setMlpwd(upwd);
				loginMember.setMlname(rs.getString("ml_name"));
				loginMember.setMlphone(rs.getString("ml_phone"));
				loginMember.setMlemail(rs.getString("ml_email"));
				loginMember.setMldate(rs.getString("ml_date"));
				loginMember.setMllast(rs.getString("ml_last"));
				loginMember.setMlstatus(rs.getString("ml_status"));
				loginMember.setMlpoint(rs.getInt("ml_point"));
				loginMember.setMazip(rs.getString("ma_zip"));
				loginMember.setMaaddr1(rs.getString("ma_addr1"));
				loginMember.setMaaddr2(rs.getString("ma_addr2"));
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
		return loginMember;
	}
}
