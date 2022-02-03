package admin.dao;

import static db.JdbcUtil.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import vo.*;

public class AminMemberDao {
	private static AminMemberDao adminMemberDao;
	// �ν��Ͻ��� �ϳ��� ����� ���� static���� ����
	private Connection conn;

	private AminMemberDao() {}
	// �⺻�����ڷ� �ܺο��� �Ժη� �������� ���ϰ� private���� ����
	
	public static AminMemberDao getInstance() {
	// FreeDao�� �ν��Ͻ��� �������� �����ϴ� �޼ҵ�� �ν��Ͻ� ���� �ܺο��� 
	// ������ �� �ֵ��� static���� �����
		if (adminMemberDao == null) {	// ���� ������ �ν��Ͻ��� ������
			adminMemberDao = new AminMemberDao();	// ���Ӱ� �ν��Ͻ��� ����
		}
		return adminMemberDao;
	}
	
	public void setConnection(Connection conn) {
	// �� Ŭ������ DB�۾��� ���� Connection��ü�� �޾ƿ��� �޼ҵ�
		this.conn = conn;
	}

	public int getMemberArticleCount(String where) {
	// �˻��� �Խñ��� �� ������ �����ϴ� �޼ҵ�
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;
		
		try {
			sql = "select count(*) from t_member_list " + 
				" where ml_status = 'a' " + where;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())	result = rs.getInt(1);
			// �˻��� �Խù��� ������ result�� ����
		} catch(Exception e) {
			System.out.println("getMemberArticleCount() ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}
		
		return result;
	}

	public ArrayList<MemberInfo> getMemberArticleList(String where, int cpage, int limit) {
	// �˻��� �Խñ� ����� ArrayList���·� �����ϴ� �޼ҵ�
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<MemberInfo> adminMemberList = new ArrayList<MemberInfo>();
		// �˻� ����� ������ ArrayList��ü
		MemberInfo memberInfo = null;
		// articleList�� ���� ���ڵ带 ������ �ν��Ͻ�
		int snum = (cpage - 1) * limit;
		// ������ limit ��ɿ��� �����͸� ������ ���� �ε��� ��ȣ

		try {
			sql ="select * from t_member_list where ml_status = 'a' " + 
			where + " order by ml_id desc limit " + snum + ", " + limit;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
			// rs�� ����� ��� �� ���·� �����ϱ� ���� if�� ������� �ʰ� �ٷ� while���
				memberInfo = new MemberInfo();
				// �ϳ��� ���ڵ�(�Խñ�)�� ������ �ν��Ͻ� ����

				memberInfo.setMlid(rs.getString("ml_id"));
				memberInfo.setMlpwd(rs.getString("ml_pwd"));
				memberInfo.setMlname(rs.getString("ml_name"));
				memberInfo.setMlgender(rs.getString("ml_gender"));
				memberInfo.setMlbirth(rs.getString("ml_birth"));
				memberInfo.setMlphone(rs.getString("ml_phone"));
				memberInfo.setMlemail(rs.getString("ml_email"));
				memberInfo.setMlpoint(rs.getInt("ml_point"));
				memberInfo.setMldate(rs.getString("ml_date"));
				memberInfo.setMllast(rs.getString("ml_last"));
				memberInfo.setMlstatus(rs.getString("ml_status"));
				// �޾ƿ� ���ڵ��� freeInto �ν��Ͻ��� ������� ������ ����

				adminMemberList.add(memberInfo);
				// ������ FreeInfo�� �ν��Ͻ��� articleList �ϳ��� ����
			}
		} catch(Exception e) {
			System.out.println("getMemberArticleList() ����");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return adminMemberList;
	}
	
	public MemberInfo getArticle(String uid) {
		// ������ �Խù��� �����͸� FreeInfo�� �ν��Ͻ��� �����ϴ� �޼ҵ�
			MemberInfo adminMemberArticle = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = null;
			
			try {
				sql = "select * from t_member_list where ml_status = 'a' and ml_id = '" + uid + "' ";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
				// rs�� �����Ͱ� ������(�ش� ȸ���� ������)
					adminMemberArticle = new MemberInfo();
					// ������ �ν��Ͻ�(�����͸� ������ �ν��Ͻ�) ����
					adminMemberArticle.setMlid(rs.getString("ml_id"));
					adminMemberArticle.setMlpwd(rs.getString("ml_pwd"));
					adminMemberArticle.setMlname(rs.getString("ml_name"));
					adminMemberArticle.setMlgender(rs.getString("ml_gender"));
					adminMemberArticle.setMlbirth(rs.getString("ml_birth"));
					adminMemberArticle.setMlphone(rs.getString("ml_phone"));
					adminMemberArticle.setMlemail(rs.getString("ml_email"));
					adminMemberArticle.setMlpoint(rs.getInt("ml_point"));
					adminMemberArticle.setMldate(rs.getString("ml_date"));
					adminMemberArticle.setMllast(rs.getString("ml_last"));
					adminMemberArticle.setMlstatus(rs.getString("ml_status"));
					// �޾ƿ� ���ڵ��� adminMemberArticle�ν��Ͻ��� ���� ����
				}
			} catch(Exception e) {
				System.out.println("getArticle() ����");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);
			}

