package dao;

import static db.JdbcUtil.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import vo.*;

public class MemberDao {
	private static MemberDao memberDao;
	// 인스턴스를 하나만 만들기위해 static으로 선언됨 하나 만들어 놓고 공유함?
	private Connection conn;
	private MemberDao() {}
	// 기본 생성자로 외부에서 함부로 생성하지 못하게 private로 선언함
	public static MemberDao getInstance() {
		if (memberDao == null) { // 현재 생성된 인스턴스가 없으면
			memberDao = new MemberDao(); // 새롭게 인스턴스를 생성
		}
		return memberDao;
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	public int memberInsert(MemberInfo memberInfo) {
		PreparedStatement pstmt = null;
		String sql = null;
		int result = 0;
		try {
			//회원 등록에 대한 쿼리
			sql = "insert into t_member_list (ml_id, ml_pwd, " +
					"ml_name, ml_phone, ml_email, ml_point, ml_status, ml_gender, ml_birth) " + 
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberInfo.getMlid());
				pstmt.setString(2, memberInfo.getMlpwd());
				pstmt.setString(3, memberInfo.getMlname());
				pstmt.setString(4, memberInfo.getMlphone());
				pstmt.setString(5, memberInfo.getMlemail());
				pstmt.setInt(6, memberInfo.getMlpoint());
				pstmt.setString(7, memberInfo.getMlstatus());
				pstmt.setString(8, memberInfo.getMlgender());
				pstmt.setString(9, memberInfo.getMlbirth());
				result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("memberInsert() Error");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
