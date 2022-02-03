package admin.dao;

import static db.JdbcUtil.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import vo.*;

public class AminMemberDao {
	private static AminMemberDao adminMemberDao;
	// 인스턴스를 하나만 만들기 위해 static으로 선언
	private Connection conn;

	private AminMemberDao() {}
	// 기본생성자로 외부에서 함부로 생성하지 못하게 private으로 선언
	
	public static AminMemberDao getInstance() {
	// FreeDao의 인스턴스를 생성시켜 리턴하는 메소드로 인스턴스 없이 외부에서 
	// 접근할 수 있도록 static으로 선언됨
		if (adminMemberDao == null) {	// 현재 생성된 인스턴스가 없으면
			adminMemberDao = new AminMemberDao();	// 새롭게 인스턴스를 생성
		}
		return adminMemberDao;
	}
	
	public void setConnection(Connection conn) {
	// 현 클래스의 DB작업을 위해 Connection객체를 받아오는 메소드
		this.conn = conn;
	}

	public int getMemberArticleCount(String where) {
	// 검색된 게시글의 총 개수를 리턴하는 메소드
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
			// 검색된 게시물의 개수를 result에 담음
		} catch(Exception e) {
			System.out.println("getMemberArticleCount() 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}
		
		return result;
	}

	public ArrayList<MemberInfo> getMemberArticleList(String where, int cpage, int limit) {
	// 검색된 게시글 목록을 ArrayList형태로 리턴하는 메소드
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<MemberInfo> adminMemberList = new ArrayList<MemberInfo>();
		// 검색 결과를 저장할 ArrayList객체
		MemberInfo memberInfo = null;
		// articleList에 담을 레코드를 저장할 인스턴스
		int snum = (cpage - 1) * limit;
		// 쿼리의 limit 명령에서 데이터를 가져올 시작 인덱스 번호

		try {
			sql ="select * from t_member_list where ml_status = 'a' " + 
			where + " order by ml_id desc limit " + snum + ", " + limit;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
			// rs가 비었을 경우 빈 상태로 리턴하기 위해 if를 사용하지 않고 바로 while사용
				memberInfo = new MemberInfo();
				// 하나의 레코드(게시글)를 저장할 인스턴스 생성

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
				// 받아온 레코드들로 freeInto 인스턴스에 멤버변수 값으로 넣음

				adminMemberList.add(memberInfo);
				// 생성된 FreeInfo형 인스턴스를 articleList 하나씩 저장
			}
		} catch(Exception e) {
			System.out.println("getMemberArticleList() 오류");
			e.printStackTrace();
		} finally {
			close(rs);	close(stmt);
		}

		return adminMemberList;
	}
	
	public MemberInfo getArticle(String uid) {
		// 지정된 게시물의 데이터를 FreeInfo형 인스턴스로 리턴하는 메소드
			MemberInfo adminMemberArticle = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = null;
			
			try {
				sql = "select * from t_member_list where ml_status = 'a' and ml_id = '" + uid + "' ";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
				// rs에 데이터가 있으면(해당 회원이 있으면)
					adminMemberArticle = new MemberInfo();
					// 리턴할 인스턴스(데이터를 저장할 인스턴스) 생성
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
					// 받아온 레코드들로 adminMemberArticle인스턴스에 값을 넣음
				}
			} catch(Exception e) {
				System.out.println("getArticle() 오류");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);
			}

			return adminMemberArticle;
		}
	public MemberInfo getArticleUp(String uid) {
		// 수정할 글에 대한 권한이 있을 경우 해당 데이터를 가져와 리턴할 메소드
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
					// 검색된 게시물의 정보를 저장할 FreeInfo형 인스턴스 article 생성
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
					// 받아온 레코드들로 article 인스턴스의 멤버 변수에 값을 넣음
				}
			} catch(Exception e) {
				System.out.println("getArticleUp() 오류");
				e.printStackTrace();
			} finally {
				close(rs);	close(stmt);
			}
			
			return article;
		}
	
	public int memberUpdate(MemberInfo memberInfo) {
		// 게시글 수정을 위한 메소드
			PreparedStatement pstmt = null;
			String sql = null;
			int result = 0;		// 쿼리 실행 결과 개수를 저장할 변수

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
				result = pstmt.executeUpdate();	// 회원 수정
			} catch(Exception e) {
				System.out.println("memberUpdate() 오류");
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}

		public int memberDelete(MemberInfo memberInfo) {
		// 게시글 삭제를 위한 메소드
			Statement stmt = null;
			String sql = null;
			int result = 0;		// 쿼리 실행 결과 개수를 저장할 변수

			try {
				String where = " where ml_id = '" + memberInfo.getMlid() + "' ";
				sql = "update t_member_list set ml_status = 'b' " + where;
				stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
			} catch(Exception e) {
				System.out.println("memberDelete() 오류");
				e.printStackTrace();
			} finally {
				close(stmt);
			}
			return result;
		}
}