			return adminMemberArticle;
		}
	public MemberInfo getArticleUp(String uid) {
		// ������ �ۿ� ���� ������ ���� ��� �ش� �����͸� ������ ������ �޼ҵ�
			MemberInfo article = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = null;

			try {
				sql = "select * from t_member_list where ml_status = 'a' and ml_id = '" + uid + "' ";
				System.out.println(sql);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					article = new MemberInfo();
					// �˻��� �Խù��� ������ ������ FreeInfo�� �ν��Ͻ� article ����
					article.setMlid(rs.getString("ml_id"));
					article.setMlpwd(rs.getString("ml_pwd"));
					article.setMlname(rs.getString("ml_name"));
					article.setMlgender(rs.getString("ml_gender"));
					article.setMlbirth(rs.getString("ml_birth"));
					article.setMlphone(rs.getString("ml_phone"));
					article.setMlemail(rs.getString("ml_email"));
					article.setMlpoint(rs.getInt("ml_point"));
					article.setMldate(rs.getString("ml_date"));
					article.setMllast(rs.getString("ml_last"));
					article.setMlstatus(rs.getString("ml_status"));
					// �޾ƿ� ���ڵ��� article �ν��Ͻ��� ��� ������ ���� ����
				}
			} catch(Exception e) {
				System.out.println("getArticleUp() ����");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);
			}
			
			return article;
		}
	
	public int memberUpdate(MemberInfo memberInfo) {
		// �Խñ� ������ ���� �޼ҵ�
			PreparedStatement pstmt = null;
			String sql = null;
			int result = 0;		// ���� ���� ��� ������ ������ ����

			try {
				sql = "update t_member_list set ml_id = ?, ml_pwd = ?, ml_name = ?, ml_gender = ?, ml_birth = ?, ml_phone = ?, " +
				" ml_email = ?, ml_point = ?, ml_date = ?, ml_last = ?, ml_status = ? where ml_id = '" + memberInfo.getMlid() + "' ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberInfo.getMlid());
				pstmt.setString(2, memberInfo.getMlpwd());
				pstmt.setString(3, memberInfo.getMlname());
				pstmt.setString(4, memberInfo.getMlgender());
				pstmt.setString(5, memberInfo.getMlbirth());
				pstmt.setString(6, memberInfo.getMlphone());
				pstmt.setString(7, memberInfo.getMlemail());
				pstmt.setInt(8, memberInfo.getMlpoint());
				pstmt.setString(9, memberInfo.getMldate());
				pstmt.setString(10, memberInfo.getMllast());
				pstmt.setString(11, memberInfo.getMlstatus());
				result = pstmt.executeUpdate();	// ȸ�� ����
			} catch(Exception e) {
				System.out.println("memberUpdate() ����");
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}

		public int memberDelete(MemberInfo memberInfo) {
		// �Խñ� ������ ���� �޼ҵ�
			Statement stmt = null;
			String sql = null;
			int result = 0;		// ���� ���� ��� ������ ������ ����

			try {
				String where = " where ml_id = '" + memberInfo.getMlid() + "' ";
				sql = "update t_member_list set ml_status = 'b' " + where;
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
			} catch(Exception e) {
				System.out.println("memberDelete() ����");
				e.printStackTrace();
			} finally {
				close(stmt);
			}
			return result;
		}
}
