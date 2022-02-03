package dao;

import static db.JdbcUtil.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import vo.*;

public class MemberDao {
	private static MemberDao memberDao;
	// �ν��Ͻ��� �ϳ��� ��������� static���� ����� �ϳ� ����� ���� ������?
	private Connection conn;
	private MemberDao() {}
	// �⺻ �����ڷ� �ܺο��� �Ժη� �������� ���ϰ� private�� ������
	public static MemberDao getInstance() {
		if (memberDao == null) { // ���� ������ �ν��Ͻ��� ������
			memberDao = new MemberDao(); // ���Ӱ� �ν��Ͻ��� ����
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
			//ȸ�� ��Ͽ� ���� ����
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
